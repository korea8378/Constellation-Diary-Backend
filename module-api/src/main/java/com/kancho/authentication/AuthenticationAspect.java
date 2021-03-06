package com.kancho.authentication;

import com.kancho.common.exception.FailAuthenticationException;
import com.kancho.common.user_context.ThreadContext;
import com.kancho.common.user_context.UserInfo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
@RequiredArgsConstructor
public class AuthenticationAspect {

    private final JWTManager jwtManager;

    @Pointcut("execution(public * com.kancho.user.controller.UserChangeController.*(..)) && " +
            "!execution(public * com.kancho.user.controller.UserChangeController.modifyPassword(..))")
    public void userChangeController() {
    }

    @Pointcut("execution(public * com.kancho.user.controller.UserController.refreshToken(..))")
    public void refreshToken() {
    }

    @Pointcut("execution(public * com.kancho.user.controller.UserController.getUser(..))")
    public void getUser() {
    }

    @Pointcut("execution(public * com.kancho.user.controller.UserController.signOut(..))")
    public void userSignOut() {
    }

    @Pointcut("execution(public * com.kancho.daily.controller.DailyQuestionController.*(..))")
    public void dailyQuestionController() {
    }

    @Pointcut("execution(public * com.kancho.daily.controller.DiaryController.*(..))")
    public void diaryController() {
    }

    @Before(value = "refreshToken()")
    public void checkRefreshToken() {
        String token = getToken();

        if (isEmptyToken(token)) {
            throw new FailAuthenticationException();
        }
        UserInfo userInfo = jwtManager.getUserInfo(token, TokenType.REFRESH_TOKEN::verifyValue);

        ThreadContext.userInfo.set(userInfo);
    }

    @Before(value = "dailyQuestionController() || diaryController() || userChangeController() || userSignOut() || getUser()")
    public void checkAuthenticationToken() {
        String token = getToken();

        if (isEmptyToken(token)) {
            throw new FailAuthenticationException();
        }
        UserInfo userInfo = jwtManager.getUserInfo(token, TokenType.AUTHENTICATION_TOKEN::verifyValue);

        ThreadContext.userInfo.set(userInfo);
    }

    @After(value = "dailyQuestionController() || diaryController() || userChangeController() || userSignOut() || getUser()")
    public void removeThreadLocal() {
        ThreadContext.userInfo.remove();
    }

    private String getToken() {
        return ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest().getHeader("Authorization");
    }

    private boolean isEmptyToken(String token) {
        return token == null;
    }
}

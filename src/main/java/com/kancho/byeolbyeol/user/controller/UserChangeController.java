package com.kancho.byeolbyeol.user.controller;

import com.kancho.byeolbyeol.common.constant.ReqTimeZone;
import com.kancho.byeolbyeol.common.user_context.ThreadContext;
import com.kancho.byeolbyeol.common.user_context.UserInfo;
import com.kancho.byeolbyeol.user.application.UserService;
import com.kancho.byeolbyeol.user.dto.requset.*;
import com.kancho.byeolbyeol.user.dto.response.ResUserDto;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api(description = "유저 - 정보 변경 관련 API")
public class UserChangeController {
    private final UserService userService;

    @ApiOperation(value = "유저 별자리 변경 - 요청시 Time-Zone 선택")
    @ApiResponses({
            @ApiResponse(code = 200, message = "유저 별자리 변경 성공"),
            @ApiResponse(code = 400, message = "4001 - Request Worn Field, " +
                    "4004 - Not Found Constellation, 4006 - Not Found User"),
            @ApiResponse(code = 401, message = "4101 - Fail Authentication check token"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Refresh JWT",
                    required = true, dataType = "string", paramType = "header",
                    defaultValue = "Bearer cbbb1a6e-8614-4a4d-a967-b0a42924e7ca")
    })
    @PatchMapping("/users/constellations")
    public ResponseEntity<ResUserDto> modifyConstellation(
            @RequestHeader(value = "Time-Zone") ReqTimeZone reqTimeZone,
            @RequestBody @Valid ReqModifyConstellationDto reqModifyConstellationDto) {

        UserInfo userInfo = ThreadContext.userInfo.get();

        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.modifyConstellations(userInfo, reqTimeZone, reqModifyConstellationDto));
    }

    @ApiOperation(value = "질문 푸시알람 설정 - 요청시 Time-Zone 선택")
    @ApiResponses({
            @ApiResponse(code = 200, message = "질문 푸시알람 설정 성공"),
            @ApiResponse(code = 400, message = "4001 - Request Worn Field, " +
                    "4004 - Not Found Constellation, 4006 - Not Found User"),
            @ApiResponse(code = 401, message = "4101 - Fail Authentication check token"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Refresh JWT",
                    required = true, dataType = "string", paramType = "header",
                    defaultValue = "Bearer cbbb1a6e-8614-4a4d-a967-b0a42924e7ca")
    })
    @PatchMapping("/users/question-alarm")
    public ResponseEntity<ResUserDto> modifyQuestionAlarm(
            @RequestHeader(value = "Time-Zone") ReqTimeZone reqTimeZone,
            @RequestBody @Valid ReqModifyQuestionAlarmDto reqModifyQuestionAlarmDto) {

        UserInfo userInfo = ThreadContext.userInfo.get();

        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.modifyQuestionAlarm(userInfo, reqTimeZone, reqModifyQuestionAlarmDto));
    }

    @ApiOperation(value = "운세 푸시알람 설정 - 요청시 Time-Zone 선택")
    @ApiResponses({
            @ApiResponse(code = 200, message = "운세 푸시알람 설정 성공"),
            @ApiResponse(code = 400, message = "4001 - Request Worn Field, " +
                    "4004 - Not Found Constellation, 4006 - Not Found User"),
            @ApiResponse(code = 401, message = "4101 - Fail Authentication check token"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Refresh JWT",
                    required = true, dataType = "string", paramType = "header",
                    defaultValue = "Bearer cbbb1a6e-8614-4a4d-a967-b0a42924e7ca")
    })
    @PatchMapping("/users/horoscope-alarm")
    public ResponseEntity<ResUserDto> modifyHoroscopeAlarm(
            @RequestHeader(value = "Time-Zone") ReqTimeZone reqTimeZone,
            @RequestBody @Valid ReqModifyHoroscopeAlarmDto reqModifyHoroscopeAlarmDto) {

        UserInfo userInfo = ThreadContext.userInfo.get();

        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.modifyHoroscopeAlarm(userInfo, reqTimeZone, reqModifyHoroscopeAlarmDto));
    }

    @ApiOperation(value = "질문 푸시알람 시간 설정 - 요청시 Time-Zone 선택")
    @ApiResponses({
            @ApiResponse(code = 200, message = "질문 푸시알람 시간 설정 성공"),
            @ApiResponse(code = 400, message = "4001 - Request Worn Field, " +
                    "4004 - Not Found Constellation, 4006 - Not Found User"),
            @ApiResponse(code = 401, message = "4101 - Fail Authentication check token"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Refresh JWT",
                    required = true, dataType = "string", paramType = "header",
                    defaultValue = "Bearer cbbb1a6e-8614-4a4d-a967-b0a42924e7ca")
    })
    @PatchMapping("/users/question-time")
    public ResponseEntity<ResUserDto> modifyQuestionTime(
            @RequestHeader(value = "Time-Zone") ReqTimeZone reqTimeZone,
            @RequestBody @Valid ReqModifyQuestionTimeDto reqModifyQuestionTimeDto) {

        UserInfo userInfo = ThreadContext.userInfo.get();

        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.modifyQuestionTime(userInfo, reqTimeZone, reqModifyQuestionTimeDto));
    }

    @ApiOperation(value = "운세 푸시알람 시간 설정 - 요청시 Time-Zone 선택")
    @ApiResponses({
            @ApiResponse(code = 200, message = "운세 푸시알람 시간 설정 성공"),
            @ApiResponse(code = 400, message = "4001 - Request Worn Field, " +
                    "4004 - Not Found Constellation, 4006 - Not Found User"),
            @ApiResponse(code = 401, message = "4101 - Fail Authentication check token"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Refresh JWT",
                    required = true, dataType = "string", paramType = "header",
                    defaultValue = "Bearer cbbb1a6e-8614-4a4d-a967-b0a42924e7ca")
    })
    @PatchMapping("/users/horoscope-time")
    public ResponseEntity<ResUserDto> modifyHoroscopeTime(
            @RequestHeader(value = "Time-Zone") ReqTimeZone reqTimeZone,
            @RequestBody @Valid ReqModifyHoroscopeTimeDto reqModifyHoroscopeTimeDto) {

        UserInfo userInfo = ThreadContext.userInfo.get();

        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.modifyHoroscopeTime(userInfo, reqTimeZone, reqModifyHoroscopeTimeDto));
    }

}

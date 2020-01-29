package com.kancho.byeolbyeol.user.domain.user;

import com.kancho.byeolbyeol.common.constant.Constellation;
import com.kancho.byeolbyeol.user.domain.user.User;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {

    @Test
    public void 유저_생성() {
        User user = User.builder()
                .userId("test")
                .password("test123")
                .constellation(Constellation.AQUARIUS)
                .build();

        assertThat(user.getUserId(), is("test"));
        assertThat(user.getConstellation(), is(Constellation.AQUARIUS));
    }

}
package com.kancho.byeolbyeol.user.domain.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userId;

    private String password;

    private String email;

    private Long constellationsId;

    private Boolean horoscopeAlarmFlag;

    private String questionTime;

    private Boolean questionAlarmFlag;

    @Builder
    private User(String userId, String password, Long constellationsId, String email) {
        this.userId = userId;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.constellationsId = constellationsId;
        this.email = email;
        this.horoscopeAlarmFlag = true;
        this.questionAlarmFlag = true;
        this.questionTime = "22:00";
    }
}

package com.cybertek.entity;

import com.cybertek.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Where(clause = "is_deleted=false")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private boolean enabled;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

//    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime,
//                Long lastUpdateUserId, String firstName, String lastName, String userName, String passWord,
//                boolean enabled, String phone, Role role, Gender gender) {
//        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.userName = userName;
//        this.passWord = passWord;
//        this.enabled = enabled;
//        this.phone = phone;
//        this.role = role;
//        this.gender = gender;
//    }
}

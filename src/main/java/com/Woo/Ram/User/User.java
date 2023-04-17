package com.Woo.Ram.User;

import com.Woo.Ram.entity.Date;
import lombok.*;



import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor //디폴트 생성자 추가
@ToString
@Entity
public class User extends Date {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(Long id, String name, String email, Role role,String picture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.picture = picture;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture  = picture;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}

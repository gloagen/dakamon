package io.gloagen.persistence.dakamon.entity.user;

import javax.persistence.*;

@Entity(name = "USER_MAIL")
public class EmailAdress {
    @Id
    private long id;

    @Column(length = 320, nullable = false, unique = true)
    private String mail;

    @ManyToOne
    @JoinColumn(name = "user_info_id")
    private UserInformation userInformation;
}

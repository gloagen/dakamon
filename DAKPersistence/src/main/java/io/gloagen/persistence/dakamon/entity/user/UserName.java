package io.gloagen.persistence.dakamon.entity.user;

import javax.persistence.*;

@Entity(name = "UNAME")
public class UserName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 45, unique = true)
    private String username;

    @OneToOne
    @JoinColumn(name = "acc_id", nullable = false)
    private UserAccount userAccount;
}

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
    @JoinColumn(name = "uacc", nullable = false)
    private UserAccount userAccount;

    public UserName() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}

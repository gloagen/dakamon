package io.gloagen.persistence.dakamon.entity.user;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "USER_MAIL")
public class EmailAddress {
    @Id
    @GeneratedValue(generator = "IDGeneTable")
    @TableGenerator(name = "IDGeneTable", table = "IDGene",
                    pkColumnName = "ID_NAME", valueColumnName = "ID_VAL",
                    pkColumnValue = "EMAIL_GEN")
    @Column(name = "email_id")
    private long id;

    @Column(length = 320, nullable = false, unique = true, name = "email_addesss")
    private String email;

    @ManyToOne
    @JoinColumn(name = "userinfo_id", nullable = false)
    private UserInformation userInformation;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column
    private boolean validated;

    public EmailAddress() {
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }
}

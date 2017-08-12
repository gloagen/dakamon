package io.gloagen.persistence.dakamon.entity.user;

import cloud.gloagen.utility.persistence.DSBooleanConverter;

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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userinfo_id", nullable = false)
    private UserInformation userInformation;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(length = 5, name = "isValidated")
    @Convert(converter = DSBooleanConverter.class)
    private Boolean validated;
    //
    @Column(name = "isPrimary", length = 5)
    @Convert(converter = DSBooleanConverter.class)
    private Boolean primary;

    public EmailAddress() {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }
}

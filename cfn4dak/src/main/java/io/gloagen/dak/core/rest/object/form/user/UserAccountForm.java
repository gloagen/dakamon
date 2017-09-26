package io.gloagen.dak.core.rest.object.form.user;

import org.apache.commons.lang3.StringUtils;

public class UserAccountForm {

    private String action;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public UserAccountForm() {
    }

    public boolean isValidForm() {

        if (StringUtils.isBlank(firstname)) {
            return false;
        }

        if (StringUtils.isBlank(action)) {
            return false;
        }

        if (StringUtils.isBlank(lastname)) {
            return false;
        }

        if (StringUtils.isBlank(email)) {
            return false;
        }

        if (StringUtils.isBlank(password)) {
            return false;
        }

        return true;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

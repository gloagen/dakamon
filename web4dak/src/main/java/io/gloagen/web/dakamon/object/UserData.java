package io.gloagen.web.dakamon.object;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "useraccount", namespace = "http://gloagen.cloud/xml/ns/useraccount/1.0/")
@XmlType(propOrder = {"accountName", "accountId", "userId", "userName", "emailAddress"})
public class UserData {

    private String accountName;
    private String emailAddress;
    private String userName;

    private long accountId;
    private long userId;

    public UserData() {
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

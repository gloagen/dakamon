package io.gloagen.dak.core.rest.object.form.user;

public class LoginForm {

    private String username;
    private String password;

    private String remoteHost;
    private String clientOperatingSystem;

    public LoginForm() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public String getClientOperatingSystem() {
        return clientOperatingSystem;
    }

    public void setClientOperatingSystem(String clientOperatingSystem) {
        this.clientOperatingSystem = clientOperatingSystem;
    }
}

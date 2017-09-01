package io.gloagen.dak.core.encrypt;

public class HashedPassword {

    private String hash;
    private String salt;

    public HashedPassword() {
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}

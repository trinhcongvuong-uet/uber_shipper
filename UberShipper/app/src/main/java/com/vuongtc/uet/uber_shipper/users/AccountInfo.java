package com.vuongtc.uet.uber_shipper.users;

/**
 * Created by vuongtc on 3/22/2017.
 */
public class AccountInfo {
    private String displayName;
    private String email;
    private String urlPhoto;

    public AccountInfo(String displayName, String email, String urlPhoto) {
        this.displayName = displayName;
        this.email = email;
        this.urlPhoto = urlPhoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

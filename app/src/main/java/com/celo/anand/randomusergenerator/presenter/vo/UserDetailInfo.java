package com.celo.anand.randomusergenerator.presenter.vo;


import android.os.Parcel;
import android.os.Parcelable;

public class UserDetailInfo implements Parcelable {
    private String avatarUrl;
    private String fullName;
    private String firstName;
    private String email;
    private String cellPhone;
    private String homePhone;
    private String location;
    private String dateOfBirth;
    private String registered;
    private String idName;
    private String idValue;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public UserDetailInfo() {}

    private UserDetailInfo(Parcel in) {
        avatarUrl = in.readString();
        fullName = in.readString();
        firstName = in.readString();
        email = in.readString();
        cellPhone = in.readString();
        homePhone = in.readString();
        location = in.readString();
        dateOfBirth = in.readString();
        registered = in.readString();
        idName = in.readString();
        idValue = in.readString();
        username = in.readString();
        password = in.readString();
        salt = in.readString();
        md5 = in.readString();
        sha1 = in.readString();
        sha256 = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(avatarUrl);
        dest.writeString(fullName);
        dest.writeString(firstName);
        dest.writeString(email);
        dest.writeString(cellPhone);
        dest.writeString(homePhone);
        dest.writeString(location);
        dest.writeString(dateOfBirth);
        dest.writeString(registered);
        dest.writeString(idName);
        dest.writeString(idValue);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(salt);
        dest.writeString(md5);
        dest.writeString(sha1);
        dest.writeString(sha256);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<UserDetailInfo> CREATOR = new Parcelable.Creator<UserDetailInfo>() {
        @Override
        public UserDetailInfo createFromParcel(Parcel in) {
            return new UserDetailInfo(in);
        }

        @Override
        public UserDetailInfo[] newArray(int size) {
            return new UserDetailInfo[size];
        }
    };
}
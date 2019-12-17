
package com.celo.anand.randomusergenerator.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginDTO implements Parcelable {
    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("salt")
    @Expose
    private String salt;

    @SerializedName("md5")
    @Expose
    private String md5;

    @SerializedName("sha1")
    @Expose
    private String sha1;

    @SerializedName("sha256")
    @Expose
    private String sha256;

    public final static Parcelable.Creator<LoginDTO> CREATOR = new Creator<LoginDTO>() {

        @SuppressWarnings("unchecked")
        public LoginDTO createFromParcel(Parcel in) {
            LoginDTO instance = new LoginDTO();
            instance.username = ((String) in.readValue((String.class.getClassLoader())));
            instance.password = ((String) in.readValue((String.class.getClassLoader())));
            instance.salt = ((String) in.readValue((String.class.getClassLoader())));
            instance.md5 = ((String) in.readValue((String.class.getClassLoader())));
            instance.sha1 = ((String) in.readValue((String.class.getClassLoader())));
            instance.sha256 = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public LoginDTO[] newArray(int size) {
            return (new LoginDTO[size]);
        }

    };

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(username);
        dest.writeValue(password);
        dest.writeValue(salt);
        dest.writeValue(md5);
        dest.writeValue(sha1);
        dest.writeValue(sha256);
    }

    public int describeContents() {
        return 0;
    }

}

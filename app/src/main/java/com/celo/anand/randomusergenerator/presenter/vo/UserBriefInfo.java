package com.celo.anand.randomusergenerator.presenter.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class UserBriefInfo implements Parcelable {
    private String fullName;
    private String avatarUrl;

    public UserBriefInfo(String fullName, String avatarUrl) {
        this.fullName = fullName;
        this.avatarUrl = avatarUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    protected UserBriefInfo(Parcel in) {
        fullName = in.readString();
        avatarUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(avatarUrl);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<UserBriefInfo> CREATOR = new Parcelable.Creator<UserBriefInfo>() {
        @Override
        public UserBriefInfo createFromParcel(Parcel in) {
            return new UserBriefInfo(in);
        }

        @Override
        public UserBriefInfo[] newArray(int size) {
            return new UserBriefInfo[size];
        }
    };
}
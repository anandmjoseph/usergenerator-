
package com.celo.anand.randomusergenerator.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PictureDTO implements Parcelable {
    @SerializedName("large")
    @Expose
    private String large;

    @SerializedName("medium")
    @Expose
    private String medium;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public final static Parcelable.Creator<PictureDTO> CREATOR = new Creator<PictureDTO>() {

        @SuppressWarnings("unchecked")
        public PictureDTO createFromParcel(Parcel in) {
            PictureDTO instance = new PictureDTO();
            instance.large = ((String) in.readValue((String.class.getClassLoader())));
            instance.medium = ((String) in.readValue((String.class.getClassLoader())));
            instance.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public PictureDTO[] newArray(int size) {
            return (new PictureDTO[size]);
        }

    };

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(large);
        dest.writeValue(medium);
        dest.writeValue(thumbnail);
    }

    public int describeContents() {
        return 0;
    }

}

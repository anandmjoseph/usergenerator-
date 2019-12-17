
package com.celo.anand.randomusergenerator.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NameDTO implements Parcelable {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("first")
    @Expose
    private String first;

    @SerializedName("last")
    @Expose
    private String last;

    public final static Parcelable.Creator<NameDTO> CREATOR = new Creator<NameDTO>() {

        @SuppressWarnings("unchecked")
        public NameDTO createFromParcel(Parcel in) {
            NameDTO instance = new NameDTO();
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.first = ((String) in.readValue((String.class.getClassLoader())));
            instance.last = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public NameDTO[] newArray(int size) {
            return (new NameDTO[size]);
        }

    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(first);
        dest.writeValue(last);
    }

    public int describeContents() {
        return 0;
    }

}

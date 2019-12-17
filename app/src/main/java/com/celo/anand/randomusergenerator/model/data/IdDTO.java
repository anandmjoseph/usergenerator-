
package com.celo.anand.randomusergenerator.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdDTO implements Parcelable {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("value")
    @Expose
    private String value;

    public final static Parcelable.Creator<IdDTO> CREATOR = new Creator<IdDTO>() {

        @SuppressWarnings("unchecked")
        public IdDTO createFromParcel(Parcel in) {
            IdDTO instance = new IdDTO();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.value = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public IdDTO[] newArray(int size) {
            return (new IdDTO[size]);
        }

    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(value);
    }

    public int describeContents() {
        return 0;
    }

}

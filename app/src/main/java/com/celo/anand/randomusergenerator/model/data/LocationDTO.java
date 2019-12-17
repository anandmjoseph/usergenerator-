
package com.celo.anand.randomusergenerator.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationDTO implements Parcelable {
    @SerializedName("street")
    @Expose
    private String street;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("postcode")
    @Expose
    private String postcode;

    public final static Parcelable.Creator<LocationDTO> CREATOR = new Creator<LocationDTO>() {

        @SuppressWarnings("unchecked")
        public LocationDTO createFromParcel(Parcel in) {
            LocationDTO instance = new LocationDTO();
            instance.street = ((String) in.readValue((String.class.getClassLoader())));
            instance.city = ((String) in.readValue((String.class.getClassLoader())));
            instance.state = ((String) in.readValue((String.class.getClassLoader())));
            instance.postcode = ((String) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public LocationDTO[] newArray(int size) {
            return (new LocationDTO[size]);
        }

    };

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(street);
        dest.writeValue(city);
        dest.writeValue(state);
        dest.writeValue(postcode);
    }

    public int describeContents() {
        return 0;
    }

}


package com.celo.anand.randomusergenerator.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoDTO implements Parcelable {
    @SerializedName("seed")
    @Expose
    private String seed;

    @SerializedName("results")
    @Expose
    private Integer results;

    @SerializedName("page")
    @Expose
    private Integer page;

    @SerializedName("version")
    @Expose
    private String version;

    public final static Parcelable.Creator<InfoDTO> CREATOR = new Creator<InfoDTO>() {

        @SuppressWarnings("unchecked")
        public InfoDTO createFromParcel(Parcel in) {
            InfoDTO instance = new InfoDTO();
            instance.seed = ((String) in.readValue((String.class.getClassLoader())));
            instance.results = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.version = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public InfoDTO[] newArray(int size) {
            return (new InfoDTO[size]);
        }

    };

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(seed);
        dest.writeValue(results);
        dest.writeValue(page);
        dest.writeValue(version);
    }

    public int describeContents() {
        return 0;
    }

}

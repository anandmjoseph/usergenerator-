
package com.celo.anand.randomusergenerator.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponseDTO implements Parcelable {
    @SerializedName("results")
    @Expose
    private List<UserDTO> userDTOs = null;

    @SerializedName("info")
    @Expose
    private InfoDTO infoDTO;

    @SerializedName("error")
    @Expose
    private String error;

    public final static Parcelable.Creator<ApiResponseDTO> CREATOR = new Creator<ApiResponseDTO>() {

        @SuppressWarnings("unchecked")
        public ApiResponseDTO createFromParcel(Parcel in) {
            ApiResponseDTO instance = new ApiResponseDTO();
            in.readList(instance.userDTOs, (UserDTO.class.getClassLoader()));
            instance.infoDTO = ((InfoDTO) in.readValue((InfoDTO.class.getClassLoader())));
            instance.error = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public ApiResponseDTO[] newArray(int size) {
            return (new ApiResponseDTO[size]);
        }

    };

    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    public InfoDTO getInfoDTO() {
        return infoDTO;
    }

    public void setInfoDTO(InfoDTO infoDTO) {
        this.infoDTO = infoDTO;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(userDTOs);
        dest.writeValue(infoDTO);
        dest.writeValue(error);
    }

    public int describeContents() {
        return 0;
    }

}

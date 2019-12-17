
package com.celo.anand.randomusergenerator.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDTO implements Parcelable {
    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("name")
    @Expose
    private NameDTO nameDTO;

    @SerializedName("location")
    @Expose
    private LocationDTO locationDTO;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("login")
    @Expose
    private LoginDTO loginDTO;

    @SerializedName("dob")
    @Expose
    private String dob;

    @SerializedName("registered")
    @Expose
    private String registered;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("cell")
    @Expose
    private String cell;

    @SerializedName("id")
    @Expose
    private IdDTO idDTO;

    @SerializedName("picture")
    @Expose
    private PictureDTO pictureDTO;

    @SerializedName("nat")
    @Expose
    private String nat;

    public final static Parcelable.Creator<UserDTO> CREATOR = new Creator<UserDTO>() {

        @SuppressWarnings("unchecked")
        public UserDTO createFromParcel(Parcel in) {
            UserDTO instance = new UserDTO();
            instance.gender = ((String) in.readValue((String.class.getClassLoader())));
            instance.nameDTO = ((NameDTO) in.readValue((NameDTO.class.getClassLoader())));
            instance.locationDTO = ((LocationDTO) in.readValue((LocationDTO.class.getClassLoader())));
            instance.email = ((String) in.readValue((String.class.getClassLoader())));
            instance.loginDTO = ((LoginDTO) in.readValue((LoginDTO.class.getClassLoader())));
            instance.dob = ((String) in.readValue((String.class.getClassLoader())));
            instance.registered = ((String) in.readValue((String.class.getClassLoader())));
            instance.phone = ((String) in.readValue((String.class.getClassLoader())));
            instance.cell = ((String) in.readValue((String.class.getClassLoader())));
            instance.idDTO = ((IdDTO) in.readValue((IdDTO.class.getClassLoader())));
            instance.pictureDTO = ((PictureDTO) in.readValue((PictureDTO.class.getClassLoader())));
            instance.nat = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public UserDTO[] newArray(int size) {
            return (new UserDTO[size]);
        }

    };

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public NameDTO getNameDTO() {
        return nameDTO;
    }

    public void setNameDTO(NameDTO nameDTO) {
        this.nameDTO = nameDTO;
    }

    public LocationDTO getLocationDTO() {
        return locationDTO;
    }

    public void setLocationDTO(LocationDTO locationDTO) {
        this.locationDTO = locationDTO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public IdDTO getIdDTO() {
        return idDTO;
    }

    public void setIdDTO(IdDTO idDTO) {
        this.idDTO = idDTO;
    }

    public PictureDTO getPictureDTO() {
        return pictureDTO;
    }

    public void setPictureDTO(PictureDTO pictureDTO) {
        this.pictureDTO = pictureDTO;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(gender);
        dest.writeValue(nameDTO);
        dest.writeValue(locationDTO);
        dest.writeValue(email);
        dest.writeValue(loginDTO);
        dest.writeValue(dob);
        dest.writeValue(registered);
        dest.writeValue(phone);
        dest.writeValue(cell);
        dest.writeValue(idDTO);
        dest.writeValue(pictureDTO);
        dest.writeValue(nat);
    }

    public int describeContents() {
        return 0;
    }

}

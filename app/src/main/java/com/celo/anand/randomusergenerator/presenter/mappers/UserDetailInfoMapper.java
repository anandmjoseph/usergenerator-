package com.celo.anand.randomusergenerator.presenter.mappers;

import android.text.TextUtils;

import com.celo.anand.randomusergenerator.model.data.LocationDTO;
import com.celo.anand.randomusergenerator.model.data.LoginDTO;
import com.celo.anand.randomusergenerator.model.data.UserDTO;
import com.celo.anand.randomusergenerator.presenter.vo.UserDetailInfo;
import com.celo.anand.randomusergenerator.util.MyTextUtils;

public class UserDetailInfoMapper {

    public static UserDetailInfo map(UserDTO userDTO) {
        UserDetailInfo userDetailInfo = new UserDetailInfo();

        userDetailInfo.setAvatarUrl(UserBriefInfoListMapper.getAvatarUrl(userDTO));
        userDetailInfo.setFullName(UserBriefInfoListMapper.getFullName(userDTO));
        userDetailInfo.setFirstName(
                MyTextUtils.capitalizeFirstLetter(userDTO.getNameDTO().getFirst()));
        userDetailInfo.setEmail(userDTO.getEmail());

        userDetailInfo.setCellPhone(userDTO.getCell());
        userDetailInfo.setHomePhone(userDTO.getPhone());

        userDetailInfo.setLocation(getLocation(userDTO.getLocationDTO()));

        userDetailInfo.setDateOfBirth(userDTO.getDob());
        userDetailInfo.setRegistered(userDTO.getRegistered());

        userDetailInfo.setIdName(userDTO.getIdDTO().getName());
        userDetailInfo.setIdValue(userDTO.getIdDTO().getValue());

        LoginDTO loginDTO = userDTO.getLoginDTO();
        userDetailInfo.setUsername(loginDTO.getUsername());
        userDetailInfo.setPassword(loginDTO.getPassword());
        userDetailInfo.setSalt(loginDTO.getSalt());
        userDetailInfo.setMd5(loginDTO.getMd5());
        userDetailInfo.setSha1(loginDTO.getSha1());
        userDetailInfo.setSha256(loginDTO.getSha256());

        return userDetailInfo;
    }

    private static String getLocation(LocationDTO locationDTO) {
        String[] streetParts = TextUtils.split(locationDTO.getStreet(), " ");
        StringBuilder streetBuilder = new StringBuilder();
        for (String streetPart : streetParts) {
            streetBuilder
                    .append(MyTextUtils.capitalizeFirstLetter(streetPart))
                    .append(" ");

        }

        return MyTextUtils.capitalizeFirstLetter(locationDTO.getState()) +
                ", " +
                MyTextUtils.capitalizeFirstLetter(locationDTO.getCity()) +
                ", " +
                streetBuilder.toString() +
                ", " +
                locationDTO.getPostcode();
    }

}

package com.celo.anand.randomusergenerator.presenter.mappers;


import com.celo.anand.randomusergenerator.model.data.UserDTO;
import com.celo.anand.randomusergenerator.presenter.vo.UserBriefInfo;
import com.celo.anand.randomusergenerator.util.MyTextUtils;
import java.util.ArrayList;
import java.util.List;

public class UserBriefInfoListMapper {

    public static List<UserBriefInfo> map(List<UserDTO> userDTOs) {
        List<UserBriefInfo> result = new ArrayList<>(userDTOs.size());

        for (UserDTO userDTO : userDTOs) {
            UserBriefInfo userBriefInfo = new UserBriefInfo(
                    getFullName(userDTO),
                    getAvatarUrl(userDTO));
            result.add(userBriefInfo);
        }
        return result;
    }

    public static String getFullName(UserDTO userDTO) {
        return MyTextUtils.capitalizeFirstLetter(userDTO.getNameDTO().getFirst()) + " "
                + MyTextUtils.capitalizeFirstLetter(userDTO.getNameDTO().getLast());
    }

    public static String getAvatarUrl(UserDTO userDTO) {
        return userDTO.getPictureDTO().getLarge();
    }
}

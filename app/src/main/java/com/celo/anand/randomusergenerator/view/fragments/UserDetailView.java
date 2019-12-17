package com.celo.anand.randomusergenerator.view.fragments;


public interface UserDetailView {

    void setAvatarUrl(String avatarUrl);

    void setTitle(String title);

    void setSubtitle(String subtitle);

    void setCellPhone(String cellPhone);

    void setHomePhone(String homePhone);

    void setLocation(String location);

    void setAboutName(String aboutName);

    void setDateOfBirth(String dateOfBirth);

    void setRegistered(String registered);

    void setId(String idName, String idValue);

    void setUsername(String username);

    void setPassword(String password);

    void setSalt(String salt);

    void setMd5(String md5);

    void setSha1(String sha1);

    void setSha256(String sha256);

}

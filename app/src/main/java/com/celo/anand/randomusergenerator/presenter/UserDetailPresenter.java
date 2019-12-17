package com.celo.anand.randomusergenerator.presenter;


import com.celo.anand.randomusergenerator.presenter.vo.UserDetailInfo;
import com.celo.anand.randomusergenerator.view.fragments.UserDetailView;

public class UserDetailPresenter {

    private UserDetailView view;
    private UserDetailInfo user;

    public UserDetailPresenter(UserDetailView view, UserDetailInfo user) {
        this.view = view;
        this.user = user;

        showData();
    }

    private void showData() {
        view.setAvatarUrl(user.getAvatarUrl());
        view.setTitle(user.getFullName());
        view.setSubtitle(user.getEmail());
        view.setCellPhone(user.getCellPhone());
        view.setHomePhone(user.getHomePhone());
        view.setLocation(user.getLocation());
        view.setAboutName(user.getFirstName());
        view.setDateOfBirth(user.getDateOfBirth());
        view.setRegistered(user.getRegistered());
        view.setId(user.getIdName(), user.getIdValue());
        view.setUsername(user.getUsername());
        view.setPassword(user.getPassword());
        view.setSalt(user.getSalt());
        view.setMd5(user.getMd5());
        view.setSha1(user.getSha1());
        view.setSha256(user.getSha256());
    }
}

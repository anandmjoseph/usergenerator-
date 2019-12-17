package com.celo.anand.randomusergenerator.view.fragments;

import com.celo.anand.randomusergenerator.presenter.vo.UserBriefInfo;
import com.celo.anand.randomusergenerator.presenter.vo.UserDetailInfo;

import java.util.List;

public interface UsersListView {
    void showData(List<UserBriefInfo> list);

    void startUserDetailFragment(UserDetailInfo userDetailInfo);

    void showLoading();

    void hideLoading();

    void showOfflineError();

    void openNetworkSettings();

    void exit();

    void showApiError(String apiError);

    void showAppError(String appError);

    void showUnknownApiResponse();
}

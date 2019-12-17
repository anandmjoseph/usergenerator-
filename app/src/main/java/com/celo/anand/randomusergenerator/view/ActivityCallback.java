package com.celo.anand.randomusergenerator.view;


import android.support.v4.app.DialogFragment;

import com.celo.anand.randomusergenerator.presenter.vo.UserDetailInfo;

public interface ActivityCallback extends SupportActionBarActivity {
    void startUserDetailFragment(UserDetailInfo userDetailInfo);
    void showDialogFragment(DialogFragment dialogFragment);
}

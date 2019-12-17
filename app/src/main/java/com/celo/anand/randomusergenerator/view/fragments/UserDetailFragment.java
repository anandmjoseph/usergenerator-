package com.celo.anand.randomusergenerator.view.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.celo.anand.randomusergenerator.R;
import com.celo.anand.randomusergenerator.presenter.UserDetailPresenter;
import com.celo.anand.randomusergenerator.presenter.vo.UserDetailInfo;
import com.celo.anand.randomusergenerator.util.PicassoUtils;
import com.celo.anand.randomusergenerator.view.SupportActionBarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class UserDetailFragment extends Fragment implements UserDetailView {

    private static final String BUNDLE_USER_DETAIL_INFO = "bundle_user_detail_info";
    @BindView(R.id.toolbar_userdetail) Toolbar toolbar;
    @BindView(R.id.imageview_userdetail_avatar) ImageView avatarImageView;
    @BindView(R.id.textview_userdetail_title) TextView titleTextView;
    @BindView(R.id.textview_userdetail_subtitle) TextView subtitleTextView;
    @BindView(R.id.textview_userdetail_phone_cell) TextView cellPhoneTextView;
    @BindView(R.id.textview_userdetail_phone_home) TextView homePhoneTextView;
    @BindView(R.id.textview_userdetail_location) TextView locationTextView;
    @BindView(R.id.textview_userdetail_about_user) TextView aboutUserTextView;
    @BindView(R.id.textview_userdetail_date_of_birth) TextView dateOfBirthTextView;
    @BindView(R.id.textview_userdetail_registred) TextView registeredTextView;
    @BindView(R.id.textview_userdetail_id_name) TextView idNameTextView;
    @BindView(R.id.textview_userdetail_id_value) TextView idValueTextView;
    @BindView(R.id.textview_userdetail_username) TextView usernameTextView;
    @BindView(R.id.textview_userdetail_password) TextView passwordTextView;
    @BindView(R.id.textview_userdetail_salt) TextView saltTextView;
    @BindView(R.id.textview_userdetail_md5) TextView md5TextView;
    @BindView(R.id.textview_userdetail_sha1) TextView sha1TextView;
    @BindView(R.id.textview_userdetail_sha256) TextView sha256TextView;

    private UserDetailPresenter presenter;
    private SupportActionBarActivity supportActionBarActivity;
    private Unbinder unbinder;

    public static UserDetailFragment newInstance(UserDetailInfo userDetailInfo) {
        Bundle args = new Bundle();
        args.putParcelable(BUNDLE_USER_DETAIL_INFO, userDetailInfo);

        UserDetailFragment fragment = new UserDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userdetail, container, false);

        unbinder = ButterKnife.bind(this, view);

        setupToolbar();

        UserDetailInfo userDetailInfo = getArguments().getParcelable(BUNDLE_USER_DETAIL_INFO);

        presenter = new UserDetailPresenter(this, userDetailInfo);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setupToolbar() {
        ActionBar actionBar = supportActionBarActivity.setupToolbar(toolbar);
        actionBar.setTitle(" ");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            supportActionBarActivity = (SupportActionBarActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement SupportActionBarActivity");
        }
    }

    @Override
    public void setAvatarUrl(String avatarUrl) {
        PicassoUtils.loadImage(getContext(), avatarUrl, avatarImageView);
    }

    @Override
    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    @Override
    public void setSubtitle(String subtitle) {
        subtitleTextView.setText(subtitle);
    }

    @Override
    public void setCellPhone(String cellPhone) {
        cellPhoneTextView.setText(cellPhone);
    }

    @Override
    public void setHomePhone(String homePhone) {
        homePhoneTextView.setText(homePhone);
    }

    @Override
    public void setLocation(String location) {
        locationTextView.setText(location);
    }

    @Override
    public void setAboutName(String aboutName) {
        aboutUserTextView.setText(
                getString(R.string.userdetail_about, aboutName));
    }

    @Override
    public void setDateOfBirth(String dateOfBirth) {
        dateOfBirthTextView.setText(dateOfBirth);
    }

    @Override
    public void setRegistered(String registered) {
        registeredTextView.setText(registered);
    }

    @Override
    public void setId(String idName, String idValue) {
        idNameTextView.setText(idName);
        idValueTextView.setText(idValue);
    }

    @Override
    public void setUsername(String username) {
        usernameTextView.setText(username);
    }

    @Override
    public void setPassword(String password) {
        passwordTextView.setText(password);
    }

    @Override
    public void setSalt(String salt) {
        saltTextView.setText(salt);
    }

    @Override
    public void setMd5(String md5) {
        md5TextView.setText(md5);
    }

    @Override
    public void setSha1(String sha1) {
        sha1TextView.setText(sha1);
    }

    @Override
    public void setSha256(String sha256) {
        sha256TextView.setText(sha256);
    }
}

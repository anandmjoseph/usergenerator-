package com.celo.anand.randomusergenerator.presenter;

import android.os.Bundle;

import com.celo.anand.randomusergenerator.model.Model;
import com.celo.anand.randomusergenerator.model.ModelImpl;
import com.celo.anand.randomusergenerator.model.data.ApiResponseDTO;
import com.celo.anand.randomusergenerator.model.data.UserDTO;
import com.celo.anand.randomusergenerator.presenter.mappers.UserBriefInfoListMapper;
import com.celo.anand.randomusergenerator.presenter.mappers.UserDetailInfoMapper;
import com.celo.anand.randomusergenerator.presenter.vo.UserBriefInfo;
import com.celo.anand.randomusergenerator.presenter.vo.UserDetailInfo;
import com.celo.anand.randomusergenerator.view.fragments.UsersListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.observers.DisposableObserver;

public class UsersListPresenter {

    private static int USERS_COUNT = 10;
    private static final String BUNDLE_USER_DTOS_KEY = "bundle_user_dtos_key";
    private static final String BUNDLE_IS_IN_CRITICAL_ERROR_STATE = "bundle_is_in_critical_error_state";
    private boolean isInCriticalErrorState = false;

    private List<UserDTO> userDTOs;

    private Model model = new ModelImpl();

    private UsersListView view;
    private Disposable disposable = Disposables.empty();

    public UsersListPresenter(UsersListView view) {
        this.view = view;
    }

    @SuppressWarnings("unchecked")
    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            userDTOs = (List<UserDTO>) savedInstanceState.getSerializable(BUNDLE_USER_DTOS_KEY);
            isInCriticalErrorState = savedInstanceState.getBoolean(BUNDLE_IS_IN_CRITICAL_ERROR_STATE);
        }

    }

    public void onResume(boolean isOnline) {
        if (!isInCriticalErrorState) {
            if (!isUserDTOsEmpty()) {
                processUserDTOs(userDTOs);
            } else {
                if (isOnline) {
                    loadUsers(USERS_COUNT);
                } else {
                    view.showOfflineError();
                }
            }
        }
    }

    private boolean isUserDTOsEmpty() {
        return userDTOs == null || userDTOs.isEmpty();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (!isUserDTOsEmpty()) {
            outState.putSerializable(BUNDLE_USER_DTOS_KEY, new ArrayList<>(userDTOs));
        }
        outState.putBoolean(BUNDLE_IS_IN_CRITICAL_ERROR_STATE, isInCriticalErrorState);
    }

    public void onStop() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public void onUserSelected(int position) {
        UserDTO selectedUserDTO = userDTOs.get(position);
        UserDetailInfo userDetailInfo = UserDetailInfoMapper.map(selectedUserDTO);
        view.startUserDetailFragment(userDetailInfo);
    }

    public void onSettingsClick() {
        view.openNetworkSettings();
    }

    public void onExitClick() {
        view.exit();
    }

    public void updateUsers(int totalItemCount){

        USERS_COUNT = totalItemCount+10;
        loadUsers(USERS_COUNT);
    }

    private void loadUsers(int USERS_COUNT) {

        if (!disposable.isDisposed()) {
            disposable.dispose();
        }

        USERS_COUNT += 10;

        view.showLoading();

        disposable = model.getUsersList(USERS_COUNT)
                .subscribeWith(new DisposableObserver<ApiResponseDTO>() {
                    @Override
                    public void onNext(@NonNull ApiResponseDTO apiResponseDTO) {
                        if (apiResponseDTO != null) {
                            String apiError = apiResponseDTO.getError();
                            if (apiError == null) {
                                processUserDTOs(apiResponseDTO.getUserDTOs());
                            } else {
                                isInCriticalErrorState = true;
                                view.showApiError(apiError);
                            }
                        } else {
                            isInCriticalErrorState = true;
                            view.showUnknownApiResponse();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.hideLoading();
                        view.showAppError(e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        view.hideLoading();
                    }
                });
    }

    private void processUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
        sortUserDTOs(this.userDTOs);
        List<UserBriefInfo> usersBriefInfo = UserBriefInfoListMapper.map(this.userDTOs);
        view.showData(usersBriefInfo);
    }

    private void sortUserDTOs(List<UserDTO> userDTOs) {
        Collections.sort(userDTOs, (u1, u2) -> {
            int compareResult = u1.getNameDTO().getFirst().compareTo(
                    u2.getNameDTO().getFirst());

            if (compareResult == 0) {
                compareResult = u1.getNameDTO().getLast().compareTo(
                        u2.getNameDTO().getLast());
            }

            return compareResult;
        });
    }
}

package com.celo.anand.randomusergenerator.view;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.celo.anand.randomusergenerator.R;
import com.celo.anand.randomusergenerator.presenter.vo.UserDetailInfo;
import com.celo.anand.randomusergenerator.view.fragments.UserDetailFragment;
import com.celo.anand.randomusergenerator.view.fragments.UsersListFragment;


public class MainActivity extends AppCompatActivity implements ActivityCallback, FragmentManager.OnBackStackChangedListener {

    public static final String TAG_DIALOG_FRAGMENT = "dialog_fragment";
    private static String TAG = "TAG";

    private DialogFragment dialogFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        fragmentManager.addOnBackStackChangedListener(this);

        Fragment fragment = fragmentManager.findFragmentByTag(TAG);
        if (fragment == null) {
            replaceFragment(new UsersListFragment(), false);
        }
    }

    private void replaceFragment(Fragment fragment, boolean addBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout_main, fragment, TAG);
        if (addBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    @Override
    public ActionBar setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();

        shouldDisplayHomeUp();

        return supportActionBar;
    }

    @Override
    public void startUserDetailFragment(UserDetailInfo userDetailInfo) {
        replaceFragment(UserDetailFragment.newInstance(userDetailInfo), true);
    }

    @Override
    public void showDialogFragment(DialogFragment newDialogFragment) {
        DialogFragment currentDialogFragment =
                (DialogFragment) fragmentManager.findFragmentByTag(TAG_DIALOG_FRAGMENT);

        if (isDialogShowing(currentDialogFragment)) {
            currentDialogFragment.getDialog().dismiss();
        }

        currentDialogFragment = newDialogFragment;
        currentDialogFragment.show(fragmentManager, TAG_DIALOG_FRAGMENT);
    }

    private boolean isDialogShowing(DialogFragment dialogFragment) {
        return dialogFragment != null && dialogFragment.getDialog() != null
                && dialogFragment.getDialog().isShowing();
    }


    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    private void shouldDisplayHomeUp() {
        boolean canBack = getSupportFragmentManager().getBackStackEntryCount() > 0;
        getSupportActionBar().setDisplayHomeAsUpEnabled(canBack);
    }

    @Override
    public boolean onSupportNavigateUp() {
        getSupportFragmentManager().popBackStack();
        return true;
    }
}

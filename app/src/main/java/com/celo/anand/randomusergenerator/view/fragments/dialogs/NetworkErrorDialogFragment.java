package com.celo.anand.randomusergenerator.view.fragments.dialogs;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

import com.celo.anand.randomusergenerator.R;

public class NetworkErrorDialogFragment extends DialogFragment {

    private static final int REQUEST_CODE = 2;

    public static NetworkErrorDialogFragment newInstance(Fragment listenerFragment) {
        NetworkErrorDialogFragment fragment = new NetworkErrorDialogFragment();

        if (!(listenerFragment instanceof NetworkErrorDialogListener)) {
            throw new ClassCastException(listenerFragment.toString()
                    + " must implement NetworkErrorDialogListener");
        }

        fragment.setTargetFragment(listenerFragment, REQUEST_CODE);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);

        NetworkErrorDialogListener listener = (NetworkErrorDialogListener) getTargetFragment();

        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.dialog_networkerror_title)
                .setMessage(R.string.dialog_networkerror_message)
                .setPositiveButton(R.string.dialog_networkerror_settings_button,
                        (dialog, whichButton) -> listener.onSettingsClick())
                .setNegativeButton(R.string.dialog_error_exit_button,
                        (dialog, whichButton) -> listener.onExitClick())
                .create();
    }

}

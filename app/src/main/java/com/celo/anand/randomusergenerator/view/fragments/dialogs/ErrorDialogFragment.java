package com.celo.anand.randomusergenerator.view.fragments.dialogs;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

import com.celo.anand.randomusergenerator.R;

public class ErrorDialogFragment extends DialogFragment {

    private static final int REQUEST_CODE = 1;

    private static final String BUNDLE_MESSAGE = "bundle_message";
    private static final String BUNDLE_TITLE = "bundle_title";

    public static ErrorDialogFragment newInstance(Fragment listenerFragment, String title, String message) {

        Bundle args = new Bundle();
        args.putString(BUNDLE_MESSAGE, message);
        args.putString(BUNDLE_TITLE, title);

        ErrorDialogFragment fragment = new ErrorDialogFragment();
        fragment.setArguments(args);

        if (!(listenerFragment instanceof ErrorDialogListener)) {
            throw new ClassCastException(listenerFragment.toString()
                    + " must implement ErrorDialogListener");
        }
        fragment.setTargetFragment(listenerFragment, REQUEST_CODE);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);

        ErrorDialogListener listener = (ErrorDialogListener) getTargetFragment();
        String message = getArguments().getString(BUNDLE_MESSAGE);
        String title = getArguments().getString(BUNDLE_TITLE);

        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(R.string.dialog_error_exit_button,
                        (dialog, whichButton) -> listener.onExitClick())
                .create();
    }

}

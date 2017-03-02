package com.salon.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.salon.R;
import com.salon.config.App;

/**
 * Created by cis on 1/12/16.
 */

public class Utilities {

    private ProgressDialog loadingDialog;
    public Activity activity;

    public Utilities(Activity activity) {
        this.activity = activity;
    }

    public void showLoadingDialog(final String title, final String message) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        loadingDialog = ProgressDialog.show(activity, title, message, true, false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void dismissLoadingDialog() {
        if (activity != null && loadingDialog != null) {
            try {
                loadingDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        Toast.makeText(context, context.getString(R.string.error_no_internet), Toast.LENGTH_SHORT).show();
        return false;
    }

    public void showToast(String message) {
        Toast.makeText(App.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public boolean isValidEmail(String target) {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()) {
            return false;
        }
        return true;
    }
}

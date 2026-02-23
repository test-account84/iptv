package com.amazonaws.mobile.auth.core.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ViewHelper {
    public static void showDialog(Activity activity, String str, String str2) {
        if (activity == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setNeutralButton(17039370, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public static void showDialog(Activity activity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        if (activity == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(str3, onClickListener);
        builder.setNegativeButton(str4, onClickListener2);
        builder.show();
    }
}

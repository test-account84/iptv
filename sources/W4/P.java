package w4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class p extends androidx.fragment.app.d {
    public Dialog a;
    public DialogInterface.OnCancelListener c;
    public Dialog d;

    public static p A(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        p pVar = new p();
        Dialog dialog2 = (Dialog) com.google.android.gms.common.internal.r.n(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        pVar.a = dialog2;
        if (onCancelListener != null) {
            pVar.c = onCancelListener;
        }
        return pVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.c;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.d == null) {
            this.d = new AlertDialog.Builder((Context) com.google.android.gms.common.internal.r.m(getContext())).create();
        }
        return this.d;
    }

    public void show(androidx.fragment.app.m mVar, String str) {
        super.show(mVar, str);
    }
}

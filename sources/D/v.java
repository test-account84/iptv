package d;

import android.app.Dialog;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class v extends androidx.fragment.app.d {
    public Dialog onCreateDialog(Bundle bundle) {
        return new u(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i) {
        if (!(dialog instanceof u)) {
            super.setupDialog(dialog, i);
            return;
        }
        u uVar = (u) dialog;
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        uVar.supportRequestWindowFeature(1);
    }
}

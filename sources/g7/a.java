package G7;

import android.app.Activity;
import android.app.UiModeManager;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a extends Activity {
    public final boolean a() {
        return ((UiModeManager) getSystemService("uimode")).getCurrentModeType() == 4;
    }

    public void onCreate(Bundle bundle) {
        if (a()) {
            requestWindowFeature(0);
        }
        super.onCreate(bundle);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }
}

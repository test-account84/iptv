package R8;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class d extends e {
    public d(Object obj) {
        super(obj);
    }

    public void a(int i, String... strArr) {
        throw new IllegalStateException("Should never be requesting permissions on API < 23!");
    }

    public Context b() {
        if (c() instanceof Activity) {
            return (Context) c();
        }
        if (c() instanceof Fragment) {
            return ((Fragment) c()).getContext();
        }
        throw new IllegalStateException("Unknown host: " + c());
    }

    public boolean i(String str) {
        return false;
    }

    public void j(String str, String str2, String str3, int i, int i2, String... strArr) {
        throw new IllegalStateException("Should never be requesting permissions on API < 23!");
    }
}

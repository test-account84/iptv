package R8;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class f extends c {
    public f(Fragment fragment) {
        super(fragment);
    }

    public void a(int i, String... strArr) {
        ((Fragment) c()).requestPermissions(strArr, i);
    }

    public Context b() {
        return ((Fragment) c()).getActivity();
    }

    public boolean i(String str) {
        return ((Fragment) c()).shouldShowRequestPermissionRationale(str);
    }

    public m l() {
        return ((Fragment) c()).getChildFragmentManager();
    }
}

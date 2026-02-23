package z7;

import android.view.View;
import com.nst.iptvsmarterstvbox.model.callback.StalkerCreatePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerDeletePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerShortEPGCallback;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface j {
    void D0(String str);

    void M0(String str);

    void P(String str);

    void T0(StalkerDeletePlayerLinkCallback stalkerDeletePlayerLinkCallback);

    void X(StalkerShortEPGCallback stalkerShortEPGCallback);

    void u(StalkerCreatePlayerLinkCallback stalkerCreatePlayerLinkCallback, View view, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8);
}

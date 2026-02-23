package M4;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h3 implements Z4 {
    public final /* synthetic */ t3 a;

    public h3(t3 t3Var) {
        this.a = t3Var;
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.a.r("auto", "_err", bundle);
        } else {
            this.a.t("auto", "_err", bundle, str);
        }
    }
}

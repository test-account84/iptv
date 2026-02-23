package androidx.preference;

import F.k;
import android.content.Context;
import android.util.AttributeSet;
import z0.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public boolean M;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, k.a(context, c.f, 16842891));
        this.M = true;
    }

    public void A() {
        if (l() == null && j() == null && N() != 0) {
            r();
            throw null;
        }
    }
}

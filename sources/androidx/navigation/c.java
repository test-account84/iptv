package androidx.navigation;

import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c {
    public final int a;
    public p b;
    public Bundle c;

    public c(int i) {
        this(i, null);
    }

    public Bundle a() {
        return this.c;
    }

    public int b() {
        return this.a;
    }

    public p c() {
        return this.b;
    }

    public void d(Bundle bundle) {
        this.c = bundle;
    }

    public void e(p pVar) {
        this.b = pVar;
    }

    public c(int i, p pVar) {
        this(i, pVar, null);
    }

    public c(int i, p pVar, Bundle bundle) {
        this.a = i;
        this.b = pVar;
        this.c = bundle;
    }
}

package com.onesignal;

import com.onesignal.F1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class I0 {
    public boolean a = false;

    public abstract String a();

    public abstract void b(F1.x xVar);

    public boolean c() {
        return this.a;
    }

    public void d(boolean z) {
        this.a = z;
    }

    public String toString() {
        return "OSInAppMessagePrompt{key=" + a() + " prompted=" + this.a + '}';
    }
}

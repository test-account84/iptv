package androidx.activity;

import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class n {
    public static final void a(View view, l lVar) {
        kotlin.jvm.internal.l.e(view, "<this>");
        kotlin.jvm.internal.l.e(lVar, "onBackPressedDispatcherOwner");
        view.setTag(m.a, lVar);
    }
}

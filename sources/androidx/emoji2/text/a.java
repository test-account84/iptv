package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class a implements ThreadFactory {
    public final /* synthetic */ String a;

    public /* synthetic */ a(String str) {
        this.a = str;
    }

    public final Thread newThread(Runnable runnable) {
        return b.a(this.a, runnable);
    }
}

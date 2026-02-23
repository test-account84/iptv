package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class akq {
    protected final ContentProgressProvider a;
    private final Handler b;
    private final List c;

    public akq() {
        this.c = new ArrayList(1);
        this.b = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ void a(akq akqVar) {
        akqVar.g();
    }

    private final void g() {
        VideoProgressUpdate f = f();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((akp) it.next()).a(f);
        }
        this.b.postDelayed(new ako(this), 200L);
    }

    public final void b(akp akpVar) {
        this.c.add(akpVar);
    }

    public final void c(akp akpVar) {
        this.c.remove(akpVar);
    }

    public final void d() {
        e();
        g();
    }

    public final void e() {
        this.b.removeCallbacksAndMessages((Object) null);
    }

    public final VideoProgressUpdate f() {
        VideoProgressUpdate contentProgress = this.a.getContentProgress();
        if (contentProgress != null) {
            return contentProgress;
        }
        Log.w("IMASDK", "ContentProgressProvider.getContentProgress() is null. Use VideoProgressUpdate.VIDEO_TIME_NOT_READY instead.");
        return VideoProgressUpdate.VIDEO_TIME_NOT_READY;
    }

    public akq(ContentProgressProvider contentProgressProvider) {
        this();
        this.a = contentProgressProvider;
    }
}

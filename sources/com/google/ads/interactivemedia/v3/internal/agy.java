package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class agy extends ContentObserver {
    private final Context a;
    private final AudioManager b;
    private float c;
    private final ahe d;
    private final afe e;

    public agy(Handler handler, Context context, afe afeVar, ahe aheVar, byte[] bArr, byte[] bArr2) {
        super(handler);
        this.a = context;
        this.b = (AudioManager) context.getSystemService("audio");
        this.e = afeVar;
        this.d = aheVar;
    }

    private final float c() {
        int streamVolume = this.b.getStreamVolume(3);
        int streamMaxVolume = this.b.getStreamMaxVolume(3);
        float f = 0.0f;
        if (streamMaxVolume > 0 && streamVolume > 0) {
            float f2 = streamVolume / streamMaxVolume;
            f = 1.0f;
            if (f2 <= 1.0f) {
                return f2;
            }
        }
        return f;
    }

    private final void d() {
        this.d.d(this.c);
    }

    public final void a() {
        this.c = c();
        d();
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void b() {
        this.a.getContentResolver().unregisterContentObserver(this);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        float c = c();
        if (c != this.c) {
            this.c = c;
            d();
        }
    }
}

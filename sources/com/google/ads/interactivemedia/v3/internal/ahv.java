package com.google.ads.interactivemedia.v3.internal;

import android.os.AsyncTask;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ahv extends AsyncTask {
    private ahw a;
    protected final aly d;

    public ahv(aly alyVar, byte[] bArr) {
        this.d = alyVar;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        ahw ahwVar = this.a;
        if (ahwVar != null) {
            ahwVar.b();
        }
    }

    public final void b(ahw ahwVar) {
        this.a = ahwVar;
    }
}

package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import n4.m;
import p4.i;
import q4.x;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcn extends a {
    private final TextView zza;

    public zzcn(TextView textView) {
        this.zza = textView;
    }

    public final void onMediaStatusUpdated() {
        MediaInfo j;
        m Q;
        String e;
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || (j = remoteMediaClient.j()) == null || (Q = j.Q()) == null || (e = x.e(Q)) == null) {
            return;
        }
        this.zza.setText(e);
    }
}

package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import java.util.ArrayList;
import java.util.List;
import n4.m;
import n4.p;
import p4.i;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcc extends a {
    private final TextView zza;
    private final List zzb;

    public zzcc(TextView textView, List list) {
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        this.zza = textView;
        arrayList.addAll(list);
    }

    public final void onMediaStatusUpdated() {
        p o;
        MediaInfo L;
        m Q;
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q() || (o = remoteMediaClient.o()) == null || (L = o.L()) == null || (Q = L.Q()) == null) {
            return;
        }
        for (String str : this.zzb) {
            if (Q.e(str)) {
                this.zza.setText(Q.J(str));
                return;
            }
        }
        this.zza.setText("");
    }
}

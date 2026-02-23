package com.google.android.gms.internal.cast;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import o4.e;
import o4.m;
import o4.q;
import o4.u;
import o4.v;
import p4.i;
import r4.a;
import r4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcu extends a implements i.e {
    private final TextView zza;
    private final ImageView zzb;
    private final c zzc;

    public zzcu(View view, c cVar) {
        TextView findViewById = view.findViewById(q.R);
        this.zza = findViewById;
        ImageView findViewById2 = view.findViewById(q.Q);
        this.zzb = findViewById2;
        this.zzc = cVar;
        TypedArray obtainStyledAttributes = findViewById2.getContext().obtainStyledAttributes((AttributeSet) null, v.b, m.a, u.a);
        int resourceId = obtainStyledAttributes.getResourceId(v.p, 0);
        obtainStyledAttributes.recycle();
        findViewById2.getDrawable().setColorFilter(findViewById2.getContext().getResources().getColor(resourceId), PorterDuff.Mode.SRC_IN);
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onProgressUpdated(long j, long j2) {
        zza();
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.c(this, 1000L);
        }
        zza();
    }

    public final void onSessionEnded() {
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.P(this);
        }
        super.onSessionEnded();
        zza();
    }

    public final void zza() {
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q() || !remoteMediaClient.s()) {
            this.zza.setVisibility(8);
            this.zzb.setVisibility(8);
        } else {
            boolean v = !remoteMediaClient.r0() ? remoteMediaClient.v() : this.zzc.m();
            this.zza.setVisibility(0);
            this.zzb.setVisibility(true == v ? 0 : 8);
            zzr.zzd(zzln.zzz);
        }
    }
}

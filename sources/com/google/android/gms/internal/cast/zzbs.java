package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import java.util.ArrayList;
import java.util.List;
import n4.b;
import n4.r;
import o4.e;
import p4.i;
import r4.a;
import r4.c;
import s4.d;
import s4.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbs extends a implements i.e {
    private final CastSeekBar zza;
    private final long zzb;
    private final c zzc;

    public zzbs(CastSeekBar castSeekBar, long j, c cVar) {
        this.zza = castSeekBar;
        this.zzb = j;
        this.zzc = cVar;
        castSeekBar.setEnabled(false);
        castSeekBar.d(null);
        castSeekBar.e = null;
        castSeekBar.postInvalidate();
    }

    public final i getRemoteMediaClient() {
        return super.getRemoteMediaClient();
    }

    public final void onMediaStatusUpdated() {
        zzc();
    }

    public final void onProgressUpdated(long j, long j2) {
        zzb();
        zza();
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        i remoteMediaClient = super.getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.c(this, this.zzb);
        }
        zzc();
    }

    public final void onSessionEnded() {
        i remoteMediaClient = super.getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.P(this);
        }
        super.onSessionEnded();
        zzc();
    }

    public final void zza() {
        CastSeekBar castSeekBar;
        i remoteMediaClient = super.getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.w()) {
            castSeekBar = this.zza;
            castSeekBar.e = null;
        } else {
            int d = (int) remoteMediaClient.d();
            r l = remoteMediaClient.l();
            n4.a J = l != null ? l.J() : null;
            int K = J != null ? (int) J.K() : d;
            if (d < 0) {
                d = 0;
            }
            if (K < 0) {
                K = 1;
            }
            castSeekBar = this.zza;
            if (d > K) {
                K = d;
            }
            castSeekBar.e = new d(d, K);
        }
        castSeekBar.postInvalidate();
    }

    public final void zzb() {
        i remoteMediaClient = super.getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q() || remoteMediaClient.w()) {
            this.zza.setEnabled(false);
        } else {
            this.zza.setEnabled(true);
        }
        f fVar = new f();
        fVar.a = this.zzc.a();
        fVar.b = this.zzc.b();
        fVar.c = (int) (-this.zzc.e());
        i remoteMediaClient2 = super.getRemoteMediaClient();
        fVar.d = (remoteMediaClient2 != null && remoteMediaClient2.q() && remoteMediaClient2.r0()) ? this.zzc.d() : this.zzc.a();
        i remoteMediaClient3 = super.getRemoteMediaClient();
        fVar.e = (remoteMediaClient3 != null && remoteMediaClient3.q() && remoteMediaClient3.r0()) ? this.zzc.c() : this.zzc.a();
        i remoteMediaClient4 = super.getRemoteMediaClient();
        fVar.f = remoteMediaClient4 != null && remoteMediaClient4.q() && remoteMediaClient4.r0();
        this.zza.e(fVar);
    }

    public final void zzc() {
        CastSeekBar castSeekBar;
        zzb();
        i remoteMediaClient = super.getRemoteMediaClient();
        ArrayList arrayList = null;
        MediaInfo j = remoteMediaClient == null ? null : remoteMediaClient.j();
        if (remoteMediaClient == null || !remoteMediaClient.q() || remoteMediaClient.t() || j == null) {
            castSeekBar = this.zza;
        } else {
            castSeekBar = this.zza;
            List<b> I = j.I();
            if (I != null) {
                arrayList = new ArrayList();
                for (b bVar : I) {
                    if (bVar != null) {
                        long K = bVar.K();
                        int b = K == -1000 ? this.zzc.b() : Math.min((int) (K - this.zzc.e()), this.zzc.b());
                        if (b >= 0) {
                            arrayList.add(new s4.c(b, (int) bVar.I(), bVar.M()));
                        }
                    }
                }
            }
        }
        castSeekBar.d(arrayList);
        zza();
    }
}

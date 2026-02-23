package com.google.android.gms.internal.cast;

import android.content.Context;
import android.view.View;
import o4.e;
import o4.t;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbt extends a {
    private final View zza;
    private final String zzb;
    private final String zzc;

    public zzbt(View view, Context context) {
        this.zza = view;
        this.zzb = context.getString(t.c);
        this.zzc = context.getString(t.d);
        view.setEnabled(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zza() {
        /*
            r8 = this;
            p4.i r0 = r8.getRemoteMediaClient()
            r1 = 0
            if (r0 == 0) goto L57
            boolean r2 = r0.q()
            if (r2 == 0) goto L57
            com.google.android.gms.cast.MediaInfo r2 = r0.j()
            if (r2 != 0) goto L14
            goto L57
        L14:
            java.util.List r2 = r2.P()
            if (r2 == 0) goto L57
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L57
            java.util.Iterator r2 = r2.iterator()
            r3 = 0
        L25:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L57
            java.lang.Object r4 = r2.next()
            com.google.android.gms.cast.MediaTrack r4 = (com.google.android.gms.cast.MediaTrack) r4
            int r5 = r4.O()
            r6 = 2
            r7 = 1
            if (r5 != r6) goto L3e
            int r3 = r3 + 1
            if (r3 <= r7) goto L25
            goto L44
        L3e:
            int r4 = r4.O()
            if (r4 != r7) goto L25
        L44:
            boolean r0 = r0.w()
            if (r0 != 0) goto L57
            android.view.View r0 = r8.zza
            r0.setEnabled(r7)
            android.view.View r0 = r8.zza
            java.lang.String r1 = r8.zzb
        L53:
            r0.setContentDescription(r1)
            return
        L57:
            android.view.View r0 = r8.zza
            r0.setEnabled(r1)
            android.view.View r0 = r8.zza
            java.lang.String r1 = r8.zzc
            goto L53
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzbt.zza():void");
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        this.zza.setEnabled(true);
        zza();
    }

    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        super.onSessionEnded();
    }
}

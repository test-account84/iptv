package com.google.ads.interactivemedia.v3.internal;

import android.content.BroadcastReceiver;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class cg extends BroadcastReceiver {
    final /* synthetic */ ch a;

    public /* synthetic */ cg(ch chVar) {
        this.a = chVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceive(android.content.Context r9, android.content.Intent r10) {
        /*
            r8 = this;
            java.lang.String r10 = "connectivity"
            java.lang.Object r10 = r9.getSystemService(r10)
            android.net.ConnectivityManager r10 = (android.net.ConnectivityManager) r10
            r0 = 0
            r1 = 5
            if (r10 != 0) goto Ld
            goto L51
        Ld:
            android.net.NetworkInfo r10 = r10.getActiveNetworkInfo()     // Catch: java.lang.SecurityException -> L50
            r2 = 1
            if (r10 == 0) goto L1a
            boolean r3 = r10.isConnected()
            if (r3 != 0) goto L1c
        L1a:
            r0 = 1
            goto L51
        L1c:
            int r3 = r10.getType()
            r4 = 2
            r5 = 9
            r6 = 6
            r7 = 4
            if (r3 == 0) goto L3a
            if (r3 == r2) goto L38
            if (r3 == r7) goto L3a
            if (r3 == r1) goto L3a
            if (r3 == r6) goto L36
            if (r3 == r5) goto L34
            r0 = 8
            goto L51
        L34:
            r0 = 7
            goto L51
        L36:
            r0 = 5
            goto L51
        L38:
            r0 = 2
            goto L51
        L3a:
            int r10 = r10.getSubtype()
            switch(r10) {
                case 1: goto L4e;
                case 2: goto L4e;
                case 3: goto L4c;
                case 4: goto L4c;
                case 5: goto L4c;
                case 6: goto L4c;
                case 7: goto L4c;
                case 8: goto L4c;
                case 9: goto L4c;
                case 10: goto L4c;
                case 11: goto L4c;
                case 12: goto L4c;
                case 13: goto L36;
                case 14: goto L4c;
                case 15: goto L4c;
                case 16: goto L41;
                case 17: goto L4c;
                case 18: goto L38;
                case 19: goto L41;
                case 20: goto L43;
                default: goto L41;
            }
        L41:
            r0 = 6
            goto L51
        L43:
            int r10 = com.google.ads.interactivemedia.v3.internal.cq.a
            r2 = 29
            if (r10 < r2) goto L51
            r0 = 9
            goto L51
        L4c:
            r0 = 4
            goto L51
        L4e:
            r0 = 3
            goto L51
        L50:
        L51:
            int r10 = com.google.ads.interactivemedia.v3.internal.cq.a
            r2 = 31
            if (r10 < r2) goto L7a
            if (r0 != r1) goto L7a
            com.google.ads.interactivemedia.v3.internal.ch r10 = r8.a
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r9.getSystemService(r0)     // Catch: java.lang.RuntimeException -> L76
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.RuntimeException -> L76
            com.google.ads.interactivemedia.v3.internal.af.s(r0)     // Catch: java.lang.RuntimeException -> L76
            com.google.ads.interactivemedia.v3.internal.cf r2 = new com.google.ads.interactivemedia.v3.internal.cf     // Catch: java.lang.RuntimeException -> L76
            r2.<init>(r10)     // Catch: java.lang.RuntimeException -> L76
            java.util.concurrent.Executor r9 = com.google.ads.interactivemedia.v3.internal.I.a(r9)     // Catch: java.lang.RuntimeException -> L76
            com.google.ads.interactivemedia.v3.internal.J.a(r0, r9, r2)     // Catch: java.lang.RuntimeException -> L76
            com.google.ads.interactivemedia.v3.internal.K.a(r0, r2)     // Catch: java.lang.RuntimeException -> L76
            return
        L76:
            com.google.ads.interactivemedia.v3.internal.ch.c(r10, r1)
            return
        L7a:
            com.google.ads.interactivemedia.v3.internal.ch r9 = r8.a
            com.google.ads.interactivemedia.v3.internal.ch.c(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.cg.onReceive(android.content.Context, android.content.Intent):void");
    }
}

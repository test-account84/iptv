package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class tq implements wy, su {
    final /* synthetic */ tv a;
    private final Uri c;
    private final dv d;
    private final tl e;
    private final zk f;
    private volatile boolean h;
    private long j;
    private aae l;
    private boolean m;
    private final agp n;
    private final zy g = new zy();
    private boolean i = true;
    private final long b = sw.a();
    private dc k = i(0);

    public tq(tv tvVar, Uri uri, cy cyVar, tl tlVar, zk zkVar, agp agpVar, byte[] bArr) {
        this.a = tvVar;
        this.c = uri;
        this.d = new dv(cyVar);
        this.e = tlVar;
        this.f = zkVar;
        this.n = agpVar;
    }

    public static /* bridge */ /* synthetic */ long c(tq tqVar) {
        return tqVar.b;
    }

    public static /* bridge */ /* synthetic */ long d(tq tqVar) {
        return tqVar.j;
    }

    public static /* bridge */ /* synthetic */ dc f(tq tqVar) {
        return tqVar.k;
    }

    public static /* bridge */ /* synthetic */ dv g(tq tqVar) {
        return tqVar.d;
    }

    public static /* bridge */ /* synthetic */ void h(tq tqVar, long j, long j2) {
        tqVar.g.a = j;
        tqVar.j = j2;
        tqVar.i = true;
        tqVar.m = false;
    }

    private final dc i(long j) {
        db dbVar = new db();
        dbVar.i(this.c);
        dbVar.h(j);
        dbVar.f(null);
        dbVar.b(6);
        dbVar.e(tv.y());
        return dbVar.a();
    }

    public final void a(cj cjVar) {
        long max = !this.m ? this.j : Math.max(tv.K(this.a), this.j);
        int a = cjVar.a();
        aae aaeVar = this.l;
        af.s(aaeVar);
        aaeVar.e(cjVar, a);
        aaeVar.f(max, 1, a, 0, null);
        this.m = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089 A[Catch: all -> 0x0027, TryCatch #2 {all -> 0x0027, blocks: (B:6:0x000b, B:8:0x001f, B:10:0x002b, B:13:0x0040, B:15:0x0046, B:20:0x007e, B:22:0x0089, B:23:0x0095, B:25:0x009f, B:26:0x00ab, B:28:0x00b5, B:29:0x00c1, B:31:0x00cb, B:32:0x00dd, B:34:0x00e7, B:36:0x00ed, B:41:0x011c, B:42:0x0123, B:44:0x0130, B:46:0x0138, B:47:0x0155, B:49:0x0170, B:50:0x0175, B:52:0x0179, B:104:0x00f5, B:108:0x010c, B:117:0x0050, B:121:0x006a), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f A[Catch: all -> 0x0027, TryCatch #2 {all -> 0x0027, blocks: (B:6:0x000b, B:8:0x001f, B:10:0x002b, B:13:0x0040, B:15:0x0046, B:20:0x007e, B:22:0x0089, B:23:0x0095, B:25:0x009f, B:26:0x00ab, B:28:0x00b5, B:29:0x00c1, B:31:0x00cb, B:32:0x00dd, B:34:0x00e7, B:36:0x00ed, B:41:0x011c, B:42:0x0123, B:44:0x0130, B:46:0x0138, B:47:0x0155, B:49:0x0170, B:50:0x0175, B:52:0x0179, B:104:0x00f5, B:108:0x010c, B:117:0x0050, B:121:0x006a), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5 A[Catch: all -> 0x0027, TryCatch #2 {all -> 0x0027, blocks: (B:6:0x000b, B:8:0x001f, B:10:0x002b, B:13:0x0040, B:15:0x0046, B:20:0x007e, B:22:0x0089, B:23:0x0095, B:25:0x009f, B:26:0x00ab, B:28:0x00b5, B:29:0x00c1, B:31:0x00cb, B:32:0x00dd, B:34:0x00e7, B:36:0x00ed, B:41:0x011c, B:42:0x0123, B:44:0x0130, B:46:0x0138, B:47:0x0155, B:49:0x0170, B:50:0x0175, B:52:0x0179, B:104:0x00f5, B:108:0x010c, B:117:0x0050, B:121:0x006a), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cb A[Catch: all -> 0x0027, TryCatch #2 {all -> 0x0027, blocks: (B:6:0x000b, B:8:0x001f, B:10:0x002b, B:13:0x0040, B:15:0x0046, B:20:0x007e, B:22:0x0089, B:23:0x0095, B:25:0x009f, B:26:0x00ab, B:28:0x00b5, B:29:0x00c1, B:31:0x00cb, B:32:0x00dd, B:34:0x00e7, B:36:0x00ed, B:41:0x011c, B:42:0x0123, B:44:0x0130, B:46:0x0138, B:47:0x0155, B:49:0x0170, B:50:0x0175, B:52:0x0179, B:104:0x00f5, B:108:0x010c, B:117:0x0050, B:121:0x006a), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e7 A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #2 {all -> 0x0027, blocks: (B:6:0x000b, B:8:0x001f, B:10:0x002b, B:13:0x0040, B:15:0x0046, B:20:0x007e, B:22:0x0089, B:23:0x0095, B:25:0x009f, B:26:0x00ab, B:28:0x00b5, B:29:0x00c1, B:31:0x00cb, B:32:0x00dd, B:34:0x00e7, B:36:0x00ed, B:41:0x011c, B:42:0x0123, B:44:0x0130, B:46:0x0138, B:47:0x0155, B:49:0x0170, B:50:0x0175, B:52:0x0179, B:104:0x00f5, B:108:0x010c, B:117:0x0050, B:121:0x006a), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011c A[Catch: all -> 0x0027, TryCatch #2 {all -> 0x0027, blocks: (B:6:0x000b, B:8:0x001f, B:10:0x002b, B:13:0x0040, B:15:0x0046, B:20:0x007e, B:22:0x0089, B:23:0x0095, B:25:0x009f, B:26:0x00ab, B:28:0x00b5, B:29:0x00c1, B:31:0x00cb, B:32:0x00dd, B:34:0x00e7, B:36:0x00ed, B:41:0x011c, B:42:0x0123, B:44:0x0130, B:46:0x0138, B:47:0x0155, B:49:0x0170, B:50:0x0175, B:52:0x0179, B:104:0x00f5, B:108:0x010c, B:117:0x0050, B:121:0x006a), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0130 A[Catch: all -> 0x0027, TryCatch #2 {all -> 0x0027, blocks: (B:6:0x000b, B:8:0x001f, B:10:0x002b, B:13:0x0040, B:15:0x0046, B:20:0x007e, B:22:0x0089, B:23:0x0095, B:25:0x009f, B:26:0x00ab, B:28:0x00b5, B:29:0x00c1, B:31:0x00cb, B:32:0x00dd, B:34:0x00e7, B:36:0x00ed, B:41:0x011c, B:42:0x0123, B:44:0x0130, B:46:0x0138, B:47:0x0155, B:49:0x0170, B:50:0x0175, B:52:0x0179, B:104:0x00f5, B:108:0x010c, B:117:0x0050, B:121:0x006a), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0170 A[Catch: all -> 0x0027, TryCatch #2 {all -> 0x0027, blocks: (B:6:0x000b, B:8:0x001f, B:10:0x002b, B:13:0x0040, B:15:0x0046, B:20:0x007e, B:22:0x0089, B:23:0x0095, B:25:0x009f, B:26:0x00ab, B:28:0x00b5, B:29:0x00c1, B:31:0x00cb, B:32:0x00dd, B:34:0x00e7, B:36:0x00ed, B:41:0x011c, B:42:0x0123, B:44:0x0130, B:46:0x0138, B:47:0x0155, B:49:0x0170, B:50:0x0175, B:52:0x0179, B:104:0x00f5, B:108:0x010c, B:117:0x0050, B:121:0x006a), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0179 A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #2 {all -> 0x0027, blocks: (B:6:0x000b, B:8:0x001f, B:10:0x002b, B:13:0x0040, B:15:0x0046, B:20:0x007e, B:22:0x0089, B:23:0x0095, B:25:0x009f, B:26:0x00ab, B:28:0x00b5, B:29:0x00c1, B:31:0x00cb, B:32:0x00dd, B:34:0x00e7, B:36:0x00ed, B:41:0x011c, B:42:0x0123, B:44:0x0130, B:46:0x0138, B:47:0x0155, B:49:0x0170, B:50:0x0175, B:52:0x0179, B:104:0x00f5, B:108:0x010c, B:117:0x0050, B:121:0x006a), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0214 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[LOOP:0: B:2:0x0004->B:83:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.tq.e():void");
    }

    public final void r() {
        this.h = true;
    }
}

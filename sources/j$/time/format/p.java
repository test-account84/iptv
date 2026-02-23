package j$.time.format;

import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class p {
    private j$.time.temporal.o a;
    private DateTimeFormatter b;
    private int c;

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    p(j$.time.temporal.o r10, j$.time.format.DateTimeFormatter r11) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.p.<init>(j$.time.temporal.o, j$.time.format.DateTimeFormatter):void");
    }

    final void a() {
        this.c--;
    }

    final s b() {
        return this.b.c();
    }

    final Locale c() {
        return this.b.d();
    }

    final j$.time.temporal.o d() {
        return this.a;
    }

    final Long e(j$.time.temporal.r rVar) {
        int i = this.c;
        j$.time.temporal.o oVar = this.a;
        if (i <= 0 || oVar.f(rVar)) {
            return Long.valueOf(oVar.q(rVar));
        }
        return null;
    }

    final Object f(a aVar) {
        j$.time.temporal.o oVar = this.a;
        Object t = oVar.t(aVar);
        if (t != null || this.c != 0) {
            return t;
        }
        throw new j$.time.c("Unable to extract " + aVar + " from temporal " + oVar);
    }

    final void g() {
        this.c++;
    }

    public final String toString() {
        return this.a.toString();
    }
}

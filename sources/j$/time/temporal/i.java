package j$.time.temporal;

import j$.time.Duration;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
enum i implements u {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");

    private final String a;

    static {
        Duration duration = Duration.c;
    }

    i(String str) {
        this.a = str;
    }

    public final m i(m mVar, long j) {
        int i = c.a[ordinal()];
        if (i == 1) {
            return mVar.d(j$.com.android.tools.r8.a.i(mVar.i(r0), j), j.c);
        }
        if (i == 2) {
            return mVar.e(j / 4, b.YEARS).e((j % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    public final String toString() {
        return this.a;
    }
}

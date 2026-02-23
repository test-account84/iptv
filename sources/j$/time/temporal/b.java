package j$.time.temporal;

import j$.time.Duration;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public enum b implements u {
    NANOS("Nanos"),
    MICROS("Micros"),
    MILLIS("Millis"),
    SECONDS("Seconds"),
    MINUTES("Minutes"),
    HOURS("Hours"),
    HALF_DAYS("HalfDays"),
    DAYS("Days"),
    WEEKS("Weeks"),
    MONTHS("Months"),
    YEARS("Years"),
    DECADES("Decades"),
    CENTURIES("Centuries"),
    MILLENNIA("Millennia"),
    ERAS("Eras"),
    FOREVER("Forever");

    private final String a;

    static {
        Duration duration = Duration.c;
        Duration.q(Long.MAX_VALUE, 999999999L);
    }

    b(String str) {
        this.a = str;
    }

    public final m i(m mVar, long j) {
        return mVar.e(j, this);
    }

    public final String toString() {
        return this.a;
    }
}

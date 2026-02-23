package j$.util;

import j$.time.Instant;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class DateRetargetClass {
    public static Instant toInstant(Date date) {
        return Instant.E(date.getTime());
    }
}

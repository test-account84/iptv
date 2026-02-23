package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public interface n extends Comparable {
    o A(int i);

    String getId();

    b j(j$.time.temporal.o oVar);

    e m(LocalDateTime localDateTime);

    String p();

    k x(Instant instant, ZoneId zoneId);
}

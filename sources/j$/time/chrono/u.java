package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class u extends a implements Serializable {
    public static final u d = new u();
    private static final long serialVersionUID = -1440403870442975015L;

    private u() {
    }

    public static boolean l(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final o A(int i) {
        if (i == 0) {
            return v.BCE;
        }
        if (i == 1) {
            return v.CE;
        }
        throw new j$.time.c("Invalid era: " + i);
    }

    public final String getId() {
        return "ISO";
    }

    public final b j(j$.time.temporal.o oVar) {
        return j$.time.h.E(oVar);
    }

    public final e m(LocalDateTime localDateTime) {
        return LocalDateTime.D(localDateTime);
    }

    public final String p() {
        return "iso8601";
    }

    Object writeReplace() {
        return new G((byte) 1, this);
    }

    public final k x(Instant instant, ZoneId zoneId) {
        return j$.time.z.D(instant, zoneId);
    }
}

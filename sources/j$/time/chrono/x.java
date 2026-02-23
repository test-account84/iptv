package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class x extends a implements Serializable {
    public static final x d = new x();
    private static final long serialVersionUID = 459996390165777884L;

    private x() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final o A(int i) {
        return A.A(i);
    }

    public final String getId() {
        return "Japanese";
    }

    public final b j(j$.time.temporal.o oVar) {
        return oVar instanceof z ? (z) oVar : new z(j$.time.h.E(oVar));
    }

    public final j$.time.temporal.w l(j$.time.temporal.a aVar) {
        long J;
        long j;
        switch (w.a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new j$.time.temporal.v("Unsupported field: " + aVar);
            case 5:
                return j$.time.temporal.w.k(A.D(), 999999999 - A.m().p().J());
            case 6:
                return j$.time.temporal.w.k(A.C(), j$.time.temporal.a.DAY_OF_YEAR.i().d());
            case 7:
                J = z.d.J();
                j = 999999999;
                break;
            case 8:
                J = A.d.getValue();
                j = A.m().getValue();
                break;
            default:
                return aVar.i();
        }
        return j$.time.temporal.w.j(J, j);
    }

    public final String p() {
        return "japanese";
    }

    Object writeReplace() {
        return new G((byte) 1, this);
    }

    public final k x(Instant instant, ZoneId zoneId) {
        return m.F(this, instant, zoneId);
    }
}

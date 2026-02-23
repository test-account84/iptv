package j$.time;

import j$.util.Objects;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class x extends ZoneId {
    public static final /* synthetic */ int d = 0;
    private static final long serialVersionUID = 8386373296231747096L;
    private final String b;
    private final transient j$.time.zone.f c;

    x(String str, j$.time.zone.f fVar) {
        this.b = str;
        this.c = fVar;
    }

    static x H(String str, boolean z) {
        j$.time.zone.f fVar;
        Objects.a(str, "zoneId");
        int length = str.length();
        if (length < 2) {
            throw new c("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i == 0) && ((charAt < '0' || charAt > '9' || i == 0) && ((charAt != '~' || i == 0) && ((charAt != '.' || i == 0) && ((charAt != '_' || i == 0) && ((charAt != '+' || i == 0) && (charAt != '-' || i == 0))))))))) {
                throw new c("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
            }
        }
        try {
            fVar = j$.time.zone.j.a(str, true);
        } catch (j$.time.zone.g e) {
            if (z) {
                throw e;
            }
            fVar = null;
        }
        return new x(str, fVar);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 7, this);
    }

    public final j$.time.zone.f C() {
        j$.time.zone.f fVar = this.c;
        return fVar != null ? fVar : j$.time.zone.j.a(this.b, false);
    }

    final void G(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.b);
    }

    final void I(DataOutput dataOutput) {
        dataOutput.writeUTF(this.b);
    }

    public final String getId() {
        return this.b;
    }
}

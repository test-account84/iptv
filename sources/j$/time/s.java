package j$.time;

import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class s implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;
    private byte a;
    private Object b;

    public s() {
    }

    s(byte b, Object obj) {
        this.a = b;
        this.b = obj;
    }

    static Serializable a(ObjectInput objectInput) {
        return b(objectInput.readByte(), objectInput);
    }

    private static Serializable b(byte b, ObjectInput objectInput) {
        switch (b) {
            case 1:
                Duration duration = Duration.c;
                return Duration.q(objectInput.readLong(), objectInput.readInt());
            case 2:
                Instant instant = Instant.c;
                return Instant.F(objectInput.readLong(), objectInput.readInt());
            case 3:
                h hVar = h.d;
                return h.N(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return k.R(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.c;
                h hVar2 = h.d;
                return LocalDateTime.K(h.N(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.R(objectInput));
            case 6:
                return z.G(objectInput);
            case 7:
                int i = x.d;
                return ZoneId.D(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.N(objectInput);
            case 9:
                return q.E(objectInput);
            case 10:
                return OffsetDateTime.F(objectInput);
            case 11:
                int i2 = u.b;
                return u.C(objectInput.readInt());
            case 12:
                return w.G(objectInput);
            case 13:
                return o.C(objectInput);
            case 14:
                return r.a(objectInput);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.b;
    }

    public final void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.a = readByte;
        this.b = b(readByte, objectInput);
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        byte b = this.a;
        Object obj = this.b;
        objectOutput.writeByte(b);
        switch (b) {
            case 1:
                ((Duration) obj).t(objectOutput);
                return;
            case 2:
                ((Instant) obj).I(objectOutput);
                return;
            case 3:
                ((h) obj).Z(objectOutput);
                return;
            case 4:
                ((k) obj).W(objectOutput);
                return;
            case 5:
                ((LocalDateTime) obj).T(objectOutput);
                return;
            case 6:
                ((z) obj).J(objectOutput);
                return;
            case 7:
                ((x) obj).I(objectOutput);
                return;
            case 8:
                ((ZoneOffset) obj).O(objectOutput);
                return;
            case 9:
                ((q) obj).writeExternal(objectOutput);
                return;
            case 10:
                ((OffsetDateTime) obj).writeExternal(objectOutput);
                return;
            case 11:
                ((u) obj).G(objectOutput);
                return;
            case 12:
                ((w) obj).J(objectOutput);
                return;
            case 13:
                ((o) obj).D(objectOutput);
                return;
            case 14:
                ((r) obj).b(objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }
}

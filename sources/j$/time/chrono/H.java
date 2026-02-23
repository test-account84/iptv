package j$.time.chrono;

import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class h implements Serializable {
    public static final /* synthetic */ int e = 0;
    private static final long serialVersionUID = 57387258289L;
    private final n a;
    final int b;
    final int c;
    final int d;

    static {
        j$.com.android.tools.r8.a.k(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    h(n nVar, int i, int i2, int i3) {
        this.a = nVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void a(DataOutput dataOutput) {
        dataOutput.writeUTF(this.a.getId());
        dataOutput.writeInt(this.b);
        dataOutput.writeInt(this.c);
        dataOutput.writeInt(this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.b == hVar.b && this.c == hVar.c && this.d == hVar.d) {
            if (((a) this.a).equals(hVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((a) this.a).hashCode() ^ (Integer.rotateLeft(this.d, 16) + (Integer.rotateLeft(this.c, 8) + this.b));
    }

    public final String toString() {
        n nVar = this.a;
        int i = this.d;
        int i2 = this.c;
        int i3 = this.b;
        if (i3 == 0 && i2 == 0 && i == 0) {
            return ((a) nVar).getId() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(((a) nVar).getId());
        sb.append(" P");
        if (i3 != 0) {
            sb.append(i3);
            sb.append('Y');
        }
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        if (i != 0) {
            sb.append(i);
            sb.append('D');
        }
        return sb.toString();
    }

    protected Object writeReplace() {
        return new G((byte) 9, this);
    }
}

package j$.time;

import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class Duration implements Comparable, Serializable {
    public static final Duration c = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;
    private final long a;
    private final int b;

    static {
        BigInteger.valueOf(1000000000L);
    }

    private Duration(long j, int i) {
        this.a = j;
        this.b = i;
    }

    private static Duration i(long j, int i) {
        return (((long) i) | j) == 0 ? c : new Duration(j, i);
    }

    public static Duration l(long j) {
        return i(j, 0);
    }

    public static Duration q(long j, long j2) {
        return i(j$.com.android.tools.r8.a.i(j, j$.com.android.tools.r8.a.n(j2, 1000000000L)), (int) j$.com.android.tools.r8.a.m(j2, 1000000000L));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 1, this);
    }

    public final int compareTo(Object obj) {
        Duration duration = (Duration) obj;
        int compare = Long.compare(this.a, duration.a);
        return compare != 0 ? compare : this.b - duration.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.a == duration.a && this.b == duration.b;
    }

    public final int hashCode() {
        long j = this.a;
        return (this.b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public final long k() {
        return this.a;
    }

    final void t(DataOutput dataOutput) {
        dataOutput.writeLong(this.a);
        dataOutput.writeInt(this.b);
    }

    public long toMillis() {
        long j = this.b;
        long j2 = this.a;
        if (j2 < 0) {
            j2++;
            j -= 1000000000;
        }
        return j$.com.android.tools.r8.a.i(j$.com.android.tools.r8.a.o(j2, 1000), j / 1000000);
    }

    public final String toString() {
        if (this == c) {
            return "PT0S";
        }
        long j = this.a;
        int i = this.b;
        long j2 = (j >= 0 || i <= 0) ? j : 1 + j;
        long j3 = j2 / 3600;
        int i2 = (int) ((j2 % 3600) / 60);
        int i3 = (int) (j2 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j3 != 0) {
            sb.append(j3);
            sb.append('H');
        }
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        if (i3 == 0 && i == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (j >= 0 || i <= 0 || i3 != 0) {
            sb.append(i3);
        } else {
            sb.append("-0");
        }
        if (i > 0) {
            int length = sb.length();
            sb.append(j < 0 ? 2000000000 - i : i + 1000000000);
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }
}

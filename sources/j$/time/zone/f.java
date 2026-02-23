package j$.time.zone;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class f implements Serializable {
    private static final long[] i = new long[0];
    private static final e[] j = new e[0];
    private static final LocalDateTime[] k = new LocalDateTime[0];
    private static final b[] l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;
    private final long[] a;
    private final ZoneOffset[] b;
    private final long[] c;
    private final LocalDateTime[] d;
    private final ZoneOffset[] e;
    private final e[] f;
    private final TimeZone g;
    private final transient ConcurrentHashMap h = new ConcurrentHashMap();

    private f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.b = zoneOffsetArr;
        long[] jArr = i;
        this.a = jArr;
        this.c = jArr;
        this.d = k;
        this.e = zoneOffsetArr;
        this.f = j;
        this.g = null;
    }

    f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {j(timeZone.getRawOffset())};
        this.b = zoneOffsetArr;
        long[] jArr = i;
        this.a = jArr;
        this.c = jArr;
        this.d = k;
        this.e = zoneOffsetArr;
        this.f = j;
        this.g = timeZone;
    }

    private f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        LocalDateTime k2;
        this.a = jArr;
        this.b = zoneOffsetArr;
        this.c = jArr2;
        this.e = zoneOffsetArr2;
        this.f = eVarArr;
        if (jArr2.length == 0) {
            this.d = k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < jArr2.length) {
                int i3 = i2 + 1;
                b bVar = new b(jArr2[i2], zoneOffsetArr2[i2], zoneOffsetArr2[i3]);
                if (bVar.y()) {
                    arrayList.add(bVar.k());
                    k2 = bVar.i();
                } else {
                    arrayList.add(bVar.i());
                    k2 = bVar.k();
                }
                arrayList.add(k2);
                i2 = i3;
            }
            this.d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.g = null;
    }

    private static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime k2 = bVar.k();
        boolean y = bVar.y();
        boolean I = localDateTime.I(k2);
        return y ? I ? bVar.t() : localDateTime.I(bVar.i()) ? bVar : bVar.q() : !I ? bVar.q() : localDateTime.I(bVar.i()) ? bVar.t() : bVar;
    }

    private b[] b(int i2) {
        long j2;
        Integer valueOf = Integer.valueOf(i2);
        ConcurrentHashMap concurrentHashMap = this.h;
        b[] bVarArr = (b[]) concurrentHashMap.get(valueOf);
        if (bVarArr != null) {
            return bVarArr;
        }
        TimeZone timeZone = this.g;
        if (timeZone == null) {
            e[] eVarArr = this.f;
            b[] bVarArr2 = new b[eVarArr.length];
            for (int i3 = 0; i3 < eVarArr.length; i3++) {
                bVarArr2[i3] = eVarArr[i3].a(i2);
            }
            if (i2 < 2100) {
                concurrentHashMap.putIfAbsent(valueOf, bVarArr2);
            }
            return bVarArr2;
        }
        b[] bVarArr3 = l;
        if (i2 < 1800) {
            return bVarArr3;
        }
        long n = j$.time.chrono.i.n(LocalDateTime.J(i2 - 1), this.b[0]);
        int offset = timeZone.getOffset(n * 1000);
        long j3 = 31968000 + n;
        while (n < j3) {
            long j4 = 7776000 + n;
            long j5 = n;
            if (offset != timeZone.getOffset(j4 * 1000)) {
                n = j5;
                while (j4 - n > 1) {
                    int i4 = offset;
                    long j6 = j3;
                    long n2 = j$.com.android.tools.r8.a.n(j4 + n, 2L);
                    if (timeZone.getOffset(n2 * 1000) == i4) {
                        n = n2;
                    } else {
                        j4 = n2;
                    }
                    offset = i4;
                    j3 = j6;
                }
                j2 = j3;
                int i5 = offset;
                if (timeZone.getOffset(n * 1000) == i5) {
                    n = j4;
                }
                ZoneOffset j7 = j(i5);
                offset = timeZone.getOffset(n * 1000);
                ZoneOffset j8 = j(offset);
                if (c(n, j8) == i2) {
                    bVarArr3 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length + 1);
                    bVarArr3[bVarArr3.length - 1] = new b(n, j7, j8);
                }
            } else {
                j2 = j3;
                n = j4;
            }
            j3 = j2;
        }
        if (1916 <= i2 && i2 < 2100) {
            concurrentHashMap.putIfAbsent(valueOf, bVarArr3);
        }
        return bVarArr3;
    }

    private static int c(long j2, ZoneOffset zoneOffset) {
        return j$.time.h.P(j$.com.android.tools.r8.a.n(j2 + zoneOffset.I(), 86400)).J();
    }

    private Object e(LocalDateTime localDateTime) {
        Object obj = null;
        ZoneOffset[] zoneOffsetArr = this.b;
        int i2 = 0;
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            b[] b = b(localDateTime.G());
            if (b.length == 0) {
                return j(timeZone.getOffset(j$.time.chrono.i.n(localDateTime, zoneOffsetArr[0]) * 1000));
            }
            int length = b.length;
            while (i2 < length) {
                b bVar = b[i2];
                Object a = a(localDateTime, bVar);
                if ((a instanceof b) || a.equals(bVar.t())) {
                    return a;
                }
                i2++;
                obj = a;
            }
            return obj;
        }
        if (this.c.length == 0) {
            return zoneOffsetArr[0];
        }
        int length2 = this.f.length;
        LocalDateTime[] localDateTimeArr = this.d;
        if (length2 > 0 && localDateTime.H(localDateTimeArr[localDateTimeArr.length - 1])) {
            b[] b2 = b(localDateTime.G());
            int length3 = b2.length;
            while (i2 < length3) {
                b bVar2 = b2[i2];
                Object a2 = a(localDateTime, bVar2);
                if ((a2 instanceof b) || a2.equals(bVar2.t())) {
                    return a2;
                }
                i2++;
                obj = a2;
            }
            return obj;
        }
        int binarySearch = Arrays.binarySearch(localDateTimeArr, localDateTime);
        ZoneOffset[] zoneOffsetArr2 = this.e;
        if (binarySearch == -1) {
            return zoneOffsetArr2[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else if (binarySearch < localDateTimeArr.length - 1) {
            int i3 = binarySearch + 1;
            if (localDateTimeArr[binarySearch].equals(localDateTimeArr[i3])) {
                binarySearch = i3;
            }
        }
        if ((binarySearch & 1) != 0) {
            return zoneOffsetArr2[(binarySearch / 2) + 1];
        }
        LocalDateTime localDateTime2 = localDateTimeArr[binarySearch];
        LocalDateTime localDateTime3 = localDateTimeArr[binarySearch + 1];
        int i4 = binarySearch / 2;
        ZoneOffset zoneOffset = zoneOffsetArr2[i4];
        ZoneOffset zoneOffset2 = zoneOffsetArr2[i4 + 1];
        return zoneOffset2.I() > zoneOffset.I() ? new b(localDateTime2, zoneOffset, zoneOffset2) : new b(localDateTime3, zoneOffset, zoneOffset2);
    }

    public static f i(ZoneOffset zoneOffset) {
        Objects.a(zoneOffset, "offset");
        return new f(zoneOffset);
    }

    private static ZoneOffset j(int i2) {
        return ZoneOffset.L(i2 / 1000);
    }

    static f k(DataInput dataInput) {
        int readInt = dataInput.readInt();
        long[] jArr = i;
        long[] jArr2 = readInt == 0 ? jArr : new long[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            jArr2[i2] = a.a(dataInput);
        }
        int i3 = readInt + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            zoneOffsetArr[i4] = a.b(dataInput);
        }
        int readInt2 = dataInput.readInt();
        if (readInt2 != 0) {
            jArr = new long[readInt2];
        }
        long[] jArr3 = jArr;
        for (int i5 = 0; i5 < readInt2; i5++) {
            jArr3[i5] = a.a(dataInput);
        }
        int i6 = readInt2 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            zoneOffsetArr2[i7] = a.b(dataInput);
        }
        int readByte = dataInput.readByte();
        e[] eVarArr = readByte == 0 ? j : new e[readByte];
        for (int i8 = 0; i8 < readByte; i8++) {
            eVarArr[i8] = e.b(dataInput);
        }
        return new f(jArr2, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.g != null ? (byte) 100 : (byte) 1, this);
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            return j(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.c;
        if (jArr.length == 0) {
            return this.b[0];
        }
        long epochSecond = instant.getEpochSecond();
        int length = this.f.length;
        ZoneOffset[] zoneOffsetArr = this.e;
        if (length <= 0 || epochSecond <= jArr[jArr.length - 1]) {
            int binarySearch = Arrays.binarySearch(jArr, epochSecond);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            return zoneOffsetArr[binarySearch + 1];
        }
        b[] b = b(c(epochSecond, zoneOffsetArr[zoneOffsetArr.length - 1]));
        b bVar = null;
        for (int i2 = 0; i2 < b.length; i2++) {
            bVar = b[i2];
            if (epochSecond < bVar.B()) {
                return bVar.t();
            }
        }
        return bVar.q();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Objects.equals(this.g, fVar.g) && Arrays.equals(this.a, fVar.a) && Arrays.equals(this.b, fVar.b) && Arrays.equals(this.c, fVar.c) && Arrays.equals(this.e, fVar.e) && Arrays.equals(this.f, fVar.f);
    }

    public final b f(LocalDateTime localDateTime) {
        Object e = e(localDateTime);
        if (e instanceof b) {
            return (b) e;
        }
        return null;
    }

    public final List g(LocalDateTime localDateTime) {
        Object e = e(localDateTime);
        return e instanceof b ? ((b) e).u() : Collections.singletonList((ZoneOffset) e);
    }

    public final boolean h() {
        b bVar;
        TimeZone timeZone = this.g;
        if (timeZone == null) {
            return this.c.length == 0;
        }
        if (timeZone.useDaylightTime() || timeZone.getDSTSavings() != 0) {
            return false;
        }
        Instant now = Instant.now();
        long epochSecond = now.getEpochSecond();
        if (now.D() > 0 && epochSecond < Long.MAX_VALUE) {
            epochSecond++;
        }
        int c = c(epochSecond, d(now));
        b[] b = b(c);
        int length = b.length - 1;
        while (true) {
            if (length >= 0) {
                if (epochSecond > b[length].B()) {
                    bVar = b[length];
                    break;
                }
                length--;
            } else if (c > 1800) {
                b[] b2 = b(c - 1);
                int length2 = b2.length - 1;
                while (true) {
                    if (length2 < 0) {
                        int offset = timeZone.getOffset((epochSecond - 1) * 1000);
                        long r = j$.time.h.N(1800, 1, 1).r() * 86400;
                        for (long min = Math.min(epochSecond - 31104000, (j$.time.b.b().a() / 1000) + 31968000); r <= min; min -= 7776000) {
                            int offset2 = timeZone.getOffset(min * 1000);
                            if (offset != offset2) {
                                int c2 = c(min, j(offset2));
                                b[] b3 = b(c2 + 1);
                                int length3 = b3.length - 1;
                                while (true) {
                                    if (length3 < 0) {
                                        b[] b4 = b(c2);
                                        bVar = b4[b4.length - 1];
                                        break;
                                    }
                                    if (epochSecond > b3[length3].B()) {
                                        bVar = b3[length3];
                                        break;
                                    }
                                    length3--;
                                }
                            }
                        }
                    } else {
                        if (epochSecond > b2[length2].B()) {
                            bVar = b2[length2];
                            break;
                        }
                        length2--;
                    }
                }
                bVar = null;
            } else {
                bVar = null;
            }
        }
        return bVar == null;
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.g) ^ Arrays.hashCode(this.a)) ^ Arrays.hashCode(this.b)) ^ Arrays.hashCode(this.c)) ^ Arrays.hashCode(this.e)) ^ Arrays.hashCode(this.f);
    }

    final void l(DataOutput dataOutput) {
        long[] jArr = this.a;
        dataOutput.writeInt(jArr.length);
        for (long j2 : jArr) {
            a.c(j2, dataOutput);
        }
        for (ZoneOffset zoneOffset : this.b) {
            a.d(zoneOffset, dataOutput);
        }
        long[] jArr2 = this.c;
        dataOutput.writeInt(jArr2.length);
        for (long j3 : jArr2) {
            a.c(j3, dataOutput);
        }
        for (ZoneOffset zoneOffset2 : this.e) {
            a.d(zoneOffset2, dataOutput);
        }
        e[] eVarArr = this.f;
        dataOutput.writeByte(eVarArr.length);
        for (e eVar : eVarArr) {
            eVar.c(dataOutput);
        }
    }

    final void m(DataOutput dataOutput) {
        dataOutput.writeUTF(this.g.getID());
    }

    public final String toString() {
        StringBuilder sb;
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            String id = timeZone.getID();
            sb = new StringBuilder("ZoneRules[timeZone=");
            sb.append(id);
        } else {
            ZoneOffset zoneOffset = this.b[r1.length - 1];
            sb = new StringBuilder("ZoneRules[currentStandardOffset=");
            sb.append(zoneOffset);
        }
        sb.append("]");
        return sb.toString();
    }
}

package l3;

import d4.B;
import d4.M;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class l {

    public static class a {
        public final UUID a;
        public final int b;
        public final byte[] c;

        public a(UUID uuid, int i, byte[] bArr) {
            this.a = uuid;
            this.b = i;
            this.c = bArr;
        }

        public static /* synthetic */ UUID a(a aVar) {
            return aVar.a;
        }

        public static /* synthetic */ int b(a aVar) {
            return aVar.b;
        }

        public static /* synthetic */ byte[] c(a aVar) {
            return aVar.c;
        }
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    public static a d(byte[] bArr) {
        M m = new M(bArr);
        if (m.g() < 32) {
            return null;
        }
        m.U(0);
        if (m.q() != m.a() + 4 || m.q() != 1886614376) {
            return null;
        }
        int c = l3.a.c(m.q());
        if (c > 1) {
            B.j("PsshAtomUtil", "Unsupported pssh version: " + c);
            return null;
        }
        UUID uuid = new UUID(m.A(), m.A());
        if (c == 1) {
            m.V(m.L() * 16);
        }
        int L = m.L();
        if (L != m.a()) {
            return null;
        }
        byte[] bArr2 = new byte[L];
        m.l(bArr2, 0, L);
        return new a(uuid, c, bArr2);
    }

    public static byte[] e(byte[] bArr, UUID uuid) {
        a d = d(bArr);
        if (d == null) {
            return null;
        }
        if (uuid.equals(a.a(d))) {
            return a.c(d);
        }
        B.j("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + a.a(d) + ".");
        return null;
    }

    public static UUID f(byte[] bArr) {
        a d = d(bArr);
        if (d == null) {
            return null;
        }
        return a.a(d);
    }

    public static int g(byte[] bArr) {
        a d = d(bArr);
        if (d == null) {
            return -1;
        }
        return a.b(d);
    }
}

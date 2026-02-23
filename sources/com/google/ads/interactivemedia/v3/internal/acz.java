package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class acz {
    public static int a(byte[] bArr) {
        acy g = g(bArr);
        if (g == null) {
            return -1;
        }
        return acy.a(g);
    }

    public static UUID b(byte[] bArr) {
        acy g = g(bArr);
        if (g == null) {
            return null;
        }
        return acy.b(g);
    }

    public static boolean c(byte[] bArr) {
        return g(bArr) != null;
    }

    public static byte[] d(UUID uuid, byte[] bArr) {
        return e(uuid, null, bArr);
    }

    public static byte[] e(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length;
        int length2 = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length2 += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length2);
        allocate.putInt(length2);
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
        if (bArr != null && (length = bArr.length) != 0) {
            allocate.putInt(length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static byte[] f(byte[] bArr, UUID uuid) {
        acy g = g(bArr);
        if (g == null) {
            return null;
        }
        if (uuid.equals(acy.b(g))) {
            return acy.c(g);
        }
        cd.e("PsshAtomUtil", "UUID mismatch. Expected: " + String.valueOf(uuid) + ", got: " + acy.b(g).toString() + ".");
        return null;
    }

    private static acy g(byte[] bArr) {
        cj cjVar = new cj(bArr);
        if (cjVar.d() < 32) {
            return null;
        }
        cjVar.F(0);
        if (cjVar.e() != cjVar.a() + 4 || cjVar.e() != 1886614376) {
            return null;
        }
        int f = ace.f(cjVar.e());
        if (f > 1) {
            cd.e("PsshAtomUtil", "Unsupported pssh version: " + f);
            return null;
        }
        UUID uuid = new UUID(cjVar.o(), cjVar.o());
        if (f == 1) {
            cjVar.G(cjVar.l() * 16);
        }
        int l = cjVar.l();
        if (l != cjVar.a()) {
            return null;
        }
        byte[] bArr2 = new byte[l];
        cjVar.A(bArr2, 0, l);
        return new acy(uuid, f, bArr2);
    }
}

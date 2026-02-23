package f3;

import O2.z0;
import d4.B;
import d4.M;
import d4.k0;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g implements a {
    public final z0 a;

    public g(z0 z0Var) {
        this.a = z0Var;
    }

    public static String a(int i) {
        switch (i) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return "video/mp4v-es";
            case 826496577:
            case 828601953:
            case 875967048:
                return "video/avc";
            case 842289229:
                return "video/mp42";
            case 859066445:
                return "video/mp43";
            case 1196444237:
            case 1735420525:
                return "video/mjpeg";
            default:
                return null;
        }
    }

    public static String b(int i) {
        if (i == 1) {
            return "audio/raw";
        }
        if (i == 85) {
            return "audio/mpeg";
        }
        if (i == 255) {
            return "audio/mp4a-latm";
        }
        if (i == 8192) {
            return "audio/ac3";
        }
        if (i != 8193) {
            return null;
        }
        return "audio/vnd.dts";
    }

    public static a c(M m) {
        m.V(4);
        int u = m.u();
        int u2 = m.u();
        m.V(4);
        int u3 = m.u();
        String a = a(u3);
        if (a != null) {
            z0.b bVar = new z0.b();
            bVar.n0(u).S(u2).g0(a);
            return new g(bVar.G());
        }
        B.j("StreamFormatChunk", "Ignoring track with unsupported compression " + u3);
        return null;
    }

    public static a d(int i, M m) {
        if (i == 2) {
            return c(m);
        }
        if (i == 1) {
            return e(m);
        }
        B.j("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + k0.r0(i));
        return null;
    }

    public static a e(M m) {
        int z = m.z();
        String b = b(z);
        if (b == null) {
            B.j("StreamFormatChunk", "Ignoring track with unsupported format tag " + z);
            return null;
        }
        int z2 = m.z();
        int u = m.u();
        m.V(6);
        int h0 = k0.h0(m.N());
        int z3 = m.z();
        byte[] bArr = new byte[z3];
        m.l(bArr, 0, z3);
        z0.b bVar = new z0.b();
        bVar.g0(b).J(z2).h0(u);
        if ("audio/raw".equals(b) && h0 != 0) {
            bVar.a0(h0);
        }
        if ("audio/mp4a-latm".equals(b) && z3 > 0) {
            bVar.V(y.A(bArr));
        }
        return new g(bVar.G());
    }

    public int getType() {
        return 1718776947;
    }
}

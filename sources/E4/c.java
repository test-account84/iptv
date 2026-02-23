package e4;

import O2.n;
import android.os.Bundle;
import d4.k0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements O2.n {
    public static final c g = new c(1, 2, 3, null);
    public static final c h = new b().c(1).b(1).d(2).a();
    public static final String i = k0.A0(0);
    public static final String j = k0.A0(1);
    public static final String k = k0.A0(2);
    public static final String l = k0.A0(3);
    public static final n.a m = new e4.b();
    public final int a;
    public final int c;
    public final int d;
    public final byte[] e;
    public int f;

    public static final class b {
        public int a;
        public int b;
        public int c;
        public byte[] d;

        public b() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
        }

        public c a() {
            return new c(this.a, this.b, this.c, this.d);
        }

        public b b(int i) {
            this.b = i;
            return this;
        }

        public b c(int i) {
            this.a = i;
            return this;
        }

        public b d(int i) {
            this.c = i;
            return this;
        }

        public b(c cVar) {
            this.a = cVar.a;
            this.b = cVar.c;
            this.c = cVar.d;
            this.d = cVar.e;
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(int i2, int i3, int i4, byte[] bArr) {
        this.a = i2;
        this.c = i3;
        this.d = i4;
        this.e = bArr;
    }

    public static /* synthetic */ c a(Bundle bundle) {
        return k(bundle);
    }

    public static String c(int i2) {
        return i2 != -1 ? i2 != 1 ? i2 != 2 ? "Undefined color range" : "Limited range" : "Full range" : "Unset color range";
    }

    public static String d(int i2) {
        return i2 != -1 ? i2 != 6 ? i2 != 1 ? i2 != 2 ? "Undefined color space" : "BT601" : "BT709" : "BT2020" : "Unset color space";
    }

    public static String e(int i2) {
        return i2 != -1 ? i2 != 10 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 6 ? i2 != 7 ? "Undefined color transfer" : "HLG" : "ST2084 PQ" : "SDR SMPTE 170M" : "sRGB" : "Linear" : "Gamma 2.2" : "Unset color transfer";
    }

    public static boolean f(c cVar) {
        int i2;
        return cVar != null && ((i2 = cVar.d) == 7 || i2 == 6);
    }

    public static int i(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 9) {
            return (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int j(int i2) {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 4) {
            return 10;
        }
        if (i2 == 13) {
            return 2;
        }
        if (i2 == 16) {
            return 6;
        }
        if (i2 != 18) {
            return (i2 == 6 || i2 == 7) ? 3 : -1;
        }
        return 7;
    }

    public static /* synthetic */ c k(Bundle bundle) {
        return new c(bundle.getInt(i, -1), bundle.getInt(j, -1), bundle.getInt(k, -1), bundle.getByteArray(l));
    }

    public b b() {
        return new b(this, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.c == cVar.c && this.d == cVar.d && Arrays.equals(this.e, cVar.e);
    }

    public boolean g() {
        return (this.a == -1 || this.c == -1 || this.d == -1) ? false : true;
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(i, this.a);
        bundle.putInt(j, this.c);
        bundle.putInt(k, this.d);
        bundle.putByteArray(l, this.e);
        return bundle;
    }

    public int hashCode() {
        if (this.f == 0) {
            this.f = ((((((527 + this.a) * 31) + this.c) * 31) + this.d) * 31) + Arrays.hashCode(this.e);
        }
        return this.f;
    }

    public String l() {
        return !g() ? "NA" : k0.D("%s/%s/%s", d(this.a), c(this.c), e(this.d));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(d(this.a));
        sb.append(", ");
        sb.append(c(this.c));
        sb.append(", ");
        sb.append(e(this.d));
        sb.append(", ");
        sb.append(this.e != null);
        sb.append(")");
        return sb.toString();
    }
}

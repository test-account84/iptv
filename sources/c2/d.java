package C2;

import C2.p;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d extends p {
    public final String a;
    public final byte[] b;
    public final z2.d c;

    public static final class b extends p.a {
        public String a;
        public byte[] b;
        public z2.d c;

        public p a() {
            String str = "";
            if (this.a == null) {
                str = " backendName";
            }
            if (this.c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.a, this.b, this.c, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public p.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.a = str;
            return this;
        }

        public p.a c(byte[] bArr) {
            this.b = bArr;
            return this;
        }

        public p.a d(z2.d dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null priority");
            }
            this.c = dVar;
            return this;
        }
    }

    public d(String str, byte[] bArr, z2.d dVar) {
        this.a = str;
        this.b = bArr;
        this.c = dVar;
    }

    public String b() {
        return this.a;
    }

    public byte[] c() {
        return this.b;
    }

    public z2.d d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.a.equals(pVar.b())) {
            if (Arrays.equals(this.b, pVar instanceof d ? ((d) pVar).b : pVar.c()) && this.c.equals(pVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b)) * 1000003) ^ this.c.hashCode();
    }

    public /* synthetic */ d(String str, byte[] bArr, z2.d dVar, a aVar) {
        this(str, bArr, dVar);
    }
}

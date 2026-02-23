package Q5;

import Q5.B;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g extends B.d.b {
    public final String a;
    public final byte[] b;

    public static final class b extends B.d.b.a {
        public String a;
        public byte[] b;

        public B.d.b a() {
            String str = "";
            if (this.a == null) {
                str = " filename";
            }
            if (this.b == null) {
                str = str + " contents";
            }
            if (str.isEmpty()) {
                return new g(this.a, this.b, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.d.b.a b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.b = bArr;
            return this;
        }

        public B.d.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.a = str;
            return this;
        }
    }

    public g(String str, byte[] bArr) {
        this.a = str;
        this.b = bArr;
    }

    public byte[] b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.d.b)) {
            return false;
        }
        B.d.b bVar = (B.d.b) obj;
        if (this.a.equals(bVar.c())) {
            if (Arrays.equals(this.b, bVar instanceof g ? ((g) bVar).b : bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        return "File{filename=" + this.a + ", contents=" + Arrays.toString(this.b) + "}";
    }

    public /* synthetic */ g(String str, byte[] bArr, a aVar) {
        this(str, bArr);
    }
}

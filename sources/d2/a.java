package D2;

import D2.f;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends f {
    public final Iterable a;
    public final byte[] b;

    public static final class b extends f.a {
        public Iterable a;
        public byte[] b;

        public f a() {
            String str = "";
            if (this.a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public f.a b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.a = iterable;
            return this;
        }

        public f.a c(byte[] bArr) {
            this.b = bArr;
            return this;
        }
    }

    public a(Iterable iterable, byte[] bArr) {
        this.a = iterable;
        this.b = bArr;
    }

    public Iterable b() {
        return this.a;
    }

    public byte[] c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.a.equals(fVar.b())) {
            if (Arrays.equals(this.b, fVar instanceof a ? ((a) fVar).b : fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.a + ", extras=" + Arrays.toString(this.b) + "}";
    }

    public /* synthetic */ a(Iterable iterable, byte[] bArr, a aVar) {
        this(iterable, bArr);
    }
}

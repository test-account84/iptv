package f6;

import f6.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a {
    public int a;
    public d.a b = d.a.DEFAULT;

    public static final class a implements d {
        public final int a;
        public final d.a b;

        public a(int i, d.a aVar) {
            this.a = i;
            this.b = aVar;
        }

        public Class annotationType() {
            return d.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.tag() && this.b.equals(dVar.intEncoding());
        }

        public int hashCode() {
            return (14552422 ^ this.a) + (this.b.hashCode() ^ 2041407134);
        }

        public d.a intEncoding() {
            return this.b;
        }

        public int tag() {
            return this.a;
        }

        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.a + "intEncoding=" + this.b + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public d a() {
        return new a(this.a, this.b);
    }

    public a c(int i) {
        this.a = i;
        return this;
    }
}

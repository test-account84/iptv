package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l extends B.e.d {
    public final long a;
    public final String b;
    public final B.e.d.a c;
    public final B.e.d.c d;
    public final B.e.d.d e;

    public static final class b extends B.e.d.b {
        public Long a;
        public String b;
        public B.e.d.a c;
        public B.e.d.c d;
        public B.e.d.d e;

        public b() {
        }

        public B.e.d a() {
            String str = "";
            if (this.a == null) {
                str = " timestamp";
            }
            if (this.b == null) {
                str = str + " type";
            }
            if (this.c == null) {
                str = str + " app";
            }
            if (this.d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new l(this.a.longValue(), this.b, this.c, this.d, this.e, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public B.e.d.b b(B.e.d.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.c = aVar;
            return this;
        }

        public B.e.d.b c(B.e.d.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null device");
            }
            this.d = cVar;
            return this;
        }

        public B.e.d.b d(B.e.d.d dVar) {
            this.e = dVar;
            return this;
        }

        public B.e.d.b e(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        public B.e.d.b f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.b = str;
            return this;
        }

        public b(B.e.d dVar) {
            this.a = Long.valueOf(dVar.e());
            this.b = dVar.f();
            this.c = dVar.b();
            this.d = dVar.c();
            this.e = dVar.d();
        }

        public /* synthetic */ b(B.e.d dVar, a aVar) {
            this(dVar);
        }
    }

    public l(long j, String str, B.e.d.a aVar, B.e.d.c cVar, B.e.d.d dVar) {
        this.a = j;
        this.b = str;
        this.c = aVar;
        this.d = cVar;
        this.e = dVar;
    }

    public B.e.d.a b() {
        return this.c;
    }

    public B.e.d.c c() {
        return this.d;
    }

    public B.e.d.d d() {
        return this.e;
    }

    public long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B.e.d)) {
            return false;
        }
        B.e.d dVar = (B.e.d) obj;
        if (this.a == dVar.e() && this.b.equals(dVar.f()) && this.c.equals(dVar.b()) && this.d.equals(dVar.c())) {
            B.e.d.d dVar2 = this.e;
            B.e.d.d d = dVar.d();
            if (dVar2 == null) {
                if (d == null) {
                    return true;
                }
            } else if (dVar2.equals(d)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.b;
    }

    public B.e.d.b g() {
        return new b(this, null);
    }

    public int hashCode() {
        long j = this.a;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        B.e.d.d dVar = this.e;
        return (dVar == null ? 0 : dVar.hashCode()) ^ hashCode;
    }

    public String toString() {
        return "Event{timestamp=" + this.a + ", type=" + this.b + ", app=" + this.c + ", device=" + this.d + ", log=" + this.e + "}";
    }

    public /* synthetic */ l(long j, String str, B.e.d.a aVar, B.e.d.c cVar, B.e.d.d dVar, a aVar2) {
        this(j, str, aVar, cVar, dVar);
    }
}

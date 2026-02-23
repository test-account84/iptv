package m6;

import m6.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends f {
    public final String a;
    public final long b;
    public final f.b c;

    public static final class b extends f.a {
        public String a;
        public Long b;
        public f.b c;

        public f a() {
            String str = "";
            if (this.b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.a, this.b.longValue(), this.c, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public f.a b(f.b bVar) {
            this.c = bVar;
            return this;
        }

        public f.a c(String str) {
            this.a = str;
            return this;
        }

        public f.a d(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    public b(String str, long j, f.b bVar) {
        this.a = str;
        this.b = j;
        this.c = bVar;
    }

    public f.b b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public long d() {
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
        String str = this.a;
        if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
            if (this.b == fVar.d()) {
                f.b bVar = this.c;
                f.b b2 = fVar.b();
                if (bVar == null) {
                    if (b2 == null) {
                        return true;
                    }
                } else if (bVar.equals(b2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.b;
        int i = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        f.b bVar = this.c;
        return i ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.a + ", tokenExpirationTimestamp=" + this.b + ", responseCode=" + this.c + "}";
    }

    public /* synthetic */ b(String str, long j, f.b bVar, a aVar) {
        this(str, j, bVar);
    }
}

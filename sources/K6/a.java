package k6;

import k6.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends m {
    public final String a;
    public final long b;
    public final long c;

    public static final class b extends m.a {
        public String a;
        public Long b;
        public Long c;

        public m a() {
            String str = "";
            if (this.a == null) {
                str = " token";
            }
            if (this.b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b.longValue(), this.c.longValue(), null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public m.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.a = str;
            return this;
        }

        public m.a c(long j) {
            this.c = Long.valueOf(j);
            return this;
        }

        public m.a d(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    public a(String str, long j, long j2) {
        this.a = str;
        this.b = j;
        this.c = j2;
    }

    public String b() {
        return this.a;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.a.equals(mVar.b()) && this.b == mVar.d() && this.c == mVar.c();
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j = this.b;
        long j2 = this.c;
        return ((hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.a + ", tokenExpirationTimestamp=" + this.b + ", tokenCreationTimestamp=" + this.c + "}";
    }

    public /* synthetic */ a(String str, long j, long j2, a aVar) {
        this(str, j, j2);
    }
}

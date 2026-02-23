package K2;

import K2.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends e {
    public final long b;
    public final int c;
    public final int d;
    public final long e;
    public final int f;

    public static final class b extends e.a {
        public Long a;
        public Integer b;
        public Integer c;
        public Long d;
        public Integer e;

        public e a() {
            String str = "";
            if (this.a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.b == null) {
                str = str + " loadBatchSize";
            }
            if (this.c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.a.longValue(), this.b.intValue(), this.c.intValue(), this.d.longValue(), this.e.intValue(), null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public e.a b(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public e.a c(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        public e.a d(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public e.a e(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public e.a f(long j) {
            this.a = Long.valueOf(j);
            return this;
        }
    }

    public a(long j, int i, int i2, long j2, int i3) {
        this.b = j;
        this.c = i;
        this.d = i2;
        this.e = j2;
        this.f = i3;
    }

    public int b() {
        return this.d;
    }

    public long c() {
        return this.e;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.b == eVar.f() && this.c == eVar.d() && this.d == eVar.b() && this.e == eVar.c() && this.f == eVar.e();
    }

    public long f() {
        return this.b;
    }

    public int hashCode() {
        long j = this.b;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003;
        long j2 = this.e;
        return this.f ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.b + ", loadBatchSize=" + this.c + ", criticalSectionEnterTimeoutMs=" + this.d + ", eventCleanUpAge=" + this.e + ", maxBlobByteSizePerRow=" + this.f + "}";
    }

    public /* synthetic */ a(long j, int i, int i2, long j2, int i3, a aVar) {
        this(j, i, i2, j2, i3);
    }
}

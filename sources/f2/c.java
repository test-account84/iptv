package F2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c {
    public static final c c = new a().a();
    public final long a;
    public final b b;

    public static final class a {
        public long a = 0;
        public b b = b.REASON_UNKNOWN;

        public c a() {
            return new c(this.a, this.b);
        }

        public a b(long j) {
            this.a = j;
            return this;
        }

        public a c(b bVar) {
            this.b = bVar;
            return this;
        }
    }

    public enum b implements f6.c {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);

        private final int number_;

        b(int i) {
            this.number_ = i;
        }

        public int getNumber() {
            return this.number_;
        }
    }

    public c(long j, b bVar) {
        this.a = j;
        this.b = bVar;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.a;
    }

    public b b() {
        return this.b;
    }
}

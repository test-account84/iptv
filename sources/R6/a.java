package r6;

import com.google.android.gms.internal.firebase_messaging.zzq;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a {
    public static final a p = new a().a();
    public final long a;
    public final String b;
    public final String c;
    public final c d;
    public final d e;
    public final String f;
    public final String g;
    public final int h;
    public final int i;
    public final String j;
    public final long k;
    public final b l;
    public final String m;
    public final long n;
    public final String o;

    public static final class a {
        public long a = 0;
        public String b = "";
        public String c = "";
        public c d = c.UNKNOWN;
        public d e = d.UNKNOWN_OS;
        public String f = "";
        public String g = "";
        public int h = 0;
        public int i = 0;
        public String j = "";
        public long k = 0;
        public b l = b.UNKNOWN_EVENT;
        public String m = "";
        public long n = 0;
        public String o = "";

        public a a() {
            return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
        }

        public a b(String str) {
            this.m = str;
            return this;
        }

        public a c(String str) {
            this.g = str;
            return this;
        }

        public a d(String str) {
            this.o = str;
            return this;
        }

        public a e(b bVar) {
            this.l = bVar;
            return this;
        }

        public a f(String str) {
            this.c = str;
            return this;
        }

        public a g(String str) {
            this.b = str;
            return this;
        }

        public a h(c cVar) {
            this.d = cVar;
            return this;
        }

        public a i(String str) {
            this.f = str;
            return this;
        }

        public a j(long j) {
            this.a = j;
            return this;
        }

        public a k(d dVar) {
            this.e = dVar;
            return this;
        }

        public a l(String str) {
            this.j = str;
            return this;
        }

        public a m(int i) {
            this.i = i;
            return this;
        }
    }

    public enum b implements zzq {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);

        private final int number_;

        b(int i) {
            this.number_ = i;
        }

        public int getNumber() {
            return this.number_;
        }
    }

    public enum c implements zzq {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);

        private final int number_;

        c(int i) {
            this.number_ = i;
        }

        public int getNumber() {
            return this.number_;
        }
    }

    public enum d implements zzq {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);

        private final int number_;

        d(int i) {
            this.number_ = i;
        }

        public int getNumber() {
            return this.number_;
        }
    }

    public a(long j, String str, String str2, c cVar, d dVar, String str3, String str4, int i, int i2, String str5, long j2, b bVar, String str6, long j3, String str7) {
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = cVar;
        this.e = dVar;
        this.f = str3;
        this.g = str4;
        this.h = i;
        this.i = i2;
        this.j = str5;
        this.k = j2;
        this.l = bVar;
        this.m = str6;
        this.n = j3;
        this.o = str7;
    }

    public static a p() {
        return new a();
    }

    public String a() {
        return this.m;
    }

    public long b() {
        return this.k;
    }

    public long c() {
        return this.n;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.o;
    }

    public b f() {
        return this.l;
    }

    public String g() {
        return this.c;
    }

    public String h() {
        return this.b;
    }

    public c i() {
        return this.d;
    }

    public String j() {
        return this.f;
    }

    public int k() {
        return this.h;
    }

    public long l() {
        return this.a;
    }

    public d m() {
        return this.e;
    }

    public String n() {
        return this.j;
    }

    public int o() {
        return this.i;
    }
}

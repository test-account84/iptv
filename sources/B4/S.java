package b4;

import O2.w0;
import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s {
    public final Uri a;
    public final long b;
    public final int c;
    public final byte[] d;
    public final Map e;
    public final long f;
    public final long g;
    public final long h;
    public final String i;
    public final int j;
    public final Object k;

    public static final class b {
        public Uri a;
        public long b;
        public int c;
        public byte[] d;
        public Map e;
        public long f;
        public long g;
        public String h;
        public int i;
        public Object j;

        public b() {
            this.c = 1;
            this.e = Collections.emptyMap();
            this.g = -1L;
        }

        public s a() {
            d4.a.j(this.a, "The uri must be set.");
            return new s(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
        }

        public b b(int i) {
            this.i = i;
            return this;
        }

        public b c(byte[] bArr) {
            this.d = bArr;
            return this;
        }

        public b d(int i) {
            this.c = i;
            return this;
        }

        public b e(Map map) {
            this.e = map;
            return this;
        }

        public b f(String str) {
            this.h = str;
            return this;
        }

        public b g(long j) {
            this.g = j;
            return this;
        }

        public b h(long j) {
            this.f = j;
            return this;
        }

        public b i(Uri uri) {
            this.a = uri;
            return this;
        }

        public b j(String str) {
            this.a = Uri.parse(str);
            return this;
        }

        public b k(long j) {
            this.b = j;
            return this;
        }

        public b(s sVar) {
            this.a = sVar.a;
            this.b = sVar.b;
            this.c = sVar.c;
            this.d = sVar.d;
            this.e = sVar.e;
            this.f = sVar.g;
            this.g = sVar.h;
            this.h = sVar.i;
            this.i = sVar.j;
            this.j = sVar.k;
        }

        public /* synthetic */ b(s sVar, a aVar) {
            this(sVar);
        }
    }

    static {
        w0.a("goog.exo.datasource");
    }

    public s(Uri uri) {
        this(uri, 0L, -1L);
    }

    public static String c(int i) {
        if (i == 1) {
            return "GET";
        }
        if (i == 2) {
            return "POST";
        }
        if (i == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public b a() {
        return new b(this, null);
    }

    public final String b() {
        return c(this.c);
    }

    public boolean d(int i) {
        return (this.j & i) == i;
    }

    public s e(long j) {
        long j2 = this.h;
        return f(j, j2 != -1 ? j2 - j : -1L);
    }

    public s f(long j, long j2) {
        return (j == 0 && this.h == j2) ? this : new s(this.a, this.b, this.c, this.d, this.e, this.g + j, j2, this.i, this.j, this.k);
    }

    public s g(Uri uri) {
        return new s(uri, this.b, this.c, this.d, this.e, this.g, this.h, this.i, this.j, this.k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.a + ", " + this.g + ", " + this.h + ", " + this.i + ", " + this.j + "]";
    }

    public s(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj) {
        byte[] bArr2 = bArr;
        long j4 = j + j2;
        d4.a.a(j4 >= 0);
        d4.a.a(j2 >= 0);
        d4.a.a(j3 > 0 || j3 == -1);
        this.a = uri;
        this.b = j;
        this.c = i;
        this.d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.e = Collections.unmodifiableMap(new HashMap(map));
        this.g = j2;
        this.f = j4;
        this.h = j3;
        this.i = str;
        this.j = i2;
        this.k = obj;
    }

    public /* synthetic */ s(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj, a aVar) {
        this(uri, j, i, bArr, map, j2, j3, str, i2, obj);
    }

    public s(Uri uri, long j, long j2) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j, j2, null, 0, null);
    }
}

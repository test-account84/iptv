package n4;

import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class k {
    public final boolean a;
    public final long b;
    public final double c;
    public final long[] d;
    public final JSONObject e;
    public final String f;
    public final String g;

    public static class a {
        public boolean a = true;
        public long b = -1;
        public double c = 1.0d;
        public long[] d;
        public JSONObject e;
        public String f;
        public String g;

        public k a() {
            return new k(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        public a b(boolean z) {
            this.a = z;
            return this;
        }

        public a c(long j) {
            this.b = j;
            return this;
        }
    }

    public /* synthetic */ k(boolean z, long j, double d, long[] jArr, JSONObject jSONObject, String str, String str2, g0 g0Var) {
        this.a = z;
        this.b = j;
        this.c = d;
        this.d = jArr;
        this.e = jSONObject;
        this.f = str;
        this.g = str2;
    }

    public long[] a() {
        return this.d;
    }

    public boolean b() {
        return this.a;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public JSONObject e() {
        return this.e;
    }

    public long f() {
        return this.b;
    }

    public double g() {
        return this.c;
    }
}

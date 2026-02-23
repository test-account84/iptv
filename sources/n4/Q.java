package n4;

import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class q {
    public final long a;
    public final int b;
    public final boolean c;
    public final JSONObject d;

    public static class a {
        public long a;
        public int b = 0;
        public boolean c;
        public JSONObject d;

        public q a() {
            return new q(this.a, this.b, this.c, this.d, null);
        }

        public a b(JSONObject jSONObject) {
            this.d = jSONObject;
            return this;
        }

        public a c(boolean z) {
            this.c = z;
            return this;
        }

        public a d(long j) {
            this.a = j;
            return this;
        }

        public a e(int i) {
            this.b = i;
            return this;
        }
    }

    public /* synthetic */ q(long j, int i, boolean z, JSONObject jSONObject, r0 r0Var) {
        this.a = j;
        this.b = i;
        this.c = z;
        this.d = jSONObject;
    }

    public JSONObject a() {
        return this.d;
    }

    public long b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a == qVar.a && this.b == qVar.b && this.c == qVar.c && com.google.android.gms.common.internal.q.b(this.d, qVar.d);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Long.valueOf(this.a), Integer.valueOf(this.b), Boolean.valueOf(this.c), this.d);
    }
}

package O2;

import O2.n;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u implements n {
    public static final u f = new b(0).e();
    public static final String g = d4.k0.A0(0);
    public static final String h = d4.k0.A0(1);
    public static final String i = d4.k0.A0(2);
    public static final String j = d4.k0.A0(3);
    public static final n.a k = new t();
    public final int a;
    public final int c;
    public final int d;
    public final String e;

    public static final class b {
        public final int a;
        public int b;
        public int c;
        public String d;

        public b(int i) {
            this.a = i;
        }

        public static /* synthetic */ int a(b bVar) {
            return bVar.a;
        }

        public static /* synthetic */ int b(b bVar) {
            return bVar.b;
        }

        public static /* synthetic */ int c(b bVar) {
            return bVar.c;
        }

        public static /* synthetic */ String d(b bVar) {
            return bVar.d;
        }

        public u e() {
            d4.a.a(this.b <= this.c);
            return new u(this, null);
        }

        public b f(int i) {
            this.c = i;
            return this;
        }

        public b g(int i) {
            this.b = i;
            return this;
        }

        public b h(String str) {
            d4.a.a(this.a != 0 || str == null);
            this.d = str;
            return this;
        }
    }

    public u(b bVar) {
        this.a = b.a(bVar);
        this.c = b.b(bVar);
        this.d = b.c(bVar);
        this.e = b.d(bVar);
    }

    public static /* synthetic */ u a(Bundle bundle) {
        return b(bundle);
    }

    public static /* synthetic */ u b(Bundle bundle) {
        int i2 = bundle.getInt(g, 0);
        int i3 = bundle.getInt(h, 0);
        int i4 = bundle.getInt(i, 0);
        return new b(i2).g(i3).f(i4).h(bundle.getString(j)).e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.a == uVar.a && this.c == uVar.c && this.d == uVar.d && d4.k0.c(this.e, uVar.e);
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        int i2 = this.a;
        if (i2 != 0) {
            bundle.putInt(g, i2);
        }
        int i3 = this.c;
        if (i3 != 0) {
            bundle.putInt(h, i3);
        }
        int i4 = this.d;
        if (i4 != 0) {
            bundle.putInt(i, i4);
        }
        String str = this.e;
        if (str != null) {
            bundle.putString(j, str);
        }
        return bundle;
    }

    public int hashCode() {
        int i2 = (((((527 + this.a) * 31) + this.c) * 31) + this.d) * 31;
        String str = this.e;
        return i2 + (str == null ? 0 : str.hashCode());
    }

    public /* synthetic */ u(b bVar, a aVar) {
        this(bVar);
    }
}

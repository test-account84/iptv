package Q2;

import O2.n;
import android.media.AudioAttributes;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e implements O2.n {
    public static final e h = new e().a();
    public static final String i = d4.k0.A0(0);
    public static final String j = d4.k0.A0(1);
    public static final String k = d4.k0.A0(2);
    public static final String l = d4.k0.A0(3);
    public static final String m = d4.k0.A0(4);
    public static final n.a n = new Q2.d();
    public final int a;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public d g;

    public static final class b {
        public static void a(AudioAttributes.Builder builder, int i) {
            com.google.ads.interactivemedia.v3.internal.G.a(builder, i);
        }
    }

    public static final class c {
        public static void a(AudioAttributes.Builder builder, int i) {
            com.google.ads.interactivemedia.v3.internal.O.a(builder, i);
        }
    }

    public static final class d {
        public final AudioAttributes a;

        public d(e eVar) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(eVar.a).setFlags(eVar.c).setUsage(eVar.d);
            int i = d4.k0.a;
            if (i >= 29) {
                b.a(usage, eVar.e);
            }
            if (i >= 32) {
                c.a(usage, eVar.f);
            }
            this.a = usage.build();
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this(eVar);
        }
    }

    public static final class e {
        public int a = 0;
        public int b = 0;
        public int c = 1;
        public int d = 1;
        public int e = 0;

        public e a() {
            return new e(this.a, this.b, this.c, this.d, this.e, null);
        }

        public e b(int i) {
            this.d = i;
            return this;
        }

        public e c(int i) {
            this.a = i;
            return this;
        }

        public e d(int i) {
            this.b = i;
            return this;
        }

        public e e(int i) {
            this.e = i;
            return this;
        }

        public e f(int i) {
            this.c = i;
            return this;
        }
    }

    public e(int i2, int i3, int i4, int i5, int i6) {
        this.a = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public static /* synthetic */ e a(Bundle bundle) {
        return c(bundle);
    }

    public static /* synthetic */ e c(Bundle bundle) {
        e eVar = new e();
        String str = i;
        if (bundle.containsKey(str)) {
            eVar.c(bundle.getInt(str));
        }
        String str2 = j;
        if (bundle.containsKey(str2)) {
            eVar.d(bundle.getInt(str2));
        }
        String str3 = k;
        if (bundle.containsKey(str3)) {
            eVar.f(bundle.getInt(str3));
        }
        String str4 = l;
        if (bundle.containsKey(str4)) {
            eVar.b(bundle.getInt(str4));
        }
        String str5 = m;
        if (bundle.containsKey(str5)) {
            eVar.e(bundle.getInt(str5));
        }
        return eVar.a();
    }

    public d b() {
        if (this.g == null) {
            this.g = new d(this, null);
        }
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.c == eVar.c && this.d == eVar.d && this.e == eVar.e && this.f == eVar.f;
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(i, this.a);
        bundle.putInt(j, this.c);
        bundle.putInt(k, this.d);
        bundle.putInt(l, this.e);
        bundle.putInt(m, this.f);
        return bundle;
    }

    public int hashCode() {
        return ((((((((527 + this.a) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
    }

    public /* synthetic */ e(int i2, int i3, int i4, int i5, int i6, a aVar) {
        this(i2, i3, i4, i5, i6);
    }
}

package K3;

import android.net.Uri;
import d4.k0;
import java.util.HashMap;
import s5.A;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class y {
    public final A a;
    public final s5.y b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final Uri g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    public static final class b {
        public final HashMap a = new HashMap();
        public final y.a b = new y.a();
        public int c = -1;
        public String d;
        public String e;
        public String f;
        public Uri g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;

        public static /* synthetic */ HashMap a(b bVar) {
            return bVar.a;
        }

        public static /* synthetic */ String b(b bVar) {
            return bVar.k;
        }

        public static /* synthetic */ String c(b bVar) {
            return bVar.l;
        }

        public static /* synthetic */ String d(b bVar) {
            return bVar.j;
        }

        public static /* synthetic */ y.a e(b bVar) {
            return bVar.b;
        }

        public static /* synthetic */ String f(b bVar) {
            return bVar.d;
        }

        public static /* synthetic */ String g(b bVar) {
            return bVar.e;
        }

        public static /* synthetic */ String h(b bVar) {
            return bVar.f;
        }

        public static /* synthetic */ Uri i(b bVar) {
            return bVar.g;
        }

        public static /* synthetic */ String j(b bVar) {
            return bVar.h;
        }

        public static /* synthetic */ int k(b bVar) {
            return bVar.c;
        }

        public static /* synthetic */ String l(b bVar) {
            return bVar.i;
        }

        public b m(String str, String str2) {
            this.a.put(str, str2);
            return this;
        }

        public b n(K3.a aVar) {
            this.b.h(aVar);
            return this;
        }

        public y o() {
            return new y(this, null);
        }

        public b p(int i) {
            this.c = i;
            return this;
        }

        public b q(String str) {
            this.h = str;
            return this;
        }

        public b r(String str) {
            this.k = str;
            return this;
        }

        public b s(String str) {
            this.i = str;
            return this;
        }

        public b t(String str) {
            this.e = str;
            return this;
        }

        public b u(String str) {
            this.l = str;
            return this;
        }

        public b v(String str) {
            this.j = str;
            return this;
        }

        public b w(String str) {
            this.d = str;
            return this;
        }

        public b x(String str) {
            this.f = str;
            return this;
        }

        public b y(Uri uri) {
            this.g = uri;
            return this;
        }
    }

    public y(b bVar) {
        this.a = A.d(b.a(bVar));
        this.b = b.e(bVar).k();
        this.c = (String) k0.j(b.f(bVar));
        this.d = (String) k0.j(b.g(bVar));
        this.e = (String) k0.j(b.h(bVar));
        this.g = b.i(bVar);
        this.h = b.j(bVar);
        this.f = b.k(bVar);
        this.i = b.l(bVar);
        this.j = b.b(bVar);
        this.k = b.c(bVar);
        this.l = b.d(bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        return this.f == yVar.f && this.a.equals(yVar.a) && this.b.equals(yVar.b) && k0.c(this.d, yVar.d) && k0.c(this.c, yVar.c) && k0.c(this.e, yVar.e) && k0.c(this.l, yVar.l) && k0.c(this.g, yVar.g) && k0.c(this.j, yVar.j) && k0.c(this.k, yVar.k) && k0.c(this.h, yVar.h) && k0.c(this.i, yVar.i);
    }

    public int hashCode() {
        int hashCode = (((217 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31;
        String str = this.d;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f) * 31;
        String str4 = this.l;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Uri uri = this.g;
        int hashCode6 = (hashCode5 + (uri == null ? 0 : uri.hashCode())) * 31;
        String str5 = this.j;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.k;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.h;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.i;
        return hashCode9 + (str8 != null ? str8.hashCode() : 0);
    }

    public /* synthetic */ y(b bVar, a aVar) {
        this(bVar);
    }
}

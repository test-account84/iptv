package g1;

import android.text.TextUtils;
import com.android.billingclient.api.SkuDetails;
import com.google.android.gms.internal.play_billing.zzai;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f {
    public boolean a;
    public String b;
    public String c;
    public b d;
    public zzai e;
    public ArrayList f;
    public boolean g;

    public static class a {
        public String a;
        public String b;
        public List c;
        public ArrayList d;
        public boolean e;
        public b.a f;

        public /* synthetic */ a(z zVar) {
            b.a a = b.a();
            b.a.b(a);
            this.f = a;
        }

        public f a() {
            ArrayList arrayList = this.d;
            boolean z = true;
            boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.c;
            boolean z3 = (list == null || list.isEmpty()) ? false : true;
            if (!z2 && !z3) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z2 && z3) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            if (!z2) {
                d.D.a(this.c.get(0));
                if (this.c.size() <= 0) {
                    throw null;
                }
                d.D.a(this.c.get(0));
                throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
            }
            if (this.d.contains((Object) null)) {
                throw new IllegalArgumentException("SKU cannot be null.");
            }
            if (this.d.size() > 1) {
                SkuDetails skuDetails = (SkuDetails) this.d.get(0);
                String d = skuDetails.d();
                ArrayList arrayList2 = this.d;
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    SkuDetails skuDetails2 = (SkuDetails) arrayList2.get(i);
                    if (!d.equals("play_pass_subs") && !skuDetails2.d().equals("play_pass_subs") && !d.equals(skuDetails2.d())) {
                        throw new IllegalArgumentException("SKUs should have the same type.");
                    }
                }
                String h = skuDetails.h();
                ArrayList arrayList3 = this.d;
                int size2 = arrayList3.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    SkuDetails skuDetails3 = (SkuDetails) arrayList3.get(i2);
                    if (!d.equals("play_pass_subs") && !skuDetails3.d().equals("play_pass_subs") && !h.equals(skuDetails3.h())) {
                        throw new IllegalArgumentException("All SKUs must have the same package name.");
                    }
                }
            }
            f fVar = new f(null);
            if (!z2 || ((SkuDetails) this.d.get(0)).h().isEmpty()) {
                if (z3) {
                    d.D.a(this.c.get(0));
                    throw null;
                }
                z = false;
            }
            f.i(fVar, z);
            f.k(fVar, this.a);
            f.l(fVar, this.b);
            f.o(fVar, this.f.a());
            ArrayList arrayList4 = this.d;
            f.n(fVar, arrayList4 != null ? new ArrayList(arrayList4) : new ArrayList());
            f.j(fVar, this.e);
            List list2 = this.c;
            f.m(fVar, list2 != null ? zzai.zzj(list2) : zzai.zzk());
            return fVar;
        }

        public a b(SkuDetails skuDetails) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(skuDetails);
            this.d = arrayList;
            return this;
        }
    }

    public static class b {
        public String a;
        public String b;
        public int c = 0;

        public static class a {
            public String a;
            public String b;
            public boolean c;
            public int d = 0;

            public /* synthetic */ a(A a) {
            }

            public static /* synthetic */ a b(a aVar) {
                aVar.c = true;
                return aVar;
            }

            public b a() {
                boolean z = (TextUtils.isEmpty(this.a) && TextUtils.isEmpty((CharSequence) null)) ? false : true;
                boolean isEmpty = true ^ TextUtils.isEmpty(this.b);
                if (z && isEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.c && !z && !isEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                b bVar = new b(null);
                b.e(bVar, this.a);
                b.g(bVar, this.d);
                b.f(bVar, this.b);
                return bVar;
            }
        }

        public /* synthetic */ b(B b) {
        }

        public static a a() {
            return new a(null);
        }

        public static /* bridge */ /* synthetic */ void e(b bVar, String str) {
            bVar.a = str;
        }

        public static /* bridge */ /* synthetic */ void f(b bVar, String str) {
            bVar.b = str;
        }

        public static /* bridge */ /* synthetic */ void g(b bVar, int i) {
            bVar.c = i;
        }

        public final int b() {
            return this.c;
        }

        public final String c() {
            return this.a;
        }

        public final String d() {
            return this.b;
        }
    }

    public /* synthetic */ f(D d) {
    }

    public static a a() {
        return new a(null);
    }

    public static /* bridge */ /* synthetic */ void i(f fVar, boolean z) {
        fVar.a = z;
    }

    public static /* bridge */ /* synthetic */ void j(f fVar, boolean z) {
        fVar.g = z;
    }

    public static /* bridge */ /* synthetic */ void k(f fVar, String str) {
        fVar.b = str;
    }

    public static /* bridge */ /* synthetic */ void l(f fVar, String str) {
        fVar.c = str;
    }

    public static /* bridge */ /* synthetic */ void m(f fVar, zzai zzaiVar) {
        fVar.e = zzaiVar;
    }

    public static /* bridge */ /* synthetic */ void n(f fVar, ArrayList arrayList) {
        fVar.f = arrayList;
    }

    public static /* bridge */ /* synthetic */ void o(f fVar, b bVar) {
        fVar.d = bVar;
    }

    public final int b() {
        return this.d.b();
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.d.c();
    }

    public final String f() {
        return this.d.d();
    }

    public final ArrayList g() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f);
        return arrayList;
    }

    public final List h() {
        return this.e;
    }

    public final boolean p() {
        return this.g;
    }

    public final boolean q() {
        return (this.b == null && this.c == null && this.d.d() == null && this.d.b() == 0 && !this.a && !this.g) ? false : true;
    }
}

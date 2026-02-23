package O2;

import O2.n;
import android.os.Bundle;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import d4.s;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface t1 {

    public static final class b implements n {
        public static final b c = new a().e();
        public static final String d = d4.k0.A0(0);
        public static final n.a e = new u1();
        public final d4.s a;

        public static final class a {
            public static final int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 33, 26, 34, 27, 28, 29, 30, 32};
            public final s.b a = new s.b();

            public a a(int i) {
                this.a.a(i);
                return this;
            }

            public a b(b bVar) {
                this.a.b(b.b(bVar));
                return this;
            }

            public a c(int... iArr) {
                this.a.c(iArr);
                return this;
            }

            public a d(int i, boolean z) {
                this.a.d(i, z);
                return this;
            }

            public b e() {
                return new b(this.a.e(), null);
            }
        }

        public b(d4.s sVar) {
            this.a = sVar;
        }

        public static /* synthetic */ b a(Bundle bundle) {
            return d(bundle);
        }

        public static /* synthetic */ d4.s b(b bVar) {
            return bVar.a;
        }

        public static b d(Bundle bundle) {
            ArrayList integerArrayList = bundle.getIntegerArrayList(d);
            if (integerArrayList == null) {
                return c;
            }
            a aVar = new a();
            for (int i = 0; i < integerArrayList.size(); i++) {
                aVar.a(((Integer) integerArrayList.get(i)).intValue());
            }
            return aVar.e();
        }

        public boolean c(int i) {
            return this.a.a(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public Bundle h() {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.a.d(); i++) {
                arrayList.add(Integer.valueOf(this.a.c(i)));
            }
            bundle.putIntegerArrayList(d, arrayList);
            return bundle;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public /* synthetic */ b(d4.s sVar, a aVar) {
            this(sVar);
        }
    }

    public static final class c {
        public final d4.s a;

        public c(d4.s sVar) {
            this.a = sVar;
        }

        public boolean a(int i) {
            return this.a.a(i);
        }

        public boolean b(int... iArr) {
            return this.a.b(iArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.a.equals(((c) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public interface d {
        void A(Q2.e eVar);

        void B(boolean z);

        void E(int i);

        void J(boolean z);

        void M(int i, boolean z);

        void O(b bVar);

        void P();

        void S(e eVar, e eVar2, int i);

        void U(int i, int i2);

        void V(Q1 q1, int i);

        void W(p1 p1Var);

        void Y(Z3.z zVar);

        void a(boolean z);

        void a0(u uVar);

        void b0(int i);

        void d0(boolean z);

        void e(q3.a aVar);

        void f0(V1 v1);

        void g0(boolean z, int i);

        void h0(H0 h0, int i);

        void i0(R0 r0);

        void j(e4.C c);

        void j0(boolean z, int i);

        void k(List list);

        void l0(p1 p1Var);

        void m0(t1 t1Var, c cVar);

        void n0(boolean z);

        void onRepeatModeChanged(int i);

        void t(s1 s1Var);

        void u(P3.f fVar);

        void z(int i);
    }

    public static final class e implements n {
        public static final String l = d4.k0.A0(0);
        public static final String m = d4.k0.A0(1);
        public static final String n = d4.k0.A0(2);
        public static final String o = d4.k0.A0(3);
        public static final String p = d4.k0.A0(4);
        public static final String q = d4.k0.A0(5);
        public static final String r = d4.k0.A0(6);
        public static final n.a s = new w1();
        public final Object a;
        public final int c;
        public final int d;
        public final H0 e;
        public final Object f;
        public final int g;
        public final long h;
        public final long i;
        public final int j;
        public final int k;

        public e(Object obj, int i, H0 h0, Object obj2, int i2, long j, long j2, int i3, int i4) {
            this.a = obj;
            this.c = i;
            this.d = i;
            this.e = h0;
            this.f = obj2;
            this.g = i2;
            this.h = j;
            this.i = j2;
            this.j = i3;
            this.k = i4;
        }

        public static /* synthetic */ e a(Bundle bundle) {
            return b(bundle);
        }

        public static e b(Bundle bundle) {
            int i = bundle.getInt(l, 0);
            Bundle bundle2 = bundle.getBundle(m);
            return new e(null, i, bundle2 == null ? null : (H0) H0.q.a(bundle2), null, bundle.getInt(n, 0), bundle.getLong(o, 0L), bundle.getLong(p, 0L), bundle.getInt(q, -1), bundle.getInt(r, -1));
        }

        public Bundle c(boolean z, boolean z2) {
            Bundle bundle = new Bundle();
            bundle.putInt(l, z2 ? this.d : 0);
            H0 h0 = this.e;
            if (h0 != null && z) {
                bundle.putBundle(m, h0.h());
            }
            bundle.putInt(n, z2 ? this.g : 0);
            bundle.putLong(o, z ? this.h : 0L);
            bundle.putLong(p, z ? this.i : 0L);
            bundle.putInt(q, z ? this.j : -1);
            bundle.putInt(r, z ? this.k : -1);
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.d == eVar.d && this.g == eVar.g && this.h == eVar.h && this.i == eVar.i && this.j == eVar.j && this.k == eVar.k && r5.j.a(this.a, eVar.a) && r5.j.a(this.f, eVar.f) && r5.j.a(this.e, eVar.e);
        }

        public Bundle h() {
            return c(true, true);
        }

        public int hashCode() {
            return r5.j.b(this.a, Integer.valueOf(this.d), this.e, this.f, Integer.valueOf(this.g), Long.valueOf(this.h), Long.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k));
        }
    }

    void A(TextureView textureView);

    void B(d dVar);

    void C(int i, long j);

    b D();

    boolean E();

    void F(boolean z);

    H0 G(int i);

    long H();

    long I();

    int J();

    void K(TextureView textureView);

    e4.C L();

    boolean M();

    int N();

    long P();

    long R();

    void T(int i, List list);

    long U();

    boolean V();

    int X();

    void Y(SurfaceView surfaceView);

    boolean Z();

    long a0();

    void b(s1 s1Var);

    void b0();

    s1 c();

    boolean d();

    void d0();

    long e();

    R0 e0();

    H0 f();

    long f0();

    void g();

    boolean g0();

    long getCurrentPosition();

    long getDuration();

    int getPlaybackState();

    int getRepeatMode();

    float getVolume();

    void h(List list, boolean z);

    void i(Z3.z zVar);

    boolean isPlaying();

    void j(SurfaceView surfaceView);

    int k();

    void l(d dVar);

    void m();

    p1 n();

    void o(boolean z);

    V1 p();

    void pause();

    void play();

    void prepare();

    boolean q();

    P3.f r();

    void release();

    int s();

    void seekTo(long j);

    void setRepeatMode(int i);

    boolean t(int i);

    boolean u();

    int v();

    Q1 w();

    Looper x();

    Z3.z y();

    void z();
}

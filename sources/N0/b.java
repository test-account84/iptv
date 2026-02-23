package n0;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.I;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.lifecycle.p;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import n0.a;
import o0.c;
import s.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends n0.a {
    public static boolean c = false;
    public final p a;
    public final c b;

    public static class a extends u implements c.b {
        public final int l;
        public final Bundle m;
        public final o0.c n;
        public p o;
        public b p;
        public o0.c q;

        public a(int i, Bundle bundle, o0.c cVar, o0.c cVar2) {
            this.l = i;
            this.m = bundle;
            this.n = cVar;
            this.q = cVar2;
            cVar.t(i, this);
        }

        public void a(o0.c cVar, Object obj) {
            if (b.c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                o(obj);
                return;
            }
            if (b.c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            l(obj);
        }

        public void j() {
            if (b.c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.n.w();
        }

        public void k() {
            if (b.c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.n.x();
        }

        public void m(v vVar) {
            super.m(vVar);
            this.o = null;
            this.p = null;
        }

        public void o(Object obj) {
            super.o(obj);
            o0.c cVar = this.q;
            if (cVar != null) {
                cVar.u();
                this.q = null;
            }
        }

        public o0.c p(boolean z) {
            if (b.c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.n.b();
            this.n.a();
            b bVar = this.p;
            if (bVar != null) {
                m(bVar);
                if (z) {
                    bVar.d();
                }
            }
            this.n.z(this);
            if ((bVar == null || bVar.c()) && !z) {
                return this.n;
            }
            this.n.u();
            return this.q;
        }

        public void q(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.l);
            printWriter.print(" mArgs=");
            printWriter.println(this.m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.n);
            this.n.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.p);
                this.p.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(r().d(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(g());
        }

        public o0.c r() {
            return this.n;
        }

        public void s() {
            p pVar = this.o;
            b bVar = this.p;
            if (pVar == null || bVar == null) {
                return;
            }
            super.m(bVar);
            h(pVar, bVar);
        }

        public o0.c t(p pVar, a.a aVar) {
            b bVar = new b(this.n, aVar);
            h(pVar, bVar);
            v vVar = this.p;
            if (vVar != null) {
                m(vVar);
            }
            this.o = pVar;
            this.p = bVar;
            return this.n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.l);
            sb.append(" : ");
            O.b.a(this.n, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public static class b implements v {
        public final o0.c a;
        public final a.a b;
        public boolean c = false;

        public b(o0.c cVar, a.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        public void a(Object obj) {
            if (b.c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.d(obj));
            }
            this.b.c(this.a, obj);
            this.c = true;
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }

        public boolean c() {
            return this.c;
        }

        public void d() {
            if (this.c) {
                if (b.c) {
                    Log.v("LoaderManager", "  Resetting: " + this.a);
                }
                this.b.b(this.a);
            }
        }

        public String toString() {
            return this.b.toString();
        }
    }

    public static class c extends I {
        public static final J.b c = new a();
        public j a = new j();
        public boolean b = false;

        public static class a implements J.b {
            public /* synthetic */ I a(Class cls, m0.a aVar) {
                return K.b(this, cls, aVar);
            }

            public I b(Class cls) {
                return new c();
            }
        }

        public static c d(M m) {
            return (c) new J(m, c).a(c.class);
        }

        public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.a.m() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.a.m(); i++) {
                    a aVar = (a) this.a.n(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.a.j(i));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.q(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void c() {
            this.b = false;
        }

        public a e(int i) {
            return (a) this.a.g(i);
        }

        public boolean f() {
            return this.b;
        }

        public void g() {
            int m = this.a.m();
            for (int i = 0; i < m; i++) {
                ((a) this.a.n(i)).s();
            }
        }

        public void h(int i, a aVar) {
            this.a.k(i, aVar);
        }

        public void i() {
            this.b = true;
        }

        public void onCleared() {
            super.onCleared();
            int m = this.a.m();
            for (int i = 0; i < m; i++) {
                ((a) this.a.n(i)).p(true);
            }
            this.a.d();
        }
    }

    public b(p pVar, M m) {
        this.a = pVar;
        this.b = c.d(m);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.b.b(str, fileDescriptor, printWriter, strArr);
    }

    public o0.c c(int i, Bundle bundle, a.a aVar) {
        if (this.b.f()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a e = this.b.e(i);
        if (c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (e == null) {
            return e(i, bundle, aVar, null);
        }
        if (c) {
            Log.v("LoaderManager", "  Re-using existing loader " + e);
        }
        return e.t(this.a, aVar);
    }

    public void d() {
        this.b.g();
    }

    public final o0.c e(int i, Bundle bundle, a.a aVar, o0.c cVar) {
        try {
            this.b.i();
            o0.c a2 = aVar.a(i, bundle);
            if (a2 == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (a2.getClass().isMemberClass() && !Modifier.isStatic(a2.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + a2);
            }
            a aVar2 = new a(i, bundle, a2, cVar);
            if (c) {
                Log.v("LoaderManager", "  Created new loader " + aVar2);
            }
            this.b.h(i, aVar2);
            this.b.c();
            return aVar2.t(this.a, aVar);
        } catch (Throwable th) {
            this.b.c();
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        O.b.a(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
}

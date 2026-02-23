package u0;

import android.content.Context;
import java.lang.ref.WeakReference;
import u0.d0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class l0 {
    public final Context a;
    public final Object b;
    public c c;

    public static class a extends l0 {
        public final Object d;
        public final Object e;
        public final Object f;
        public boolean g;

        public static final class a implements d0.e {
            public final WeakReference a;

            public a(a aVar) {
                this.a = new WeakReference(aVar);
            }

            public void a(Object obj, int i) {
                c cVar;
                a aVar = (a) this.a.get();
                if (aVar == null || (cVar = aVar.c) == null) {
                    return;
                }
                cVar.b(i);
            }

            public void d(Object obj, int i) {
                c cVar;
                a aVar = (a) this.a.get();
                if (aVar == null || (cVar = aVar.c) == null) {
                    return;
                }
                cVar.a(i);
            }
        }

        public a(Context context, Object obj) {
            super(context, obj);
            Object e = d0.e(context);
            this.d = e;
            Object b = d0.b(e, "", false);
            this.e = b;
            this.f = d0.c(e, b);
        }

        public void c(b bVar) {
            d0.d.e(this.f, bVar.a);
            d0.d.h(this.f, bVar.b);
            d0.d.g(this.f, bVar.c);
            d0.d.b(this.f, bVar.d);
            d0.d.c(this.f, bVar.e);
            if (this.g) {
                return;
            }
            this.g = true;
            d0.d.f(this.f, d0.d(new a(this)));
            d0.d.d(this.f, this.b);
        }
    }

    public static final class b {
        public int a;
        public int b;
        public int c = 0;
        public int d = 3;
        public int e = 1;
        public String f;
    }

    public interface c {
        void a(int i);

        void b(int i);
    }

    public l0(Context context, Object obj) {
        this.a = context;
        this.b = obj;
    }

    public static l0 b(Context context, Object obj) {
        return new a(context, obj);
    }

    public Object a() {
        return this.b;
    }

    public abstract void c(b bVar);

    public void d(c cVar) {
        this.c = cVar;
    }
}

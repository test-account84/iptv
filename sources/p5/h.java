package P5;

import O5.k;
import com.google.ads.interactivemedia.v3.internal.z1;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h {
    public final d a;
    public final k b;
    public final String c;
    public final a d = new a(false);
    public final a e = new a(true);
    public final AtomicMarkableReference f = new AtomicMarkableReference((Object) null, false);

    public class a {
        public final AtomicMarkableReference a;
        public final AtomicReference b = new AtomicReference((Object) null);
        public final boolean c;

        public a(boolean z) {
            this.c = z;
            this.a = new AtomicMarkableReference(new b(64, z ? 8192 : 1024), false);
        }

        public static /* synthetic */ Void a(a aVar) {
            return aVar.c();
        }

        public Map b() {
            return ((b) this.a.getReference()).a();
        }

        public final /* synthetic */ Void c() {
            this.b.set((Object) null);
            e();
            return null;
        }

        public final void d() {
            g gVar = new g(this);
            if (z1.a(this.b, null, gVar)) {
                h.a(h.this).g(gVar);
            }
        }

        public final void e() {
            Map map;
            synchronized (this) {
                try {
                    if (this.a.isMarked()) {
                        map = ((b) this.a.getReference()).a();
                        AtomicMarkableReference atomicMarkableReference = this.a;
                        atomicMarkableReference.set((b) atomicMarkableReference.getReference(), false);
                    } else {
                        map = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (map != null) {
                h.c(h.this).k(h.b(h.this), map, this.c);
            }
        }

        public boolean f(String str, String str2) {
            synchronized (this) {
                try {
                    if (!((b) this.a.getReference()).d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference atomicMarkableReference = this.a;
                    atomicMarkableReference.set((b) atomicMarkableReference.getReference(), true);
                    d();
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public h(String str, T5.f fVar, k kVar) {
        this.c = str;
        this.a = new d(fVar);
        this.b = kVar;
    }

    public static /* synthetic */ k a(h hVar) {
        return hVar.b;
    }

    public static /* synthetic */ String b(h hVar) {
        return hVar.c;
    }

    public static /* synthetic */ d c(h hVar) {
        return hVar.a;
    }

    public static h f(String str, T5.f fVar, k kVar) {
        d dVar = new d(fVar);
        h hVar = new h(str, fVar, kVar);
        ((b) hVar.d.a.getReference()).e(dVar.g(str, false));
        ((b) hVar.e.a.getReference()).e(dVar.g(str, true));
        hVar.f.set(dVar.h(str), false);
        return hVar;
    }

    public static String g(String str, T5.f fVar) {
        return new d(fVar).h(str);
    }

    public Map d() {
        return this.d.b();
    }

    public Map e() {
        return this.e.b();
    }

    public boolean h(String str, String str2) {
        return this.e.f(str, str2);
    }
}

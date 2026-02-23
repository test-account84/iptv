package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import h1.n;
import h1.o;
import h1.p;
import h1.u;
import i1.i;
import i1.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a {
    public final o a;
    public final f c;
    public Runnable g;
    public int b = 100;
    public final HashMap d = new HashMap();
    public final HashMap e = new HashMap();
    public final Handler f = new Handler(Looper.getMainLooper());

    public class a implements h {
        public final /* synthetic */ int a;
        public final /* synthetic */ ImageView b;
        public final /* synthetic */ int c;

        public a(int i, ImageView imageView, int i2) {
            this.a = i;
            this.b = imageView;
            this.c = i2;
        }

        public void a(u uVar) {
            int i = this.a;
            if (i != 0) {
                this.b.setImageResource(i);
            }
        }

        public void b(g gVar, boolean z) {
            if (gVar.d() != null) {
                this.b.setImageBitmap(gVar.d());
                return;
            }
            int i = this.c;
            if (i != 0) {
                this.b.setImageResource(i);
            }
        }
    }

    public class b implements p.b {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Bitmap bitmap) {
            a.this.l(this.a, bitmap);
        }
    }

    public class c implements p.a {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        public void a(u uVar) {
            a.this.k(this.a, uVar);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            for (e eVar : a.b(a.this).values()) {
                for (g gVar : e.c(eVar)) {
                    if (g.a(gVar) != null) {
                        if (eVar.e() == null) {
                            g.b(gVar, e.a(eVar));
                            g.a(gVar).b(gVar, false);
                        } else {
                            g.a(gVar).a(eVar.e());
                        }
                    }
                }
            }
            a.b(a.this).clear();
            a.c(a.this, null);
        }
    }

    public static class e {
        public final n a;
        public Bitmap b;
        public u c;
        public final List d;

        public e(n nVar, g gVar) {
            ArrayList arrayList = new ArrayList();
            this.d = arrayList;
            this.a = nVar;
            arrayList.add(gVar);
        }

        public static /* synthetic */ Bitmap a(e eVar) {
            return eVar.b;
        }

        public static /* synthetic */ Bitmap b(e eVar, Bitmap bitmap) {
            eVar.b = bitmap;
            return bitmap;
        }

        public static /* synthetic */ List c(e eVar) {
            return eVar.d;
        }

        public void d(g gVar) {
            this.d.add(gVar);
        }

        public u e() {
            return this.c;
        }

        public boolean f(g gVar) {
            this.d.remove(gVar);
            if (this.d.size() != 0) {
                return false;
            }
            this.a.h();
            return true;
        }

        public void g(u uVar) {
            this.c = uVar;
        }
    }

    public interface f {
        void a(String str, Bitmap bitmap);

        Bitmap b(String str);
    }

    public class g {
        public Bitmap a;
        public final h b;
        public final String c;
        public final String d;

        public g(Bitmap bitmap, String str, String str2, h hVar) {
            this.a = bitmap;
            this.d = str;
            this.c = str2;
            this.b = hVar;
        }

        public static /* synthetic */ h a(g gVar) {
            return gVar.b;
        }

        public static /* synthetic */ Bitmap b(g gVar, Bitmap bitmap) {
            gVar.a = bitmap;
            return bitmap;
        }

        public void c() {
            HashMap b;
            l.a();
            if (this.b == null) {
                return;
            }
            e eVar = (e) a.a(a.this).get(this.c);
            if (eVar == null) {
                e eVar2 = (e) a.b(a.this).get(this.c);
                if (eVar2 == null) {
                    return;
                }
                eVar2.f(this);
                if (e.c(eVar2).size() != 0) {
                    return;
                } else {
                    b = a.b(a.this);
                }
            } else if (!eVar.f(this)) {
                return;
            } else {
                b = a.a(a.this);
            }
            b.remove(this.c);
        }

        public Bitmap d() {
            return this.a;
        }

        public String e() {
            return this.d;
        }
    }

    public interface h extends p.a {
        void b(g gVar, boolean z);
    }

    public a(o oVar, f fVar) {
        this.a = oVar;
        this.c = fVar;
    }

    public static /* synthetic */ HashMap a(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ HashMap b(a aVar) {
        return aVar.e;
    }

    public static /* synthetic */ Runnable c(a aVar, Runnable runnable) {
        aVar.g = runnable;
        return runnable;
    }

    public static String h(String str, int i, int i2, ImageView.ScaleType scaleType) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(str);
        return sb.toString();
    }

    public static h i(ImageView imageView, int i, int i2) {
        return new a(i2, imageView, i);
    }

    public final void d(String str, e eVar) {
        this.e.put(str, eVar);
        if (this.g == null) {
            d dVar = new d();
            this.g = dVar;
            this.f.postDelayed(dVar, this.b);
        }
    }

    public g e(String str, h hVar) {
        return f(str, hVar, 0, 0);
    }

    public g f(String str, h hVar, int i, int i2) {
        return g(str, hVar, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public g g(String str, h hVar, int i, int i2, ImageView.ScaleType scaleType) {
        l.a();
        String h2 = h(str, i, i2, scaleType);
        Bitmap b2 = this.c.b(h2);
        if (b2 != null) {
            g gVar = new g(b2, str, null, null);
            hVar.b(gVar, true);
            return gVar;
        }
        g gVar2 = new g(null, str, h2, hVar);
        hVar.b(gVar2, true);
        e eVar = (e) this.d.get(h2);
        if (eVar == null) {
            eVar = (e) this.e.get(h2);
        }
        if (eVar != null) {
            eVar.d(gVar2);
            return gVar2;
        }
        n j = j(str, i, i2, scaleType, h2);
        this.a.a(j);
        this.d.put(h2, new e(j, gVar2));
        return gVar2;
    }

    public n j(String str, int i, int i2, ImageView.ScaleType scaleType, String str2) {
        return new i(str, new b(str2), i, i2, scaleType, Bitmap.Config.RGB_565, new c(str2));
    }

    public void k(String str, u uVar) {
        e eVar = (e) this.d.remove(str);
        if (eVar != null) {
            eVar.g(uVar);
            d(str, eVar);
        }
    }

    public void l(String str, Bitmap bitmap) {
        this.c.a(str, bitmap);
        e eVar = (e) this.d.remove(str);
        if (eVar != null) {
            e.b(eVar, bitmap);
            d(str, eVar);
        }
    }
}

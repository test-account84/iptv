package d3;

import android.net.Uri;
import d4.Z;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import n3.A;
import n3.H;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f implements o {
    public static final int[] o = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};
    public static final a p = new a(new d());
    public static final a q = new a(new e());
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int l;
    public s5.y m;
    public int k = 1;
    public int n = 112800;

    public static final class a {
        public final a a;
        public final AtomicBoolean b = new AtomicBoolean(false);
        public Constructor c;

        public interface a {
            Constructor a();
        }

        public a(a aVar) {
            this.a = aVar;
        }

        public i a(Object... objArr) {
            Constructor b = b();
            if (b == null) {
                return null;
            }
            try {
                return (i) b.newInstance(objArr);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error creating extractor", e);
            }
        }

        public final Constructor b() {
            synchronized (this.b) {
                if (this.b.get()) {
                    return this.c;
                }
                try {
                    return this.a.a();
                } catch (ClassNotFoundException unused) {
                    this.b.set(true);
                    return this.c;
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
        }
    }

    public static /* synthetic */ Constructor c() {
        return f();
    }

    public static /* synthetic */ Constructor d() {
        return g();
    }

    public static Constructor f() {
        Boolean bool = Boolean.TRUE;
        d4.x xVar = com.google.android.exoplayer2.ext.flac.h.a;
        if (!bool.equals(com.google.android.exoplayer2.ext.flac.h.class.getMethod("isAvailable", (Class[]) null).invoke((Object) null, (Object[]) null))) {
            return null;
        }
        o oVar = com.google.android.exoplayer2.ext.flac.g.k;
        return com.google.android.exoplayer2.ext.flac.g.class.asSubclass(i.class).getConstructor(new Class[]{Integer.TYPE});
    }

    public static Constructor g() {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(i.class).getConstructor((Class[]) null);
    }

    public synchronized i[] a(Uri uri, Map map) {
        ArrayList arrayList;
        try {
            int[] iArr = o;
            arrayList = new ArrayList(iArr.length);
            int b = d4.r.b(map);
            if (b != -1) {
                e(b, arrayList);
            }
            int c = d4.r.c(uri);
            if (c != -1 && c != b) {
                e(c, arrayList);
            }
            for (int i : iArr) {
                if (i != b && i != c) {
                    e(i, arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (i[]) arrayList.toArray(new i[arrayList.size()]);
    }

    public synchronized i[] b() {
        return a(Uri.EMPTY, new HashMap());
    }

    public final void e(int i, List list) {
        i bVar;
        switch (i) {
            case 0:
                bVar = new n3.b();
                break;
            case 1:
                bVar = new n3.e();
                break;
            case 2:
                bVar = new n3.h((this.c ? 2 : 0) | this.d | (this.b ? 1 : 0));
                break;
            case 3:
                bVar = new e3.b((this.c ? 2 : 0) | this.e | (this.b ? 1 : 0));
                break;
            case 4:
                bVar = p.a(Integer.valueOf(this.f));
                if (bVar == null) {
                    bVar = new g3.c(this.f);
                    break;
                }
                break;
            case 5:
                bVar = new h3.c();
                break;
            case 6:
                bVar = new j3.e(this.g);
                break;
            case 7:
                bVar = new k3.f((this.c ? 2 : 0) | this.j | (this.b ? 1 : 0));
                break;
            case 8:
                list.add(new l3.g(this.i));
                bVar = new l3.k(this.h);
                break;
            case 9:
                bVar = new m3.d();
                break;
            case 10:
                bVar = new A();
                break;
            case 11:
                if (this.m == null) {
                    this.m = s5.y.z();
                }
                bVar = new H(this.k, new Z(0L), new n3.j(this.l, this.m), this.n);
                break;
            case 12:
                bVar = new o3.b();
                break;
            case 13:
            default:
                return;
            case 14:
                bVar = new i3.a();
                break;
            case 15:
                bVar = q.a(new Object[0]);
                if (bVar == null) {
                    return;
                }
                break;
            case 16:
                bVar = new f3.b();
                break;
        }
        list.add(bVar);
    }
}

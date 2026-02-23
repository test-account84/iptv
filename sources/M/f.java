package M;

import M.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import s.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class f {
    public static final s.g a = new s.g(16);
    public static final ExecutorService b = h.a("fonts-androidx", 10, 10000);
    public static final Object c = new Object();
    public static final i d = new i();

    public class a implements Callable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ M.e c;
        public final /* synthetic */ int d;

        public a(String str, Context context, M.e eVar, int i) {
            this.a = str;
            this.b = context;
            this.c = eVar;
            this.d = i;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.a, this.b, this.c, this.d);
        }
    }

    public class b implements O.a {
        public final /* synthetic */ M.a a;

        public b(M.a aVar) {
            this.a = aVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.a.b(eVar);
        }
    }

    public class c implements Callable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ M.e c;
        public final /* synthetic */ int d;

        public c(String str, Context context, M.e eVar, int i) {
            this.a = str;
            this.b = context;
            this.c = eVar;
            this.d = i;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.a, this.b, this.c, this.d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    public class d implements O.a {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.c) {
                try {
                    i iVar = f.d;
                    ArrayList arrayList = (ArrayList) iVar.get(this.a);
                    if (arrayList == null) {
                        return;
                    }
                    iVar.remove(this.a);
                    for (int i = 0; i < arrayList.size(); i++) {
                        ((O.a) arrayList.get(i)).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final class e {
        public final Typeface a;
        public final int b;

        public e(int i) {
            this.a = null;
            this.b = i;
        }

        public boolean a() {
            return this.b == 0;
        }

        public e(Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }
    }

    public static String a(M.e eVar, int i) {
        return eVar.d() + "-" + i;
    }

    public static int b(g.a aVar) {
        int i = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        g.b[] b2 = aVar.b();
        if (b2 != null && b2.length != 0) {
            i = 0;
            for (g.b bVar : b2) {
                int b3 = bVar.b();
                if (b3 != 0) {
                    if (b3 < 0) {
                        return -3;
                    }
                    return b3;
                }
            }
        }
        return i;
    }

    public static e c(String str, Context context, M.e eVar, int i) {
        s.g gVar = a;
        Typeface typeface = (Typeface) gVar.get(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            g.a e2 = M.d.e(context, eVar, null);
            int b2 = b(e2);
            if (b2 != 0) {
                return new e(b2);
            }
            Typeface b3 = G.f.b(context, null, e2.b(), i);
            if (b3 == null) {
                return new e(-3);
            }
            gVar.put(str, b3);
            return new e(b3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    public static Typeface d(Context context, M.e eVar, int i, Executor executor, M.a aVar) {
        String a2 = a(eVar, i);
        Typeface typeface = (Typeface) a.get(a2);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (c) {
            try {
                i iVar = d;
                ArrayList arrayList = (ArrayList) iVar.get(a2);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                iVar.put(a2, arrayList2);
                c cVar = new c(a2, context, eVar, i);
                if (executor == null) {
                    executor = b;
                }
                h.b(executor, cVar, new d(a2));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface e(Context context, M.e eVar, M.a aVar, int i, int i2) {
        String a2 = a(eVar, i);
        Typeface typeface = (Typeface) a.get(a2);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        if (i2 == -1) {
            e c2 = c(a2, context, eVar, i);
            aVar.b(c2);
            return c2.a;
        }
        try {
            e eVar2 = (e) h.c(b, new a(a2, context, eVar, i), i2);
            aVar.b(eVar2);
            return eVar2.a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }
}

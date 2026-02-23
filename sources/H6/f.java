package h6;

import I5.F;
import I5.r;
import L.u;
import android.content.Context;
import android.util.Base64OutputStream;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import h6.j;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class f implements i, j {
    public final j6.b a;
    public final Context b;
    public final j6.b c;
    public final Set d;
    public final Executor e;

    public f(Context context, String str, Set set, j6.b bVar, Executor executor) {
        this(new c(context, str), set, executor, bVar, context);
    }

    public static /* synthetic */ String c(f fVar) {
        return fVar.i();
    }

    public static /* synthetic */ k d(Context context, String str) {
        return j(context, str);
    }

    public static /* synthetic */ f e(F f, I5.e eVar) {
        return h(f, eVar);
    }

    public static /* synthetic */ Void f(f fVar) {
        return fVar.k();
    }

    public static I5.c g() {
        F a = F.a(E5.a.class, Executor.class);
        return I5.c.f(f.class, i.class, j.class).b(r.k(Context.class)).b(r.k(A5.f.class)).b(r.n(g.class)).b(r.m(s6.i.class)).b(r.j(a)).f(new b(a)).d();
    }

    public static /* synthetic */ f h(F f, I5.e eVar) {
        return new f((Context) eVar.a(Context.class), ((A5.f) eVar.a(A5.f.class)).q(), eVar.c(g.class), eVar.g(s6.i.class), (Executor) eVar.b(f));
    }

    public static /* synthetic */ k j(Context context, String str) {
        return new k(context, str);
    }

    public Task a() {
        return u.a(this.b) ^ true ? Tasks.forResult("") : Tasks.call(this.e, new d(this));
    }

    public synchronized j.a b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        k kVar = (k) this.a.get();
        if (!kVar.i(currentTimeMillis)) {
            return j.a.NONE;
        }
        kVar.g();
        return j.a.GLOBAL;
    }

    public final /* synthetic */ String i() {
        String byteArrayOutputStream;
        synchronized (this) {
            try {
                k kVar = (k) this.a.get();
                List c = kVar.c();
                kVar.b();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < c.size(); i++) {
                    l lVar = (l) c.get(i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", lVar.c());
                    jSONObject.put("dates", new JSONArray(lVar.b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return byteArrayOutputStream;
    }

    public final /* synthetic */ Void k() {
        synchronized (this) {
            ((k) this.a.get()).k(System.currentTimeMillis(), ((s6.i) this.c.get()).a());
        }
        return null;
    }

    public Task l() {
        return this.d.size() <= 0 ? Tasks.forResult(null) : u.a(this.b) ^ true ? Tasks.forResult(null) : Tasks.call(this.e, new e(this));
    }

    public f(j6.b bVar, Set set, Executor executor, j6.b bVar2, Context context) {
        this.a = bVar;
        this.d = set;
        this.e = executor;
        this.c = bVar2;
        this.b = context;
    }
}

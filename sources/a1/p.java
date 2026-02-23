package a1;

import Q0.t;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class p implements Q0.f {
    public static final String d = Q0.k.f("WMFgUpdater");
    public final c1.a a;
    public final Y0.a b;
    public final Z0.q c;

    public class a implements Runnable {
        public final /* synthetic */ b1.c a;
        public final /* synthetic */ UUID c;
        public final /* synthetic */ Q0.e d;
        public final /* synthetic */ Context e;

        public a(b1.c cVar, UUID uuid, Q0.e eVar, Context context) {
            this.a = cVar;
            this.c = uuid;
            this.d = eVar;
            this.e = context;
        }

        public void run() {
            try {
                if (!this.a.isCancelled()) {
                    String uuid = this.c.toString();
                    t g = p.this.c.g(uuid);
                    if (g == null || g.isFinished()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    p.this.b.b(uuid, this.d);
                    this.e.startService(androidx.work.impl.foreground.a.a(this.e, uuid, this.d));
                }
                this.a.p(null);
            } catch (Throwable th) {
                this.a.q(th);
            }
        }
    }

    public p(WorkDatabase workDatabase, Y0.a aVar, c1.a aVar2) {
        this.b = aVar;
        this.a = aVar2;
        this.c = workDatabase.B();
    }

    public y5.b a(Context context, UUID uuid, Q0.e eVar) {
        b1.c t = b1.c.t();
        this.a.b(new a(t, uuid, eVar, context));
        return t;
    }
}

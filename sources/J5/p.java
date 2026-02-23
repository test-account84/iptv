package J5;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class p extends t.a implements ScheduledFuture {
    public final ScheduledFuture i;

    public class a implements b {
        public a() {
        }

        public void a(Throwable th) {
            p.v(p.this, th);
        }

        public void set(Object obj) {
            p.u(p.this, obj);
        }
    }

    public interface b {
        void a(Throwable th);

        void set(Object obj);
    }

    public interface c {
        ScheduledFuture a(b bVar);
    }

    public p(c cVar) {
        this.i = cVar.a(new a());
    }

    public static /* synthetic */ boolean u(p pVar, Object obj) {
        return pVar.q(obj);
    }

    public static /* synthetic */ boolean v(p pVar, Throwable th) {
        return pVar.r(th);
    }

    public void b() {
        this.i.cancel(t());
    }

    public long getDelay(TimeUnit timeUnit) {
        return this.i.getDelay(timeUnit);
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.i.compareTo(delayed);
    }
}

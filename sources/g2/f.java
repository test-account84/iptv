package g2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.security.MessageDigest;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f {
    public final c a;
    public final Q1.a b;
    public final Handler c;
    public boolean d;
    public boolean e;
    public O1.e f;
    public b g;
    public boolean h;

    public static class b extends o2.g {
        public final Handler d;
        public final int e;
        public final long f;
        public Bitmap g;

        public b(Handler handler, int i, long j) {
            this.d = handler;
            this.e = i;
            this.f = j;
        }

        public static /* synthetic */ int j(b bVar) {
            return bVar.e;
        }

        public Bitmap k() {
            return this.g;
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, n2.c cVar) {
            this.g = bitmap;
            this.d.sendMessageAtTime(this.d.obtainMessage(1, this), this.f);
        }
    }

    public interface c {
        void a(int i);
    }

    public class d implements Handler.Callback {
        public d() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                f.this.e((b) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            O1.g.g((b) message.obj);
            return false;
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this();
        }
    }

    public static class e implements S1.c {
        public final UUID a;

        public e() {
            this(UUID.randomUUID());
        }

        public void a(MessageDigest messageDigest) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return ((e) obj).a.equals(this.a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public e(UUID uuid) {
            this.a = uuid;
        }
    }

    public f(Context context, c cVar, Q1.a aVar, int i, int i2) {
        this(cVar, aVar, null, c(context, aVar, i, i2, O1.g.i(context).l()));
    }

    public static O1.e c(Context context, Q1.a aVar, int i, int i2, V1.b bVar) {
        h hVar = new h(bVar);
        g gVar = new g();
        return O1.g.u(context).w(gVar, Q1.a.class).c(aVar).a(Bitmap.class).u(c2.a.b()).i(hVar).t(true).j(U1.b.NONE).q(i, i2);
    }

    public void a() {
        h();
        b bVar = this.g;
        if (bVar != null) {
            O1.g.g(bVar);
            this.g = null;
        }
        this.h = true;
    }

    public Bitmap b() {
        b bVar = this.g;
        if (bVar != null) {
            return bVar.k();
        }
        return null;
    }

    public final void d() {
        if (!this.d || this.e) {
            return;
        }
        this.e = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.b.h();
        this.b.a();
        this.f.s(new e()).m(new b(this.c, this.b.d(), uptimeMillis));
    }

    public void e(b bVar) {
        if (this.h) {
            this.c.obtainMessage(2, bVar).sendToTarget();
            return;
        }
        b bVar2 = this.g;
        this.g = bVar;
        this.a.a(b.j(bVar));
        if (bVar2 != null) {
            this.c.obtainMessage(2, bVar2).sendToTarget();
        }
        this.e = false;
        d();
    }

    public void f(S1.g gVar) {
        if (gVar == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f = this.f.v(gVar);
    }

    public void g() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.h = false;
        d();
    }

    public void h() {
        this.d = false;
    }

    public f(c cVar, Q1.a aVar, Handler handler, O1.e eVar) {
        this.d = false;
        this.e = false;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new d(this, null)) : handler;
        this.a = cVar;
        this.b = aVar;
        this.c = handler;
        this.f = eVar;
    }
}

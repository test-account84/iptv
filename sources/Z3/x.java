package z3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import d4.K;
import d4.k0;
import java.util.HashMap;
import java.util.List;
import z3.s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class x extends Service {
    public static final HashMap l = new HashMap();
    public final c a;
    public final String c;
    public final int d;
    public final int e;
    public b f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;

    public static final class b implements s.d {
        public final Context a;
        public final s b;
        public final boolean c;
        public final A3.g d;
        public final Class e;
        public x f;
        public A3.c g;

        public b(Context context, s sVar, boolean z, A3.g gVar, Class cls) {
            this.a = context;
            this.b = sVar;
            this.c = z;
            this.d = gVar;
            this.e = cls;
            sVar.d(this);
            q();
        }

        public static /* synthetic */ void h(b bVar, x xVar) {
            bVar.m(xVar);
        }

        public static /* synthetic */ s i(b bVar) {
            return bVar.b;
        }

        public void a(s sVar, z3.c cVar, Exception exc) {
            x xVar = this.f;
            if (xVar != null) {
                x.c(xVar, cVar);
            }
            if (p() && x.d(cVar.b)) {
                d4.B.j("DownloadService", "DownloadService wasn't running. Restarting.");
                n();
            }
        }

        public void b(s sVar, A3.c cVar, int i) {
            q();
        }

        public final void c(s sVar) {
            x xVar = this.f;
            if (xVar != null) {
                x.f(xVar);
            }
        }

        public void d(s sVar, z3.c cVar) {
            x xVar = this.f;
            if (xVar != null) {
                x.e(xVar);
            }
        }

        public /* synthetic */ void e(s sVar, boolean z) {
            u.b(this, sVar, z);
        }

        public void f(s sVar, boolean z) {
            if (z || sVar.g() || !p()) {
                return;
            }
            List e = sVar.e();
            for (int i = 0; i < e.size(); i++) {
                if (((z3.c) e.get(i)).b == 0) {
                    n();
                    return;
                }
            }
        }

        public void g(s sVar) {
            x xVar = this.f;
            if (xVar != null) {
                x.b(xVar, sVar.e());
            }
        }

        public void j(x xVar) {
            d4.a.g(this.f == null);
            this.f = xVar;
            if (this.b.l()) {
                k0.z().postAtFrontOfQueue(new y(this, xVar));
            }
        }

        public final void k() {
            A3.c cVar = new A3.c(0);
            if (o(cVar)) {
                this.d.cancel();
                this.g = cVar;
            }
        }

        public void l(x xVar) {
            d4.a.g(this.f == xVar);
            this.f = null;
        }

        public final /* synthetic */ void m(x xVar) {
            x.b(xVar, this.b.e());
        }

        public final void n() {
            String str;
            if (this.c) {
                try {
                    k0.l1(this.a, x.h(this.a, this.e, "com.google.android.exoplayer.downloadService.action.RESTART"));
                    return;
                } catch (IllegalStateException unused) {
                    str = "Failed to restart (foreground launch restriction)";
                }
            } else {
                try {
                    this.a.startService(x.h(this.a, this.e, "com.google.android.exoplayer.downloadService.action.INIT"));
                    return;
                } catch (IllegalStateException unused2) {
                    str = "Failed to restart (process is idle)";
                }
            }
            d4.B.j("DownloadService", str);
        }

        public final boolean o(A3.c cVar) {
            return !k0.c(this.g, cVar);
        }

        public final boolean p() {
            x xVar = this.f;
            return xVar == null || x.g(xVar);
        }

        public boolean q() {
            boolean m = this.b.m();
            if (this.d == null) {
                return !m;
            }
            if (!m) {
                k();
                return true;
            }
            A3.c i = this.b.i();
            if (!this.d.b(i).equals(i)) {
                k();
                return false;
            }
            if (!o(i)) {
                return true;
            }
            if (this.d.a(i, this.a.getPackageName(), "com.google.android.exoplayer.downloadService.action.RESTART")) {
                this.g = i;
                return true;
            }
            d4.B.j("DownloadService", "Failed to schedule restart");
            k();
            return false;
        }

        public /* synthetic */ b(Context context, s sVar, boolean z, A3.g gVar, Class cls, a aVar) {
            this(context, sVar, z, gVar, cls);
        }
    }

    public final class c {
        public final int a;
        public final long b;
        public final Handler c = new Handler(Looper.getMainLooper());
        public boolean d;
        public boolean e;

        public c(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public static /* synthetic */ void a(c cVar) {
            cVar.f();
        }

        public void b() {
            if (this.e) {
                f();
            }
        }

        public void c() {
            if (this.e) {
                return;
            }
            f();
        }

        public void d() {
            this.d = true;
            f();
        }

        public void e() {
            this.d = false;
            this.c.removeCallbacksAndMessages((Object) null);
        }

        public final void f() {
            s i = b.i((b) d4.a.e(x.a(x.this)));
            Notification n = x.this.n(i.e(), i.h());
            if (this.e) {
                ((NotificationManager) x.this.getSystemService("notification")).notify(this.a, n);
            } else {
                x.this.startForeground(this.a, n);
                this.e = true;
            }
            if (this.d) {
                this.c.removeCallbacksAndMessages((Object) null);
                this.c.postDelayed(new z(this), this.b);
            }
        }
    }

    public x(int i, long j, String str, int i2, int i3) {
        if (i == 0) {
            this.a = null;
            this.c = null;
            this.d = 0;
            this.e = 0;
            return;
        }
        this.a = new c(i, j);
        this.c = str;
        this.d = i2;
        this.e = i3;
    }

    public static void A(Context context, Class cls) {
        context.startService(o(context, cls, "com.google.android.exoplayer.downloadService.action.INIT"));
    }

    public static void B(Context context, Class cls) {
        k0.l1(context, p(context, cls, "com.google.android.exoplayer.downloadService.action.INIT", true));
    }

    public static void C(Context context, Intent intent, boolean z) {
        if (z) {
            k0.l1(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static /* synthetic */ b a(x xVar) {
        return xVar.f;
    }

    public static /* synthetic */ void b(x xVar, List list) {
        xVar.v(list);
    }

    public static /* synthetic */ void c(x xVar, z3.c cVar) {
        xVar.t(cVar);
    }

    public static /* synthetic */ boolean d(int i) {
        return s(i);
    }

    public static /* synthetic */ void e(x xVar) {
        xVar.u();
    }

    public static /* synthetic */ void f(x xVar) {
        xVar.w();
    }

    public static /* synthetic */ boolean g(x xVar) {
        return xVar.r();
    }

    public static /* synthetic */ Intent h(Context context, Class cls, String str) {
        return o(context, cls, str);
    }

    public static Intent i(Context context, Class cls, w wVar, int i, boolean z) {
        return p(context, cls, "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD", z).putExtra("download_request", wVar).putExtra("stop_reason", i);
    }

    public static Intent j(Context context, Class cls, w wVar, boolean z) {
        return i(context, cls, wVar, 0, z);
    }

    public static Intent k(Context context, Class cls, String str, boolean z) {
        return p(context, cls, "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD", z).putExtra("content_id", str);
    }

    public static Intent l(Context context, Class cls, String str, int i, boolean z) {
        return p(context, cls, "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON", z).putExtra("content_id", str).putExtra("stop_reason", i);
    }

    public static Intent o(Context context, Class cls, String str) {
        return new Intent(context, cls).setAction(str);
    }

    public static Intent p(Context context, Class cls, String str, boolean z) {
        return o(context, cls, str).putExtra("foreground", z);
    }

    public static boolean s(int i) {
        return i == 2 || i == 5 || i == 7;
    }

    public static void x(Context context, Class cls, w wVar, boolean z) {
        C(context, j(context, cls, wVar, z), z);
    }

    public static void y(Context context, Class cls, String str, boolean z) {
        C(context, k(context, cls, str, z), z);
    }

    public static void z(Context context, Class cls, String str, int i, boolean z) {
        C(context, l(context, cls, str, i, z), z);
    }

    public abstract s m();

    public abstract Notification n(List list, int i);

    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    public void onCreate() {
        String str = this.c;
        if (str != null) {
            K.a(this, str, this.d, this.e, 2);
        }
        Class cls = getClass();
        HashMap hashMap = l;
        b bVar = (b) hashMap.get(cls);
        if (bVar == null) {
            boolean z = this.a != null;
            A3.g q = (z && (k0.a < 31)) ? q() : null;
            s m = m();
            m.w();
            bVar = new b(getApplicationContext(), m, z, q, cls, null);
            hashMap.put(cls, bVar);
        }
        this.f = bVar;
        bVar.j(this);
    }

    public void onDestroy() {
        this.k = true;
        ((b) d4.a.e(this.f)).l(this);
        c cVar = this.a;
        if (cVar != null) {
            cVar.e();
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        String str;
        String str2;
        s i3;
        c cVar;
        String str3;
        this.g = i2;
        this.i = false;
        if (intent != null) {
            str = intent.getAction();
            str2 = intent.getStringExtra("content_id");
            this.h |= intent.getBooleanExtra("foreground", false) || "com.google.android.exoplayer.downloadService.action.RESTART".equals(str);
        } else {
            str = null;
            str2 = null;
        }
        if (str == null) {
            str = "com.google.android.exoplayer.downloadService.action.INIT";
        }
        i3 = b.i((b) d4.a.e(this.f));
        switch (str) {
            case "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD":
                w wVar = (w) ((Intent) d4.a.e(intent)).getParcelableExtra("download_request");
                if (wVar != null) {
                    i3.c(wVar, intent.getIntExtra("stop_reason", 0));
                    break;
                } else {
                    str3 = "Ignored ADD_DOWNLOAD: Missing download_request extra";
                    d4.B.d("DownloadService", str3);
                    break;
                }
            case "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS":
                i3.w();
                break;
            case "com.google.android.exoplayer.downloadService.action.RESTART":
            case "com.google.android.exoplayer.downloadService.action.INIT":
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS":
                i3.u();
                break;
            case "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS":
                A3.c cVar2 = (A3.c) ((Intent) d4.a.e(intent)).getParcelableExtra("requirements");
                if (cVar2 != null) {
                    i3.z(cVar2);
                    break;
                } else {
                    str3 = "Ignored SET_REQUIREMENTS: Missing requirements extra";
                    d4.B.d("DownloadService", str3);
                    break;
                }
            case "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS":
                i3.t();
                break;
            case "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON":
                if (!((Intent) d4.a.e(intent)).hasExtra("stop_reason")) {
                    str3 = "Ignored SET_STOP_REASON: Missing stop_reason extra";
                    d4.B.d("DownloadService", str3);
                    break;
                } else {
                    i3.A(str2, intent.getIntExtra("stop_reason", 0));
                    break;
                }
            case "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD":
                if (str2 != null) {
                    i3.v(str2);
                    break;
                } else {
                    str3 = "Ignored REMOVE_DOWNLOAD: Missing content_id extra";
                    d4.B.d("DownloadService", str3);
                    break;
                }
            default:
                str3 = "Ignored unrecognized action: " + str;
                d4.B.d("DownloadService", str3);
                break;
        }
        if (k0.a >= 26 && this.h && (cVar = this.a) != null) {
            cVar.c();
        }
        this.j = false;
        if (i3.k()) {
            w();
        }
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        this.i = true;
    }

    public abstract A3.g q();

    public final boolean r() {
        return this.j;
    }

    public final void t(z3.c cVar) {
        if (this.a != null) {
            if (s(cVar.b)) {
                this.a.d();
            } else {
                this.a.b();
            }
        }
    }

    public final void u() {
        c cVar = this.a;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void v(List list) {
        if (this.a != null) {
            for (int i = 0; i < list.size(); i++) {
                if (s(((z3.c) list.get(i)).b)) {
                    this.a.d();
                    return;
                }
            }
        }
    }

    public final void w() {
        boolean stopSelfResult;
        c cVar = this.a;
        if (cVar != null) {
            cVar.e();
        }
        if (((b) d4.a.e(this.f)).q()) {
            if (k0.a >= 28 || !this.i) {
                stopSelfResult = this.j | stopSelfResult(this.g);
            } else {
                stopSelf();
                stopSelfResult = true;
            }
            this.j = stopSelfResult;
        }
    }
}

package O5;

import O5.s;
import Q5.B;
import Q5.D;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class m {
    public static final FilenameFilter s = new l();
    public final Context a;
    public final u b;
    public final p c;
    public final P5.h d;
    public final k e;
    public final y f;
    public final T5.f g;
    public final O5.a h;
    public final P5.c i;
    public final L5.a j;
    public final M5.a k;
    public final O l;
    public s m;
    public V5.i n = null;
    public final TaskCompletionSource o = new TaskCompletionSource();
    public final TaskCompletionSource p = new TaskCompletionSource();
    public final TaskCompletionSource q = new TaskCompletionSource();
    public final AtomicBoolean r = new AtomicBoolean(false);

    public class a implements s.a {
        public a() {
        }

        public void a(V5.i iVar, Thread thread, Throwable th) {
            m.this.H(iVar, thread, th);
        }
    }

    public class b implements Callable {
        public final /* synthetic */ long a;
        public final /* synthetic */ Throwable b;
        public final /* synthetic */ Thread c;
        public final /* synthetic */ V5.i d;
        public final /* synthetic */ boolean e;

        public class a implements SuccessContinuation {
            public final /* synthetic */ Executor a;
            public final /* synthetic */ String b;

            public a(Executor executor, String str) {
                this.a = executor;
                this.b = str;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task then(V5.d dVar) {
                if (dVar != null) {
                    return Tasks.whenAll(m.n(m.this), m.h(m.this).w(this.a, b.this.e ? this.b : null));
                }
                L5.f.f().k("Received null app settings, cannot send reports at crash time.");
                return Tasks.forResult(null);
            }
        }

        public b(long j, Throwable th, Thread thread, V5.i iVar, boolean z) {
            this.a = j;
            this.b = th;
            this.c = thread;
            this.d = iVar;
            this.e = z;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task call() {
            long b = m.b(this.a);
            String c = m.c(m.this);
            if (c == null) {
                L5.f.f().d("Tried to write a fatal exception while no session was open.");
                return Tasks.forResult(null);
            }
            m.g(m.this).a();
            m.h(m.this).s(this.b, this.c, c, b);
            m.i(m.this, this.a);
            m.this.t(this.d);
            m.k(m.this, new h(m.j(m.this)).toString());
            if (!m.l(m.this).d()) {
                return Tasks.forResult(null);
            }
            Executor c2 = m.m(m.this).c();
            return this.d.a().onSuccessTask(c2, new a(c2, c));
        }
    }

    public class c implements SuccessContinuation {
        public c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task then(Void r1) {
            return Tasks.forResult(Boolean.TRUE);
        }
    }

    public class d implements SuccessContinuation {
        public final /* synthetic */ Task a;

        public class a implements Callable {
            public final /* synthetic */ Boolean a;

            public class a implements SuccessContinuation {
                public final /* synthetic */ Executor a;

                public a(Executor executor) {
                    this.a = executor;
                }

                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Task then(V5.d dVar) {
                    if (dVar == null) {
                        L5.f.f().k("Received null app settings at app startup. Cannot send cached reports");
                    } else {
                        m.n(m.this);
                        m.h(m.this).v(this.a);
                        m.this.q.trySetResult(null);
                    }
                    return Tasks.forResult(null);
                }
            }

            public a(Boolean bool) {
                this.a = bool;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task call() {
                if (this.a.booleanValue()) {
                    L5.f.f().b("Sending cached crash reports...");
                    m.l(m.this).c(this.a.booleanValue());
                    Executor c = m.m(m.this).c();
                    return d.this.a.onSuccessTask(c, new a(c));
                }
                L5.f.f().i("Deleting cached crash reports...");
                m.d(m.this.L());
                m.h(m.this).u();
                m.this.q.trySetResult(null);
                return Tasks.forResult(null);
            }
        }

        public d(Task task) {
            this.a = task;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task then(Boolean bool) {
            return m.m(m.this).h(new a(bool));
        }
    }

    public class e implements Callable {
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;

        public e(long j, String str) {
            this.a = j;
            this.b = str;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            if (m.this.J()) {
                return null;
            }
            m.e(m.this).g(this.a, this.b);
            return null;
        }
    }

    public class f implements Callable {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            m.k(m.this, this.a);
            return null;
        }
    }

    public class g implements Callable {
        public final /* synthetic */ long a;

        public g(long j) {
            this.a = j;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong("timestamp", this.a);
            m.f(m.this).a("_ae", bundle);
            return null;
        }
    }

    public m(Context context, k kVar, y yVar, u uVar, T5.f fVar, p pVar, O5.a aVar, P5.h hVar, P5.c cVar, O o, L5.a aVar2, M5.a aVar3) {
        this.a = context;
        this.e = kVar;
        this.f = yVar;
        this.b = uVar;
        this.g = fVar;
        this.c = pVar;
        this.h = aVar;
        this.d = hVar;
        this.i = cVar;
        this.j = aVar2;
        this.k = aVar3;
        this.l = o;
    }

    public static boolean A() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static long C() {
        return F(System.currentTimeMillis());
    }

    public static List D(L5.g gVar, String str, T5.f fVar, byte[] bArr) {
        File o = fVar.o(str, "user-data");
        File o2 = fVar.o(str, "keys");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new O5.g("logs_file", "logs", bArr));
        arrayList.add(new x("crash_meta_file", "metadata", gVar.d()));
        arrayList.add(new x("session_meta_file", "session", gVar.g()));
        arrayList.add(new x("app_meta_file", "app", gVar.e()));
        arrayList.add(new x("device_meta_file", "device", gVar.a()));
        arrayList.add(new x("os_meta_file", "os", gVar.f()));
        arrayList.add(P(gVar));
        arrayList.add(new x("user_meta_file", "user", o));
        arrayList.add(new x("keys_file", "keys", o2));
        return arrayList;
    }

    public static long F(long j) {
        return j / 1000;
    }

    public static /* synthetic */ boolean K(File file, String str) {
        return str.startsWith(".ae");
    }

    public static boolean O(String str, File file, B.a aVar) {
        if (file == null || !file.exists()) {
            L5.f.f().k("No minidump data found for session " + str);
        }
        if (aVar == null) {
            L5.f.f().g("No Tombstones data found for session " + str);
        }
        return (file == null || !file.exists()) && aVar == null;
    }

    public static B P(L5.g gVar) {
        File c2 = gVar.c();
        return (c2 == null || !c2.exists()) ? new O5.g("minidump_file", "minidump", new byte[]{0}) : new x("minidump_file", "minidump", c2);
    }

    public static byte[] R(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static /* synthetic */ boolean a(File file, String str) {
        return K(file, str);
    }

    public static /* synthetic */ long b(long j) {
        return F(j);
    }

    public static /* synthetic */ String c(m mVar) {
        return mVar.B();
    }

    public static /* synthetic */ void d(List list) {
        r(list);
    }

    public static /* synthetic */ P5.c e(m mVar) {
        return mVar.i;
    }

    public static /* synthetic */ M5.a f(m mVar) {
        return mVar.k;
    }

    public static /* synthetic */ p g(m mVar) {
        return mVar.c;
    }

    public static /* synthetic */ O h(m mVar) {
        return mVar.l;
    }

    public static /* synthetic */ void i(m mVar, long j) {
        mVar.w(j);
    }

    public static /* synthetic */ y j(m mVar) {
        return mVar.f;
    }

    public static /* synthetic */ void k(m mVar, String str) {
        mVar.v(str);
    }

    public static /* synthetic */ u l(m mVar) {
        return mVar.b;
    }

    public static /* synthetic */ k m(m mVar) {
        return mVar.e;
    }

    public static /* synthetic */ Task n(m mVar) {
        return mVar.N();
    }

    public static D.a o(y yVar, O5.a aVar) {
        return D.a.b(yVar.f(), aVar.f, aVar.g, yVar.a().c(), v.determineFrom(aVar.d).getId(), aVar.h);
    }

    public static D.b p() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return D.b.c(i.m(), Build.MODEL, Runtime.getRuntime().availableProcessors(), i.t(), statFs.getBlockCount() * statFs.getBlockSize(), i.z(), i.n(), Build.MANUFACTURER, Build.PRODUCT);
    }

    public static D.c q() {
        return D.c.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, i.A());
    }

    public static void r(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public final String B() {
        SortedSet o = this.l.o();
        if (o.isEmpty()) {
            return null;
        }
        return (String) o.first();
    }

    public final InputStream E(String str) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            L5.f.f().k("Couldn't get Class Loader");
            return null;
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        L5.f.f().g("No version control information found");
        return null;
    }

    public String G() {
        InputStream E = E("META-INF/version-control-info.textproto");
        if (E == null) {
            return null;
        }
        L5.f.f().b("Read version control info");
        return Base64.encodeToString(R(E), 0);
    }

    public void H(V5.i iVar, Thread thread, Throwable th) {
        I(iVar, thread, th, false);
    }

    public synchronized void I(V5.i iVar, Thread thread, Throwable th, boolean z) {
        L5.f.f().b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        try {
            W.f(this.e.h(new b(System.currentTimeMillis(), th, thread, iVar, z)));
        } catch (Exception e2) {
            L5.f.f().e("Error handling uncaught exception", e2);
        } catch (TimeoutException unused) {
            L5.f.f().d("Cannot send reports. Timed out while fetching settings.");
        }
    }

    public boolean J() {
        s sVar = this.m;
        return sVar != null && sVar.a();
    }

    public List L() {
        return this.g.f(s);
    }

    public final Task M(long j) {
        if (A()) {
            L5.f.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult(null);
        }
        L5.f.f().b("Logging app exception event to Firebase Analytics");
        return Tasks.call(new ScheduledThreadPoolExecutor(1), new g(j));
    }

    public final Task N() {
        ArrayList arrayList = new ArrayList();
        for (File file : L()) {
            try {
                arrayList.add(M(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                L5.f.f().k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll((Collection) arrayList);
    }

    public void Q(String str) {
        this.e.g(new f(str));
    }

    public void S() {
        try {
            String G = G();
            if (G != null) {
                T("com.crashlytics.version-control-info", G);
                L5.f.f().g("Saved version control info");
            }
        } catch (IOException e2) {
            L5.f.f().l("Unable to save version control info", e2);
        }
    }

    public void T(String str, String str2) {
        try {
            this.d.h(str, str2);
        } catch (IllegalArgumentException e2) {
            Context context = this.a;
            if (context != null && i.x(context)) {
                throw e2;
            }
            L5.f.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    public Task U(Task task) {
        if (this.l.m()) {
            L5.f.f().i("Crash reports are available to be sent.");
            return V().onSuccessTask(new d(task));
        }
        L5.f.f().i("No crash reports are available to be sent.");
        this.o.trySetResult(Boolean.FALSE);
        return Tasks.forResult(null);
    }

    public final Task V() {
        if (this.b.d()) {
            L5.f.f().b("Automatic data collection is enabled. Allowing upload.");
            this.o.trySetResult(Boolean.FALSE);
            return Tasks.forResult(Boolean.TRUE);
        }
        L5.f.f().b("Automatic data collection is disabled.");
        L5.f.f().i("Notifying that unsent reports are available.");
        this.o.trySetResult(Boolean.TRUE);
        Task onSuccessTask = this.b.h().onSuccessTask(new c());
        L5.f.f().b("Waiting for send/deleteUnsentReports to be called.");
        return W.n(onSuccessTask, this.p.getTask());
    }

    public final void W(String str) {
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            L5.f.f().i("ANR feature enabled, but device is API " + i);
            return;
        }
        List a2 = a1.c.a((ActivityManager) this.a.getSystemService("activity"), (String) null, 0, 0);
        if (a2.size() != 0) {
            this.l.t(str, a2, new P5.c(this.g, str), P5.h.f(str, this.g, this.e));
        } else {
            L5.f.f().i("No ApplicationExitInfo available. Session: " + str);
        }
    }

    public void X(long j, String str) {
        this.e.g(new e(j, str));
    }

    public boolean s() {
        if (!this.c.c()) {
            String B = B();
            return B != null && this.j.d(B);
        }
        L5.f.f().i("Found previous crash marker.");
        this.c.d();
        return true;
    }

    public void t(V5.i iVar) {
        u(false, iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u(boolean z, V5.i iVar) {
        ArrayList arrayList = new ArrayList(this.l.o());
        if (arrayList.size() <= z) {
            L5.f.f().i("No open sessions to be closed.");
            return;
        }
        String str = (String) arrayList.get(z ? 1 : 0);
        if (iVar.b().b.b) {
            W(str);
        } else {
            L5.f.f().i("ANR feature disabled.");
        }
        if (this.j.d(str)) {
            y(str);
        }
        this.l.j(C(), z != 0 ? (String) arrayList.get(0) : null);
    }

    public final void v(String str) {
        long C = C();
        L5.f.f().b("Opening a new session with ID " + str);
        this.j.c(str, String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{o.i()}), C, Q5.D.b(o(this.f, this.h), q(), p()));
        this.i.e(str);
        this.l.p(str, C);
    }

    public final void w(long j) {
        try {
            if (this.g.e(".ae" + j).createNewFile()) {
            } else {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e2) {
            L5.f.f().l("Could not create app exception marker file.", e2);
        }
    }

    public void x(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, V5.i iVar) {
        this.n = iVar;
        Q(str);
        s sVar = new s(new a(), iVar, uncaughtExceptionHandler, this.j);
        this.m = sVar;
        Thread.setDefaultUncaughtExceptionHandler(sVar);
    }

    public final void y(String str) {
        L5.f.f().i("Finalizing native report for session " + str);
        L5.g a2 = this.j.a(str);
        File c2 = a2.c();
        B.a b2 = a2.b();
        if (O(str, c2, b2)) {
            L5.f.f().k("No native core present");
            return;
        }
        long lastModified = c2.lastModified();
        P5.c cVar = new P5.c(this.g, str);
        File i = this.g.i(str);
        if (!i.isDirectory()) {
            L5.f.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        w(lastModified);
        List D = D(a2, str, this.g, cVar.b());
        C.b(i, D);
        L5.f.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.l.i(str, D, b2);
        cVar.a();
    }

    public boolean z(V5.i iVar) {
        this.e.b();
        if (J()) {
            L5.f.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        L5.f.f().i("Finalizing previously open sessions.");
        try {
            u(true, iVar);
            L5.f.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e2) {
            L5.f.f().e("Unable to finalize previously open sessions.", e2);
            return false;
        }
    }
}

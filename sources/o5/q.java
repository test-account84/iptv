package O5;

import Q5.B;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class q {
    public static final Map f;
    public static final String g;
    public final Context a;
    public final y b;
    public final a c;
    public final W5.d d;
    public final V5.i e;

    static {
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
        g = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{"18.4.1"});
    }

    public q(Context context, y yVar, a aVar, W5.d dVar, V5.i iVar) {
        this.a = context;
        this.b = yVar;
        this.c = aVar;
        this.d = dVar;
        this.e = iVar;
    }

    public static int f() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = (Integer) f.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    public final B.a a(B.a aVar) {
        Q5.C c;
        if (!this.e.b().b.c || this.c.c.size() <= 0) {
            c = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (f fVar : this.c.c) {
                arrayList.add(B.a.a.a().d(fVar.c()).b(fVar.a()).c(fVar.b()).a());
            }
            c = Q5.C.a(arrayList);
        }
        return B.a.a().c(aVar.c()).e(aVar.e()).g(aVar.g()).i(aVar.i()).d(aVar.d()).f(aVar.f()).h(aVar.h()).j(aVar.j()).b(c).a();
    }

    public final B.b b() {
        return Q5.B.b().j("18.4.1").f(this.c.a).g(this.b.a().c()).e(this.b.a().d()).c(this.c.f).d(this.c.g).i(4);
    }

    public B.e.d c(B.a aVar) {
        int i = this.a.getResources().getConfiguration().orientation;
        return B.e.d.a().f("anr").e(aVar.i()).b(i(i, a(aVar))).c(k(i)).a();
    }

    public B.e.d d(Throwable th, Thread thread, String str, long j, int i, int i2, boolean z) {
        int i3 = this.a.getResources().getConfiguration().orientation;
        return B.e.d.a().f(str).e(j).b(j(i3, new W5.e(th, this.d), thread, i, i2, z)).c(k(i3)).a();
    }

    public Q5.B e(String str, long j) {
        return b().k(s(str, j)).a();
    }

    public final B.e.d.a.b.a g() {
        return B.e.d.a.b.a.a().b(0L).d(0L).c(this.c.e).e(this.c.b).a();
    }

    public final Q5.C h() {
        return Q5.C.b(g());
    }

    public final B.e.d.a i(int i, B.a aVar) {
        return B.e.d.a.a().b(Boolean.valueOf(aVar.c() != 100)).f(i).d(n(aVar)).a();
    }

    public final B.e.d.a j(int i, W5.e eVar, Thread thread, int i2, int i3, boolean z) {
        Boolean bool;
        ActivityManager.RunningAppProcessInfo j = i.j(this.c.e, this.a);
        if (j != null) {
            bool = Boolean.valueOf(j.importance != 100);
        } else {
            bool = null;
        }
        return B.e.d.a.a().b(bool).f(i).d(o(eVar, thread, i2, i3, z)).a();
    }

    public final B.e.d.c k(int i) {
        e a = e.a(this.a);
        Float b = a.b();
        Double valueOf = b != null ? Double.valueOf(b.doubleValue()) : null;
        int c = a.c();
        boolean p = i.p(this.a);
        return B.e.d.c.a().b(valueOf).c(c).f(p).e(i).g(i.t() - i.a(this.a)).d(i.b(Environment.getDataDirectory().getPath())).a();
    }

    public final B.e.d.a.b.c l(W5.e eVar, int i, int i2) {
        return m(eVar, i, i2, 0);
    }

    public final B.e.d.a.b.c m(W5.e eVar, int i, int i2, int i3) {
        String str = eVar.b;
        String str2 = eVar.a;
        StackTraceElement[] stackTraceElementArr = eVar.c;
        int i4 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        W5.e eVar2 = eVar.d;
        if (i3 >= i2) {
            W5.e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.d;
                i4++;
            }
        }
        B.e.d.a.b.c.a d = B.e.d.a.b.c.a().f(str).e(str2).c(Q5.C.a(q(stackTraceElementArr, i))).d(i4);
        if (eVar2 != null && i4 == 0) {
            d.b(m(eVar2, i, i2, i3 + 1));
        }
        return d.a();
    }

    public final B.e.d.a.b n(B.a aVar) {
        return B.e.d.a.b.a().b(aVar).e(v()).c(h()).a();
    }

    public final B.e.d.a.b o(W5.e eVar, Thread thread, int i, int i2, boolean z) {
        return B.e.d.a.b.a().f(y(eVar, thread, i, z)).d(l(eVar, i, i2)).e(v()).c(h()).a();
    }

    public final B.e.d.a.b.e.b p(StackTraceElement stackTraceElement, B.e.d.a.b.e.b.a aVar) {
        long j = 0;
        long max = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j = stackTraceElement.getLineNumber();
        }
        return aVar.e(max).f(str).b(fileName).d(j).a();
    }

    public final Q5.C q(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(p(stackTraceElement, B.e.d.a.b.e.b.a().c(i)));
        }
        return Q5.C.a(arrayList);
    }

    public final B.e.a r() {
        return B.e.a.a().e(this.b.f()).g(this.c.f).d(this.c.g).f(this.b.a().c()).b(this.c.h.d()).c(this.c.h.e()).a();
    }

    public final B.e s(String str, long j) {
        return B.e.a().m(j).j(str).h(g).b(r()).l(u()).e(t()).i(3).a();
    }

    public final B.e.c t() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int f2 = f();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long t = i.t();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean z = i.z();
        int n = i.n();
        return B.e.c.a().b(f2).f(Build.MODEL).c(availableProcessors).h(t).d(blockCount).i(z).j(n).e(Build.MANUFACTURER).g(Build.PRODUCT).a();
    }

    public final B.e.e u() {
        return B.e.e.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(i.A()).a();
    }

    public final B.e.d.a.b.d v() {
        return B.e.d.a.b.d.a().d("0").c("0").b(0L).a();
    }

    public final B.e.d.a.b.e w(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return x(thread, stackTraceElementArr, 0);
    }

    public final B.e.d.a.b.e x(Thread thread, StackTraceElement[] stackTraceElementArr, int i) {
        return B.e.d.a.b.e.a().d(thread.getName()).c(i).b(Q5.C.a(q(stackTraceElementArr, i))).a();
    }

    public final Q5.C y(W5.e eVar, Thread thread, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x(thread, eVar.c, i));
        if (z) {
            for (Map.Entry entry : Thread.getAllStackTraces().entrySet()) {
                Thread thread2 = (Thread) entry.getKey();
                if (!thread2.equals(thread)) {
                    arrayList.add(w(thread2, this.d.a((StackTraceElement[]) entry.getValue())));
                }
            }
        }
        return Q5.C.a(arrayList);
    }
}

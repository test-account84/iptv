package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignalsAdapter;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class alx {
    private final List a = new ArrayList(0);
    private final TaskCompletionSource b = new TaskCompletionSource();
    private final TaskCompletionSource c = new TaskCompletionSource();
    private final Context d;
    private final ExecutorService e;
    private final alm f;
    private Integer g;

    public alx(Context context, ExecutorService executorService, alm almVar) {
        this.d = context;
        this.e = executorService;
        this.f = almVar;
    }

    public static /* synthetic */ Task a(alx alxVar, Task task) {
        List list = (List) task.getResult();
        return Tasks.whenAllComplete((Collection) list).continueWith(alxVar.e, new alu(list, 1));
    }

    public static /* synthetic */ void f(alx alxVar) {
        alxVar.c.trySetResult(alxVar.a);
    }

    private final void i(com.google.ads.interactivemedia.v3.impl.data.bj bjVar, Exception exc) {
        this.f.b(com.google.ads.interactivemedia.v3.impl.data.bi.NATIVE_ESP, bjVar, exc);
    }

    private final void j(alt altVar) {
        this.a.remove(altVar);
    }

    private static final Exception k(alt altVar, Exception exc) {
        return new Exception("Exception with SecureSignalsAdapter " + altVar.e() + ":" + altVar.f(), exc);
    }

    public final List b() {
        try {
            Task continueWith = this.c.getTask().continueWith(this.e, new alu(this, 0)).continueWithTask(this.e, new alu(this, 2)).continueWith(this.e, new alu(this, 3));
            return (List) Tasks.await(this.g == null ? Tasks.forResult(new ArrayList()) : Tasks.withTimeout(continueWith, r1.intValue(), TimeUnit.MILLISECONDS).addOnFailureListener(new alo(this, 2)));
        } catch (InterruptedException | ExecutionException unused) {
            return new ArrayList();
        }
    }

    public final /* synthetic */ void c(Exception exc) {
        i(com.google.ads.interactivemedia.v3.impl.data.bj.COLLECT_SIGNALS, exc);
    }

    public final /* synthetic */ void d(alt altVar, Exception exc) {
        j(altVar);
        i(com.google.ads.interactivemedia.v3.impl.data.bj.COLLECT_SIGNALS, k(altVar, exc));
    }

    public final /* synthetic */ void e(alt altVar, Exception exc) {
        j(altVar);
        i(com.google.ads.interactivemedia.v3.impl.data.bj.INIT, k(altVar, exc));
    }

    public final void g() {
        this.b.getTask().continueWith(this.e, new alu(this, 4)).continueWithTask(this.e, new alu(this, 2)).continueWith(this.e, new alu(this, 3)).continueWith(this.e, new alu(this, 5));
        this.c.getTask();
    }

    public final void h(List list, Integer num) {
        if (num.intValue() == 0) {
            this.b.trySetException(new Exception("No adapters to load"));
        } else {
            this.g = num;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                alt altVar = null;
                try {
                    int i = 0;
                    Class cls = Class.forName(str, false, alx.class.getClassLoader());
                    Class[] interfaces = cls.getInterfaces();
                    String name = SecureSignalsAdapter.class.getName();
                    int length = interfaces.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        if (interfaces[i].getName().equals(name)) {
                            altVar = new alt((SecureSignalsAdapter) cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null), str, this.d);
                            break;
                        }
                        i++;
                    }
                } catch (Throwable unused) {
                }
                if (altVar != null) {
                    try {
                        this.a.add(altVar);
                    } catch (Exception e) {
                        i(com.google.ads.interactivemedia.v3.impl.data.bj.LOAD_ADAPTER, new Exception("Exception with SecureSignalsAdapter ".concat(String.valueOf(str)), e));
                    }
                }
            }
            this.b.trySetResult(this.a);
        }
        this.b.getTask();
    }
}

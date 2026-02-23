package androidx.emoji2.text;

import L.t;
import android.content.Context;
import androidx.emoji2.text.e;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class EmojiCompatInitializer implements I0.b {

    public class 1 implements androidx.lifecycle.d {
        public final /* synthetic */ androidx.lifecycle.j a;

        public 1(androidx.lifecycle.j jVar) {
            this.a = jVar;
        }

        public /* synthetic */ void a(androidx.lifecycle.p pVar) {
            androidx.lifecycle.c.a(this, pVar);
        }

        public void d(androidx.lifecycle.p pVar) {
            EmojiCompatInitializer.this.e();
            this.a.c(this);
        }

        public /* synthetic */ void f(androidx.lifecycle.p pVar) {
            androidx.lifecycle.c.c(this, pVar);
        }

        public /* synthetic */ void g(androidx.lifecycle.p pVar) {
            androidx.lifecycle.c.e(this, pVar);
        }

        public /* synthetic */ void h(androidx.lifecycle.p pVar) {
            androidx.lifecycle.c.b(this, pVar);
        }

        public /* synthetic */ void i(androidx.lifecycle.p pVar) {
            androidx.lifecycle.c.d(this, pVar);
        }
    }

    public static class a extends e.c {
        public a(Context context) {
            super(new b(context));
            b(1);
        }
    }

    public static class b implements e.g {
        public final Context a;

        public class a extends e.h {
            public final /* synthetic */ e.h a;
            public final /* synthetic */ ThreadPoolExecutor b;

            public a(e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
                this.a = hVar;
                this.b = threadPoolExecutor;
            }

            public void a(Throwable th) {
                try {
                    this.a.a(th);
                } finally {
                    this.b.shutdown();
                }
            }

            public void b(m mVar) {
                try {
                    this.a.b(mVar);
                } finally {
                    this.b.shutdown();
                }
            }
        }

        public b(Context context) {
            this.a = context.getApplicationContext();
        }

        public static /* synthetic */ void b(b bVar, e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
            bVar.d(hVar, threadPoolExecutor);
        }

        public void a(e.h hVar) {
            ThreadPoolExecutor b = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            b.execute(new f(this, hVar, b));
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                j a2 = androidx.emoji2.text.c.a(this.a);
                if (a2 == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                a2.c(threadPoolExecutor);
                a2.a().a(new a(hVar, threadPoolExecutor));
            } catch (Throwable th) {
                hVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    public static class c implements Runnable {
        public void run() {
            try {
                t.a("EmojiCompat.EmojiCompatInitializer.run");
                if (e.h()) {
                    e.b().k();
                }
            } finally {
                t.b();
            }
        }
    }

    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        e.g(new a(context));
        d(context);
        return Boolean.TRUE;
    }

    public void d(Context context) {
        androidx.lifecycle.j lifecycle = ((androidx.lifecycle.p) I0.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new 1(lifecycle));
    }

    public void e() {
        androidx.emoji2.text.b.d().postDelayed(new c(), 500L);
    }
}

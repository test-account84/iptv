package androidx.lifecycle;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.j;
import androidx.lifecycle.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class x implements p {
    public static final x j = new x();
    public Handler f;
    public int a = 0;
    public int c = 0;
    public boolean d = true;
    public boolean e = true;
    public final q g = new q(this);
    public Runnable h = new a();
    public z.a i = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            x.this.f();
            x.this.g();
        }
    }

    public class b implements z.a {
        public b() {
        }

        public void a() {
        }

        public void onResume() {
            x.this.b();
        }

        public void onStart() {
            x.this.c();
        }
    }

    public class c extends e {

        public class a extends e {
            public a() {
            }

            public void onActivityPostResumed(Activity activity) {
                x.this.b();
            }

            public void onActivityPostStarted(Activity activity) {
                x.this.c();
            }
        }

        public c() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                z.f(activity).h(x.this.i);
            }
        }

        public void onActivityPaused(Activity activity) {
            x.this.a();
        }

        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            y.a(activity, new a());
        }

        public void onActivityStopped(Activity activity) {
            x.this.d();
        }
    }

    public static p h() {
        return j;
    }

    public static void i(Context context) {
        j.e(context);
    }

    public void a() {
        int i = this.c - 1;
        this.c = i;
        if (i == 0) {
            this.f.postDelayed(this.h, 700L);
        }
    }

    public void b() {
        int i = this.c + 1;
        this.c = i;
        if (i == 1) {
            if (!this.d) {
                this.f.removeCallbacks(this.h);
            } else {
                this.g.h(j.b.ON_RESUME);
                this.d = false;
            }
        }
    }

    public void c() {
        int i = this.a + 1;
        this.a = i;
        if (i == 1 && this.e) {
            this.g.h(j.b.ON_START);
            this.e = false;
        }
    }

    public void d() {
        this.a--;
        g();
    }

    public void e(Context context) {
        this.f = new Handler();
        this.g.h(j.b.ON_CREATE);
        context.getApplicationContext().registerActivityLifecycleCallbacks(new c());
    }

    public void f() {
        if (this.c == 0) {
            this.d = true;
            this.g.h(j.b.ON_PAUSE);
        }
    }

    public void g() {
        if (this.a == 0 && this.d) {
            this.g.h(j.b.ON_STOP);
            this.e = true;
        }
    }

    public j getLifecycle() {
        return this.g;
    }
}

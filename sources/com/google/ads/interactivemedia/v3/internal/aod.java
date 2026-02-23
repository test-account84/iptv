package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aod implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private final Context b;
    private Application c;
    private final PowerManager d;
    private final KeyguardManager e;
    private BroadcastReceiver f;
    private final anr g;
    private WeakReference h;
    private WeakReference i;
    private ano j;
    private byte k = -1;
    private int l = -1;
    private long m = -3;

    public aod(Context context, anr anrVar) {
        Application applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.g = anrVar;
        this.d = (PowerManager) applicationContext.getSystemService("power");
        this.e = (KeyguardManager) applicationContext.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            Application application = applicationContext;
            this.c = application;
            this.j = new ano(application, this);
        }
        d(null);
    }

    public static /* bridge */ /* synthetic */ void c(aod aodVar) {
        aodVar.f();
    }

    private final void e(Activity activity, int i) {
        Window window;
        if (this.i == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View b = b();
        if (b == null || peekDecorView == null || b.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.l = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void f() {
        /*
            r7 = this;
            java.lang.ref.WeakReference r0 = r7.i
            if (r0 != 0) goto L5
            return
        L5:
            android.view.View r0 = r7.b()
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L13
            r7.m = r2
            r7.k = r1
            return
        L13:
            int r4 = r0.getVisibility()
            if (r4 == 0) goto L1b
            r4 = 1
            goto L1c
        L1b:
            r4 = 0
        L1c:
            boolean r5 = r0.isShown()
            if (r5 != 0) goto L24
            r4 = r4 | 2
        L24:
            android.os.PowerManager r5 = r7.d
            if (r5 == 0) goto L30
            boolean r5 = r5.isScreenOn()
            if (r5 != 0) goto L30
            r4 = r4 | 4
        L30:
            com.google.ads.interactivemedia.v3.internal.anr r5 = r7.g
            boolean r5 = r5.a()
            if (r5 != 0) goto L60
            android.app.KeyguardManager r5 = r7.e
            if (r5 == 0) goto L5e
            boolean r5 = r5.inKeyguardRestrictedInputMode()
            if (r5 == 0) goto L5e
            android.app.Activity r5 = com.google.ads.interactivemedia.v3.internal.aoa.b(r0)
            if (r5 != 0) goto L49
            goto L5e
        L49:
            android.view.Window r5 = r5.getWindow()
            if (r5 != 0) goto L51
            r5 = 0
            goto L55
        L51:
            android.view.WindowManager$LayoutParams r5 = r5.getAttributes()
        L55:
            if (r5 == 0) goto L5e
            int r5 = r5.flags
            r6 = 524288(0x80000, float:7.34684E-40)
            r5 = r5 & r6
            if (r5 != 0) goto L60
        L5e:
            r4 = r4 | 8
        L60:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L6d
            r4 = r4 | 16
        L6d:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L7a
            r4 = r4 | 32
        L7a:
            int r0 = r0.getWindowVisibility()
            int r5 = r7.l
            if (r5 == r1) goto L83
            r0 = r5
        L83:
            if (r0 == 0) goto L87
            r4 = r4 | 64
        L87:
            byte r0 = r7.k
            if (r0 == r4) goto L9a
            byte r0 = (byte) r4
            r7.k = r0
            if (r4 != 0) goto L95
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto L98
        L95:
            long r0 = (long) r4
            long r0 = r2 - r0
        L98:
            r7.m = r0
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aod.f():void");
    }

    private final void g() {
        a.post(new amt(this, 4));
    }

    private final void h(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.h = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.f == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            aoc aocVar = new aoc(this);
            this.f = aocVar;
            this.b.registerReceiver(aocVar, intentFilter);
        }
        Application application = this.c;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.j);
            } catch (Exception unused) {
            }
        }
    }

    private final void i(View view) {
        try {
            WeakReference weakReference = this.h;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.h = null;
            }
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        BroadcastReceiver broadcastReceiver = this.f;
        if (broadcastReceiver != null) {
            try {
                this.b.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.f = null;
        }
        Application application = this.c;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.j);
            } catch (Exception unused4) {
            }
        }
    }

    public final long a() {
        if (this.m <= -2 && b() == null) {
            this.m = -3L;
        }
        return this.m;
    }

    public final View b() {
        WeakReference weakReference = this.i;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public final void d(View view) {
        long j;
        View b = b();
        if (b != null) {
            b.removeOnAttachStateChangeListener(this);
            i(b);
        }
        this.i = new WeakReference(view);
        if (view != null) {
            if (view.getWindowToken() != null || view.getWindowVisibility() != 8) {
                h(view);
            }
            view.addOnAttachStateChangeListener(this);
            j = -2;
        } else {
            j = -3;
        }
        this.m = j;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        e(activity, 0);
        f();
    }

    public final void onActivityDestroyed(Activity activity) {
        f();
    }

    public final void onActivityPaused(Activity activity) {
        e(activity, 4);
        f();
    }

    public final void onActivityResumed(Activity activity) {
        e(activity, 0);
        f();
        g();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        f();
    }

    public final void onActivityStarted(Activity activity) {
        e(activity, 0);
        f();
    }

    public final void onActivityStopped(Activity activity) {
        f();
    }

    public final void onGlobalLayout() {
        f();
    }

    public final void onScrollChanged() {
        f();
    }

    public final void onViewAttachedToWindow(View view) {
        this.l = -1;
        h(view);
        f();
    }

    public final void onViewDetachedFromWindow(View view) {
        this.l = -1;
        f();
        g();
        i(view);
    }
}

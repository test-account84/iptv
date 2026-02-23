package com.nst.iptvsmarterstvbox.miscelleneious;

import a7.f;
import a7.g;
import a7.j;
import a7.k;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.a;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.SBPAnnouncementsActivity;
import com.nst.iptvsmarterstvbox.view.activity.LoginActivity;
import com.nst.iptvsmarterstvbox.view.activity.LoginActivityOneStream;
import com.nst.iptvsmarterstvbox.view.activity.LoginM3uActivity;
import com.nst.iptvsmarterstvbox.view.activity.MultiUserActivity;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.RoutingActivity;
import g7.d;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a {
    public static Activity a;
    public static Context b;
    public static androidx.appcompat.app.a c;
    public static b d;

    public class a implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            if (a.e() == activity) {
                a.f(null);
            }
        }

        public void onActivityResumed(Activity activity) {
            a.f(activity);
            if (a.g() != null) {
                a.g().a(a.e());
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public interface b {
        void a(Activity activity);
    }

    public static class c implements View.OnFocusChangeListener {
        public final View a;

        public c(View view) {
            this.a = view;
        }

        public final void a(boolean z) {
            if (z) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{z ? 0.6f : 0.5f});
                ofFloat.setDuration(150L);
                ofFloat.start();
            }
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void c(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            if (z) {
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
            }
        }
    }

    public static /* synthetic */ void a(Activity activity, View view) {
        i(activity, view);
    }

    public static /* synthetic */ void b(Activity activity, View view) {
        h(activity, view);
    }

    public static boolean c() {
        Activity activity = a;
        if (activity != null) {
            return (activity instanceof LoginActivity) || (activity instanceof LoginM3uActivity) || (activity instanceof LoginActivityOneStream) || (activity instanceof MultiUserActivity) || (activity instanceof RoutingActivity) || m7.a.p1;
        }
        return false;
    }

    public static void d() {
        NewDashboardActivity newDashboardActivity = a;
        if (newDashboardActivity == null || !(newDashboardActivity instanceof NewDashboardActivity)) {
            return;
        }
        newDashboardActivity.V2(true, true);
    }

    public static /* synthetic */ Activity e() {
        return a;
    }

    public static /* synthetic */ Activity f(Activity activity) {
        a = activity;
        return activity;
    }

    public static /* synthetic */ b g() {
        return d;
    }

    public static /* synthetic */ void h(Activity activity, View view) {
        try {
            k(c, activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void i(Activity activity, View view) {
        SharepreferenceDBHandler.setRateUsCount(0, activity);
        if (activity instanceof NewDashboardActivity) {
            ((NewDashboardActivity) activity).U2();
        }
        c.dismiss();
    }

    public static void j(Context context, Application application, b bVar) {
        d = bVar;
        b = context;
        application.registerActivityLifecycleCallbacks(new a());
    }

    public static void k(androidx.appcompat.app.a aVar, Activity activity) {
        aVar.dismiss();
        activity.finishAffinity();
        Intent launchIntentForPackage = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(335544320);
            activity.startActivity(launchIntentForPackage);
            Process.killProcess(Process.myPid());
        }
    }

    public static void l() {
        NewDashboardActivity newDashboardActivity = a;
        if (newDashboardActivity != null) {
            if (newDashboardActivity instanceof NewDashboardActivity) {
                newDashboardActivity.W2();
            } else if (newDashboardActivity instanceof SBPAnnouncementsActivity) {
                ((SBPAnnouncementsActivity) newDashboardActivity).x1();
            }
        }
    }

    public static void m(Activity activity, String str) {
        if (activity != null) {
            boolean z = activity instanceof NewDashboardActivity;
            boolean z2 = z ? !((NewDashboardActivity) activity).u2() : true;
            androidx.appcompat.app.a aVar = c;
            if (aVar != null) {
                aVar.dismiss();
                c = null;
            }
            if (!z2) {
                if (z) {
                    ((NewDashboardActivity) activity).T2(true, str);
                    return;
                }
                return;
            }
            a.a aVar2 = new a.a(activity, k.a);
            View inflate = LayoutInflater.from(activity).inflate(g.K2, (ViewGroup) null);
            inflate.findViewById(f.i2);
            Button findViewById = inflate.findViewById(f.o1);
            Button findViewById2 = inflate.findViewById(f.e1);
            if (!new u7.a(activity).A().equalsIgnoreCase(m7.a.K0)) {
                findViewById2.setFocusable(false);
                findViewById2.setFocusableInTouchMode(false);
                findViewById.setFocusable(false);
                findViewById.setFocusableInTouchMode(false);
            }
            TextView findViewById3 = inflate.findViewById(f.gm);
            if (str != null && str.length() > 0) {
                findViewById3.setText(str.equalsIgnoreCase("firebase") ? j.h6 : j.i6);
            }
            findViewById.setOnClickListener(new g7.c(activity));
            findViewById2.setOnClickListener(new d(activity));
            findViewById.setOnFocusChangeListener(new c(findViewById));
            findViewById2.setOnFocusChangeListener(new c(findViewById2));
            aVar2.setView(inflate);
            c = aVar2.create();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(c.getWindow().getAttributes());
            layoutParams.width = -2;
            layoutParams.height = -2;
            c.show();
            c.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            c.getWindow().setAttributes(layoutParams);
            c.setCancelable(false);
            if (activity.getCurrentFocus() != null) {
                activity.getCurrentFocus().clearFocus();
            }
            findViewById.requestFocus();
        }
    }

    public static void n(String str) {
        if (c()) {
            return;
        }
        m(a, str);
    }

    public static void o() {
        Activity activity = a;
        if (activity != null) {
            w.z0(activity);
        }
    }

    public static void p() {
        NewDashboardActivity newDashboardActivity = a;
        if (newDashboardActivity == null || !(newDashboardActivity instanceof NewDashboardActivity)) {
            return;
        }
        newDashboardActivity.X2();
    }
}

package com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications;

import D.l;
import Q0.m;
import Q0.u;
import a7.g;
import a7.i;
import a7.j;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.nst.iptvsmarterstvbox.miscelleneious.ApiWorkerCombinedRequest;
import com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.NotificationPanelActivtiy;
import com.nst.iptvsmarterstvbox.view.activity.SplashActivity;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class NotificationUtils {
    public Context a;
    public TextView b;
    public TextView c;
    public ConstraintLayout d;
    public View e;
    public CountDownTimer f;
    public long g = 10000;
    public long h = 1000;

    public class 1 extends LinearLayout {
        public final /* synthetic */ WindowManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 1(Context context, WindowManager windowManager) {
            super(context);
            this.a = windowManager;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
                return super.dispatchKeyEvent(keyEvent);
            }
            NotificationUtils notificationUtils = NotificationUtils.this;
            NotificationUtils.e(notificationUtils, NotificationUtils.f(notificationUtils), this.a, NotificationUtils.g(NotificationUtils.this));
            return true;
        }
    }

    public class 2 extends CountDownTimer {
        public final /* synthetic */ ConstraintLayout a;
        public final /* synthetic */ WindowManager b;
        public final /* synthetic */ View c;

        public class 1 implements Animator.AnimatorListener {
            public 1() {
            }

            public void onAnimationCancel(Animator animator) {
                2 r4 = 2.this;
                NotificationUtils.e(NotificationUtils.this, r4.a, r4.b, r4.c);
            }

            public void onAnimationEnd(Animator animator) {
                2 r4 = 2.this;
                NotificationUtils.e(NotificationUtils.this, r4.a, r4.b, r4.c);
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 2(long j, long j2, ConstraintLayout constraintLayout, WindowManager windowManager, View view) {
            super(j, j2);
            this.a = constraintLayout;
            this.b = windowManager;
            this.c = view;
        }

        public void onFinish() {
            try {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{1.0f, 0.0f});
                ofFloat.setDuration(500L);
                ofFloat.addListener(new 1());
                ofFloat.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onTick(long j) {
            try {
                if (NotificationUtils.d(NotificationUtils.this) == null) {
                    cancel();
                }
            } catch (Exception unused) {
            }
        }
    }

    public class OnFocusChangeAccountListener implements View.OnFocusChangeListener {
        public final View a;

        public OnFocusChangeAccountListener(View view) {
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
            if (z) {
                b(1.15f);
                c(1.15f);
            } else {
                if (z) {
                    return;
                }
                b(1.0f);
                c(1.0f);
                a(z);
            }
        }
    }

    public NotificationUtils(Context context) {
        this.a = context;
    }

    public static /* synthetic */ void a(NotificationUtils notificationUtils, WindowManager windowManager, String str, String str2, String str3, String str4, View view) {
        notificationUtils.k(windowManager, str, str2, str3, str4, view);
    }

    public static /* synthetic */ void b(NotificationUtils notificationUtils, WindowManager windowManager, View view) {
        notificationUtils.j(windowManager, view);
    }

    public static /* synthetic */ void c(NotificationUtils notificationUtils, String str, String str2, String str3, String str4) {
        notificationUtils.l(str, str2, str3, str4);
    }

    public static /* synthetic */ CountDownTimer d(NotificationUtils notificationUtils) {
        return notificationUtils.f;
    }

    public static /* synthetic */ void e(NotificationUtils notificationUtils, ConstraintLayout constraintLayout, WindowManager windowManager, View view) {
        notificationUtils.n(constraintLayout, windowManager, view);
    }

    public static /* synthetic */ ConstraintLayout f(NotificationUtils notificationUtils) {
        return notificationUtils.d;
    }

    public static /* synthetic */ View g(NotificationUtils notificationUtils) {
        return notificationUtils.e;
    }

    public static boolean i(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        PackageManager packageManager = context.getPackageManager();
        return (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback");
    }

    public Bitmap h(String str) {
        try {
            HttpURLConnection openConnection = new URL(str).openConnection();
            openConnection.setDoInput(true);
            openConnection.connect();
            return BitmapFactory.decodeStream(openConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final /* synthetic */ void j(WindowManager windowManager, View view) {
        n(this.d, windowManager, this.e);
    }

    public final /* synthetic */ void k(WindowManager windowManager, String str, String str2, String str3, String str4, View view) {
        Context context;
        Intent putExtra;
        n(this.d, windowManager, this.e);
        if (str.equals("App Ready")) {
            context = this.a;
            putExtra = new Intent(this.a, SplashActivity.class).setFlags(268435456);
        } else {
            context = this.a;
            putExtra = new Intent(this.a, NotificationPanelActivtiy.class).setFlags(268435456).putExtra("title", str).putExtra("body", str2).putExtra("image", str3).putExtra("custombody", str4);
        }
        context.startActivity(putExtra);
    }

    public final /* synthetic */ void l(String str, String str2, String str3, String str4) {
        try {
            WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
            WindowManager.LayoutParams layoutParams = Build.VERSION.SDK_INT >= 26 ? new WindowManager.LayoutParams(-2, -2, 2038, 131104, -2) : new WindowManager.LayoutParams(-2, -2, 2002, 131104, -2);
            layoutParams.gravity = 8388661;
            layoutParams.x = 0;
            layoutParams.y = 100;
            View inflate = LayoutInflater.from(this.a).inflate(g.p3, new 1(this.a, windowManager));
            this.e = inflate;
            this.d = inflate.findViewById(a7.f.Bf);
            TextView findViewById = this.e.findViewById(a7.f.fm);
            TextView findViewById2 = this.e.findViewById(a7.f.ck);
            this.b = this.e.findViewById(a7.f.i1);
            this.c = this.e.findViewById(a7.f.Y0);
            this.b.setFocusable(true);
            this.c.setFocusable(true);
            findViewById.setText(str);
            findViewById2.setText(str2);
            if (str.equals("App Ready")) {
                this.b.setText("Open App");
            }
            TextView textView = this.b;
            textView.setOnFocusChangeListener(new OnFocusChangeAccountListener(textView));
            TextView textView2 = this.c;
            textView2.setOnFocusChangeListener(new OnFocusChangeAccountListener(textView2));
            this.c.setOnClickListener(new e(this, windowManager));
            this.b.setOnClickListener(new f(this, windowManager, str, str2, str3, str4));
            windowManager.addView(this.e, layoutParams);
            this.b.requestFocus();
            o(this.d, windowManager, this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m() {
        try {
            RingtoneManager.getRingtone(this.a, RingtoneManager.getDefaultUri(2)).play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void n(ConstraintLayout constraintLayout, WindowManager windowManager, View view) {
        try {
            CountDownTimer countDownTimer = this.f;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.f = null;
            }
            if (view != null) {
                windowManager.removeViewImmediate(view);
                windowManager.removeView(view);
            }
        } catch (Exception unused) {
        }
    }

    public final void o(ConstraintLayout constraintLayout, WindowManager windowManager, View view) {
        try {
            this.f = new 2(this.g, this.h, constraintLayout, windowManager, view).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void p(Bitmap bitmap, l.e eVar, int i, String str, String str2, String str3, PendingIntent pendingIntent, Uri uri) {
        Notification c;
        new l.b();
        NotificationManager notificationManager = (NotificationManager) this.a.getSystemService("notification");
        l.e eVar2 = new l.e(this.a);
        if (Build.VERSION.SDK_INT >= 26) {
            new l.g().h(str2);
            com.amplifyframework.storage.s3.service.c.a();
            NotificationChannel a = com.amplifyframework.storage.s3.service.b.a("ksjadf87", this.a.getResources().getString(j.Y5), 2);
            c = b.a(new Notification.Builder(this.a).setContentTitle(str).setContentText(str2).setAutoCancel(true).setSound(uri).setContentIntent(pendingIntent).setSmallIcon(i.a).setLargeIcon(bitmap).setStyle(new Notification.BigPictureStyle().bigPicture(bitmap)), "ksjadf87").build();
            if (notificationManager == null) {
                return;
            } else {
                com.amplifyframework.storage.s3.service.a.a(notificationManager, a);
            }
        } else {
            l.g gVar = new l.g();
            gVar.h(str2);
            eVar2.n(str).m(str2).h(true).E(uri).F(gVar).l(pendingIntent).D(i.a);
            c = eVar2.c();
        }
        notificationManager.notify(234231, c);
    }

    public void q(String str, String str2, String str3, Intent intent, String str4, String str5) {
        NotificationUtils notificationUtils;
        l.e eVar;
        int i;
        String str6;
        String str7;
        String str8;
        PendingIntent pendingIntent;
        Intent intent2 = intent;
        Log.e("Result<<<>>>", "From:");
        if (str != null && str.length() != 0 && (str.equalsIgnoreCase("8333whmcssmarters156168514") || str.equalsIgnoreCase("This app has been updated in the background."))) {
            u.f(this.a).d("uniqueWorkName6", Q0.d.REPLACE, (m) new m.a(ApiWorkerCombinedRequest.class).b());
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String valueOf = Build.VERSION.SDK_INT >= 24 ? String.valueOf(a.a(str2, 0)) : "";
        Log.e("Result<<<>>>", "From: " + str);
        int i2 = i.a;
        intent2.setFlags(603979776);
        l.e eVar2 = new l.e(this.a);
        Uri parse = Uri.parse("android.resource://" + this.a.getPackageName() + "/raw/notification");
        if (TextUtils.isEmpty(str4)) {
            Log.e("jaskirat", "notification else clause");
            if (i(this.a)) {
                r(str, str2, str5, str4);
            } else if (this.a != null) {
                if (str.equals("App Ready")) {
                    intent2 = new Intent(this.a, SplashActivity.class);
                }
                intent2.putExtra("fromNotification", "fromNotification");
                intent2.setFlags(335544320);
                intent2.setAction("notification_action");
                intent2.putExtra("title", str);
                intent2.putExtra("body", str2);
                intent2.putExtra("custombody", str5);
                PendingIntent activity = PendingIntent.getActivity(this.a, 0, intent2, 201326592);
                notificationUtils = this;
                eVar = eVar2;
                i = i2;
                str6 = str;
                str7 = valueOf;
                str8 = str3;
                pendingIntent = activity;
                notificationUtils.s(eVar, i, str6, str7, str8, pendingIntent, parse);
            }
        } else if (str4 != null && str4.length() > 4 && Patterns.WEB_URL.matcher(str4).matches()) {
            intent2.putExtra("title", str);
            intent2.putExtra("body", str2);
            intent2.putExtra("image", str4);
            intent2.putExtra("custombody", str5);
            PendingIntent activity2 = PendingIntent.getActivity(this.a, 0, intent2, 201326592);
            Bitmap h = h(str4);
            if (h == null) {
                intent2.putExtra("title", str);
                intent2.putExtra("body", str2);
                intent2.putExtra("image", str4);
                intent2.putExtra("custombody", str5);
                if (!i(this.a)) {
                    notificationUtils = this;
                    eVar = eVar2;
                    i = i2;
                    str6 = str;
                    str7 = valueOf;
                    str8 = str3;
                    pendingIntent = activity2;
                    notificationUtils.s(eVar, i, str6, str7, str8, pendingIntent, parse);
                }
            } else if (!i(this.a)) {
                p(h, eVar2, i2, str, valueOf, str3, activity2, parse);
            }
            r(str, str2, str5, str4);
        }
        m();
    }

    public final void r(String str, String str2, String str3, String str4) {
        if (Build.VERSION.SDK_INT < 23 || !c.a(this.a)) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new d(this, str, str2, str4, str3));
    }

    public final void s(l.e eVar, int i, String str, String str2, String str3, PendingIntent pendingIntent, Uri uri) {
        NotificationManager notificationManager = (NotificationManager) this.a.getSystemService("notification");
        l.e eVar2 = new l.e(this.a);
        if (Build.VERSION.SDK_INT < 26) {
            l.g gVar = new l.g();
            gVar.h(str2);
            eVar2.n(str).m(str2).h(true).E(uri).F(gVar).l(pendingIntent).D(i.a);
            notificationManager.notify(234231, eVar2.c());
            return;
        }
        new l.g().h(str2);
        com.amplifyframework.storage.s3.service.c.a();
        NotificationChannel a = com.amplifyframework.storage.s3.service.b.a("ksjadf87", this.a.getResources().getString(j.Y5), 2);
        Notification build = b.a(new Notification.Builder(this.a).setContentTitle(str).setContentText(str2).setAutoCancel(true).setSound(uri).setContentIntent(pendingIntent).setSmallIcon(i.a), "ksjadf87").build();
        com.amplifyframework.storage.s3.service.a.a(notificationManager, a);
        notificationManager.notify(234231, build);
    }
}

package w4;

import D.l;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.q0;
import com.google.android.gms.common.api.internal.r0;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h extends i {
    public String c;
    public static final Object e = new Object();
    public static final h f = new h();
    public static final int d = i.a;

    public static h q() {
        return f;
    }

    public final boolean A(Context context, b bVar, int i) {
        PendingIntent p;
        if (E4.b.a(context) || (p = p(context, bVar)) == null) {
            return false;
        }
        x(context, bVar.H(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, p, i, true), zap.zaa | 134217728));
        return true;
    }

    public Intent d(Context context, int i, String str) {
        return super.d(context, i, str);
    }

    public PendingIntent e(Context context, int i, int i2) {
        return super.e(context, i, i2);
    }

    public final String g(int i) {
        return super.g(i);
    }

    public int i(Context context) {
        return super.i(context);
    }

    public int j(Context context, int i) {
        return super.j(context, i);
    }

    public final boolean m(int i) {
        return super.m(i);
    }

    public Dialog o(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return t(activity, i, com.google.android.gms.common.internal.G.b(activity, d(activity, i, "d"), i2), onCancelListener, null);
    }

    public PendingIntent p(Context context, b bVar) {
        return bVar.K() ? bVar.J() : e(context, bVar.H(), 0);
    }

    public boolean r(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog o = o(activity, i, i2, onCancelListener);
        if (o == null) {
            return false;
        }
        w(activity, o, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void s(Context context, int i) {
        x(context, i, null, f(context, i, 0, "n"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Dialog t(Context context, int i, com.google.android.gms.common.internal.G g, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.D.c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String b = com.google.android.gms.common.internal.D.b(context, i);
        if (b != null) {
            if (g == null) {
                g = onClickListener;
            }
            builder.setPositiveButton(b, g);
        }
        String f2 = com.google.android.gms.common.internal.D.f(context, i);
        if (f2 != null) {
            builder.setTitle(f2);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", new Object[]{Integer.valueOf(i)}), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog u(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(com.google.android.gms.common.internal.D.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        w(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final r0 v(Context context, q0 q0Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        r0 r0Var = new r0(q0Var);
        zao.zaa(context, r0Var, intentFilter);
        r0Var.a(context);
        if (l(context, "com.google.android.gms")) {
            return r0Var;
        }
        q0Var.a();
        r0Var.b();
        return null;
    }

    public final void w(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof androidx.fragment.app.e) {
                p.A(dialog, onCancelListener).show(((androidx.fragment.app.e) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public final void x(Context context, int i, String str, PendingIntent pendingIntent) {
        int i2;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[]{Integer.valueOf(i), null}), new IllegalArgumentException());
        if (i == 18) {
            y(context);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String e2 = com.google.android.gms.common.internal.D.e(context, i);
        String d2 = com.google.android.gms.common.internal.D.d(context, i);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) com.google.android.gms.common.internal.r.m(context.getSystemService("notification"));
        l.e F = new l.e(context).w(true).h(true).n(e2).F(new l.c().h(d2));
        if (C4.i.c(context)) {
            com.google.android.gms.common.internal.r.p(C4.m.e());
            F.D(context.getApplicationInfo().icon).A(2);
            if (C4.i.d(context)) {
                F.a(m4.a.a, resources.getString(m4.b.o), pendingIntent);
            } else {
                F.l(pendingIntent);
            }
        } else {
            F.D(17301642).G(resources.getString(m4.b.h)).J(System.currentTimeMillis()).l(pendingIntent).m(d2);
        }
        if (C4.m.i()) {
            com.google.android.gms.common.internal.r.p(C4.m.i());
            synchronized (e) {
                str2 = this.c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel a = e.a(notificationManager, "com.google.android.gms.availability");
                String string = context.getResources().getString(m4.b.g);
                if (a == null) {
                    com.amplifyframework.storage.s3.service.a.a(notificationManager, com.amplifyframework.storage.s3.service.b.a("com.google.android.gms.availability", string, 4));
                } else if (!string.contentEquals(f.a(a))) {
                    g.a(a, string);
                    com.amplifyframework.storage.s3.service.a.a(notificationManager, a);
                }
            }
            F.i(str2);
        }
        Notification c = F.c();
        if (i == 1 || i == 2 || i == 3) {
            m.b.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, c);
    }

    public final void y(Context context) {
        new r(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean z(Activity activity, com.google.android.gms.common.api.internal.j jVar, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog t = t(activity, i, com.google.android.gms.common.internal.G.c(jVar, d(activity, i, "d"), 2), onCancelListener, null);
        if (t == null) {
            return false;
        }
        w(activity, t, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }
}

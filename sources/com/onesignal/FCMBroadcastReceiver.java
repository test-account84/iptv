package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.onesignal.F1;
import com.onesignal.T;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class FCMBroadcastReceiver extends k0.a {

    public class a implements T.e {
        public a() {
        }

        public void a(T.f fVar) {
            if (fVar == null) {
                FCMBroadcastReceiver.d(FCMBroadcastReceiver.this);
            } else if (fVar.a() || fVar.b()) {
                FCMBroadcastReceiver.e(FCMBroadcastReceiver.this);
            } else {
                FCMBroadcastReceiver.d(FCMBroadcastReceiver.this);
            }
        }
    }

    public class b implements T.e {
        public final /* synthetic */ T.e a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Bundle c;

        public b(T.e eVar, Context context, Bundle bundle) {
            this.a = eVar;
            this.b = context;
            this.c = bundle;
        }

        public void a(T.f fVar) {
            if (fVar == null || !fVar.c()) {
                FCMBroadcastReceiver.k(this.b, this.c);
            }
            this.a.a(fVar);
        }
    }

    public static /* synthetic */ void d(FCMBroadcastReceiver fCMBroadcastReceiver) {
        fCMBroadcastReceiver.j();
    }

    public static /* synthetic */ void e(FCMBroadcastReceiver fCMBroadcastReceiver) {
        fCMBroadcastReceiver.h();
    }

    public static boolean f(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null || "gcm".equals(stringExtra);
    }

    public static void g(Context context, Intent intent, Bundle bundle, T.e eVar) {
        if (!f(intent)) {
            eVar.a(null);
        }
        T.h(context, bundle, new b(eVar, context, bundle));
    }

    public static m i(Bundle bundle, m mVar) {
        mVar.a("json_payload", T.a(bundle).toString());
        mVar.e("timestamp", Long.valueOf(F1.v0().a() / 1000));
        return mVar;
    }

    public static void k(Context context, Bundle bundle) {
        F1.v vVar = F1.v.DEBUG;
        F1.a(vVar, "startFCMService from: " + context + " and bundle: " + bundle);
        if (!T.c(bundle)) {
            F1.a(vVar, "startFCMService with no remote resources, no need for services");
            T.j(context, i(bundle, o.a()));
            return;
        }
        if (Integer.parseInt(bundle.getString("pri", "0")) > 9 || Build.VERSION.SDK_INT < 26) {
            try {
                m(context, bundle);
                return;
            } catch (IllegalStateException unused) {
            }
        }
        l(context, bundle);
    }

    public static void l(Context context, Bundle bundle) {
        m i = i(bundle, o.a());
        Intent intent = new Intent(context, FCMIntentJobService.class);
        intent.putExtra("Bundle:Parcelable:Extras", (Parcelable) i.f());
        FCMIntentJobService.j(context, intent);
    }

    public static void m(Context context, Bundle bundle) {
        k0.a.c(context, new Intent().replaceExtras((Bundle) i(bundle, new n()).f()).setComponent(new ComponentName(context.getPackageName(), FCMIntentService.class.getName())));
    }

    public final void h() {
        if (isOrderedBroadcast()) {
            abortBroadcast();
            setResultCode(-1);
        }
    }

    public final void j() {
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || "google.com/iid".equals(extras.getString("from"))) {
            return;
        }
        F1.K0(context);
        g(context, intent, extras, new a());
    }
}

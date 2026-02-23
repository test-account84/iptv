package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerJobBase;
import com.onesignal.F1;
import com.onesignal.T;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ADMMessageHandlerJob extends ADMMessageHandlerJobBase {

    public static final class a implements T.e {
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ Context b;

        public a(Bundle bundle, Context context) {
            this.a = bundle;
            this.b = context;
        }

        public void a(T.f fVar) {
            if (fVar != null && fVar.c()) {
                return;
            }
            JSONObject a = T.a(this.a);
            kotlin.jvm.internal.l.d(a, "bundleAsJSONObject(bundle)");
            Q0 q0 = new Q0(a);
            V0 v0 = new V0(this.b);
            Context context = this.b;
            v0.q(a);
            v0.o(context);
            v0.r(q0);
            T.m(v0, true);
        }
    }

    public void onMessage(@Nullable Context context, @Nullable Intent intent) {
        Bundle extras = intent == null ? null : intent.getExtras();
        T.h(context, extras, new a(extras, context));
    }

    public void onRegistered(@Nullable Context context, @Nullable String str) {
        F1.a(F1.v.INFO, kotlin.jvm.internal.l.l("ADM registration ID: ", str));
        Z1.c(str);
    }

    public void onRegistrationError(@Nullable Context context, @Nullable String str) {
        F1.v vVar = F1.v.ERROR;
        F1.a(vVar, kotlin.jvm.internal.l.l("ADM:onRegistrationError: ", str));
        if (kotlin.jvm.internal.l.a("INVALID_SENDER", str)) {
            F1.a(vVar, "Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.");
        }
        Z1.c(null);
    }

    public void onUnregistered(@Nullable Context context, @Nullable String str) {
        F1.a(F1.v.INFO, kotlin.jvm.internal.l.l("ADM:onUnregistered: ", str));
    }
}

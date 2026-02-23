package com.onesignal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class G {
    public final Context a;
    public final Class b;
    public final Class c;

    public G(Context context) {
        kotlin.jvm.internal.l.e(context, "context");
        this.a = context;
        this.b = NotificationOpenedReceiver.class;
        this.c = NotificationOpenedReceiverAndroid22AndOlder.class;
    }

    public final PendingIntent a(int i, Intent oneSignalIntent) {
        kotlin.jvm.internal.l.e(oneSignalIntent, "oneSignalIntent");
        return PendingIntent.getActivity(this.a, i, oneSignalIntent, 201326592);
    }

    public final Intent b(int i) {
        Intent addFlags = (Build.VERSION.SDK_INT >= 23 ? d() : c()).putExtra("androidNotificationId", i).addFlags(603979776);
        kotlin.jvm.internal.l.d(addFlags, "intent\n            .putE…Y_CLEAR_TOP\n            )");
        return addFlags;
    }

    public final Intent c() {
        Intent intent = new Intent(this.a, this.c);
        intent.addFlags(403177472);
        return intent;
    }

    public final Intent d() {
        return new Intent(this.a, this.b);
    }
}

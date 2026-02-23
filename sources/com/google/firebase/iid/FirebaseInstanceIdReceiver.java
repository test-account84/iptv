package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import q6.H;
import q6.n;
import v4.a;
import v4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class FirebaseInstanceIdReceiver extends b {
    public final int b(Context context, a aVar) {
        try {
            return ((Integer) Tasks.await(new n(context).g(aVar.H()))).intValue();
        } catch (ExecutionException | InterruptedException e) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", e);
            return 500;
        }
    }

    public final void c(Context context, Bundle bundle) {
        Intent putExtras = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(bundle);
        if (H.A(putExtras)) {
            H.s(putExtras);
        }
    }
}

package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import q6.H;
import q6.J;
import q6.S;
import q6.W;
import q6.d;
import q6.h;
import q6.o;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FirebaseMessagingService extends h {
    public static final Queue g = new ArrayDeque(10);

    public Intent c(Intent intent) {
        return W.b().c();
    }

    public void d(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            m(intent);
        } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
            q(intent.getStringExtra("token"));
        } else {
            String valueOf = String.valueOf(intent.getAction());
            Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Unknown intent action: ".concat(valueOf) : new String("Unknown intent action: "));
        }
    }

    public final boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue queue = g;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        }
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        String valueOf = String.valueOf(str);
        Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Received duplicate message: ".concat(valueOf) : new String("Received duplicate message: "));
        return true;
    }

    public final void k(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (J.t(extras)) {
            J j = new J(extras);
            ExecutorService c = o.c();
            try {
                if (new d(this, j, c).a()) {
                    return;
                }
                if (H.A(intent)) {
                    H.t(intent);
                }
            } finally {
                c.shutdown();
            }
        }
        o(new S(extras));
    }

    public final String l(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    public final void m(Intent intent) {
        if (j(intent.getStringExtra("google.message_id"))) {
            return;
        }
        s(intent);
    }

    public void n() {
    }

    public void p(String str) {
    }

    public void q(String str) {
    }

    public void r(String str, Exception exc) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(android.content.Intent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "message_type"
            java.lang.String r0 = r7.getStringExtra(r0)
            java.lang.String r1 = "gcm"
            if (r0 != 0) goto Lb
            r0 = r1
        Lb:
            int r2 = r0.hashCode()
            r3 = 1
            r4 = 3
            r5 = 2
            switch(r2) {
                case -2062414158: goto L32;
                case 102161: goto L2a;
                case 814694033: goto L20;
                case 814800675: goto L16;
                default: goto L15;
            }
        L15:
            goto L3c
        L16:
            java.lang.String r1 = "send_event"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3c
            r1 = 2
            goto L3d
        L20:
            java.lang.String r1 = "send_error"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3c
            r1 = 3
            goto L3d
        L2a:
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3c
            r1 = 0
            goto L3d
        L32:
            java.lang.String r1 = "deleted_messages"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3c
            r1 = 1
            goto L3d
        L3c:
            r1 = -1
        L3d:
            if (r1 == 0) goto L7e
            if (r1 == r3) goto L7a
            if (r1 == r5) goto L70
            if (r1 == r4) goto L5d
            int r7 = r0.length()
            java.lang.String r1 = "Received message with unknown type: "
            if (r7 == 0) goto L52
            java.lang.String r7 = r1.concat(r0)
            goto L57
        L52:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1)
        L57:
            java.lang.String r0 = "FirebaseMessaging"
            android.util.Log.w(r0, r7)
            return
        L5d:
            java.lang.String r0 = r6.l(r7)
            q6.V r1 = new q6.V
            java.lang.String r2 = "error"
            java.lang.String r7 = r7.getStringExtra(r2)
            r1.<init>(r7)
            r6.r(r0, r1)
            return
        L70:
            java.lang.String r0 = "google.message_id"
            java.lang.String r7 = r7.getStringExtra(r0)
            r6.p(r7)
            return
        L7a:
            r6.n()
            return
        L7e:
            q6.H.v(r7)
            r6.k(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.s(android.content.Intent):void");
    }

    public void o(S s) {
    }
}

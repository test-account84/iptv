package q4;

import android.content.Intent;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import n4.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t extends MediaSessionCompat.Callback {
    public final /* synthetic */ w a;

    public t(w wVar) {
        this.a = wVar;
    }

    public final void a(long j) {
        p4.i e = w.e(this.a);
        if (e == null) {
            return;
        }
        b(Math.min(e.p(), Math.max(0L, e.g() + j)));
    }

    public final void b(long j) {
        p4.i e = w.e(this.a);
        if (e == null) {
            return;
        }
        q.a aVar = new q.a();
        aVar.d(j);
        e.T(aVar.a());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCustomAction(java.lang.String r5, android.os.Bundle r6) {
        /*
            r4 = this;
            t4.b r6 = q4.w.f()
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r5
            java.lang.String r3 = "onCustomAction with action = %s"
            r6.a(r3, r1)
            int r6 = r5.hashCode()
            r1 = 2
            r3 = 3
            switch(r6) {
                case -1699820260: goto L37;
                case -668151673: goto L2d;
                case -124479363: goto L23;
                case 1362116196: goto L19;
                default: goto L18;
            }
        L18:
            goto L41
        L19:
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.FORWARD"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L41
            r6 = 0
            goto L42
        L23:
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.DISCONNECT"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L41
            r6 = 3
            goto L42
        L2d:
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.STOP_CASTING"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L41
            r6 = 2
            goto L42
        L37:
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.REWIND"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L41
            r6 = 1
            goto L42
        L41:
            r6 = -1
        L42:
            if (r6 == 0) goto L91
            if (r6 == r0) goto L82
            if (r6 == r1) goto L72
            if (r6 == r3) goto L62
            android.content.Intent r6 = new android.content.Intent
            r6.<init>(r5)
            q4.w r5 = r4.a
            android.content.ComponentName r5 = q4.w.a(r5)
            r6.setComponent(r5)
            q4.w r5 = r4.a
            android.content.Context r5 = q4.w.b(r5)
            r5.sendBroadcast(r6)
            return
        L62:
            q4.w r5 = r4.a
            o4.x r6 = q4.w.c(r5)
            if (r6 == 0) goto L81
            o4.x r5 = q4.w.c(r5)
            r5.b(r2)
            return
        L72:
            q4.w r5 = r4.a
            o4.x r6 = q4.w.c(r5)
            if (r6 == 0) goto L81
            o4.x r5 = q4.w.c(r5)
            r5.b(r0)
        L81:
            return
        L82:
            q4.w r5 = r4.a
            p4.h r5 = q4.w.d(r5)
            long r5 = r5.V()
            long r5 = -r5
            r4.a(r5)
            return
        L91:
            q4.w r5 = r4.a
            p4.h r5 = q4.w.d(r5)
            long r5 = r5.V()
            r4.a(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.t.onCustomAction(java.lang.String, android.os.Bundle):void");
    }

    public final boolean onMediaButtonEvent(Intent intent) {
        w.f().a("onMediaButtonEvent", new Object[0]);
        KeyEvent parcelableExtra = intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (parcelableExtra == null) {
            return true;
        }
        if (parcelableExtra.getKeyCode() != 127 && parcelableExtra.getKeyCode() != 126) {
            return true;
        }
        w wVar = this.a;
        if (w.e(wVar) == null) {
            return true;
        }
        w.e(wVar).W();
        return true;
    }

    public final void onPause() {
        w.f().a("onPause", new Object[0]);
        w wVar = this.a;
        if (w.e(wVar) != null) {
            w.e(wVar).W();
        }
    }

    public final void onPlay() {
        w.f().a("onPlay", new Object[0]);
        w wVar = this.a;
        if (w.e(wVar) != null) {
            w.e(wVar).W();
        }
    }

    public final void onSeekTo(long j) {
        w.f().a("onSeekTo %d", Long.valueOf(j));
        b(j);
    }

    public final void onSkipToNext() {
        w.f().a("onSkipToNext", new Object[0]);
        w wVar = this.a;
        if (w.e(wVar) != null) {
            w.e(wVar).J(null);
        }
    }

    public final void onSkipToPrevious() {
        w.f().a("onSkipToPrevious", new Object[0]);
        w wVar = this.a;
        if (w.e(wVar) != null) {
            w.e(wVar).K(null);
        }
    }
}

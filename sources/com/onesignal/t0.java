package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class T0 extends q0 {
    public final M1 a;
    public final P0 b;

    public class a extends k {
        public a() {
        }

        public void run() {
            super.run();
            T0.e(T0.this).e("notification", "created_time < ?", new String[]{String.valueOf((F1.v0().a() / 1000) - 604800)});
        }
    }

    public class b extends k {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ int c;

        public b(WeakReference weakReference, int i) {
            this.a = weakReference;
            this.c = i;
        }

        public void run() {
            super.run();
            Context context = (Context) this.a.get();
            if (context == null) {
                return;
            }
            String str = "android_notification_id = " + this.c + " AND opened = 0 AND dismissed = 0";
            ContentValues contentValues = new ContentValues();
            contentValues.put("dismissed", 1);
            if (T0.e(T0.this).a("notification", contentValues, str, null) > 0) {
                p0.e(context, T0.e(T0.this), this.c);
            }
            l.c(T0.e(T0.this), context);
            Q1.i(context).cancel(this.c);
        }
    }

    public class c extends k {
        public final /* synthetic */ String a;
        public final /* synthetic */ d c;

        public c(String str, d dVar) {
            this.a = str;
            this.c = dVar;
        }

        public void run() {
            boolean z;
            super.run();
            Cursor d = T0.e(T0.this).d("notification", new String[]{"notification_id"}, "notification_id = ?", new String[]{this.a}, null, null, null);
            boolean moveToFirst = d.moveToFirst();
            d.close();
            if (moveToFirst) {
                T0.f(T0.this).debug("Notification notValidOrDuplicated with id duplicated, duplicate FCM message received, skip processing of " + this.a);
                z = true;
            } else {
                z = false;
            }
            this.c.a(z);
        }
    }

    public interface d {
        void a(boolean z);
    }

    public T0(M1 m1, P0 p0) {
        this.a = m1;
        this.b = p0;
    }

    public static /* synthetic */ M1 e(T0 t0) {
        return t0.a;
    }

    public static /* synthetic */ P0 f(T0 t0) {
        return t0.b;
    }

    public final void g() {
        d(new a(), "OS_NOTIFICATIONS_THREAD");
    }

    public void h() {
        g();
    }

    public final void i(String str, d dVar) {
        if (str == null || "".equals(str)) {
            dVar.a(false);
        } else if (OSNotificationWorkManager.a(str)) {
            d(new c(str, dVar), "OS_NOTIFICATIONS_THREAD");
        } else {
            this.b.debug("Notification notValidOrDuplicated with id duplicated");
            dVar.a(true);
        }
    }

    public void j(JSONObject jSONObject, d dVar) {
        String b2 = U0.b(jSONObject);
        if (b2 != null) {
            i(b2, dVar);
        } else {
            this.b.debug("Notification notValidOrDuplicated with id null");
            dVar.a(true);
        }
    }

    public void k(int i, WeakReference weakReference) {
        d(new b(weakReference, i), "OS_NOTIFICATIONS_THREAD");
    }
}

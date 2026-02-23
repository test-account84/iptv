package q4;

import D.P;
import D.l;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import com.google.android.gms.internal.cast.zzdx;
import com.google.android.gms.internal.cast.zzln;
import com.google.android.gms.internal.cast.zzr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p4.X;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class p {
    public static final t4.b x = new t4.b("MediaNotificationProxy");
    public final Context a;
    public final NotificationManager b;
    public final o4.b c;
    public final p4.h d;
    public final ComponentName e;
    public final ComponentName f;
    public List g = new ArrayList();
    public int[] h;
    public final long i;
    public final b j;
    public final p4.b k;
    public final Resources l;
    public m m;
    public n n;
    public Notification o;
    public l.a p;
    public l.a q;
    public l.a r;
    public l.a s;
    public l.a t;
    public l.a u;
    public l.a v;
    public l.a w;

    public p(Context context) {
        this.a = context;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        this.b = notificationManager;
        o4.b bVar = (o4.b) com.google.android.gms.common.internal.r.m(o4.b.d());
        this.c = bVar;
        p4.a aVar = (p4.a) com.google.android.gms.common.internal.r.m(((o4.c) com.google.android.gms.common.internal.r.m(bVar.a())).H());
        p4.h hVar = (p4.h) com.google.android.gms.common.internal.r.m(aVar.L());
        this.d = hVar;
        aVar.I();
        Resources resources = context.getResources();
        this.l = resources;
        this.e = new ComponentName(context.getApplicationContext(), aVar.J());
        this.f = !TextUtils.isEmpty(hVar.Z()) ? new ComponentName(context.getApplicationContext(), hVar.Z()) : null;
        this.i = hVar.V();
        int dimensionPixelSize = resources.getDimensionPixelSize(hVar.e0());
        p4.b bVar2 = new p4.b(1, dimensionPixelSize, dimensionPixelSize);
        this.k = bVar2;
        this.j = new b(context.getApplicationContext(), bVar2);
        if (C4.m.i() && notificationManager != null) {
            NotificationChannel a = com.amplifyframework.storage.s3.service.b.a("cast_media_notification", ((Context) com.google.android.gms.common.internal.r.m(context)).getResources().getString(o4.t.F), 2);
            o.a(a, false);
            com.amplifyframework.storage.s3.service.a.a(notificationManager, a);
        }
        zzr.zzd(zzln.CAF_MEDIA_NOTIFICATION_PROXY);
    }

    public static /* bridge */ /* synthetic */ void a(p pVar, n nVar) {
        pVar.n = nVar;
    }

    public static /* bridge */ /* synthetic */ void b(p pVar) {
        pVar.g();
    }

    public static boolean e(o4.c cVar) {
        p4.h L;
        p4.a H = cVar.H();
        if (H == null || (L = H.L()) == null) {
            return false;
        }
        X m0 = L.m0();
        if (m0 == null) {
            return true;
        }
        List f = x.f(m0);
        int[] g = x.g(m0);
        int size = f == null ? 0 : f.size();
        if (f == null || f.isEmpty()) {
            x.c(p4.g.class.getSimpleName().concat(" doesn't provide any action."), new Object[0]);
        } else if (f.size() > 5) {
            x.c(p4.g.class.getSimpleName().concat(" provides more than 5 actions."), new Object[0]);
        } else {
            if (g != null && (g.length) != 0) {
                for (int i : g) {
                    if (i < 0 || i >= size) {
                        x.c(p4.g.class.getSimpleName().concat("provides a compact view action whose index is out of bounds."), new Object[0]);
                    }
                }
                return true;
            }
            x.c(p4.g.class.getSimpleName().concat(" doesn't provide any actions for compact view."), new Object[0]);
        }
        return false;
    }

    public final void c() {
        this.j.a();
        NotificationManager notificationManager = this.b;
        if (notificationManager != null) {
            notificationManager.cancel("castMediaNotification", 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(com.google.android.gms.cast.CastDevice r18, p4.i r19, android.support.v4.media.session.MediaSessionCompat r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.p.d(com.google.android.gms.cast.CastDevice, p4.i, android.support.v4.media.session.MediaSessionCompat, boolean):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final D.l.a f(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.p.f(java.lang.String):D.l$a");
    }

    public final void g() {
        PendingIntent j;
        l.a f;
        if (this.b == null || this.m == null) {
            return;
        }
        n nVar = this.n;
        l.e I = new l.e(this.a, "cast_media_notification").u(nVar == null ? null : nVar.b).D(this.d.W()).n(this.m.d).m(this.l.getString(this.d.I(), new Object[]{this.m.e})).y(true).C(false).I(1);
        ComponentName componentName = this.f;
        if (componentName == null) {
            j = null;
        } else {
            Intent intent = new Intent();
            intent.putExtra("targetActivity", componentName);
            intent.setAction(componentName.flattenToString());
            intent.setComponent(componentName);
            P e = P.e(this.a);
            e.b(intent);
            j = e.j(1, zzdx.zza | 134217728);
        }
        if (j != null) {
            I.l(j);
        }
        X m0 = this.d.m0();
        if (m0 != null) {
            x.a("actionsProvider != null", new Object[0]);
            int[] g = x.g(m0);
            this.h = g != null ? (int[]) g.clone() : null;
            List<p4.f> f2 = x.f(m0);
            this.g = new ArrayList();
            if (f2 != null) {
                for (p4.f fVar : f2) {
                    String H = fVar.H();
                    if (H.equals("com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK") || H.equals("com.google.android.gms.cast.framework.action.SKIP_NEXT") || H.equals("com.google.android.gms.cast.framework.action.SKIP_PREV") || H.equals("com.google.android.gms.cast.framework.action.FORWARD") || H.equals("com.google.android.gms.cast.framework.action.REWIND") || H.equals("com.google.android.gms.cast.framework.action.STOP_CASTING") || H.equals("com.google.android.gms.cast.framework.action.DISCONNECT")) {
                        f = f(fVar.H());
                    } else {
                        Intent intent2 = new Intent(fVar.H());
                        intent2.setComponent(this.e);
                        f = new l.a.a(fVar.J(), fVar.I(), PendingIntent.getBroadcast(this.a, 0, intent2, zzdx.zza)).a();
                    }
                    if (f != null) {
                        this.g.add(f);
                    }
                }
            }
        } else {
            x.a("actionsProvider == null", new Object[0]);
            this.g = new ArrayList();
            Iterator it = this.d.H().iterator();
            while (it.hasNext()) {
                l.a f3 = f((String) it.next());
                if (f3 != null) {
                    this.g.add(f3);
                }
            }
            this.h = (int[]) this.d.J().clone();
        }
        Iterator it2 = this.g.iterator();
        while (it2.hasNext()) {
            I.b((l.a) it2.next());
        }
        r0.b bVar = new r0.b();
        int[] iArr = this.h;
        if (iArr != null) {
            bVar.i(iArr);
        }
        MediaSessionCompat.Token token = this.m.a;
        if (token != null) {
            bVar.h(token);
        }
        I.F(bVar);
        Notification c = I.c();
        this.o = c;
        this.b.notify("castMediaNotification", 1, c);
    }
}

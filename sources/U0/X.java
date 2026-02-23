package u0;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.SparseArray;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import u0.F;
import u0.H;
import u0.I;
import u0.K;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class x extends H {
    public static final boolean t = Log.isLoggable("MR2Provider", 3);
    public final MediaRouter2 j;
    public final a k;
    public final Map l;
    public final MediaRouter2.RouteCallback m;
    public final MediaRouter2.TransferCallback n;
    public final MediaRouter2.ControllerCallback o;
    public final Handler p;
    public final Executor q;
    public List r;
    public Map s;

    public static abstract class a {
        public abstract void a(H.e eVar);

        public abstract void b(int i);

        public abstract void c(String str, int i);
    }

    public class b extends MediaRouter2.ControllerCallback {
        public b() {
        }

        public void onControllerUpdated(MediaRouter2.RoutingController routingController) {
            x.this.D(routingController);
        }
    }

    public class c extends H.b {
        public final String f;
        public final MediaRouter2.RoutingController g;
        public final Messenger h;
        public final Messenger i;
        public final Handler k;
        public F o;
        public final SparseArray j = new SparseArray();
        public AtomicInteger l = new AtomicInteger(1);
        public final Runnable m = new D(this);
        public int n = -1;

        public class a extends Handler {
            public a() {
                super(Looper.getMainLooper());
            }

            public void handleMessage(Message message) {
                int i = message.what;
                int i2 = message.arg1;
                Object obj = message.obj;
                Bundle peekData = message.peekData();
                L.c cVar = (L.c) c.this.j.get(i2);
                if (cVar == null) {
                    Log.w("MR2Provider", "Pending callback not found for control request.");
                    return;
                }
                c.this.j.remove(i2);
                if (i == 3) {
                    cVar.b((Bundle) obj);
                } else {
                    if (i != 4) {
                        return;
                    }
                    cVar.a(peekData == null ? null : peekData.getString("error"), (Bundle) obj);
                }
            }
        }

        public c(MediaRouter2.RoutingController routingController, String str) {
            this.g = routingController;
            this.f = str;
            Messenger z = x.z(routingController);
            this.h = z;
            this.i = z == null ? null : new Messenger(new a());
            this.k = new Handler(Looper.getMainLooper());
        }

        public static /* synthetic */ void q(c cVar) {
            cVar.s();
        }

        public void d() {
            z.a(this.g);
        }

        public void f(int i) {
            MediaRouter2.RoutingController routingController = this.g;
            if (routingController == null) {
                return;
            }
            y.a(routingController, i);
            this.n = i;
            t();
        }

        public void i(int i) {
            MediaRouter2.RoutingController routingController = this.g;
            if (routingController == null) {
                return;
            }
            int i2 = this.n;
            if (i2 < 0) {
                i2 = i.a(routingController);
            }
            int max = Math.max(0, Math.min(i2 + i, j.a(this.g)));
            this.n = max;
            y.a(this.g, max);
            t();
        }

        public void m(String str) {
            if (str == null || str.isEmpty()) {
                Log.w("MR2Provider", "onAddMemberRoute: Ignoring null or empty routeId.");
                return;
            }
            MediaRoute2Info A = x.this.A(str);
            if (A != null) {
                C.a(this.g, A);
                return;
            }
            Log.w("MR2Provider", "onAddMemberRoute: Specified route not found. routeId=" + str);
        }

        public void n(String str) {
            if (str == null || str.isEmpty()) {
                Log.w("MR2Provider", "onRemoveMemberRoute: Ignoring null or empty routeId.");
                return;
            }
            MediaRoute2Info A = x.this.A(str);
            if (A != null) {
                A.a(this.g, A);
                return;
            }
            Log.w("MR2Provider", "onRemoveMemberRoute: Specified route not found. routeId=" + str);
        }

        public void o(List list) {
            if (list == null || list.isEmpty()) {
                Log.w("MR2Provider", "onUpdateMemberRoutes: Ignoring null or empty routeIds.");
                return;
            }
            String str = (String) list.get(0);
            MediaRoute2Info A = x.this.A(str);
            if (A != null) {
                u0.a.a(x.this.j, A);
                return;
            }
            Log.w("MR2Provider", "onUpdateMemberRoutes: Specified route not found. routeId=" + str);
        }

        public String r() {
            F f = this.o;
            return f != null ? f.l() : l.a(this.g);
        }

        public final /* synthetic */ void s() {
            this.n = -1;
        }

        public final void t() {
            this.k.removeCallbacks(this.m);
            this.k.postDelayed(this.m, 1000L);
        }

        public void u(F f) {
            this.o = f;
        }

        public void v(String str, int i) {
            MediaRouter2.RoutingController routingController = this.g;
            if (routingController == null || B.a(routingController) || this.h == null) {
                return;
            }
            int andIncrement = this.l.getAndIncrement();
            Message obtain = Message.obtain();
            obtain.what = 7;
            obtain.arg1 = andIncrement;
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i);
            bundle.putString("routeId", str);
            obtain.setData(bundle);
            obtain.replyTo = this.i;
            try {
                this.h.send(obtain);
            } catch (RemoteException e) {
                Log.e("MR2Provider", "Could not send control request to service.", e);
            } catch (DeadObjectException unused) {
            }
        }

        public void w(String str, int i) {
            MediaRouter2.RoutingController routingController = this.g;
            if (routingController == null || B.a(routingController) || this.h == null) {
                return;
            }
            int andIncrement = this.l.getAndIncrement();
            Message obtain = Message.obtain();
            obtain.what = 8;
            obtain.arg1 = andIncrement;
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i);
            bundle.putString("routeId", str);
            obtain.setData(bundle);
            obtain.replyTo = this.i;
            try {
                this.h.send(obtain);
            } catch (RemoteException e) {
                Log.e("MR2Provider", "Could not send control request to service.", e);
            } catch (DeadObjectException unused) {
            }
        }
    }

    public class d extends H.e {
        public final String a;
        public final c b;

        public d(String str, c cVar) {
            this.a = str;
            this.b = cVar;
        }

        public void f(int i) {
            c cVar;
            String str = this.a;
            if (str == null || (cVar = this.b) == null) {
                return;
            }
            cVar.v(str, i);
        }

        public void i(int i) {
            c cVar;
            String str = this.a;
            if (str == null || (cVar = this.b) == null) {
                return;
            }
            cVar.w(str, i);
        }
    }

    public class e extends MediaRouter2.RouteCallback {
        public e() {
        }

        public void onRoutesAdded(List list) {
            x.this.C();
        }

        public void onRoutesChanged(List list) {
            x.this.C();
        }

        public void onRoutesRemoved(List list) {
            x.this.C();
        }
    }

    public class f extends MediaRouter2.TransferCallback {
        public f() {
        }

        public void onStop(MediaRouter2.RoutingController routingController) {
            H.e eVar = (H.e) x.this.l.remove(routingController);
            if (eVar != null) {
                x.this.k.a(eVar);
                return;
            }
            Log.w("MR2Provider", "onStop: No matching routeController found. routingController=" + routingController);
        }

        public void onTransfer(MediaRouter2.RoutingController routingController, MediaRouter2.RoutingController routingController2) {
            x.this.l.remove(routingController);
            if (routingController2 == E.a(x.this.j)) {
                x.this.k.b(3);
                return;
            }
            List a = g.a(routingController2);
            if (a.isEmpty()) {
                Log.w("MR2Provider", "Selected routes are empty. This shouldn't happen.");
                return;
            }
            String a2 = u0.f.a(u0.c.a(a.get(0)));
            x.this.l.put(routingController2, x.this.new c(routingController2, a2));
            x.this.k.c(a2, 3);
            x.this.D(routingController2);
        }

        public void onTransferFailure(MediaRoute2Info mediaRoute2Info) {
            Log.w("MR2Provider", "Transfer failed. requestedRoute=" + mediaRoute2Info);
        }
    }

    public x(Context context, a aVar) {
        super(context);
        this.l = new ArrayMap();
        this.m = new e();
        this.n = new f();
        this.o = new b();
        this.r = new ArrayList();
        this.s = new ArrayMap();
        this.j = u.a(context);
        this.k = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.p = handler;
        Objects.requireNonNull(handler);
        this.q = new w(handler);
    }

    public static String B(H.e eVar) {
        MediaRouter2.RoutingController routingController;
        if ((eVar instanceof c) && (routingController = ((c) eVar).g) != null) {
            return l.a(routingController);
        }
        return null;
    }

    public static Messenger z(MediaRouter2.RoutingController routingController) {
        Bundle a2;
        if (routingController == null || (a2 = h.a(routingController)) == null) {
            return null;
        }
        return a2.getParcelable("androidx.mediarouter.media.KEY_MESSENGER");
    }

    public MediaRoute2Info A(String str) {
        if (str == null) {
            return null;
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            MediaRoute2Info a2 = u0.c.a(it.next());
            if (TextUtils.equals(u0.f.a(a2), str)) {
                return a2;
            }
        }
        return null;
    }

    public void C() {
        ArrayList arrayList = new ArrayList();
        ArraySet a2 = v.a();
        Iterator it = u0.b.a(this.j).iterator();
        while (it.hasNext()) {
            MediaRoute2Info a3 = u0.c.a(it.next());
            if (a3 != null && !a2.contains(a3) && !u0.d.a(a3)) {
                a2.add(a3);
                arrayList.add(a3);
            }
        }
        if (arrayList.equals(this.r)) {
            return;
        }
        this.r = arrayList;
        this.s.clear();
        Iterator it2 = this.r.iterator();
        while (it2.hasNext()) {
            MediaRoute2Info a4 = u0.c.a(it2.next());
            Bundle a5 = u0.e.a(a4);
            if (a5 == null || a5.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID") == null) {
                Log.w("MR2Provider", "Cannot find the original route Id. route=" + a4);
            } else {
                this.s.put(u0.f.a(a4), a5.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID"));
            }
        }
        Collection arrayList2 = new ArrayList();
        Iterator it3 = this.r.iterator();
        while (it3.hasNext()) {
            MediaRoute2Info a6 = u0.c.a(it3.next());
            F c2 = Z.c(a6);
            if (a6 != null) {
                arrayList2.add(c2);
            }
        }
        w(new I.a().d(true).b(arrayList2).c());
    }

    public void D(MediaRouter2.RoutingController routingController) {
        c cVar = (c) this.l.get(routingController);
        if (cVar == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No matching routeController found. routingController=" + routingController);
            return;
        }
        List a2 = g.a(routingController);
        if (a2.isEmpty()) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No selected routes. This may happen when the selected routes become invalid.routingController=" + routingController);
            return;
        }
        Collection a3 = Z.a(a2);
        F c2 = Z.c(u0.c.a(a2.get(0)));
        Bundle a4 = h.a(routingController);
        String string = n().getString(t0.j.p);
        F f2 = null;
        if (a4 != null) {
            try {
                String string2 = a4.getString("androidx.mediarouter.media.KEY_SESSION_NAME");
                if (!TextUtils.isEmpty(string2)) {
                    string = string2;
                }
                Bundle bundle = a4.getBundle("androidx.mediarouter.media.KEY_GROUP_ROUTE");
                if (bundle != null) {
                    f2 = F.d(bundle);
                }
            } catch (Exception e2) {
                Log.w("MR2Provider", "Exception while unparceling control hints.", e2);
            }
        }
        if (f2 == null) {
            f2 = new F.a(l.a(routingController), string).g(2).p(1).r(i.a(routingController)).t(j.a(routingController)).s(k.a(routingController)).b(c2.f()).d(a3).e();
        }
        List a5 = Z.a(m.a(routingController));
        List a6 = Z.a(n.a(routingController));
        I o = o();
        if (o == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: providerDescriptor is not set.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<F> b2 = o.b();
        if (!b2.isEmpty()) {
            for (F f3 : b2) {
                String l = f3.l();
                arrayList.add(new H.b.c.a(f3).e(a3.contains(l) ? 3 : 1).b(a5.contains(l)).d(a6.contains(l)).c(true).a());
            }
        }
        cVar.u(f2);
        cVar.l(f2, arrayList);
    }

    public void E(String str) {
        MediaRoute2Info A = A(str);
        if (A != null) {
            u0.a.a(this.j, A);
            return;
        }
        Log.w("MR2Provider", "transferTo: Specified route not found. routeId=" + str);
    }

    public final G F(G g, boolean z) {
        if (g == null) {
            g = new G(K.c, false);
        }
        Collection e2 = g.c().e();
        if (!z) {
            e2.remove("android.media.intent.category.LIVE_AUDIO");
        } else if (!e2.contains("android.media.intent.category.LIVE_AUDIO")) {
            e2.add("android.media.intent.category.LIVE_AUDIO");
        }
        return new G(new K.a().a(e2).d(), g.d());
    }

    public H.b r(String str) {
        Iterator it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            c cVar = (c) ((Map.Entry) it.next()).getValue();
            if (TextUtils.equals(str, cVar.f)) {
                return cVar;
            }
        }
        return null;
    }

    public H.e s(String str) {
        return new d((String) this.s.get(str), null);
    }

    public H.e t(String str, String str2) {
        String str3 = (String) this.s.get(str);
        for (c cVar : this.l.values()) {
            if (TextUtils.equals(str2, cVar.r())) {
                return new d(str3, cVar);
            }
        }
        Log.w("MR2Provider", "Could not find the matching GroupRouteController. routeId=" + str + ", routeGroupId=" + str2);
        return new d(str3, null);
    }

    public void u(G g) {
        if (L.h() <= 0) {
            r.a(this.j, this.m);
            s.a(this.j, this.n);
            t.a(this.j, this.o);
        } else {
            o.a(this.j, this.q, this.m, Z.b(F(g, L.r())));
            p.a(this.j, this.q, this.n);
            q.a(this.j, this.q, this.o);
        }
    }
}

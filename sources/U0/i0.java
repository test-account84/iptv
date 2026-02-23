package u0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u0.H;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class i0 extends H implements ServiceConnection {
    public static final boolean r = Log.isLoggable("MediaRouteProviderProxy", 3);
    public final ComponentName j;
    public final d k;
    public final ArrayList l;
    public boolean m;
    public boolean n;
    public a o;
    public boolean p;
    public b q;

    public final class a implements IBinder.DeathRecipient {
        public final Messenger a;
        public final e c;
        public final Messenger d;
        public int g;
        public int h;
        public int e = 1;
        public int f = 1;
        public final SparseArray i = new SparseArray();

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                a.this.e();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                a aVar = a.this;
                i0.this.J(aVar);
            }
        }

        public a(Messenger messenger) {
            this.a = messenger;
            e eVar = new e(this);
            this.c = eVar;
            this.d = new Messenger(eVar);
        }

        public void a(int i, String str) {
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i2 = this.e;
            this.e = i2 + 1;
            s(12, i2, i, null, bundle);
        }

        public int b(String str, L.c cVar) {
            int i = this.f;
            this.f = i + 1;
            int i2 = this.e;
            this.e = i2 + 1;
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            s(11, i2, i, null, bundle);
            this.i.put(i2, cVar);
            return i;
        }

        public void binderDied() {
            i0.this.k.post(new b());
        }

        public int c(String str, String str2) {
            int i = this.f;
            this.f = i + 1;
            Bundle bundle = new Bundle();
            bundle.putString("routeId", str);
            bundle.putString("routeGroupId", str2);
            int i2 = this.e;
            this.e = i2 + 1;
            s(3, i2, i, null, bundle);
            return i;
        }

        public void d() {
            s(2, 0, 0, null, null);
            this.c.a();
            this.a.getBinder().unlinkToDeath(this, 0);
            i0.this.k.post(new a());
        }

        public void e() {
            int size = this.i.size();
            for (int i = 0; i < size; i++) {
                ((L.c) this.i.valueAt(i)).a(null, null);
            }
            this.i.clear();
        }

        public boolean f(int i, String str, Bundle bundle) {
            L.c cVar = (L.c) this.i.get(i);
            if (cVar == null) {
                return false;
            }
            this.i.remove(i);
            cVar.a(str, bundle);
            return true;
        }

        public boolean g(int i, Bundle bundle) {
            L.c cVar = (L.c) this.i.get(i);
            if (cVar == null) {
                return false;
            }
            this.i.remove(i);
            cVar.b(bundle);
            return true;
        }

        public void h(int i) {
            i0.this.H(this, i);
        }

        public boolean i(Bundle bundle) {
            if (this.g == 0) {
                return false;
            }
            i0.this.I(this, I.a(bundle));
            return true;
        }

        public void j(int i, Bundle bundle) {
            L.c cVar = (L.c) this.i.get(i);
            if (bundle == null || !bundle.containsKey("routeId")) {
                cVar.a("DynamicGroupRouteController is created without valid route id.", bundle);
            } else {
                this.i.remove(i);
                cVar.b(bundle);
            }
        }

        public boolean k(int i, Bundle bundle) {
            if (this.g == 0) {
                return false;
            }
            Bundle parcelable = bundle.getParcelable("groupRoute");
            F d = parcelable != null ? F.d(parcelable) : null;
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("dynamicRoutes");
            List arrayList = new ArrayList();
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(H.b.c.a((Bundle) it.next()));
            }
            i0.this.N(this, i, d, arrayList);
            return true;
        }

        public boolean l(int i) {
            if (i == this.h) {
                this.h = 0;
                i0.this.K(this, "Registration failed");
            }
            L.c cVar = (L.c) this.i.get(i);
            if (cVar == null) {
                return true;
            }
            this.i.remove(i);
            cVar.a(null, null);
            return true;
        }

        public boolean m(int i) {
            return true;
        }

        public boolean n(int i, int i2, Bundle bundle) {
            if (this.g != 0 || i != this.h || i2 < 1) {
                return false;
            }
            this.h = 0;
            this.g = i2;
            i0.this.I(this, I.a(bundle));
            i0.this.L(this);
            return true;
        }

        public boolean o() {
            int i = this.e;
            this.e = i + 1;
            this.h = i;
            if (!s(1, i, 4, null, null)) {
                return false;
            }
            try {
                this.a.getBinder().linkToDeath(this, 0);
                return true;
            } catch (RemoteException unused) {
                binderDied();
                return false;
            }
        }

        public void p(int i) {
            int i2 = this.e;
            this.e = i2 + 1;
            s(4, i2, i, null, null);
        }

        public void q(int i, String str) {
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i2 = this.e;
            this.e = i2 + 1;
            s(13, i2, i, null, bundle);
        }

        public void r(int i) {
            int i2 = this.e;
            this.e = i2 + 1;
            s(5, i2, i, null, null);
        }

        public final boolean s(int i, int i2, int i3, Object obj, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = i2;
            obtain.arg2 = i3;
            obtain.obj = obj;
            obtain.setData(bundle);
            obtain.replyTo = this.d;
            try {
                this.a.send(obtain);
                return true;
            } catch (DeadObjectException unused) {
                return false;
            } catch (RemoteException e) {
                if (i == 2) {
                    return false;
                }
                Log.e("MediaRouteProviderProxy", "Could not send message to service.", e);
                return false;
            }
        }

        public void t(G g) {
            int i = this.e;
            this.e = i + 1;
            s(10, i, 0, g != null ? g.a() : null, null);
        }

        public void u(int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i2);
            int i3 = this.e;
            this.e = i3 + 1;
            s(7, i3, i, null, bundle);
        }

        public void v(int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", i2);
            int i3 = this.e;
            this.e = i3 + 1;
            s(6, i3, i, null, bundle);
        }

        public void w(int i, List list) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("memberRouteIds", new ArrayList(list));
            int i2 = this.e;
            this.e = i2 + 1;
            s(14, i2, i, null, bundle);
        }

        public void x(int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i2);
            int i3 = this.e;
            this.e = i3 + 1;
            s(8, i3, i, null, bundle);
        }
    }

    public interface b {
        void a(H.e eVar);
    }

    public interface c {
        void a(a aVar);

        int b();

        void c();
    }

    public static final class d extends Handler {
    }

    public static final class e extends Handler {
        public final WeakReference a;

        public e(a aVar) {
            this.a = new WeakReference(aVar);
        }

        public void a() {
            this.a.clear();
        }

        public final boolean b(a aVar, int i, int i2, int i3, Object obj, Bundle bundle) {
            switch (i) {
                case 0:
                    aVar.l(i2);
                    return true;
                case 1:
                    aVar.m(i2);
                    return true;
                case 2:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.n(i2, i3, (Bundle) obj);
                    }
                    return false;
                case 3:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.g(i2, (Bundle) obj);
                    }
                    return false;
                case 4:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.f(i2, bundle == null ? null : bundle.getString("error"), (Bundle) obj);
                    }
                    return false;
                case 5:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.i((Bundle) obj);
                    }
                    return false;
                case 6:
                    if (obj instanceof Bundle) {
                        aVar.j(i2, (Bundle) obj);
                        return false;
                    }
                    Log.w("MediaRouteProviderProxy", "No further information on the dynamic group controller");
                    return false;
                case 7:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.k(i3, (Bundle) obj);
                    }
                    return false;
                case 8:
                    aVar.h(i3);
                    return false;
                default:
                    return false;
            }
        }

        public void handleMessage(Message message) {
            a aVar = (a) this.a.get();
            if (aVar == null || b(aVar, message.what, message.arg1, message.arg2, message.obj, message.peekData()) || !i0.r) {
                return;
            }
            Log.d("MediaRouteProviderProxy", "Unhandled message from server: " + message);
        }
    }

    public final class f extends H.b implements c {
        public final String f;
        public String g;
        public String h;
        public boolean i;
        public int k;
        public a l;
        public int j = -1;
        public int m = -1;

        public class a extends L.c {
            public a() {
            }

            public void a(String str, Bundle bundle) {
                Log.d("MediaRouteProviderProxy", "Error: " + str + ", data: " + bundle);
            }

            public void b(Bundle bundle) {
                f.this.g = bundle.getString("groupableTitle");
                f.this.h = bundle.getString("transferableTitle");
            }
        }

        public f(String str) {
            this.f = str;
        }

        public void a(a aVar) {
            a aVar2 = new a();
            this.l = aVar;
            int b = aVar.b(this.f, aVar2);
            this.m = b;
            if (this.i) {
                aVar.r(b);
                int i = this.j;
                if (i >= 0) {
                    aVar.u(this.m, i);
                    this.j = -1;
                }
                int i2 = this.k;
                if (i2 != 0) {
                    aVar.x(this.m, i2);
                    this.k = 0;
                }
            }
        }

        public int b() {
            return this.m;
        }

        public void c() {
            a aVar = this.l;
            if (aVar != null) {
                aVar.p(this.m);
                this.l = null;
                this.m = 0;
            }
        }

        public void d() {
            i0.this.M(this);
        }

        public void e() {
            this.i = true;
            a aVar = this.l;
            if (aVar != null) {
                aVar.r(this.m);
            }
        }

        public void f(int i) {
            a aVar = this.l;
            if (aVar != null) {
                aVar.u(this.m, i);
            } else {
                this.j = i;
                this.k = 0;
            }
        }

        public void g() {
            h(0);
        }

        public void h(int i) {
            this.i = false;
            a aVar = this.l;
            if (aVar != null) {
                aVar.v(this.m, i);
            }
        }

        public void i(int i) {
            a aVar = this.l;
            if (aVar != null) {
                aVar.x(this.m, i);
            } else {
                this.k += i;
            }
        }

        public String j() {
            return this.g;
        }

        public String k() {
            return this.h;
        }

        public void m(String str) {
            a aVar = this.l;
            if (aVar != null) {
                aVar.a(this.m, str);
            }
        }

        public void n(String str) {
            a aVar = this.l;
            if (aVar != null) {
                aVar.q(this.m, str);
            }
        }

        public void o(List list) {
            a aVar = this.l;
            if (aVar != null) {
                aVar.w(this.m, list);
            }
        }

        public void q(F f, List list) {
            l(f, list);
        }
    }

    public final class g extends H.e implements c {
        public final String a;
        public final String b;
        public boolean c;
        public int d = -1;
        public int e;
        public a f;
        public int g;

        public g(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void a(a aVar) {
            this.f = aVar;
            int c = aVar.c(this.a, this.b);
            this.g = c;
            if (this.c) {
                aVar.r(c);
                int i = this.d;
                if (i >= 0) {
                    aVar.u(this.g, i);
                    this.d = -1;
                }
                int i2 = this.e;
                if (i2 != 0) {
                    aVar.x(this.g, i2);
                    this.e = 0;
                }
            }
        }

        public int b() {
            return this.g;
        }

        public void c() {
            a aVar = this.f;
            if (aVar != null) {
                aVar.p(this.g);
                this.f = null;
                this.g = 0;
            }
        }

        public void d() {
            i0.this.M(this);
        }

        public void e() {
            this.c = true;
            a aVar = this.f;
            if (aVar != null) {
                aVar.r(this.g);
            }
        }

        public void f(int i) {
            a aVar = this.f;
            if (aVar != null) {
                aVar.u(this.g, i);
            } else {
                this.d = i;
                this.e = 0;
            }
        }

        public void g() {
            h(0);
        }

        public void h(int i) {
            this.c = false;
            a aVar = this.f;
            if (aVar != null) {
                aVar.v(this.g, i);
            }
        }

        public void i(int i) {
            a aVar = this.f;
            if (aVar != null) {
                aVar.x(this.g, i);
            } else {
                this.e += i;
            }
        }
    }

    public i0(Context context, ComponentName componentName) {
        super(context, new H.d(componentName));
        this.l = new ArrayList();
        this.j = componentName;
        this.k = new d();
    }

    public final void A() {
        if (this.n) {
            return;
        }
        boolean z = r;
        if (z) {
            Log.d("MediaRouteProviderProxy", this + ": Binding");
        }
        Intent intent = new Intent("android.media.MediaRouteProviderService");
        intent.setComponent(this.j);
        try {
            boolean bindService = n().bindService(intent, this, Build.VERSION.SDK_INT >= 29 ? 4097 : 1);
            this.n = bindService;
            if (bindService || !z) {
                return;
            }
            Log.d("MediaRouteProviderProxy", this + ": Bind failed");
        } catch (SecurityException e2) {
            if (r) {
                Log.d("MediaRouteProviderProxy", this + ": Bind failed", e2);
            }
        }
    }

    public final H.b B(String str) {
        I o = o();
        if (o == null) {
            return null;
        }
        List b2 = o.b();
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            if (((F) b2.get(i)).l().equals(str)) {
                f fVar = new f(str);
                this.l.add(fVar);
                if (this.p) {
                    fVar.a(this.o);
                }
                U();
                return fVar;
            }
        }
        return null;
    }

    public final H.e C(String str, String str2) {
        I o = o();
        if (o == null) {
            return null;
        }
        List b2 = o.b();
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            if (((F) b2.get(i)).l().equals(str)) {
                g gVar = new g(str, str2);
                this.l.add(gVar);
                if (this.p) {
                    gVar.a(this.o);
                }
                U();
                return gVar;
            }
        }
        return null;
    }

    public final void D() {
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            ((c) this.l.get(i)).c();
        }
    }

    public final void E() {
        if (this.o != null) {
            w(null);
            this.p = false;
            D();
            this.o.d();
            this.o = null;
        }
    }

    public final c F(int i) {
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.b() == i) {
                return cVar;
            }
        }
        return null;
    }

    public boolean G(String str, String str2) {
        return this.j.getPackageName().equals(str) && this.j.getClassName().equals(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void H(a aVar, int i) {
        if (this.o == aVar) {
            c F = F(i);
            b bVar = this.q;
            if (bVar != null && (F instanceof H.e)) {
                bVar.a((H.e) F);
            }
            M(F);
        }
    }

    public void I(a aVar, I i) {
        if (this.o == aVar) {
            if (r) {
                Log.d("MediaRouteProviderProxy", this + ": Descriptor changed, descriptor=" + i);
            }
            w(i);
        }
    }

    public void J(a aVar) {
        if (this.o == aVar) {
            if (r) {
                Log.d("MediaRouteProviderProxy", this + ": Service connection died");
            }
            E();
        }
    }

    public void K(a aVar, String str) {
        if (this.o == aVar) {
            if (r) {
                Log.d("MediaRouteProviderProxy", this + ": Service connection error - " + str);
            }
            T();
        }
    }

    public void L(a aVar) {
        if (this.o == aVar) {
            this.p = true;
            z();
            G p = p();
            if (p != null) {
                this.o.t(p);
            }
        }
    }

    public void M(c cVar) {
        this.l.remove(cVar);
        cVar.c();
        U();
    }

    public void N(a aVar, int i, F f2, List list) {
        if (this.o == aVar) {
            if (r) {
                Log.d("MediaRouteProviderProxy", this + ": DynamicRouteDescriptors changed, descriptors=" + list);
            }
            c F = F(i);
            if (F instanceof f) {
                ((f) F).q(f2, list);
            }
        }
    }

    public void O() {
        if (this.o == null && Q()) {
            T();
            A();
        }
    }

    public void P(b bVar) {
        this.q = bVar;
    }

    public final boolean Q() {
        if (this.m) {
            return (p() == null && this.l.isEmpty()) ? false : true;
        }
        return false;
    }

    public void R() {
        if (this.m) {
            return;
        }
        if (r) {
            Log.d("MediaRouteProviderProxy", this + ": Starting");
        }
        this.m = true;
        U();
    }

    public void S() {
        if (this.m) {
            if (r) {
                Log.d("MediaRouteProviderProxy", this + ": Stopping");
            }
            this.m = false;
            U();
        }
    }

    public final void T() {
        if (this.n) {
            if (r) {
                Log.d("MediaRouteProviderProxy", this + ": Unbinding");
            }
            this.n = false;
            E();
            try {
                n().unbindService(this);
            } catch (IllegalArgumentException e2) {
                Log.e("MediaRouteProviderProxy", this + ": unbindService failed", e2);
            }
        }
    }

    public final void U() {
        if (Q()) {
            A();
        } else {
            T();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z = r;
        if (z) {
            Log.d("MediaRouteProviderProxy", this + ": Connected");
        }
        if (this.n) {
            E();
            Messenger messenger = iBinder != null ? new Messenger(iBinder) : null;
            if (!J.a(messenger)) {
                Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
                return;
            }
            a aVar = new a(messenger);
            if (aVar.o()) {
                this.o = aVar;
            } else if (z) {
                Log.d("MediaRouteProviderProxy", this + ": Registration failed");
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (r) {
            Log.d("MediaRouteProviderProxy", this + ": Service disconnected");
        }
        E();
    }

    public H.b r(String str) {
        if (str != null) {
            return B(str);
        }
        throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
    }

    public H.e s(String str) {
        if (str != null) {
            return C(str, null);
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    public H.e t(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if (str2 != null) {
            return C(str, str2);
        }
        throw new IllegalArgumentException("routeGroupId cannot be null");
    }

    public String toString() {
        return "Service connection " + this.j.flattenToShortString();
    }

    public void u(G g2) {
        if (this.p) {
            this.o.t(g2);
        }
        U();
    }

    public final void z() {
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            ((c) this.l.get(i)).a(this.o);
        }
    }
}

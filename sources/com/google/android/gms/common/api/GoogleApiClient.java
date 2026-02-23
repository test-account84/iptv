package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.X0;
import com.google.android.gms.common.api.internal.Y;
import com.google.android.gms.common.api.internal.e1;
import com.google.android.gms.common.internal.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class GoogleApiClient {
    public static final Set a = Collections.newSetFromMap(new WeakHashMap());

    public static final class a {
        public Account a;
        public int d;
        public View e;
        public String f;
        public String g;
        public final Context i;
        public com.google.android.gms.common.api.internal.i k;
        public c m;
        public Looper n;
        public final Set b = new HashSet();
        public final Set c = new HashSet();
        public final Map h = new s.a();
        public final Map j = new s.a();
        public int l = -1;
        public w4.h o = w4.h.q();
        public a.a p = O4.d.c;
        public final ArrayList q = new ArrayList();
        public final ArrayList r = new ArrayList();

        public a(Context context) {
            this.i = context;
            this.n = context.getMainLooper();
            this.f = context.getPackageName();
            this.g = context.getClass().getName();
        }

        public a a(com.google.android.gms.common.api.a aVar) {
            r.n(aVar, "Api must not be null");
            this.j.put(aVar, (Object) null);
            List impliedScopes = ((a.e) r.n(aVar.c(), "Base client builder must not be null")).getImpliedScopes(null);
            this.c.addAll(impliedScopes);
            this.b.addAll(impliedScopes);
            return this;
        }

        public a b(b bVar) {
            r.n(bVar, "Listener must not be null");
            this.q.add(bVar);
            return this;
        }

        public a c(c cVar) {
            r.n(cVar, "Listener must not be null");
            this.r.add(cVar);
            return this;
        }

        public GoogleApiClient d() {
            r.b(!this.j.isEmpty(), "must call addApi() to add at least one API");
            com.google.android.gms.common.internal.e f = f();
            Map j = f.j();
            s.a aVar = new s.a();
            s.a aVar2 = new s.a();
            ArrayList arrayList = new ArrayList();
            com.google.android.gms.common.api.a aVar3 = null;
            boolean z = false;
            for (com.google.android.gms.common.api.a aVar4 : this.j.keySet()) {
                Object obj = this.j.get(aVar4);
                boolean z2 = j.get(aVar4) != null;
                aVar.put(aVar4, Boolean.valueOf(z2));
                e1 e1Var = new e1(aVar4, z2);
                arrayList.add(e1Var);
                a.a aVar5 = (a.a) r.m(aVar4.a());
                a.f buildClient = aVar5.buildClient(this.i, this.n, f, obj, (b) e1Var, (c) e1Var);
                aVar2.put(aVar4.b(), buildClient);
                if (aVar5.getPriority() == 1) {
                    z = obj != null;
                }
                if (buildClient.providesSignIn()) {
                    if (aVar3 != null) {
                        throw new IllegalStateException(aVar4.d() + " cannot be used with " + aVar3.d());
                    }
                    aVar3 = aVar4;
                }
            }
            if (aVar3 != null) {
                if (z) {
                    throw new IllegalStateException("With using " + aVar3.d() + ", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                }
                r.r(this.a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", aVar3.d());
                r.r(this.b.equals(this.c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", aVar3.d());
            }
            Y y = new Y(this.i, new ReentrantLock(), this.n, f, this.o, this.p, aVar, this.q, this.r, aVar2, this.l, Y.n(aVar2.values(), true), arrayList);
            synchronized (GoogleApiClient.m()) {
                GoogleApiClient.m().add(y);
            }
            if (this.l >= 0) {
                X0.i(this.k).j(this.l, y, this.m);
            }
            return y;
        }

        public a e(Handler handler) {
            r.n(handler, "Handler must not be null");
            this.n = handler.getLooper();
            return this;
        }

        public final com.google.android.gms.common.internal.e f() {
            O4.a aVar = O4.a.k;
            Map map = this.j;
            com.google.android.gms.common.api.a aVar2 = O4.d.g;
            if (map.containsKey(aVar2)) {
                aVar = (O4.a) this.j.get(aVar2);
            }
            return new com.google.android.gms.common.internal.e(this.a, this.b, this.h, this.d, this.e, this.f, this.g, aVar, false);
        }
    }

    public interface b extends com.google.android.gms.common.api.internal.f {
    }

    public interface c extends com.google.android.gms.common.api.internal.n {
    }

    public static /* bridge */ /* synthetic */ Set m() {
        return a;
    }

    public abstract void connect();

    public abstract void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void disconnect();

    public com.google.android.gms.common.api.internal.d e(com.google.android.gms.common.api.internal.d dVar) {
        throw new UnsupportedOperationException();
    }

    public com.google.android.gms.common.api.internal.d f(com.google.android.gms.common.api.internal.d dVar) {
        throw new UnsupportedOperationException();
    }

    public a.f g(a.c cVar) {
        throw new UnsupportedOperationException();
    }

    public Context h() {
        throw new UnsupportedOperationException();
    }

    public Looper i() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean j();

    public abstract void k(c cVar);

    public abstract void l(c cVar);
}

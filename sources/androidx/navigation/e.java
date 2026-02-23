package androidx.navigation;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.j;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e implements androidx.lifecycle.p, N, androidx.lifecycle.i, F0.e {
    public final Context a;
    public final k c;
    public Bundle d;
    public final androidx.lifecycle.q e;
    public final F0.d f;
    public final UUID g;
    public j.c h;
    public j.c i;
    public g j;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j.b.values().length];
            a = iArr;
            try {
                iArr[j.b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j.b.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[j.b.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[j.b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[j.b.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[j.b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[j.b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public e(Context context, k kVar, Bundle bundle, androidx.lifecycle.p pVar, g gVar) {
        this(context, kVar, bundle, pVar, gVar, UUID.randomUUID(), null);
    }

    public static j.c d(j.b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
            case 2:
                return j.c.CREATED;
            case 3:
            case 4:
                return j.c.STARTED;
            case 5:
                return j.c.RESUMED;
            case 6:
                return j.c.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + bVar);
        }
    }

    public Bundle a() {
        return this.d;
    }

    public k b() {
        return this.c;
    }

    public j.c c() {
        return this.i;
    }

    public void e(j.b bVar) {
        this.h = d(bVar);
        i();
    }

    public void f(Bundle bundle) {
        this.d = bundle;
    }

    public void g(Bundle bundle) {
        this.f.e(bundle);
    }

    public /* synthetic */ m0.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.h.a(this);
    }

    public androidx.lifecycle.j getLifecycle() {
        return this.e;
    }

    public F0.c getSavedStateRegistry() {
        return this.f.b();
    }

    public M getViewModelStore() {
        g gVar = this.j;
        if (gVar != null) {
            return gVar.d(this.g);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    public void h(j.c cVar) {
        this.i = cVar;
        i();
    }

    public void i() {
        androidx.lifecycle.q qVar;
        j.c cVar;
        if (this.h.ordinal() < this.i.ordinal()) {
            qVar = this.e;
            cVar = this.h;
        } else {
            qVar = this.e;
            cVar = this.i;
        }
        qVar.o(cVar);
    }

    public e(Context context, k kVar, Bundle bundle, androidx.lifecycle.p pVar, g gVar, UUID uuid, Bundle bundle2) {
        this.e = new androidx.lifecycle.q(this);
        F0.d a2 = F0.d.a(this);
        this.f = a2;
        this.h = j.c.CREATED;
        this.i = j.c.RESUMED;
        this.a = context;
        this.g = uuid;
        this.c = kVar;
        this.d = bundle;
        this.j = gVar;
        a2.d(bundle2);
        if (pVar != null) {
            this.h = pVar.getLifecycle().b();
        }
    }
}

package androidx.mediarouter.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import u0.K;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MediaRouteActionProvider extends P.b {
    public final L d;
    public final a e;
    public K f;
    public e g;
    public MediaRouteButton h;
    public boolean i;

    public static final class a extends L.a {
        public final WeakReference a;

        public a(MediaRouteActionProvider mediaRouteActionProvider) {
            this.a = new WeakReference(mediaRouteActionProvider);
        }

        public final void a(L l) {
            MediaRouteActionProvider mediaRouteActionProvider = (MediaRouteActionProvider) this.a.get();
            if (mediaRouteActionProvider != null) {
                mediaRouteActionProvider.n();
            } else {
                l.s(this);
            }
        }

        public void onProviderAdded(L l, L.g gVar) {
            a(l);
        }

        public void onProviderChanged(L l, L.g gVar) {
            a(l);
        }

        public void onProviderRemoved(L l, L.g gVar) {
            a(l);
        }

        public void onRouteAdded(L l, L.h hVar) {
            a(l);
        }

        public void onRouteChanged(L l, L.h hVar) {
            a(l);
        }

        public void onRouteRemoved(L l, L.h hVar) {
            a(l);
        }
    }

    public MediaRouteActionProvider(Context context) {
        super(context);
        this.f = K.c;
        this.g = e.getDefault();
        this.d = L.j(context);
        this.e = new a(this);
    }

    public boolean c() {
        return this.i || this.d.q(this.f, 1);
    }

    public View d() {
        if (this.h != null) {
            Log.e("MRActionProvider", "onCreateActionView: this ActionProvider is already associated with a menu item. Don't reuse MediaRouteActionProvider instances! Abandoning the old menu item...");
        }
        MediaRouteButton m = m();
        this.h = m;
        m.setCheatSheetEnabled(true);
        this.h.setRouteSelector(this.f);
        this.h.setAlwaysVisible(this.i);
        this.h.setDialogFactory(this.g);
        this.h.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        return this.h;
    }

    public boolean f() {
        MediaRouteButton mediaRouteButton = this.h;
        if (mediaRouteButton != null) {
            return mediaRouteButton.d();
        }
        return false;
    }

    public boolean h() {
        return true;
    }

    public MediaRouteButton m() {
        return new MediaRouteButton(a());
    }

    public void n() {
        i();
    }

    public void o(boolean z) {
        if (this.i != z) {
            this.i = z;
            i();
            MediaRouteButton mediaRouteButton = this.h;
            if (mediaRouteButton != null) {
                mediaRouteButton.setAlwaysVisible(this.i);
            }
        }
    }

    public void p(e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("factory must not be null");
        }
        if (this.g != eVar) {
            this.g = eVar;
            MediaRouteButton mediaRouteButton = this.h;
            if (mediaRouteButton != null) {
                mediaRouteButton.setDialogFactory(eVar);
            }
        }
    }

    public void q(K k) {
        if (k == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f.equals(k)) {
            return;
        }
        if (!this.f.f()) {
            this.d.s(this.e);
        }
        if (!k.f()) {
            this.d.a(k, this.e);
        }
        this.f = k;
        n();
        MediaRouteButton mediaRouteButton = this.h;
        if (mediaRouteButton != null) {
            mediaRouteButton.setRouteSelector(k);
        }
    }
}

package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import u0.K;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends androidx.fragment.app.d {
    public boolean a = false;
    public Dialog c;
    public K d;

    public d() {
        setCancelable(true);
    }

    private void A() {
        if (this.d == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.d = K.d(arguments.getBundle("selector"));
            }
            if (this.d == null) {
                this.d = K.c;
            }
        }
    }

    public c B(Context context, Bundle bundle) {
        return new c(context);
    }

    public h D(Context context) {
        return new h(context);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.c;
        if (dialog != null) {
            if (this.a) {
                ((h) dialog).updateLayout();
            } else {
                ((c) dialog).updateLayout();
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a) {
            h D = D(getContext());
            this.c = D;
            D.setRouteSelector(this.d);
        } else {
            this.c = B(getContext(), bundle);
        }
        return this.c;
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.c;
        if (dialog == null || this.a) {
            return;
        }
        ((c) dialog).l(false);
    }

    public void setRouteSelector(K k) {
        if (k == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        A();
        if (this.d.equals(k)) {
            return;
        }
        this.d = k;
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBundle("selector", k.a());
        setArguments(arguments);
        Dialog dialog = this.c;
        if (dialog == null || !this.a) {
            return;
        }
        ((h) dialog).setRouteSelector(k);
    }

    public void setUseDynamicGroup(boolean z) {
        if (this.c != null) {
            throw new IllegalStateException("This must be called before creating dialog");
        }
        this.a = z;
    }
}

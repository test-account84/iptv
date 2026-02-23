package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import u0.K;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends androidx.fragment.app.d {
    private static final String ARGUMENT_SELECTOR = "selector";
    private Dialog mDialog;
    private K mSelector;
    private boolean mUseDynamicGroup = false;

    public b() {
        setCancelable(true);
    }

    public final void A() {
        if (this.mSelector == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.mSelector = K.d(arguments.getBundle("selector"));
            }
            if (this.mSelector == null) {
                this.mSelector = K.c;
            }
        }
    }

    public K getRouteSelector() {
        A();
        return this.mSelector;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.mDialog;
        if (dialog == null) {
            return;
        }
        if (this.mUseDynamicGroup) {
            ((g) dialog).updateLayout();
        } else {
            ((a) dialog).updateLayout();
        }
    }

    public a onCreateChooserDialog(Context context, Bundle bundle) {
        return new a(context);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.mUseDynamicGroup) {
            g onCreateDynamicChooserDialog = onCreateDynamicChooserDialog(getContext());
            this.mDialog = onCreateDynamicChooserDialog;
            onCreateDynamicChooserDialog.setRouteSelector(getRouteSelector());
        } else {
            a onCreateChooserDialog = onCreateChooserDialog(getContext(), bundle);
            this.mDialog = onCreateChooserDialog;
            onCreateChooserDialog.setRouteSelector(getRouteSelector());
        }
        return this.mDialog;
    }

    public g onCreateDynamicChooserDialog(Context context) {
        return new g(context);
    }

    public void setRouteSelector(K k) {
        if (k == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        A();
        if (this.mSelector.equals(k)) {
            return;
        }
        this.mSelector = k;
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBundle("selector", k.a());
        setArguments(arguments);
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            if (this.mUseDynamicGroup) {
                ((g) dialog).setRouteSelector(k);
            } else {
                ((a) dialog).setRouteSelector(k);
            }
        }
    }

    public void setUseDynamicGroup(boolean z) {
        if (this.mDialog != null) {
            throw new IllegalStateException("This must be called before creating dialog");
        }
        this.mUseDynamicGroup = z;
    }
}

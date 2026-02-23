package p;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class f {
    public final Object a = new Object();
    public final ICustomTabsService b;
    public final ICustomTabsCallback c;
    public final ComponentName d;
    public final PendingIntent e;

    public f(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName, PendingIntent pendingIntent) {
        this.b = iCustomTabsService;
        this.c = iCustomTabsCallback;
        this.d = componentName;
        this.e = pendingIntent;
    }

    public final void a(Bundle bundle) {
        PendingIntent pendingIntent = this.e;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
    }

    public final Bundle b(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        a(bundle2);
        return bundle2;
    }

    public IBinder c() {
        return this.c.asBinder();
    }

    public ComponentName d() {
        return this.d;
    }

    public PendingIntent e() {
        return this.e;
    }

    public boolean f(Uri uri, Bundle bundle, List list) {
        try {
            return this.b.mayLaunchUrl(this.c, uri, b(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }
}

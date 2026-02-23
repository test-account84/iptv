package p;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e implements ServiceConnection {
    private Context mApplicationContext;

    public class a extends c {
        public a(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
            super(iCustomTabsService, componentName, context);
        }
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(ComponentName componentName, c cVar);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.mApplicationContext == null) {
            throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
        }
        onCustomTabsServiceConnected(componentName, new a(ICustomTabsService.Stub.asInterface(iBinder), componentName, this.mApplicationContext));
    }

    public void setApplicationContext(Context context) {
        this.mApplicationContext = context;
    }
}

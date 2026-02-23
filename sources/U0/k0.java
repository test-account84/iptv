package u0;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import u0.H;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class k0 {
    public final Context a;
    public final c b;
    public final PackageManager d;
    public boolean f;
    public final ArrayList e = new ArrayList();
    public final BroadcastReceiver g = new a();
    public final Runnable h = new b();
    public final Handler c = new Handler();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            k0.this.g();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            k0.this.g();
        }
    }

    public interface c {
        void a(H h);

        void b(H h);

        void d(i0 i0Var, H.e eVar);
    }

    public k0(Context context, c cVar) {
        this.a = context;
        this.b = cVar;
        this.d = context.getPackageManager();
    }

    public static /* synthetic */ void a(k0 k0Var, i0 i0Var, H.e eVar) {
        k0Var.d(i0Var, eVar);
    }

    public static boolean e(List list, ServiceInfo serviceInfo) {
        if (serviceInfo != null && list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ServiceInfo serviceInfo2 = (ServiceInfo) it.next();
                if (serviceInfo.packageName.equals(serviceInfo2.packageName) && serviceInfo.name.equals(serviceInfo2.name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int b(String str, String str2) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            if (((i0) this.e.get(i)).G(str, str2)) {
                return i;
            }
        }
        return -1;
    }

    public List c() {
        Intent intent = new Intent("android.media.MediaRoute2ProviderService");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.d.queryIntentServices(intent, 0).iterator();
        while (it.hasNext()) {
            arrayList.add(((ResolveInfo) it.next()).serviceInfo);
        }
        return arrayList;
    }

    public final /* synthetic */ void d(i0 i0Var, H.e eVar) {
        this.b.d(i0Var, eVar);
    }

    public void f() {
        this.c.post(this.h);
    }

    public void g() {
        int i;
        if (this.f) {
            List arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 30) {
                arrayList = c();
            }
            int i2 = 0;
            Iterator it = this.d.queryIntentServices(new Intent("android.media.MediaRouteProviderService"), 0).iterator();
            while (it.hasNext()) {
                ServiceInfo serviceInfo = ((ResolveInfo) it.next()).serviceInfo;
                if (serviceInfo != null && (!L.p() || !e(arrayList, serviceInfo))) {
                    int b2 = b(serviceInfo.packageName, serviceInfo.name);
                    if (b2 < 0) {
                        i0 i0Var = new i0(this.a, new ComponentName(serviceInfo.packageName, serviceInfo.name));
                        i0Var.P(new j0(this, i0Var));
                        i0Var.R();
                        i = i2 + 1;
                        this.e.add(i2, i0Var);
                        this.b.a(i0Var);
                    } else if (b2 >= i2) {
                        i0 i0Var2 = (i0) this.e.get(b2);
                        i0Var2.R();
                        i0Var2.O();
                        i = i2 + 1;
                        Collections.swap(this.e, b2, i2);
                    }
                    i2 = i;
                }
            }
            if (i2 < this.e.size()) {
                for (int size = this.e.size() - 1; size >= i2; size--) {
                    i0 i0Var3 = (i0) this.e.get(size);
                    this.b.b(i0Var3);
                    this.e.remove(i0Var3);
                    i0Var3.P(null);
                    i0Var3.S();
                }
            }
        }
    }

    public void h() {
        if (this.f) {
            return;
        }
        this.f = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
        intentFilter.addDataScheme("package");
        this.a.registerReceiver(this.g, intentFilter, (String) null, this.c);
        this.c.post(this.h);
    }
}

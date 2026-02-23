package D2;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class k implements e {
    public final a a;
    public final i b;
    public final Map c;

    public static class a {
        public final Context a;
        public Map b = null;

        public a(Context context) {
            this.a = context;
        }

        public static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        public final Map a(Context context) {
            Bundle d = d(context);
            if (d == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String str : d.keySet()) {
                Object obj = d.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String trim = str2.trim();
                        if (!trim.isEmpty()) {
                            hashMap.put(trim, str.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        public d b(String str) {
            String format;
            String format2;
            String str2 = (String) c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (d) Class.forName(str2).asSubclass(d.class).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            } catch (ClassNotFoundException e) {
                e = e;
                format = String.format("Class %s is not found.", new Object[]{str2});
                Log.w("BackendRegistry", format, e);
                return null;
            } catch (IllegalAccessException e2) {
                e = e2;
                format2 = String.format("Could not instantiate %s.", new Object[]{str2});
                Log.w("BackendRegistry", format2, e);
                return null;
            } catch (InvocationTargetException e3) {
                e = e3;
                format = String.format("Could not instantiate %s", new Object[]{str2});
                Log.w("BackendRegistry", format, e);
                return null;
            } catch (InstantiationException e4) {
                e = e4;
                format2 = String.format("Could not instantiate %s.", new Object[]{str2});
                Log.w("BackendRegistry", format2, e);
                return null;
            } catch (NoSuchMethodException e5) {
                e = e5;
                format = String.format("Could not instantiate %s", new Object[]{str2});
                Log.w("BackendRegistry", format, e);
                return null;
            }
        }

        public final Map c() {
            if (this.b == null) {
                this.b = a(this.a);
            }
            return this.b;
        }
    }

    public k(a aVar, i iVar) {
        this.c = new HashMap();
        this.a = aVar;
        this.b = iVar;
    }

    public synchronized m get(String str) {
        if (this.c.containsKey(str)) {
            return (m) this.c.get(str);
        }
        d b = this.a.b(str);
        if (b == null) {
            return null;
        }
        m create = b.create(this.b.a(str));
        this.c.put(str, create);
        return create;
    }

    public k(Context context, i iVar) {
        this(new a(context), iVar);
    }
}

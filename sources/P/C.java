package p;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {
    public final ICustomTabsService a;
    public final ComponentName b;
    public final Context c;

    public class a extends ICustomTabsCallback.Stub {
        public Handler a = new Handler(Looper.getMainLooper());
        public final /* synthetic */ p.b c;

        public class a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ Bundle c;

            public a(int i, Bundle bundle) {
                this.a = i;
                this.c = bundle;
            }

            public void run() {
                a.this.c.onNavigationEvent(this.a, this.c);
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ Bundle c;

            public b(String str, Bundle bundle) {
                this.a = str;
                this.c = bundle;
            }

            public void run() {
                a.this.c.extraCallback(this.a, this.c);
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ Bundle a;

            public c(Bundle bundle) {
                this.a = bundle;
            }

            public void run() {
                a.this.c.onMessageChannelReady(this.a);
            }
        }

        public class d implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ Bundle c;

            public d(String str, Bundle bundle) {
                this.a = str;
                this.c = bundle;
            }

            public void run() {
                a.this.c.onPostMessage(this.a, this.c);
            }
        }

        public class e implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ Uri c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ Bundle e;

            public e(int i, Uri uri, boolean z, Bundle bundle) {
                this.a = i;
                this.c = uri;
                this.d = z;
                this.e = bundle;
            }

            public void run() {
                a.this.c.onRelationshipValidationResult(this.a, this.c, this.d, this.e);
            }
        }

        public a(p.b bVar) {
            this.c = bVar;
        }

        public void extraCallback(String str, Bundle bundle) {
            if (this.c == null) {
                return;
            }
            this.a.post(new b(str, bundle));
        }

        public Bundle extraCallbackWithResult(String str, Bundle bundle) {
            p.b bVar = this.c;
            if (bVar == null) {
                return null;
            }
            return bVar.extraCallbackWithResult(str, bundle);
        }

        public void onMessageChannelReady(Bundle bundle) {
            if (this.c == null) {
                return;
            }
            this.a.post(new c(bundle));
        }

        public void onNavigationEvent(int i, Bundle bundle) {
            if (this.c == null) {
                return;
            }
            this.a.post(new a(i, bundle));
        }

        public void onPostMessage(String str, Bundle bundle) {
            if (this.c == null) {
                return;
            }
            this.a.post(new d(str, bundle));
        }

        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
            if (this.c == null) {
                return;
            }
            this.a.post(new e(i, uri, z, bundle));
        }
    }

    public c(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.a = iCustomTabsService;
        this.b = componentName;
        this.c = context;
    }

    public static boolean a(Context context, String str, e eVar) {
        eVar.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, eVar, 33);
    }

    public static String c(Context context, List list) {
        return d(context, list, false);
    }

    public static String d(Context context, List list, boolean z) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        List<String> arrayList = list == null ? new ArrayList() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z && (resolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveActivity.activityInfo.packageName;
            List arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent("android.support.customtabs.action.CustomTabsService");
        for (String str2 : arrayList) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Log.w("CustomTabsClient", "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
        return null;
    }

    public final ICustomTabsCallback.Stub b(b bVar) {
        return new a(bVar);
    }

    public f e(b bVar) {
        return f(bVar, null);
    }

    public final f f(b bVar, PendingIntent pendingIntent) {
        boolean newSession;
        ICustomTabsCallback.Stub b = b(bVar);
        try {
            if (pendingIntent != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                newSession = this.a.newSessionWithExtras(b, bundle);
            } else {
                newSession = this.a.newSession(b);
            }
            if (newSession) {
                return new f(this.a, b, this.b, pendingIntent);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public boolean g(long j) {
        try {
            return this.a.warmup(j);
        } catch (RemoteException unused) {
            return false;
        }
    }
}

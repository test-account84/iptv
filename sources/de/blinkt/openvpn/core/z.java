package de.blinkt.openvpn.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class z {
    public static z f;
    public Context c;
    public String a = "org.torproject.android.intent.extra.SOCKS_PROXY_HOST";
    public String b = "org.torproject.android.intent.extra.SOCKS_PROXY_PORT";
    public Set d = new HashSet();
    public BroadcastReceiver e = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "org.torproject.android.intent.action.STATUS")) {
                Iterator it = z.a(z.this).iterator();
                while (it.hasNext()) {
                    ((b) it.next()).b(intent);
                }
                String stringExtra = intent.getStringExtra("org.torproject.android.intent.extra.STATUS");
                if (!TextUtils.equals(stringExtra, "ON")) {
                    if (TextUtils.equals(stringExtra, "STARTS_DISABLED")) {
                        Iterator it2 = z.a(z.this).iterator();
                        while (it2.hasNext()) {
                            ((b) it2.next()).d(intent);
                        }
                        return;
                    }
                    return;
                }
                int intExtra = intent.getIntExtra(z.this.b, 9050);
                String stringExtra2 = intent.getStringExtra(z.this.a);
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = "127.0.0.1";
                }
                Iterator it3 = z.a(z.this).iterator();
                while (it3.hasNext()) {
                    ((b) it3.next()).c(intent, stringExtra2, intExtra);
                }
            }
        }
    }

    public interface b {
        void a();

        void b(Intent intent);

        void c(Intent intent, String str, int i);

        void d(Intent intent);
    }

    public static /* synthetic */ Set a(z zVar) {
        return zVar.d;
    }

    public static boolean c(Context context) {
        List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(e(context), 0);
        return queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0;
    }

    public static z d(OpenVPNService openVPNService) {
        if (f == null) {
            f = new z();
        }
        return f;
    }

    public static Intent e(Context context) {
        Intent intent = new Intent("org.torproject.android.intent.action.START");
        intent.setPackage("org.torproject.android");
        intent.putExtra("org.torproject.android.intent.extra.PACKAGE_NAME", context.getPackageName());
        return intent;
    }

    public synchronized z b(Context context, b bVar) {
        try {
            if (this.d.size() == 0) {
                context.getApplicationContext().registerReceiver(this.e, new IntentFilter("org.torproject.android.intent.action.STATUS"));
                this.c = context.getApplicationContext();
            }
            if (!c(context)) {
                bVar.a();
            }
            this.d.add(bVar);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized void f(b bVar) {
        this.d.remove(bVar);
        if (this.d.size() == 0) {
            this.c.unregisterReceiver(this.e);
        }
    }

    public void g() {
        Context context = this.c;
        context.sendBroadcast(e(context));
    }
}

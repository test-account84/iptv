package de.blinkt.openvpn.api;

import a7.j;
import android.annotation.TargetApi;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.VpnService;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import de.blinkt.openvpn.LaunchVPN;
import de.blinkt.openvpn.api.a;
import de.blinkt.openvpn.core.C;
import de.blinkt.openvpn.core.F;
import de.blinkt.openvpn.core.G;
import de.blinkt.openvpn.core.OpenVPNService;
import de.blinkt.openvpn.core.c;
import de.blinkt.openvpn.core.h;
import f8.l;
import java.io.IOException;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

@TargetApi(15)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ExternalOpenVPNService extends Service implements G.e {
    public static final d i = new d();
    public h c;
    public h8.b d;
    public e h;
    public final RemoteCallbackList a = new RemoteCallbackList();
    public ServiceConnection e = new a();
    public BroadcastReceiver f = new b();
    public final a.a g = new c();

    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ExternalOpenVPNService.b(ExternalOpenVPNService.this, (h) iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            ExternalOpenVPNService.b(ExternalOpenVPNService.this, null);
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"android.intent.action.UNINSTALL_PACKAGE".equals(intent.getAction())) {
                return;
            }
            l i = C.i();
            if (C.l() && intent.getPackage().equals(i.i0) && ExternalOpenVPNService.a(ExternalOpenVPNService.this) != null) {
                try {
                    ExternalOpenVPNService.a(ExternalOpenVPNService.this).a(false);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class c extends a.a {
        public c() {
        }

        public final void A(l lVar) {
            Intent prepare = VpnService.prepare(ExternalOpenVPNService.this);
            int H = lVar.H(null, null);
            if (prepare == null && H == 0) {
                F.f(lVar, ExternalOpenVPNService.this.getBaseContext());
                return;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setClass(ExternalOpenVPNService.this.getBaseContext(), LaunchVPN.class);
            intent.putExtra("de.blinkt.openvpn.shortcutProfileUUID", lVar.B());
            intent.putExtra("de.blinkt.openvpn.showNoLogWindow", true);
            intent.addFlags(268435456);
            ExternalOpenVPNService.this.startActivity(intent);
        }

        public Intent D() {
            ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            if (VpnService.prepare(ExternalOpenVPNService.this) == null) {
                return null;
            }
            return new Intent(ExternalOpenVPNService.this.getBaseContext(), GrantPermissionsActivity.class);
        }

        public void F0(String str) {
            ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            C.g(ExternalOpenVPNService.this.getBaseContext()).n(ExternalOpenVPNService.this, C.c(ExternalOpenVPNService.this.getBaseContext(), str));
        }

        public boolean L(String str, String str2) {
            return t(str, true, str2) != null;
        }

        public boolean O0(ParcelFileDescriptor parcelFileDescriptor) {
            ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            try {
                boolean protect = ExternalOpenVPNService.a(ExternalOpenVPNService.this).protect(parcelFileDescriptor.getFd());
                parcelFileDescriptor.close();
                return protect;
            } catch (IOException e) {
                throw new RemoteException(e.getMessage());
            }
        }

        public void R(de.blinkt.openvpn.api.b bVar) {
            ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            if (bVar != null) {
                bVar.U(ExternalOpenVPNService.d(ExternalOpenVPNService.this).d, ExternalOpenVPNService.d(ExternalOpenVPNService.this).a, ExternalOpenVPNService.d(ExternalOpenVPNService.this).b, ExternalOpenVPNService.d(ExternalOpenVPNService.this).c.name());
                ExternalOpenVPNService.this.a.register(bVar);
            }
        }

        public Intent Y0(String str) {
            if (new h8.b(ExternalOpenVPNService.this).f(str)) {
                return null;
            }
            Intent intent = new Intent();
            intent.setClass(ExternalOpenVPNService.this, ConfirmDialog.class);
            return intent;
        }

        public void disconnect() {
            ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            if (ExternalOpenVPNService.a(ExternalOpenVPNService.this) != null) {
                ExternalOpenVPNService.a(ExternalOpenVPNService.this).a(false);
            }
        }

        public void k(String str) {
            q0(str, null);
        }

        public void pause() {
            ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            if (ExternalOpenVPNService.a(ExternalOpenVPNService.this) != null) {
                ExternalOpenVPNService.a(ExternalOpenVPNService.this).T(true);
            }
        }

        public void q0(String str, Bundle bundle) {
            String b = ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            de.blinkt.openvpn.core.c cVar = new de.blinkt.openvpn.core.c();
            try {
                cVar.n(new StringReader(str));
                l f = cVar.f();
                f.d = "Remote APP VPN";
                if (f.c(ExternalOpenVPNService.this.getApplicationContext()) != j.j4) {
                    ExternalOpenVPNService externalOpenVPNService = ExternalOpenVPNService.this;
                    throw new RemoteException(externalOpenVPNService.getString(f.c(externalOpenVPNService.getApplicationContext())));
                }
                f.i0 = b;
                if (bundle != null) {
                    f.g0 = bundle.getBoolean("de.blinkt.openvpn.api.ALLOW_VPN_BYPASS", false);
                }
                C.t(ExternalOpenVPNService.this, f);
                A(f);
            } catch (c.a e) {
                e = e;
                throw new RemoteException(e.getMessage());
            } catch (IOException e2) {
                e = e2;
                throw new RemoteException(e.getMessage());
            }
        }

        public List r0() {
            ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            C g = C.g(ExternalOpenVPNService.this.getBaseContext());
            LinkedList linkedList = new LinkedList();
            for (l lVar : g.k()) {
                if (!lVar.a) {
                    linkedList.add(new h8.a(lVar.B(), lVar.d, lVar.R, lVar.i0));
                }
            }
            return linkedList;
        }

        public void resume() {
            ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            if (ExternalOpenVPNService.a(ExternalOpenVPNService.this) != null) {
                ExternalOpenVPNService.a(ExternalOpenVPNService.this).T(false);
            }
        }

        public h8.a t(String str, boolean z, String str2) {
            String b = ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            de.blinkt.openvpn.core.c cVar = new de.blinkt.openvpn.core.c();
            try {
                cVar.n(new StringReader(str2));
                l f = cVar.f();
                f.d = str;
                f.i0 = b;
                f.R = z;
                C g = C.g(ExternalOpenVPNService.this.getBaseContext());
                g.a(f);
                g.o(ExternalOpenVPNService.this, f);
                g.q(ExternalOpenVPNService.this);
                return new h8.a(f.B(), f.d, f.R, f.i0);
            } catch (c.a e) {
                G.r(e);
                return null;
            } catch (IOException e2) {
                G.r(e2);
                return null;
            }
        }

        public void u(String str) {
            ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            l c = C.c(ExternalOpenVPNService.this.getBaseContext(), str);
            if (c.c(ExternalOpenVPNService.this.getApplicationContext()) == j.j4) {
                A(c);
            } else {
                ExternalOpenVPNService externalOpenVPNService = ExternalOpenVPNService.this;
                throw new RemoteException(externalOpenVPNService.getString(c.c(externalOpenVPNService.getApplicationContext())));
            }
        }

        public void w(de.blinkt.openvpn.api.b bVar) {
            ExternalOpenVPNService.c(ExternalOpenVPNService.this).b(ExternalOpenVPNService.this.getPackageManager());
            if (bVar != null) {
                ExternalOpenVPNService.this.a.unregister(bVar);
            }
        }
    }

    public static class d extends Handler {
        public WeakReference a = null;

        public static /* synthetic */ void a(d dVar, ExternalOpenVPNService externalOpenVPNService) {
            dVar.c(externalOpenVPNService);
        }

        public final void b(de.blinkt.openvpn.api.b bVar, e eVar) {
            bVar.U(eVar.d, eVar.a, eVar.b, eVar.c.name());
        }

        public final void c(ExternalOpenVPNService externalOpenVPNService) {
            this.a = new WeakReference(externalOpenVPNService);
        }

        public void handleMessage(Message message) {
            WeakReference weakReference;
            if (message.what != 0 || (weakReference = this.a) == null || weakReference.get() == null) {
                return;
            }
            RemoteCallbackList remoteCallbackList = ((ExternalOpenVPNService) this.a.get()).a;
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    b((de.blinkt.openvpn.api.b) remoteCallbackList.getBroadcastItem(i), (e) message.obj);
                } catch (RemoteException unused) {
                }
            }
            remoteCallbackList.finishBroadcast();
        }
    }

    public class e {
        public String a;
        public String b;
        public de.blinkt.openvpn.core.e c;
        public String d;

        public e(String str, String str2, de.blinkt.openvpn.core.e eVar) {
            this.a = str;
            this.b = str2;
            this.c = eVar;
        }
    }

    public static /* synthetic */ h a(ExternalOpenVPNService externalOpenVPNService) {
        return externalOpenVPNService.c;
    }

    public static /* synthetic */ h b(ExternalOpenVPNService externalOpenVPNService, h hVar) {
        externalOpenVPNService.c = hVar;
        return hVar;
    }

    public static /* synthetic */ h8.b c(ExternalOpenVPNService externalOpenVPNService) {
        return externalOpenVPNService.d;
    }

    public static /* synthetic */ e d(ExternalOpenVPNService externalOpenVPNService) {
        return externalOpenVPNService.h;
    }

    public void Z(String str) {
    }

    public void c0(String str, String str2, int i2, de.blinkt.openvpn.core.e eVar, Intent intent) {
        this.h = new e(str, str2, eVar);
        if (C.i() != null) {
            this.h.d = C.i().B();
        }
        i.obtainMessage(0, this.h).sendToTarget();
    }

    public IBinder onBind(Intent intent) {
        return this.g;
    }

    public void onCreate() {
        super.onCreate();
        G.c(this);
        this.d = new h8.b(this);
        Intent intent = new Intent(getBaseContext(), OpenVPNService.class);
        intent.setAction("de.blinkt.openvpn.START_SERVICE");
        bindService(intent, this.e, 1);
        d.a(i, this);
        registerReceiver(this.f, new IntentFilter("android.intent.action.PACKAGE_REMOVED"));
    }

    public void onDestroy() {
        super.onDestroy();
        this.a.kill();
        unbindService(this.e);
        G.E(this);
        unregisterReceiver(this.f);
    }
}

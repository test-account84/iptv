package de.blinkt.openvpn.core;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Pair;
import de.blinkt.openvpn.core.G;
import de.blinkt.openvpn.core.i;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class OpenVPNStatusService extends Service implements G.d, G.b, G.e {
    public static c d;
    public static final RemoteCallbackList a = new RemoteCallbackList();
    public static final i.a c = new a();
    public static final b e = new b(null);

    public class a extends i.a {

        public class a extends Thread {
            public final /* synthetic */ ParcelFileDescriptor[] a;
            public final /* synthetic */ k[] c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, ParcelFileDescriptor[] parcelFileDescriptorArr, k[] kVarArr) {
                super(str);
                this.a = parcelFileDescriptorArr;
                this.c = kVarArr;
            }

            public void run() {
                DataOutputStream dataOutputStream = new DataOutputStream(new ParcelFileDescriptor.AutoCloseOutputStream(this.a[1]));
                try {
                    Object obj = G.k;
                    synchronized (obj) {
                        try {
                            if (!G.j) {
                                obj.wait();
                            }
                        } finally {
                        }
                    }
                } catch (InterruptedException e) {
                    G.r(e);
                }
                try {
                    for (k kVar : this.c) {
                        byte[] c = kVar.c();
                        dataOutputStream.writeShort(c.length);
                        dataOutputStream.write(c);
                    }
                    dataOutputStream.writeShort(32767);
                    dataOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public String B0() {
            return G.g();
        }

        public void E0(j jVar) {
            OpenVPNStatusService.a.unregister(jVar);
        }

        public ParcelFileDescriptor K(j jVar) {
            k[] j = G.j();
            c cVar = OpenVPNStatusService.d;
            if (cVar != null) {
                OpenVPNStatusService.b(jVar, cVar);
            }
            OpenVPNStatusService.a.register(jVar);
            try {
                ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                new a("pushLogs", createPipe, j).start();
                return createPipe[0];
            } catch (IOException e) {
                e.printStackTrace();
                throw new RemoteException(e.getMessage());
            }
        }

        public E O() {
            return G.l;
        }

        public void g0(String str, int i, String str2) {
            A.d(str, i, str2);
        }
    }

    public static class b extends Handler {
        public WeakReference a;

        public b() {
            this.a = null;
        }

        public static /* synthetic */ void a(b bVar, OpenVPNStatusService openVPNStatusService) {
            bVar.b(openVPNStatusService);
        }

        public final void b(OpenVPNStatusService openVPNStatusService) {
            this.a = new WeakReference(openVPNStatusService);
        }

        public void handleMessage(Message message) {
            j jVar;
            WeakReference weakReference = this.a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            RemoteCallbackList remoteCallbackList = OpenVPNStatusService.a;
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    jVar = (j) remoteCallbackList.getBroadcastItem(i);
                } catch (RemoteException unused) {
                }
                switch (message.what) {
                    case 100:
                        jVar.Q((k) message.obj);
                        continue;
                    case 101:
                        OpenVPNStatusService.b(jVar, (c) message.obj);
                        continue;
                    case 102:
                        Pair pair = (Pair) message.obj;
                        jVar.k0(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
                        continue;
                    case 103:
                        jVar.y0((String) message.obj);
                        continue;
                    default:
                        continue;
                }
            }
            remoteCallbackList.finishBroadcast();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static class c {
        public String a;
        public String b;
        public e c;
        public Intent d;
        public int e;

        public c(String str, String str2, int i, e eVar, Intent intent) {
            this.a = str;
            this.e = i;
            this.b = str2;
            this.c = eVar;
            this.d = intent;
        }
    }

    public static /* synthetic */ void b(j jVar, c cVar) {
        c(jVar, cVar);
    }

    public static void c(j jVar, c cVar) {
        jVar.t0(cVar.a, cVar.b, cVar.e, cVar.c, cVar.d);
    }

    public void E(long j, long j2, long j3, long j4) {
        e.obtainMessage(102, Pair.create(Long.valueOf(j), Long.valueOf(j2))).sendToTarget();
    }

    public void Z(String str) {
        e.obtainMessage(103, str).sendToTarget();
    }

    public void a(k kVar) {
        e.obtainMessage(100, kVar).sendToTarget();
    }

    public void c0(String str, String str2, int i, e eVar, Intent intent) {
        c cVar = new c(str, str2, i, eVar, intent);
        d = cVar;
        e.obtainMessage(101, cVar).sendToTarget();
    }

    public IBinder onBind(Intent intent) {
        return c;
    }

    public void onCreate() {
        super.onCreate();
        G.b(this);
        G.a(this);
        G.c(this);
        b.a(e, this);
    }

    public void onDestroy() {
        super.onDestroy();
        G.D(this);
        G.C(this);
        G.E(this);
        a.kill();
    }
}

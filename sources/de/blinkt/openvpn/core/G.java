package de.blinkt.openvpn.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.security.KeyChainException;
import h8.c;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class g {

    public class a implements ServiceConnection {
        public volatile boolean a = false;
        public final /* synthetic */ BlockingQueue c;

        public a(BlockingQueue blockingQueue) {
            this.c = blockingQueue;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (this.a) {
                return;
            }
            this.a = true;
            try {
                this.c.put(c.a.A(iBinder));
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static class b implements Closeable {
        public final Context a;
        public final ServiceConnection c;
        public final h8.c d;

        public b(Context context, ServiceConnection serviceConnection, h8.c cVar) {
            this.a = context;
            this.c = serviceConnection;
            this.d = cVar;
        }

        public h8.c a() {
            return this.d;
        }

        public void close() {
            this.a.unbindService(this.c);
        }
    }

    public static b a(Context context, String str) {
        b(context);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1);
        a aVar = new a(linkedBlockingQueue);
        Intent intent = new Intent("de.blinkt.openvpn.api.ExternalCertificateProvider");
        intent.setPackage(str);
        if (context.bindService(intent, aVar, 1)) {
            return new b(context, aVar, (h8.c) linkedBlockingQueue.take());
        }
        throw new KeyChainException("could not bind to external authticator app: " + str);
    }

    public static void b(Context context) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper == context.getMainLooper()) {
            throw new IllegalStateException("calling this from your main thread can lead to deadlock");
        }
    }

    public static X509Certificate[] c(Context context, String str, String str2) {
        try {
            b a2 = a(context.getApplicationContext(), str);
            try {
                byte[] certificateChain = a2.a().getCertificateChain(str2);
                if (certificateChain == null) {
                    a2.close();
                    return null;
                }
                Collection e = e(certificateChain);
                X509Certificate[] x509CertificateArr = (X509Certificate[]) e.toArray(new X509Certificate[e.size()]);
                a2.close();
                return x509CertificateArr;
            } catch (Throwable th) {
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (InterruptedException | RemoteException | RuntimeException e2) {
            throw new KeyChainException(e2);
        }
    }

    public static byte[] d(Context context, String str, String str2, byte[] bArr, Bundle bundle) {
        try {
            b a2 = a(context.getApplicationContext(), str);
            try {
                h8.c a3 = a2.a();
                byte[] I0 = a3.I0(str2, bArr, bundle);
                if (I0 == null) {
                    I0 = a3.x(str2, bArr);
                }
                a2.close();
                return I0;
            } finally {
            }
        } catch (RemoteException e) {
            throw new KeyChainException(e);
        }
    }

    public static Collection e(byte[] bArr) {
        try {
            Vector vector = new Vector();
            for (String str : new String(bArr, "iso8859-1").split("-----BEGIN CERTIFICATE-----")) {
                vector.addAll(CertificateFactory.getInstance("X.509").generateCertificates(new ByteArrayInputStream(("-----BEGIN CERTIFICATE-----" + str).getBytes("iso8859-1"))));
            }
            return vector;
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        } catch (CertificateException e2) {
            throw new AssertionError(e2);
        }
    }
}

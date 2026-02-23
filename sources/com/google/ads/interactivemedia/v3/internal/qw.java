package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class qw {
    private static final ArrayDeque a = new ArrayDeque();
    private static final Object b = new Object();
    private final MediaCodec c;
    private final HandlerThread d;
    private Handler e;
    private final AtomicReference f;
    private boolean g;
    private final agp h;

    public qw(MediaCodec mediaCodec, HandlerThread handlerThread) {
        agp agpVar = new agp();
        this.c = mediaCodec;
        this.d = handlerThread;
        this.h = agpVar;
        this.f = new AtomicReference();
    }

    public static /* bridge */ /* synthetic */ void a(qw qwVar, Message message) {
        qv qvVar;
        int i = message.what;
        try {
            if (i == 0) {
                qvVar = (qv) message.obj;
                qwVar.c.queueInputBuffer(qvVar.a, 0, qvVar.c, qvVar.e, qvVar.f);
            } else if (i != 1) {
                qvVar = null;
                if (i != 2) {
                    pi.b(qwVar.f, new IllegalStateException(String.valueOf(message.what)));
                } else {
                    qwVar.h.f();
                }
            } else {
                qvVar = (qv) message.obj;
                int i2 = qvVar.a;
                MediaCodec.CryptoInfo cryptoInfo = qvVar.d;
                long j = qvVar.e;
                int i3 = qvVar.f;
                synchronized (b) {
                    qwVar.c.queueSecureInputBuffer(i2, 0, cryptoInfo, j, i3);
                }
            }
        } catch (RuntimeException e) {
            pi.b(qwVar.f, e);
        }
        if (qvVar != null) {
            ArrayDeque arrayDeque = a;
            synchronized (arrayDeque) {
                arrayDeque.add(qvVar);
            }
        }
    }

    private static qv g() {
        ArrayDeque arrayDeque = a;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new qv();
                }
                return (qv) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void h() {
        RuntimeException runtimeException = (RuntimeException) this.f.getAndSet((Object) null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    private static byte[] i(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 != null) {
            int length = bArr2.length;
            int length2 = bArr.length;
            if (length >= length2) {
                System.arraycopy(bArr, 0, bArr2, 0, length2);
                return bArr2;
            }
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    private static int[] j(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 != null) {
            int length = iArr2.length;
            int length2 = iArr.length;
            if (length >= length2) {
                System.arraycopy(iArr, 0, iArr2, 0, length2);
                return iArr2;
            }
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public final void b() {
        if (this.g) {
            try {
                Handler handler = this.e;
                af.s(handler);
                handler.removeCallbacksAndMessages((Object) null);
                this.h.g();
                Handler handler2 = this.e;
                af.s(handler2);
                handler2.obtainMessage(2).sendToTarget();
                this.h.c();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public final void c() {
        if (this.g) {
            b();
            this.d.quit();
        }
        this.g = false;
    }

    public final void d() {
        if (this.g) {
            return;
        }
        this.d.start();
        this.e = new qu(this, this.d.getLooper());
        this.g = true;
    }

    public final void e(int i, int i2, long j, int i3) {
        h();
        qv g = g();
        g.a(i, i2, j, i3);
        Handler handler = this.e;
        int i4 = cq.a;
        handler.obtainMessage(0, g).sendToTarget();
    }

    public final void f(int i, ec ecVar, long j) {
        h();
        qv g = g();
        g.a(i, 0, j, 0);
        MediaCodec.CryptoInfo cryptoInfo = g.d;
        cryptoInfo.numSubSamples = ecVar.f;
        cryptoInfo.numBytesOfClearData = j(ecVar.d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = j(ecVar.e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) af.s(i(ecVar.b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) af.s(i(ecVar.a, cryptoInfo.iv));
        cryptoInfo.mode = ecVar.c;
        if (cq.a >= 24) {
            B1.a();
            Q.a(cryptoInfo, S.a(ecVar.g, ecVar.h));
        }
        this.e.obtainMessage(1, g).sendToTarget();
    }
}

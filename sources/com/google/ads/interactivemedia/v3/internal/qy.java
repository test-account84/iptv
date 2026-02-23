package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class qy extends MediaCodec.Callback {
    private final HandlerThread b;
    private Handler c;
    private MediaFormat h;
    private MediaFormat i;
    private MediaCodec.CodecException j;
    private long k;
    private boolean l;
    private IllegalStateException m;
    private final Object a = new Object();
    private final rc d = new rc();
    private final rc e = new rc();
    private final ArrayDeque f = new ArrayDeque();
    private final ArrayDeque g = new ArrayDeque();

    public qy(HandlerThread handlerThread) {
        this.b = handlerThread;
    }

    public static /* synthetic */ void d(qy qyVar) {
        synchronized (qyVar.a) {
            try {
                if (qyVar.l) {
                    return;
                }
                long j = qyVar.k - 1;
                qyVar.k = j;
                if (j > 0) {
                    return;
                }
                if (j >= 0) {
                    qyVar.i();
                    return;
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                synchronized (qyVar.a) {
                    qyVar.m = illegalStateException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void h(MediaFormat mediaFormat) {
        this.e.b(-2);
        this.g.add(mediaFormat);
    }

    private final void i() {
        if (!this.g.isEmpty()) {
            this.i = (MediaFormat) this.g.getLast();
        }
        this.d.c();
        this.e.c();
        this.f.clear();
        this.g.clear();
        this.j = null;
    }

    private final void j() {
        IllegalStateException illegalStateException = this.m;
        if (illegalStateException != null) {
            this.m = null;
            throw illegalStateException;
        }
        MediaCodec.CodecException codecException = this.j;
        if (codecException == null) {
            return;
        }
        this.j = null;
        throw codecException;
    }

    private final boolean k() {
        return this.k > 0 || this.l;
    }

    public final int a() {
        synchronized (this.a) {
            try {
                int i = -1;
                if (k()) {
                    return -1;
                }
                j();
                if (!this.d.d()) {
                    i = this.d.a();
                }
                return i;
            } finally {
            }
        }
    }

    public final int b(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.a) {
            try {
                if (k()) {
                    return -1;
                }
                j();
                if (this.e.d()) {
                    return -1;
                }
                int a = this.e.a();
                if (a >= 0) {
                    af.t(this.h);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.f.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (a == -2) {
                    this.h = (MediaFormat) this.g.remove();
                    a = -2;
                }
                return a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final MediaFormat c() {
        MediaFormat mediaFormat;
        synchronized (this.a) {
            try {
                mediaFormat = this.h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    public final void e() {
        synchronized (this.a) {
            this.k++;
            Handler handler = this.c;
            int i = cq.a;
            handler.post(new qx(this));
        }
    }

    public final void f(MediaCodec mediaCodec) {
        af.w(this.c == null);
        this.b.start();
        Handler handler = new Handler(this.b.getLooper());
        C1.a(mediaCodec, this, handler);
        this.c = handler;
    }

    public final void g() {
        synchronized (this.a) {
            this.l = true;
            this.b.quit();
            i();
        }
    }

    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.a) {
            this.j = codecException;
        }
    }

    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.a) {
            this.d.b(i);
        }
    }

    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.a) {
            try {
                MediaFormat mediaFormat = this.i;
                if (mediaFormat != null) {
                    h(mediaFormat);
                    this.i = null;
                }
                this.e.b(i);
                this.f.add(bufferInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.a) {
            h(mediaFormat);
            this.i = null;
        }
    }
}

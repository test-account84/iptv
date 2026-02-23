package com.google.android.exoplayer2.source.rtsp;

import K3.q;
import K3.r;
import android.os.Handler;
import android.os.HandlerThread;
import b4.G;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g implements Closeable {
    public static final Charset h = r5.d.c;
    public final d a;
    public final G c = new G("ExoPlayer:RtspMessageChannel:ReceiverLoader");
    public final Map d = DesugarCollections.synchronizedMap(new HashMap());
    public g e;
    public Socket f;
    public volatile boolean g;

    public interface b {
        void j(byte[] bArr);
    }

    public final class c implements G.b {
        public c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void t(f fVar, long j, long j2, boolean z) {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void W(f fVar, long j, long j2) {
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public G.c j(f fVar, long j, long j2, IOException iOException, int i) {
            if (!g.a(g.this)) {
                g.c(g.this).a(iOException);
            }
            return G.f;
        }

        public /* synthetic */ c(g gVar, a aVar) {
            this();
        }
    }

    public interface d {
        void a(Exception exc);

        void b(List list, Exception exc);

        void c(List list);
    }

    public static final class e {
        public final List a = new ArrayList();
        public int b = 1;
        public long c;

        public static byte[] d(byte b, DataInputStream dataInputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = {b, dataInputStream.readByte()};
            byteArrayOutputStream.write(bArr);
            while (true) {
                if (bArr[0] == 13 && bArr[1] == 10) {
                    return byteArrayOutputStream.toByteArray();
                }
                bArr[0] = bArr[1];
                byte readByte = dataInputStream.readByte();
                bArr[1] = readByte;
                byteArrayOutputStream.write(readByte);
            }
        }

        public final y a(byte[] bArr) {
            d4.a.g(this.b == 3);
            if (bArr.length <= 0 || bArr[bArr.length - 1] != 10) {
                throw new IllegalArgumentException("Message body is empty or does not end with a LF.");
            }
            this.a.add((bArr.length <= 1 || bArr[bArr.length + (-2)] != 13) ? new String(bArr, 0, bArr.length - 1, g.h) : new String(bArr, 0, bArr.length - 2, g.h));
            y r = y.r(this.a);
            e();
            return r;
        }

        public final y b(byte[] bArr) {
            d4.a.a(bArr.length >= 2 && bArr[bArr.length - 2] == 13 && bArr[bArr.length - 1] == 10);
            String str = new String(bArr, 0, bArr.length - 2, g.h);
            this.a.add(str);
            int i = this.b;
            if (i == 1) {
                if (!h.f(str)) {
                    return null;
                }
                this.b = 2;
                return null;
            }
            if (i != 2) {
                throw new IllegalStateException();
            }
            long g = h.g(str);
            if (g != -1) {
                this.c = g;
            }
            if (!str.isEmpty()) {
                return null;
            }
            if (this.c > 0) {
                this.b = 3;
                return null;
            }
            y r = y.r(this.a);
            e();
            return r;
        }

        public y c(byte b, DataInputStream dataInputStream) {
            y b2 = b(d(b, dataInputStream));
            while (b2 == null) {
                if (this.b == 3) {
                    long j = this.c;
                    if (j <= 0) {
                        throw new IllegalStateException("Expects a greater than zero Content-Length.");
                    }
                    int d = w5.f.d(j);
                    d4.a.g(d != -1);
                    byte[] bArr = new byte[d];
                    dataInputStream.readFully(bArr, 0, d);
                    b2 = a(bArr);
                } else {
                    b2 = b(d(dataInputStream.readByte(), dataInputStream));
                }
            }
            return b2;
        }

        public final void e() {
            this.a.clear();
            this.b = 1;
            this.c = 0L;
        }
    }

    public final class f implements G.e {
        public final DataInputStream a;
        public final e c = new e();
        public volatile boolean d;

        public f(InputStream inputStream) {
            this.a = new DataInputStream(inputStream);
        }

        public void a() {
            while (!this.d) {
                byte readByte = this.a.readByte();
                if (readByte == 36) {
                    b();
                } else {
                    d(readByte);
                }
            }
        }

        public final void b() {
            int readUnsignedByte = this.a.readUnsignedByte();
            int readUnsignedShort = this.a.readUnsignedShort();
            byte[] bArr = new byte[readUnsignedShort];
            this.a.readFully(bArr, 0, readUnsignedShort);
            b bVar = (b) g.d(g.this).get(Integer.valueOf(readUnsignedByte));
            if (bVar == null || g.a(g.this)) {
                return;
            }
            bVar.j(bArr);
        }

        public void c() {
            this.d = true;
        }

        public final void d(byte b) {
            if (g.a(g.this)) {
                return;
            }
            g.c(g.this).c(this.c.c(b, this.a));
        }
    }

    public final class g implements Closeable {
        public final OutputStream a;
        public final HandlerThread c;
        public final Handler d;

        public g(OutputStream outputStream) {
            this.a = outputStream;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:RtspMessageChannel:Sender");
            this.c = handlerThread;
            handlerThread.start();
            this.d = new Handler(handlerThread.getLooper());
        }

        public static /* synthetic */ void a(g gVar, byte[] bArr, List list) {
            gVar.c(bArr, list);
        }

        public final /* synthetic */ void c(byte[] bArr, List list) {
            try {
                this.a.write(bArr);
            } catch (Exception e) {
                if (g.a(g.this)) {
                    return;
                }
                g.c(g.this).b(list, e);
            }
        }

        public void close() {
            Handler handler = this.d;
            HandlerThread handlerThread = this.c;
            Objects.requireNonNull(handlerThread);
            handler.post(new r(handlerThread));
            try {
                this.c.join();
            } catch (InterruptedException unused) {
                this.c.interrupt();
            }
        }

        public void d(List list) {
            this.d.post(new q(this, h.b(list), list));
        }
    }

    public g(d dVar) {
        this.a = dVar;
    }

    public static /* synthetic */ boolean a(g gVar) {
        return gVar.g;
    }

    public static /* synthetic */ d c(g gVar) {
        return gVar.a;
    }

    public static /* synthetic */ Map d(g gVar) {
        return gVar.d;
    }

    public void close() {
        if (this.g) {
            return;
        }
        try {
            g gVar = this.e;
            if (gVar != null) {
                gVar.close();
            }
            this.c.l();
            Socket socket = this.f;
            if (socket != null) {
                socket.close();
            }
            this.g = true;
        } catch (Throwable th) {
            this.g = true;
            throw th;
        }
    }

    public void e(Socket socket) {
        this.f = socket;
        this.e = new g(socket.getOutputStream());
        this.c.n(new f(socket.getInputStream()), new c(this, null), 0);
    }

    public void g(int i, b bVar) {
        this.d.put(Integer.valueOf(i), bVar);
    }

    public void h(List list) {
        d4.a.i(this.e);
        this.e.d(list);
    }
}

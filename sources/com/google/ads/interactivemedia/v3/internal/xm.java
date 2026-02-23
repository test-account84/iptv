package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class xm {
    private static final Object a = new Object();
    private static final Object b = new Object();
    private static boolean c = false;
    private static long d = 0;
    private static final String e = "time.android.com";

    public static /* bridge */ /* synthetic */ long a() {
        String str;
        synchronized (b) {
            str = e;
        }
        InetAddress byName = InetAddress.getByName(str);
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = 27;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (currentTimeMillis == 0) {
                Arrays.fill(bArr, 40, 48, (byte) 0);
            } else {
                long j = currentTimeMillis / 1000;
                Long.signum(j);
                long j2 = currentTimeMillis - (j * 1000);
                long j3 = j + 2208988800L;
                bArr[40] = (byte) (j3 >> 24);
                bArr[41] = (byte) (j3 >> 16);
                bArr[42] = (byte) (j3 >> 8);
                bArr[43] = (byte) j3;
                long j4 = (j2 * 4294967296L) / 1000;
                bArr[44] = (byte) (j4 >> 24);
                bArr[45] = (byte) (j4 >> 16);
                bArr[46] = (byte) (j4 >> 8);
                bArr[47] = (byte) (Math.random() * 255.0d);
            }
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j5 = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
            byte b2 = bArr[0];
            int i = (b2 >> 6) & 3;
            int i2 = b2 & 7;
            int i3 = bArr[1] & 255;
            long k = k(bArr, 24);
            long k2 = k(bArr, 32);
            long k3 = k(bArr, 40);
            if (i == 3) {
                throw new IOException("SNTP: Unsynchronized server");
            }
            if (i2 != 4 && i2 != 5) {
                throw new IOException("SNTP: Untrusted mode: " + i2);
            }
            if (i3 == 0 || i3 > 15) {
                throw new IOException("SNTP: Untrusted stratum: " + i3);
            }
            if (k3 == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
            long j6 = ((k2 - k) + (k3 - j5)) / 2;
            datagramSocket.close();
            return (j5 + j6) - elapsedRealtime2;
        } finally {
        }
    }

    public static long b() {
        long j;
        synchronized (b) {
            try {
                j = c ? d : -9223372036854775807L;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    public static /* bridge */ /* synthetic */ Object c() {
        return a;
    }

    public static /* bridge */ /* synthetic */ Object d() {
        return b;
    }

    public static /* bridge */ /* synthetic */ void e(long j) {
        d = j;
    }

    public static void f(xc xcVar, xj xjVar) {
        if (h()) {
            xjVar.b();
            return;
        }
        if (xcVar == null) {
            xcVar = new xc("SntpClient");
        }
        xcVar.b(new xl(null), new xk(xjVar), 1);
    }

    public static /* bridge */ /* synthetic */ boolean g() {
        return c;
    }

    public static boolean h() {
        boolean z;
        synchronized (b) {
            z = c;
        }
        return z;
    }

    public static /* bridge */ /* synthetic */ void i() {
        c = true;
    }

    private static long j(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
    }

    private static long k(byte[] bArr, int i) {
        long j = j(bArr, i);
        long j2 = j(bArr, i + 4);
        if (j == 0) {
            if (j2 == 0) {
                return 0L;
            }
            j = 0;
        }
        return ((j - 2208988800L) * 1000) + ((j2 * 1000) / 4294967296L);
    }
}

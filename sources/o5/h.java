package O5;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h {
    public static final AtomicLong a = new AtomicLong(0);
    public static String b;

    public h(y yVar) {
        byte[] bArr = new byte[10];
        e(bArr);
        d(bArr);
        c(bArr);
        String C = i.C(yVar.a().c());
        String w = i.w(bArr);
        Locale locale = Locale.US;
        b = String.format(locale, "%s%s%s%s", new Object[]{w.substring(0, 12), w.substring(12, 16), w.subSequence(16, 20), C.substring(0, 12)}).toUpperCase(locale);
    }

    public static byte[] a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public static byte[] b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public final void c(byte[] bArr) {
        byte[] b2 = b(Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b2[0];
        bArr[9] = b2[1];
    }

    public final void d(byte[] bArr) {
        byte[] b2 = b(a.incrementAndGet());
        bArr[6] = b2[0];
        bArr[7] = b2[1];
    }

    public final void e(byte[] bArr) {
        long time = new Date().getTime();
        byte[] a2 = a(time / 1000);
        bArr[0] = a2[0];
        bArr[1] = a2[1];
        bArr[2] = a2[2];
        bArr[3] = a2[3];
        byte[] b2 = b(time % 1000);
        bArr[4] = b2[0];
        bArr[5] = b2[1];
    }

    public String toString() {
        return b;
    }
}

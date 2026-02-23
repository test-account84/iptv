package P8;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class i implements Closeable {
    public final int a = 1179403647;
    public final FileChannel c;

    public i(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.c = new FileInputStream(file).getChannel();
    }

    public final long a(d dVar, long j, long j2) {
        for (long j3 = 0; j3 < j; j3++) {
            e b = dVar.b(j3);
            if (b.a == 1) {
                long j4 = b.c;
                if (j4 <= j2 && j2 <= b.d + j4) {
                    return (j2 - j4) + b.b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public d c() {
        this.c.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (k(allocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short g = g(allocate, 4L);
        boolean z = g(allocate, 5L) == 2;
        if (g == 1) {
            return new g(z, this);
        }
        if (g == 2) {
            return new h(z, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    public void close() {
        this.c.close();
    }

    public List d() {
        long j;
        this.c.position(0L);
        ArrayList arrayList = new ArrayList();
        d c = c();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(c.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = c.f;
        int i = 0;
        if (j2 == 65535) {
            j2 = c.c(0).a;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            e b = c.b(j3);
            if (b.a == 2) {
                j = b.b;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j4 = 0;
        while (true) {
            c a = c.a(j, i);
            long j5 = j;
            long j6 = a.a;
            if (j6 == 1) {
                arrayList2.add(Long.valueOf(a.b));
            } else if (j6 == 5) {
                j4 = a.b;
            }
            i++;
            if (a.a == 0) {
                break;
            }
            j = j5;
        }
        if (j4 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long a2 = a(c, j2, j4);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(j(allocate, ((Long) it.next()).longValue() + a2));
        }
        return arrayList;
    }

    public void e(ByteBuffer byteBuffer, long j, int i) {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < i) {
            int read = this.c.read(byteBuffer, j + j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 += read;
        }
        byteBuffer.position(0);
    }

    public short g(ByteBuffer byteBuffer, long j) {
        e(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public int h(ByteBuffer byteBuffer, long j) {
        e(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    public long i(ByteBuffer byteBuffer, long j) {
        e(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public String j(ByteBuffer byteBuffer, long j) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short g = g(byteBuffer, j);
            if (g == 0) {
                return sb.toString();
            }
            sb.append((char) g);
            j = j2;
        }
    }

    public long k(ByteBuffer byteBuffer, long j) {
        e(byteBuffer, j, 4);
        return byteBuffer.getInt() & 4294967295L;
    }
}

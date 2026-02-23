package i1;

import android.os.SystemClock;
import android.text.TextUtils;
import h1.b;
import h1.v;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements h1.b {
    public final Map a = new LinkedHashMap(16, 0.75f, true);
    public long b = 0;
    public final d c;
    public final int d;

    public class a implements d {
        public final /* synthetic */ File a;

        public a(File file) {
            this.a = file;
        }

        public File get() {
            return this.a;
        }
    }

    public static class b {
        public long a;
        public final String b;
        public final String c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;
        public final List h;

        public b(String str, b.a aVar) {
            this(str, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, a(aVar));
        }

        public static List a(b.a aVar) {
            List list = aVar.h;
            return list != null ? list : e.g(aVar.g);
        }

        public static b b(c cVar) {
            if (d.l(cVar) == 538247942) {
                return new b(d.n(cVar), d.n(cVar), d.m(cVar), d.m(cVar), d.m(cVar), d.m(cVar), d.k(cVar));
            }
            throw new IOException();
        }

        public b.a c(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.a = bArr;
            aVar.b = this.c;
            aVar.c = this.d;
            aVar.d = this.e;
            aVar.e = this.f;
            aVar.f = this.g;
            aVar.g = e.h(this.h);
            aVar.h = Collections.unmodifiableList(this.h);
            return aVar;
        }

        public boolean d(OutputStream outputStream) {
            try {
                d.s(outputStream, 538247942);
                d.u(outputStream, this.b);
                String str = this.c;
                if (str == null) {
                    str = "";
                }
                d.u(outputStream, str);
                d.t(outputStream, this.d);
                d.t(outputStream, this.e);
                d.t(outputStream, this.f);
                d.t(outputStream, this.g);
                d.r(this.h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                v.b("%s", e.toString());
                return false;
            }
        }

        public b(String str, String str2, long j, long j2, long j3, long j4, List list) {
            this.b = str;
            this.c = "".equals(str2) ? null : str2;
            this.d = j;
            this.e = j2;
            this.f = j3;
            this.g = j4;
            this.h = list;
        }
    }

    public static class c extends FilterInputStream {
        public final long a;
        public long c;

        public c(InputStream inputStream, long j) {
            super(inputStream);
            this.a = j;
        }

        public long a() {
            return this.a - this.c;
        }

        public int read() {
            int read = super.read();
            if (read != -1) {
                this.c++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.c += read;
            }
            return read;
        }
    }

    public interface d {
        File get();
    }

    public d(File file, int i) {
        this.c = new a(file);
        this.d = i;
    }

    public static int j(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public static List k(c cVar) {
        int l = l(cVar);
        if (l < 0) {
            throw new IOException("readHeaderList size=" + l);
        }
        List emptyList = l == 0 ? Collections.emptyList() : new ArrayList();
        for (int i = 0; i < l; i++) {
            emptyList.add(new h1.g(n(cVar).intern(), n(cVar).intern()));
        }
        return emptyList;
    }

    public static int l(InputStream inputStream) {
        return (j(inputStream) << 24) | j(inputStream) | (j(inputStream) << 8) | (j(inputStream) << 16);
    }

    public static long m(InputStream inputStream) {
        return (j(inputStream) & 255) | ((j(inputStream) & 255) << 8) | ((j(inputStream) & 255) << 16) | ((j(inputStream) & 255) << 24) | ((j(inputStream) & 255) << 32) | ((j(inputStream) & 255) << 40) | ((j(inputStream) & 255) << 48) | ((255 & j(inputStream)) << 56);
    }

    public static String n(c cVar) {
        return new String(q(cVar, m(cVar)), "UTF-8");
    }

    public static byte[] q(c cVar, long j) {
        long a2 = cVar.a();
        if (j >= 0 && j <= a2) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(cVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + a2);
    }

    public static void r(List list, OutputStream outputStream) {
        if (list == null) {
            s(outputStream, 0);
            return;
        }
        s(outputStream, list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h1.g gVar = (h1.g) it.next();
            u(outputStream, gVar.a());
            u(outputStream, gVar.b());
        }
    }

    public static void s(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    public static void t(OutputStream outputStream, long j) {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    public static void u(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        t(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    public synchronized void a(String str, boolean z) {
        try {
            b.a aVar = get(str);
            if (aVar != null) {
                aVar.f = 0L;
                if (z) {
                    aVar.e = 0L;
                }
                b(str, aVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b(String str, b.a aVar) {
        BufferedOutputStream bufferedOutputStream;
        b bVar;
        long j = this.b;
        byte[] bArr = aVar.a;
        long length = j + bArr.length;
        int i = this.d;
        if (length <= i || bArr.length <= i * 0.9f) {
            File e = e(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(d(e));
                bVar = new b(str, aVar);
            } catch (IOException unused) {
                if (!e.delete()) {
                    v.b("Could not clean up file %s", e.getAbsolutePath());
                }
                g();
            }
            if (!bVar.d(bufferedOutputStream)) {
                bufferedOutputStream.close();
                v.b("Failed to write header for %s", e.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(aVar.a);
            bufferedOutputStream.close();
            bVar.a = e.length();
            i(str, bVar);
            h();
        }
    }

    public InputStream c(File file) {
        return new FileInputStream(file);
    }

    public OutputStream d(File file) {
        return new FileOutputStream(file);
    }

    public File e(String str) {
        return new File(this.c.get(), f(str));
    }

    public final String f(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public final void g() {
        if (this.c.get().exists()) {
            return;
        }
        v.b("Re-initializing cache after external clearing.", new Object[0]);
        this.a.clear();
        this.b = 0L;
        initialize();
    }

    public synchronized b.a get(String str) {
        b bVar = (b) this.a.get(str);
        if (bVar == null) {
            return null;
        }
        File e = e(str);
        try {
            c cVar = new c(new BufferedInputStream(c(e)), e.length());
            try {
                b b2 = b.b(cVar);
                if (TextUtils.equals(str, b2.b)) {
                    return bVar.c(q(cVar, cVar.a()));
                }
                v.b("%s: key=%s, found=%s", e.getAbsolutePath(), str, b2.b);
                p(str);
                return null;
            } finally {
                cVar.close();
            }
        } catch (IOException e2) {
            v.b("%s: %s", e.getAbsolutePath(), e2.toString());
            o(str);
            return null;
        }
    }

    public final void h() {
        if (this.b < this.d) {
            return;
        }
        if (v.b) {
            v.e("Pruning old cache entries.", new Object[0]);
        }
        long j = this.b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.a.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            b bVar = (b) ((Map.Entry) it.next()).getValue();
            if (e(bVar.b).delete()) {
                this.b -= bVar.a;
            } else {
                String str = bVar.b;
                v.b("Could not delete cache entry for key=%s, filename=%s", str, f(str));
            }
            it.remove();
            i++;
            if (this.b < this.d * 0.9f) {
                break;
            }
        }
        if (v.b) {
            v.e("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    public final void i(String str, b bVar) {
        if (this.a.containsKey(str)) {
            this.b += bVar.a - ((b) this.a.get(str)).a;
        } else {
            this.b += bVar.a;
        }
        this.a.put(str, bVar);
    }

    public synchronized void initialize() {
        long length;
        c cVar;
        synchronized (this) {
            File file = this.c.get();
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    v.c("Unable to create cache dir %s", file.getAbsolutePath());
                }
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                try {
                    length = file2.length();
                    cVar = new c(new BufferedInputStream(c(file2)), length);
                } catch (IOException unused) {
                    file2.delete();
                }
                try {
                    b b2 = b.b(cVar);
                    b2.a = length;
                    i(b2.b, b2);
                    cVar.close();
                } catch (Throwable th) {
                    cVar.close();
                    throw th;
                }
            }
        }
    }

    public synchronized void o(String str) {
        boolean delete = e(str).delete();
        p(str);
        if (!delete) {
            v.b("Could not delete cache entry for key=%s, filename=%s", str, f(str));
        }
    }

    public final void p(String str) {
        b bVar = (b) this.a.remove(str);
        if (bVar != null) {
            this.b -= bVar.a;
        }
    }
}

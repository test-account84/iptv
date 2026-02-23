package T5;

import O5.j;
import O5.r;
import Q5.B;
import Q5.C;
import R5.h;
import V5.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class e {
    public static final Charset e = Charset.forName("UTF-8");
    public static final int f = 15;
    public static final h g = new h();
    public static final Comparator h = new a();
    public static final FilenameFilter i = new b();
    public final AtomicInteger a = new AtomicInteger(0);
    public final f b;
    public final i c;
    public final j d;

    public e(f fVar, i iVar, j jVar) {
        this.b = fVar;
        this.c = iVar;
        this.d = jVar;
    }

    public static String A(File file) {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), e);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static String F(File file) {
        try {
            return A(file);
        } catch (IOException unused) {
            return null;
        }
    }

    public static void G(File file, String str) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), e);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void H(File file, String str, long j) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), e);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(h(j));
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static /* synthetic */ boolean a(File file, String str) {
        return v(file, str);
    }

    public static /* synthetic */ boolean b(File file, String str) {
        return t(file, str);
    }

    public static /* synthetic */ int c(File file, File file2) {
        return x(file, file2);
    }

    public static /* synthetic */ int d(File file, File file2) {
        return u(file, file2);
    }

    public static int f(List list, int i2) {
        int size = list.size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (size <= i2) {
                return size;
            }
            f.s(file);
            size--;
        }
        return size;
    }

    public static long h(long j) {
        return j * 1000;
    }

    public static String m(int i2, boolean z) {
        return "event" + String.format(Locale.US, "%010d", new Object[]{Integer.valueOf(i2)}) + (z ? "_" : "");
    }

    public static String o(String str) {
        return str.substring(0, f);
    }

    public static boolean s(String str) {
        return str.startsWith("event") && str.endsWith("_");
    }

    public static boolean t(File file, String str) {
        return str.startsWith("event") && !str.endsWith("_");
    }

    public static /* synthetic */ int u(File file, File file2) {
        return file2.getName().compareTo(file.getName());
    }

    public static /* synthetic */ boolean v(File file, String str) {
        return str.startsWith("event");
    }

    public static int x(File file, File file2) {
        return o(file.getName()).compareTo(o(file2.getName()));
    }

    public final void B(File file, B.d dVar, String str, B.a aVar) {
        try {
            h hVar = g;
            G(this.b.g(str), hVar.G(hVar.F(A(file)).r(dVar).o(aVar)));
        } catch (IOException e2) {
            L5.f.f().l("Could not synthesize final native report file for " + file, e2);
        }
    }

    public final void C(String str, long j) {
        boolean z;
        List<File> p = this.b.p(str, i);
        if (p.isEmpty()) {
            L5.f.f().i("Session " + str + " has no events.");
            return;
        }
        Collections.sort(p);
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            z = false;
            for (File file : p) {
                try {
                    arrayList.add(g.h(A(file)));
                } catch (IOException e2) {
                    L5.f.f().l("Could not add event to report for " + file, e2);
                }
                if (z || s(file.getName())) {
                    z = true;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            D(this.b.o(str, "report"), arrayList, j, z, P5.h.g(str, this.b), F(this.b.o(str, "app-quality-session-id")));
        } else {
            L5.f.f().k("Could not parse event files for session " + str);
        }
    }

    public final void D(File file, List list, long j, boolean z, String str, String str2) {
        try {
            h hVar = g;
            B p = hVar.F(A(file)).s(j, z, str).n(str2).p(C.a(list));
            B.e l = p.l();
            if (l == null) {
                return;
            }
            L5.f.f().b("appQualitySessionId: " + str2);
            G(z ? this.b.j(l.i()) : this.b.l(l.i()), hVar.G(p));
        } catch (IOException e2) {
            L5.f.f().l("Could not synthesize final report file for " + file, e2);
        }
    }

    public final int E(String str, int i2) {
        List p = this.b.p(str, new c());
        Collections.sort(p, new d());
        return f(p, i2);
    }

    public final SortedSet e(String str) {
        this.b.b();
        SortedSet p = p();
        if (str != null) {
            p.remove(str);
        }
        if (p.size() <= 8) {
            return p;
        }
        while (p.size() > 8) {
            String str2 = (String) p.last();
            L5.f.f().b("Removing session over cap: " + str2);
            this.b.c(str2);
            p.remove(str2);
        }
        return p;
    }

    public final void g() {
        int i2 = this.c.b().a.b;
        List n = n();
        int size = n.size();
        if (size <= i2) {
            return;
        }
        Iterator it = n.subList(i2, size).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public void i() {
        j(this.b.m());
        j(this.b.k());
        j(this.b.h());
    }

    public final void j(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public void k(String str, long j) {
        for (String str2 : e(str)) {
            L5.f.f().i("Finalizing report for session " + str2);
            C(str2, j);
            this.b.c(str2);
        }
        g();
    }

    public void l(String str, B.d dVar, B.a aVar) {
        File o = this.b.o(str, "report");
        L5.f.f().b("Writing native session report for " + str + " to file: " + o);
        B(o, dVar, str, aVar);
    }

    public final List n() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.b.k());
        arrayList.addAll(this.b.h());
        Comparator comparator = h;
        Collections.sort(arrayList, comparator);
        List m = this.b.m();
        Collections.sort(m, comparator);
        arrayList.addAll(m);
        return arrayList;
    }

    public SortedSet p() {
        return new TreeSet(this.b.d()).descendingSet();
    }

    public long q(String str) {
        return this.b.o(str, "start-time").lastModified();
    }

    public boolean r() {
        return (this.b.m().isEmpty() && this.b.k().isEmpty() && this.b.h().isEmpty()) ? false : true;
    }

    public List w() {
        List<File> n = n();
        ArrayList arrayList = new ArrayList();
        for (File file : n) {
            try {
                arrayList.add(r.a(g.F(A(file)), file.getName(), file));
            } catch (IOException e2) {
                L5.f.f().l("Could not load report file " + file + "; deleting", e2);
                file.delete();
            }
        }
        return arrayList;
    }

    public void y(B.e.d dVar, String str, boolean z) {
        int i2 = this.c.b().a.a;
        try {
            G(this.b.o(str, m(this.a.getAndIncrement(), z)), g.i(dVar));
            String d = this.d.d();
            if (d == null) {
                L5.f.f().k("Missing AQS session id for Crashlytics session " + str);
            } else {
                G(this.b.o(str, "app-quality-session-id"), d);
            }
        } catch (IOException e2) {
            L5.f.f().l("Could not persist event for session " + str, e2);
        }
        E(str, i2);
    }

    public void z(B b) {
        B.e l = b.l();
        if (l == null) {
            L5.f.f().b("Could not get session for report");
            return;
        }
        String i2 = l.i();
        try {
            G(this.b.o(i2, "report"), g.G(b));
            H(this.b.o(i2, "start-time"), "", l.l());
        } catch (IOException e2) {
            L5.f.f().c("Could not persist report for session " + i2, e2);
        }
    }
}

package P5;

import O5.i;
import P5.e;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class f implements P5.a {
    public static final Charset d = Charset.forName("UTF-8");
    public final File a;
    public final int b;
    public e c;

    public class a implements e.d {
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ int[] b;

        public a(byte[] bArr, int[] iArr) {
            this.a = bArr;
            this.b = iArr;
        }

        public void a(InputStream inputStream, int i) {
            try {
                inputStream.read(this.a, this.b[0], i);
                int[] iArr = this.b;
                iArr[0] = iArr[0] + i;
            } finally {
                inputStream.close();
            }
        }
    }

    public static class b {
        public final byte[] a;
        public final int b;

        public b(byte[] bArr, int i) {
            this.a = bArr;
            this.b = i;
        }
    }

    public f(File file, int i) {
        this.a = file;
        this.b = i;
    }

    public void a() {
        i.e(this.c, "There was a problem closing the Crashlytics log file.");
        this.c = null;
    }

    public String b() {
        byte[] c = c();
        if (c != null) {
            return new String(c, d);
        }
        return null;
    }

    public byte[] c() {
        b g = g();
        if (g == null) {
            return null;
        }
        int i = g.b;
        byte[] bArr = new byte[i];
        System.arraycopy(g.a, 0, bArr, 0, i);
        return bArr;
    }

    public void d() {
        a();
        this.a.delete();
    }

    public void e(long j, String str) {
        h();
        f(j, str);
    }

    public final void f(long j, String str) {
        if (this.c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i = this.b / 4;
            if (str.length() > i) {
                str = "..." + str.substring(str.length() - i);
            }
            this.c.g(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")}).getBytes(d));
            while (!this.c.m() && this.c.V() > this.b) {
                this.c.t();
            }
        } catch (IOException e) {
            L5.f.f().e("There was a problem writing to the Crashlytics log.", e);
        }
    }

    public final b g() {
        if (!this.a.exists()) {
            return null;
        }
        h();
        e eVar = this.c;
        if (eVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[eVar.V()];
        try {
            this.c.k(new a(bArr, iArr));
        } catch (IOException e) {
            L5.f.f().e("A problem occurred while reading the Crashlytics log file.", e);
        }
        return new b(bArr, iArr[0]);
    }

    public final void h() {
        if (this.c == null) {
            try {
                this.c = new e(this.a);
            } catch (IOException e) {
                L5.f.f().e("Could not open log file: " + this.a, e);
            }
        }
    }
}

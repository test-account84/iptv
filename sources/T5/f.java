package T5;

import a1.i;
import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class f {
    public final File a;
    public final File b;
    public final File c;
    public final File d;
    public final File e;
    public final File f;

    public f(Context context) {
        String str;
        File filesDir = context.getFilesDir();
        this.a = filesDir;
        if (v()) {
            str = ".com.google.firebase.crashlytics.files.v2" + File.pathSeparator + u(i.a());
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File q = q(new File(filesDir, str));
        this.b = q;
        this.c = q(new File(q, "open-sessions"));
        this.d = q(new File(q, "reports"));
        this.e = q(new File(q, "priority-reports"));
        this.f = q(new File(q, "native-reports"));
    }

    public static synchronized File q(File file) {
        synchronized (f.class) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        return file;
                    }
                    L5.f.f().b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                    file.delete();
                }
                if (!file.mkdirs()) {
                    L5.f.f().d("Could not create Crashlytics-specific directory: " + file);
                }
                return file;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static File r(File file) {
        file.mkdirs();
        return file;
    }

    public static boolean s(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                s(file2);
            }
        }
        return file.delete();
    }

    public static List t(Object[] objArr) {
        return objArr == null ? Collections.emptyList() : Arrays.asList(objArr);
    }

    public static String u(String str) {
        return str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    public static boolean v() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public final void a(File file) {
        if (file.exists() && s(file)) {
            L5.f.f().b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    public void b() {
        a(new File(this.a, ".com.google.firebase.crashlytics"));
        a(new File(this.a, ".com.google.firebase.crashlytics-ndk"));
        if (v()) {
            a(new File(this.a, ".com.google.firebase.crashlytics.files.v1"));
        }
    }

    public boolean c(String str) {
        return s(new File(this.c, str));
    }

    public List d() {
        return t(this.c.list());
    }

    public File e(String str) {
        return new File(this.b, str);
    }

    public List f(FilenameFilter filenameFilter) {
        return t(this.b.listFiles(filenameFilter));
    }

    public File g(String str) {
        return new File(this.f, str);
    }

    public List h() {
        return t(this.f.listFiles());
    }

    public File i(String str) {
        return r(new File(n(str), "native"));
    }

    public File j(String str) {
        return new File(this.e, str);
    }

    public List k() {
        return t(this.e.listFiles());
    }

    public File l(String str) {
        return new File(this.d, str);
    }

    public List m() {
        return t(this.d.listFiles());
    }

    public final File n(String str) {
        return r(new File(this.c, str));
    }

    public File o(String str, String str2) {
        return new File(n(str), str2);
    }

    public List p(String str, FilenameFilter filenameFilter) {
        return t(n(str).listFiles(filenameFilter));
    }
}

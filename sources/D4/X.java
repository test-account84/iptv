package d4;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class x {
    public String[] a;
    public boolean b;
    public boolean c;

    public x(String... strArr) {
        this.a = strArr;
    }

    public synchronized boolean a() {
        if (this.b) {
            return this.c;
        }
        this.b = true;
        try {
            for (String str : this.a) {
                b(str);
            }
            this.c = true;
        } catch (UnsatisfiedLinkError unused) {
            B.j("LibraryLoader", "Failed to load " + Arrays.toString(this.a));
        }
        return this.c;
    }

    public abstract void b(String str);
}

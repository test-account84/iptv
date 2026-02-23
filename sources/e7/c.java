package e7;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c {
    public String a;
    public String b;
    public String c;
    public List d = new ArrayList();

    public void a(Object obj) {
        this.d.add(obj);
    }

    public List b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public void e(String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.c.equals(((c) obj).c);
        }
        return false;
    }

    public void f(String str) {
        this.b = str;
    }

    public void g(String str) {
        this.c = str;
    }

    public int hashCode() {
        return this.c.hashCode();
    }
}

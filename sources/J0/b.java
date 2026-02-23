package j0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b {
    public int a;
    public int b;
    public int c;
    public CharSequence[] d;
    public String e;

    public int a() {
        return (this.c - this.b) + 1;
    }

    public int b() {
        return this.a;
    }

    public CharSequence c(int i) {
        CharSequence[] charSequenceArr = this.d;
        return charSequenceArr == null ? String.format(this.e, new Object[]{Integer.valueOf(i)}) : charSequenceArr[i];
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.b;
    }

    public void f(int i) {
        this.a = i;
    }

    public void g(String str) {
        this.e = str;
    }

    public void h(int i) {
        this.c = i;
    }

    public void i(int i) {
        this.b = i;
    }

    public void j(CharSequence[] charSequenceArr) {
        this.d = charSequenceArr;
    }
}

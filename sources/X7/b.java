package X7;

import W7.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b extends W7.a {
    public boolean a = false;
    public int c = Integer.MIN_VALUE;
    public String d;
    public float e;

    public void a(c cVar) {
        boolean z = this.a;
        if (z && this.c == 1) {
            cVar.d(this.d, this.e);
        } else if (!z && this.c == 1) {
            cVar.a(this.d, this.e);
        }
        this.c = Integer.MIN_VALUE;
    }

    public void c(String str) {
        this.d = str;
    }

    public void h(int i) {
        if (i == 0) {
            this.a = false;
        } else if (i == 1) {
            this.a = true;
        } else {
            if (i != 2) {
                return;
            }
            this.a = false;
        }
    }

    public void n(float f) {
        this.e = f;
    }

    public void onError(int i) {
        if (i == 1) {
            this.c = i;
        }
    }
}

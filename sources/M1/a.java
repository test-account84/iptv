package m1;

import okhttp3.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends Exception {
    public String a;
    public int c;
    public String d;
    public Response e;

    public a() {
        this.c = 0;
    }

    public Response a() {
        return this.e;
    }

    public void b() {
        this.d = "requestCancelledError";
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(int i) {
        this.c = i;
    }

    public void e(String str) {
        this.d = str;
    }

    public a(Throwable th) {
        super(th);
        this.c = 0;
    }

    public a(Response response) {
        this.c = 0;
        this.e = response;
    }
}

package o0;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {
    public int a;
    public b b;
    public Context c;
    public boolean d = false;
    public boolean e = false;
    public boolean f = true;
    public boolean g = false;
    public boolean h = false;

    public final class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            c.this.o();
        }
    }

    public interface b {
        void a(c cVar, Object obj);
    }

    public c(Context context) {
        this.c = context.getApplicationContext();
    }

    public void a() {
        this.e = true;
        m();
    }

    public boolean b() {
        return n();
    }

    public void c() {
        this.h = false;
    }

    public String d(Object obj) {
        StringBuilder sb = new StringBuilder(64);
        O.b.a(obj, sb);
        sb.append("}");
        return sb.toString();
    }

    public void f(Object obj) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(this, obj);
        }
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.d || this.g || this.h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.h);
        }
        if (this.e || this.f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.e);
            printWriter.print(" mReset=");
            printWriter.println(this.f);
        }
    }

    public void h() {
        p();
    }

    public Context i() {
        return this.c;
    }

    public boolean j() {
        return this.e;
    }

    public boolean k() {
        return this.f;
    }

    public boolean l() {
        return this.d;
    }

    public abstract boolean n();

    public void o() {
        if (this.d) {
            h();
        } else {
            this.g = true;
        }
    }

    public abstract void r();

    public abstract void s();

    public void t(int i, b bVar) {
        if (this.b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.b = bVar;
        this.a = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        O.b.a(this, sb);
        sb.append(" id=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }

    public void u() {
        q();
        this.f = true;
        this.d = false;
        this.e = false;
        this.g = false;
        this.h = false;
    }

    public void v() {
        if (this.h) {
            o();
        }
    }

    public final void w() {
        this.d = true;
        this.f = false;
        this.e = false;
        r();
    }

    public void x() {
        this.d = false;
        s();
    }

    public boolean y() {
        boolean z = this.g;
        this.g = false;
        this.h |= z;
        return z;
    }

    public void z(b bVar) {
        b bVar2 = this.b;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (bVar2 != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.b = null;
    }

    public void e() {
    }

    public void m() {
    }

    public void p() {
    }

    public void q() {
    }
}

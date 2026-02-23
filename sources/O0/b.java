package o0;

import L.e;
import L.s;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
import o0.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class b extends a {
    public final c.a o;
    public Uri p;
    public String[] q;
    public String r;
    public String[] s;
    public String t;
    public Cursor u;
    public e v;

    public b(Context context) {
        super(context);
        this.o = new c.a(this);
    }

    public void A() {
        super.A();
        synchronized (this) {
            try {
                e eVar = this.v;
                if (eVar != null) {
                    eVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void f(Cursor cursor) {
        if (k()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.u;
        this.u = cursor;
        if (l()) {
            super.f(cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public Cursor F() {
        synchronized (this) {
            if (E()) {
                throw new s();
            }
            this.v = new e();
        }
        try {
            Cursor a = E.a.a(i().getContentResolver(), this.p, this.q, this.r, this.s, this.t, this.v);
            if (a != null) {
                try {
                    a.getCount();
                    a.registerContentObserver(this.o);
                } catch (RuntimeException e) {
                    a.close();
                    throw e;
                }
            }
            synchronized (this) {
                this.v = null;
            }
            return a;
        } catch (Throwable th) {
            synchronized (this) {
                this.v = null;
                throw th;
            }
        }
    }

    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void G(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public void L(String[] strArr) {
        this.q = strArr;
    }

    public void M(String str) {
        this.r = str;
    }

    public void N(String[] strArr) {
        this.s = strArr;
    }

    public void O(String str) {
        this.t = str;
    }

    public void P(Uri uri) {
        this.p = uri;
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.p);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.q));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.s));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.t);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.g);
    }

    public void q() {
        super.q();
        s();
        Cursor cursor = this.u;
        if (cursor != null && !cursor.isClosed()) {
            this.u.close();
        }
        this.u = null;
    }

    public void r() {
        Cursor cursor = this.u;
        if (cursor != null) {
            f(cursor);
        }
        if (y() || this.u == null) {
            h();
        }
    }

    public void s() {
        b();
    }
}

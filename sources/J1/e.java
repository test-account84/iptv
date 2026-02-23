package J1;

import java.io.Closeable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e implements Closeable {

    public enum a {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public abstract void a();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract boolean g();

    public abstract boolean h();

    public abstract String i();

    public abstract String j();

    public abstract a k();

    public abstract void l();
}

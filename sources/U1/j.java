package U1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j extends Exception {
    public j(Error error) {
        super(error);
        if (error == null) {
            throw new NullPointerException("The causing error must not be null");
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Error getCause() {
        return super.getCause();
    }
}

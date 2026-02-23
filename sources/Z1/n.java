package Z1;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class n implements l {
    public final l a;
    public final Resources b;

    public n(Context context, l lVar) {
        this(context.getResources(), lVar);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public T1.c a(Integer num, int i, int i2) {
        Uri uri;
        try {
            uri = Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + '/' + this.b.getResourceTypeName(num.intValue()) + '/' + this.b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            }
            uri = null;
        }
        if (uri != null) {
            return this.a.a(uri, i, i2);
        }
        return null;
    }

    public n(Resources resources, l lVar) {
        this.b = resources;
        this.a = lVar;
    }
}

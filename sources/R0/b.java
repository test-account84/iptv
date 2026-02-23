package r0;

import D.k;
import D.l;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends l.h {
    public int[] e = null;
    public MediaSessionCompat.Token f;

    public void b(k kVar) {
        a.d(kVar.a(), a.b(a.a(), this.e, this.f));
    }

    public RemoteViews d(k kVar) {
        return null;
    }

    public RemoteViews e(k kVar) {
        return null;
    }

    public b h(MediaSessionCompat.Token token) {
        this.f = token;
        return this;
    }

    public b i(int... iArr) {
        this.e = iArr;
        return this;
    }
}

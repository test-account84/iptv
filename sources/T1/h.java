package T1;

import android.content.res.AssetManager;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h extends a {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(InputStream inputStream) {
        inputStream.close();
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InputStream d(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}

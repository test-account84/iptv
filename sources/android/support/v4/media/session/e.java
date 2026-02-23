package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract /* synthetic */ class e {
    public static /* bridge */ /* synthetic */ void a(MediaController.TransportControls transportControls, Uri uri, Bundle bundle) {
        transportControls.prepareFromUri(uri, bundle);
    }
}

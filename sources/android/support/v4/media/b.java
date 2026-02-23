package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract /* synthetic */ class b {
    public static /* bridge */ /* synthetic */ void a(MediaBrowser mediaBrowser, String str, Bundle bundle, MediaBrowser.SubscriptionCallback subscriptionCallback) {
        mediaBrowser.subscribe(str, bundle, subscriptionCallback);
    }
}

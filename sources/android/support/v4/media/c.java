package android.support.v4.media;

import android.media.browse.MediaBrowser;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract /* synthetic */ class c {
    public static /* bridge */ /* synthetic */ void a(MediaBrowser mediaBrowser, String str, MediaBrowser.SubscriptionCallback subscriptionCallback) {
        mediaBrowser.unsubscribe(str, subscriptionCallback);
    }
}

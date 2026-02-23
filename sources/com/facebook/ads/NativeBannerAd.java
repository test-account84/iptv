package com.facebook.ads;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeBannerAdApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;
import java.util.List;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class NativeBannerAd extends NativeAdBase {
    private final NativeBannerAdApi mNativeBannerAdApi;

    public NativeBannerAd(Context context, NativeAdBaseApi nativeAdBaseApi) {
        super(nativeAdBaseApi);
        this.mNativeBannerAdApi = DynamicLoaderFactory.makeLoader(context).createNativeBannerAdApi(this, this.mNativeAdBaseApi);
    }

    public void registerViewForInteraction(View view, ImageView imageView) {
        Preconditions.checkIsOnMainThread();
        this.mNativeBannerAdApi.registerViewForInteraction(view, imageView);
    }

    public NativeBannerAd(Context context, String str) {
        super(context, str);
        this.mNativeBannerAdApi = DynamicLoaderFactory.makeLoader(context).createNativeBannerAdApi(this, this.mNativeAdBaseApi);
    }

    public void registerViewForInteraction(View view, ImageView imageView, List list) {
        Preconditions.checkIsOnMainThread();
        this.mNativeBannerAdApi.registerViewForInteraction(view, imageView, list);
    }

    public void registerViewForInteraction(View view, MediaView mediaView) {
        Preconditions.checkIsOnMainThread();
        this.mNativeBannerAdApi.registerViewForInteraction(view, mediaView);
    }

    public void registerViewForInteraction(View view, MediaView mediaView, List list) {
        Preconditions.checkIsOnMainThread();
        this.mNativeBannerAdApi.registerViewForInteraction(view, mediaView, list);
    }
}

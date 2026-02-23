package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdComponentViewApiProvider;
import com.facebook.ads.internal.api.AdNativeComponentView;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MediaView extends AdNativeComponentView {
    private AdViewConstructorParams mConstructorParams;
    private MediaViewApi mMediaViewApi;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            MediaView.this.removeAllViews();
            MediaView.access$002(MediaView.this, null);
            MediaView mediaView = MediaView.this;
            MediaView.access$102(mediaView, DynamicLoaderFactory.makeLoader(MediaView.access$200(mediaView).getContext()).createMediaViewApi());
            MediaView mediaView2 = MediaView.this;
            MediaView.access$300(mediaView2, MediaView.access$100(mediaView2));
            MediaView.access$100(MediaView.this).initialize(MediaView.access$200(MediaView.this), MediaView.this);
        }
    }

    public MediaView(Context context) {
        super(context);
        initializeSelf(new AdViewConstructorParams(context));
    }

    public static /* synthetic */ AdComponentViewApi access$002(MediaView mediaView, AdComponentViewApi adComponentViewApi) {
        mediaView.mAdComponentViewApi = adComponentViewApi;
        return adComponentViewApi;
    }

    public static /* synthetic */ MediaViewApi access$100(MediaView mediaView) {
        return mediaView.mMediaViewApi;
    }

    public static /* synthetic */ MediaViewApi access$102(MediaView mediaView, MediaViewApi mediaViewApi) {
        mediaView.mMediaViewApi = mediaViewApi;
        return mediaViewApi;
    }

    public static /* synthetic */ AdViewConstructorParams access$200(MediaView mediaView) {
        return mediaView.mConstructorParams;
    }

    public static /* synthetic */ void access$300(MediaView mediaView, AdComponentViewApiProvider adComponentViewApiProvider) {
        mediaView.attachAdComponentViewApi(adComponentViewApiProvider);
    }

    private void initializeSelf(AdViewConstructorParams adViewConstructorParams) {
        this.mConstructorParams = adViewConstructorParams;
        MediaViewApi createMediaViewApi = DynamicLoaderFactory.makeLoader(adViewConstructorParams.getContext()).createMediaViewApi();
        this.mMediaViewApi = createMediaViewApi;
        attachAdComponentViewApi(createMediaViewApi);
        this.mMediaViewApi.initialize(adViewConstructorParams, this);
    }

    public void destroy() {
        this.mMediaViewApi.destroy();
    }

    public View getAdContentsView() {
        return this.mMediaViewApi.getAdContentsView();
    }

    public int getMediaHeight() {
        return this.mMediaViewApi.getMediaHeight();
    }

    public MediaViewApi getMediaViewApi() {
        return this.mMediaViewApi;
    }

    public int getMediaWidth() {
        return this.mMediaViewApi.getMediaWidth();
    }

    public void repair(Throwable th) {
        post(new a());
    }

    public void setListener(MediaViewListener mediaViewListener) {
        this.mMediaViewApi.setListener(mediaViewListener);
    }

    public void setVideoRenderer(MediaViewVideoRenderer mediaViewVideoRenderer) {
        this.mMediaViewApi.setVideoRenderer(mediaViewVideoRenderer);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initializeSelf(new AdViewConstructorParams(context, attributeSet));
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeSelf(new AdViewConstructorParams(context, attributeSet, i));
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initializeSelf(new AdViewConstructorParams(context, attributeSet, i, i2));
    }
}

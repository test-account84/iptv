package com.facebook.ads.internal.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AdNativeComponentView extends RelativeLayout implements AdComponentView {
    protected AdComponentViewApi mAdComponentViewApi;
    private final AdComponentViewParentApi mAdComponentViewParentApi;

    public class a implements AdComponentViewParentApi {
        public a() {
        }

        public void addView(View view) {
            AdNativeComponentView.access$901(AdNativeComponentView.this, view);
        }

        public void bringChildToFront(View view) {
            AdNativeComponentView.access$501(AdNativeComponentView.this, view);
        }

        public void onAttachedToWindow() {
            AdNativeComponentView.access$301(AdNativeComponentView.this);
        }

        public void onDetachedFromWindow() {
            AdNativeComponentView.access$401(AdNativeComponentView.this);
        }

        public void onMeasure(int i, int i2) {
            AdNativeComponentView.access$101(AdNativeComponentView.this, i, i2);
        }

        public void onVisibilityChanged(View view, int i) {
            AdNativeComponentView.access$701(AdNativeComponentView.this, view, i);
        }

        public void onWindowFocusChanged(boolean z) {
            AdNativeComponentView.access$601(AdNativeComponentView.this, z);
        }

        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            AdNativeComponentView.access$001(AdNativeComponentView.this, layoutParams);
        }

        public void setMeasuredDimension(int i, int i2) {
            AdNativeComponentView.access$201(AdNativeComponentView.this, i, i2);
        }

        public void addView(View view, int i) {
            AdNativeComponentView.access$1001(AdNativeComponentView.this, view, i);
        }

        public void addView(View view, int i, int i2) {
            AdNativeComponentView.access$1201(AdNativeComponentView.this, view, i, i2);
        }

        public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
            AdNativeComponentView.access$801(AdNativeComponentView.this, view, i, layoutParams);
        }

        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            AdNativeComponentView.access$1101(AdNativeComponentView.this, view, layoutParams);
        }
    }

    public AdNativeComponentView(Context context) {
        super(context);
        this.mAdComponentViewParentApi = new a();
    }

    public static /* synthetic */ void access$001(AdNativeComponentView adNativeComponentView, ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ void access$1001(AdNativeComponentView adNativeComponentView, View view, int i) {
        super.addView(view, i);
    }

    public static /* synthetic */ void access$101(AdNativeComponentView adNativeComponentView, int i, int i2) {
        super.onMeasure(i, i2);
    }

    public static /* synthetic */ void access$1101(AdNativeComponentView adNativeComponentView, View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
    }

    public static /* synthetic */ void access$1201(AdNativeComponentView adNativeComponentView, View view, int i, int i2) {
        super.addView(view, i, i2);
    }

    public static /* synthetic */ void access$201(AdNativeComponentView adNativeComponentView, int i, int i2) {
        super.setMeasuredDimension(i, i2);
    }

    public static /* synthetic */ void access$301(AdNativeComponentView adNativeComponentView) {
        super.onAttachedToWindow();
    }

    public static /* synthetic */ void access$401(AdNativeComponentView adNativeComponentView) {
        super.onDetachedFromWindow();
    }

    public static /* synthetic */ void access$501(AdNativeComponentView adNativeComponentView, View view) {
        super.bringChildToFront(view);
    }

    public static /* synthetic */ void access$601(AdNativeComponentView adNativeComponentView, boolean z) {
        super.onWindowFocusChanged(z);
    }

    public static /* synthetic */ void access$701(AdNativeComponentView adNativeComponentView, View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public static /* synthetic */ void access$801(AdNativeComponentView adNativeComponentView, View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    public static /* synthetic */ void access$901(AdNativeComponentView adNativeComponentView, View view) {
        super.addView(view);
    }

    public void addView(View view) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view);
        } else {
            super.addView(view);
        }
    }

    public void attachAdComponentViewApi(AdComponentViewApiProvider adComponentViewApiProvider) {
        if (DynamicLoaderFactory.isFallbackMode()) {
            return;
        }
        if (this.mAdComponentViewApi != null) {
            throw new IllegalStateException("AdComponentViewApi can't be attached more then once.");
        }
        adComponentViewApiProvider.getAdComponentViewApi().onAttachedToView(this, this.mAdComponentViewParentApi);
        this.mAdComponentViewApi = adComponentViewApiProvider.getAdComponentViewApi();
    }

    public void bringChildToFront(View view) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.bringChildToFront(view);
        } else {
            super.bringChildToFront(view);
        }
    }

    public abstract View getAdContentsView();

    @SuppressLint({"MissingSuperCall"})
    public void onAttachedToWindow() {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    public void onMeasure(int i, int i2) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onMeasure(i, i2);
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void onVisibilityChanged(View view, int i) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onVisibilityChanged(view, i);
        } else {
            super.onVisibilityChanged(view, i);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onWindowFocusChanged(z);
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.setLayoutParams(layoutParams);
        } else {
            super.setLayoutParams(layoutParams);
        }
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdComponentViewParentApi = new a();
    }

    public void addView(View view, int i) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i);
        } else {
            super.addView(view, i);
        }
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAdComponentViewParentApi = new a();
    }

    public void addView(View view, int i, int i2) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i, i2);
        } else {
            super.addView(view, i, i2);
        }
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mAdComponentViewParentApi = new a();
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i, layoutParams);
        } else {
            super.addView(view, i, layoutParams);
        }
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, layoutParams);
        } else {
            super.addView(view, layoutParams);
        }
    }
}

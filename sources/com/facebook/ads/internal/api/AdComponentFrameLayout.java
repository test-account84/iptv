package com.facebook.ads.internal.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AdComponentFrameLayout extends FrameLayout implements AdComponentView {
    private AdComponentViewApi mAdComponentViewApi;
    private final AdComponentViewParentApi mAdComponentViewParentApi;

    public class a implements AdComponentViewParentApi {
        public a() {
        }

        public void addView(View view) {
            AdComponentFrameLayout.access$901(AdComponentFrameLayout.this, view);
        }

        public void bringChildToFront(View view) {
            AdComponentFrameLayout.access$501(AdComponentFrameLayout.this, view);
        }

        public void onAttachedToWindow() {
            AdComponentFrameLayout.access$201(AdComponentFrameLayout.this);
        }

        public void onDetachedFromWindow() {
            AdComponentFrameLayout.access$301(AdComponentFrameLayout.this);
        }

        public void onMeasure(int i, int i2) {
            AdComponentFrameLayout.access$101(AdComponentFrameLayout.this, i, i2);
        }

        public void onVisibilityChanged(View view, int i) {
            AdComponentFrameLayout.access$701(AdComponentFrameLayout.this, view, i);
        }

        public void onWindowFocusChanged(boolean z) {
            AdComponentFrameLayout.access$601(AdComponentFrameLayout.this, z);
        }

        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            AdComponentFrameLayout.access$001(AdComponentFrameLayout.this, layoutParams);
        }

        public void setMeasuredDimension(int i, int i2) {
            AdComponentFrameLayout.access$401(AdComponentFrameLayout.this, i, i2);
        }

        public void addView(View view, int i) {
            AdComponentFrameLayout.access$1001(AdComponentFrameLayout.this, view, i);
        }

        public void addView(View view, int i, int i2) {
            AdComponentFrameLayout.access$1201(AdComponentFrameLayout.this, view, i, i2);
        }

        public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
            AdComponentFrameLayout.access$801(AdComponentFrameLayout.this, view, i, layoutParams);
        }

        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            AdComponentFrameLayout.access$1101(AdComponentFrameLayout.this, view, layoutParams);
        }
    }

    public AdComponentFrameLayout(Context context) {
        super(context);
        this.mAdComponentViewParentApi = new a();
    }

    public static /* synthetic */ void access$001(AdComponentFrameLayout adComponentFrameLayout, ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ void access$1001(AdComponentFrameLayout adComponentFrameLayout, View view, int i) {
        super.addView(view, i);
    }

    public static /* synthetic */ void access$101(AdComponentFrameLayout adComponentFrameLayout, int i, int i2) {
        super.onMeasure(i, i2);
    }

    public static /* synthetic */ void access$1101(AdComponentFrameLayout adComponentFrameLayout, View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
    }

    public static /* synthetic */ void access$1201(AdComponentFrameLayout adComponentFrameLayout, View view, int i, int i2) {
        super.addView(view, i, i2);
    }

    public static /* synthetic */ void access$201(AdComponentFrameLayout adComponentFrameLayout) {
        super.onAttachedToWindow();
    }

    public static /* synthetic */ void access$301(AdComponentFrameLayout adComponentFrameLayout) {
        super.onDetachedFromWindow();
    }

    public static /* synthetic */ void access$401(AdComponentFrameLayout adComponentFrameLayout, int i, int i2) {
        super.setMeasuredDimension(i, i2);
    }

    public static /* synthetic */ void access$501(AdComponentFrameLayout adComponentFrameLayout, View view) {
        super.bringChildToFront(view);
    }

    public static /* synthetic */ void access$601(AdComponentFrameLayout adComponentFrameLayout, boolean z) {
        super.onWindowFocusChanged(z);
    }

    public static /* synthetic */ void access$701(AdComponentFrameLayout adComponentFrameLayout, View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public static /* synthetic */ void access$801(AdComponentFrameLayout adComponentFrameLayout, View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    public static /* synthetic */ void access$901(AdComponentFrameLayout adComponentFrameLayout, View view) {
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

    public AdComponentFrameLayout(Context context, AttributeSet attributeSet) {
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

    public AdComponentFrameLayout(Context context, AttributeSet attributeSet, int i) {
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

    public AdComponentFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
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

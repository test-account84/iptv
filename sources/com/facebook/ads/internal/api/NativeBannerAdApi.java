package com.facebook.ads.internal.api;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.facebook.ads.MediaView;
import java.util.List;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface NativeBannerAdApi {
    void registerViewForInteraction(View view, ImageView imageView);

    void registerViewForInteraction(View view, ImageView imageView, List list);

    void registerViewForInteraction(View view, MediaView mediaView);

    void registerViewForInteraction(View view, MediaView mediaView, List list);
}

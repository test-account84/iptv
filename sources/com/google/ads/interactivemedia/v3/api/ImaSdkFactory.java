package com.google.ads.interactivemedia.v3.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;
import com.google.ads.interactivemedia.v3.impl.data.bc;
import com.google.ads.interactivemedia.v3.impl.data.bd;
import com.google.ads.interactivemedia.v3.impl.data.g;
import com.google.ads.interactivemedia.v3.internal.aie;
import com.google.ads.interactivemedia.v3.internal.aiq;
import com.google.ads.interactivemedia.v3.internal.aiw;
import com.google.ads.interactivemedia.v3.internal.ajd;
import com.google.ads.interactivemedia.v3.internal.ajk;
import com.google.ads.interactivemedia.v3.internal.ajl;
import com.google.ads.interactivemedia.v3.internal.akr;
import com.google.ads.interactivemedia.v3.internal.akt;
import com.google.ads.interactivemedia.v3.internal.alc;
import com.google.ads.interactivemedia.v3.internal.atp;
import com.google.android.gms.common.internal.Hide;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class ImaSdkFactory {
    private static ImaSdkFactory instance;

    private ImaSdkFactory() {
    }

    private AdsLoader createAdsLoader(Context context, Uri uri, BaseDisplayContainer baseDisplayContainer, ImaSdkSettings imaSdkSettings) {
        if (uri == null) {
            uri = readJsCoreUri(imaSdkSettings);
        }
        aiq aiqVar = new aiq(context, uri, imaSdkSettings, baseDisplayContainer, Executors.newCachedThreadPool());
        aiqVar.l();
        return aiqVar;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    @Deprecated
    public static VideoAdPlayer createSdkOwnedPlayer(Context context, ViewGroup viewGroup) {
        atp.k(context);
        atp.k(viewGroup);
        return new alc(context, viewGroup);
    }

    public static ImaSdkFactory getInstance() {
        if (instance == null) {
            instance = new ImaSdkFactory();
        }
        return instance;
    }

    private Uri readJsCoreUri(ImaSdkSettings imaSdkSettings) {
        return (imaSdkSettings == null || !imaSdkSettings.isDebugMode()) ? ajk.a : ajk.b;
    }

    @Deprecated
    public AdDisplayContainer createAdDisplayContainer() {
        return new aie((ViewGroup) null, (VideoAdPlayer) null);
    }

    public AdsRenderingSettings createAdsRenderingSettings() {
        return new g();
    }

    public AdsRequest createAdsRequest() {
        return new aiw();
    }

    @Deprecated
    public AdDisplayContainer createAudioAdDisplayContainer(Context context) {
        atp.k(context);
        return new aie(context, (VideoAdPlayer) null);
    }

    public CompanionAdSlot createCompanionAdSlot() {
        return new ajd();
    }

    public FriendlyObstruction createFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        bc builder = bd.builder();
        builder.view(view);
        builder.purpose(friendlyObstructionPurpose);
        builder.detailedReason(str);
        return builder.build();
    }

    public ImaSdkSettings createImaSdkSettings() {
        return new ajl();
    }

    public StreamRequest createLiveStreamRequest(String str, String str2) {
        akt aktVar = new akt();
        aktVar.b(str);
        aktVar.a(str2);
        return aktVar;
    }

    public StreamRequest createPodStreamRequest(String str, String str2, String str3) {
        akt aktVar = new akt();
        aktVar.f(str);
        aktVar.d(str2);
        aktVar.a(str3);
        return aktVar;
    }

    @Deprecated
    public StreamDisplayContainer createStreamDisplayContainer() {
        return new akr(null, null);
    }

    @Hide
    public StreamRequest createVideoStitcherLiveStreamRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        akt aktVar = new akt();
        aktVar.f(str);
        aktVar.d(str2);
        aktVar.e(str3);
        aktVar.i(str4);
        aktVar.h(str5);
        aktVar.g(str6);
        return aktVar;
    }

    public StreamRequest createVodStreamRequest(String str, String str2, String str3) {
        akt aktVar = new akt();
        aktVar.c(str);
        aktVar.j(str2);
        aktVar.a(str3);
        return aktVar;
    }

    public static AdDisplayContainer createAdDisplayContainer(ViewGroup viewGroup, VideoAdPlayer videoAdPlayer) {
        atp.k(viewGroup);
        atp.k(videoAdPlayer);
        return new aie(viewGroup, videoAdPlayer);
    }

    public static AdDisplayContainer createAudioAdDisplayContainer(Context context, VideoAdPlayer videoAdPlayer) {
        atp.k(context);
        atp.k(videoAdPlayer);
        return new aie(context, videoAdPlayer);
    }

    public static StreamDisplayContainer createStreamDisplayContainer(ViewGroup viewGroup, VideoStreamPlayer videoStreamPlayer) {
        atp.k(viewGroup);
        atp.k(videoStreamPlayer);
        return new akr(viewGroup, videoStreamPlayer);
    }

    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, AdDisplayContainer adDisplayContainer) {
        return createAdsLoader(context, imaSdkSettings, adDisplayContainer, Executors.newCachedThreadPool());
    }

    @Hide
    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, AdDisplayContainer adDisplayContainer, ExecutorService executorService) {
        aiq aiqVar = new aiq(context, readJsCoreUri(imaSdkSettings), imaSdkSettings, adDisplayContainer, executorService);
        aiqVar.l();
        return aiqVar;
    }

    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, StreamDisplayContainer streamDisplayContainer) {
        return createAdsLoader(context, imaSdkSettings, streamDisplayContainer, Executors.newCachedThreadPool());
    }

    @Hide
    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, StreamDisplayContainer streamDisplayContainer, ExecutorService executorService) {
        aiq aiqVar = new aiq(context, readJsCoreUri(imaSdkSettings), imaSdkSettings, streamDisplayContainer, executorService);
        aiqVar.l();
        return aiqVar;
    }
}

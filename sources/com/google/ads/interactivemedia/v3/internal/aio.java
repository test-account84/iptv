package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import java.util.List;
import java.util.SortedSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aio implements ajt {
    final /* synthetic */ aiq a;

    public aio(aiq aiqVar) {
        this.a = aiqVar;
    }

    public final void a(String str, AdError.AdErrorType adErrorType, int i, String str2) {
        aiq.c(this.a).c(new aif(new AdError(adErrorType, i, str2), aiq.h(this.a).get(str) != null ? ((AdsRequest) aiq.h(this.a).get(str)).getUserRequestContext() : aiq.i(this.a).get(str) != null ? ((StreamRequest) aiq.i(this.a).get(str)).getUserRequestContext() : new Object()));
    }

    public final void b(String str, List list, SortedSet sortedSet, boolean z) {
        aiq aiqVar = this.a;
        AdDisplayContainer adDisplayContainer = (AdDisplayContainer) aiq.b(aiqVar);
        AdsRequest adsRequest = (AdsRequest) aiq.h(aiqVar).get(str);
        if (adsRequest == null) {
            aiq.c(this.a).c(new aif(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Request not found for session id: ".concat(String.valueOf(str))), new Object()));
            return;
        }
        ContentProgressProvider contentProgressProvider = adsRequest.getContentProgressProvider();
        AdError adError = null;
        akq akqVar = contentProgressProvider != null ? new akq(contentProgressProvider) : null;
        aiq.e(this.a).e(((aiw) adsRequest).h());
        if (sortedSet != null && !sortedSet.isEmpty() && akqVar == null) {
            adError = new AdError(AdError.AdErrorType.PLAY, AdError.AdErrorCode.PLAYLIST_NO_CONTENT_TRACKING, "Unable to handle cue points, no content progress provider configured.");
        }
        if (adError != null) {
            aiq.c(this.a).c(new aif(adError, adsRequest.getUserRequestContext()));
        } else {
            aiq aiqVar2 = this.a;
            aiq.j(aiqVar2, new ais(new air(str, aiq.d(aiqVar2), adDisplayContainer, akqVar, list, sortedSet, aiq.e(aiqVar2), new ajj(), aiq.a(this.a), z), adsRequest.getUserRequestContext()));
        }
    }

    public final void c(String str, String str2, boolean z) {
        aiq aiqVar = this.a;
        StreamDisplayContainer streamDisplayContainer = (StreamDisplayContainer) aiq.b(aiqVar);
        StreamRequest streamRequest = (StreamRequest) aiq.i(aiqVar).get(str);
        aiq aiqVar2 = this.a;
        if (streamRequest == null) {
            aiq.c(aiqVar2).c(new aif(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Request not found for session id: ".concat(String.valueOf(str))), new Object()));
            return;
        }
        aiq.e(aiqVar2).e(streamRequest.getContentUrl());
        aiq.e(this.a).i();
        aiq aiqVar3 = this.a;
        ajx d = aiq.d(aiqVar3);
        String manifestSuffix = streamRequest.getManifestSuffix();
        akn e = aiq.e(this.a);
        ajj ajjVar = new ajj();
        aiq.j(aiqVar3, new ais(new aks(str, d, streamDisplayContainer, new akv(str, d, ajjVar, streamDisplayContainer, manifestSuffix), new aid(str, d, streamDisplayContainer.getAdContainer()), e, ajjVar, aiq.a(this.a), str2, z), streamRequest.getUserRequestContext()));
    }

    public final void d(String str, AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode) {
        aiq.c(this.a).c(new aif(new AdError(adErrorType, adErrorCode, "adsLoaded message did not contain cue points."), aiq.h(this.a).get(str) != null ? ((AdsRequest) aiq.h(this.a).get(str)).getUserRequestContext() : aiq.i(this.a).get(str) != null ? ((StreamRequest) aiq.i(this.a).get(str)).getUserRequestContext() : new Object()));
    }
}

package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InstreamVideoAdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.InstreamVideoAdViewApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class DynamicLoaderFallback {
    private static final WeakHashMap sApiProxyToAdListenersMap = new WeakHashMap();

    public static class a implements InvocationHandler {
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ List d;
        public final /* synthetic */ Method e;
        public final /* synthetic */ Map f;
        public final /* synthetic */ List g;
        public final /* synthetic */ List h;
        public final /* synthetic */ List i;
        public final /* synthetic */ Method j;
        public final /* synthetic */ Method k;

        public a(List list, List list2, Map map, List list3, Method method, Map map2, List list4, List list5, List list6, Method method2, Method method3) {
            this.a = list;
            this.b = list2;
            this.c = map;
            this.d = list3;
            this.e = method;
            this.f = map2;
            this.g = list4;
            this.h = list5;
            this.i = list6;
            this.j = method2;
            this.k = method3;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getReturnType().isPrimitive()) {
                if (!method.getReturnType().equals(Void.TYPE)) {
                    return Array.get(Array.newInstance(method.getReturnType(), 1), 0);
                }
                Iterator it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (DynamicLoaderFallback.access$100(method, (Method) it.next())) {
                        DynamicLoaderFallback.access$200().put(obj, (AdListener) objArr[0]);
                        break;
                    }
                }
                Iterator it2 = this.b.iterator();
                while (it2.hasNext() && (!DynamicLoaderFallback.access$100(method, (Method) it2.next()) || !DynamicLoaderFallback.access$300(obj, this.c))) {
                }
                Iterator it3 = this.d.iterator();
                while (it3.hasNext() && (!DynamicLoaderFallback.access$100(method, (Method) it3.next()) || !DynamicLoaderFallback.access$300(obj, this.c))) {
                }
                if (!DynamicLoaderFallback.access$100(method, this.e)) {
                    return null;
                }
                DynamicLoaderFallback.access$300(this.f.get(obj), this.c);
                return null;
            }
            if (method.getReturnType().equals(String.class)) {
                return "";
            }
            Object newProxyInstance = method.getReturnType().equals(obj.getClass().getInterfaces()[0]) ? obj : Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{method.getReturnType()}, this);
            Iterator it4 = this.g.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                if (DynamicLoaderFallback.access$100(method, (Method) it4.next())) {
                    DynamicLoaderFallback.access$200().put(this.f.get(obj), (AdListener) objArr[0]);
                    break;
                }
            }
            Iterator it5 = this.h.iterator();
            while (it5.hasNext()) {
                if (DynamicLoaderFallback.access$100(method, (Method) it5.next())) {
                    this.f.put(newProxyInstance, obj);
                }
            }
            Iterator it6 = this.i.iterator();
            while (it6.hasNext()) {
                if (DynamicLoaderFallback.access$100(method, (Method) it6.next())) {
                    for (Object obj2 : objArr) {
                        if (obj2 instanceof Ad) {
                            this.c.put(newProxyInstance, (Ad) obj2);
                        }
                    }
                }
            }
            if (DynamicLoaderFallback.access$100(method, this.j)) {
                this.c.put(objArr[1], (Ad) objArr[0]);
            }
            if (DynamicLoaderFallback.access$100(method, this.k)) {
                this.c.put(objArr[1], (Ad) objArr[0]);
            }
            return newProxyInstance;
        }
    }

    public static class b implements Runnable {
        public final /* synthetic */ AdListener a;
        public final /* synthetic */ Ad c;

        public b(AdListener adListener, Ad ad) {
            this.a = adListener;
            this.c = ad;
        }

        public void run() {
            this.a.onError(this.c, new AdError(-1, "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder."));
        }
    }

    public static class c {
        public Method a;
        public final InvocationHandler b;

        public class a implements InvocationHandler {
            public a() {
            }

            public Object invoke(Object obj, Method method, Object[] objArr) {
                if ("toString".equals(method.getName())) {
                    return null;
                }
                c.a(c.this, method);
                return null;
            }
        }

        public c() {
            this.b = new a();
        }

        public static /* synthetic */ Method a(c cVar, Method method) {
            cVar.a = method;
            return method;
        }

        public Method b() {
            return this.a;
        }

        public Object c(Class cls) {
            return cls.cast(Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{cls}, this.b));
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static /* synthetic */ boolean access$100(Method method, Method method2) {
        return equalsMethods(method, method2);
    }

    public static /* synthetic */ WeakHashMap access$200() {
        return sApiProxyToAdListenersMap;
    }

    public static /* synthetic */ boolean access$300(Object obj, Map map) {
        return reportError(obj, map);
    }

    private static boolean equalsMethodParams(Method method, Method method2) {
        return Arrays.equals(method.getParameterTypes(), method2.getParameterTypes());
    }

    private static boolean equalsMethods(Method method, Method method2) {
        return method != null && method2 != null && method.getDeclaringClass().equals(method2.getDeclaringClass()) && method.getName().equals(method2.getName()) && equalsMethodParams(method, method2);
    }

    @SuppressLint({"Parameter Not Nullable", "CatchGeneralException"})
    public static DynamicLoader makeFallbackLoader() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        c cVar = new c(null);
        DynamicLoader dynamicLoader = (DynamicLoader) cVar.c(DynamicLoader.class);
        dynamicLoader.createInterstitialAd(null, null, null);
        arrayList6.add(cVar.b());
        dynamicLoader.createRewardedVideoAd(null, null, null);
        arrayList6.add(cVar.b());
        dynamicLoader.createInstreamVideoAdViewApi(null, null, null, null);
        arrayList6.add(cVar.b());
        dynamicLoader.createAdViewApi((Context) null, (String) null, (AdSize) null, (AdViewParentApi) null, (AdView) null);
        arrayList6.add(cVar.b());
        try {
            dynamicLoader.createAdViewApi((Context) null, (String) null, (String) null, (AdViewParentApi) null, (AdView) null);
        } catch (Exception unused) {
        }
        arrayList6.add(cVar.b());
        dynamicLoader.createNativeAdApi(null, null);
        Method b2 = cVar.b();
        dynamicLoader.createNativeBannerAdApi(null, null);
        Method b3 = cVar.b();
        NativeAdBaseApi nativeAdBaseApi = (NativeAdBaseApi) cVar.c(NativeAdBaseApi.class);
        nativeAdBaseApi.loadAd();
        arrayList.add(cVar.b());
        nativeAdBaseApi.loadAd((NativeAdBase.NativeLoadAdConfig) null);
        arrayList2.add(cVar.b());
        nativeAdBaseApi.loadAd((NativeAdBase.MediaCacheFlag) null);
        arrayList.add(cVar.b());
        nativeAdBaseApi.loadAdFromBid(null);
        arrayList.add(cVar.b());
        nativeAdBaseApi.loadAdFromBid(null, null);
        arrayList.add(cVar.b());
        nativeAdBaseApi.buildLoadAdConfig(null);
        arrayList5.add(cVar.b());
        nativeAdBaseApi.setAdListener(null, null);
        arrayList3.add(cVar.b());
        InterstitialAdApi interstitialAdApi = (InterstitialAdApi) cVar.c(InterstitialAdApi.class);
        interstitialAdApi.loadAd();
        arrayList.add(cVar.b());
        interstitialAdApi.loadAd((EnumSet) null);
        arrayList.add(cVar.b());
        interstitialAdApi.loadAd((InterstitialAd.InterstitialLoadAdConfig) null);
        arrayList2.add(cVar.b());
        interstitialAdApi.loadAdFromBid(null, null);
        arrayList.add(cVar.b());
        interstitialAdApi.setAdListener(null);
        arrayList3.add(cVar.b());
        interstitialAdApi.buildLoadAdConfig();
        arrayList5.add(cVar.b());
        RewardedVideoAdApi rewardedVideoAdApi = (RewardedVideoAdApi) cVar.c(RewardedVideoAdApi.class);
        rewardedVideoAdApi.loadAd();
        arrayList.add(cVar.b());
        rewardedVideoAdApi.loadAd((RewardedVideoAd.RewardedVideoLoadAdConfig) null);
        arrayList2.add(cVar.b());
        rewardedVideoAdApi.loadAd(false);
        arrayList.add(cVar.b());
        rewardedVideoAdApi.loadAdFromBid(null, false);
        arrayList.add(cVar.b());
        rewardedVideoAdApi.setAdListener(null);
        arrayList3.add(cVar.b());
        rewardedVideoAdApi.buildLoadAdConfig();
        arrayList5.add(cVar.b());
        InstreamVideoAdViewApi instreamVideoAdViewApi = (InstreamVideoAdViewApi) cVar.c(InstreamVideoAdViewApi.class);
        instreamVideoAdViewApi.loadAd();
        arrayList.add(cVar.b());
        instreamVideoAdViewApi.loadAd(null);
        arrayList2.add(cVar.b());
        instreamVideoAdViewApi.loadAdFromBid(null);
        arrayList.add(cVar.b());
        instreamVideoAdViewApi.setAdListener(null);
        arrayList3.add(cVar.b());
        instreamVideoAdViewApi.buildLoadAdConfig();
        arrayList5.add(cVar.b());
        AdViewApi adViewApi = (AdViewApi) cVar.c(AdViewApi.class);
        adViewApi.loadAd();
        arrayList.add(cVar.b());
        adViewApi.loadAd(null);
        arrayList2.add(cVar.b());
        adViewApi.loadAdFromBid(null);
        arrayList.add(cVar.b());
        adViewApi.setAdListener(null);
        arrayList3.add(cVar.b());
        adViewApi.buildLoadAdConfig();
        arrayList5.add(cVar.b());
        ((AdView.AdViewLoadConfigBuilder) cVar.c(AdView.AdViewLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(cVar.b());
        NativeAdBase.NativeAdLoadConfigBuilder nativeAdLoadConfigBuilder = (NativeAdBase.NativeAdLoadConfigBuilder) cVar.c(NativeAdBase.NativeAdLoadConfigBuilder.class);
        nativeAdLoadConfigBuilder.withAdListener(null);
        arrayList4.add(cVar.b());
        ((InterstitialAd.InterstitialAdLoadConfigBuilder) cVar.c(InterstitialAd.InterstitialAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(cVar.b());
        ((RewardedVideoAd.RewardedVideoAdLoadConfigBuilder) cVar.c(RewardedVideoAd.RewardedVideoAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(cVar.b());
        ((InstreamVideoAdView.InstreamVideoLoadConfigBuilder) cVar.c(InstreamVideoAdView.InstreamVideoLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(cVar.b());
        nativeAdLoadConfigBuilder.loadAd();
        return (DynamicLoader) Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{DynamicLoader.class}, new a(arrayList3, arrayList, hashMap, arrayList2, cVar.b(), hashMap2, arrayList4, arrayList5, arrayList6, b2, b3));
    }

    private static boolean reportError(Object obj, Map map) {
        if (obj == null) {
            return false;
        }
        AdListener adListener = (AdListener) sApiProxyToAdListenersMap.get(obj);
        Ad ad = (Ad) map.get(obj);
        if (adListener == null) {
            return false;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new b(adListener, ad), 500L);
        return true;
    }
}

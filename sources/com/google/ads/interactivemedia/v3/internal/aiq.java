package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.StrictMode;
import android.webkit.WebView;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdsLoader;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aiq implements AdsLoader {
    aps a;
    private final Context b;
    private final ajx c;
    private final ajt d;
    private final ajj e;
    private final List f;
    private final Map g;
    private final Map h;
    private final akn i;
    private final ImaSdkSettings j;
    private final BaseDisplayContainer k;
    private final alq l;
    private final alx m;
    private final Object n;
    private final aze o;
    private final alm p;
    private final TestingConfiguration q;
    private ali r;

    public aiq(Context context, Uri uri, ImaSdkSettings imaSdkSettings, BaseDisplayContainer baseDisplayContainer, ExecutorService executorService) {
        ajx ajxVar = new ajx(new ake(new Handler(Looper.getMainLooper()), new WebView(context), uri), context, uri, imaSdkSettings, executorService);
        this.d = new aio(this);
        this.e = new ajj();
        this.f = new ArrayList(1);
        this.g = new HashMap();
        this.h = new HashMap();
        this.n = new Object();
        this.c = ajxVar;
        this.b = context;
        this.j = imaSdkSettings == null ? ImaSdkFactory.getInstance().createImaSdkSettings() : imaSdkSettings;
        this.k = baseDisplayContainer;
        aze a = azh.a(executorService);
        this.o = a;
        this.q = imaSdkSettings.getTestingConfig();
        akn aknVar = new akn(ajxVar, context);
        this.i = aknVar;
        alm almVar = new alm(ajxVar);
        this.p = almVar;
        ajxVar.h(aknVar);
        baseDisplayContainer.claim();
        this.l = new alq(context, a, almVar);
        this.m = new alx(context, a, almVar);
        this.r = new ali(context, false, 150L);
    }

    public static /* bridge */ /* synthetic */ Context a(aiq aiqVar) {
        return aiqVar.b;
    }

    public static /* bridge */ /* synthetic */ BaseDisplayContainer b(aiq aiqVar) {
        return aiqVar.k;
    }

    public static /* bridge */ /* synthetic */ ajj c(aiq aiqVar) {
        return aiqVar.e;
    }

    public static /* bridge */ /* synthetic */ ajx d(aiq aiqVar) {
        return aiqVar.c;
    }

    public static /* bridge */ /* synthetic */ akn e(aiq aiqVar) {
        return aiqVar.i;
    }

    public static /* bridge */ /* synthetic */ Map h(aiq aiqVar) {
        return aiqVar.g;
    }

    public static /* bridge */ /* synthetic */ Map i(aiq aiqVar) {
        return aiqVar.h;
    }

    public static /* bridge */ /* synthetic */ void j(aiq aiqVar, AdsManagerLoadedEvent adsManagerLoadedEvent) {
        Iterator it = aiqVar.f.iterator();
        while (it.hasNext()) {
            ((AdsLoader.AdsLoadedListener) it.next()).onAdsManagerLoaded(adsManagerLoadedEvent);
        }
    }

    public static final Object p(Future future) {
        if (future == null) {
            return null;
        }
        try {
            return azh.c(future);
        } catch (Exception e) {
            com.google.ads.interactivemedia.v3.impl.data.m.b("Error during initialization", e);
            return null;
        } catch (Throwable th) {
            com.google.ads.interactivemedia.v3.impl.data.m.b("Error during initialization", new Exception(th));
            return null;
        }
    }

    private final aip q() {
        ActivityInfo activityInfo;
        PackageManager packageManager = this.b.getPackageManager();
        ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads.interactivemedia.v3")), 65536);
        if (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo == null) {
                return null;
            }
            return aip.create(packageInfo.versionCode, activityInfo.packageName);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final com.google.ads.interactivemedia.v3.impl.data.ba r() {
        SharedPreferences a = z0.b.a(this.b);
        if (a == null) {
            return null;
        }
        try {
            return com.google.ads.interactivemedia.v3.impl.data.ba.create(a.contains("IABTCF_gdprApplies") ? String.valueOf(a.getInt("IABTCF_gdprApplies", 0)) : "", a.getString("IABTCF_TCString", ""), a.getString("IABTCF_AddtlConsent", ""), a.getString("IABUSPrivacy_String", ""));
        } catch (ClassCastException e) {
            com.google.ads.interactivemedia.v3.impl.data.m.b("Failed to read TCF Consent settings from SharedPreferences.", e);
            return null;
        }
    }

    private final com.google.ads.interactivemedia.v3.impl.data.cd s() {
        NetworkCapabilities networkCapabilities;
        Integer valueOf;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                com.google.ads.interactivemedia.v3.impl.data.m.d("Host application doesn't have ACCESS_NETWORK_STATE permission");
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
                if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(X0.e.a(connectivityManager))) != null) {
                    valueOf = Integer.valueOf(networkCapabilities.getLinkDownstreamBandwidthKbps());
                }
            }
            valueOf = null;
        } else {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        return com.google.ads.interactivemedia.v3.impl.data.cd.create(valueOf);
    }

    private final String t() {
        TestingConfiguration testingConfiguration = this.q;
        if (testingConfiguration == null || !testingConfiguration.ignoreStrictModeFalsePositives()) {
            return UUID.randomUUID().toString();
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
        String uuid = UUID.randomUUID().toString();
        StrictMode.setThreadPolicy(threadPolicy);
        return uuid;
    }

    private final String u() {
        return String.format("android%s:%s:%s", new Object[]{Build.VERSION.RELEASE, "3.29.0", this.b.getPackageName()});
    }

    public final void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.e.a(adErrorListener);
    }

    public final void addAdsLoadedListener(AdsLoader.AdsLoadedListener adsLoadedListener) {
        this.f.add(adsLoadedListener);
    }

    public final void contentComplete() {
        this.c.o(new ajr(ajp.adsLoader, ajq.contentComplete, "*"));
    }

    public final /* synthetic */ String f(AdsRequest adsRequest) throws Exception {
        String adTagUrl = adsRequest.getAdTagUrl();
        m();
        if (adTagUrl == null) {
            return adTagUrl;
        }
        try {
            Uri parse = Uri.parse(adTagUrl);
            aps apsVar = this.a;
            return (apsVar == null || !apsVar.c(parse)) ? adTagUrl : this.a.a(parse, this.b).toString();
        } catch (aqb | RemoteException | IllegalStateException unused) {
            return adTagUrl;
        }
    }

    public final /* synthetic */ String g() throws Exception {
        Context context = this.b;
        m();
        try {
            aps apsVar = this.a;
            if (apsVar != null) {
                return apsVar.b(context);
            }
        } catch (RemoteException unused) {
        }
        return "";
    }

    public final ImaSdkSettings getSettings() {
        return this.j;
    }

    public final /* synthetic */ void k(Task task) {
        List list;
        com.google.ads.interactivemedia.v3.impl.data.bm bmVar = (com.google.ads.interactivemedia.v3.impl.data.bm) task.getResult();
        this.p.d(bmVar.enableInstrumentation);
        Integer num = bmVar.espAdapterTimeoutMs;
        if (num != null && (list = bmVar.espAdapters) != null) {
            this.m.h(list, num);
            this.m.g();
        }
        Integer num2 = bmVar.platformSignalCollectorTimeoutMs;
        if (num2 != null) {
            this.l.c(num2);
        }
        this.r = new ali(this.b, !bmVar.disableAppSetId, bmVar.appSetIdTimeoutMs);
    }

    public final void l() {
        this.c.c().addOnCompleteListener((Executor) this.o, (OnCompleteListener) new ajm(this, 1));
    }

    public final void m() {
        synchronized (this.n) {
            if (this.a == null) {
                try {
                    afl l = aff.l();
                    l.k(afg.b);
                    l.j();
                    l.h();
                    l.i();
                    this.a = new aps(this.b, this.o, (aff) l.aY());
                } catch (RuntimeException unused) {
                    this.a = null;
                }
            }
        }
    }

    public final /* synthetic */ void n(AdsRequest adsRequest, azd azdVar, AdDisplayContainer adDisplayContainer, azd azdVar2, azd azdVar3, azd azdVar4, String str) throws Exception {
        SecureSignals secureSignals = adsRequest.getSecureSignals();
        List list = (List) p(azdVar);
        com.google.ads.interactivemedia.v3.impl.data.y.a(secureSignals, list);
        com.google.ads.interactivemedia.v3.impl.data.bg bgVar = (com.google.ads.interactivemedia.v3.impl.data.bg) azh.c(azdVar2);
        String str2 = (String) azh.c(azdVar3);
        Map map = (Map) p(azdVar4);
        adsRequest.setAdTagUrl(str2);
        ajr ajrVar = new ajr(ajp.adsLoader, ajq.requestAds, str, com.google.ads.interactivemedia.v3.impl.data.bf.create(adsRequest, u(), r(), list, map, "android:0", s(), this.j, q(), com.google.ads.interactivemedia.v3.impl.data.k.b(this.b, this.q), bgVar, adDisplayContainer));
        this.c.j(bgVar);
        this.c.o(ajrVar);
    }

    public final /* synthetic */ void o(StreamRequest streamRequest, azd azdVar, azd azdVar2, azd azdVar3, azd azdVar4, String str) throws Exception {
        SecureSignals secureSignals = streamRequest.getSecureSignals();
        List list = (List) p(azdVar);
        com.google.ads.interactivemedia.v3.impl.data.y.a(secureSignals, list);
        StreamDisplayContainer streamDisplayContainer = (StreamDisplayContainer) this.k;
        com.google.ads.interactivemedia.v3.impl.data.bg bgVar = (com.google.ads.interactivemedia.v3.impl.data.bg) azh.c(azdVar2);
        String str2 = (String) azh.c(azdVar3);
        Map map = (Map) p(azdVar4);
        ajr ajrVar = new ajr(ajp.adsLoader, ajq.requestStream, str, com.google.ads.interactivemedia.v3.impl.data.bf.createFromStreamRequest(streamRequest, u(), r(), list, map, "android:0", s(), this.j, q(), com.google.ads.interactivemedia.v3.impl.data.k.b(this.b, this.q), str2, bgVar, streamDisplayContainer));
        this.c.j(bgVar);
        this.c.o(ajrVar);
    }

    public final void release() {
        this.k.destroy();
        ajx ajxVar = this.c;
        if (ajxVar != null) {
            ajxVar.l();
        }
        this.g.clear();
        this.f.clear();
        this.e.b();
        this.h.clear();
    }

    public final void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.e.d(adErrorListener);
    }

    public final void removeAdsLoadedListener(AdsLoader.AdsLoadedListener adsLoadedListener) {
        this.f.remove(adsLoadedListener);
    }

    public final void requestAds(AdsRequest adsRequest) {
        String t = t();
        if (adsRequest == null) {
            this.e.c(new aif(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsRequest cannot be null.")));
            return;
        }
        BaseDisplayContainer baseDisplayContainer = this.k;
        if (!(baseDisplayContainer instanceof AdDisplayContainer)) {
            this.e.c(new aif(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsLoader must be constructed with AdDisplayContainer.")));
            return;
        }
        if (baseDisplayContainer.getAdContainer() == null) {
            this.e.c(new aif(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Ad display container must have a UI container.")));
            return;
        }
        if (atp.c(adsRequest.getAdTagUrl()) && atp.c(adsRequest.getAdsResponse())) {
            this.e.c(new aif(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Ad tag url must non-null and non empty.")));
            return;
        }
        AdDisplayContainer adDisplayContainer = (AdDisplayContainer) this.k;
        if (adDisplayContainer.getPlayer() == null) {
            this.p.a(com.google.ads.interactivemedia.v3.impl.data.bi.ADS_LOADER, com.google.ads.interactivemedia.v3.impl.data.bj.CREATE_SDK_OWNED_PLAYER);
            adDisplayContainer.setPlayer(ImaSdkFactory.createSdkOwnedPlayer(this.b, adDisplayContainer.getAdContainer()));
        }
        this.g.put(t, adsRequest);
        this.c.f(this.d, t);
        this.c.e(adDisplayContainer, t);
        aze azeVar = this.o;
        ali aliVar = this.r;
        aliVar.getClass();
        azd a = azeVar.a(new aik(aliVar, 1));
        azd a2 = this.o.a(new aim(this, adsRequest));
        aze azeVar2 = this.o;
        alx alxVar = this.m;
        alxVar.getClass();
        azd a3 = azeVar2.a(new aik(alxVar, 0));
        aze azeVar3 = this.o;
        alq alqVar = this.l;
        alqVar.getClass();
        azd a4 = azeVar3.a(new aik(alqVar, 3));
        this.p.c(azh.b(a, a2, a3, a4).a(new ain(this, adsRequest, a3, adDisplayContainer, a, a2, a4, t), this.o), this.o, com.google.ads.interactivemedia.v3.impl.data.bi.ADS_LOADER, com.google.ads.interactivemedia.v3.impl.data.bj.REQUEST_ADS);
    }

    public final String requestStream(StreamRequest streamRequest) {
        ajj ajjVar;
        aif aifVar;
        String t = t();
        if (streamRequest == null) {
            ajjVar = this.e;
            aifVar = new aif(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "StreamRequest cannot be null."));
        } else {
            BaseDisplayContainer baseDisplayContainer = this.k;
            if (!(baseDisplayContainer instanceof StreamDisplayContainer)) {
                ajjVar = this.e;
                aifVar = new aif(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsLoader must be constructed with StreamDisplayContainer."));
            } else {
                if (((StreamDisplayContainer) baseDisplayContainer).getVideoStreamPlayer() != null) {
                    this.h.put(t, streamRequest);
                    this.c.f(this.d, t);
                    this.c.e(this.k, t);
                    aze azeVar = this.o;
                    ali aliVar = this.r;
                    aliVar.getClass();
                    azd a = azeVar.a(new aik(aliVar, 1));
                    aze azeVar2 = this.o;
                    alx alxVar = this.m;
                    alxVar.getClass();
                    azd a2 = azeVar2.a(new aik(alxVar, 0));
                    azd a3 = this.o.a(new aik(this, 2));
                    aze azeVar3 = this.o;
                    alq alqVar = this.l;
                    alqVar.getClass();
                    azd a4 = azeVar3.a(new aik(alqVar, 3));
                    this.p.c(azh.b(a, a2, a3, a4).a(new ail(this, streamRequest, a2, a, a3, a4, t), this.o), this.o, com.google.ads.interactivemedia.v3.impl.data.bi.ADS_LOADER, com.google.ads.interactivemedia.v3.impl.data.bj.REQUEST_STREAM);
                    return t;
                }
                ajjVar = this.e;
                aifVar = new aif(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Stream requests must specify a player."));
            }
        }
        ajjVar.c(aifVar);
        return t;
    }
}

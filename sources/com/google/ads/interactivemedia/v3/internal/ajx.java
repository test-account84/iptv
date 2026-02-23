package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.impl.data.CompanionData;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ajx implements akb, akc {
    private final Context g;
    private final String h;
    private final ake i;
    private final float k;
    private final ExecutorService l;
    private final TestingConfiguration m;
    private final TaskCompletionSource n;
    private final TaskCompletionSource o;
    private akl p;
    private ajw q;
    private long r;
    private boolean s;
    private final Map a = new HashMap();
    private final Set b = new HashSet();
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final Map e = new HashMap();
    private final Map f = new HashMap();
    private final Queue j = new ConcurrentLinkedQueue();

    public ajx(ake akeVar, Context context, Uri uri, ImaSdkSettings imaSdkSettings, ExecutorService executorService) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.n = taskCompletionSource;
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        this.o = taskCompletionSource2;
        this.s = false;
        this.g = context;
        this.k = context.getResources().getDisplayMetrics().density;
        boolean a = O0.f.a("WEB_MESSAGE_LISTENER");
        Uri.Builder appendQueryParameter = uri.buildUpon().appendQueryParameter("sdk_version", "a.3.29.0").appendQueryParameter("hl", imaSdkSettings.getLanguage()).appendQueryParameter("omv", ago.a()).appendQueryParameter("app", context.getApplicationContext().getPackageName());
        appendQueryParameter.appendQueryParameter("mt", true != a ? "0" : "4");
        if (imaSdkSettings.getTestingConfig() != null) {
            bju bjuVar = new bju();
            bjuVar.c(new atg());
            bjuVar.d(new com.google.ads.interactivemedia.v3.impl.data.k());
            appendQueryParameter.appendQueryParameter("tcnfp", bjuVar.a().g(imaSdkSettings.getTestingConfig()));
        }
        this.h = appendQueryParameter.build().toString();
        this.m = imaSdkSettings.getTestingConfig();
        this.i = akeVar;
        akeVar.g(this);
        this.l = executorService;
        Tasks.whenAllComplete(taskCompletionSource2.getTask(), taskCompletionSource.getTask()).addOnCompleteListener(new ajm(this, 2));
    }

    private static String q(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        return str + " Caused by: " + str2;
    }

    private final void r(ajp ajpVar, ajq ajqVar, String str, com.google.ads.interactivemedia.v3.impl.data.bm bmVar) {
        akw akwVar = (akw) this.f.get(str);
        if (akwVar != null) {
            akwVar.f(ajpVar, ajqVar, bmVar);
            return;
        }
        com.google.ads.interactivemedia.v3.impl.data.m.d("Received " + String.valueOf(ajpVar) + " message: " + String.valueOf(ajqVar) + " for invalid session id: " + str);
    }

    private static final void s(String str, ajq ajqVar) {
        com.google.ads.interactivemedia.v3.impl.data.m.c("Illegal message type " + String.valueOf(ajqVar) + " received for " + str + " channel");
    }

    public final WebView a() {
        return this.i.a();
    }

    public final TestingConfiguration b() {
        return this.m;
    }

    public final Task c() {
        this.r = SystemClock.elapsedRealtime();
        this.i.e(this.h);
        return this.o.getTask();
    }

    public final void d(ajs ajsVar, String str) {
        this.a.put(str, ajsVar);
    }

    public final void e(BaseDisplayContainer baseDisplayContainer, String str) {
        this.c.put(str, baseDisplayContainer);
    }

    public final void f(ajt ajtVar, String str) {
        this.d.put(str, ajtVar);
    }

    public final void g(ajv ajvVar, String str) {
        this.e.put(str, ajvVar);
    }

    public final void h(ajw ajwVar) {
        this.q = ajwVar;
    }

    public final void i(akw akwVar, String str) {
        this.f.put(str, akwVar);
    }

    public final void j(com.google.ads.interactivemedia.v3.impl.data.bg bgVar) {
        this.n.trySetResult(bgVar);
    }

    public final void k(ajr ajrVar) {
        com.google.ads.interactivemedia.v3.impl.data.c cVar;
        Map map;
        String str;
        String str2;
        com.google.ads.interactivemedia.v3.impl.data.bm bmVar = (com.google.ads.interactivemedia.v3.impl.data.bm) ajrVar.e();
        String f = ajrVar.f();
        ajq b = ajrVar.b();
        com.google.ads.interactivemedia.v3.impl.data.m.c("Received js message: " + ajrVar.a().name() + " [" + b.name() + "]");
        switch (ajrVar.a().ordinal()) {
            case 0:
                if (!this.b.contains(f)) {
                    ajs ajsVar = (ajs) this.a.get(f);
                    if (ajsVar == null) {
                        com.google.ads.interactivemedia.v3.impl.data.m.d("Received monitor message: " + String.valueOf(b) + " for invalid session id: " + f);
                        break;
                    } else if (bmVar == null) {
                        com.google.ads.interactivemedia.v3.impl.data.m.d("Received monitor message: " + String.valueOf(b) + " for session id: " + f + " with no data");
                        break;
                    } else if (b.ordinal() != 37) {
                        s(ajp.activityMonitor.toString(), b);
                        break;
                    } else {
                        ajsVar.h(bmVar.queryId, bmVar.eventId);
                        break;
                    }
                }
                break;
            case 1:
                ajt ajtVar = (ajt) this.d.get(f);
                if (ajtVar == null) {
                    com.google.ads.interactivemedia.v3.impl.data.m.a("Received request message: " + String.valueOf(b) + " for invalid session id: " + f);
                    break;
                } else {
                    int ordinal = b.ordinal();
                    if (ordinal != 11) {
                        if (ordinal != 31) {
                            if (ordinal != 68) {
                                s(ajp.adsLoader.toString(), b);
                                break;
                            } else {
                                ajtVar.c(f, bmVar.streamId, bmVar.monitorAppLifecycle);
                                com.google.ads.interactivemedia.v3.impl.data.m.c("Stream initialized with streamId: ".concat(String.valueOf(bmVar.streamId)));
                                break;
                            }
                        } else {
                            ajtVar.a(f, AdError.AdErrorType.LOAD, bmVar.errorCode, q(bmVar.errorMessage, bmVar.innerError));
                            break;
                        }
                    } else if (bmVar == null) {
                        ajtVar.d(f, AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR);
                        break;
                    } else {
                        ajtVar.b(f, bmVar.adCuePoints, bmVar.internalCuePoints, bmVar.monitorAppLifecycle);
                        break;
                    }
                }
            case 2:
                ajv ajvVar = (ajv) this.e.get(f);
                if (ajvVar == null) {
                    com.google.ads.interactivemedia.v3.impl.data.m.d("Received manager message: " + String.valueOf(b) + " for invalid session id: " + f);
                    break;
                } else {
                    if (bmVar == null || (cVar = bmVar.adData) == null) {
                        cVar = null;
                    }
                    int ordinal2 = b.ordinal();
                    if (ordinal2 != 12) {
                        if (ordinal2 != 16) {
                            if (ordinal2 != 18) {
                                if (ordinal2 != 25) {
                                    if (ordinal2 != 44) {
                                        if (ordinal2 != 52) {
                                            if (ordinal2 != 61) {
                                                if (ordinal2 != 69) {
                                                    if (ordinal2 != 77) {
                                                        if (ordinal2 != 20) {
                                                            if (ordinal2 != 21) {
                                                                if (ordinal2 != 31) {
                                                                    if (ordinal2 != 32) {
                                                                        if (ordinal2 != 39) {
                                                                            if (ordinal2 != 40) {
                                                                                switch (ordinal2) {
                                                                                    case 1:
                                                                                        ajvVar.b(new aju(AdEvent.AdEventType.AD_BREAK_ENDED, cVar));
                                                                                        break;
                                                                                    case 2:
                                                                                        aju ajuVar = new aju(AdEvent.AdEventType.AD_BREAK_FETCH_ERROR, null);
                                                                                        ajuVar.c = avs.j(bmVar.adBreakTime);
                                                                                        ajvVar.b(ajuVar);
                                                                                        break;
                                                                                    case 3:
                                                                                        aju ajuVar2 = new aju(AdEvent.AdEventType.AD_BREAK_READY, null);
                                                                                        ajuVar2.c = avs.j(bmVar.adBreakTime);
                                                                                        ajvVar.b(ajuVar2);
                                                                                        break;
                                                                                    case 4:
                                                                                        ajvVar.b(new aju(AdEvent.AdEventType.AD_BREAK_STARTED, cVar));
                                                                                        break;
                                                                                    case 5:
                                                                                        ajvVar.b(new aju(AdEvent.AdEventType.AD_BUFFERING, null));
                                                                                        break;
                                                                                    case 6:
                                                                                    case 7:
                                                                                        break;
                                                                                    case 8:
                                                                                        ajvVar.b(new aju(AdEvent.AdEventType.AD_PERIOD_ENDED, null));
                                                                                        break;
                                                                                    case 9:
                                                                                        ajvVar.b(new aju(AdEvent.AdEventType.AD_PERIOD_STARTED, null));
                                                                                        break;
                                                                                    case 10:
                                                                                        aju ajuVar3 = new aju(AdEvent.AdEventType.AD_PROGRESS, cVar);
                                                                                        ajuVar3.e = new aij(bmVar.currentTime, bmVar.duration, bmVar.adPosition, bmVar.totalAds, bmVar.adBreakDuration, bmVar.adPeriodDuration);
                                                                                        ajvVar.b(ajuVar3);
                                                                                        break;
                                                                                    default:
                                                                                        switch (ordinal2) {
                                                                                            case 46:
                                                                                                aju ajuVar4 = new aju(AdEvent.AdEventType.LOG, cVar);
                                                                                                ajuVar4.c = bmVar.logData.constructMap();
                                                                                                ajvVar.b(ajuVar4);
                                                                                                break;
                                                                                            case 47:
                                                                                                ajvVar.b(new aju(AdEvent.AdEventType.MIDPOINT, cVar));
                                                                                                break;
                                                                                            case 48:
                                                                                                break;
                                                                                            case 49:
                                                                                                ajvVar.h(bmVar.url);
                                                                                                break;
                                                                                            default:
                                                                                                switch (ordinal2) {
                                                                                                    case 63:
                                                                                                        aju ajuVar5 = new aju(AdEvent.AdEventType.SKIPPED, null);
                                                                                                        ajuVar5.f = bmVar.seekTime;
                                                                                                        ajvVar.b(ajuVar5);
                                                                                                        break;
                                                                                                    case 64:
                                                                                                        ajvVar.b(new aju(AdEvent.AdEventType.SKIPPABLE_STATE_CHANGED, cVar));
                                                                                                        break;
                                                                                                    case 65:
                                                                                                        ajvVar.b(new aju(AdEvent.AdEventType.STARTED, cVar));
                                                                                                        break;
                                                                                                    default:
                                                                                                        switch (ordinal2) {
                                                                                                            case 73:
                                                                                                                break;
                                                                                                            case 74:
                                                                                                                ajvVar.b(new aju(AdEvent.AdEventType.TAPPED, cVar));
                                                                                                                break;
                                                                                                            case 75:
                                                                                                                ajvVar.b(new aju(AdEvent.AdEventType.ICON_TAPPED, null));
                                                                                                                break;
                                                                                                            default:
                                                                                                                s(ajp.adsManager.toString(), b);
                                                                                                                break;
                                                                                                        }
                                                                                                }
                                                                                        }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            ajvVar.b(new aju(AdEvent.AdEventType.ICON_FALLBACK_IMAGE_CLOSED, null));
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        ajvVar.b(new aju(AdEvent.AdEventType.FIRST_QUARTILE, cVar));
                                                                        break;
                                                                    }
                                                                } else {
                                                                    ajvVar.f(AdError.AdErrorType.PLAY, bmVar.errorCode, q(bmVar.errorMessage, bmVar.innerError));
                                                                    break;
                                                                }
                                                            } else {
                                                                ajvVar.b(new aju(AdEvent.AdEventType.CONTENT_RESUME_REQUESTED, null));
                                                                break;
                                                            }
                                                        } else {
                                                            ajvVar.b(new aju(AdEvent.AdEventType.CONTENT_PAUSE_REQUESTED, null));
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    ajvVar.b(new aju(AdEvent.AdEventType.THIRD_QUARTILE, cVar));
                                                    break;
                                                }
                                            } else {
                                                ajvVar.b(new aju(AdEvent.AdEventType.RESUMED, cVar));
                                                break;
                                            }
                                        } else {
                                            ajvVar.b(new aju(AdEvent.AdEventType.PAUSED, cVar));
                                            break;
                                        }
                                    } else if (cVar != null) {
                                        ajvVar.b(new aju(AdEvent.AdEventType.LOADED, cVar));
                                        break;
                                    } else {
                                        com.google.ads.interactivemedia.v3.impl.data.m.a("Ad loaded message requires adData");
                                        ajvVar.g(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Ad loaded message did not contain adData.");
                                        break;
                                    }
                                } else {
                                    aju ajuVar6 = new aju(AdEvent.AdEventType.CUEPOINTS_CHANGED, null);
                                    ajuVar6.d = new ArrayList();
                                    for (com.google.ads.interactivemedia.v3.impl.data.bb bbVar : bmVar.cuepoints) {
                                        ajuVar6.d.add(new aji(bbVar.start(), bbVar.end(), bbVar.played()));
                                    }
                                    ajvVar.b(ajuVar6);
                                    break;
                                }
                            } else {
                                ajvVar.b(new aju(AdEvent.AdEventType.COMPLETED, cVar));
                                break;
                            }
                        } else {
                            ajvVar.b(new aju(AdEvent.AdEventType.CLICKED, cVar));
                            break;
                        }
                    } else {
                        ajvVar.b(new aju(AdEvent.AdEventType.ALL_ADS_COMPLETED, null));
                        break;
                    }
                }
                break;
            case 3:
            case 8:
            default:
                com.google.ads.interactivemedia.v3.impl.data.m.a("Unknown message channel: ".concat(String.valueOf(ajrVar.a())));
                break;
            case 4:
                ajb ajbVar = (ajb) this.c.get(f);
                ajv ajvVar2 = (ajv) this.e.get(f);
                akw akwVar = (akw) this.f.get(f);
                if (ajbVar == null || ajvVar2 == null || akwVar == null) {
                    com.google.ads.interactivemedia.v3.impl.data.m.a("Received displayContainer message: " + String.valueOf(b) + " for invalid session id: " + f);
                    break;
                } else {
                    int ordinal3 = b.ordinal();
                    if (ordinal3 == 28) {
                        if (bmVar != null && (map = bmVar.companions) != null) {
                            Set<String> keySet = map.keySet();
                            HashMap p = axo.p(keySet.size());
                            for (String str3 : keySet) {
                                CompanionAdSlot companionAdSlot = (CompanionAdSlot) ajbVar.a().get(str3);
                                ViewGroup container = companionAdSlot != null ? companionAdSlot.getContainer() : null;
                                if (container != null) {
                                    p.put(str3, container);
                                } else {
                                    ajvVar2.g(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Display requested for invalid companion slot.");
                                }
                            }
                            for (String str4 : p.keySet()) {
                                ajvVar2.i((ViewGroup) p.get(str4), (CompanionData) bmVar.companions.get(str4), f, (CompanionAdSlot) ajbVar.a().get(str4), this, new all(this.l, this.k));
                            }
                            break;
                        } else {
                            ajvVar2.g(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Display companions message requires companions in data.");
                            break;
                        }
                    } else if (ordinal3 != 38 && ordinal3 != 62) {
                        if (ordinal3 != 59) {
                            if (ordinal3 != 60) {
                                s(ajp.displayContainer.toString(), b);
                                break;
                            } else {
                                ajvVar2.k();
                                break;
                            }
                        } else {
                            ajvVar2.j(bmVar.resizeAndPositionVideo);
                            break;
                        }
                    }
                }
                break;
            case 5:
            case 11:
                int ordinal4 = b.ordinal();
                if (ordinal4 != 42) {
                    if (ordinal4 != 46) {
                        s("other", b);
                        break;
                    } else if (bmVar.ln != null && (str = bmVar.n) != null && (str2 = bmVar.m) != null) {
                        String str5 = "JsMessage (" + str + "): " + str2;
                        char charAt = bmVar.ln.charAt(0);
                        if (charAt != 'D') {
                            if (charAt != 'E') {
                                if (charAt != 'I') {
                                    if (charAt != 'S') {
                                        if (charAt != 'V') {
                                            if (charAt != 'W') {
                                                com.google.ads.interactivemedia.v3.impl.data.m.d("Unrecognized log level: ".concat(String.valueOf(bmVar.ln)));
                                                com.google.ads.interactivemedia.v3.impl.data.m.d(str5);
                                                break;
                                            } else {
                                                com.google.ads.interactivemedia.v3.impl.data.m.d(str5);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            com.google.ads.interactivemedia.v3.impl.data.m.a(str5);
                            break;
                        }
                        com.google.ads.interactivemedia.v3.impl.data.m.c(str5);
                        break;
                    } else {
                        com.google.ads.interactivemedia.v3.impl.data.m.a("Invalid logging message data: ".concat(String.valueOf(bmVar)));
                        break;
                    }
                } else {
                    this.o.trySetResult(bmVar);
                    this.s = true;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = this.r;
                    HashMap p2 = axo.p(1);
                    p2.put("webViewLoadingTime", Long.valueOf(elapsedRealtime - j));
                    o(new ajr(ajp.webViewLoaded, ajq.csi, f, p2));
                    break;
                }
            case 6:
                akl aklVar = this.p;
                if (aklVar != null) {
                    aklVar.c(b, f, bmVar.networkRequest);
                    break;
                } else {
                    com.google.ads.interactivemedia.v3.impl.data.m.a("Native network handler not initialized.");
                    break;
                }
            case 7:
                if (this.q == null) {
                    com.google.ads.interactivemedia.v3.impl.data.m.a("Null 'omidManagerListener': cannot send 'onOmidMessage'.");
                    break;
                } else {
                    int ordinal5 = b.ordinal();
                    if (ordinal5 == 50) {
                        this.q.b();
                        break;
                    } else if (ordinal5 == 51) {
                        this.q.a();
                        break;
                    }
                }
                break;
            case 9:
                r(ajp.videoDisplay1, b, f, bmVar);
                break;
            case 10:
                r(ajp.videoDisplay2, b, f, bmVar);
                break;
        }
    }

    public final void l() {
        this.i.b();
    }

    public final void m(String str) {
        this.a.remove(str);
        this.b.add(str);
    }

    public final void n(String str) {
        this.d.remove(str);
        this.e.remove(str);
        this.c.remove(str);
        this.f.remove(str);
    }

    public final void o(ajr ajrVar) {
        com.google.ads.interactivemedia.v3.impl.data.m.c("Sending js message: " + ajrVar.a().name() + " [" + ajrVar.b().name() + "]");
        this.j.add(ajrVar);
        if (!this.s) {
            return;
        }
        while (true) {
            ajr ajrVar2 = (ajr) this.j.poll();
            if (ajrVar2 == null) {
                return;
            } else {
                this.i.h(ajrVar2);
            }
        }
    }

    public final /* synthetic */ void p() {
        com.google.ads.interactivemedia.v3.impl.data.bm bmVar = (com.google.ads.interactivemedia.v3.impl.data.bm) this.o.getTask().getResult();
        com.google.ads.interactivemedia.v3.impl.data.bg bgVar = (com.google.ads.interactivemedia.v3.impl.data.bg) this.n.getTask().getResult();
        Context context = this.g;
        this.p = new akl(this, this.l, bmVar.enableGks ? new akk(context, bgVar) : new aki(null));
    }
}

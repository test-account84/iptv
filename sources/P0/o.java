package P0;

import P0.a;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class o {
    public static final a.b a = new a.b("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");
    public static final a.b b = new a.b("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");
    public static final a.e c = new a.e("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");
    public static final a.c d = new a.c("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");
    public static final a.f e = new a.f("START_SAFE_BROWSING", "START_SAFE_BROWSING");
    public static final a.f f = new a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");
    public static final a.f g = new a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");
    public static final a.f h = new a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");
    public static final a.f i = new a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");
    public static final a.f j = new a.f("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");
    public static final a.c k = new a.c("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");
    public static final a.c l = new a.c("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");
    public static final a.c m = new a.c("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");
    public static final a.c n = new a.c("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");
    public static final a.c o = new a.c("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");
    public static final a.c p = new a.c("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");
    public static final a.b q = new a.b("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");
    public static final a.b r = new a.b("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");
    public static final a.c s = new a.c("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");
    public static final a.f t = new a.f("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");
    public static final a.c u = new a.c("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");
    public static final a.b v = new a.b("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");
    public static final a.b w = new a.b("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");
    public static final a.f x = new a.f("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");
    public static final a.f y = new a.f("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");
    public static final a.f z = new a.f("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
    public static final a.b A = new a.b("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");
    public static final a.b B = new a.b("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");
    public static final a.b C = new a.b("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
    public static final a.b D = new a.b("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");
    public static final a.b E = new a.b("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");
    public static final a.b F = new a.b("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");
    public static final a.e G = new a.e("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");
    public static final a.e H = new a.e("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");
    public static final a.h I = new a.h("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");
    public static final a.h J = new a.h("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");
    public static final a.g K = new a.g("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");
    public static final a.h L = new a.h("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");
    public static final a.d M = new a.d("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
    public static final a.d N = new a.d("SUPPRESS_ERROR_PAGE", "SUPPRESS_ERROR_PAGE");
    public static final a.d O = new a.d("MULTI_PROCESS", "MULTI_PROCESS_QUERY");
    public static final a.d P = new a.d("FORCE_DARK", "FORCE_DARK");
    public static final a.d Q = new a.d("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
    public static final a.d R = new a.d("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
    public static final a.d S = new a.d("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
    public static final a.d T = new a.d("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
    public static final a.d U = new a.d("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");
    public static final a.d V = new a.d("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");
    public static final a.d W = new a.d("REQUESTED_WITH_HEADER_CONTROL", "REQUESTED_WITH_HEADER_CONTROL");
    public static final a.d X = new a.d("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");

    public static UnsupportedOperationException a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    public static boolean b(String str) {
        return c(str, a.d());
    }

    public static boolean c(String str, Collection collection) {
        HashSet hashSet = new HashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (iVar.a().equals(str)) {
                hashSet.add(iVar);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException("Unknown feature " + str);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            if (((i) it2.next()).isSupported()) {
                return true;
            }
        }
        return false;
    }
}

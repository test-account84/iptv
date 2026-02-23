package Z2;

import android.net.Uri;
import android.text.TextUtils;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class l {
    public static StreamRequest a(Uri uri) {
        StreamRequest.StreamFormat streamFormat;
        if (!"ssai".equals(uri.getScheme()) || !"dai.google.com".equals(uri.getAuthority())) {
            throw new IllegalArgumentException("Invalid URI scheme or authority.");
        }
        String queryParameter = uri.getQueryParameter("assetKey");
        String queryParameter2 = uri.getQueryParameter("apiKey");
        StreamRequest createLiveStreamRequest = !TextUtils.isEmpty(queryParameter) ? ImaSdkFactory.getInstance().createLiveStreamRequest(queryParameter, queryParameter2) : ImaSdkFactory.getInstance().createVodStreamRequest((String) d4.a.e(uri.getQueryParameter("contentSourceId")), (String) d4.a.e(uri.getQueryParameter("videoId")), queryParameter2);
        int parseInt = Integer.parseInt(uri.getQueryParameter("format"));
        if (parseInt == 0) {
            streamFormat = StreamRequest.StreamFormat.DASH;
        } else {
            if (parseInt != 2) {
                throw new IllegalArgumentException("Unsupported stream format:" + parseInt);
            }
            streamFormat = StreamRequest.StreamFormat.HLS;
        }
        createLiveStreamRequest.setFormat(streamFormat);
        String queryParameter3 = uri.getQueryParameter("adTagParameters");
        if (!TextUtils.isEmpty(queryParameter3)) {
            HashMap hashMap = new HashMap();
            Uri parse = Uri.parse(queryParameter3);
            for (String str : parse.getQueryParameterNames()) {
                String queryParameter4 = parse.getQueryParameter(str);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    hashMap.put(str, queryParameter4);
                }
            }
            createLiveStreamRequest.setAdTagParameters(hashMap);
        }
        String queryParameter5 = uri.getQueryParameter("manifestSuffix");
        if (queryParameter5 != null) {
            createLiveStreamRequest.setManifestSuffix(queryParameter5);
        }
        String queryParameter6 = uri.getQueryParameter("contentUrl");
        if (queryParameter6 != null) {
            createLiveStreamRequest.setContentUrl(queryParameter6);
        }
        String queryParameter7 = uri.getQueryParameter("authToken");
        if (queryParameter7 != null) {
            createLiveStreamRequest.setAuthToken(queryParameter7);
        }
        String queryParameter8 = uri.getQueryParameter("streamActivityMonitorId");
        if (queryParameter8 != null) {
            createLiveStreamRequest.setStreamActivityMonitorId(queryParameter8);
        }
        return createLiveStreamRequest;
    }

    public static String b(Uri uri) {
        return (String) d4.a.e(uri.getQueryParameter("adsId"));
    }

    public static int c(Uri uri) {
        String queryParameter = uri.getQueryParameter("loadVideoTimeoutMs");
        if (TextUtils.isEmpty(queryParameter)) {
            return 10000;
        }
        return Integer.parseInt(queryParameter);
    }

    public static boolean d(Uri uri) {
        return !TextUtils.isEmpty(uri.getQueryParameter("assetKey"));
    }
}

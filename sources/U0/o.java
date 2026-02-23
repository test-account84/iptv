package u0;

import android.media.MediaRouter2;
import android.media.RouteDiscoveryPreference;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract /* synthetic */ class o {
    public static /* bridge */ /* synthetic */ void a(MediaRouter2 mediaRouter2, Executor executor, MediaRouter2.RouteCallback routeCallback, RouteDiscoveryPreference routeDiscoveryPreference) {
        mediaRouter2.registerRouteCallback(executor, routeCallback, routeDiscoveryPreference);
    }
}

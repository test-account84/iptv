package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.l;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RouteDatabase {
    private final Set failedRoutes = new LinkedHashSet();

    public final synchronized void connected(@NotNull Route route) {
        l.e(route, "route");
        this.failedRoutes.remove(route);
    }

    public final synchronized void failed(@NotNull Route failedRoute) {
        l.e(failedRoute, "failedRoute");
        this.failedRoutes.add(failedRoute);
    }

    public final synchronized boolean shouldPostpone(@NotNull Route route) {
        l.e(route, "route");
        return this.failedRoutes.contains(route);
    }
}

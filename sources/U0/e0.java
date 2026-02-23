package u0;

import android.media.MediaRouter;
import android.util.Log;
import android.view.Display;
import u0.d0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e0 {

    public interface a extends d0.a {
        void i(Object obj);
    }

    public static class b extends d0.b {
        public b(a aVar) {
            super(aVar);
        }

        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            ((a) this.a).i(routeInfo);
        }
    }

    public static final class c {
        public static Display a(Object obj) {
            try {
                return ((MediaRouter.RouteInfo) obj).getPresentationDisplay();
            } catch (NoSuchMethodError e) {
                Log.w("MediaRouterJellybeanMr1", "Cannot get presentation display for the route.", e);
                return null;
            }
        }

        public static boolean b(Object obj) {
            return ((MediaRouter.RouteInfo) obj).isEnabled();
        }
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }
}

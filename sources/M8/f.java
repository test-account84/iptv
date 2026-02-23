package M8;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class f {
    public static final b a = new c(null);

    public interface b {
        void a(ViewGroup viewGroup, View view, Rect rect);
    }

    public static class c implements b {
        public c() {
        }

        public void a(ViewGroup viewGroup, View view, Rect rect) {
            g.b(viewGroup, view, rect);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        b(viewGroup, view, rect);
    }

    public static void b(ViewGroup viewGroup, View view, Rect rect) {
        a.a(viewGroup, view, rect);
    }
}

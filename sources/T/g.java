package T;

import android.widget.ListView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g {

    public static class a {
        public static boolean a(ListView listView, int i) {
            return listView.canScrollList(i);
        }

        public static void b(ListView listView, int i) {
            listView.scrollListBy(i);
        }
    }

    public static void a(ListView listView, int i) {
        a.b(listView, i);
    }
}

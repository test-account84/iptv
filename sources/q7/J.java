package q7;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class j extends BaseAdapter {
    public final String a;
    public List c;
    public List d;
    public LayoutInflater e;
    public Context f;
    public DatabaseHandler g;
    public a h;

    public static class a {
        public TextView a;
        public ImageView b;
        public LinearLayout c;
    }

    public j(Context context, List list, String str) {
        this.d = list;
        this.c = list;
        this.f = context;
        this.e = LayoutInflater.from(context);
        this.g = new DatabaseHandler(context);
        this.a = str;
    }

    public int getCount() {
        return this.d.size();
    }

    public Object getItem(int i) {
        return this.d.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00fc A[Catch: Exception -> 0x0077, TryCatch #0 {Exception -> 0x0077, blocks: (B:5:0x0051, B:7:0x006c, B:8:0x0072, B:9:0x00f6, B:11:0x00fc, B:13:0x0106, B:14:0x010c, B:17:0x0110, B:18:0x0119, B:19:0x007a, B:21:0x0080, B:23:0x008a, B:25:0x009a, B:28:0x00ab, B:29:0x00b2, B:30:0x00b9, B:32:0x00c9, B:35:0x00da, B:36:0x00e1, B:37:0x00e8, B:39:0x00ee), top: B:4:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0119 A[Catch: Exception -> 0x0077, TRY_LEAVE, TryCatch #0 {Exception -> 0x0077, blocks: (B:5:0x0051, B:7:0x006c, B:8:0x0072, B:9:0x00f6, B:11:0x00fc, B:13:0x0106, B:14:0x010c, B:17:0x0110, B:18:0x0119, B:19:0x007a, B:21:0x0080, B:23:0x008a, B:25:0x009a, B:28:0x00ab, B:29:0x00b2, B:30:0x00b9, B:32:0x00c9, B:35:0x00da, B:36:0x00e1, B:37:0x00e8, B:39:0x00ee), top: B:4:0x0051 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r4, android.view.View r5, android.view.ViewGroup r6) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.j.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}

package q7;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class k extends BaseAdapter {
    public List a;
    public List d;
    public LayoutInflater e;
    public Context f;
    public DatabaseHandler g;
    public a h;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public List i = new ArrayList();
    public List j = new ArrayList();
    public List c = new ArrayList();

    public static class a {
        public TextView a;
        public TextView b;
        public TextView c;
        public ImageView d;
        public LinearLayout e;
    }

    public k(Context context, List list) {
        this.d = list;
        this.a = list;
        this.f = context;
        this.e = LayoutInflater.from(context);
        this.g = new DatabaseHandler(context);
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x00d8 A[Catch: Exception -> 0x00b6, TryCatch #1 {Exception -> 0x00b6, blocks: (B:5:0x0081, B:7:0x00ac, B:8:0x00b2, B:9:0x00d2, B:11:0x00d8, B:13:0x00e2, B:14:0x00e8, B:17:0x00ec, B:18:0x00f5, B:19:0x00b8, B:21:0x00be, B:22:0x00c5, B:24:0x00cb), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f5 A[Catch: Exception -> 0x00b6, TRY_LEAVE, TryCatch #1 {Exception -> 0x00b6, blocks: (B:5:0x0081, B:7:0x00ac, B:8:0x00b2, B:9:0x00d2, B:11:0x00d8, B:13:0x00e2, B:14:0x00e8, B:17:0x00ec, B:18:0x00f5, B:19:0x00b8, B:21:0x00be, B:22:0x00c5, B:24:0x00cb), top: B:4:0x0081 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r4, android.view.View r5, android.view.ViewGroup r6) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.k.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}

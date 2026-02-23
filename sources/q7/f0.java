package q7;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class f0 extends androidx.fragment.app.r {
    public Context h;
    public final int i;
    public String[] j;
    public String[] k;
    public Map l;
    public androidx.fragment.app.m m;

    public f0(List list, androidx.fragment.app.m mVar, Context context) {
        super(mVar);
        this.m = mVar;
        this.l = new HashMap();
        int size = list.size();
        this.i = size;
        this.j = new String[size];
        this.k = new String[size];
        this.h = context;
        for (int i = 0; i < this.i; i++) {
            String liveStreamCategoryName = ((LiveStreamCategoryIdDBModel) list.get(i)).getLiveStreamCategoryName();
            String liveStreamCategoryID = ((LiveStreamCategoryIdDBModel) list.get(i)).getLiveStreamCategoryID();
            this.j[i] = liveStreamCategoryName;
            this.k[i] = liveStreamCategoryID;
        }
    }

    public int c() {
        return this.i;
    }

    public CharSequence e(int i) {
        return this.j[i];
    }

    public Object g(ViewGroup viewGroup, int i) {
        Object g = super.g(viewGroup, i);
        if (g instanceof Fragment) {
            this.l.put(Integer.valueOf(i), ((Fragment) g).getTag());
        }
        return g;
    }

    public Fragment p(int i) {
        return s7.j.Z(this.k[i]);
    }
}

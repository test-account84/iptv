package q7;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class e extends RecyclerView.g {
    public Context d;
    public ArrayList e;
    public I f;

    public e(Context context, ArrayList arrayList) {
        this.d = context;
        this.e = arrayList;
    }

    public void j0(List list) {
        this.e.clear();
        this.e.addAll(list);
        w();
    }

    public void k0(I i) {
        this.f = i;
    }
}

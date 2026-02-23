package a8;

import V7.c;
import V7.d;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import d.D;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b extends RecyclerView.g {
    public final Context d;
    public final List e;

    public class a extends RecyclerView.D {
        public final View t;
        public final TextView u;

        public a(View view) {
            super(view);
            this.t = view;
            this.u = view.findViewById(c.m);
        }
    }

    public b(Context context, List list) {
        this.d = context;
        this.e = list;
    }

    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void E(a aVar, int i) {
        View view = aVar.t;
        D.a(this.e.get(i));
        throw null;
    }

    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a L(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(d.b, viewGroup, false));
    }

    public int n() {
        return this.e.size();
    }
}

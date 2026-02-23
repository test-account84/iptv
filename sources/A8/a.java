package a8;

import V7.c;
import V7.d;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a implements Z7.a {
    public final Context a;
    public final List b = new ArrayList();
    public PopupWindow c;

    public a(Context context) {
        this.a = context;
    }

    public void a(View view) {
        PopupWindow b = b();
        this.c = b;
        b.showAsDropDown(view, 0, (-this.a.getResources().getDimensionPixelSize(V7.a.a)) * 4);
        if (this.b.size() == 0) {
            Log.e(Z7.a.class.getName(), "The menu is empty");
        }
    }

    public final PopupWindow b() {
        LayoutInflater layoutInflater = (LayoutInflater) this.a.getSystemService("layout_inflater");
        if (layoutInflater == null) {
            throw new RuntimeException("can't access LAYOUT_INFLATER_SERVICE");
        }
        View inflate = layoutInflater.inflate(d.c, (ViewGroup) null);
        c((RecyclerView) inflate.findViewById(c.k));
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setFocusable(true);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setContentView(inflate);
        return popupWindow;
    }

    public final void c(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.a));
        recyclerView.setAdapter(new b(this.a, this.b));
    }
}

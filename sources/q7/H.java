package q7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class h extends BaseAdapter {
    public List a;
    public List c;
    public LayoutInflater d;
    public Context e;
    public DatabaseHandler f;
    public a g;

    public static class a {
        public TextView a;
        public ImageView b;
        public LinearLayout c;
    }

    public h(Context context, List list) {
        this.c = list;
        this.a = list;
        this.e = context;
        this.d = LayoutInflater.from(context);
        this.f = new DatabaseHandler(context);
    }

    public int getCount() {
        return this.c.size();
    }

    public Object getItem(int i) {
        return this.c.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        int i2;
        if (view == null) {
            try {
                view = ((LayoutInflater) this.e.getSystemService("layout_inflater")).inflate(a7.g.u4, (ViewGroup) null);
                a aVar = new a();
                this.g = aVar;
                aVar.a = view.findViewById(a7.f.I6);
                this.g.b = view.findViewById(a7.f.Xj);
                this.g.c = view.findViewById(a7.f.H8);
                view.setTag(this.g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.g = (a) view.getTag();
        }
        try {
            if (((String) this.c.get(i)).endsWith(".m3u") || ((String) this.c.get(i)).endsWith(".m3u8")) {
                imageView = this.g.b;
                i2 = a7.e.T0;
            } else {
                imageView = this.g.b;
                i2 = a7.e.a0;
            }
            imageView.setBackgroundResource(i2);
            this.g.a.setText((CharSequence) this.c.get(i));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return view;
    }
}

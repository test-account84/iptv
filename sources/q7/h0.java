package q7;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.Mylist;
import com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class h0 extends e {
    public static u7.a p;
    public boolean g;
    public int h;
    public int i;
    public String j;
    public Boolean k;
    public long l;
    public String m;
    public ArrayList n;
    public ArrayList o;

    public class a implements View.OnClickListener {
        public final /* synthetic */ e7.f a;

        public a(e7.f fVar) {
            this.a = fVar;
        }

        public void onClick(View view) {
            Uri parse;
            Intent intent;
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                if (Build.VERSION.SDK_INT >= 24) {
                    intent2.setFlags(1);
                    File file = new File(this.a.x());
                    h0.this.l = file.length() / 1048576;
                    parse = Uri.fromFile(file);
                } else {
                    parse = Uri.parse("file://" + this.a.x());
                }
                intent2.setDataAndType(parse, "video/mp4");
                String substring = this.a.x().substring(0, this.a.x().lastIndexOf("."));
                h0.this.m = substring.substring(substring.lastIndexOf("/") + 1);
                if (!a7.o.a(h0.this.d, intent2)) {
                    a7.n.a(h0.this.d).c(h0.this.d.getString(a7.j.I8));
                    return;
                }
                h0 h0Var = h0.this;
                if (h0Var.d == null || !h0.l0(h0Var).booleanValue()) {
                    return;
                }
                h0.n0(new u7.a(h0.this.d));
                if (h0.m0().x() == 3) {
                    h0.m0().U("Hardware Decoder");
                    intent = new Intent(h0.this.d, HoneyPlayer.class);
                } else {
                    intent = new Intent(h0.this.d, HoneyPlayer.class);
                }
                intent.putExtra("type", "devicedata");
                intent.putExtra("VIDEO_NUM", 0);
                intent.putExtra("VIDEO_PATH", this.a.x());
                h0.this.d.startActivity(intent);
            } catch (Exception e) {
                a7.n.a(h0.this.d).c(e.getMessage());
            }
        }
    }

    public class b extends RecyclerView.D {
        public ImageView t;
        public TextView u;
        public TextView v;
        public TextView w;
        public TextView x;

        public b(View view) {
            super(view);
            this.t = view.findViewById(a7.f.f6);
            TextView findViewById = view.findViewById(a7.f.wm);
            this.x = findViewById;
            findViewById.setSelected(true);
            this.v = view.findViewById(a7.f.xm);
            this.w = view.findViewById(a7.f.ek);
            this.u = view.findViewById(a7.f.vm);
        }

        public static /* synthetic */ ImageView P(b bVar) {
            return bVar.t;
        }

        public static /* synthetic */ TextView Q(b bVar) {
            return bVar.w;
        }

        public static /* synthetic */ TextView R(b bVar) {
            return bVar.u;
        }

        public static /* synthetic */ TextView S(b bVar) {
            return bVar.x;
        }

        public static /* synthetic */ TextView T(b bVar) {
            return bVar.v;
        }
    }

    public h0(Context context, ArrayList arrayList, boolean z, int i) {
        super(context, arrayList);
        this.i = 0;
        this.k = Boolean.TRUE;
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.g = z;
        this.h = i;
    }

    public static /* synthetic */ Boolean l0(h0 h0Var) {
        return h0Var.k;
    }

    public static /* synthetic */ u7.a m0() {
        return p;
    }

    public static /* synthetic */ u7.a n0(u7.a aVar) {
        p = aVar;
        return aVar;
    }

    public int n() {
        return this.e.size();
    }

    public boolean p0() {
        return this.i >= this.h;
    }

    public ArrayList q0(ArrayList arrayList) {
        this.n = arrayList;
        return arrayList;
    }

    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void E(b bVar, int i) {
        b.P(bVar).setVisibility(0);
        e7.f fVar = (e7.f) (this.g ? this.e.get(i - 1) : this.e.get(i));
        try {
            O1.g.u(this.d).q(fVar.x()).l(b.P(bVar));
        } catch (Exception unused) {
        }
        fVar.C();
        ((RecyclerView.D) bVar).a.setOnClickListener(new a(fVar));
        try {
            ((Mylist) this.n.get(i)).getName();
            ((Mylist) this.n.get(i)).getSize();
            ((Mylist) this.n.get(i)).getModified_date();
            ((Mylist) this.n.get(i)).getDuration();
            ((Mylist) this.n.get(i)).getExtension();
            ((Mylist) this.n.get(i)).getFrame_height();
            ((Mylist) this.n.get(i)).getFrmae_width();
            b.Q(bVar).setText("Modified:" + new Date(((Mylist) this.n.get(i)).getModified_date()));
            b.R(bVar).setText("Duration: " + ((Mylist) this.n.get(i)).getDuration());
            b.S(bVar).setText(((Mylist) this.n.get(i)).getName());
            b.T(bVar).setText("Size: " + ((Mylist) this.n.get(i)).getSize() + " video/" + ((Mylist) this.n.get(i)).getExtension() + " " + ((Mylist) this.n.get(i)).getFrmae_width() + "x" + ((Mylist) this.n.get(i)).getFrame_height());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public b L(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.d).inflate(a7.g.c5, viewGroup, false);
        inflate.getLayoutParams();
        return new b(inflate);
    }

    public void t0(int i) {
        this.i = i;
    }

    public h0(Context context, boolean z, int i) {
        this(context, new ArrayList(), z, i);
    }
}

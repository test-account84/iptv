package q7;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.database.EPGSourcesModel;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class m extends RecyclerView.g {
    public final LiveStreamDBHandler d;
    public Context e;
    public ArrayList f;
    public b g;
    public u7.a h;
    public String i;

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            if (m.j0(m.this) instanceof EPGSettingsActivity) {
                m.j0(m.this).L1((EPGSourcesModel) m.k0(m.this).get(this.a));
            }
        }
    }

    public static class b extends RecyclerView.D {
        public LinearLayout A;
        public TextView B;
        public TextView t;
        public TextView u;
        public ImageView v;
        public LinearLayout w;
        public LinearLayout x;
        public LinearLayout y;
        public TextView z;

        public b(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Ml);
            this.u = view.findViewById(a7.f.Nl);
            this.v = view.findViewById(a7.f.Q4);
            this.w = view.findViewById(a7.f.H8);
            this.x = view.findViewById(a7.f.Aa);
            this.y = view.findViewById(a7.f.ia);
            this.z = view.findViewById(a7.f.Rl);
            this.A = view.findViewById(a7.f.ka);
            this.B = view.findViewById(a7.f.Lj);
            J(false);
        }
    }

    public m(Context context, ArrayList arrayList) {
        this.i = "mobile";
        ArrayList arrayList2 = new ArrayList();
        this.f = arrayList2;
        arrayList2.addAll(arrayList);
        this.e = context;
        this.d = new LiveStreamDBHandler(context);
        u7.a aVar = new u7.a(context);
        this.h = aVar;
        if (aVar.A().equals(m7.a.K0)) {
            this.i = "tv";
        } else {
            this.i = "mobile";
        }
    }

    public static /* synthetic */ Context j0(m mVar) {
        return mVar.e;
    }

    public static /* synthetic */ ArrayList k0(m mVar) {
        return mVar.f;
    }

    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void E(b bVar, int i) {
        TextView textView;
        Resources resources;
        int i2;
        if (this.e != null) {
            int idAuto = ((EPGSourcesModel) this.f.get(i)).getIdAuto();
            bVar.w.setBackground(this.e.getResources().getDrawable(a7.e.y1));
            if (((EPGSourcesModel) this.f.get(i)).getDefault_source().equals("1")) {
                String name = ((EPGSourcesModel) this.f.get(i)).getName();
                if (((EPGSourcesModel) this.f.get(i)).getSource_type().equals("panel")) {
                    if (m7.a.t.booleanValue()) {
                        bVar.t.setText(name + " - " + this.e.getResources().getString(a7.j.w2) + " " + this.e.getResources().getString(a7.j.G0));
                    } else {
                        bVar.t.setText(this.e.getResources().getString(a7.j.w2) + " " + this.e.getResources().getString(a7.j.G0));
                    }
                    bVar.u.setVisibility(8);
                } else {
                    bVar.t.setText(name + " " + this.e.getResources().getString(a7.j.G0));
                    bVar.u.setVisibility(0);
                }
                bVar.v.setVisibility(0);
                bVar.v.setImageResource(a7.e.g0);
                EPGSettingsActivity ePGSettingsActivity = this.e;
                if (ePGSettingsActivity instanceof EPGSettingsActivity) {
                    ePGSettingsActivity.T1(name);
                }
            } else {
                String name2 = ((EPGSourcesModel) this.f.get(i)).getName();
                bVar.v.setImageResource(a7.e.P);
                bVar.v.setVisibility(8);
                bVar.x.setVisibility(8);
                bVar.y.setVisibility(8);
                bVar.A.setVisibility(8);
                bVar.B.setVisibility(8);
                if (((EPGSourcesModel) this.f.get(i)).getSource_type().equals("panel")) {
                    if (m7.a.t.booleanValue()) {
                        bVar.t.setText(name2 + " - " + this.e.getResources().getString(a7.j.w2));
                    } else {
                        bVar.t.setText(this.e.getResources().getString(a7.j.w2));
                    }
                    bVar.u.setVisibility(8);
                } else {
                    bVar.t.setText(name2);
                    bVar.u.setVisibility(0);
                }
            }
            ImportStatusModel importStatusModel = this.d.getdateDBStatus("epg", String.valueOf(idAuto));
            if (importStatusModel != null) {
                if (importStatusModel.getStatus() == null || !importStatusModel.getStatus().equals("3")) {
                    if (importStatusModel.getStatus() == null || !importStatusModel.getStatus().equals("1")) {
                        if ((importStatusModel.getStatus() != null && importStatusModel.getStatus().equals("0")) || importStatusModel.getStatus() == null || !importStatusModel.getStatus().equals("2")) {
                            bVar.x.setVisibility(8);
                            bVar.y.setVisibility(0);
                            textView = bVar.z;
                            resources = this.e.getResources();
                            i2 = a7.j.G4;
                        }
                        textView.setText(resources.getString(i2));
                        bVar.z.setTextColor(this.e.getResources().getColor(a7.c.y));
                        bVar.A.setVisibility(0);
                        bVar.B.setVisibility(8);
                    } else {
                        bVar.x.setVisibility(8);
                        bVar.y.setVisibility(0);
                        bVar.z.setText(this.e.getResources().getString(a7.j.g1));
                        bVar.z.setTextColor(this.e.getResources().getColor(a7.c.q));
                        long currentTimeMillis = (importStatusModel.getTime() == null || importStatusModel.getTime().equals("")) ? 0L : System.currentTimeMillis() - Long.parseLong(importStatusModel.getTime());
                        bVar.B.setText(this.e.getResources().getString(a7.j.S2) + " " + m7.w.R0(currentTimeMillis));
                        bVar.B.setVisibility(0);
                        bVar.A.setVisibility(0);
                    }
                } else if (System.currentTimeMillis() - Long.parseLong(importStatusModel.getTime()) <= 600000) {
                    bVar.x.setVisibility(0);
                    bVar.y.setVisibility(8);
                    bVar.A.setVisibility(0);
                    bVar.B.setVisibility(8);
                }
                bVar.x.setVisibility(8);
                bVar.y.setVisibility(0);
                textView = bVar.z;
                resources = this.e.getResources();
                i2 = a7.j.E0;
                textView.setText(resources.getString(i2));
                bVar.z.setTextColor(this.e.getResources().getColor(a7.c.y));
                bVar.A.setVisibility(0);
                bVar.B.setVisibility(8);
            }
            bVar.u.setText(((EPGSourcesModel) this.f.get(i)).getEpgurl());
            bVar.w.setOnClickListener(new a(i));
        }
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public b L(ViewGroup viewGroup, int i) {
        LayoutInflater from;
        int i2;
        if (this.i.equals(m7.a.K0)) {
            from = LayoutInflater.from(viewGroup.getContext());
            i2 = a7.g.E2;
        } else {
            from = LayoutInflater.from(viewGroup.getContext());
            i2 = a7.g.D2;
        }
        b bVar = new b(from.inflate(i2, viewGroup, false));
        this.g = bVar;
        return bVar;
    }

    public int n() {
        return this.f.size();
    }
}

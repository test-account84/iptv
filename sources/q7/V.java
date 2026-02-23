package q7;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.XMLTVProgrammePojo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import k.U;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class v extends RecyclerView.g {
    public static SharedPreferences p;
    public Context d;
    public List e;
    public SharedPreferences f;
    public List g;
    public List h;
    public DatabaseHandler i;
    public LiveStreamDBHandler j;
    public i k;
    public SharedPreferences l;
    public SimpleDateFormat m;
    public int n;
    public int o;

    public class d implements View.OnLongClickListener {
        public final /* synthetic */ i a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public d(i iVar, int i, String str, String str2, String str3, String str4) {
            this.a = iVar;
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
        }

        public boolean onLongClick(View view) {
            v.j0(v.this, this.a, this.c, this.d, this.e, this.f, this.g);
            return true;
        }
    }

    public class e implements View.OnLongClickListener {
        public final /* synthetic */ i a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public e(i iVar, int i, String str, String str2, String str3, String str4) {
            this.a = iVar;
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
        }

        public boolean onLongClick(View view) {
            v.j0(v.this, this.a, this.c, this.d, this.e, this.f, this.g);
            return true;
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ i a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public f(i iVar, int i, String str, String str2, String str3, String str4) {
            this.a = iVar;
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
        }

        public void onClick(View view) {
            v.j0(v.this, this.a, this.c, this.d, this.e, this.f, this.g);
        }
    }

    public class g implements U.d {
        public final /* synthetic */ i a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public g(i iVar, String str, int i, String str2, String str3, String str4) {
            this.a = iVar;
            this.b = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        public final void a() {
            FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
            favouriteDBModel.setCategoryID(this.b);
            favouriteDBModel.setStreamID(this.c);
            favouriteDBModel.setStreamIDOneStream(this.d);
            favouriteDBModel.setName(this.e);
            favouriteDBModel.setNum(this.f);
            favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(v.k0(v.this)));
            v.l0(v.this).addToFavourite(favouriteDBModel, "live");
            this.a.x.setVisibility(0);
        }

        public final void b() {
            this.a.v.performClick();
        }

        public final void c() {
            v.l0(v.this).deleteFavourite(this.c, this.b, "live", this.e, SharepreferenceDBHandler.getUserID(v.k0(v.this)), this.d);
            this.a.x.setVisibility(4);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == a7.f.Hb) {
                b();
                return false;
            }
            if (itemId == a7.f.Bb) {
                a();
                return false;
            }
            if (itemId != a7.f.Lb) {
                return false;
            }
            c();
            return false;
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ TextView c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                v vVar;
                List m0;
                if (!TextUtils.isEmpty(h.this.a)) {
                    if (!v.m0(v.this).isEmpty() || v.m0(v.this).isEmpty()) {
                        vVar = v.this;
                        m0 = v.m0(vVar);
                    }
                    if (v.q0(v.this) != null && v.q0(v.this).size() == 0) {
                        h.this.c.setVisibility(0);
                    }
                    v vVar2 = v.this;
                    vVar2.n = vVar2.o;
                    vVar2.w();
                }
                vVar = v.this;
                m0 = v.p0(vVar);
                v.r0(vVar, m0);
                if (v.q0(v.this) != null) {
                    h.this.c.setVisibility(0);
                }
                v vVar22 = v.this;
                vVar22.n = vVar22.o;
                vVar22.w();
            }
        }

        public h(String str, TextView textView) {
            this.a = str;
            this.c = textView;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r4 = this;
                q7.v r0 = q7.v.this
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                q7.v.n0(r0, r1)
                q7.v r0 = q7.v.this
                java.lang.String r1 = r4.a
                int r1 = r1.length()
                r0.o = r1
                q7.v r0 = q7.v.this
                java.util.List r0 = q7.v.m0(r0)
                if (r0 == 0) goto L25
                q7.v r0 = q7.v.this
                java.util.List r0 = q7.v.m0(r0)
                r0.clear()
            L25:
                java.lang.String r0 = r4.a
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L3d
                q7.v r0 = q7.v.this
                java.util.List r0 = q7.v.m0(r0)
                q7.v r1 = q7.v.this
                java.util.List r1 = q7.v.p0(r1)
                r0.addAll(r1)
                goto La4
            L3d:
                q7.v r0 = q7.v.this
                java.util.List r0 = q7.v.q0(r0)
                if (r0 == 0) goto L51
                q7.v r0 = q7.v.this
                java.util.List r0 = q7.v.q0(r0)
                int r0 = r0.size()
                if (r0 == 0) goto L59
            L51:
                q7.v r0 = q7.v.this
                int r1 = r0.n
                int r0 = r0.o
                if (r1 <= r0) goto L62
            L59:
                q7.v r0 = q7.v.this
                java.util.List r1 = q7.v.p0(r0)
                q7.v.r0(r0, r1)
            L62:
                q7.v r0 = q7.v.this
                java.util.List r0 = q7.v.q0(r0)
                if (r0 == 0) goto La4
                q7.v r0 = q7.v.this
                java.util.List r0 = q7.v.q0(r0)
                java.util.Iterator r0 = r0.iterator()
            L74:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto La4
                java.lang.Object r1 = r0.next()
                com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel r1 = (com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel) r1
                java.lang.String r2 = r1.getName()
                if (r2 == 0) goto L74
                java.lang.String r2 = r1.getName()
                java.lang.String r2 = r2.toLowerCase()
                java.lang.String r3 = r4.a
                java.lang.String r3 = r3.toLowerCase()
                boolean r2 = r2.contains(r3)
                if (r2 == 0) goto L74
                q7.v r2 = q7.v.this
                java.util.List r2 = q7.v.m0(r2)
                r2.add(r1)
                goto L74
            La4:
                q7.v r0 = q7.v.this
                android.content.Context r0 = q7.v.k0(r0)
                android.app.Activity r0 = (android.app.Activity) r0
                q7.v$h$a r1 = new q7.v$h$a
                r1.<init>()
                r0.runOnUiThread(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: q7.v.h.run():void");
        }
    }

    public static class i extends RecyclerView.D {
        public LinearLayout A;
        public ProgressBar B;
        public TextView C;
        public TextView D;
        public RelativeLayout E;
        public ImageView t;
        public TextView u;
        public CardView v;
        public TextView w;
        public ImageView x;
        public RelativeLayout y;
        public RelativeLayout z;

        public i(View view) {
            super(view);
            this.t = view.findViewById(a7.f.P4);
            this.u = view.findViewById(a7.f.lk);
            this.v = view.findViewById(a7.f.J1);
            this.w = view.findViewById(a7.f.Ul);
            this.x = view.findViewById(a7.f.g5);
            this.y = view.findViewById(a7.f.qf);
            this.z = view.findViewById(a7.f.de);
            this.A = view.findViewById(a7.f.O8);
            this.B = view.findViewById(a7.f.Nc);
            this.C = view.findViewById(a7.f.si);
            this.D = view.findViewById(a7.f.em);
            this.E = view.findViewById(a7.f.He);
            J(false);
        }
    }

    public v(List list, Context context) {
        this.e = list;
        this.d = context;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.addAll(list);
        this.h = list;
        this.i = new DatabaseHandler(context);
        this.j = new LiveStreamDBHandler(context);
    }

    public static /* synthetic */ void j0(v vVar, i iVar, int i2, String str, String str2, String str3, String str4) {
        vVar.z0(iVar, i2, str, str2, str3, str4);
    }

    public static /* synthetic */ Context k0(v vVar) {
        return vVar.d;
    }

    public static /* synthetic */ DatabaseHandler l0(v vVar) {
        return vVar.i;
    }

    public static /* synthetic */ List m0(v vVar) {
        return vVar.g;
    }

    public static /* synthetic */ List n0(v vVar, List list) {
        vVar.g = list;
        return list;
    }

    public static /* synthetic */ List p0(v vVar) {
        return vVar.h;
    }

    public static /* synthetic */ List q0(v vVar) {
        return vVar.e;
    }

    public static /* synthetic */ List r0(v vVar, List list) {
        vVar.e = list;
        return list;
    }

    public int n() {
        List list = this.e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void s0(String str, TextView textView) {
        new Thread(new h(str, textView)).start();
    }

    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void E(i iVar, int i2) {
        int i3;
        LiveStreamDBHandler liveStreamDBHandler;
        ArrayList epg;
        int M;
        Context context = this.d;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("selectedPlayer", 0);
            this.f = sharedPreferences;
            sharedPreferences.getString("selectedPlayer", "");
            String trim = ((LiveStreamsDBModel) this.e.get(i2)).getStreamId().trim();
            ((LiveStreamsDBModel) this.e.get(i2)).getStreamId().trim();
            try {
                i3 = Integer.parseInt(trim);
            } catch (NumberFormatException unused) {
                i3 = -1;
            }
            String categoryId = ((LiveStreamsDBModel) this.e.get(i2)).getCategoryId();
            ((LiveStreamsDBModel) this.e.get(i2)).getStreamType();
            String epgChannelId = ((LiveStreamsDBModel) this.e.get(i2)).getEpgChannelId();
            String num = ((LiveStreamsDBModel) this.e.get(i2)).getNum();
            iVar.D.setText("");
            iVar.B.setVisibility(8);
            iVar.C.setText("");
            if (epgChannelId != null && !epgChannelId.equals("") && (liveStreamDBHandler = this.j) != null && (epg = liveStreamDBHandler.getEPG(epgChannelId)) != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= epg.size()) {
                        break;
                    }
                    String start = ((XMLTVProgrammePojo) epg.get(i4)).getStart();
                    String stop = ((XMLTVProgrammePojo) epg.get(i4)).getStop();
                    String title = ((XMLTVProgrammePojo) epg.get(i4)).getTitle();
                    ((XMLTVProgrammePojo) epg.get(i4)).getDesc();
                    long x = m7.w.x(start, this.d);
                    Long valueOf = Long.valueOf(x);
                    long x2 = m7.w.x(stop, this.d);
                    Long valueOf2 = Long.valueOf(x2);
                    if (!m7.w.b0(x, x2, this.d) || (M = m7.w.M(x, x2, this.d)) == 0) {
                        i4++;
                    } else {
                        int i5 = 100 - M;
                        if (i5 == 0 || title.equals("")) {
                            iVar.D.setVisibility(8);
                            iVar.B.setVisibility(8);
                            iVar.C.setVisibility(8);
                        } else {
                            if (m7.a.M == 0) {
                                iVar.D.setVisibility(0);
                                SharedPreferences sharedPreferences2 = this.d.getSharedPreferences("timeFormat", 0);
                                p = sharedPreferences2;
                                this.m = new SimpleDateFormat(sharedPreferences2.getString("timeFormat", m7.a.E0));
                                iVar.D.setText(this.m.format(valueOf) + " - " + this.m.format(valueOf2));
                            }
                            iVar.B.setVisibility(0);
                            iVar.B.setProgress(i5);
                            iVar.C.setVisibility(0);
                            iVar.C.setText(title);
                        }
                    }
                }
            }
            ((LiveStreamsDBModel) this.e.get(i2)).getNum();
            String name = ((LiveStreamsDBModel) this.e.get(i2)).getName();
            iVar.u.setText(((LiveStreamsDBModel) this.e.get(i2)).getName());
            String streamIcon = ((LiveStreamsDBModel) this.e.get(i2)).getStreamIcon();
            ((LiveStreamsDBModel) this.e.get(i2)).getEpgChannelId();
            iVar.t.setImageDrawable((Drawable) null);
            if (streamIcon == null || streamIcon.equals("")) {
                iVar.t.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1, (Resources.Theme) null));
            } else {
                com.squareup.picasso.t.q(this.d).l(streamIcon).j(a7.e.i1).g(iVar.t);
            }
            iVar.v.setOnClickListener(new a());
            iVar.E.setOnClickListener(new b());
            iVar.y.setOnClickListener(new c());
            ArrayList checkFavourite = this.i.checkFavourite(i3, categoryId, "live", SharepreferenceDBHandler.getUserID(this.d), trim);
            if (checkFavourite == null || checkFavourite.size() <= 0) {
                iVar.x.setVisibility(4);
            } else {
                iVar.x.setVisibility(0);
            }
            int i6 = i3;
            iVar.y.setOnLongClickListener(new d(iVar, i6, categoryId, name, num, trim));
            iVar.E.setOnLongClickListener(new e(iVar, i6, categoryId, name, num, trim));
            iVar.A.setOnClickListener(new f(iVar, i6, categoryId, name, num, trim));
        }
    }

    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public i L(ViewGroup viewGroup, int i2) {
        SharedPreferences sharedPreferences = this.d.getSharedPreferences("listgridview", 0);
        this.l = sharedPreferences;
        int i3 = sharedPreferences.getInt("livestream", 0);
        m7.a.M = i3;
        i iVar = i3 == 1 ? new i(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.C3, viewGroup, false)) : new i(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.D3, viewGroup, false));
        this.k = iVar;
        return iVar;
    }

    public final void z0(i iVar, int i2, String str, String str2, String str3, String str4) {
        k.U u = new k.U(this.d, iVar.w);
        u.d(a7.h.e);
        (this.i.checkFavourite(i2, str, "live", SharepreferenceDBHandler.getUserID(this.d), str4).size() > 0 ? u.b().getItem(2) : u.b().getItem(1)).setVisible(true);
        u.f(new g(iVar, str, i2, str4, str2, str3));
        u.g();
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
        }
    }
}

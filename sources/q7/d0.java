package q7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.XMLTVProgrammePojo;
import com.nst.iptvsmarterstvbox.view.activity.SubTVArchiveActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class d0 extends RecyclerView.g {
    public static SharedPreferences n;
    public Context d;
    public List e;
    public SharedPreferences f;
    public List g;
    public List h;
    public DatabaseHandler i;
    public LiveStreamDBHandler j;
    public e k;
    public SharedPreferences l;
    public SimpleDateFormat m;

    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public a(String str, int i, String str2, String str3, String str4, String str5, String str6) {
            this.a = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
        }

        public void onClick(View view) {
            Intent intent = new Intent(d0.j0(d0.this), SubTVArchiveActivity.class);
            if (SharepreferenceDBHandler.getCurrentAPPType(d0.j0(d0.this)).equals("onestream_api")) {
                intent.putExtra("OPENED_STREAM_ID", this.a);
            } else {
                intent.putExtra("OPENED_STREAM_ID", this.c);
            }
            intent.putExtra("OPENED_CHANNEL_ID", this.d);
            intent.putExtra("OPENED_STREAM_ID", this.c);
            intent.putExtra("OPENED_NUM", this.e);
            intent.putExtra("OPENED_NAME", this.f);
            intent.putExtra("OPENED_STREAM_ICON", this.g);
            intent.putExtra("OPENED_ARCHIVE_DURATION", this.h);
            d0.j0(d0.this).startActivity(intent);
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public b(String str, int i, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        public void onClick(View view) {
            Intent intent = new Intent(d0.j0(d0.this), SubTVArchiveActivity.class);
            intent.putExtra("OPENED_CHANNEL_ID", this.a);
            intent.putExtra("OPENED_STREAM_ID", this.c);
            intent.putExtra("OPENED_NUM", this.d);
            intent.putExtra("OPENED_NAME", this.e);
            intent.putExtra("OPENED_STREAM_ICON", this.f);
            intent.putExtra("OPENED_ARCHIVE_DURATION", this.g);
            d0.j0(d0.this).startActivity(intent);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public c(String str, int i, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        public void onClick(View view) {
            Intent intent = new Intent(d0.j0(d0.this), SubTVArchiveActivity.class);
            intent.putExtra("OPENED_CHANNEL_ID", this.a);
            intent.putExtra("OPENED_STREAM_ID", this.c);
            intent.putExtra("OPENED_NUM", this.d);
            intent.putExtra("OPENED_NAME", this.e);
            intent.putExtra("OPENED_STREAM_ICON", this.f);
            intent.putExtra("OPENED_ARCHIVE_DURATION", this.g);
            d0.j0(d0.this).startActivity(intent);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ TextView c;

        public class a implements Runnable {
            public a() {
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0049  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r2 = this;
                    q7.d0$d r0 = q7.d0.d.this
                    java.lang.String r0 = r0.a
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 == 0) goto L16
                    q7.d0$d r0 = q7.d0.d.this
                    q7.d0 r0 = q7.d0.this
                    java.util.List r1 = q7.d0.m0(r0)
                L12:
                    q7.d0.p0(r0, r1)
                    goto L3b
                L16:
                    q7.d0$d r0 = q7.d0.d.this
                    q7.d0 r0 = q7.d0.this
                    java.util.List r0 = q7.d0.k0(r0)
                    boolean r0 = r0.isEmpty()
                    if (r0 == 0) goto L32
                    q7.d0$d r0 = q7.d0.d.this
                    q7.d0 r0 = q7.d0.this
                    java.util.List r0 = q7.d0.k0(r0)
                    boolean r0 = r0.isEmpty()
                    if (r0 == 0) goto L3b
                L32:
                    q7.d0$d r0 = q7.d0.d.this
                    q7.d0 r0 = q7.d0.this
                    java.util.List r1 = q7.d0.k0(r0)
                    goto L12
                L3b:
                    q7.d0$d r0 = q7.d0.d.this
                    q7.d0 r0 = q7.d0.this
                    java.util.List r0 = q7.d0.n0(r0)
                    int r0 = r0.size()
                    if (r0 != 0) goto L51
                    q7.d0$d r0 = q7.d0.d.this
                    android.widget.TextView r0 = r0.c
                    r1 = 0
                    r0.setVisibility(r1)
                L51:
                    q7.d0$d r0 = q7.d0.d.this
                    q7.d0 r0 = q7.d0.this
                    r0.w()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: q7.d0.d.a.run():void");
            }
        }

        public d(String str, TextView textView) {
            this.a = str;
            this.c = textView;
        }

        public void run() {
            d0.l0(d0.this, new ArrayList());
            if (d0.k0(d0.this) != null) {
                d0.k0(d0.this).clear();
            }
            if (TextUtils.isEmpty(this.a)) {
                d0.k0(d0.this).addAll(d0.m0(d0.this));
            } else {
                for (LiveStreamsDBModel liveStreamsDBModel : d0.n0(d0.this)) {
                    if (liveStreamsDBModel.getName().toLowerCase().contains(this.a.toLowerCase())) {
                        d0.k0(d0.this).add(liveStreamsDBModel);
                    }
                }
            }
            d0.j0(d0.this).runOnUiThread(new a());
        }
    }

    public static class e extends RecyclerView.D {
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

        public e(View view) {
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

    public d0(List list, Context context) {
        this.e = list;
        this.d = context;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.addAll(list);
        this.h = list;
        this.i = new DatabaseHandler(context);
        this.j = new LiveStreamDBHandler(context);
    }

    public static /* synthetic */ Context j0(d0 d0Var) {
        return d0Var.d;
    }

    public static /* synthetic */ List k0(d0 d0Var) {
        return d0Var.g;
    }

    public static /* synthetic */ List l0(d0 d0Var, List list) {
        d0Var.g = list;
        return list;
    }

    public static /* synthetic */ List m0(d0 d0Var) {
        return d0Var.h;
    }

    public static /* synthetic */ List n0(d0 d0Var) {
        return d0Var.e;
    }

    public static /* synthetic */ List p0(d0 d0Var, List list) {
        d0Var.e = list;
        return list;
    }

    public int n() {
        return this.e.size();
    }

    public void q0(String str, TextView textView) {
        new Thread(new d(str, textView)).start();
    }

    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void E(e eVar, int i) {
        int i2;
        ImageView imageView;
        int i3;
        LiveStreamDBHandler liveStreamDBHandler;
        ArrayList epg;
        int M;
        Context context = this.d;
        if (context != null) {
            this.f = context.getSharedPreferences("selectedPlayer", 0);
            try {
                i2 = Integer.parseInt(((LiveStreamsDBModel) this.e.get(i)).getStreamId().trim());
            } catch (NumberFormatException unused) {
                i2 = -1;
            }
            String categoryId = ((LiveStreamsDBModel) this.e.get(i)).getCategoryId();
            String epgChannelId = ((LiveStreamsDBModel) this.e.get(i)).getEpgChannelId();
            eVar.D.setText("");
            eVar.B.setVisibility(8);
            eVar.C.setText("");
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
                            eVar.D.setVisibility(8);
                            eVar.B.setVisibility(8);
                            eVar.C.setVisibility(8);
                        } else {
                            if (m7.a.M == 0) {
                                eVar.D.setVisibility(0);
                                SharedPreferences sharedPreferences = this.d.getSharedPreferences("timeFormat", 0);
                                n = sharedPreferences;
                                this.m = new SimpleDateFormat(sharedPreferences.getString("timeFormat", m7.a.E0));
                                eVar.D.setText(this.m.format(valueOf) + " - " + this.m.format(valueOf2));
                            }
                            eVar.B.setVisibility(0);
                            eVar.B.setProgress(i5);
                            eVar.C.setVisibility(0);
                            eVar.C.setText(title);
                        }
                    }
                }
            }
            String num = ((LiveStreamsDBModel) this.e.get(i)).getNum();
            String name = ((LiveStreamsDBModel) this.e.get(i)).getName();
            eVar.u.setText(((LiveStreamsDBModel) this.e.get(i)).getName());
            String streamIcon = ((LiveStreamsDBModel) this.e.get(i)).getStreamIcon();
            String epgChannelId2 = ((LiveStreamsDBModel) this.e.get(i)).getEpgChannelId();
            String tvArchiveDuration = ((LiveStreamsDBModel) this.e.get(i)).getTvArchiveDuration();
            eVar.t.setImageDrawable((Drawable) null);
            if (streamIcon == null || streamIcon.equals("")) {
                eVar.t.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1, (Resources.Theme) null));
            } else {
                com.squareup.picasso.t.q(this.d).l(streamIcon).j(a7.e.i1).g(eVar.t);
            }
            int i6 = i2;
            eVar.v.setOnClickListener(new a("", i6, epgChannelId2, num, name, streamIcon, tvArchiveDuration));
            eVar.E.setOnClickListener(new b(epgChannelId2, i6, num, name, streamIcon, tvArchiveDuration));
            eVar.y.setOnClickListener(new c(epgChannelId2, i6, num, name, streamIcon, tvArchiveDuration));
            ArrayList checkFavourite = this.i.checkFavourite(i6, categoryId, "live", SharepreferenceDBHandler.getUserID(this.d), "");
            if (checkFavourite == null || checkFavourite.size() <= 0) {
                imageView = eVar.x;
                i3 = 4;
            } else {
                imageView = eVar.x;
                i3 = 0;
            }
            imageView.setVisibility(i3);
        }
    }

    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public e L(ViewGroup viewGroup, int i) {
        SharedPreferences sharedPreferences = this.d.getSharedPreferences("listgridview", 0);
        this.l = sharedPreferences;
        int i2 = sharedPreferences.getInt("livestream", 0);
        m7.a.M = i2;
        e eVar = i2 == 1 ? new e(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.C3, viewGroup, false)) : new e(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.D3, viewGroup, false));
        this.k = eVar;
        return eVar;
    }
}

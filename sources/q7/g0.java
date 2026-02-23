package q7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.XMLTVProgrammePojo;
import com.nst.iptvsmarterstvbox.view.activity.SubTVArchiveActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class g0 extends RecyclerView.g {
    public static SharedPreferences l;
    public List d;
    public Context e;
    public List f;
    public List g;
    public LiveStreamDBHandler h;
    public SimpleDateFormat i;
    public boolean j = true;
    public String k;

    public class a implements Comparator {
        public a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(LiveStreamsDBModel liveStreamsDBModel, LiveStreamsDBModel liveStreamsDBModel2) {
            return s5.q.j().d(liveStreamsDBModel.getIdAuto(), liveStreamsDBModel2.getIdAuto()).i();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ LiveStreamsDBModel a;

        public b(LiveStreamsDBModel liveStreamsDBModel) {
            this.a = liveStreamsDBModel;
        }

        public void onClick(View view) {
            Intent intent = new Intent(g0.j0(g0.this), SubTVArchiveActivity.class);
            intent.putExtra("OPENED_CHANNEL_ID", this.a.getEpgChannelId());
            intent.putExtra("OPENED_STREAM_ID", this.a.getStreamId());
            intent.putExtra("OPENED_NUM", this.a.getNum());
            intent.putExtra("OPENED_NAME", this.a.getName());
            intent.putExtra("OPENED_STREAM_ICON", this.a.getStreamIcon());
            intent.putExtra("OPENED_ARCHIVE_DURATION", this.a.getTvArchiveDuration());
            g0.j0(g0.this).startActivity(intent);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ LiveStreamsDBModel a;

        public c(LiveStreamsDBModel liveStreamsDBModel) {
            this.a = liveStreamsDBModel;
        }

        public void onClick(View view) {
            Log.e("data Value Categories", ">>>>>>>>>>>>>>" + this.a);
            Intent intent = new Intent(g0.j0(g0.this), SubTVArchiveActivity.class);
            intent.putExtra("OPENED_CHANNEL_ID", this.a.getEpgChannelId());
            intent.putExtra("OPENED_STREAM_ID", this.a.getStreamId());
            intent.putExtra("OPENED_NUM", this.a.getNum());
            intent.putExtra("OPENED_NAME", this.a.getName());
            intent.putExtra("OPENED_STREAM_ICON", this.a.getStreamIcon());
            intent.putExtra("OPENED_ARCHIVE_DURATION", this.a.getTvArchiveDuration());
            g0.j0(g0.this).startActivity(intent);
        }
    }

    public static class d extends RecyclerView.D {
        public ProgressBar A;
        public TextView B;
        public ImageView C;
        public TextView t;
        public ProgressBar u;
        public RelativeLayout v;
        public RelativeLayout w;
        public RelativeLayout x;
        public TextView y;
        public TextView z;

        public d(View view) {
            super(view);
            this.t = view.findViewById(a7.f.fk);
            this.u = view.findViewById(a7.f.oc);
            this.v = view.findViewById(a7.f.Re);
            this.w = view.findViewById(a7.f.ze);
            this.x = view.findViewById(a7.f.Wg);
            this.y = view.findViewById(a7.f.di);
            this.z = view.findViewById(a7.f.em);
            this.A = view.findViewById(a7.f.Nc);
            this.B = view.findViewById(a7.f.si);
            this.C = view.findViewById(a7.f.h6);
            J(false);
        }
    }

    public class e implements View.OnFocusChangeListener {
        public final View a;

        public e(View view) {
            this.a = view;
        }

        public final void a(boolean z) {
            if (z) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{z ? 0.6f : 0.5f});
                ofFloat.setDuration(150L);
                ofFloat.start();
            }
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void c(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            View view2;
            int i;
            if (z) {
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                Log.e("id is", "" + this.a.getTag());
                view2 = this.a;
                i = a7.e.q2;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
                view2 = this.a;
                i = a7.e.p2;
            }
            view2.setBackgroundResource(i);
        }
    }

    public g0(List list, Context context) {
        this.k = "";
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.addAll(list);
        this.g = list;
        this.d = list;
        this.e = context;
        this.h = new LiveStreamDBHandler(context);
        this.k = context.getSharedPreferences("selected_language", 0).getString("selected_language", "");
        Collections.sort(this.d, new a());
    }

    public static /* synthetic */ Context j0(g0 g0Var) {
        return g0Var.e;
    }

    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void E(d dVar, int i) {
        LiveStreamDBHandler liveStreamDBHandler;
        int M;
        LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) this.d.get(i);
        String name = liveStreamsDBModel.getName();
        liveStreamsDBModel.getStreamId();
        String num = liveStreamsDBModel.getNum();
        String epgChannelId = liveStreamsDBModel.getEpgChannelId();
        String streamIcon = liveStreamsDBModel.getStreamIcon();
        if (name != null && !name.equals("") && !name.isEmpty()) {
            dVar.t.setText(name);
        }
        TextView textView = dVar.y;
        if (textView != null) {
            textView.setText(num);
        }
        dVar.z.setText("");
        dVar.A.setVisibility(8);
        dVar.B.setText("");
        if (epgChannelId != null && !epgChannelId.equals("") && (liveStreamDBHandler = this.h) != null) {
            ArrayList epg = liveStreamDBHandler.getEPG(epgChannelId);
            if (epg != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= epg.size()) {
                        break;
                    }
                    String start = ((XMLTVProgrammePojo) epg.get(i2)).getStart();
                    String stop = ((XMLTVProgrammePojo) epg.get(i2)).getStop();
                    String title = ((XMLTVProgrammePojo) epg.get(i2)).getTitle();
                    ((XMLTVProgrammePojo) epg.get(i2)).getDesc();
                    long x = m7.w.x(start, this.e);
                    Long valueOf = Long.valueOf(x);
                    ArrayList arrayList = epg;
                    long x2 = m7.w.x(stop, this.e);
                    Long valueOf2 = Long.valueOf(x2);
                    if (!m7.w.b0(x, x2, this.e) || (M = m7.w.M(x, x2, this.e)) == 0) {
                        i2++;
                        epg = arrayList;
                    } else {
                        int i3 = 100 - M;
                        if (i3 == 0 || title == null || title.equals("")) {
                            dVar.z.setVisibility(8);
                            dVar.A.setVisibility(8);
                            dVar.B.setVisibility(8);
                        } else {
                            if (m7.a.M == 0) {
                                dVar.z.setVisibility(0);
                                SharedPreferences sharedPreferences = this.e.getSharedPreferences("timeFormat", 0);
                                l = sharedPreferences;
                                this.i = new SimpleDateFormat(sharedPreferences.getString("timeFormat", m7.a.E0));
                                dVar.z.setText(this.i.format(valueOf) + " - " + this.i.format(valueOf2));
                            }
                            dVar.A.setVisibility(0);
                            dVar.A.setProgress(i3);
                            dVar.B.setVisibility(0);
                            dVar.B.setText(title);
                        }
                    }
                }
            }
            dVar.C.setImageDrawable((Drawable) null);
            if (streamIcon == null || streamIcon.equals("")) {
                dVar.C.setImageDrawable(this.e.getResources().getDrawable(a7.e.K2, (Resources.Theme) null));
            } else {
                com.squareup.picasso.t.q(this.e).l(streamIcon).j(a7.e.K2).g(dVar.C);
            }
        }
        dVar.v.setOnClickListener(new b(liveStreamsDBModel));
        dVar.w.setOnClickListener(new c(liveStreamsDBModel));
        RelativeLayout relativeLayout = dVar.v;
        relativeLayout.setOnFocusChangeListener(new e(relativeLayout));
        if (i == 0 && this.j) {
            dVar.v.requestFocus();
            this.j = false;
        }
    }

    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public d L(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.h3, viewGroup, false);
        ImageView findViewById = inflate.findViewById(a7.f.i5);
        if (this.k.equalsIgnoreCase("Arabic")) {
            findViewById.setImageResource(a7.e.W0);
        }
        return new d(inflate);
    }

    public int n() {
        return this.d.size();
    }
}

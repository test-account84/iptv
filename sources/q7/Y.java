package q7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class y extends RecyclerView.g {
    public static SharedPreferences t;
    public List d;
    public Context e;
    public List f;
    public List g;
    public LiveStreamDBHandler h;
    public SimpleDateFormat i;
    public String k;
    public PopupWindow l;
    public PopupWindow m;
    public z7.h n;
    public SharedPreferences o;
    public SharedPreferences p;
    public String q;
    public String s;
    public boolean j = true;
    public String r = "";

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
            z7.h l0;
            String str;
            if (y.j0(y.this) != null) {
                y.j0(y.this).dismiss();
            }
            if (y.k0(y.this) != null) {
                y.k0(y.this).dismiss();
            }
            if (y.l0(y.this) != null) {
                if (SharepreferenceDBHandler.getCurrentAPPType(y.m0(y.this)).equals("m3u")) {
                    l0 = y.l0(y.this);
                    str = this.a.getUrl();
                } else {
                    l0 = y.l0(y.this);
                    str = y.this.s + this.a.getStreamId() + y.this.q;
                }
                l0.p(String.valueOf(Uri.parse(str)), this.a.getNum());
            }
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ LiveStreamsDBModel a;

        public c(LiveStreamsDBModel liveStreamsDBModel) {
            this.a = liveStreamsDBModel;
        }

        public void onClick(View view) {
            z7.h l0;
            String str;
            if (y.j0(y.this) != null) {
                y.j0(y.this).dismiss();
            }
            if (y.k0(y.this) != null) {
                y.k0(y.this).dismiss();
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(y.m0(y.this)).equals("m3u")) {
                l0 = y.l0(y.this);
                str = this.a.getUrl();
            } else {
                l0 = y.l0(y.this);
                str = y.this.s + this.a.getStreamId() + y.this.q;
            }
            l0.p(String.valueOf(Uri.parse(str)), this.a.getNum());
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

    public y(List list, Context context, PopupWindow popupWindow, z7.h hVar, PopupWindow popupWindow2) {
        this.k = "";
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.addAll(list);
        this.g = list;
        this.n = hVar;
        this.d = list;
        this.e = context;
        this.h = new LiveStreamDBHandler(context);
        this.k = context.getSharedPreferences("selected_language", 0).getString("selected_language", "");
        Collections.sort(this.d, new a());
        this.l = popupWindow;
        this.m = popupWindow2;
        if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("m3u")) {
            return;
        }
        q0();
    }

    public static /* synthetic */ PopupWindow j0(y yVar) {
        return yVar.l;
    }

    public static /* synthetic */ PopupWindow k0(y yVar) {
        return yVar.m;
    }

    public static /* synthetic */ z7.h l0(y yVar) {
        return yVar.n;
    }

    public static /* synthetic */ Context m0(y yVar) {
        return yVar.e;
    }

    public int n() {
        return this.d.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x015b A[Catch: Exception -> 0x016d, TRY_LEAVE, TryCatch #0 {Exception -> 0x016d, blocks: (B:48:0x013f, B:50:0x0145, B:43:0x015b), top: B:47:0x013f }] */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(q7.y.d r18, int r19) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.y.E(q7.y$d, int):void");
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public d L(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.h3, viewGroup, false);
        ImageView findViewById = inflate.findViewById(a7.f.i5);
        if (this.k.equalsIgnoreCase("Arabic")) {
            findViewById.setImageResource(a7.e.W0);
        }
        return new d(inflate);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q0() {
        /*
            Method dump skipped, instructions count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.y.q0():void");
    }
}

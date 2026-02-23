package q7;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.StalkerLiveFavIdsSingleton;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAdCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAllChannelsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetSeriesCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVODByCatCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerLiveFavIdsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerProfilesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerSetLiveFavCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerTokenCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity;
import java.util.ArrayList;
import java.util.List;
import k.U;
import q7.Z;
import q7.m0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class t extends RecyclerView.g implements Filterable, z7.g {
    public String B;
    public String C;
    public Handler E;
    public LiveStreamDBHandler F;
    public n7.e G;
    public ArrayList I;
    public String J;
    public List d;
    public ArrayList h;
    public Context i;
    public DatabaseHandler k;
    public Animation l;
    public String m;
    public String p;
    public SharedPreferences t;
    public o4.e u;
    public Boolean j = Boolean.FALSE;
    public l n = new l(this, null);
    public m o = new m(this, null);
    public String q = "";
    public boolean r = false;
    public int s = -1;
    public String v = "";
    public String w = "0";
    public String x = "";
    public String y = "";
    public String z = "";
    public int A = 0;
    public String D = "";
    public int H = 0;
    public ArrayList e = VodAllCategoriesSingleton.getInstance().getLiveList();
    public ArrayList f = VodAllCategoriesSingleton.getInstance().getLiveList();
    public final ArrayList g = VodAllCategoriesSingleton.getInstance().getContinueWatchingList();

    public class b implements U.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ o b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ArrayList d;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                t.this.w();
            }
        }

        public class b extends Dialog implements View.OnClickListener {
            public Activity a;
            public TextView c;
            public TextView d;
            public TextView e;
            public LinearLayout f;
            public LinearLayout g;

            public class a implements Runnable {
                public a() {
                }

                public void run() {
                    if (t.r0(t.this) instanceof LiveAllDataSingleActivity) {
                        t.r0(t.this).j2();
                    }
                }
            }

            public class b implements View.OnFocusChangeListener {
                public View a;

                public b(View view) {
                    this.a = view;
                }

                public void onFocusChange(View view, boolean z) {
                    LinearLayout b;
                    int i;
                    if (z) {
                        View view2 = this.a;
                        if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                            View view3 = this.a;
                            if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                                return;
                            } else {
                                b = b.b(b.this);
                            }
                        } else {
                            b = b.a(b.this);
                        }
                        i = a7.e.p;
                    } else {
                        View view4 = this.a;
                        if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                            View view5 = this.a;
                            if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                                return;
                            } else {
                                b = b.b(b.this);
                            }
                        } else {
                            b = b.a(b.this);
                        }
                        i = a7.e.o;
                    }
                    b.setBackgroundResource(i);
                }
            }

            public b(Activity activity) {
                super(activity);
                this.a = activity;
            }

            public static /* synthetic */ LinearLayout a(b bVar) {
                return bVar.f;
            }

            public static /* synthetic */ LinearLayout b(b bVar) {
                return bVar.g;
            }

            public void onClick(View view) {
                int id = view.getId();
                if (id == a7.f.u1) {
                    try {
                        t.R0(t.this).deleteLiveRecentlyWatched(String.valueOf(b.this.a));
                        if (t.r0(t.this) instanceof LiveAllDataSingleActivity) {
                            t.r0(t.this).p2();
                        }
                        new Handler().postDelayed(new a(), 100L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (id == a7.f.h1) {
                    dismiss();
                }
                dismiss();
            }

            public void onCreate(Bundle bundle) {
                super.onCreate(bundle);
                setContentView(new u7.a(t.r0(t.this)).A().equals(m7.a.K0) ? a7.g.X1 : a7.g.W1);
                this.c = findViewById(a7.f.u1);
                this.d = findViewById(a7.f.h1);
                this.f = findViewById(a7.f.V8);
                this.g = findViewById(a7.f.Ia);
                TextView findViewById = findViewById(a7.f.um);
                this.e = findViewById;
                findViewById.setText(t.r0(t.this).getResources().getString(a7.j.Y8));
                this.c.setOnClickListener(this);
                this.d.setOnClickListener(this);
                TextView textView = this.c;
                textView.setOnFocusChangeListener(new b(textView));
                TextView textView2 = this.d;
                textView2.setOnFocusChangeListener(new b(textView2));
            }
        }

        public b(String str, o oVar, int i, ArrayList arrayList) {
            this.a = str;
            this.b = oVar;
            this.c = i;
            this.d = arrayList;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId != a7.f.Bb && itemId != a7.f.Lb) {
                if (itemId != a7.f.kb) {
                    return false;
                }
                new b(t.r0(t.this)).show();
                return false;
            }
            t.j0(t.this, t.R0(t.this).checkFavourite(this.a, SharepreferenceDBHandler.getUserID(t.r0(t.this))), this.b, this.c, this.d);
            new Handler().postDelayed(new a(), 300L);
            if (!(t.r0(t.this) instanceof LiveAllDataSingleActivity)) {
                return false;
            }
            t.r0(t.this).j2();
            return false;
        }
    }

    public class c implements U.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ LiveStreamsDBModel b;
        public final /* synthetic */ String c;
        public final /* synthetic */ o d;
        public final /* synthetic */ int e;
        public final /* synthetic */ ArrayList f;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                t.this.w();
            }
        }

        public class b extends Dialog implements View.OnClickListener {
            public Activity a;
            public TextView c;
            public TextView d;
            public TextView e;
            public LinearLayout f;
            public LinearLayout g;

            public class a implements Runnable {
                public a() {
                }

                public void run() {
                    if (t.r0(t.this) instanceof LiveAllDataSingleActivity) {
                        t.r0(t.this).j2();
                    }
                }
            }

            public class b implements View.OnFocusChangeListener {
                public View a;

                public b(View view) {
                    this.a = view;
                }

                public void onFocusChange(View view, boolean z) {
                    LinearLayout b;
                    int i;
                    if (z) {
                        View view2 = this.a;
                        if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                            View view3 = this.a;
                            if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                                return;
                            } else {
                                b = b.b(b.this);
                            }
                        } else {
                            b = b.a(b.this);
                        }
                        i = a7.e.p;
                    } else {
                        View view4 = this.a;
                        if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                            View view5 = this.a;
                            if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                                return;
                            } else {
                                b = b.b(b.this);
                            }
                        } else {
                            b = b.a(b.this);
                        }
                        i = a7.e.o;
                    }
                    b.setBackgroundResource(i);
                }
            }

            public b(Activity activity) {
                super(activity);
                this.a = activity;
            }

            public static /* synthetic */ LinearLayout a(b bVar) {
                return bVar.f;
            }

            public static /* synthetic */ LinearLayout b(b bVar) {
                return bVar.g;
            }

            public void onClick(View view) {
                if (view.getId() == a7.f.u1) {
                    try {
                        t.R0(t.this).deleteLiveRecentlyWatched(String.valueOf(c.this.a));
                        if (t.r0(t.this) instanceof LiveAllDataSingleActivity) {
                            t.r0(t.this).p2();
                        }
                        new Handler().postDelayed(new a(), 100L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (view.getId() == a7.f.h1) {
                    dismiss();
                }
                dismiss();
            }

            public void onCreate(Bundle bundle) {
                super.onCreate(bundle);
                setContentView(new u7.a(t.r0(t.this)).A().equals(m7.a.K0) ? a7.g.X1 : a7.g.W1);
                this.c = findViewById(a7.f.u1);
                this.d = findViewById(a7.f.h1);
                this.f = findViewById(a7.f.V8);
                this.g = findViewById(a7.f.Ia);
                TextView findViewById = findViewById(a7.f.um);
                this.e = findViewById;
                findViewById.setText(t.r0(t.this).getResources().getString(a7.j.Y8));
                this.c.setOnClickListener(this);
                this.d.setOnClickListener(this);
                TextView textView = this.c;
                textView.setOnFocusChangeListener(new b(textView));
                TextView textView2 = this.d;
                textView2.setOnFocusChangeListener(new b(textView2));
            }
        }

        public c(String str, LiveStreamsDBModel liveStreamsDBModel, String str2, o oVar, int i, ArrayList arrayList) {
            this.a = str;
            this.b = liveStreamsDBModel;
            this.c = str2;
            this.d = oVar;
            this.e = i;
            this.f = arrayList;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getItemId() != a7.f.Bb && menuItem.getItemId() != a7.f.Lb) {
                if (menuItem.getItemId() != a7.f.kb) {
                    return false;
                }
                new b(t.r0(t.this)).show();
                return false;
            }
            t.q0(t.this, t.p0(t.this).checkFavourite(Integer.parseInt(this.a), this.b.getCategoryId(), this.b.getStreamType(), SharepreferenceDBHandler.getUserID(t.r0(t.this)), this.c), this.d, this.e, this.f);
            new Handler().postDelayed(new a(), 300L);
            if (!(t.r0(t.this) instanceof LiveAllDataSingleActivity)) {
                return false;
            }
            t.r0(t.this).j2();
            return false;
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public f(String str, String str2, int i, String str3, String str4, String str5) {
            this.a = str;
            this.c = str2;
            this.d = i;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x01bc  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x01d3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r18) {
            /*
                Method dump skipped, instructions count: 552
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: q7.t.f.onClick(android.view.View):void");
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public g(String str, String str2, int i, String str3, String str4, String str5) {
            this.a = str;
            this.c = str2;
            this.d = i;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x01bb  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x01d2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r18) {
            /*
                Method dump skipped, instructions count: 551
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: q7.t.g.onClick(android.view.View):void");
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public h(String str, String str2, int i, String str3, String str4, String str5) {
            this.a = str;
            this.c = str2;
            this.d = i;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x01bb  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x01d2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r18) {
            /*
                Method dump skipped, instructions count: 551
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: q7.t.h.onClick(android.view.View):void");
        }
    }

    public class i implements View.OnLongClickListener {
        public final /* synthetic */ o a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public i(o oVar, int i, String str, int i2, String str2, String str3, String str4) {
            this.a = oVar;
            this.c = i;
            this.d = str;
            this.e = i2;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        public boolean onLongClick(View view) {
            if (t.K0(t.this).equals("-6")) {
                t tVar = t.this;
                t.Q0(tVar, this.a, this.c, t.N0(tVar));
                return true;
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(t.r0(t.this)).equals("m3u")) {
                ArrayList checkFavourite = t.R0(t.this).checkFavourite(this.d, SharepreferenceDBHandler.getUserID(t.r0(t.this)));
                t tVar2 = t.this;
                t.j0(tVar2, checkFavourite, this.a, this.c, t.N0(tVar2));
            } else if (SharepreferenceDBHandler.getCurrentAPPType(t.r0(t.this)).equals("stalker_api")) {
                m7.w.N0(t.r0(t.this));
                t.k0(t.this, 0);
                try {
                    if (t.l0(t.this) == null || t.l0(t.this).size() <= 0) {
                        t.n0(t.this, this.e, this.a);
                    } else if (t.l0(t.this).contains(Integer.valueOf(this.e))) {
                        t.m0(t.this, this.e, this.a);
                    } else {
                        t.n0(t.this, this.e, this.a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ArrayList checkFavourite2 = t.p0(t.this).checkFavourite(this.e, this.g, this.h, SharepreferenceDBHandler.getUserID(t.r0(t.this)), this.f);
                t tVar3 = t.this;
                t.q0(tVar3, checkFavourite2, this.a, this.c, t.N0(tVar3));
            }
            return true;
        }
    }

    public class j implements View.OnLongClickListener {
        public final /* synthetic */ o a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public j(o oVar, int i, String str, int i2, String str2, String str3, String str4) {
            this.a = oVar;
            this.c = i;
            this.d = str;
            this.e = i2;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        public boolean onLongClick(View view) {
            if (t.K0(t.this).equals("-6")) {
                t tVar = t.this;
                t.Q0(tVar, this.a, this.c, t.N0(tVar));
                return true;
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(t.r0(t.this)).equals("m3u")) {
                ArrayList checkFavourite = t.R0(t.this).checkFavourite(this.d, SharepreferenceDBHandler.getUserID(t.r0(t.this)));
                t tVar2 = t.this;
                t.j0(tVar2, checkFavourite, this.a, this.c, t.N0(tVar2));
            } else if (SharepreferenceDBHandler.getCurrentAPPType(t.r0(t.this)).equals("stalker_api")) {
                m7.w.N0(t.r0(t.this));
                t.k0(t.this, 0);
                try {
                    if (t.l0(t.this) == null || t.l0(t.this).size() <= 0) {
                        t.n0(t.this, this.e, this.a);
                    } else if (t.l0(t.this).contains(Integer.valueOf(this.e))) {
                        t.m0(t.this, this.e, this.a);
                    } else {
                        t.n0(t.this, this.e, this.a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ArrayList checkFavourite2 = t.p0(t.this).checkFavourite(this.e, this.g, this.h, SharepreferenceDBHandler.getUserID(t.r0(t.this)), this.f);
                t tVar3 = t.this;
                t.q0(tVar3, checkFavourite2, this.a, this.c, t.N0(tVar3));
            }
            return true;
        }
    }

    public class k implements View.OnLongClickListener {
        public final /* synthetic */ o a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public k(o oVar, int i, String str, int i2, String str2, String str3, String str4) {
            this.a = oVar;
            this.c = i;
            this.d = str;
            this.e = i2;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        public boolean onLongClick(View view) {
            if (t.K0(t.this).equals("-6")) {
                t tVar = t.this;
                t.Q0(tVar, this.a, this.c, t.N0(tVar));
                return true;
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(t.r0(t.this)).equals("m3u")) {
                ArrayList checkFavourite = t.R0(t.this).checkFavourite(this.d, SharepreferenceDBHandler.getUserID(t.r0(t.this)));
                t tVar2 = t.this;
                t.j0(tVar2, checkFavourite, this.a, this.c, t.N0(tVar2));
            } else if (SharepreferenceDBHandler.getCurrentAPPType(t.r0(t.this)).equals("stalker_api")) {
                m7.w.N0(t.r0(t.this));
                t.k0(t.this, 0);
                try {
                    if (t.l0(t.this) == null || t.l0(t.this).size() <= 0) {
                        t.n0(t.this, this.e, this.a);
                    } else if (t.l0(t.this).contains(Integer.valueOf(this.e))) {
                        t.m0(t.this, this.e, this.a);
                    } else {
                        t.n0(t.this, this.e, this.a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ArrayList checkFavourite2 = t.p0(t.this).checkFavourite(this.e, this.g, this.h, SharepreferenceDBHandler.getUserID(t.r0(t.this)), this.f);
                t tVar3 = t.this;
                t.q0(tVar3, checkFavourite2, this.a, this.c, t.N0(tVar3));
            }
            return true;
        }
    }

    public class l extends Filter {
        public l() {
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            String lowerCase = charSequence.toString().toLowerCase();
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList s0 = t.s0(t.this);
            if (s0 == null) {
                filterResults.values = null;
                filterResults.count = 0;
                return filterResults;
            }
            int size = s0.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) s0.get(i);
                if (liveStreamsDBModel.getName().toLowerCase().contains(lowerCase) || liveStreamsDBModel.getName().contains(lowerCase)) {
                    arrayList.add(liveStreamsDBModel);
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            try {
                t.O0(t.this, (ArrayList) filterResults.values);
                if (t.N0(t.this) != null) {
                    t.this.w();
                    if (t.N0(t.this) == null || t.N0(t.this).size() != 0) {
                        t.r0(t.this).u2();
                        t.r0(t.this).X1();
                    } else {
                        t.r0(t.this).V1();
                        t.r0(t.this).v2(t.r0(t.this).getResources().getString(a7.j.g4));
                    }
                }
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ l(t tVar, a aVar) {
            this();
        }
    }

    public class m extends Filter {
        public m() {
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            String lowerCase = charSequence.toString().toLowerCase();
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList t0 = t.t0(t.this);
            if (t0 == null) {
                filterResults.values = null;
                filterResults.count = 0;
                return filterResults;
            }
            int size = t0.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) t0.get(i);
                if (liveStreamsDBModel.getName().toLowerCase().contains(lowerCase) || liveStreamsDBModel.getName().contains(lowerCase)) {
                    arrayList.add(liveStreamsDBModel);
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            try {
                t.z0(t.this, (ArrayList) filterResults.values);
                if (t.x0(t.this) != null) {
                    t.this.w();
                    if (t.x0(t.this).size() == 0) {
                        t.r0(t.this).V1();
                        t.r0(t.this).v2(t.r0(t.this).getResources().getString(a7.j.g4));
                    } else {
                        t.r0(t.this).u2();
                        t.r0(t.this).X1();
                    }
                }
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ m(t tVar, a aVar) {
            this();
        }
    }

    public class n implements View.OnFocusChangeListener {
        public int a;

        public n(int i) {
            this.a = i;
        }

        public void onFocusChange(View view, boolean z) {
            t.this.s = z ? this.a : -1;
        }
    }

    public static class o extends RecyclerView.D {
        public TextView t;
        public RelativeLayout u;
        public ImageView v;
        public CardView w;
        public TextView x;
        public ImageView y;
        public LinearLayout z;

        public o(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Fl);
            this.u = view.findViewById(a7.f.Ge);
            this.v = view.findViewById(a7.f.B5);
            this.w = view.findViewById(a7.f.J1);
            this.x = view.findViewById(a7.f.Ul);
            this.y = view.findViewById(a7.f.g5);
            this.z = view.findViewById(a7.f.O8);
        }
    }

    public t(Context context, String str, String str2, String str3, String str4) {
        this.m = "";
        this.p = "mobile";
        this.B = "";
        this.C = "0";
        this.i = context;
        this.J = str4;
        this.I = str4.equalsIgnoreCase("live") ? VodAllCategoriesSingleton.getInstance().getLiveFavList() : VodAllCategoriesSingleton.getInstance().getRadioFavList();
        this.h = VodAllCategoriesSingleton.getInstance().getContinueWatchingList();
        this.k = new DatabaseHandler(context);
        this.F = new LiveStreamDBHandler(context);
        this.l = AnimationUtils.loadAnimation(context, a7.b.a);
        this.m = str;
        this.B = str2;
        this.C = str3;
        this.d = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
        this.G = new n7.e(this, context);
        if (new u7.a(context).A().equals(m7.a.K0)) {
            this.p = "tv";
        } else {
            this.p = "mobile";
        }
        this.E = new Handler(Looper.getMainLooper());
        if (this.p.equals("mobile")) {
            try {
                this.u = o4.b.e(context).c().c();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static /* synthetic */ o4.e A0(t tVar) {
        return tVar.u;
    }

    public static /* synthetic */ o4.e B0(t tVar, o4.e eVar) {
        tVar.u = eVar;
        return eVar;
    }

    public static /* synthetic */ String F0(t tVar) {
        return tVar.D;
    }

    public static /* synthetic */ String J0(t tVar, String str) {
        tVar.D = str;
        return str;
    }

    public static /* synthetic */ String K0(t tVar) {
        return tVar.C;
    }

    public static /* synthetic */ String L0(t tVar) {
        return tVar.B;
    }

    public static /* synthetic */ ArrayList N0(t tVar) {
        return tVar.f;
    }

    public static /* synthetic */ ArrayList O0(t tVar, ArrayList arrayList) {
        tVar.f = arrayList;
        return arrayList;
    }

    public static /* synthetic */ void Q0(t tVar, RecyclerView.D d2, int i2, ArrayList arrayList) {
        tVar.e1(d2, i2, arrayList);
    }

    public static /* synthetic */ LiveStreamDBHandler R0(t tVar) {
        return tVar.F;
    }

    public static /* synthetic */ void j0(t tVar, ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2) {
        tVar.a1(arrayList, d2, i2, arrayList2);
    }

    public static /* synthetic */ int k0(t tVar, int i2) {
        tVar.H = i2;
        return i2;
    }

    public static /* synthetic */ List l0(t tVar) {
        return tVar.d;
    }

    public static /* synthetic */ void m0(t tVar, int i2, o oVar) {
        tVar.f1(i2, oVar);
    }

    public static /* synthetic */ void n0(t tVar, int i2, o oVar) {
        tVar.S0(i2, oVar);
    }

    public static /* synthetic */ DatabaseHandler p0(t tVar) {
        return tVar.k;
    }

    public static /* synthetic */ void q0(t tVar, ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2) {
        tVar.Z0(arrayList, d2, i2, arrayList2);
    }

    public static /* synthetic */ Context r0(t tVar) {
        return tVar.i;
    }

    public static /* synthetic */ ArrayList s0(t tVar) {
        return tVar.e;
    }

    public static /* synthetic */ ArrayList t0(t tVar) {
        return tVar.g;
    }

    public static /* synthetic */ ArrayList x0(t tVar) {
        return tVar.h;
    }

    public static /* synthetic */ ArrayList z0(t tVar, ArrayList arrayList) {
        tVar.h = arrayList;
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x018e A[Catch: Exception -> 0x005f, TryCatch #0 {Exception -> 0x005f, blocks: (B:3:0x001f, B:5:0x0023, B:7:0x0029, B:9:0x0043, B:11:0x005b, B:12:0x0062, B:14:0x0068, B:15:0x006f, B:17:0x0075, B:18:0x007e, B:80:0x0084, B:23:0x00a0, B:25:0x00a6, B:26:0x00ad, B:28:0x00b3, B:29:0x00ba, B:31:0x00c0, B:32:0x00c9, B:34:0x00e2, B:35:0x00ef, B:39:0x017f, B:41:0x018e, B:43:0x01a0, B:44:0x01a2, B:45:0x01f9, B:47:0x0290, B:49:0x0294, B:50:0x01a6, B:51:0x01a8, B:52:0x01ac, B:54:0x01ba, B:56:0x01be, B:58:0x01c4, B:60:0x01d0, B:61:0x01d3, B:62:0x01d6, B:63:0x01d9, B:65:0x01f3, B:66:0x01f6, B:37:0x014a, B:38:0x0146, B:70:0x0112, B:71:0x00e8, B:78:0x009c, B:86:0x02a0, B:88:0x02b0, B:22:0x0095, B:68:0x00f5), top: B:2:0x001f, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ac A[Catch: Exception -> 0x005f, TryCatch #0 {Exception -> 0x005f, blocks: (B:3:0x001f, B:5:0x0023, B:7:0x0029, B:9:0x0043, B:11:0x005b, B:12:0x0062, B:14:0x0068, B:15:0x006f, B:17:0x0075, B:18:0x007e, B:80:0x0084, B:23:0x00a0, B:25:0x00a6, B:26:0x00ad, B:28:0x00b3, B:29:0x00ba, B:31:0x00c0, B:32:0x00c9, B:34:0x00e2, B:35:0x00ef, B:39:0x017f, B:41:0x018e, B:43:0x01a0, B:44:0x01a2, B:45:0x01f9, B:47:0x0290, B:49:0x0294, B:50:0x01a6, B:51:0x01a8, B:52:0x01ac, B:54:0x01ba, B:56:0x01be, B:58:0x01c4, B:60:0x01d0, B:61:0x01d3, B:62:0x01d6, B:63:0x01d9, B:65:0x01f3, B:66:0x01f6, B:37:0x014a, B:38:0x0146, B:70:0x0112, B:71:0x00e8, B:78:0x009c, B:86:0x02a0, B:88:0x02b0, B:22:0x0095, B:68:0x00f5), top: B:2:0x001f, inners: #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(androidx.recyclerview.widget.RecyclerView.D r25, int r26) {
        /*
            Method dump skipped, instructions count: 698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.t.E(androidx.recyclerview.widget.RecyclerView$D, int):void");
    }

    public RecyclerView.D L(ViewGroup viewGroup, int i2) {
        return new o(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.x3, viewGroup, false));
    }

    public void P0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    public final void S0(int i2, o oVar) {
        try {
            StringBuilder sb = new StringBuilder();
            List list = this.d;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < this.d.size(); i3++) {
                    sb.append(this.d.get(i3));
                    sb.append(",");
                }
            }
            sb.append(i2);
            this.H = i2;
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.i);
            this.G.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.i), stalkerToken, oVar, sb.toString(), "added", "");
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    public final void W0(RecyclerView.D d2, int i2, ArrayList arrayList) {
        o oVar = (o) d2;
        FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
        favouriteDBModel.setCategoryID(((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId());
        favouriteDBModel.setStreamID(m7.w.r0(((LiveStreamsDBModel) arrayList.get(i2)).getStreamId()));
        favouriteDBModel.setStreamIDOneStream(((LiveStreamsDBModel) arrayList.get(i2)).getStreamIdOneStream());
        favouriteDBModel.setName(((LiveStreamsDBModel) arrayList.get(i2)).getName());
        favouriteDBModel.setNum(((LiveStreamsDBModel) arrayList.get(i2)).getNum());
        favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(this.i));
        this.k.addToFavourite(favouriteDBModel, ((LiveStreamsDBModel) arrayList.get(i2)).getStreamType());
        oVar.y.startAnimation(this.l);
        oVar.y.setVisibility(0);
    }

    public final void Y0(RecyclerView.D d2, int i2, ArrayList arrayList) {
        o oVar = (o) d2;
        FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
        favouriteM3UModel.setUrl(((LiveStreamsDBModel) arrayList.get(i2)).getUrl());
        favouriteM3UModel.setUserID(SharepreferenceDBHandler.getUserID(this.i));
        favouriteM3UModel.setName(((LiveStreamsDBModel) arrayList.get(i2)).getName());
        favouriteM3UModel.setCategoryID(((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId());
        this.F.addToFavourite(favouriteM3UModel);
        oVar.y.startAnimation(this.l);
        oVar.y.setVisibility(0);
    }

    public final void Z0(ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2) {
        if (arrayList.size() > 0) {
            g1(d2, i2, arrayList2);
        } else {
            W0(d2, i2, arrayList2);
        }
        this.r = true;
        LiveAllDataSingleActivity liveAllDataSingleActivity = this.i;
        if (liveAllDataSingleActivity instanceof LiveAllDataSingleActivity) {
            liveAllDataSingleActivity.j2();
        }
    }

    public final void a1(ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2) {
        if (arrayList.size() > 0) {
            h1(d2, i2, arrayList2);
        } else {
            Y0(d2, i2, arrayList2);
        }
        this.r = true;
        LiveAllDataSingleActivity liveAllDataSingleActivity = this.i;
        if (liveAllDataSingleActivity instanceof LiveAllDataSingleActivity) {
            liveAllDataSingleActivity.j2();
        }
    }

    public boolean b1() {
        return this.r;
    }

    public int c1() {
        return this.s;
    }

    public void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, o oVar, String str, String str2) {
        try {
            m7.w.X();
            if (stalkerSetLiveFavCallback == null || stalkerSetLiveFavCallback.getJs() == null || !stalkerSetLiveFavCallback.getJs().equals(Boolean.TRUE)) {
                return;
            }
            this.d = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
            if (str.equals("added")) {
                int i2 = this.H;
                if (i2 != 0) {
                    this.d.add(Integer.valueOf(i2));
                }
                StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(this.d);
                oVar.y.startAnimation(this.l);
                oVar.y.setVisibility(0);
            } else {
                int i3 = this.H;
                if (i3 != 0) {
                    this.d.remove(Integer.valueOf(i3));
                    StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(this.d);
                }
                oVar.y.setVisibility(4);
            }
            this.r = true;
            LiveAllDataSingleActivity liveAllDataSingleActivity = this.i;
            if (liveAllDataSingleActivity instanceof LiveAllDataSingleActivity) {
                liveAllDataSingleActivity.j2();
            }
        } catch (Exception unused) {
        }
    }

    public int d1(String str, String str2) {
        try {
            ArrayList arrayList = this.e;
            if (arrayList != null && arrayList.size() > 0) {
                if (str2.equals("m3u")) {
                    for (int i2 = 0; i2 < this.e.size(); i2++) {
                        if (((LiveStreamsDBModel) this.e.get(i2)).getUrl().equals(str)) {
                            return i2;
                        }
                    }
                } else {
                    for (int i3 = 0; i3 < this.e.size(); i3++) {
                        if (((LiveStreamsDBModel) this.e.get(i3)).getStreamId().equals(str)) {
                            return i3;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public final void e1(RecyclerView.D d2, int i2, ArrayList arrayList) {
        String str;
        try {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.i).equals("m3u")) {
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                o oVar = (o) d2;
                k.U u = new k.U(this.i, oVar.w);
                u.d(a7.h.o);
                String url = ((LiveStreamsDBModel) arrayList.get(i2)).getUrl();
                if (this.F.checkFavourite(url, SharepreferenceDBHandler.getUserID(this.i)).size() > 0) {
                    u.b().getItem(0).setVisible(false);
                    u.b().getItem(1).setVisible(true);
                } else {
                    u.b().getItem(0).setVisible(true);
                    u.b().getItem(1).setVisible(false);
                }
                u.f(new b(url, oVar, i2, arrayList));
                u.g();
                return;
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            o oVar2 = (o) d2;
            k.U u2 = new k.U(this.i, oVar2.w);
            u2.d(a7.h.o);
            LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) arrayList.get(i2);
            try {
                str = liveStreamsDBModel.getStreamIdOneStream();
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            String streamIdOneStream = ((LiveStreamsDBModel) arrayList.get(i2)).getStreamIdOneStream() != null ? ((LiveStreamsDBModel) arrayList.get(i2)).getStreamIdOneStream() : ((LiveStreamsDBModel) arrayList.get(i2)).getStreamId() != null ? ((LiveStreamsDBModel) arrayList.get(i2)).getStreamId() : "";
            if (this.k.checkFavourite(Integer.parseInt(streamIdOneStream), liveStreamsDBModel.getCategoryId(), liveStreamsDBModel.getStreamType(), SharepreferenceDBHandler.getUserID(this.i), str).size() > 0) {
                u2.b().getItem(0).setVisible(false);
                u2.b().getItem(1).setVisible(true);
            } else {
                u2.b().getItem(0).setVisible(true);
                u2.b().getItem(1).setVisible(false);
            }
            u2.f(new c(streamIdOneStream, liveStreamsDBModel, str, oVar2, i2, arrayList));
            u2.g();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void f1(int i2, o oVar) {
        try {
            List list = this.d;
            if (list == null) {
                m7.w.X();
                return;
            }
            list.remove(Integer.valueOf(i2));
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                sb.append(this.d.get(i3));
                sb.append(",");
            }
            this.d.add(Integer.valueOf(i2));
            String substring = sb.toString().contains(",") ? sb.substring(0, sb.lastIndexOf(",")) : sb.toString();
            this.H = i2;
            this.G.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.i), SharepreferenceDBHandler.getStalkerToken(this.i), oVar, substring, "removed", "");
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    public final void g1(RecyclerView.D d2, int i2, ArrayList arrayList) {
        this.k.deleteFavourite(m7.w.r0(((LiveStreamsDBModel) arrayList.get(i2)).getStreamId()), ((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId(), ((LiveStreamsDBModel) arrayList.get(i2)).getStreamType(), ((LiveStreamsDBModel) arrayList.get(i2)).getName(), SharepreferenceDBHandler.getUserID(this.i), ((LiveStreamsDBModel) arrayList.get(i2)).getStreamIdOneStream());
        ((o) d2).y.setVisibility(4);
    }

    public Filter getFilter() {
        return this.m.equals("continue_watching") ? this.o : this.n;
    }

    public final void h1(RecyclerView.D d2, int i2, ArrayList arrayList) {
        this.F.deleteFavourite(((LiveStreamsDBModel) arrayList.get(i2)).getUrl(), SharepreferenceDBHandler.getUserID(this.i));
        ((o) d2).y.setVisibility(4);
    }

    public void i1() {
        this.r = false;
    }

    public int n() {
        ArrayList arrayList;
        if (this.m.equals("continue_watching")) {
            ArrayList arrayList2 = this.h;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return 0;
            }
            arrayList = this.h;
        } else {
            ArrayList arrayList3 = this.f;
            if (arrayList3 == null || arrayList3.size() <= 0) {
                return 0;
            }
            arrayList = this.f;
        }
        return arrayList.size();
    }

    public int p(int i2) {
        return 0;
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
    }

    public void H(String str) {
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public void c(String str) {
    }

    public void e(String str) {
    }

    public void e0(String str) {
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public void o0(String str) {
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    public void v0(String str) {
    }

    public void y0(String str) {
    }

    public class a implements com.squareup.picasso.e {
        public final /* synthetic */ o a;

        public a(o oVar) {
            this.a = oVar;
        }

        public void a() {
            com.squareup.picasso.t.q(t.r0(t.this)).l(String.valueOf(F.h.f(t.r0(t.this).getResources(), a7.e.B1, t.r0(t.this).getTheme()))).e().b().h(this.a.v, new a());
            this.a.t.setVisibility(0);
        }

        public class a implements com.squareup.picasso.e {
            public a() {
            }

            public void a() {
            }

            public void onSuccess() {
            }
        }

        public void onSuccess() {
        }
    }

    public class d implements com.squareup.picasso.e {
        public d() {
        }

        public void a() {
        }

        public void onSuccess() {
        }
    }

    public class e implements com.squareup.picasso.e {
        public e() {
        }

        public void a() {
        }

        public void onSuccess() {
        }
    }

    public void I(m0.x xVar, int i2) {
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
    }

    public void O(Z.E e2, int i2) {
    }

    public void G(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, Z.E e2, int i2) {
    }

    public void V0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, m0.x xVar, int i2) {
    }
}

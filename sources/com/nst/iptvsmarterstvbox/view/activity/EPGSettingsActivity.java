package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.EPGSourcesModel;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import d.a;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class EPGSettingsActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public RelativeLayout A;
    public RelativeLayout B;
    public TextView C;
    public ImageView D;
    public FrameLayout E;
    public Context F;
    public SharedPreferences G;
    public SharedPreferences.Editor H;
    public SharedPreferences I;
    public SharedPreferences.Editor J;
    public LiveStreamDBHandler K;
    public q7.m P;
    public ArrayList Q;
    public u7.a R;
    public ProgressDialog S;
    public Toolbar d;
    public AppBarLayout e;
    public Button f;
    public Button g;
    public RadioGroup h;
    public RadioButton i;
    public RadioButton j;
    public Spinner k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public Button o;
    public Button p;
    public Button q;
    public LinearLayout r;
    public LinearLayout s;
    public LinearLayout t;
    public TextView u;
    public TextView v;
    public TextView w;
    public RecyclerView x;
    public TextView y;
    public ImageView z;
    public DatabaseUpdatedStatusDBModel L = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel M = new DatabaseUpdatedStatusDBModel();
    public String N = "";
    public String O = "";
    public Thread T = null;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(EPGSettingsActivity.u1(EPGSettingsActivity.this));
                String A = w.A(date);
                TextView textView = EPGSettingsActivity.this.m;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = EPGSettingsActivity.this.l;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            w.j(EPGSettingsActivity.u1(EPGSettingsActivity.this));
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            EPGSettingsActivity.this.onBackPressed();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(EPGSettingsActivity.u1(EPGSettingsActivity.this));
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(EPGSettingsActivity.u1(EPGSettingsActivity.this));
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class j implements Runnable {
        public j() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    EPGSettingsActivity.this.K1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class k extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public EditText e;
        public Context f;
        public LiveStreamDBHandler g;
        public LinearLayout h;
        public LinearLayout i;

        public class a implements View.OnFocusChangeListener {
            public View a;

            public a(View view) {
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
                            b = k.b(k.this);
                        }
                    } else {
                        b = k.a(k.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = k.b(k.this);
                        }
                    } else {
                        b = k.a(k.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public k(Activity activity, Context context, LiveStreamDBHandler liveStreamDBHandler) {
            super(activity);
            this.a = activity;
            this.f = context;
            this.g = liveStreamDBHandler;
        }

        public static /* synthetic */ LinearLayout a(k kVar) {
            return kVar.h;
        }

        public static /* synthetic */ LinearLayout b(k kVar) {
            return kVar.i;
        }

        public void onClick(View view) {
            Context context;
            String string;
            int id = view.getId();
            if (id != a7.f.p1) {
                if (id == a7.f.X0) {
                    dismiss();
                    return;
                }
                return;
            }
            try {
                String trim = this.e.getText().toString().trim();
                try {
                    URI uri = new URI(this.e.getText().toString().trim());
                    trim = uri.getHost() == null ? this.e.getText().toString().trim() : uri.getHost();
                } catch (Exception unused) {
                }
                String trim2 = String.valueOf(this.e.getText()).trim();
                if (trim == null || trim.equals("") || trim.isEmpty()) {
                    context = this.f;
                    string = context.getResources().getString(a7.j.x1);
                } else if (trim2 == null || trim2.equals("") || trim2.isEmpty()) {
                    context = this.f;
                    string = context.getResources().getString(a7.j.y1);
                } else {
                    if (this.g.checkIfEPGSourceAlreadyExists(trim2) == 0) {
                        this.g.addEPGSource(trim, "custom", trim2, "0");
                        Context context2 = this.f;
                        Toast.makeText(context2, context2.getResources().getString(a7.j.k5), 0).show();
                        EPGSettingsActivity.G1(EPGSettingsActivity.this);
                        dismiss();
                        return;
                    }
                    context = this.f;
                    string = context.getResources().getString(a7.j.l7);
                }
                Toast.makeText(context, string, 0).show();
            } catch (Exception unused2) {
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(EPGSettingsActivity.F1(EPGSettingsActivity.this).A().equals(m7.a.K0) ? a7.g.M1 : a7.g.L1);
            this.c = findViewById(a7.f.p1);
            this.d = findViewById(a7.f.X0);
            this.h = findViewById(a7.f.V8);
            this.i = findViewById(a7.f.Ia);
            this.e = findViewById(a7.f.t3);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new a(textView));
            TextView textView2 = this.d;
            textView2.setOnFocusChangeListener(new a(textView2));
        }
    }

    public class l extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public SwitchCompat e;
        public LinearLayout f;
        public EditText g;
        public EditText h;
        public Context i;
        public LiveStreamDBHandler j;
        public EPGSourcesModel k;
        public boolean l;
        public String m;
        public int n;
        public String o;
        public LinearLayout p;
        public LinearLayout q;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                l.b(l.this).updateImportStatus("epg", "3", String.valueOf(l.a(l.this)));
                EPGSettingsActivity.G1(EPGSettingsActivity.this);
                if (EPGSettingsActivity.C1(EPGSettingsActivity.this) != null) {
                    EPGSettingsActivity ePGSettingsActivity = EPGSettingsActivity.this;
                    EPGSettingsActivity.y1(ePGSettingsActivity, EPGSettingsActivity.C1(ePGSettingsActivity), l.a(l.this));
                }
            }
        }

        public class b implements View.OnFocusChangeListener {
            public View a;

            public b(View view) {
                this.a = view;
            }

            public void onFocusChange(View view, boolean z) {
                LinearLayout d;
                int i;
                if (z) {
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                        View view3 = this.a;
                        if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            d = l.d(l.this);
                        }
                    } else {
                        d = l.c(l.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            d = l.d(l.this);
                        }
                    } else {
                        d = l.c(l.this);
                    }
                    i = a7.e.o;
                }
                d.setBackgroundResource(i);
            }
        }

        public l(Activity activity, Context context, LiveStreamDBHandler liveStreamDBHandler, EPGSourcesModel ePGSourcesModel) {
            super(activity);
            this.l = false;
            this.a = activity;
            this.i = context;
            this.j = liveStreamDBHandler;
            this.k = ePGSourcesModel;
        }

        public static /* synthetic */ int a(l lVar) {
            return lVar.n;
        }

        public static /* synthetic */ LiveStreamDBHandler b(l lVar) {
            return lVar.j;
        }

        public static /* synthetic */ LinearLayout c(l lVar) {
            return lVar.p;
        }

        public static /* synthetic */ LinearLayout d(l lVar) {
            return lVar.q;
        }

        /* JADX WARN: Removed duplicated region for block: B:78:0x01b5 A[Catch: Exception -> 0x01f3, TryCatch #0 {Exception -> 0x01f3, blocks: (B:14:0x0008, B:17:0x002b, B:19:0x0031, B:21:0x0037, B:24:0x004d, B:26:0x0053, B:29:0x005b, B:33:0x006a, B:36:0x0074, B:38:0x007c, B:40:0x00b0, B:42:0x00b4, B:43:0x00ef, B:45:0x00f3, B:47:0x00f9, B:49:0x0103, B:50:0x0108, B:52:0x010e, B:54:0x0120, B:56:0x0126, B:58:0x012c, B:59:0x0159, B:61:0x015f, B:63:0x017b, B:65:0x017f, B:66:0x0181, B:68:0x0189, B:69:0x0196, B:70:0x01a1, B:71:0x01ba, B:73:0x019e, B:74:0x016b, B:76:0x0171, B:78:0x01b5, B:79:0x00be, B:81:0x00d2, B:83:0x01be), top: B:13:0x0008 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r12) {
            /*
                Method dump skipped, instructions count: 500
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.l.onClick(android.view.View):void");
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(EPGSettingsActivity.F1(EPGSettingsActivity.this).A().equals(m7.a.K0) ? a7.g.z2 : a7.g.y2);
            this.c = findViewById(a7.f.p1);
            this.d = findViewById(a7.f.X0);
            this.p = findViewById(a7.f.V8);
            this.q = findViewById(a7.f.Ia);
            this.f = findViewById(a7.f.D7);
            this.e = findViewById(a7.f.Ng);
            this.g = findViewById(a7.f.s3);
            this.h = findViewById(a7.f.t3);
            this.g.setText(this.k.getName());
            this.h.setText(this.k.getEpgurl());
            this.m = this.k.getSource_type();
            this.n = this.k.getIdAuto();
            this.o = this.k.getEpgurl().trim();
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.f.setOnClickListener(this);
            if (this.k.getDefault_source().equals("1")) {
                this.e.setChecked(true);
                this.l = true;
            } else {
                this.e.setChecked(false);
                this.l = false;
            }
            if (this.k.getSource_type().equals("panel")) {
                this.g.setEnabled(false);
                if (m7.a.t.booleanValue()) {
                    this.g.setVisibility(0);
                } else {
                    this.g.setVisibility(8);
                }
                this.h.setEnabled(false);
                this.f.setVisibility(8);
                this.h.setVisibility(8);
                ArrayList ePGSources = this.j.getEPGSources();
                if (ePGSources == null || ePGSources.size() <= 1) {
                    this.e.setEnabled(false);
                } else {
                    this.e.setEnabled(true);
                }
            }
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new b(textView));
            TextView textView2 = this.d;
            textView2.setOnFocusChangeListener(new b(textView2));
        }
    }

    public class m extends Dialog implements View.OnClickListener {
        public final l a;
        public final int c;
        public final boolean d;
        public Activity e;
        public TextView f;
        public TextView g;
        public TextView h;
        public TextView i;
        public LinearLayout j;
        public LinearLayout k;

        public class a implements View.OnFocusChangeListener {
            public View a;

            public a(View view) {
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
                            b = m.b(m.this);
                        }
                    } else {
                        b = m.a(m.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = m.b(m.this);
                        }
                    } else {
                        b = m.a(m.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public m(Activity activity, l lVar, int i, boolean z) {
            super(activity);
            this.e = activity;
            this.a = lVar;
            this.c = i;
            this.d = z;
        }

        public static /* synthetic */ LinearLayout a(m mVar) {
            return mVar.j;
        }

        public static /* synthetic */ LinearLayout b(m mVar) {
            return mVar.k;
        }

        public void onClick(View view) {
            if (view.getId() != a7.f.u1) {
                if (view.getId() == a7.f.h1) {
                    dismiss();
                    return;
                }
                return;
            }
            EPGSettingsActivity.v1(EPGSettingsActivity.this).deleteEPGSource(this.c);
            EPGSettingsActivity.v1(EPGSettingsActivity.this).deleteImportStatusForUser(SharepreferenceDBHandler.getUserID(EPGSettingsActivity.u1(EPGSettingsActivity.this)), String.valueOf(this.c), SharepreferenceDBHandler.getCurrentAPPType(EPGSettingsActivity.u1(EPGSettingsActivity.this)));
            EPGSettingsActivity.v1(EPGSettingsActivity.this).makeEmptyEPGWithSourceRef(String.valueOf(this.c));
            if (this.d) {
                EPGSettingsActivity.v1(EPGSettingsActivity.this).updatePanelEPGSourceToDefault();
            }
            Toast.makeText(EPGSettingsActivity.u1(EPGSettingsActivity.this), EPGSettingsActivity.u1(EPGSettingsActivity.this).getResources().getString(a7.j.m7), 0).show();
            EPGSettingsActivity.G1(EPGSettingsActivity.this);
            dismiss();
            this.a.dismiss();
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(EPGSettingsActivity.F1(EPGSettingsActivity.this).A().equals(m7.a.K0) ? a7.g.b2 : a7.g.a2);
            this.f = findViewById(a7.f.u1);
            this.g = findViewById(a7.f.h1);
            this.j = findViewById(a7.f.V8);
            this.k = findViewById(a7.f.Ia);
            this.i = findViewById(a7.f.fm);
            this.h = findViewById(a7.f.um);
            this.i.setText(EPGSettingsActivity.u1(EPGSettingsActivity.this).getResources().getString(a7.j.K0));
            this.h.setText(EPGSettingsActivity.u1(EPGSettingsActivity.this).getResources().getString(a7.j.M8));
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            TextView textView = this.f;
            textView.setOnFocusChangeListener(new a(textView));
            TextView textView2 = this.g;
            textView2.setOnFocusChangeListener(new a(textView2));
        }
    }

    public class n extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public LinearLayout g;
        public LinearLayout h;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            public void run() {
                EPGSettingsActivity.v1(EPGSettingsActivity.this).updateImportStatus("epg", "3", this.a);
                EPGSettingsActivity.G1(EPGSettingsActivity.this);
                if (EPGSettingsActivity.C1(EPGSettingsActivity.this) != null) {
                    EPGSettingsActivity ePGSettingsActivity = EPGSettingsActivity.this;
                    EPGSettingsActivity.y1(ePGSettingsActivity, EPGSettingsActivity.C1(ePGSettingsActivity), w.r0(this.a));
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
                            b = n.b(n.this);
                        }
                    } else {
                        b = n.a(n.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = n.b(n.this);
                        }
                    } else {
                        b = n.a(n.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public n(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(n nVar) {
            return nVar.g;
        }

        public static /* synthetic */ LinearLayout b(n nVar) {
            return nVar.h;
        }

        public void onClick(View view) {
            EPGSettingsActivity ePGSettingsActivity;
            if (view.getId() != a7.f.u1) {
                if (view.getId() == a7.f.h1) {
                    dismiss();
                    return;
                }
                return;
            }
            try {
                if (m7.a.I0) {
                    m7.a.I0 = false;
                }
                ArrayList activeEPGSource = EPGSettingsActivity.v1(EPGSettingsActivity.this).getActiveEPGSource();
                String valueOf = (activeEPGSource == null || activeEPGSource.size() <= 0) ? "0" : String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto());
                ImportStatusModel importStatusModel = EPGSettingsActivity.v1(EPGSettingsActivity.this).getdateDBStatus("epg", valueOf);
                if (importStatusModel.getStatus() == null && importStatusModel.getTime() == null && importStatusModel.getType() == null) {
                    ImportStatusModel importStatusModel2 = new ImportStatusModel();
                    importStatusModel2.setType("epg");
                    importStatusModel2.setStatus("0");
                    importStatusModel2.setDate("");
                    importStatusModel2.setTime("");
                    importStatusModel2.setSourceRef(valueOf);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(0, importStatusModel2);
                    EPGSettingsActivity.v1(EPGSettingsActivity.this).importDataStatusArrayList(arrayList, SharepreferenceDBHandler.getCurrentAPPType(EPGSettingsActivity.u1(EPGSettingsActivity.this)));
                }
                if (EPGSettingsActivity.w1(EPGSettingsActivity.this) == null) {
                    EPGSettingsActivity ePGSettingsActivity2 = EPGSettingsActivity.this;
                    EPGSettingsActivity.x1(ePGSettingsActivity2, EPGSettingsActivity.J1(EPGSettingsActivity.u1(ePGSettingsActivity2)));
                    ePGSettingsActivity = EPGSettingsActivity.this;
                } else {
                    ePGSettingsActivity = EPGSettingsActivity.this;
                }
                EPGSettingsActivity.w1(ePGSettingsActivity).show();
                new Handler(Looper.getMainLooper()).postDelayed(new a(valueOf), 1000L);
                dismiss();
            } catch (Exception unused) {
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(EPGSettingsActivity.F1(EPGSettingsActivity.this).A().equals(m7.a.K0) ? a7.g.b2 : a7.g.a2);
            this.c = findViewById(a7.f.u1);
            this.d = findViewById(a7.f.h1);
            this.g = findViewById(a7.f.V8);
            this.h = findViewById(a7.f.Ia);
            this.f = findViewById(a7.f.fm);
            this.e = findViewById(a7.f.um);
            this.f.setText(EPGSettingsActivity.u1(EPGSettingsActivity.this).getResources().getString(a7.j.Z5));
            this.e.setText(EPGSettingsActivity.u1(EPGSettingsActivity.this).getResources().getString(a7.j.a6));
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new b(textView));
            TextView textView2 = this.d;
            textView2.setOnFocusChangeListener(new b(textView2));
        }
    }

    public class o extends AsyncTask {
        public String a = "0";
        public ArrayList b;

        public o(Context context) {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                publishProgress(new Integer[]{0});
                ArrayList ePGSources = EPGSettingsActivity.v1(EPGSettingsActivity.this).getEPGSources();
                this.b = ePGSources;
                if (ePGSources == null || ePGSources.size() <= 0) {
                    return Boolean.FALSE;
                }
                ArrayList activeEPGSource = EPGSettingsActivity.v1(EPGSettingsActivity.this).getActiveEPGSource();
                if (activeEPGSource != null && activeEPGSource.size() > 0) {
                    this.a = String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto());
                }
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            try {
                if (bool.booleanValue()) {
                    EPGSettingsActivity.this.u.setVisibility(0);
                    EPGSettingsActivity.this.B.setVisibility(0);
                    EPGSettingsActivity.this.C.setVisibility(0);
                    EPGSettingsActivity.this.y.setVisibility(8);
                    EPGSettingsActivity.this.x.setVisibility(0);
                    EPGSettingsActivity.this.x.setLayoutManager(new LinearLayoutManager(EPGSettingsActivity.u1(EPGSettingsActivity.this), 1, false));
                    EPGSettingsActivity.this.x.setItemAnimator(new androidx.recyclerview.widget.c());
                    EPGSettingsActivity ePGSettingsActivity = EPGSettingsActivity.this;
                    EPGSettingsActivity.D1(ePGSettingsActivity, new q7.m(EPGSettingsActivity.u1(ePGSettingsActivity), this.b));
                    EPGSettingsActivity ePGSettingsActivity2 = EPGSettingsActivity.this;
                    ePGSettingsActivity2.x.setAdapter(EPGSettingsActivity.C1(ePGSettingsActivity2));
                    EPGSettingsActivity.E1(EPGSettingsActivity.this, this.a);
                } else {
                    EPGSettingsActivity.this.u.setVisibility(8);
                    EPGSettingsActivity.this.B.setVisibility(8);
                    EPGSettingsActivity.this.y.setVisibility(0);
                    EPGSettingsActivity.this.x.setVisibility(8);
                    EPGSettingsActivity.this.C.setVisibility(8);
                }
            } catch (Exception unused) {
            }
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        public void onCancelled() {
        }

        public void onPreExecute() {
        }
    }

    public class p implements View.OnFocusChangeListener {
        public final View a;

        public p(View view) {
            this.a = view;
        }

        public final void a(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            View view2;
            int i;
            Button button;
            if (z) {
                f = z ? 1.05f : 1.0f;
                Log.e("id is", "" + this.a.getTag());
                if (!this.a.getTag().equals("1") && !this.a.getTag().equals("2")) {
                    if (this.a.getTag().equals("bt_epg_sources")) {
                        button = EPGSettingsActivity.this.o;
                    } else if (this.a.getTag().equals("bt_epg_timeline")) {
                        button = EPGSettingsActivity.this.p;
                    } else {
                        if (!this.a.getTag().equals("bt_epg_timeshift")) {
                            if (this.a.getTag().equals("rb_withepg") || this.a.getTag().equals("rb_allchannels")) {
                                this.a.setBackground(EPGSettingsActivity.this.getResources().getDrawable(a7.e.K1));
                                return;
                            } else {
                                a(1.05f);
                                b(1.05f);
                                return;
                            }
                        }
                        button = EPGSettingsActivity.this.q;
                    }
                    button.performClick();
                    return;
                }
                a(f);
                b(f);
                view2 = this.a;
                i = a7.e.k1;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                a(f);
                b(f);
                if (!this.a.getTag().equals("1") && !this.a.getTag().equals("2")) {
                    return;
                }
                view2 = this.a;
                i = a7.e.o;
            }
            view2.setBackgroundResource(i);
        }
    }

    public class q extends AsyncTask {
        public final q7.m a;
        public B7.d b;
        public String c;

        public class a extends AsyncTask {
            public volatile boolean a = true;
            public Context b;

            public a(Context context) {
                this.b = context;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(String... strArr) {
                publishProgress(new Integer[]{0});
                if (EPGSettingsActivity.v1(EPGSettingsActivity.this) != null) {
                    EPGSettingsActivity.v1(EPGSettingsActivity.this).addEPGTesting2(EPGSettingsActivity.z1(EPGSettingsActivity.this));
                    EPGSettingsActivity.z1(EPGSettingsActivity.this).clear();
                    EPGSettingsActivity.v1(EPGSettingsActivity.this).updateImportStatus("epg", "1", q.this.c);
                }
                return Boolean.TRUE;
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
                EPGSettingsActivity ePGSettingsActivity = EPGSettingsActivity.this;
                EPGSettingsActivity.B1(ePGSettingsActivity, ePGSettingsActivity.getSharedPreferences("loginPrefs", 0));
                try {
                    EPGSettingsActivity.G1(EPGSettingsActivity.this);
                } catch (Exception unused) {
                }
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onProgressUpdate(Integer... numArr) {
            }

            public void onCancelled() {
                this.a = false;
            }

            public void onPreExecute() {
            }
        }

        public q(q7.m mVar, int i) {
            this.c = "0";
            this.a = mVar;
            this.c = String.valueOf(i);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            if (!this.c.equals("0") && EPGSettingsActivity.v1(EPGSettingsActivity.this) != null) {
                EPGSettingsActivity.v1(EPGSettingsActivity.this).makeEmptyEPGWithSourceRef(this.c);
            }
            Log.e("honey", "epg 1");
            this.b = new B7.d();
            Log.e("honey", "epg 2");
            this.b.a(EPGSettingsActivity.u1(EPGSettingsActivity.this));
            Log.e("honey", "epg 3");
            EPGSettingsActivity.A1(EPGSettingsActivity.this, this.b.b());
            Log.e("honey", "epg 4");
            if (EPGSettingsActivity.z1(EPGSettingsActivity.this) != null && EPGSettingsActivity.z1(EPGSettingsActivity.this).size() > 0) {
                Log.e("honey", "size:" + EPGSettingsActivity.z1(EPGSettingsActivity.this).size());
            } else {
                if (EPGSettingsActivity.v1(EPGSettingsActivity.this).getEPGCountWithSourceRef(this.c) == 0) {
                    return Boolean.FALSE;
                }
                EPGSettingsActivity.v1(EPGSettingsActivity.this).updateImportStatus("epg", "1", this.c);
            }
            return Boolean.TRUE;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPostExecute(java.lang.Boolean r4) {
            /*
                r3 = this;
                boolean r4 = r4.booleanValue()
                java.lang.String r0 = "epg"
                if (r4 == 0) goto L58
                r4 = 0
                m7.a.I0 = r4
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity r1 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.this
                java.util.ArrayList r1 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.z1(r1)
                if (r1 == 0) goto L4a
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity r1 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.this
                java.util.ArrayList r1 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.z1(r1)
                int r1 = r1.size()
                if (r1 <= 0) goto L4a
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity$q$a r1 = new com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity$q$a     // Catch: java.lang.Exception -> L35
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity r2 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.this     // Catch: java.lang.Exception -> L35
                android.content.Context r2 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.u1(r2)     // Catch: java.lang.Exception -> L35
                r1.<init>(r2)     // Catch: java.lang.Exception -> L35
                java.util.concurrent.Executor r2 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Exception -> L35
                java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L35
                android.os.AsyncTask r4 = r1.executeOnExecutor(r2, r4)     // Catch: java.lang.Exception -> L35
                m7.w.r = r4     // Catch: java.lang.Exception -> L35
                goto L68
            L35:
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity r4 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.this     // Catch: java.lang.Exception -> L48
                com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler r4 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.v1(r4)     // Catch: java.lang.Exception -> L48
                java.lang.String r1 = "0"
                java.lang.String r2 = r3.c     // Catch: java.lang.Exception -> L48
                r4.updateImportStatus(r0, r1, r2)     // Catch: java.lang.Exception -> L48
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity r4 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.this     // Catch: java.lang.Exception -> L48
            L44:
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.G1(r4)     // Catch: java.lang.Exception -> L48
                goto L68
            L48:
                goto L68
            L4a:
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity r0 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.this
                java.lang.String r1 = "loginPrefs"
                android.content.SharedPreferences r4 = r0.getSharedPreferences(r1, r4)
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.B1(r0, r4)
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity r4 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.this     // Catch: java.lang.Exception -> L48
                goto L44
            L58:
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity r4 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.this     // Catch: java.lang.Exception -> L48
                com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler r4 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.v1(r4)     // Catch: java.lang.Exception -> L48
                java.lang.String r1 = "2"
                java.lang.String r2 = r3.c     // Catch: java.lang.Exception -> L48
                r4.updateImportStatus(r0, r1, r2)     // Catch: java.lang.Exception -> L48
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity r4 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.this     // Catch: java.lang.Exception -> L48
                goto L44
            L68:
                java.io.File r4 = new java.io.File
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity r1 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.this
                android.content.Context r1 = com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.u1(r1)
                java.io.File r1 = r1.getFilesDir()
                r0.append(r1)
                java.lang.String r1 = "/epgZip.xml"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r4.<init>(r0)
                java.io.File r0 = new java.io.File
                java.lang.String r4 = java.lang.String.valueOf(r4)
                r0.<init>(r4)
                boolean r4 = r0.exists()
                if (r4 == 0) goto L9a
                r0.delete()
            L9a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.EPGSettingsActivity.q.onPostExecute(java.lang.Boolean):void");
        }

        public void onPreExecute() {
            EPGSettingsActivity.this.N1();
        }
    }

    public static /* synthetic */ ArrayList A1(EPGSettingsActivity ePGSettingsActivity, ArrayList arrayList) {
        ePGSettingsActivity.Q = arrayList;
        return arrayList;
    }

    public static /* synthetic */ SharedPreferences B1(EPGSettingsActivity ePGSettingsActivity, SharedPreferences sharedPreferences) {
        ePGSettingsActivity.G = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ q7.m C1(EPGSettingsActivity ePGSettingsActivity) {
        return ePGSettingsActivity.P;
    }

    public static /* synthetic */ q7.m D1(EPGSettingsActivity ePGSettingsActivity, q7.m mVar) {
        ePGSettingsActivity.P = mVar;
        return mVar;
    }

    public static /* synthetic */ void E1(EPGSettingsActivity ePGSettingsActivity, String str) {
        ePGSettingsActivity.S1(str);
    }

    public static /* synthetic */ u7.a F1(EPGSettingsActivity ePGSettingsActivity) {
        return ePGSettingsActivity.R;
    }

    public static /* synthetic */ void G1(EPGSettingsActivity ePGSettingsActivity) {
        ePGSettingsActivity.R1();
    }

    private void H1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public static ProgressDialog J1(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        try {
            progressDialog.show();
        } catch (Exception unused) {
        }
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        progressDialog.setContentView(a7.g.e4);
        return progressDialog;
    }

    private void M1() {
        Button button = this.f;
        if (button != null) {
            button.setOnFocusChangeListener(new p(button));
        }
        Button button2 = this.g;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new p(button2));
        }
        Button button3 = this.o;
        button3.setOnFocusChangeListener(new p(button3));
        Button button4 = this.p;
        button4.setOnFocusChangeListener(new p(button4));
        Button button5 = this.q;
        button5.setOnFocusChangeListener(new p(button5));
        RadioButton radioButton = this.i;
        if (radioButton != null) {
            radioButton.setOnFocusChangeListener(new p(radioButton));
        }
        RadioButton radioButton2 = this.j;
        if (radioButton2 != null) {
            radioButton2.setOnFocusChangeListener(new p(radioButton2));
        }
        Spinner spinner = this.k;
        if (spinner != null) {
            spinner.setOnFocusChangeListener(new p(spinner));
        }
    }

    private void P1() {
        TextView textView;
        Resources resources;
        int i2;
        this.K = new LiveStreamDBHandler(this.F);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.G = sharedPreferences;
        String string = sharedPreferences.getString("selectedEPGShift", m7.a.C0);
        int N = w.N(string);
        if (string.equals("")) {
            this.w.setText("0");
        } else {
            this.w.setText(string);
        }
        this.k.setSelection(N);
        SharedPreferences sharedPreferences2 = getSharedPreferences("epgchannelupdate", 0);
        this.I = sharedPreferences2;
        if (sharedPreferences2.getString("epgchannelupdate", "").equals("all")) {
            this.j.setChecked(true);
            textView = this.v;
            resources = this.F.getResources();
            i2 = a7.j.z;
        } else {
            this.i.setChecked(true);
            textView = this.v;
            resources = this.F.getResources();
            i2 = a7.j.D1;
        }
        textView.setText(resources.getString(i2));
        R1();
        this.z.setOnClickListener(new b());
        this.n.setOnClickListener(new c());
    }

    public static /* synthetic */ Context u1(EPGSettingsActivity ePGSettingsActivity) {
        return ePGSettingsActivity.F;
    }

    public static /* synthetic */ LiveStreamDBHandler v1(EPGSettingsActivity ePGSettingsActivity) {
        return ePGSettingsActivity.K;
    }

    public static /* synthetic */ ProgressDialog w1(EPGSettingsActivity ePGSettingsActivity) {
        return ePGSettingsActivity.S;
    }

    public static /* synthetic */ ProgressDialog x1(EPGSettingsActivity ePGSettingsActivity, ProgressDialog progressDialog) {
        ePGSettingsActivity.S = progressDialog;
        return progressDialog;
    }

    public static /* synthetic */ void y1(EPGSettingsActivity ePGSettingsActivity, q7.m mVar, int i2) {
        ePGSettingsActivity.Q1(mVar, i2);
    }

    public static /* synthetic */ ArrayList z1(EPGSettingsActivity ePGSettingsActivity) {
        return ePGSettingsActivity.Q;
    }

    public final void I1() {
        FrameLayout frameLayout;
        int i2 = 8;
        if (m7.a.V0.booleanValue() && (this.R.k() == null || this.R.n() == null || this.R.l() == 0 || this.R.k().equals("") || this.R.n().equals(""))) {
            frameLayout = this.E;
            i2 = 0;
        } else {
            frameLayout = this.E;
        }
        frameLayout.setVisibility(i2);
        this.D.setVisibility(i2);
    }

    public void K1() {
        runOnUiThread(new a());
    }

    public void L1(EPGSourcesModel ePGSourcesModel) {
        new l(this, this.F, this.K, ePGSourcesModel).show();
    }

    public void N1() {
        try {
            ProgressDialog progressDialog = this.S;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            Log.e("honey", "hideProgressDialog");
            this.S.dismiss();
        } catch (Exception unused) {
        }
    }

    public void O1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public final void Q1(q7.m mVar, int i2) {
        new q(mVar, i2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void R1() {
        if (this.x != null) {
            new o(this.F).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    public final void S1(String str) {
        try {
            this.C.setText(getResources().getString(a7.j.E1, new Object[]{String.valueOf(this.K.getTotalNumberOFChannelsWithEPG(str))}));
        } catch (Exception unused) {
        }
    }

    public void T1(String str) {
        this.u.setText(str);
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007e -> B:26:0x0205). Please report as a decompilation issue!!! */
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView;
        Resources resources;
        int i2;
        Resources resources2;
        int i3;
        Toast makeText;
        Dialog nVar;
        int id = view.getId();
        if (id == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
            return;
        }
        if (id == a7.f.V6) {
            try {
                if (!m7.a.o.booleanValue()) {
                    new k(this, this.F, this.K).show();
                } else if (!m7.a.V0.booleanValue()) {
                    nVar = new k(this, this.F, this.K);
                } else if (this.R.k() == null || this.R.n() == null || this.R.l() == 0 || this.R.k().equals("") || this.R.n().equals("")) {
                    new w.j(this, this.F, this.R).show();
                } else {
                    nVar = new k(this, this.F, this.K);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return;
        }
        if (id == a7.f.G9) {
            ArrayList activeEPGSource = this.K.getActiveEPGSource();
            if (((activeEPGSource == null || activeEPGSource.size() <= 0) ? "0" : String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto())).equals("0")) {
                makeText = Toast.makeText(this, getResources().getString(a7.j.M6), 1);
            } else {
                nVar = new n(this);
            }
        } else {
            if (id == a7.f.F0) {
                SharedPreferences.Editor edit = this.G.edit();
                this.H = edit;
                if (edit != null) {
                    edit.putString("selectedEPGShift", String.valueOf(this.k.getSelectedItem()));
                    this.H.apply();
                    this.w.setText(String.valueOf(this.k.getSelectedItem()));
                    resources2 = getResources();
                    i3 = a7.j.k5;
                }
                resources2 = getResources();
                i3 = a7.j.j5;
            } else {
                if (id != a7.f.G0) {
                    if (id == a7.f.p0) {
                        this.r.setVisibility(0);
                        this.o.setBackgroundResource(a7.e.p);
                        this.p.setBackgroundResource(a7.e.o);
                        this.q.setBackgroundResource(a7.e.o);
                        linearLayout2 = this.s;
                    } else {
                        if (id != a7.f.q0) {
                            if (id != a7.f.r0) {
                                if (id == a7.f.S0) {
                                    finish();
                                    return;
                                }
                                return;
                            }
                            this.t.setVisibility(0);
                            this.q.setBackgroundResource(a7.e.p);
                            this.o.setBackgroundResource(a7.e.o);
                            this.p.setBackgroundResource(a7.e.o);
                            this.r.setVisibility(8);
                            linearLayout = this.s;
                            linearLayout.setVisibility(8);
                            return;
                        }
                        this.s.setVisibility(0);
                        this.p.setBackgroundResource(a7.e.p);
                        this.o.setBackgroundResource(a7.e.o);
                        this.q.setBackgroundResource(a7.e.o);
                        linearLayout2 = this.r;
                    }
                    linearLayout2.setVisibility(8);
                    linearLayout = this.t;
                    linearLayout.setVisibility(8);
                    return;
                }
                RadioButton findViewById = findViewById(this.h.getCheckedRadioButtonId());
                SharedPreferences sharedPreferences = getSharedPreferences("epgchannelupdate", 0);
                this.I = sharedPreferences;
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                this.J = edit2;
                if (edit2 != null) {
                    if (findViewById.getText().toString().equals(getResources().getString(a7.j.y))) {
                        this.J.putString("epgchannelupdate", "all");
                        textView = this.v;
                        resources = getResources();
                        i2 = a7.j.z;
                    } else {
                        this.J.putString("epgchannelupdate", "withepg");
                        textView = this.v;
                        resources = getResources();
                        i2 = a7.j.D1;
                    }
                    textView.setText(resources.getString(i2));
                    this.J.apply();
                    resources2 = getResources();
                    i3 = a7.j.k5;
                }
                resources2 = getResources();
                i3 = a7.j.j5;
            }
            makeText = Toast.makeText(this, resources2.getString(i3), 0);
        }
        makeText.show();
        return;
        nVar.show();
    }

    public void onCreate(Bundle bundle) {
        this.F = this;
        O1();
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.F);
        this.R = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? a7.g.x : a7.g.w);
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.F0);
        this.g = findViewById(a7.f.G0);
        this.h = findViewById(a7.f.Kd);
        this.i = findViewById(a7.f.yd);
        this.j = findViewById(a7.f.ed);
        this.k = findViewById(a7.f.Cg);
        this.l = findViewById(a7.f.E2);
        this.m = findViewById(a7.f.gh);
        this.n = findViewById(a7.f.F4);
        this.o = findViewById(a7.f.p0);
        this.p = findViewById(a7.f.q0);
        this.q = findViewById(a7.f.r0);
        this.r = findViewById(a7.f.Z7);
        this.s = findViewById(a7.f.a8);
        this.t = findViewById(a7.f.b8);
        this.u = findViewById(a7.f.hj);
        this.v = findViewById(a7.f.ij);
        this.w = findViewById(a7.f.jj);
        this.x = findViewById(a7.f.Ef);
        this.y = findViewById(a7.f.zk);
        this.z = findViewById(a7.f.Xa);
        this.A = findViewById(a7.f.V6);
        this.B = findViewById(a7.f.G9);
        this.C = findViewById(a7.f.gj);
        this.D = findViewById(a7.f.V2);
        this.E = findViewById(a7.f.T2);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.A.setOnClickListener(this);
        if (m7.a.o.booleanValue()) {
            I1();
        } else {
            this.E.setVisibility(8);
            this.D.setVisibility(8);
        }
        M1();
        H1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        P1();
        Thread thread = this.T;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new j());
            this.T = thread2;
            thread2.start();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.d.x(a7.h.v);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            if (this.d.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.d.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.e && (context = this.F) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new e()).g(getResources().getString(a7.j.d4), new d()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.F.getResources().getString(a7.j.u0));
            aVar.f(this.F.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.F.getResources().getString(a7.j.S8), new f());
            aVar.g(this.F.getResources().getString(a7.j.d4), new g());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.F.getResources().getString(a7.j.u0));
            aVar2.f(this.F.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.F.getResources().getString(a7.j.S8), new h());
            aVar2.g(this.F.getResources().getString(a7.j.d4), new i());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.T;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.T.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        O1();
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.T;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new j());
            this.T = thread2;
            thread2.start();
        }
        w.m(this.F);
        w.z0(this.F);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.G = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.G.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        O1();
    }
}

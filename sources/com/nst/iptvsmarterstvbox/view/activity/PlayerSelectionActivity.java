package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass;
import d.a;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PlayerSelectionActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public LiveStreamDBHandler A;
    public ExternalPlayerDataBase F;
    public u7.a Q;
    public Toolbar d;
    public AppBarLayout e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public RelativeLayout m;
    public Spinner n;
    public Spinner o;
    public Spinner p;
    public Spinner q;
    public Spinner r;
    public Spinner s;
    public ImageView t;
    public Button u;
    public Button v;
    public LinearLayout w;
    public LinearLayout x;
    public Context y;
    public SharedPreferences z;
    public DatabaseUpdatedStatusDBModel B = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel C = new DatabaseUpdatedStatusDBModel();
    public String D = "";
    public String E = "";
    public ArrayList G = new ArrayList();
    public ArrayList H = new ArrayList();
    public ArrayList I = new ArrayList();
    public ArrayList J = new ArrayList();
    public int K = 0;
    public int L = 0;
    public int M = 0;
    public int N = 0;
    public int O = 0;
    public int P = 0;
    public Thread R = null;

    public class a implements View.OnClickListener {
        public final /* synthetic */ PopupWindow a;

        public a(PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        public void onClick(View view) {
            PlayerSelectionActivity.D1(PlayerSelectionActivity.this);
            PopupWindow popupWindow = this.a;
            if (popupWindow == null || !popupWindow.isShowing()) {
                return;
            }
            this.a.dismiss();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            w.j(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
        }
    }

    public class i implements AdapterView.OnItemSelectedListener {
        public final /* synthetic */ LinkedHashMap a;
        public final /* synthetic */ List c;

        public i(LinkedHashMap linkedHashMap, List list) {
            this.a = linkedHashMap;
            this.c = list;
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            new SharepreferenceDBHandler();
            if (PlayerSelectionActivity.v1(PlayerSelectionActivity.this) == i) {
                String ePGPlayerPKGName = SharepreferenceDBHandler.getEPGPlayerPKGName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                String ePGPlayerAppName = SharepreferenceDBHandler.getEPGPlayerAppName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                if (ePGPlayerPKGName == null || ePGPlayerPKGName.isEmpty() || ePGPlayerPKGName.equals("")) {
                    return;
                }
                int E1 = PlayerSelectionActivity.E1(PlayerSelectionActivity.this, this.c, ePGPlayerPKGName, ePGPlayerAppName, this.a);
                if (this.c.toString().contains(ePGPlayerAppName)) {
                    Log.i("calledPart", "ifCalled");
                    PlayerSelectionActivity.this.s.setSelection(E1);
                    return;
                } else {
                    Log.i("calledPart", "elseCalled");
                    PlayerSelectionActivity.F1(PlayerSelectionActivity.this);
                    return;
                }
            }
            PlayerSelectionActivity.y1(PlayerSelectionActivity.this, i);
            PlayerSelectionActivity.this.s.setSelection(i);
            if (this.a.containsKey(this.c.get(i))) {
                String str = (String) this.a.get(this.c.get(i));
                String str2 = (String) PlayerSelectionActivity.U1(this.a, str);
                if (str == null || str.isEmpty() || str.equals("") || PlayerSelectionActivity.u1(PlayerSelectionActivity.this) == null || str2 == null || str2.isEmpty() || str2.equals("")) {
                    return;
                }
                SharepreferenceDBHandler.setEPGPlayer(str, str2, PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public final /* synthetic */ LinkedHashMap a;
        public final /* synthetic */ List c;

        public j(LinkedHashMap linkedHashMap, List list) {
            this.a = linkedHashMap;
            this.c = list;
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            new SharepreferenceDBHandler();
            if (PlayerSelectionActivity.G1(PlayerSelectionActivity.this) == i) {
                String recordingsPlayerPkgName = SharepreferenceDBHandler.getRecordingsPlayerPkgName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                String recordingsPlayerAppName = SharepreferenceDBHandler.getRecordingsPlayerAppName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                if (recordingsPlayerPkgName == null || recordingsPlayerPkgName.isEmpty() || recordingsPlayerPkgName.equals("")) {
                    return;
                }
                int E1 = PlayerSelectionActivity.E1(PlayerSelectionActivity.this, this.c, recordingsPlayerPkgName, recordingsPlayerAppName, this.a);
                if (this.c.toString().contains(recordingsPlayerAppName)) {
                    Log.i("calledPart", "ifCalled");
                    PlayerSelectionActivity.this.r.setSelection(E1);
                    return;
                } else {
                    Log.i("calledPart", "elseCalled");
                    PlayerSelectionActivity.I1(PlayerSelectionActivity.this);
                    return;
                }
            }
            PlayerSelectionActivity.H1(PlayerSelectionActivity.this, i);
            PlayerSelectionActivity.this.r.setSelection(i);
            if (this.a.containsKey(this.c.get(i))) {
                String str = (String) this.a.get(this.c.get(i));
                String str2 = (String) PlayerSelectionActivity.U1(this.a, str);
                if (str == null || str.isEmpty() || str.equals("") || PlayerSelectionActivity.u1(PlayerSelectionActivity.this) == null || str2 == null || str2.isEmpty() || str2.equals("")) {
                    return;
                }
                SharepreferenceDBHandler.setRecordingsPlayer(str, str2, PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class k implements AdapterView.OnItemSelectedListener {
        public final /* synthetic */ LinkedHashMap a;
        public final /* synthetic */ List c;

        public k(LinkedHashMap linkedHashMap, List list) {
            this.a = linkedHashMap;
            this.c = list;
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            new SharepreferenceDBHandler();
            if (PlayerSelectionActivity.J1(PlayerSelectionActivity.this) == i) {
                String catchUpPlayerPkgName = SharepreferenceDBHandler.getCatchUpPlayerPkgName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                String catchUpPlayerAppName = SharepreferenceDBHandler.getCatchUpPlayerAppName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                if (catchUpPlayerPkgName == null || catchUpPlayerPkgName.isEmpty() || catchUpPlayerPkgName.equals("")) {
                    return;
                }
                int E1 = PlayerSelectionActivity.E1(PlayerSelectionActivity.this, this.c, catchUpPlayerPkgName, catchUpPlayerAppName, this.a);
                if (this.c.toString().contains(catchUpPlayerAppName)) {
                    Log.i("calledPart", "ifCalled");
                    PlayerSelectionActivity.this.q.setSelection(E1);
                    return;
                } else {
                    Log.i("calledPart", "elseCalled");
                    PlayerSelectionActivity.L1(PlayerSelectionActivity.this);
                    return;
                }
            }
            PlayerSelectionActivity.K1(PlayerSelectionActivity.this, i);
            PlayerSelectionActivity.this.q.setSelection(i);
            if (this.a.containsKey(this.c.get(i))) {
                String str = (String) this.a.get(this.c.get(i));
                String str2 = (String) PlayerSelectionActivity.U1(this.a, str);
                if (str == null || str.isEmpty() || str.equals("") || PlayerSelectionActivity.u1(PlayerSelectionActivity.this) == null || str2 == null || str2.isEmpty() || str2.equals("")) {
                    return;
                }
                SharepreferenceDBHandler.setCatchUpPlayer(str, str2, PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class l implements AdapterView.OnItemSelectedListener {
        public final /* synthetic */ LinkedHashMap a;
        public final /* synthetic */ List c;

        public l(LinkedHashMap linkedHashMap, List list) {
            this.a = linkedHashMap;
            this.c = list;
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            new SharepreferenceDBHandler();
            if (PlayerSelectionActivity.M1(PlayerSelectionActivity.this) == i) {
                String seriesPlayerPkgName = SharepreferenceDBHandler.getSeriesPlayerPkgName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                String seriesPlayerAppName = SharepreferenceDBHandler.getSeriesPlayerAppName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                if (seriesPlayerPkgName == null || seriesPlayerPkgName.isEmpty() || seriesPlayerPkgName.equals("")) {
                    return;
                }
                int E1 = PlayerSelectionActivity.E1(PlayerSelectionActivity.this, this.c, seriesPlayerPkgName, seriesPlayerAppName, this.a);
                if (this.c.toString().contains(seriesPlayerAppName)) {
                    Log.i("calledPart", "ifCalled");
                    PlayerSelectionActivity.this.p.setSelection(E1);
                    return;
                } else {
                    Log.i("calledPart", "elseCalled");
                    PlayerSelectionActivity.O1(PlayerSelectionActivity.this);
                    return;
                }
            }
            PlayerSelectionActivity.N1(PlayerSelectionActivity.this, i);
            PlayerSelectionActivity.this.p.setSelection(i);
            if (this.a.containsKey(this.c.get(i))) {
                String str = (String) this.a.get(this.c.get(i));
                String str2 = (String) PlayerSelectionActivity.U1(this.a, str);
                if (str == null || str.isEmpty() || str.equals("") || PlayerSelectionActivity.u1(PlayerSelectionActivity.this) == null || str2 == null || str2.isEmpty() || str2.equals("")) {
                    return;
                }
                SharepreferenceDBHandler.setSeriesPlayer(str, str2, PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class m implements AdapterView.OnItemSelectedListener {
        public final /* synthetic */ LinkedHashMap a;
        public final /* synthetic */ List c;

        public m(LinkedHashMap linkedHashMap, List list) {
            this.a = linkedHashMap;
            this.c = list;
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            String vODPlayerPkgName;
            String vODPlayerAppName;
            StringBuilder sb;
            new SharepreferenceDBHandler();
            if (PlayerSelectionActivity.w1(PlayerSelectionActivity.this) != i) {
                PlayerSelectionActivity.x1(PlayerSelectionActivity.this, i);
                PlayerSelectionActivity.this.o.setSelection(i);
                if (!this.a.containsKey(this.c.get(i))) {
                    return;
                }
                vODPlayerPkgName = (String) this.a.get(this.c.get(i));
                vODPlayerAppName = (String) PlayerSelectionActivity.U1(this.a, vODPlayerPkgName);
                if (vODPlayerPkgName == null || vODPlayerPkgName.isEmpty() || vODPlayerPkgName.equals("") || PlayerSelectionActivity.u1(PlayerSelectionActivity.this) == null || vODPlayerAppName == null || vODPlayerAppName.isEmpty() || vODPlayerAppName.equals("")) {
                    return;
                }
                Log.i("listIS", this.c.toString());
                SharepreferenceDBHandler.setVODPlayer(vODPlayerPkgName, vODPlayerAppName, PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                sb = new StringBuilder();
            } else {
                vODPlayerPkgName = SharepreferenceDBHandler.getVODPlayerPkgName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                vODPlayerAppName = SharepreferenceDBHandler.getVODPlayerAppName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                if (vODPlayerPkgName == null || vODPlayerPkgName.isEmpty() || vODPlayerPkgName.equals("")) {
                    return;
                }
                int E1 = PlayerSelectionActivity.E1(PlayerSelectionActivity.this, this.c, vODPlayerPkgName, vODPlayerAppName, this.a);
                if (this.c.toString().contains(vODPlayerAppName)) {
                    Log.i("calledPart", "ifCalled");
                    PlayerSelectionActivity.this.o.setSelection(E1);
                } else {
                    Log.i("calledPart", "elseCalled");
                    PlayerSelectionActivity.z1(PlayerSelectionActivity.this);
                }
                sb = new StringBuilder();
            }
            sb.append(vODPlayerPkgName);
            sb.append(":");
            sb.append(vODPlayerAppName);
            Log.i("dataISSelected", sb.toString());
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class n implements AdapterView.OnItemSelectedListener {
        public final /* synthetic */ LinkedHashMap a;
        public final /* synthetic */ List c;

        public n(LinkedHashMap linkedHashMap, List list) {
            this.a = linkedHashMap;
            this.c = list;
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            new SharepreferenceDBHandler();
            if (PlayerSelectionActivity.A1(PlayerSelectionActivity.this) == i) {
                String livePlayerPkgName = SharepreferenceDBHandler.getLivePlayerPkgName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                String livePlayerAppName = SharepreferenceDBHandler.getLivePlayerAppName(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                if (livePlayerPkgName == null || livePlayerPkgName.isEmpty() || livePlayerPkgName.equals("")) {
                    return;
                }
                int E1 = PlayerSelectionActivity.E1(PlayerSelectionActivity.this, this.c, livePlayerPkgName, livePlayerAppName, this.a);
                if (this.c.toString().contains(livePlayerAppName)) {
                    PlayerSelectionActivity.this.n.setSelection(E1);
                    return;
                } else {
                    PlayerSelectionActivity.C1(PlayerSelectionActivity.this);
                    return;
                }
            }
            PlayerSelectionActivity.B1(PlayerSelectionActivity.this, i);
            PlayerSelectionActivity.this.n.setSelection(i);
            if (this.a.containsKey(this.c.get(i))) {
                String str = (String) this.a.get(this.c.get(i));
                String str2 = (String) PlayerSelectionActivity.U1(this.a, str);
                if (str == null || str.isEmpty() || str.equals("") || PlayerSelectionActivity.u1(PlayerSelectionActivity.this) == null || str2 == null || str2.isEmpty() || str2.equals("")) {
                    return;
                }
                SharepreferenceDBHandler.setLivePlayer(str, str2, PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class o implements Runnable {
        public o() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(PlayerSelectionActivity.u1(PlayerSelectionActivity.this));
                String A = w.A(date);
                TextView textView = PlayerSelectionActivity.this.g;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = PlayerSelectionActivity.this.f;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class p implements View.OnClickListener {
        public final /* synthetic */ PopupWindow a;

        public p(PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        public void onClick(View view) {
            PopupWindow popupWindow = this.a;
            if (popupWindow == null || !popupWindow.isShowing()) {
                return;
            }
            this.a.dismiss();
        }
    }

    public class q implements Runnable {
        public q() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    PlayerSelectionActivity.this.R1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class r implements View.OnFocusChangeListener {
        public final View a;

        public r(View view) {
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
            if (z) {
                f = z ? 1.05f : 1.0f;
                Log.e("id is", "" + this.a.getTag());
                if (this.a.getTag().equals("1")) {
                    a(f);
                    b(f);
                    view2 = this.a;
                    i = a7.e.h;
                } else if (!this.a.getTag().equals("2")) {
                    a(1.12f);
                    b(1.12f);
                    return;
                } else {
                    a(f);
                    b(f);
                    view2 = this.a;
                    i = a7.e.k1;
                }
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

    public static /* synthetic */ int A1(PlayerSelectionActivity playerSelectionActivity) {
        return playerSelectionActivity.K;
    }

    public static /* synthetic */ int B1(PlayerSelectionActivity playerSelectionActivity, int i2) {
        playerSelectionActivity.K = i2;
        return i2;
    }

    public static /* synthetic */ void C1(PlayerSelectionActivity playerSelectionActivity) {
        playerSelectionActivity.Y1();
    }

    public static /* synthetic */ void D1(PlayerSelectionActivity playerSelectionActivity) {
        playerSelectionActivity.Z1();
    }

    public static /* synthetic */ int E1(PlayerSelectionActivity playerSelectionActivity, List list, String str, String str2, LinkedHashMap linkedHashMap) {
        return playerSelectionActivity.T1(list, str, str2, linkedHashMap);
    }

    public static /* synthetic */ void F1(PlayerSelectionActivity playerSelectionActivity) {
        playerSelectionActivity.b2();
    }

    public static /* synthetic */ int G1(PlayerSelectionActivity playerSelectionActivity) {
        return playerSelectionActivity.O;
    }

    public static /* synthetic */ int H1(PlayerSelectionActivity playerSelectionActivity, int i2) {
        playerSelectionActivity.O = i2;
        return i2;
    }

    public static /* synthetic */ void I1(PlayerSelectionActivity playerSelectionActivity) {
        playerSelectionActivity.e2();
    }

    public static /* synthetic */ int J1(PlayerSelectionActivity playerSelectionActivity) {
        return playerSelectionActivity.N;
    }

    public static /* synthetic */ int K1(PlayerSelectionActivity playerSelectionActivity, int i2) {
        playerSelectionActivity.N = i2;
        return i2;
    }

    public static /* synthetic */ void L1(PlayerSelectionActivity playerSelectionActivity) {
        playerSelectionActivity.W1();
    }

    public static /* synthetic */ int M1(PlayerSelectionActivity playerSelectionActivity) {
        return playerSelectionActivity.M;
    }

    public static /* synthetic */ int N1(PlayerSelectionActivity playerSelectionActivity, int i2) {
        playerSelectionActivity.M = i2;
        return i2;
    }

    public static /* synthetic */ void O1(PlayerSelectionActivity playerSelectionActivity) {
        playerSelectionActivity.g2();
    }

    private void Q1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void S1() {
        Button button = this.u;
        if (button != null) {
            button.setOnFocusChangeListener(new r(button));
        }
        Button button2 = this.v;
        button2.setOnFocusChangeListener(new r(button2));
        this.v.requestFocus();
        this.v.requestFocusFromTouch();
    }

    public static Object U1(Map map, Object obj) {
        for (Map.Entry entry : map.entrySet()) {
            if (Objects.equals(obj, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    private void V1() {
        ArrayList arrayList = this.G;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList arrayList2 = this.I;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this.y = this;
        this.A = new LiveStreamDBHandler(this.y);
        if (this.y != null) {
            this.F = new ExternalPlayerDataBase(this.y);
            ExternalPlayerModelClass externalPlayerModelClass = new ExternalPlayerModelClass();
            externalPlayerModelClass.setAppicon("");
            externalPlayerModelClass.setAppname("Built-in Player (Hardware/Software Decoder)");
            externalPlayerModelClass.setPackagename("default");
            this.G.add(externalPlayerModelClass);
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.y).equals("stalker_api")) {
                ArrayList externalPlayer = this.F.getExternalPlayer();
                this.H = externalPlayer;
                this.G.addAll(1, externalPlayer);
            }
        }
        if (this.y != null) {
            this.F = new ExternalPlayerDataBase(this.y);
            ExternalPlayerModelClass externalPlayerModelClass2 = new ExternalPlayerModelClass();
            externalPlayerModelClass2.setAppicon("");
            externalPlayerModelClass2.setAppname("Built-in Player (Native)");
            externalPlayerModelClass2.setPackagename("default_native");
            this.I.add(externalPlayerModelClass2);
            this.F = new ExternalPlayerDataBase(this.y);
            ExternalPlayerModelClass externalPlayerModelClass3 = new ExternalPlayerModelClass();
            externalPlayerModelClass3.setAppicon("");
            externalPlayerModelClass3.setAppname("Built-in Player (Hardware/Software Decoder)");
            externalPlayerModelClass3.setPackagename("default");
            this.I.add(externalPlayerModelClass3);
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.y).equals("stalker_api")) {
                ArrayList externalPlayer2 = this.F.getExternalPlayer();
                this.J = externalPlayer2;
                this.I.addAll(2, externalPlayer2);
            }
        }
        SharedPreferences sharedPreferences = getSharedPreferences("selectedPlayer", 0);
        this.z = sharedPreferences;
        sharedPreferences.getString("selectedPlayer", "");
    }

    public static /* synthetic */ Context u1(PlayerSelectionActivity playerSelectionActivity) {
        return playerSelectionActivity.y;
    }

    public static /* synthetic */ int v1(PlayerSelectionActivity playerSelectionActivity) {
        return playerSelectionActivity.P;
    }

    public static /* synthetic */ int w1(PlayerSelectionActivity playerSelectionActivity) {
        return playerSelectionActivity.L;
    }

    public static /* synthetic */ int x1(PlayerSelectionActivity playerSelectionActivity, int i2) {
        playerSelectionActivity.L = i2;
        return i2;
    }

    public static /* synthetic */ int y1(PlayerSelectionActivity playerSelectionActivity, int i2) {
        playerSelectionActivity.P = i2;
        return i2;
    }

    public static /* synthetic */ void z1(PlayerSelectionActivity playerSelectionActivity) {
        playerSelectionActivity.a2();
    }

    public final void P1() {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            ExternalPlayerModelClass externalPlayerModelClass = (ExternalPlayerModelClass) it.next();
            arrayList.add(externalPlayerModelClass.getAppname());
            linkedHashMap.put(externalPlayerModelClass.getAppname(), externalPlayerModelClass.getPackagename());
        }
        d2(this.I, linkedHashMap, arrayList);
        ArrayList arrayList2 = new ArrayList();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator it2 = this.G.iterator();
        while (it2.hasNext()) {
            ExternalPlayerModelClass externalPlayerModelClass2 = (ExternalPlayerModelClass) it2.next();
            arrayList2.add(externalPlayerModelClass2.getAppname());
            linkedHashMap2.put(externalPlayerModelClass2.getAppname(), externalPlayerModelClass2.getPackagename());
        }
        i2(this.I, linkedHashMap, arrayList);
        h2(this.I, linkedHashMap, arrayList);
        X1(this.G, linkedHashMap2, arrayList2);
        f2(this.G, linkedHashMap2, arrayList2);
        c2(this.G, linkedHashMap2, arrayList2);
    }

    public void R1() {
        runOnUiThread(new o());
    }

    public final int T1(List list, String str, String str2, LinkedHashMap linkedHashMap) {
        Iterator it = linkedHashMap.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (((String) ((Map.Entry) it.next()).getValue()).toString().equals(str)) {
                return i2;
            }
            i2++;
        }
        return 0;
    }

    public final void W1() {
        new SharepreferenceDBHandler();
        SharepreferenceDBHandler.setCatchUpPlayer("default", "Default Player", this.y);
        this.q.setSelection(0);
    }

    public final void X1(ArrayList arrayList, LinkedHashMap linkedHashMap, List list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367043, list);
        arrayAdapter.setDropDownViewResource(17367049);
        this.q.setAdapter(arrayAdapter);
        this.q.setOnItemSelectedListener(new k(linkedHashMap, list));
    }

    public final void Y1() {
        new SharepreferenceDBHandler();
        SharepreferenceDBHandler.setLivePlayer("default", "Default Player", this.y);
        this.n.setSelection(1);
    }

    public final void Z1() {
        Y1();
        a2();
        g2();
        W1();
        e2();
        b2();
    }

    public final void a2() {
        new SharepreferenceDBHandler();
        SharepreferenceDBHandler.setVODPlayer("default", "Default Player", this.y);
        this.o.setSelection(1);
    }

    public final void b2() {
        new SharepreferenceDBHandler();
        SharepreferenceDBHandler.setEPGPlayer("default", "Default Player", this.y);
        this.s.setSelection(0);
    }

    public final void c2(ArrayList arrayList, LinkedHashMap linkedHashMap, List list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367043, list);
        arrayAdapter.setDropDownViewResource(17367049);
        this.s.setAdapter(arrayAdapter);
        this.s.setOnItemSelectedListener(new i(linkedHashMap, list));
    }

    public final void d2(ArrayList arrayList, LinkedHashMap linkedHashMap, List list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367043, list);
        arrayAdapter.setDropDownViewResource(17367049);
        this.n.setAdapter(arrayAdapter);
        this.n.setOnItemSelectedListener(new n(linkedHashMap, list));
    }

    public final void e2() {
        new SharepreferenceDBHandler();
        SharepreferenceDBHandler.setRecordingsPlayer("default", "Default Player", this.y);
        this.r.setSelection(0);
    }

    public final void f2(ArrayList arrayList, LinkedHashMap linkedHashMap, List list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367043, list);
        arrayAdapter.setDropDownViewResource(17367049);
        this.r.setAdapter(arrayAdapter);
        this.r.setOnItemSelectedListener(new j(linkedHashMap, list));
    }

    public final void g2() {
        new SharepreferenceDBHandler();
        SharepreferenceDBHandler.setSeriesPlayer("default", "Default Player", this.y);
        this.p.setSelection(1);
    }

    public final void h2(ArrayList arrayList, LinkedHashMap linkedHashMap, List list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367043, list);
        arrayAdapter.setDropDownViewResource(17367049);
        this.p.setAdapter(arrayAdapter);
        this.p.setOnItemSelectedListener(new l(linkedHashMap, list));
    }

    public final void i2(ArrayList arrayList, LinkedHashMap linkedHashMap, List list) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367043, list);
        arrayAdapter.setDropDownViewResource(17367049);
        this.o.setAdapter(arrayAdapter);
        this.o.setOnItemSelectedListener(new m(linkedHashMap, list));
    }

    public final void j2() {
        try {
            View inflate = ((LayoutInflater) this.y.getSystemService("layout_inflater")).inflate(a7.g.c4, findViewById(a7.f.Re));
            PopupWindow popupWindow = new PopupWindow(this.y);
            popupWindow.setContentView(inflate);
            popupWindow.setWidth(-1);
            popupWindow.setHeight(-1);
            popupWindow.setFocusable(true);
            popupWindow.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.h1);
            Button findViewById2 = inflate.findViewById(a7.f.u1);
            findViewById2.setText(getResources().getString(a7.j.T8));
            inflate.findViewById(a7.f.Di).setText(getResources().getString(a7.j.K));
            findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
            findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
            findViewById.setOnClickListener(new p(popupWindow));
            findViewById2.setOnClickListener(new a(popupWindow));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        Intent intent;
        int id = view.getId();
        if (id == a7.f.Bj) {
            intent = new Intent(this, NewDashboardActivity.class);
        } else {
            if (id != a7.f.wh && id != a7.f.S6 && id != a7.f.w4) {
                if (id != a7.f.vl && id != a7.f.K9 && id != a7.f.Z5) {
                    if (id == a7.f.S0) {
                        onBackPressed();
                        return;
                    } else if (id != a7.f.n1) {
                        return;
                    }
                }
                j2();
                return;
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.y).equals("stalker_api")) {
                return;
            } else {
                intent = new Intent(this, ExternalPlayerActivity.class);
            }
        }
        startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        int i2;
        LinearLayout linearLayout;
        this.y = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.y);
        this.Q = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? a7.g.o0 : a7.g.n0);
        w.Y(this);
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.E2);
        this.g = findViewById(a7.f.gh);
        this.h = findViewById(a7.f.Xa);
        this.i = findViewById(a7.f.Yf);
        this.j = findViewById(a7.f.ah);
        this.k = findViewById(a7.f.Zf);
        this.l = findViewById(a7.f.dh);
        this.m = findViewById(a7.f.kf);
        this.n = findViewById(a7.f.qg);
        this.o = findViewById(a7.f.ug);
        this.p = findViewById(a7.f.tg);
        this.q = findViewById(a7.f.ng);
        this.r = findViewById(a7.f.sg);
        this.s = findViewById(a7.f.pg);
        this.t = findViewById(a7.f.w4);
        this.u = findViewById(a7.f.S0);
        this.v = findViewById(a7.f.n1);
        this.w = findViewById(a7.f.s7);
        this.x = findViewById(a7.f.X9);
        this.v.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.t.setOnClickListener(this);
        S1();
        Q1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        Thread thread = this.R;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new q());
            this.R = thread2;
            thread2.start();
        }
        if (SharepreferenceDBHandler.getCurrentAPPType(this.y).equals("m3u")) {
            linearLayout = this.w;
            i2 = 8;
        } else {
            i2 = 0;
            this.w.setVisibility(0);
            linearLayout = this.x;
        }
        linearLayout.setVisibility(i2);
        this.h.setOnClickListener(new h());
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

    public void onDestroy() {
        super.onDestroy();
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
        if (itemId == a7.f.e && (context = this.y) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new c()).g(getResources().getString(a7.j.d4), new b()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.y.getResources().getString(a7.j.u0));
            aVar.f(this.y.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.y.getResources().getString(a7.j.S8), new d());
            aVar.g(this.y.getResources().getString(a7.j.d4), new e());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.y.getResources().getString(a7.j.u0));
            aVar2.f(this.y.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.y.getResources().getString(a7.j.S8), new f());
            aVar2.g(this.y.getResources().getString(a7.j.d4), new g());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.R;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.R.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.R;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new q());
            this.R = thread2;
            thread2.start();
        }
        overridePendingTransition(a7.b.f, a7.b.d);
        V1();
        P1();
        w.m(this.y);
        w.z0(this.y);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.z = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.z.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    public void onStop() {
        super.onStop();
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
    }
}

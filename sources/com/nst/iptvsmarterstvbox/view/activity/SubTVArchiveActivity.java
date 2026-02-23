package com.nst.iptvsmarterstvbox.view.activity;

import a7.h;
import a7.j;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.nst.iptvsmarterstvbox.model.callback.LiveStreamsEpgCallback;
import com.nst.iptvsmarterstvbox.model.callback.LoginCallback;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.EpgListingPojo;
import com.nst.iptvsmarterstvbox.model.pojo.XMLTVProgrammePojo;
import d.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import m7.w;
import n7.k;
import q7.b0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SubTVArchiveActivity extends androidx.appcompat.app.b implements z7.f, z7.e, View.OnClickListener {
    public k A;
    public Thread B = null;
    public List C = new ArrayList();
    public Toolbar d;
    public TabLayout e;
    public ViewPager f;
    public ProgressBar g;
    public AppBarLayout h;
    public TextView i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public ImageView o;
    public SharedPreferences p;
    public SharedPreferences q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public LiveStreamDBHandler y;
    public Context z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(SubTVArchiveActivity.u1(SubTVArchiveActivity.this));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            SubTVArchiveActivity.this.onBackPressed();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(SubTVArchiveActivity.u1(SubTVArchiveActivity.this));
                String A = w.A(date);
                TextView textView = SubTVArchiveActivity.this.m;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = SubTVArchiveActivity.this.l;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class d implements p1.c {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ ArrayList b;

        public d(ArrayList arrayList, ArrayList arrayList2) {
            this.a = arrayList;
            this.b = arrayList2;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(33:98|99|100|101|102|103|104|105|106|107|108|109|(3:110|111|112)|(3:113|114|115)|116|117|118|119|120|121|(3:122|123|124)|125|126|127|128|129|130|(5:131|132|(18:157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174)(1:134)|135|136)|(2:137|138)|(2:140|141)|142|143|144) */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x0218, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x0219, code lost:
        
            r0.printStackTrace();
            r0 = "";
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0277 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:255:0x02c5 A[PHI: r7
          0x02c5: PHI (r7v2 java.lang.String) = (r7v1 java.lang.String), (r7v1 java.lang.String), (r7v8 java.lang.String) binds: [B:5:0x001a, B:9:0x002b, B:248:0x02c5] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x02cf A[Catch: Exception -> 0x02c2, TryCatch #29 {Exception -> 0x02c2, blocks: (B:3:0x000c, B:6:0x001c, B:28:0x02c7, B:30:0x02cf, B:32:0x02d3, B:34:0x02d9, B:36:0x02f7, B:38:0x0309, B:41:0x0314, B:42:0x032c, B:44:0x0336, B:46:0x033c, B:48:0x0346, B:50:0x0348, B:59:0x0328, B:53:0x034d, B:54:0x03be, B:64:0x0397, B:66:0x039d, B:67:0x03a0, B:69:0x03a6, B:70:0x03a9, B:72:0x03af, B:73:0x03b5, B:75:0x03bb, B:77:0x03e9, B:81:0x03c4, B:83:0x03c8, B:84:0x03cb, B:86:0x03d1, B:87:0x03d4, B:89:0x03da, B:90:0x03e0, B:92:0x03e6, B:96:0x02ba), top: B:2:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0346 A[Catch: Exception -> 0x02c2, TryCatch #29 {Exception -> 0x02c2, blocks: (B:3:0x000c, B:6:0x001c, B:28:0x02c7, B:30:0x02cf, B:32:0x02d3, B:34:0x02d9, B:36:0x02f7, B:38:0x0309, B:41:0x0314, B:42:0x032c, B:44:0x0336, B:46:0x033c, B:48:0x0346, B:50:0x0348, B:59:0x0328, B:53:0x034d, B:54:0x03be, B:64:0x0397, B:66:0x039d, B:67:0x03a0, B:69:0x03a6, B:70:0x03a9, B:72:0x03af, B:73:0x03b5, B:75:0x03bb, B:77:0x03e9, B:81:0x03c4, B:83:0x03c8, B:84:0x03cb, B:86:0x03d1, B:87:0x03d4, B:89:0x03da, B:90:0x03e0, B:92:0x03e6, B:96:0x02ba), top: B:2:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0345 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x03c4 A[Catch: Exception -> 0x02c2, TryCatch #29 {Exception -> 0x02c2, blocks: (B:3:0x000c, B:6:0x001c, B:28:0x02c7, B:30:0x02cf, B:32:0x02d3, B:34:0x02d9, B:36:0x02f7, B:38:0x0309, B:41:0x0314, B:42:0x032c, B:44:0x0336, B:46:0x033c, B:48:0x0346, B:50:0x0348, B:59:0x0328, B:53:0x034d, B:54:0x03be, B:64:0x0397, B:66:0x039d, B:67:0x03a0, B:69:0x03a6, B:70:0x03a9, B:72:0x03af, B:73:0x03b5, B:75:0x03bb, B:77:0x03e9, B:81:0x03c4, B:83:0x03c8, B:84:0x03cb, B:86:0x03d1, B:87:0x03d4, B:89:0x03da, B:90:0x03e0, B:92:0x03e6, B:96:0x02ba), top: B:2:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x029e A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(org.json.JSONObject r41) {
            /*
                Method dump skipped, instructions count: 1011
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SubTVArchiveActivity.d.a(org.json.JSONObject):void");
        }

        public void b(m1.a aVar) {
            Log.e("EPG", String.valueOf(aVar));
            Toast.makeText(SubTVArchiveActivity.this.getApplicationContext(), SubTVArchiveActivity.this.getResources().getString(j.D2), 0).show();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(SubTVArchiveActivity.u1(SubTVArchiveActivity.this));
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    SubTVArchiveActivity.this.z1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static long B1(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private void D1() {
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.ig);
        this.f = findViewById(a7.f.Om);
        this.g = findViewById(a7.f.ec);
        this.h = findViewById(a7.f.W);
        this.i = findViewById(a7.f.wk);
        this.j = findViewById(a7.f.wf);
        this.k = findViewById(a7.f.Pi);
        this.l = findViewById(a7.f.E2);
        this.m = findViewById(a7.f.gh);
        this.n = findViewById(a7.f.Xa);
        this.o = findViewById(a7.f.F4);
    }

    private void E1() {
        int i;
        this.e.setVisibility(8);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.q = sharedPreferences;
        String string = sharedPreferences.getString("username", "");
        String string2 = this.q.getString("password", "");
        this.r = getIntent().getStringExtra("OPENED_STREAM_ID");
        String stringExtra = getIntent().getStringExtra("OPENED_NUM");
        String stringExtra2 = getIntent().getStringExtra("OPENED_CHANNEL_ID");
        String stringExtra3 = getIntent().getStringExtra("OPENED_NAME");
        String stringExtra4 = getIntent().getStringExtra("OPENED_STREAM_ICON");
        String stringExtra5 = getIntent().getStringExtra("OPENED_ARCHIVE_DURATION");
        this.y = new LiveStreamDBHandler(this.z);
        if (stringExtra2 != null) {
            stringExtra2.equals("");
        }
        this.A = new k(this, this.z);
        try {
            i = Integer.parseInt(this.r);
        } catch (NumberFormatException unused) {
            i = -1;
        }
        if (SharepreferenceDBHandler.getCurrentAPPType(this.z).equals("onestream_api")) {
            A1();
        } else {
            this.A.b(string, string2, i, stringExtra2, this.r, stringExtra, stringExtra3, stringExtra4, stringExtra5, this.x);
        }
    }

    public static /* synthetic */ Context u1(SubTVArchiveActivity subTVArchiveActivity) {
        return subTVArchiveActivity.z;
    }

    public static /* synthetic */ long v1(SubTVArchiveActivity subTVArchiveActivity, String str, String str2) {
        return subTVArchiveActivity.y1(str, str2);
    }

    public static /* synthetic */ List w1(SubTVArchiveActivity subTVArchiveActivity) {
        return subTVArchiveActivity.C;
    }

    private void x1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public final void A1() {
        String oneStreamToken = SharepreferenceDBHandler.getOneStreamToken(this.z);
        j1.a.a(this.z.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "") + "play/b2c/v1/epg/" + this.r + "?token=" + oneStreamToken).s(k1.e.MEDIUM).q().o(new d(new ArrayList(), new ArrayList()));
    }

    public void C1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public void N(LiveStreamsEpgCallback liveStreamsEpgCallback, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8;
        if (liveStreamsEpgCallback == null || liveStreamsEpgCallback.getEpgListingPojos() == null || liveStreamsEpgCallback.getEpgListingPojos().size() <= 0) {
            ViewPager viewPager = this.f;
            if (viewPager != null) {
                viewPager.setVisibility(8);
            }
            TabLayout tabLayout = this.e;
            if (tabLayout != null) {
                tabLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.j;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            TextView textView = this.i;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (EpgListingPojo epgListingPojo : liveStreamsEpgCallback.getEpgListingPojos()) {
                if (epgListingPojo.getHasArchive().intValue() == 1) {
                    arrayList.add(epgListingPojo);
                    XMLTVProgrammePojo xMLTVProgrammePojo = new XMLTVProgrammePojo();
                    xMLTVProgrammePojo.setTitle(epgListingPojo.getTitle());
                    xMLTVProgrammePojo.setStart(epgListingPojo.getStart());
                    xMLTVProgrammePojo.setStop(epgListingPojo.getEnd());
                    xMLTVProgrammePojo.setDesc(epgListingPojo.getDescription());
                    xMLTVProgrammePojo.setChannel(epgListingPojo.getChannelId());
                    xMLTVProgrammePojo.setStartTimeStamp(epgListingPojo.getStartTimestamp());
                    xMLTVProgrammePojo.setEndTimeStamp(epgListingPojo.getStopTimestamp());
                    arrayList2.add(xMLTVProgrammePojo);
                }
            }
            if (this.y != null) {
                int size = arrayList2.size();
                if (size != 0) {
                    String format = new SimpleDateFormat("dd-MMM-yyyy", Locale.US).format(new Date());
                    ArrayList arrayList3 = new ArrayList();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        try {
                            str8 = new SimpleDateFormat("dd MMM yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(((XMLTVProgrammePojo) arrayList2.get(i2)).getStart().split("\\s+")[0]));
                        } catch (ParseException e2) {
                            e2.printStackTrace();
                            str8 = "";
                        }
                        if (B1(simpleDateFormat, str8, format) >= 0 && !arrayList3.contains(str8)) {
                            arrayList3.add(i, str8);
                            if (format.equals(str8)) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    this.f.setAdapter(new b0(arrayList3, arrayList2, str2, str3, str4, str5, str, str6, str7, getSupportFragmentManager(), this));
                    this.e.setVisibility(0);
                    this.e.setupWithViewPager(this.f);
                    this.f.setCurrentItem(i - 1);
                } else {
                    ViewPager viewPager2 = this.f;
                    if (viewPager2 != null) {
                        viewPager2.setVisibility(8);
                    }
                    TabLayout tabLayout2 = this.e;
                    if (tabLayout2 != null) {
                        tabLayout2.setVisibility(8);
                    }
                    RelativeLayout relativeLayout2 = this.j;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setVisibility(0);
                    }
                    TextView textView2 = this.i;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                }
                b();
            }
        }
        b();
    }

    public void a() {
        ProgressBar progressBar = this.g;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public void b() {
        ProgressBar progressBar = this.g;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    public void c(String str) {
    }

    public void d(String str) {
    }

    public void e(String str) {
    }

    public void h0(ArrayList arrayList, String str) {
    }

    public void m(LoginCallback loginCallback, String str) {
        if (loginCallback == null || loginCallback.getUserLoginInfo().getAuth().intValue() != 1) {
            return;
        }
        String status = loginCallback.getUserLoginInfo().getStatus();
        if (status.equals("Active")) {
            return;
        }
        w.P0(this.z, "Your Account is " + status);
        Context context = this.z;
        if (context != null) {
            w.n0(context);
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        this.z = this;
        C1();
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(a7.g.c1);
        D1();
        x1();
        r1(findViewById(a7.f.kh));
        overridePendingTransition(a7.b.f, a7.b.d);
        E1();
        Thread thread = this.B;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new g());
            this.B = thread2;
            thread2.start();
        }
        this.n.setOnClickListener(new a());
        this.o.setOnClickListener(new b());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.d.x(h.j);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i = 0; i < this.d.getChildCount(); i++) {
            if (this.d.getChildAt(i) instanceof ActionMenuView) {
                ((a.a) this.d.getChildAt(i).getLayoutParams()).a = 16;
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
        if (itemId == a7.f.e && (context = this.z) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(j.f3)).f(getResources().getString(j.e3)).j(getResources().getString(j.S8), new f()).g(getResources().getString(j.d4), new e()).n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.B;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.B.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        C1();
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.B;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new g());
            this.B = thread2;
            thread2.start();
        }
        w.m(this.z);
        w.z0(this.z);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.p = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.p.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        bundle.clear();
    }

    public void onStop() {
        super.onStop();
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        C1();
    }

    public void w0(ArrayList arrayList, String str) {
    }

    public void y(LoginCallback loginCallback, String str, ArrayList arrayList) {
    }

    public final long y1(String str, String str2) {
        long j;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        try {
            j = simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            j = -1;
        }
        return (j / 1000) / 60;
    }

    public void z1() {
        runOnUiThread(new c());
    }
}

package com.nst.iptvsmarterstvbox.view.activity;

import a7.c;
import a7.f;
import a7.g;
import a7.j;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.util.ArrayList;
import java.util.Iterator;
import m7.w;
import q7.f0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class TVArchiveActivity extends b implements View.OnClickListener {
    public ProgressBar d;
    public TabLayout e;
    public ViewPager f;
    public ImageView g;
    public Toolbar h;
    public AppBarLayout i;
    public Context j;
    public SharedPreferences k;
    public LiveStreamDBHandler m;
    public ArrayList n;
    public ArrayList o;
    public ArrayList p;
    public ArrayList q;
    public ArrayList r;
    public ArrayList l = new ArrayList();
    public String s = "";
    public String t = "";
    public DatabaseUpdatedStatusDBModel u = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel v = new DatabaseUpdatedStatusDBModel();

    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
        }
    }

    private void u1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, c.k));
    }

    private ArrayList v1() {
        ArrayList allPasswordStatus = this.m.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.j));
        this.n = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.l.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.l;
    }

    private ArrayList w1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) it.next();
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (liveStreamCategoryIdDBModel.getLiveStreamCategoryID().equals((String) it2.next())) {
                            break;
                        }
                    } else {
                        ArrayList arrayList3 = this.o;
                        if (arrayList3 != null) {
                            arrayList3.add(liveStreamCategoryIdDBModel);
                        }
                    }
                }
            }
        }
        return this.o;
    }

    private void x1() {
        this.d = findViewById(f.ec);
        this.e = findViewById(f.ig);
        this.f = findViewById(f.Om);
        this.g = findViewById(f.Bj);
        this.h = findViewById(f.kh);
        this.i = findViewById(f.W);
    }

    private void y1() {
        ViewPager viewPager;
        try {
            if (this.j != null) {
                this.m = new LiveStreamDBHandler(this.j);
                this.n = new ArrayList();
                this.o = new ArrayList();
                this.p = new ArrayList();
                this.q = new ArrayList();
                this.r = new ArrayList();
                this.r = this.m.getAllliveCategories();
                ArrayList allliveCategories = this.m.getAllliveCategories();
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                new LiveStreamCategoryIdDBModel();
                liveStreamCategoryIdDBModel.setLiveStreamCategoryID("0");
                liveStreamCategoryIdDBModel.setLiveStreamCategoryName(getResources().getString(j.x));
                if (this.m.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.j)) <= 0 || allliveCategories == null) {
                    allliveCategories.add(0, liveStreamCategoryIdDBModel);
                } else {
                    ArrayList v1 = v1();
                    this.l = v1;
                    this.p = w1(allliveCategories, v1);
                    this.o.add(0, liveStreamCategoryIdDBModel);
                    allliveCategories = this.p;
                }
                this.q = allliveCategories;
                ArrayList arrayList = this.q;
                if (arrayList == null || (viewPager = this.f) == null || this.e == null) {
                    return;
                }
                viewPager.setAdapter(new f0(arrayList, getSupportFragmentManager(), this));
                this.e.setupWithViewPager(this.f);
                this.f.setOnPageChangeListener(new a());
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    public void b() {
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        if (view.getId() == f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(g.n1);
        x1();
        overridePendingTransition(a7.b.f, a7.b.d);
        u1();
        r1(findViewById(f.kh));
        getWindow().setFlags(1024, 1024);
        this.j = this;
        y1();
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.j);
        w.z0(this.j);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.k = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.k.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.j != null) {
            b();
        }
    }
}

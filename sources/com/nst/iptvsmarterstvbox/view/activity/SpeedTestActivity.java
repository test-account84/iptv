package com.nst.iptvsmarterstvbox.view.activity;

import a7.e;
import a7.f;
import a7.g;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import m7.d;
import m7.w;
import org.achartengine.ChartFactory;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SpeedTestActivity extends androidx.appcompat.app.b {
    public static int r;
    public static int s;
    public Button d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public LinearLayout l;
    public d m;
    public HashSet n;
    public RotateAnimation o;
    public Context p;
    public u7.a q;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            SpeedTestActivity.this.d.setEnabled(false);
            SpeedTestActivity.u1(SpeedTestActivity.this);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ DecimalFormat a;

        public class a implements Runnable {
            public final /* synthetic */ h7.a a;

            public a(h7.a aVar) {
                this.a = aVar;
            }

            public void run() {
                SpeedTestActivity.this.o = new RotateAnimation(SpeedTestActivity.s, SpeedTestActivity.r, 1, 0.5f, 1, 0.5f);
                SpeedTestActivity.this.o.setInterpolator(new LinearInterpolator());
                SpeedTestActivity.this.o.setDuration(100L);
                SpeedTestActivity speedTestActivity = SpeedTestActivity.this;
                speedTestActivity.k.startAnimation(speedTestActivity.o);
                SpeedTestActivity.this.g.setText(b.this.a.format(this.a.b()) + " Mbps");
                SpeedTestActivity.this.h.setText(b.this.a.format(this.a.b()) + " Mbps");
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ List a;
            public final /* synthetic */ XYMultipleSeriesRenderer c;
            public final /* synthetic */ LinearLayout d;

            public b(List list, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, LinearLayout linearLayout) {
                this.a = list;
                this.c = xYMultipleSeriesRenderer;
                this.d = linearLayout;
            }

            public void run() {
                XYSeries xYSeries = new XYSeries("");
                xYSeries.setTitle("");
                Iterator it = new ArrayList(this.a).iterator();
                int i = 0;
                while (it.hasNext()) {
                    xYSeries.add(i, ((Double) it.next()).doubleValue());
                    i++;
                }
                XYMultipleSeriesDataset xYMultipleSeriesDataset = new XYMultipleSeriesDataset();
                xYMultipleSeriesDataset.addSeries(xYSeries);
                this.d.addView(ChartFactory.getLineChartView(SpeedTestActivity.this.getBaseContext(), xYMultipleSeriesDataset, this.c), 0);
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ h7.c a;

            public c(h7.c cVar) {
                this.a = cVar;
            }

            public void run() {
                SpeedTestActivity.this.i.setText(b.this.a.format(this.a.a()) + " Mbps");
                SpeedTestActivity.this.j.setText(b.this.a.format(this.a.a()) + " Mbps");
            }
        }

        public class d implements Runnable {
            public final /* synthetic */ h7.c a;

            public d(h7.c cVar) {
                this.a = cVar;
            }

            public void run() {
                SpeedTestActivity.this.o = new RotateAnimation(SpeedTestActivity.s, SpeedTestActivity.r, 1, 0.5f, 1, 0.5f);
                SpeedTestActivity.this.o.setInterpolator(new LinearInterpolator());
                SpeedTestActivity.this.o.setDuration(100L);
                SpeedTestActivity speedTestActivity = SpeedTestActivity.this;
                speedTestActivity.k.startAnimation(speedTestActivity.o);
                SpeedTestActivity.this.i.setText(b.this.a.format(this.a.b()) + " Mbps");
                SpeedTestActivity.this.j.setText(b.this.a.format(this.a.b()) + " Mbps");
            }
        }

        public class e implements Runnable {
            public final /* synthetic */ List a;
            public final /* synthetic */ XYMultipleSeriesRenderer c;
            public final /* synthetic */ LinearLayout d;

            public e(List list, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, LinearLayout linearLayout) {
                this.a = list;
                this.c = xYMultipleSeriesRenderer;
                this.d = linearLayout;
            }

            public void run() {
                XYSeries xYSeries = new XYSeries("");
                xYSeries.setTitle("");
                int i = 0;
                for (Double d : new ArrayList(this.a)) {
                    if (i == 0) {
                        d = Double.valueOf(0.0d);
                    }
                    xYSeries.add(i, d.doubleValue());
                    i++;
                }
                XYMultipleSeriesDataset xYMultipleSeriesDataset = new XYMultipleSeriesDataset();
                xYMultipleSeriesDataset.addSeries(xYSeries);
                this.d.addView(ChartFactory.getLineChartView(SpeedTestActivity.this.getBaseContext(), xYMultipleSeriesDataset, this.c), 0);
            }
        }

        public class f implements Runnable {
            public f() {
            }

            public void run() {
                SpeedTestActivity.this.d.setEnabled(true);
                SpeedTestActivity speedTestActivity = SpeedTestActivity.this;
                speedTestActivity.d.setText(speedTestActivity.getResources().getString(a7.j.j6));
            }
        }

        public class g implements Runnable {
            public g() {
            }

            public void run() {
                SpeedTestActivity speedTestActivity = SpeedTestActivity.this;
                speedTestActivity.d.setText(speedTestActivity.getResources().getString(a7.j.e5));
            }
        }

        public class h implements Runnable {
            public h() {
            }

            public void run() {
                Toast.makeText(SpeedTestActivity.this.getApplicationContext(), "No Connection...", 1).show();
                SpeedTestActivity.this.d.setEnabled(true);
                SpeedTestActivity speedTestActivity = SpeedTestActivity.this;
                speedTestActivity.d.setText(speedTestActivity.getResources().getString(a7.j.j6));
            }
        }

        public class i implements Runnable {
            public i() {
            }

            public void run() {
                SpeedTestActivity speedTestActivity = SpeedTestActivity.this;
                speedTestActivity.d.setText(speedTestActivity.getResources().getString(a7.j.H5));
            }
        }

        public class j implements Runnable {
            public final /* synthetic */ List a;
            public final /* synthetic */ double c;

            public j(List list, double d) {
                this.a = list;
                this.c = d;
            }

            public void run() {
                SpeedTestActivity.this.d.setText(String.format("Host Location: %s \n[Distance: %s km]", new Object[]{this.a.get(2), new DecimalFormat("#.##").format(this.c / 1000.0d)}));
            }
        }

        public class k implements Runnable {
            public final /* synthetic */ LinearLayout a;
            public final /* synthetic */ LinearLayout c;
            public final /* synthetic */ LinearLayout d;

            public k(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3) {
                this.a = linearLayout;
                this.c = linearLayout2;
                this.d = linearLayout3;
            }

            public void run() {
                SpeedTestActivity.this.e.setText("0 ms");
                SpeedTestActivity.this.f.setText("0 ms");
                this.a.removeAllViews();
                SpeedTestActivity.this.g.setText("0 Mbps");
                SpeedTestActivity.this.h.setText("0 Mbps");
                this.c.removeAllViews();
                SpeedTestActivity.this.i.setText("0 Mbps");
                SpeedTestActivity.this.j.setText("0 Mbps");
                this.d.removeAllViews();
            }
        }

        public class l implements Runnable {
            public final /* synthetic */ h7.d a;

            public l(h7.d dVar) {
                this.a = dVar;
            }

            public void run() {
                SpeedTestActivity.this.e.setText(b.this.a.format(this.a.a()) + " ms");
                SpeedTestActivity.this.f.setText(b.this.a.format(this.a.a()) + " ms");
            }
        }

        public class m implements Runnable {
            public final /* synthetic */ h7.d a;

            public m(h7.d dVar) {
                this.a = dVar;
            }

            public void run() {
                SpeedTestActivity.this.e.setText(b.this.a.format(this.a.b()) + " ms");
                SpeedTestActivity.this.f.setText(b.this.a.format(this.a.b()) + " ms");
            }
        }

        public class n implements Runnable {
            public final /* synthetic */ List a;
            public final /* synthetic */ XYMultipleSeriesRenderer c;
            public final /* synthetic */ LinearLayout d;

            public n(List list, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, LinearLayout linearLayout) {
                this.a = list;
                this.c = xYMultipleSeriesRenderer;
                this.d = linearLayout;
            }

            public void run() {
                XYSeries xYSeries = new XYSeries("");
                xYSeries.setTitle("");
                Iterator it = new ArrayList(this.a).iterator();
                int i = 0;
                while (it.hasNext()) {
                    xYSeries.add(i, ((Double) it.next()).doubleValue());
                    i++;
                }
                XYMultipleSeriesDataset xYMultipleSeriesDataset = new XYMultipleSeriesDataset();
                xYMultipleSeriesDataset.addSeries(xYSeries);
                this.d.addView(ChartFactory.getLineChartView(SpeedTestActivity.this.getBaseContext(), xYMultipleSeriesDataset, this.c), 0);
            }
        }

        public class o implements Runnable {
            public final /* synthetic */ h7.a a;

            public o(h7.a aVar) {
                this.a = aVar;
            }

            public void run() {
                SpeedTestActivity.this.g.setText(b.this.a.format(this.a.a()) + " Mbps");
                SpeedTestActivity.this.h.setText(b.this.a.format(this.a.a()) + " Mbps");
            }
        }

        public b(DecimalFormat decimalFormat) {
            this.a = decimalFormat;
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x03fd  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x03ab  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x0313  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x02fc  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0356  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x03d2  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x03da  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x03e3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 1036
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SpeedTestActivity.b.run():void");
        }
    }

    public class c implements View.OnFocusChangeListener {
        public final View a;

        public c(View view) {
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
            Button button;
            int i;
            if (z) {
                f = z ? 1.12f : 1.0f;
                b(f);
                c(f);
                View view2 = this.a;
                if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                    return;
                }
                button = SpeedTestActivity.this.d;
                i = e.p;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
                View view3 = this.a;
                if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("1")) {
                    return;
                }
                button = SpeedTestActivity.this.d;
                i = e.o;
            }
            button.setBackgroundResource(i);
        }
    }

    public static /* synthetic */ void u1(SpeedTestActivity speedTestActivity) {
        speedTestActivity.y1();
    }

    private void x1() {
        this.d.setOnClickListener(new a());
    }

    public void onCreate(Bundle bundle) {
        this.p = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.p);
        this.q = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? g.Y0 : g.X0);
        w.Y(this);
        w1();
        this.n = new HashSet();
        try {
            d dVar = new d();
            this.m = dVar;
            dVar.start();
        } catch (Exception unused) {
        }
        Button button = this.d;
        if (button != null) {
            button.setOnFocusChangeListener(new c(button));
        }
        x1();
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        try {
            d dVar = new d();
            this.m = dVar;
            dVar.start();
        } catch (Exception unused) {
        }
    }

    public int v1(double d) {
        if (d <= 1.0d) {
            return (int) (d * 30.0d);
        }
        if (d <= 10.0d) {
            return ((int) (d * 6.0d)) + 30;
        }
        if (d <= 30.0d) {
            return ((int) ((d - 10.0d) * 3.0d)) + 90;
        }
        if (d <= 50.0d) {
            return ((int) ((d - 30.0d) * 1.5d)) + 150;
        }
        if (d <= 100.0d) {
            return ((int) ((d - 50.0d) * 1.2d)) + 180;
        }
        return 0;
    }

    public final void w1() {
        this.d = findViewById(f.Vg);
        this.e = findViewById(f.vc);
        this.f = findViewById(f.wc);
        this.g = findViewById(f.J2);
        this.h = findViewById(f.K2);
        this.i = findViewById(f.Bm);
        this.j = findViewById(f.Cm);
        this.k = findViewById(f.h0);
        this.l = findViewById(f.i4);
    }

    public final void y1() {
        try {
            if (this.m == null) {
                d dVar = new d();
                this.m = dVar;
                dVar.start();
            }
            if (this.m != null) {
                this.l.setVisibility(0);
                try {
                    new Thread(new b(new DecimalFormat("#.##"))).start();
                } catch (Exception e) {
                    Toast.makeText(this.p, e.getMessage(), 0).show();
                }
            }
        } catch (Exception unused) {
        }
    }
}

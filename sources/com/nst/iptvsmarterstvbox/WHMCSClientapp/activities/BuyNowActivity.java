package com.nst.iptvsmarterstvbox.WHMCSClientapp.activities;

import a7.f;
import a7.g;
import a7.j;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.appcompat.app.b;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import java.util.Calendar;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BuyNowActivity extends b {
    public WebView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ProgressDialog j;
    public Context k;
    public String h = "";
    public String i = "";
    public String l = "";
    public String m = "";
    public String n = "";

    public class 1 extends WebViewClient {
        public 1() {
        }

        public void onPageFinished(WebView webView, String str) {
            BuyNowActivity.this.j.dismiss();
            BuyNowActivity.this.d.setVisibility(0);
        }
    }

    public class 2 implements Runnable {
        public 2() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(BuyNowActivity.this.k);
                String A = w.A(date);
                TextView textView = BuyNowActivity.this.f;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = BuyNowActivity.this.e;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class CountDownRunner implements Runnable {
        public CountDownRunner() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    BuyNowActivity.this.w1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, ServicesDashboardActivity.class);
        intent.setFlags(67141632);
        intent.setAction("check_buy_now");
        startActivity(intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.o);
        this.d = findViewById(f.Vm);
        this.e = findViewById(f.E2);
        this.f = findViewById(f.gh);
        TextView findViewById = findViewById(f.fm);
        this.g = findViewById;
        findViewById.setText(getResources().getString(j.c));
        Intent intent = getIntent();
        this.l = intent.getAction();
        new Thread(new CountDownRunner()).start();
        this.k = this;
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.j = progressDialog;
        progressDialog.setMessage(this.k.getResources().getString(j.v5));
        this.j.show();
        this.j.setCancelable(false);
        Context context = this.k;
        if (context != null) {
            this.j.setMessage(context.getResources().getString(j.v5));
        }
        this.d.getSettings().setJavaScriptEnabled(true);
        this.d.getSettings().setLoadWithOverviewMode(true);
        this.d.getSettings().setUseWideViewPort(true);
        this.d.setWebViewClient(new 1());
        String str = this.l;
        if (str == null || !str.equalsIgnoreCase("Invoice_action")) {
            this.i = intent.getStringExtra("service_id");
            v1();
        } else {
            this.n = intent.getStringExtra("status");
            this.m = intent.getStringExtra("invoice_id");
            u1();
        }
    }

    public final void u1() {
        if (this.m != null) {
            this.d.loadUrl("https://cms.alldrama.tv/viewinvoice.php?id=" + this.m + "&loginemail=" + ClientSharepreferenceHandler.c(this.k) + "&api_username=OUBQqC6334OcxjS&gotourl=viewinvoice.php?id=" + this.m);
        }
    }

    public final void v1() {
        this.d.loadUrl("http://51.75.16.104/upgrade.php?type=package&id=" + this.i + "&loginemail=" + ClientSharepreferenceHandler.c(this) + "&api_username=OUBQqC6334OcxjS&gotourl=upgrade.php");
    }

    public void w1() {
        runOnUiThread(new 2());
    }
}

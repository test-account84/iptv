package com.nst.iptvsmarterstvbox.WHMCSClientapp.activities;

import a7.f;
import a7.g;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import androidx.appcompat.app.b;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InvoicePaidDetailActivity extends b implements View.OnClickListener {
    public WebView d;
    public Button e;
    public Context f;
    public String g = "";
    public String h = "";
    public String i = "";

    private void u1() {
        if (this.g != null) {
            WebView findViewById = findViewById(f.Vm);
            this.d = findViewById;
            findViewById.loadUrl("https://cms.alldrama.tv/viewinvoice.php?id=" + this.g + "&loginemail=" + ClientSharepreferenceHandler.c(this.f) + "&api_username=OUBQqC6334OcxjS&gotourl=viewinvoice.php?id=" + this.g);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MyInvoiceActivity.class));
    }

    public void onClick(View view) {
        if (view.getId() == f.g0) {
            startActivity(this.h.equalsIgnoreCase("paid") ? new Intent(this, PaidInvoiceActivity.class) : this.h.equalsIgnoreCase("Unpaid") ? new Intent(this, UnpiadInvoiceActivity.class) : this.h.equalsIgnoreCase("Cancelled") ? new Intent(this, CancelInvoiceActivity.class) : this.h.equalsIgnoreCase("Refund") ? new Intent(this, InvoiceRefundedActivity.class) : new Intent(this, MyInvoiceActivity.class));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.P);
        this.d = findViewById(f.Vm);
        this.e = findViewById(f.g0);
        this.f = this;
        Intent intent = getIntent();
        this.h = intent.getStringExtra("status");
        this.g = intent.getStringExtra("invoice_id");
        u1();
    }
}

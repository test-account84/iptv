package com.nst.iptvsmarterstvbox.miscelleneious.chromecastfeature.queue;

import a7.f;
import a7.g;
import a7.h;
import a7.j;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import java.util.List;
import n4.r;
import o4.e;
import o4.y;
import p4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class QueueListViewActivity extends androidx.appcompat.app.b {
    public final i.a d = new b(this, null);
    public final y e = new c(this, null);
    public o4.b f;
    public i g;
    public View h;

    public class b extends i.a {
        public b() {
        }

        private void o() {
            View x1;
            int i;
            r l = QueueListViewActivity.u1(QueueListViewActivity.this).l();
            List a0 = l == null ? null : l.a0();
            if (a0 == null || a0.isEmpty()) {
                x1 = QueueListViewActivity.x1(QueueListViewActivity.this);
                i = 0;
            } else {
                x1 = QueueListViewActivity.x1(QueueListViewActivity.this);
                i = 8;
            }
            x1.setVisibility(i);
        }

        public void e() {
            o();
        }

        public void g() {
            o();
        }

        public /* synthetic */ b(QueueListViewActivity queueListViewActivity, a aVar) {
            this();
        }
    }

    public class c implements y {
        public c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSessionEnded(e eVar, int i) {
            if (QueueListViewActivity.u1(QueueListViewActivity.this) != null) {
                QueueListViewActivity.u1(QueueListViewActivity.this).N(QueueListViewActivity.w1(QueueListViewActivity.this));
            }
            QueueListViewActivity.v1(QueueListViewActivity.this, null);
            QueueListViewActivity.x1(QueueListViewActivity.this).setVisibility(0);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onSessionResumed(e eVar, boolean z) {
            QueueListViewActivity queueListViewActivity = QueueListViewActivity.this;
            QueueListViewActivity.v1(queueListViewActivity, QueueListViewActivity.y1(queueListViewActivity));
            if (QueueListViewActivity.u1(QueueListViewActivity.this) != null) {
                QueueListViewActivity.u1(QueueListViewActivity.this).N(QueueListViewActivity.w1(QueueListViewActivity.this));
            }
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onSessionStarted(e eVar, String str) {
            QueueListViewActivity queueListViewActivity = QueueListViewActivity.this;
            QueueListViewActivity.v1(queueListViewActivity, QueueListViewActivity.y1(queueListViewActivity));
            if (QueueListViewActivity.u1(QueueListViewActivity.this) != null) {
                QueueListViewActivity.u1(QueueListViewActivity.this).N(QueueListViewActivity.w1(QueueListViewActivity.this));
            }
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void onSessionSuspended(e eVar, int i) {
            if (QueueListViewActivity.u1(QueueListViewActivity.this) != null) {
                QueueListViewActivity.u1(QueueListViewActivity.this).X(QueueListViewActivity.w1(QueueListViewActivity.this));
            }
            QueueListViewActivity.v1(QueueListViewActivity.this, null);
        }

        public /* synthetic */ c(QueueListViewActivity queueListViewActivity, a aVar) {
            this();
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSessionEnding(e eVar) {
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onSessionStarting(e eVar) {
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSessionResumeFailed(e eVar, int i) {
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onSessionResuming(e eVar, String str) {
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onSessionStartFailed(e eVar, int i) {
        }
    }

    public static /* synthetic */ i u1(QueueListViewActivity queueListViewActivity) {
        return queueListViewActivity.g;
    }

    public static /* synthetic */ i v1(QueueListViewActivity queueListViewActivity, i iVar) {
        queueListViewActivity.g = iVar;
        return iVar;
    }

    public static /* synthetic */ i.a w1(QueueListViewActivity queueListViewActivity) {
        return queueListViewActivity.d;
    }

    public static /* synthetic */ View x1(QueueListViewActivity queueListViewActivity) {
        return queueListViewActivity.h;
    }

    public static /* synthetic */ i y1(QueueListViewActivity queueListViewActivity) {
        return queueListViewActivity.z1();
    }

    public final void A1() {
        Toolbar toolbar = (Toolbar) findViewById(f.kh);
        toolbar.setTitle(j.N5);
        r1(toolbar);
        i1().t(true);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f.f(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.f4);
        Log.d("QueueListViewActivity", "onCreate() was called");
        i7.b.n(this);
        o4.b.e(this).c().c();
        if (bundle == null) {
            getSupportFragmentManager().m().c(f.m2, new k7.c(), "list view").i();
        }
        A1();
        this.h = findViewById(f.P2);
        this.f = o4.b.e(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(h.w, menu);
        o4.a.a(getApplicationContext(), menu, f.eb);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == f.d) {
            i7.b.n(getApplicationContext()).x();
            return true;
        }
        if (itemId != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    public void onPause() {
        i iVar = this.g;
        if (iVar != null) {
            iVar.X(this.d);
        }
        this.f.c().e(this.e, e.class);
        super.onPause();
    }

    public void onResume() {
        this.f.c().a(this.e, e.class);
        if (this.g == null) {
            this.g = z1();
        }
        i iVar = this.g;
        if (iVar != null) {
            iVar.N(this.d);
            r l = this.g.l();
            List a0 = l == null ? null : l.a0();
            if (a0 != null && !a0.isEmpty()) {
                this.h.setVisibility(8);
            }
        }
        super.onResume();
    }

    public final i z1() {
        e c2 = this.f.c().c();
        if (c2 == null || !c2.c()) {
            return null;
        }
        return c2.r();
    }
}

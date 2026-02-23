package com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.adapterpushnotification.SBPAnnouncementsAdapter;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton;
import java.util.Calendar;
import java.util.List;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SBPAnnouncementsActivity extends b {
    public RecyclerView d;
    public ProgressBar e;
    public TextView f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public RecyclerView.o j;
    public SBPAnnouncementsAdapter k;
    public Context l;
    public Thread m = null;
    public List n;

    public class 1 implements View.OnClickListener {
        public 1() {
        }

        public void onClick(View view) {
            w.j(SBPAnnouncementsActivity.this.l);
        }
    }

    public class 2 implements Runnable {
        public 2() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(SBPAnnouncementsActivity.this.l);
                String A = w.A(date);
                if (SBPAnnouncementsActivity.u1(SBPAnnouncementsActivity.this) != null) {
                    SBPAnnouncementsActivity.u1(SBPAnnouncementsActivity.this).setText(R);
                }
                if (SBPAnnouncementsActivity.v1(SBPAnnouncementsActivity.this) != null) {
                    SBPAnnouncementsActivity.v1(SBPAnnouncementsActivity.this).setText(A);
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
                    SBPAnnouncementsActivity.this.w1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class OnFocusChangeAccountListener implements View.OnFocusChangeListener {
        public final View a;

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
            if (z) {
                f = z ? 1.23f : 1.0f;
                b(f);
                c(f);
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
            }
        }
    }

    public static /* synthetic */ TextView u1(SBPAnnouncementsActivity sBPAnnouncementsActivity) {
        return sBPAnnouncementsActivity.h;
    }

    public static /* synthetic */ TextView v1(SBPAnnouncementsActivity sBPAnnouncementsActivity) {
        return sBPAnnouncementsActivity.g;
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r3) {
        /*
            r2 = this;
            super.onCreate(r3)
            int r3 = a7.g.h
            r2.setContentView(r3)
            r2.l = r2
            m7.w.Y(r2)
            int r3 = a7.f.ub
            android.view.View r3 = r2.findViewById(r3)
            androidx.recyclerview.widget.RecyclerView r3 = (androidx.recyclerview.widget.RecyclerView) r3
            r2.d = r3
            int r3 = a7.f.oc
            android.view.View r3 = r2.findViewById(r3)
            android.widget.ProgressBar r3 = (android.widget.ProgressBar) r3
            r2.e = r3
            int r3 = a7.f.Qb
            android.view.View r3 = r2.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r2.f = r3
            int r3 = a7.f.E2
            android.view.View r3 = r2.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r2.g = r3
            int r3 = a7.f.gh
            android.view.View r3 = r2.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r2.h = r3
            int r3 = a7.f.Xa
            android.view.View r3 = r2.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r2.i = r3
            com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton r3 = com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton.b()
            java.util.List r3 = r3.a()
            r2.n = r3
            r0 = 8
            if (r3 == 0) goto L8a
            int r3 = r3.size()
            if (r3 <= 0) goto L8a
            androidx.recyclerview.widget.RecyclerView r3 = r2.d
            r1 = 1
            r3.setHasFixedSize(r1)
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            r3.<init>(r2)
            r2.j = r3
            androidx.recyclerview.widget.RecyclerView r1 = r2.d
            r1.setLayoutManager(r3)
            com.nst.iptvsmarterstvbox.sbpfunction.adapterpushnotification.SBPAnnouncementsAdapter r3 = new com.nst.iptvsmarterstvbox.sbpfunction.adapterpushnotification.SBPAnnouncementsAdapter
            java.util.List r1 = r2.n
            r3.<init>(r1, r2)
            r2.k = r3
            androidx.recyclerview.widget.RecyclerView r1 = r2.d
            r1.setAdapter(r3)
            android.widget.ProgressBar r3 = r2.e
            if (r3 == 0) goto L84
            r3.setVisibility(r0)
        L84:
            android.widget.TextView r3 = r2.f
        L86:
            r3.setVisibility(r0)
            goto L9a
        L8a:
            android.widget.ProgressBar r3 = r2.e
            if (r3 == 0) goto L9a
            r3.setVisibility(r0)
            android.widget.TextView r3 = r2.f
            r0 = 0
            r3.setVisibility(r0)
            androidx.recyclerview.widget.RecyclerView r3 = r2.d
            goto L86
        L9a:
            java.lang.Thread r3 = r2.m
            if (r3 == 0) goto La5
            boolean r3 = r3.isAlive()
            if (r3 == 0) goto La5
            goto Lb4
        La5:
            com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.SBPAnnouncementsActivity$CountDownRunner r3 = new com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.SBPAnnouncementsActivity$CountDownRunner
            r3.<init>()
            java.lang.Thread r0 = new java.lang.Thread
            r0.<init>(r3)
            r2.m = r0
            r0.start()
        Lb4:
            android.widget.ImageView r3 = r2.i
            com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.SBPAnnouncementsActivity$1 r0 = new com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.SBPAnnouncementsActivity$1
            r0.<init>()
            r3.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.SBPAnnouncementsActivity.onCreate(android.os.Bundle):void");
    }

    public void onPause() {
        super.onPause();
        try {
            Thread thread = this.m;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.m.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super.onResume();
        Thread thread = this.m;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.m = thread2;
            thread2.start();
        }
        x1();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void w1() {
        runOnUiThread(new 2());
    }

    public void x1() {
        if (SharepreferenceDBHandler.getAnnouncementsList(this.l) == null || SharepreferenceDBHandler.getAnnouncementsList(this.l).size() <= 0) {
            AnnouncementsSBPSingleton.b().c(null);
            ProgressBar progressBar = this.e;
            if (progressBar != null) {
                progressBar.setVisibility(8);
                this.f.setVisibility(0);
                this.d.setVisibility(0);
            }
            SBPAnnouncementsAdapter sBPAnnouncementsAdapter = this.k;
            if (sBPAnnouncementsAdapter != null) {
                sBPAnnouncementsAdapter.q0();
                return;
            }
            return;
        }
        AnnouncementsSBPSingleton.b().c(SharepreferenceDBHandler.getAnnouncementsList(this.l));
        SBPAnnouncementsAdapter sBPAnnouncementsAdapter2 = this.k;
        if (sBPAnnouncementsAdapter2 != null) {
            sBPAnnouncementsAdapter2.q0();
        } else {
            this.n = AnnouncementsSBPSingleton.b().a();
            this.d.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.l);
            this.j = linearLayoutManager;
            this.d.setLayoutManager(linearLayoutManager);
            SBPAnnouncementsAdapter sBPAnnouncementsAdapter3 = new SBPAnnouncementsAdapter(this.n, this);
            this.k = sBPAnnouncementsAdapter3;
            this.d.setAdapter(sBPAnnouncementsAdapter3);
        }
        ProgressBar progressBar2 = this.e;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        this.f.setVisibility(8);
    }
}

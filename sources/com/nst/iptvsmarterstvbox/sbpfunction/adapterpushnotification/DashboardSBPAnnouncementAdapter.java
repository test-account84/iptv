package com.nst.iptvsmarterstvbox.sbpfunction.adapterpushnotification;

import a7.c;
import a7.e;
import a7.f;
import a7.g;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.AnnouncementsData;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton;
import com.nst.iptvsmarterstvbox.view.activity.AnnouncementAlertActivity;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DashboardSBPAnnouncementAdapter extends RecyclerView.g {
    public RelativeLayout d;
    public List e;
    public NewDashboardActivity f;
    public boolean g = true;
    public ImageView h;

    public class 1 implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public 1(String str, String str2, String str3, String str4) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        public void onClick(View view) {
            Intent intent = new Intent(DashboardSBPAnnouncementAdapter.j0(DashboardSBPAnnouncementAdapter.this), AnnouncementAlertActivity.class);
            intent.putExtra("Title", this.a);
            intent.putExtra("Description", this.c);
            intent.putExtra("Id", this.d);
            intent.putExtra("CheckSeen", this.e);
            DashboardSBPAnnouncementAdapter.j0(DashboardSBPAnnouncementAdapter.this).startActivity(intent);
        }
    }

    public class OnFocusChangeAccountListener implements View.OnFocusChangeListener {
        public final View a;

        public OnFocusChangeAccountListener(View view) {
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
            View view2;
            int i;
            if (z) {
                b(1.0f);
                c(1.0f);
                view2 = this.a;
                i = e.o2;
            } else {
                if (z) {
                    return;
                }
                b(1.0f);
                c(1.0f);
                a(z);
                view2 = this.a;
                i = c.z;
            }
            view2.setBackgroundResource(i);
        }
    }

    public class ViewHolder extends RecyclerView.D {
        public TextView t;
        public TextView u;
        public TextView v;
        public ImageView w;
        public View x;
        public CardView y;

        public ViewHolder(View view) {
            super(view);
            this.x = view;
            this.t = view.findViewById(f.dk);
            this.u = view.findViewById(f.ck);
            this.v = view.findViewById(f.ri);
            this.y = view.findViewById(f.G1);
            DashboardSBPAnnouncementAdapter.k0(DashboardSBPAnnouncementAdapter.this, view.findViewById(f.Pe));
            DashboardSBPAnnouncementAdapter.l0(DashboardSBPAnnouncementAdapter.this, view.findViewById(f.Y4));
            this.w = view.findViewById(f.Tb);
        }

        public static /* synthetic */ CardView P(ViewHolder viewHolder) {
            return viewHolder.y;
        }
    }

    public DashboardSBPAnnouncementAdapter(List list, NewDashboardActivity newDashboardActivity) {
        this.f = newDashboardActivity;
        this.e = list;
    }

    public static /* synthetic */ NewDashboardActivity j0(DashboardSBPAnnouncementAdapter dashboardSBPAnnouncementAdapter) {
        return dashboardSBPAnnouncementAdapter.f;
    }

    public static /* synthetic */ RelativeLayout k0(DashboardSBPAnnouncementAdapter dashboardSBPAnnouncementAdapter, RelativeLayout relativeLayout) {
        dashboardSBPAnnouncementAdapter.d = relativeLayout;
        return relativeLayout;
    }

    public static /* synthetic */ ImageView l0(DashboardSBPAnnouncementAdapter dashboardSBPAnnouncementAdapter, ImageView imageView) {
        dashboardSBPAnnouncementAdapter.h = imageView;
        return imageView;
    }

    public String m0(String str) {
        String str2 = "";
        try {
            String format = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            str2 = Long.toString(Math.abs(simpleDateFormat.parse(format).getTime() - simpleDateFormat.parse(str).getTime()) / 86400000);
            Log.e("HERE", "HERE: " + str2);
            return str2;
        } catch (Exception e) {
            Log.e("DIDN'T WORK", "exception " + e);
            return str2;
        }
    }

    public int n() {
        return this.e.size();
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void E(ViewHolder viewHolder, int i) {
        TextView textView;
        String str;
        AnnouncementsData announcementsData = (AnnouncementsData) this.e.get(i);
        if (announcementsData.getSeen().intValue() == 0) {
            ViewHolder.P(viewHolder).setBackgroundColor(this.f.getResources().getColor(c.c));
            viewHolder.u.setTypeface((Typeface) null, 1);
            viewHolder.v.setTypeface((Typeface) null, 1);
            viewHolder.t.setSelected(true);
            viewHolder.u.setTextColor(this.f.getResources().getColor(c.G));
            viewHolder.t.setTextColor(this.f.getResources().getColor(c.G));
            viewHolder.v.setTextColor(this.f.getResources().getColor(c.G));
            viewHolder.w.setVisibility(0);
        } else {
            ViewHolder.P(viewHolder).setBackgroundColor(this.f.getResources().getColor(c.v));
            viewHolder.v.setTypeface((Typeface) null, 0);
            viewHolder.u.setTypeface((Typeface) null, 0);
            viewHolder.t.setSelected(true);
            viewHolder.u.setTextColor(this.f.getResources().getColor(c.w));
            viewHolder.t.setTextColor(this.f.getResources().getColor(c.w));
            viewHolder.v.setTextColor(this.f.getResources().getColor(c.w));
            viewHolder.w.setVisibility(8);
        }
        viewHolder.t.setText(announcementsData.getTitle());
        String title = announcementsData.getTitle();
        String message = announcementsData.getMessage();
        String id = announcementsData.getId();
        String valueOf = String.valueOf(announcementsData.getSeen());
        viewHolder.u.setText(MyApplication.p().o(message));
        String m0 = m0(announcementsData.getCreatedOn());
        if (m0.equalsIgnoreCase("0")) {
            textView = viewHolder.v;
            str = "Today";
        } else {
            if (!m0.equalsIgnoreCase("1")) {
                viewHolder.v.setText(m0 + " days ago");
                ViewHolder.P(viewHolder).setOnClickListener(new 1(title, message, id, valueOf));
                ViewHolder.P(viewHolder).setOnFocusChangeListener(new OnFocusChangeAccountListener(ViewHolder.P(viewHolder)));
                if (i == 0 || !this.g) {
                }
                this.g = false;
                return;
            }
            textView = viewHolder.v;
            str = "Yesterday";
        }
        textView.setText(str);
        ViewHolder.P(viewHolder).setOnClickListener(new 1(title, message, id, valueOf));
        ViewHolder.P(viewHolder).setOnFocusChangeListener(new OnFocusChangeAccountListener(ViewHolder.P(viewHolder)));
        if (i == 0) {
        }
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public ViewHolder L(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.f).inflate(g.e3, viewGroup, false));
    }

    public void q0() {
        List a = AnnouncementsSBPSingleton.b().a();
        if (a == null || a.size() <= 0) {
            return;
        }
        this.e = a;
        w();
    }
}

package com.nst.iptvsmarterstvbox.sbpfunction.adapterpushnotification;

import a7.c;
import a7.e;
import a7.f;
import a7.g;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.pojo.AnnouncementsResponsePojo;
import com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.AnnouncementsNewActivity;
import com.nst.iptvsmarterstvbox.view.activity.AnnouncementAlertActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AnnouncementsAdapterNew extends RecyclerView.g {
    public RelativeLayout d;
    public List e;
    public AnnouncementsNewActivity f;
    public boolean g = true;
    public ImageView h;

    public class 1 implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;

        public 1(String str, String str2) {
            this.a = str;
            this.c = str2;
        }

        public void onClick(View view) {
            Intent intent = new Intent(AnnouncementsAdapterNew.this.f, AnnouncementAlertActivity.class);
            intent.putExtra("Title", this.a);
            intent.putExtra("Description", this.c);
            AnnouncementsAdapterNew.this.f.startActivity(intent);
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
        public View w;
        public CardView x;

        public ViewHolder(View view) {
            super(view);
            this.w = view;
            this.t = view.findViewById(f.dk);
            this.u = view.findViewById(f.ck);
            this.v = view.findViewById(f.ri);
            this.x = view.findViewById(f.G1);
            AnnouncementsAdapterNew.this.d = view.findViewById(f.Pe);
            AnnouncementsAdapterNew.j0(AnnouncementsAdapterNew.this, view.findViewById(f.Y4));
        }

        public static /* synthetic */ CardView P(ViewHolder viewHolder) {
            return viewHolder.x;
        }
    }

    public AnnouncementsAdapterNew(List list, AnnouncementsNewActivity announcementsNewActivity) {
        this.f = announcementsNewActivity;
        this.e = list;
    }

    public static /* synthetic */ ImageView j0(AnnouncementsAdapterNew announcementsAdapterNew, ImageView imageView) {
        announcementsAdapterNew.h = imageView;
        return imageView;
    }

    public String k0(String str) {
        String str2 = "";
        try {
            String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            str2 = Long.toString(Math.abs(simpleDateFormat.parse(format).getTime() - simpleDateFormat.parse(str).getTime()) / 86400000);
            Log.e("HERE", "HERE: " + str2);
            return str2;
        } catch (Exception e) {
            Log.e("DIDN'T WORK", "exception " + e);
            return str2;
        }
    }

    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void E(ViewHolder viewHolder, int i) {
        TextView textView;
        String str;
        AnnouncementsResponsePojo announcementsResponsePojo = (AnnouncementsResponsePojo) this.e.get(i);
        viewHolder.t.setText(announcementsResponsePojo.getTitle());
        String title = announcementsResponsePojo.getTitle();
        String description = announcementsResponsePojo.getDescription();
        viewHolder.u.setText(announcementsResponsePojo.getDescription());
        String k0 = k0(announcementsResponsePojo.getCreateDate());
        if (k0.equalsIgnoreCase("0")) {
            textView = viewHolder.v;
            str = "Today";
        } else {
            if (!k0.equalsIgnoreCase("1")) {
                viewHolder.v.setText(k0 + " days ago");
                ViewHolder.P(viewHolder).setOnClickListener(new 1(title, description));
                ViewHolder.P(viewHolder).setOnFocusChangeListener(new OnFocusChangeAccountListener(ViewHolder.P(viewHolder)));
                if (i == 0 || !this.g) {
                }
                ViewHolder.P(viewHolder).requestFocus();
                this.g = false;
                return;
            }
            textView = viewHolder.v;
            str = "Yesterday";
        }
        textView.setText(str);
        ViewHolder.P(viewHolder).setOnClickListener(new 1(title, description));
        ViewHolder.P(viewHolder).setOnFocusChangeListener(new OnFocusChangeAccountListener(ViewHolder.P(viewHolder)));
        if (i == 0) {
        }
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public ViewHolder L(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.f).inflate(g.c3, viewGroup, false));
    }

    public int n() {
        return this.e.size();
    }
}

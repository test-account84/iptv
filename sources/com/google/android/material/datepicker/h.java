package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h extends BaseAdapter {
    public static final int e;
    public final Calendar a;
    public final int c;
    public final int d;

    static {
        e = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public h() {
        Calendar k = v.k();
        this.a = k;
        this.c = k.getMaximum(7);
        this.d = k.getFirstDayOfWeek();
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i) {
        if (i >= this.c) {
            return null;
        }
        return Integer.valueOf(b(i));
    }

    public final int b(int i) {
        int i2 = i + this.d;
        int i3 = this.c;
        return i2 > i3 ? i2 - i3 : i2;
    }

    public int getCount() {
        return this.c;
    }

    public long getItemId(int i) {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = LayoutInflater.from(viewGroup.getContext()).inflate(R4.h.n, viewGroup, false);
        }
        this.a.set(7, b(i));
        textView.setText(this.a.getDisplayName(7, e, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R4.j.n), new Object[]{this.a.getDisplayName(7, 2, Locale.getDefault())}));
        return textView;
    }
}

package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class w extends RecyclerView.g {
    public final i d;

    public static class a extends RecyclerView.D {
        public final TextView t;

        public a(TextView textView) {
            super(textView);
            this.t = textView;
        }
    }

    public w(i iVar) {
        this.d = iVar;
    }

    public int j0(int i) {
        return i - this.d.S().m().d;
    }

    public int k0(int i) {
        return this.d.S().m().d + i;
    }

    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void E(a aVar, int i) {
        int k0 = k0(i);
        String string = aVar.t.getContext().getString(R4.j.o);
        aVar.t.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(k0)}));
        aVar.t.setContentDescription(String.format(string, new Object[]{Integer.valueOf(k0)}));
        c T = this.d.T();
        if (v.i().get(1) == k0) {
            b bVar = T.f;
        } else {
            b bVar2 = T.d;
        }
        this.d.X();
        throw null;
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a L(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R4.h.r, viewGroup, false));
    }

    public int n() {
        return this.d.S().r();
    }
}

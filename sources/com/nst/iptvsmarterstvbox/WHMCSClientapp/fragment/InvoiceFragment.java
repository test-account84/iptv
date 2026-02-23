package com.nst.iptvsmarterstvbox.WHMCSClientapp.fragment;

import a7.f;
import a7.g;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Field;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InvoiceFragment extends Fragment {
    public WebView a;
    public String c;
    public String d;
    public String e = "";
    public String f = "";
    public String g = "";
    public OnFragmentInteractionListener h;

    public interface OnFragmentInteractionListener {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            this.h = (OnFragmentInteractionListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.c = getArguments().getString("param1");
            this.d = getArguments().getString("param2");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.M2, viewGroup, false);
        this.a = inflate.findViewById(f.Vm);
        x();
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(this, (Object) null);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void x() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.e = arguments.getString("invoice_id");
        }
        this.a.setWebChromeClient(new WebChromeClient());
    }
}

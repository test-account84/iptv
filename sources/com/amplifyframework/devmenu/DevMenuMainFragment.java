package com.amplifyframework.devmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.r;
import com.amplifyframework.core.R;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DevMenuMainFragment extends Fragment {
    public static /* synthetic */ void A(View view) {
        lambda$onCreateView$2(view);
    }

    public static /* synthetic */ void B(View view) {
        lambda$onCreateView$3(view);
    }

    private static /* synthetic */ void lambda$onCreateView$0(View view) {
        r.b(view).n(R.id.show_env_info);
    }

    private static /* synthetic */ void lambda$onCreateView$1(View view) {
        r.b(view).n(R.id.show_device_info);
    }

    private static /* synthetic */ void lambda$onCreateView$2(View view) {
        r.b(view).n(R.id.show_logs);
    }

    private static /* synthetic */ void lambda$onCreateView$3(View view) {
        r.b(view).n(R.id.show_file_issue);
    }

    public static /* synthetic */ void x(View view) {
        lambda$onCreateView$1(view);
    }

    public static /* synthetic */ void z(View view) {
        lambda$onCreateView$0(view);
    }

    public /* bridge */ /* synthetic */ m0.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.h.a(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dev_menu_fragment_main, viewGroup, false);
        inflate.findViewById(R.id.env_button).setOnClickListener(new d());
        inflate.findViewById(R.id.device_button).setOnClickListener(new e());
        inflate.findViewById(R.id.logs_button).setOnClickListener(new f());
        inflate.findViewById(R.id.file_issue_button).setOnClickListener(new g());
        return inflate;
    }
}

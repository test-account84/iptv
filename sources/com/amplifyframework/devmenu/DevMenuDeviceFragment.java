package com.amplifyframework.devmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.amplifyframework.core.R;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DevMenuDeviceFragment extends Fragment {
    public /* bridge */ /* synthetic */ m0.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.h.a(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dev_menu_fragment_device, viewGroup, false);
        inflate.findViewById(R.id.device_info_text).setText(new DeviceInfo().toString());
        return inflate;
    }
}

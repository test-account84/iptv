package com.amplifyframework.devmenu;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.R;
import com.amplifyframework.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DevMenuEnvironmentFragment extends Fragment {
    private static final Logger LOG = Amplify.Logging.forNamespace("amplify:devmenu");

    private SpannableStringBuilder getEnvironmentInfo() {
        String str;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        EnvironmentInfo environmentInfo = new EnvironmentInfo();
        spannableStringBuilder.append(setBold("Amplify Plugins Information"));
        spannableStringBuilder.append("\n" + environmentInfo.getPluginVersions() + "\n");
        spannableStringBuilder.append(setBold("Developer Environment Information"));
        try {
            str = environmentInfo.getDeveloperEnvironmentInfo(requireContext());
        } catch (AmplifyException unused) {
            LOG.warn("Error reading developer environment information.");
            str = "";
        }
        if (str.isEmpty()) {
            str2 = "\nUnable to retrieve developer environment information.";
        } else {
            str2 = "\n" + str;
        }
        spannableStringBuilder.append(str2);
        return spannableStringBuilder;
    }

    private SpannableString setBold(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
        return spannableString;
    }

    public /* bridge */ /* synthetic */ m0.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.h.a(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dev_menu_fragment_environment, viewGroup, false);
        inflate.findViewById(R.id.env_info_text).setText(getEnvironmentInfo());
        return inflate;
    }
}

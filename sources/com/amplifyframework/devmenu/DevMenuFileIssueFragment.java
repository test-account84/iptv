package com.amplifyframework.devmenu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.amplifyframework.core.R;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DevMenuFileIssueFragment extends Fragment {
    private static final String DESCRIPTION_LENGTH_ERROR = "Issue description must be at least 20 characters.";
    private static final int MIN_DESCRIPTION_LENGTH = 20;
    private static final String NEW_ISSUE_URL = "https://github.com/aws-amplify/amplify-android/issues/new";
    private DeveloperMenu developerMenu;
    private View fileIssueView;

    private void fileIssue() {
        String issueBody = getIssueBody();
        if (issueBody.isEmpty()) {
            return;
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/aws-amplify/amplify-android/issues/new").buildUpon().appendQueryParameter("title", "").appendQueryParameter("body", issueBody).build()));
    }

    private String getIssueBody() {
        EditText findViewById = this.fileIssueView.findViewById(R.id.issue_description);
        String obj = findViewById.getText().toString();
        if (obj.length() >= 20) {
            return this.developerMenu.createIssueBody(obj, false);
        }
        findViewById.setError("Issue description must be at least 20 characters.");
        return "";
    }

    private /* synthetic */ void lambda$onCreateView$0(View view) {
        fileIssue();
    }

    private /* synthetic */ void lambda$onCreateView$1(Context context, View view) {
        String issueBody = getIssueBody();
        if (issueBody.isEmpty()) {
            return;
        }
        this.developerMenu.copyToClipboard(issueBody);
        Toast.makeText(context, "Copied issue body to clipboard.", 0).show();
    }

    public static /* synthetic */ void x(DevMenuFileIssueFragment devMenuFileIssueFragment, Context context, View view) {
        devMenuFileIssueFragment.lambda$onCreateView$1(context, view);
    }

    public static /* synthetic */ void z(DevMenuFileIssueFragment devMenuFileIssueFragment, View view) {
        devMenuFileIssueFragment.lambda$onCreateView$0(view);
    }

    public /* bridge */ /* synthetic */ m0.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.h.a(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fileIssueView = layoutInflater.inflate(R.layout.dev_menu_fragment_file_issue, viewGroup, false);
        Context applicationContext = requireContext().getApplicationContext();
        this.developerMenu = DeveloperMenu.singletonInstance(applicationContext);
        this.fileIssueView.findViewById(R.id.file_issue).setOnClickListener(new a(this));
        this.fileIssueView.findViewById(R.id.copy_issue).setOnClickListener(new b(this, applicationContext));
        return this.fileIssueView;
    }
}

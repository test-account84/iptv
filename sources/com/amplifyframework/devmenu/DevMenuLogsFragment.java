package com.amplifyframework.devmenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.amplifyframework.core.R;
import com.amplifyframework.logging.LogLevel;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DevMenuLogsFragment extends Fragment {
    private DeveloperMenu developerMenu;
    private TextView logsText;
    private String searchQuery;
    private MenuItem selectedLogsFilterItem;

    public class 1 implements SearchView.OnQueryTextListener {
        public 1() {
        }

        public boolean onQueryTextChange(String str) {
            DevMenuLogsFragment.access$002(DevMenuLogsFragment.this, str);
            DevMenuLogsFragment.access$100(DevMenuLogsFragment.this);
            return true;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public static /* synthetic */ String access$002(DevMenuLogsFragment devMenuLogsFragment, String str) {
        devMenuLogsFragment.searchQuery = str;
        return str;
    }

    public static /* synthetic */ void access$100(DevMenuLogsFragment devMenuLogsFragment) {
        devMenuLogsFragment.displayFilteredLogs();
    }

    private void displayFilteredLogs() {
        this.logsText.setText(R.string.placeholder_logs);
        this.logsText.setText(this.developerMenu.getFilteredLogs(this.searchQuery, this.selectedLogsFilterItem.getItemId() != R.id.all_logs ? LogLevel.valueOf(this.selectedLogsFilterItem.getTitle().toString().toUpperCase(Locale.US)) : null));
    }

    private /* synthetic */ void lambda$onCreateView$0(View view) {
        requireActivity().openContextMenu(view);
    }

    public static /* synthetic */ void x(DevMenuLogsFragment devMenuLogsFragment, View view) {
        devMenuLogsFragment.lambda$onCreateView$0(view);
    }

    public /* bridge */ /* synthetic */ m0.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.h.a(this);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        this.selectedLogsFilterItem = menuItem;
        displayFilteredLogs();
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        requireActivity().getMenuInflater().inflate(R.menu.dev_menu_logs_menu, contextMenu);
        if (this.selectedLogsFilterItem == null) {
            this.selectedLogsFilterItem = contextMenu.findItem(R.id.all_logs);
        }
        contextMenu.findItem(this.selectedLogsFilterItem.getItemId()).setChecked(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dev_menu_fragment_logs, viewGroup, false);
        this.developerMenu = DeveloperMenu.singletonInstance(getContext());
        TextView findViewById = inflate.findViewById(R.id.logs_text);
        this.logsText = findViewById;
        findViewById.setText(this.developerMenu.getLogs());
        inflate.findViewById(R.id.search_logs_field).setOnQueryTextListener(new 1());
        Button findViewById2 = inflate.findViewById(R.id.filter_logs);
        registerForContextMenu(findViewById2);
        findViewById2.setOnClickListener(new c(this));
        return inflate;
    }
}

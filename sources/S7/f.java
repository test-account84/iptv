package s7;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class f extends Fragment {
    public EditText a;
    public EditText c;
    public EditText d;
    public Button e;
    public String f = "";
    public String g = "";
    public String h = "";
    public Context i;
    public LiveStreamDBHandler j;
    public String k;
    public String l;
    public b m;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            f.this.B();
        }
    }

    public interface b {
    }

    private void A() {
        this.i = getContext();
        this.j = new LiveStreamDBHandler(this.i);
        this.f = String.valueOf(this.a.getText());
        this.g = String.valueOf(this.c.getText());
        this.h = String.valueOf(this.d.getText());
        this.a.requestFocus();
        ((InputMethodManager) this.i.getSystemService("input_method")).showSoftInput(this.a, 1);
    }

    public void B() {
        Context context;
        Resources resources;
        int i;
        if (this.i != null) {
            this.f = String.valueOf(this.a.getText());
            this.g = String.valueOf(this.c.getText());
            this.h = String.valueOf(this.d.getText());
            String string = this.i.getSharedPreferences("loginPrefs", 0).getString("username", "");
            if (!D(string, this.f, SharepreferenceDBHandler.getUserID(this.i))) {
                context = this.i;
                if (context != null) {
                    resources = getResources();
                    i = a7.j.E2;
                    Toast.makeText(context, resources.getString(i), 0).show();
                }
            } else {
                if (!z(this.g, this.h)) {
                    return;
                }
                if (this.g.equals(this.h)) {
                    E(this.j.upDatePassword(string, this.g, SharepreferenceDBHandler.getUserID(this.i)));
                    getActivity().finish();
                    return;
                } else {
                    context = this.i;
                    if (context != null) {
                        resources = getResources();
                        i = a7.j.W4;
                        Toast.makeText(context, resources.getString(i), 0).show();
                    }
                }
            }
            x();
        }
    }

    public final boolean D(String str, String str2, int i) {
        String str3;
        boolean z;
        ArrayList allPassword = new LiveStreamDBHandler(this.i).getAllPassword(SharepreferenceDBHandler.getUserID(this.i));
        if (allPassword != null) {
            Iterator it = allPassword.iterator();
            str3 = "";
            z = false;
            while (it.hasNext()) {
                PasswordDBModel passwordDBModel = (PasswordDBModel) it.next();
                if (passwordDBModel.getUserDetail().equals(str) && !passwordDBModel.getUserPassword().isEmpty()) {
                    str3 = passwordDBModel.getUserPassword();
                    z = true;
                }
            }
        } else {
            str3 = "";
            z = false;
        }
        return (!z || str2 == null || str2.isEmpty() || str2.equals("") || str3.equals("") || !str3.equals(str2)) ? false : true;
    }

    public final void E(boolean z) {
        Context context;
        Resources resources;
        int i;
        if (z) {
            context = this.i;
            if (context != null) {
                resources = getResources();
                i = a7.j.Z4;
                Toast.makeText(context, resources.getString(i), 0).show();
            }
        } else {
            context = this.i;
            if (context != null) {
                resources = getResources();
                i = a7.j.e7;
                Toast.makeText(context, resources.getString(i), 0).show();
            }
        }
        x();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof b) {
            this.m = (b) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.k = getArguments().getString("param1");
            this.l = getArguments().getString("param2");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a7.g.R2, viewGroup, false);
        this.a = inflate.findViewById(a7.f.Fk);
        this.c = inflate.findViewById(a7.f.ok);
        this.d = inflate.findViewById(a7.f.ni);
        Button findViewById = inflate.findViewById(a7.f.H0);
        this.e = findViewById;
        findViewById.setOnClickListener(new a());
        A();
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDetach() {
        super.onDetach();
        this.m = null;
    }

    public final void x() {
        EditText editText = this.a;
        if (editText == null || this.d == null || this.c == null) {
            return;
        }
        editText.getText().clear();
        this.d.getText().clear();
        this.c.getText().clear();
    }

    public final boolean z(String str, String str2) {
        if (str == null || str.equals("") || str.isEmpty()) {
            Context context = this.i;
            if (context != null) {
                Toast.makeText(context, getResources().getString(a7.j.t1), 0).show();
            }
            return false;
        }
        if ((!str.isEmpty() && !str.equals("") && str2 == null && str2.isEmpty()) || str2.equals("")) {
            Context context2 = this.i;
            if (context2 != null) {
                Toast.makeText(context2, getResources().getString(a7.j.o1), 0).show();
                return false;
            }
        } else if ((!str.isEmpty() && !str.equals("") && !str2.isEmpty()) || !str2.equals("")) {
            return true;
        }
        return false;
    }
}

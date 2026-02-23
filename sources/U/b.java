package U;

import android.database.Cursor;
import android.widget.Filter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends Filter {
    public a a;

    public interface a {
        void a(Cursor cursor);

        CharSequence b(Cursor cursor);

        Cursor c(CharSequence charSequence);

        Cursor d();
    }

    public b(a aVar) {
        this.a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.a.b((Cursor) obj);
    }

    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor c = this.a.c(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (c != null) {
            filterResults.count = c.getCount();
        } else {
            filterResults.count = 0;
            c = null;
        }
        filterResults.values = c;
        return filterResults;
    }

    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor d = this.a.d();
        Object obj = filterResults.values;
        if (obj == null || obj == d) {
            return;
        }
        this.a.a((Cursor) obj);
    }
}

package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import d.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import u0.K;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends u {
    static final int MSG_UPDATE_ROUTES = 1;
    static final String TAG = "MediaRouteChooserDialog";
    private static final long UPDATE_ROUTES_DELAY_MS = 300;
    private c mAdapter;
    private boolean mAttachedToWindow;
    private final b mCallback;
    private final Handler mHandler;
    private long mLastUpdateTime;
    private ListView mListView;
    private final L mRouter;
    private ArrayList mRoutes;
    private K mSelector;
    private TextView mTitleView;

    public class a extends Handler {
        public a() {
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            a.this.updateRoutes((List) message.obj);
        }
    }

    public final class b extends L.a {
        public b() {
        }

        public void onRouteAdded(L l, L.h hVar) {
            a.this.refreshRoutes();
        }

        public void onRouteChanged(L l, L.h hVar) {
            a.this.refreshRoutes();
        }

        public void onRouteRemoved(L l, L.h hVar) {
            a.this.refreshRoutes();
        }

        public void onRouteSelected(L l, L.h hVar) {
            a.this.dismiss();
        }
    }

    public static final class c extends ArrayAdapter implements AdapterView.OnItemClickListener {
        public final LayoutInflater a;
        public final Drawable c;
        public final Drawable d;
        public final Drawable e;
        public final Drawable f;

        public c(Context context, List list) {
            super(context, 0, list);
            this.a = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{t0.a.b, t0.a.i, t0.a.f, t0.a.e});
            this.c = e.a.b(context, obtainStyledAttributes.getResourceId(0, 0));
            this.d = e.a.b(context, obtainStyledAttributes.getResourceId(1, 0));
            this.e = e.a.b(context, obtainStyledAttributes.getResourceId(2, 0));
            this.f = e.a.b(context, obtainStyledAttributes.getResourceId(3, 0));
            obtainStyledAttributes.recycle();
        }

        public final Drawable a(L.h hVar) {
            int f = hVar.f();
            return f != 1 ? f != 2 ? hVar.y() ? this.f : this.c : this.e : this.d;
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public final Drawable b(L.h hVar) {
            Uri j = hVar.j();
            if (j != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(getContext().getContentResolver().openInputStream(j), (String) null);
                    if (createFromStream != null) {
                        return createFromStream;
                    }
                } catch (IOException e) {
                    Log.w("MediaRouteChooserDialog", "Failed to load " + j, e);
                }
            }
            return a(hVar);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.a.inflate(t0.i.g, viewGroup, false);
            }
            L.h hVar = (L.h) getItem(i);
            TextView findViewById = view.findViewById(t0.f.x);
            TextView findViewById2 = view.findViewById(t0.f.v);
            findViewById.setText(hVar.m());
            String d = hVar.d();
            if ((hVar.c() == 2 || hVar.c() == 1) && !TextUtils.isEmpty(d)) {
                findViewById.setGravity(80);
                findViewById2.setVisibility(0);
                findViewById2.setText(d);
            } else {
                findViewById.setGravity(16);
                findViewById2.setVisibility(8);
                findViewById2.setText("");
            }
            view.setEnabled(hVar.x());
            ImageView findViewById3 = view.findViewById(t0.f.w);
            if (findViewById3 != null) {
                findViewById3.setImageDrawable(b(hVar));
            }
            return view;
        }

        public boolean isEnabled(int i) {
            return ((L.h) getItem(i)).x();
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            L.h hVar = (L.h) getItem(i);
            if (hVar.x()) {
                ImageView findViewById = view.findViewById(t0.f.w);
                ProgressBar findViewById2 = view.findViewById(t0.f.y);
                if (findViewById != null && findViewById2 != null) {
                    findViewById.setVisibility(8);
                    findViewById2.setVisibility(0);
                }
                hVar.I();
            }
        }
    }

    public static final class d implements Comparator {
        public static final d a = new d();

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(L.h hVar, L.h hVar2) {
            return hVar.m().compareToIgnoreCase(hVar2.m());
        }
    }

    public a(Context context) {
        this(context, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        this.mRouter.b(this.mSelector, this.mCallback, 1);
        refreshRoutes();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t0.i.f);
        this.mRoutes = new ArrayList();
        this.mAdapter = new c(getContext(), this.mRoutes);
        ListView findViewById = findViewById(t0.f.u);
        this.mListView = findViewById;
        findViewById.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this.mAdapter);
        this.mListView.setEmptyView(findViewById(16908292));
        this.mTitleView = findViewById(t0.f.z);
        updateLayout();
    }

    public void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        this.mRouter.s(this.mCallback);
        this.mHandler.removeMessages(1);
        super.onDetachedFromWindow();
    }

    public boolean onFilterRoute(L.h hVar) {
        return !hVar.w() && hVar.x() && hVar.E(this.mSelector);
    }

    public void onFilterRoutes(List list) {
        int size = list.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            if (!onFilterRoute((L.h) list.get(i))) {
                list.remove(i);
            }
            size = i;
        }
    }

    public void refreshRoutes() {
        if (this.mAttachedToWindow) {
            ArrayList arrayList = new ArrayList(this.mRouter.m());
            onFilterRoutes(arrayList);
            Collections.sort(arrayList, d.a);
            if (SystemClock.uptimeMillis() - this.mLastUpdateTime >= 300) {
                updateRoutes(arrayList);
                return;
            }
            this.mHandler.removeMessages(1);
            Handler handler = this.mHandler;
            handler.sendMessageAtTime(handler.obtainMessage(1, arrayList), this.mLastUpdateTime + 300);
        }
    }

    public void setRouteSelector(K k) {
        if (k == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.mSelector.equals(k)) {
            return;
        }
        this.mSelector = k;
        if (this.mAttachedToWindow) {
            this.mRouter.s(this.mCallback);
            this.mRouter.b(k, this.mCallback, 1);
        }
        refreshRoutes();
    }

    public void setTitle(int i) {
        this.mTitleView.setText(i);
    }

    public void updateLayout() {
        getWindow().setLayout(f.b(getContext()), -2);
    }

    public void updateRoutes(List list) {
        this.mLastUpdateTime = SystemClock.uptimeMillis();
        this.mRoutes.clear();
        this.mRoutes.addAll(list);
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, int i) {
        Context b2 = i.b(context, i, false);
        super(b2, i.c(b2));
        this.mSelector = K.c;
        this.mHandler = new a();
        this.mRouter = L.j(getContext());
        this.mCallback = new b();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitleView.setText(charSequence);
    }
}

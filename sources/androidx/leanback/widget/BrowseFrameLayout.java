package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BrowseFrameLayout extends FrameLayout {
    public View.OnKeyListener a;

    public interface a {
    }

    public interface b {
    }

    public BrowseFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        View.OnKeyListener onKeyListener = this.a;
        return (onKeyListener == null || dispatchKeyEvent) ? dispatchKeyEvent : onKeyListener.onKey(getRootView(), keyEvent.getKeyCode(), keyEvent);
    }

    public View focusSearch(View view, int i) {
        return super.focusSearch(view, i);
    }

    public a getOnChildFocusListener() {
        return null;
    }

    public b getOnFocusSearchListener() {
        return null;
    }

    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        return super.onRequestFocusInDescendants(i, rect);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
    }

    public void setOnChildFocusListener(a aVar) {
    }

    public void setOnDispatchKeyListener(View.OnKeyListener onKeyListener) {
        this.a = onKeyListener;
    }

    public void setOnFocusSearchListener(b bVar) {
    }

    public BrowseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

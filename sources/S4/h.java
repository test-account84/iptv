package s4;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h extends View.AccessibilityDelegate {
    public final /* synthetic */ CastSeekBar a;

    public /* synthetic */ h(CastSeekBar castSeekBar, g gVar) {
        this.a = castSeekBar;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(SeekBar.class.getName());
        accessibilityEvent.setItemCount(this.a.a.b);
        accessibilityEvent.setCurrentItemIndex(this.a.getProgress());
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SeekBar.class.getName());
        if (C4.m.b() && view.isEnabled()) {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (!view.isEnabled()) {
            return false;
        }
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (C4.m.b() && (i == 4096 || i == 8192)) {
            CastSeekBar.b(this.a);
            CastSeekBar castSeekBar = this.a;
            int i2 = castSeekBar.a.b / 20;
            if (i == 8192) {
                i2 = -i2;
            }
            CastSeekBar.a(castSeekBar, castSeekBar.getProgress() + i2);
            CastSeekBar.c(this.a);
        }
        return false;
    }
}

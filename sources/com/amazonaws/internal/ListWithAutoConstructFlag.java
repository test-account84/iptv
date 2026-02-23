package com.amazonaws.internal;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListWithAutoConstructFlag extends ArrayList {
    private static final long serialVersionUID = 1;
    private boolean autoConstruct;

    public ListWithAutoConstructFlag() {
    }

    public boolean isAutoConstruct() {
        return this.autoConstruct;
    }

    public void setAutoConstruct(boolean z) {
        this.autoConstruct = z;
    }

    public ListWithAutoConstructFlag(int i) {
        super(i);
    }

    public ListWithAutoConstructFlag(Collection collection) {
        super(collection);
    }
}

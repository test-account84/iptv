package org.simpleframework.xml.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class LabelGroup {
    private final List list;
    private final int size;

    public LabelGroup(List list) {
        this.size = list.size();
        this.list = list;
    }

    public List getList() {
        return this.list;
    }

    public Label getPrimary() {
        if (this.size > 0) {
            return (Label) this.list.get(0);
        }
        return null;
    }

    public LabelGroup(Label label) {
        this(Arrays.asList(new Label[]{label}));
    }
}

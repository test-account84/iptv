package org.simpleframework.xml.stream;

import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class EventElement extends ArrayList implements EventNode {
    public int getLine() {
        return -1;
    }

    public String getValue() {
        return null;
    }

    public boolean isEnd() {
        return false;
    }

    public boolean isStart() {
        return true;
    }

    public boolean isText() {
        return false;
    }
}

package org.jsoup.parser;

import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ParseErrorList extends ArrayList {
    private static final int INITIAL_CAPACITY = 16;
    private final int maxSize;

    public ParseErrorList(int i, int i2) {
        super(i);
        this.maxSize = i2;
    }

    public static ParseErrorList noTracking() {
        return new ParseErrorList(0, 0);
    }

    public static ParseErrorList tracking(int i) {
        return new ParseErrorList(16, i);
    }

    public boolean canAddError() {
        return size() < this.maxSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }
}

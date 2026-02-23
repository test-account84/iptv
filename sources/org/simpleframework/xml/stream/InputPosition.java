package org.simpleframework.xml.stream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class InputPosition implements Position {
    private EventNode source;

    public InputPosition(EventNode eventNode) {
        this.source = eventNode;
    }

    public int getLine() {
        return this.source.getLine();
    }

    public String toString() {
        return String.format("line %s", new Object[]{Integer.valueOf(getLine())});
    }
}

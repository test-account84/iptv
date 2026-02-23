package org.simpleframework.xml.stream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class InputStack extends Stack {
    public InputStack() {
        super(6);
    }

    public boolean isRelevant(InputNode inputNode) {
        return contains(inputNode) || isEmpty();
    }
}

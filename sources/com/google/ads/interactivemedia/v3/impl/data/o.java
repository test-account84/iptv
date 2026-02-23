package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class o extends ax {
    private int height;
    private int left;
    private byte set$0;
    private int top;
    private int width;

    public ay build() {
        if (this.set$0 == 15) {
            return new q(this.left, this.top, this.height, this.width, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.set$0 & 1) == 0) {
            sb.append(" left");
        }
        if ((this.set$0 & 2) == 0) {
            sb.append(" top");
        }
        if ((this.set$0 & 4) == 0) {
            sb.append(" height");
        }
        if ((this.set$0 & 8) == 0) {
            sb.append(" width");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public ax height(int i) {
        this.height = i;
        this.set$0 = (byte) (this.set$0 | 4);
        return this;
    }

    public ax left(int i) {
        this.left = i;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }

    public ax top(int i) {
        this.top = i;
        this.set$0 = (byte) (this.set$0 | 2);
        return this;
    }

    public ax width(int i) {
        this.width = i;
        this.set$0 = (byte) (this.set$0 | 8);
        return this;
    }
}

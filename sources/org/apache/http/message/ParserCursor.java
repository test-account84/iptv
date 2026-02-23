package org.apache.http.message;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        }
        if (i > i2) {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
        this.lowerBound = i;
        this.upperBound = i2;
        this.pos = i;
    }

    public boolean atEnd() {
        return this.pos >= this.upperBound;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getPos() {
        return this.pos;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public String toString() {
        return '[' + Integer.toString(this.lowerBound) + '>' + Integer.toString(this.pos) + '>' + Integer.toString(this.upperBound) + ']';
    }

    public void updatePos(int i) {
        if (i < this.lowerBound) {
            throw new IndexOutOfBoundsException("pos: " + i + " < lowerBound: " + this.lowerBound);
        }
        if (i <= this.upperBound) {
            this.pos = i;
            return;
        }
        throw new IndexOutOfBoundsException("pos: " + i + " > upperBound: " + this.upperBound);
    }
}

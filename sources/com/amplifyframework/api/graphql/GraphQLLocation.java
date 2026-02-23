package com.amplifyframework.api.graphql;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class GraphQLLocation {
    private int column;
    private int line;

    public GraphQLLocation(int i, int i2) {
        this.line = i;
        this.column = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GraphQLLocation.class != obj.getClass()) {
            return false;
        }
        GraphQLLocation graphQLLocation = (GraphQLLocation) obj;
        return this.line == graphQLLocation.line && this.column == graphQLLocation.column;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        return "GraphQLLocation{line='" + this.line + "', column='" + this.column + "'}";
    }
}

package com.amazonaws.mobileconnectors.appsync;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ClearCacheOptions {
    private boolean mutations;
    private boolean queries;
    private boolean subscriptions;

    public static class Builder {
        private boolean queries = false;
        private boolean mutations = false;
        private boolean subscriptions = false;

        public ClearCacheOptions build() {
            return new ClearCacheOptions(this.queries, this.mutations, this.subscriptions, null);
        }

        public Builder clearMutations() {
            this.mutations = true;
            return this;
        }

        public Builder clearQueries() {
            this.queries = true;
            return this;
        }

        public Builder clearSubscriptions() {
            this.subscriptions = true;
            return this;
        }
    }

    private ClearCacheOptions(boolean z, boolean z2, boolean z3) {
        this.queries = z;
        this.mutations = z2;
        this.subscriptions = z3;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean isMutations() {
        return this.mutations;
    }

    public boolean isQueries() {
        return this.queries;
    }

    public boolean isSubscriptions() {
        return this.subscriptions;
    }

    public /* synthetic */ ClearCacheOptions(boolean z, boolean z2, boolean z3, 1 r4) {
        this(z, z2, z3);
    }
}

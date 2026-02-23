package com.amazonaws.mobile.client;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SignInUIOptions {
    private final Builder builder;

    public static class Builder {
        private Integer backgroundColor;
        private String browserPackage;
        private boolean canCancel;
        private HostedUIOptions hostedUIOptions;
        private Integer logo;
        private Class nextActivityClass;

        public static /* synthetic */ String access$000(Builder builder) {
            return builder.browserPackage;
        }

        public static /* synthetic */ Integer access$100(Builder builder) {
            return builder.logo;
        }

        public static /* synthetic */ Integer access$200(Builder builder) {
            return builder.backgroundColor;
        }

        public static /* synthetic */ boolean access$300(Builder builder) {
            return builder.canCancel;
        }

        public static /* synthetic */ Class access$400(Builder builder) {
            return builder.nextActivityClass;
        }

        public static /* synthetic */ HostedUIOptions access$500(Builder builder) {
            return builder.hostedUIOptions;
        }

        public Builder backgroundColor(Integer num) {
            this.backgroundColor = num;
            return this;
        }

        public Builder browserPackage(String str) {
            this.browserPackage = str;
            return this;
        }

        public SignInUIOptions build() {
            return new SignInUIOptions(this);
        }

        public Builder canCancel(boolean z) {
            this.canCancel = z;
            return this;
        }

        public Builder hostedUIOptions(HostedUIOptions hostedUIOptions) {
            this.hostedUIOptions = hostedUIOptions;
            return this;
        }

        public Builder logo(Integer num) {
            this.logo = num;
            return this;
        }

        public Builder nextActivity(Class cls) {
            this.nextActivityClass = cls;
            return this;
        }
    }

    public SignInUIOptions(Builder builder) {
        this.builder = builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean canCancel() {
        return Builder.access$300(this.builder);
    }

    public Integer getBackgroundColor() {
        return Builder.access$200(this.builder);
    }

    public String getBrowserPackage() {
        return Builder.access$000(this.builder);
    }

    public HostedUIOptions getHostedUIOptions() {
        return Builder.access$500(this.builder);
    }

    public Integer getLogo() {
        return Builder.access$100(this.builder);
    }

    public Class nextActivity() {
        return Builder.access$400(this.builder);
    }
}

package com.amazonaws.mobileconnectors.s3.transferutility;

import O.c;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class UploadOptions {
    private final String bucket;
    private final CannedAccessControlList cannedAcl;
    private final TransferListener listener;
    private final ObjectMetadata metadata;

    public static final class Builder {
        private String bucket;
        private CannedAccessControlList cannedAcl;
        private TransferListener listener;
        private ObjectMetadata metadata;

        private Builder() {
        }

        public static /* synthetic */ String access$000(Builder builder) {
            return builder.bucket;
        }

        public static /* synthetic */ ObjectMetadata access$100(Builder builder) {
            return builder.metadata;
        }

        public static /* synthetic */ CannedAccessControlList access$200(Builder builder) {
            return builder.cannedAcl;
        }

        public static /* synthetic */ TransferListener access$300(Builder builder) {
            return builder.listener;
        }

        public Builder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public UploadOptions build() {
            return new UploadOptions(this);
        }

        public Builder cannedAcl(CannedAccessControlList cannedAccessControlList) {
            this.cannedAcl = cannedAccessControlList;
            return this;
        }

        public Builder objectMetadata(ObjectMetadata objectMetadata) {
            this.metadata = objectMetadata;
            return this;
        }

        public Builder transferListener(TransferListener transferListener) {
            this.listener = transferListener;
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }
    }

    public UploadOptions(Builder builder) {
        this.bucket = Builder.access$000(builder);
        this.metadata = Builder.access$100(builder);
        this.cannedAcl = Builder.access$200(builder);
        this.listener = Builder.access$300(builder);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UploadOptions.class != obj.getClass()) {
            return false;
        }
        UploadOptions uploadOptions = (UploadOptions) obj;
        return c.a(this.bucket, uploadOptions.bucket) && c.a(this.metadata, uploadOptions.metadata) && this.cannedAcl == uploadOptions.cannedAcl && c.a(this.listener, uploadOptions.listener);
    }

    public String getBucket() {
        return this.bucket;
    }

    public CannedAccessControlList getCannedAcl() {
        return this.cannedAcl;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public TransferListener getTransferListener() {
        return this.listener;
    }

    public int hashCode() {
        return c.b(this.bucket, this.metadata, this.cannedAcl, this.listener);
    }

    public String toString() {
        return "UploadOptions{bucket='" + this.bucket + "', metadata=" + this.metadata + ", cannedAcl=" + this.cannedAcl + ", listener=" + this.listener + '}';
    }
}

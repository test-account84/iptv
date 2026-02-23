package com.amplifyframework.storage.s3.options;

import O.c;
import com.amplifyframework.storage.options.StorageUploadInputStreamOptions;
import com.amplifyframework.storage.s3.ServerSideEncryption;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageUploadInputStreamOptions extends StorageUploadInputStreamOptions {
    private final ServerSideEncryption serverSideEncryption;

    public static final class Builder extends StorageUploadInputStreamOptions.Builder {
        private ServerSideEncryption serverSideEncryption;

        private Builder() {
            this.serverSideEncryption = ServerSideEncryption.NONE;
        }

        public static /* synthetic */ ServerSideEncryption access$000(Builder builder) {
            return builder.serverSideEncryption;
        }

        public Builder serverSideEncryption(ServerSideEncryption serverSideEncryption) {
            Objects.requireNonNull(serverSideEncryption);
            this.serverSideEncryption = serverSideEncryption;
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }

        public AWSS3StorageUploadInputStreamOptions build() {
            return new AWSS3StorageUploadInputStreamOptions(this, null);
        }
    }

    private AWSS3StorageUploadInputStreamOptions(Builder builder) {
        super(builder);
        this.serverSideEncryption = Builder.access$000(builder);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static AWSS3StorageUploadInputStreamOptions defaultInstance() {
        return builder().build();
    }

    public static Builder from(AWSS3StorageUploadInputStreamOptions aWSS3StorageUploadInputStreamOptions) {
        return (Builder) ((Builder) ((Builder) ((Builder) builder().accessLevel(aWSS3StorageUploadInputStreamOptions.getAccessLevel())).targetIdentityId(aWSS3StorageUploadInputStreamOptions.getTargetIdentityId())).contentType(aWSS3StorageUploadInputStreamOptions.getContentType())).serverSideEncryption(aWSS3StorageUploadInputStreamOptions.getServerSideEncryption()).metadata(aWSS3StorageUploadInputStreamOptions.getMetadata());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AWSS3StorageUploadInputStreamOptions)) {
            return false;
        }
        AWSS3StorageUploadInputStreamOptions aWSS3StorageUploadInputStreamOptions = (AWSS3StorageUploadInputStreamOptions) obj;
        return c.a(getAccessLevel(), aWSS3StorageUploadInputStreamOptions.getAccessLevel()) && c.a(getTargetIdentityId(), aWSS3StorageUploadInputStreamOptions.getTargetIdentityId()) && c.a(getContentType(), aWSS3StorageUploadInputStreamOptions.getContentType()) && c.a(getServerSideEncryption(), aWSS3StorageUploadInputStreamOptions.getServerSideEncryption()) && c.a(getMetadata(), aWSS3StorageUploadInputStreamOptions.getMetadata());
    }

    public ServerSideEncryption getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId(), getContentType(), getServerSideEncryption(), getMetadata());
    }

    public String toString() {
        return "AWSS3StorageUploadInputStreamOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + ", contentType=" + getContentType() + ", serverSideEncryption=" + getServerSideEncryption().getName() + ", metadata=" + getMetadata() + '}';
    }

    public /* synthetic */ AWSS3StorageUploadInputStreamOptions(Builder builder, 1 r2) {
        this(builder);
    }
}

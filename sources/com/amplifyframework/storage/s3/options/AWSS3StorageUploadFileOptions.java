package com.amplifyframework.storage.s3.options;

import O.c;
import com.amplifyframework.storage.options.StorageUploadFileOptions;
import com.amplifyframework.storage.s3.ServerSideEncryption;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageUploadFileOptions extends StorageUploadFileOptions {
    private final ServerSideEncryption serverSideEncryption;

    public static final class Builder extends StorageUploadFileOptions.Builder {
        private ServerSideEncryption serverSideEncryption;

        private Builder() {
            this.serverSideEncryption = ServerSideEncryption.NONE;
        }

        public ServerSideEncryption getServerSideEncryption() {
            return this.serverSideEncryption;
        }

        public Builder serverSideEncryption(ServerSideEncryption serverSideEncryption) {
            Objects.requireNonNull(serverSideEncryption);
            this.serverSideEncryption = serverSideEncryption;
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }

        public AWSS3StorageUploadFileOptions build() {
            return new AWSS3StorageUploadFileOptions(this, null);
        }
    }

    private AWSS3StorageUploadFileOptions(Builder builder) {
        super(builder);
        this.serverSideEncryption = builder.getServerSideEncryption();
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static AWSS3StorageUploadFileOptions defaultInstance() {
        return builder().build();
    }

    public static Builder from(AWSS3StorageUploadFileOptions aWSS3StorageUploadFileOptions) {
        return (Builder) ((Builder) ((Builder) ((Builder) builder().accessLevel(aWSS3StorageUploadFileOptions.getAccessLevel())).targetIdentityId(aWSS3StorageUploadFileOptions.getTargetIdentityId())).contentType(aWSS3StorageUploadFileOptions.getContentType())).serverSideEncryption(aWSS3StorageUploadFileOptions.getServerSideEncryption()).metadata(aWSS3StorageUploadFileOptions.getMetadata());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AWSS3StorageUploadFileOptions)) {
            return false;
        }
        AWSS3StorageUploadFileOptions aWSS3StorageUploadFileOptions = (AWSS3StorageUploadFileOptions) obj;
        return c.a(getAccessLevel(), aWSS3StorageUploadFileOptions.getAccessLevel()) && c.a(getTargetIdentityId(), aWSS3StorageUploadFileOptions.getTargetIdentityId()) && c.a(getContentType(), aWSS3StorageUploadFileOptions.getContentType()) && c.a(getServerSideEncryption(), aWSS3StorageUploadFileOptions.getServerSideEncryption()) && c.a(getMetadata(), aWSS3StorageUploadFileOptions.getMetadata());
    }

    public ServerSideEncryption getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public int hashCode() {
        return c.b(getAccessLevel(), getTargetIdentityId(), getContentType(), getServerSideEncryption(), getMetadata());
    }

    public String toString() {
        return "AWSS3StorageUploadFileOptions {accessLevel=" + getAccessLevel() + ", targetIdentityId=" + getTargetIdentityId() + ", contentType=" + getContentType() + ", serverSideEncryption=" + getServerSideEncryption().getName() + ", metadata=" + getMetadata() + '}';
    }

    public /* synthetic */ AWSS3StorageUploadFileOptions(Builder builder, 1 r2) {
        this(builder);
    }
}

package org.chromium.net;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class UploadDataProviders {

    public static class 1 implements FileChannelProvider {
        final /* synthetic */ File val$file;

        public 1(File file) {
            this.val$file = file;
        }

        public FileChannel getChannel() throws IOException {
            return new FileInputStream(this.val$file).getChannel();
        }
    }

    public static class 2 implements FileChannelProvider {
        final /* synthetic */ ParcelFileDescriptor val$fd;

        public 2(ParcelFileDescriptor parcelFileDescriptor) {
            this.val$fd = parcelFileDescriptor;
        }

        public FileChannel getChannel() throws IOException {
            if (this.val$fd.getStatSize() != -1) {
                return new ParcelFileDescriptor.AutoCloseInputStream(this.val$fd).getChannel();
            }
            this.val$fd.close();
            throw new IllegalArgumentException("Not a file: " + this.val$fd);
        }
    }

    public static final class ByteBufferUploadProvider extends UploadDataProvider {
        private final ByteBuffer mUploadBuffer;

        private ByteBufferUploadProvider(ByteBuffer byteBuffer) {
            this.mUploadBuffer = byteBuffer;
        }

        public long getLength() {
            return this.mUploadBuffer.limit();
        }

        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            if (byteBuffer.remaining() >= this.mUploadBuffer.remaining()) {
                byteBuffer.put(this.mUploadBuffer);
            } else {
                int limit = this.mUploadBuffer.limit();
                ByteBuffer byteBuffer2 = this.mUploadBuffer;
                byteBuffer2.limit(byteBuffer2.position() + byteBuffer.remaining());
                byteBuffer.put(this.mUploadBuffer);
                this.mUploadBuffer.limit(limit);
            }
            uploadDataSink.onReadSucceeded(false);
        }

        public void rewind(UploadDataSink uploadDataSink) {
            this.mUploadBuffer.position(0);
            uploadDataSink.onRewindSucceeded();
        }

        public /* synthetic */ ByteBufferUploadProvider(ByteBuffer byteBuffer, 1 r2) {
            this(byteBuffer);
        }
    }

    public interface FileChannelProvider {
        FileChannel getChannel() throws IOException;
    }

    public static final class FileUploadProvider extends UploadDataProvider {
        private volatile FileChannel mChannel;
        private final Object mLock;
        private final FileChannelProvider mProvider;

        private FileUploadProvider(FileChannelProvider fileChannelProvider) {
            this.mLock = new Object();
            this.mProvider = fileChannelProvider;
        }

        private FileChannel getChannel() throws IOException {
            if (this.mChannel == null) {
                synchronized (this.mLock) {
                    try {
                        if (this.mChannel == null) {
                            this.mChannel = this.mProvider.getChannel();
                        }
                    } finally {
                    }
                }
            }
            return this.mChannel;
        }

        public void close() throws IOException {
            FileChannel fileChannel = this.mChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
        }

        public long getLength() throws IOException {
            return getChannel().size();
        }

        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            FileChannel channel = getChannel();
            int i = 0;
            while (i == 0) {
                int read = channel.read(byteBuffer);
                if (read == -1) {
                    break;
                } else {
                    i += read;
                }
            }
            uploadDataSink.onReadSucceeded(false);
        }

        public void rewind(UploadDataSink uploadDataSink) throws IOException {
            getChannel().position(0L);
            uploadDataSink.onRewindSucceeded();
        }

        public /* synthetic */ FileUploadProvider(FileChannelProvider fileChannelProvider, 1 r2) {
            this(fileChannelProvider);
        }
    }

    private UploadDataProviders() {
    }

    public static UploadDataProvider create(ParcelFileDescriptor parcelFileDescriptor) {
        return new FileUploadProvider(new 2(parcelFileDescriptor), null);
    }

    public static UploadDataProvider create(File file) {
        return new FileUploadProvider(new 1(file), null);
    }

    public static UploadDataProvider create(ByteBuffer byteBuffer) {
        return new ByteBufferUploadProvider(byteBuffer.slice(), null);
    }

    public static UploadDataProvider create(byte[] bArr) {
        return create(bArr, 0, bArr.length);
    }

    public static UploadDataProvider create(byte[] bArr, int i, int i2) {
        return new ByteBufferUploadProvider(ByteBuffer.wrap(bArr, i, i2).slice(), null);
    }
}

package b4;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import d4.k0;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j extends g {
    public final ContentResolver e;
    public Uri f;
    public AssetFileDescriptor g;
    public FileInputStream h;
    public long i;
    public boolean j;

    public static class a extends p {
        public a(IOException iOException, int i) {
            super((Throwable) iOException, i);
        }
    }

    public j(Context context) {
        super(false);
        this.e = context.getContentResolver();
    }

    public long a(s sVar) {
        AssetFileDescriptor openAssetFileDescriptor;
        try {
            Uri normalizeScheme = sVar.a.normalizeScheme();
            this.f = normalizeScheme;
            v(sVar);
            if ("content".equals(normalizeScheme.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                openAssetFileDescriptor = this.e.openTypedAssetFileDescriptor(normalizeScheme, "*/*", bundle);
            } else {
                openAssetFileDescriptor = this.e.openAssetFileDescriptor(normalizeScheme, "r");
            }
            this.g = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                throw new a(new IOException("Could not open file descriptor for: " + normalizeScheme), 2000);
            }
            long length = openAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
            this.h = fileInputStream;
            if (length != -1 && sVar.g > length) {
                throw new a(null, 2008);
            }
            long startOffset = openAssetFileDescriptor.getStartOffset();
            long skip = fileInputStream.skip(sVar.g + startOffset) - startOffset;
            if (skip != sVar.g) {
                throw new a(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.i = -1L;
                } else {
                    long position = size - channel.position();
                    this.i = position;
                    if (position < 0) {
                        throw new a(null, 2008);
                    }
                }
            } else {
                long j = length - skip;
                this.i = j;
                if (j < 0) {
                    throw new a(null, 2008);
                }
            }
            long j2 = sVar.h;
            if (j2 != -1) {
                long j3 = this.i;
                if (j3 != -1) {
                    j2 = Math.min(j3, j2);
                }
                this.i = j2;
            }
            this.j = true;
            w(sVar);
            long j4 = sVar.h;
            return j4 != -1 ? j4 : this.i;
        } catch (a e) {
            throw e;
        } catch (IOException e2) {
            throw new a(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    public void close() {
        this.f = null;
        try {
            try {
                FileInputStream fileInputStream = this.h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new a(e, 2000);
                    }
                } finally {
                    this.g = null;
                    if (this.j) {
                        this.j = false;
                        u();
                    }
                }
            } catch (IOException e2) {
                throw new a(e2, 2000);
            }
        } catch (Throwable th) {
            this.h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.g = null;
                    if (this.j) {
                        this.j = false;
                        u();
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new a(e3, 2000);
                }
            } finally {
                this.g = null;
                if (this.j) {
                    this.j = false;
                    u();
                }
            }
        }
    }

    public Uri getUri() {
        return this.f;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.i;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new a(e, 2000);
            }
        }
        int read = ((FileInputStream) k0.j(this.h)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.i;
        if (j2 != -1) {
            this.i = j2 - read;
        }
        t(read);
        return read;
    }
}

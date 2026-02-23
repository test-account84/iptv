package com.google.ads.interactivemedia.v3.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class cv extends ct {
    private final ContentResolver a;
    private Uri b;
    private AssetFileDescriptor c;
    private FileInputStream d;
    private long e;
    private boolean f;

    public cv(Context context) {
        super(false);
        this.a = context.getContentResolver();
    }

    public final int a(byte[] bArr, int i, int i2) throws cu {
        if (i2 == 0) {
            return 0;
        }
        long j = this.e;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new cu(e, 2000);
            }
        }
        FileInputStream fileInputStream = this.d;
        int i3 = cq.a;
        int read = fileInputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.e;
        if (j2 != -1) {
            this.e = j2 - read;
        }
        g(read);
        return read;
    }

    public final long b(dc dcVar) throws cu {
        int i;
        AssetFileDescriptor openAssetFileDescriptor;
        long j;
        try {
            try {
                Uri uri = dcVar.a;
                this.b = uri;
                i(dcVar);
                if ("content".equals(dcVar.a.getScheme())) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                    openAssetFileDescriptor = this.a.openTypedAssetFileDescriptor(uri, "*/*", bundle);
                } else {
                    openAssetFileDescriptor = this.a.openAssetFileDescriptor(uri, "r");
                }
                this.c = openAssetFileDescriptor;
                if (openAssetFileDescriptor == null) {
                    i = 2000;
                    try {
                        throw new cu(new IOException("Could not open file descriptor for: " + String.valueOf(uri)), 2000);
                    } catch (IOException e) {
                        e = e;
                        if (true == (e instanceof FileNotFoundException)) {
                            i = 2005;
                        }
                        throw new cu(e, i);
                    }
                }
                long length = openAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.d = fileInputStream;
                if (length != -1 && dcVar.e > length) {
                    throw new cu(null, 2008);
                }
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(dcVar.e + startOffset) - startOffset;
                if (skip != dcVar.e) {
                    throw new cu(null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.e = -1L;
                        j = -1;
                    } else {
                        j = size - channel.position();
                        this.e = j;
                        if (j < 0) {
                            throw new cu(null, 2008);
                        }
                    }
                } else {
                    j = length - skip;
                    this.e = j;
                    if (j < 0) {
                        throw new cu(null, 2008);
                    }
                }
                long j2 = dcVar.f;
                if (j2 != -1) {
                    if (j != -1) {
                        j2 = Math.min(j, j2);
                    }
                    this.e = j2;
                }
                this.f = true;
                j(dcVar);
                long j3 = dcVar.f;
                return j3 != -1 ? j3 : this.e;
            } catch (cu e2) {
                throw e2;
            }
        } catch (IOException e3) {
            e = e3;
            i = 2000;
        }
    }

    public final Uri c() {
        return this.b;
    }

    public final void d() throws cu {
        this.b = null;
        try {
            try {
                FileInputStream fileInputStream = this.d;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.d = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.c;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new cu(e, 2000);
                    }
                } finally {
                    this.c = null;
                    if (this.f) {
                        this.f = false;
                        h();
                    }
                }
            } catch (IOException e2) {
                throw new cu(e2, 2000);
            }
        } catch (Throwable th) {
            this.d = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.c;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.c = null;
                    if (this.f) {
                        this.f = false;
                        h();
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new cu(e3, 2000);
                }
            } catch (Throwable th2) {
                this.c = null;
                if (this.f) {
                    this.f = false;
                    h();
                }
                throw th2;
            }
        }
    }
}

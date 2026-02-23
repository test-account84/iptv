package org.apache.http.auth;

import org.apache.http.ProtocolException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class MalformedChallengeException extends ProtocolException {
    private static final long serialVersionUID = 814586927989932284L;

    public MalformedChallengeException() {
    }

    public MalformedChallengeException(String str) {
        super(str);
    }

    public MalformedChallengeException(String str, Throwable th) {
        super(str, th);
    }
}

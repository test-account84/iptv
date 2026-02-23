package com.amazonaws.mobile.config;

import android.content.Context;
import com.amazonaws.ClientConfiguration;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AWSConfigurable {
    AWSConfigurable initialize(Context context) throws Exception;

    AWSConfigurable initialize(Context context, AWSConfiguration aWSConfiguration) throws Exception;

    AWSConfigurable initialize(Context context, AWSConfiguration aWSConfiguration, ClientConfiguration clientConfiguration) throws Exception;
}

package com.amplifyframework.predictions;

import android.graphics.Bitmap;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.predictions.models.IdentifyAction;
import com.amplifyframework.predictions.models.LanguageType;
import com.amplifyframework.predictions.operation.IdentifyOperation;
import com.amplifyframework.predictions.operation.InterpretOperation;
import com.amplifyframework.predictions.operation.TextToSpeechOperation;
import com.amplifyframework.predictions.operation.TranslateTextOperation;
import com.amplifyframework.predictions.options.IdentifyOptions;
import com.amplifyframework.predictions.options.InterpretOptions;
import com.amplifyframework.predictions.options.TextToSpeechOptions;
import com.amplifyframework.predictions.options.TranslateTextOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface PredictionsCategoryBehavior {
    TextToSpeechOperation convertTextToSpeech(String str, Consumer consumer, Consumer consumer2);

    TextToSpeechOperation convertTextToSpeech(String str, TextToSpeechOptions textToSpeechOptions, Consumer consumer, Consumer consumer2);

    IdentifyOperation identify(IdentifyAction identifyAction, Bitmap bitmap, Consumer consumer, Consumer consumer2);

    IdentifyOperation identify(IdentifyAction identifyAction, Bitmap bitmap, IdentifyOptions identifyOptions, Consumer consumer, Consumer consumer2);

    InterpretOperation interpret(String str, Consumer consumer, Consumer consumer2);

    InterpretOperation interpret(String str, InterpretOptions interpretOptions, Consumer consumer, Consumer consumer2);

    TranslateTextOperation translateText(String str, Consumer consumer, Consumer consumer2);

    TranslateTextOperation translateText(String str, LanguageType languageType, LanguageType languageType2, Consumer consumer, Consumer consumer2);

    TranslateTextOperation translateText(String str, LanguageType languageType, LanguageType languageType2, TranslateTextOptions translateTextOptions, Consumer consumer, Consumer consumer2);

    TranslateTextOperation translateText(String str, TranslateTextOptions translateTextOptions, Consumer consumer, Consumer consumer2);
}

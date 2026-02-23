package com.amplifyframework.predictions;

import android.graphics.Bitmap;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
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
public final class PredictionsCategory extends Category implements PredictionsCategoryBehavior {
    public TextToSpeechOperation convertTextToSpeech(String str, Consumer consumer, Consumer consumer2) {
        return ((PredictionsPlugin) getSelectedPlugin()).convertTextToSpeech(str, consumer, consumer2);
    }

    public CategoryType getCategoryType() {
        return CategoryType.PREDICTIONS;
    }

    public IdentifyOperation identify(IdentifyAction identifyAction, Bitmap bitmap, Consumer consumer, Consumer consumer2) {
        return ((PredictionsPlugin) getSelectedPlugin()).identify(identifyAction, bitmap, consumer, consumer2);
    }

    public InterpretOperation interpret(String str, Consumer consumer, Consumer consumer2) {
        return ((PredictionsPlugin) getSelectedPlugin()).interpret(str, consumer, consumer2);
    }

    public TranslateTextOperation translateText(String str, Consumer consumer, Consumer consumer2) {
        return ((PredictionsPlugin) getSelectedPlugin()).translateText(str, consumer, consumer2);
    }

    public TextToSpeechOperation convertTextToSpeech(String str, TextToSpeechOptions textToSpeechOptions, Consumer consumer, Consumer consumer2) {
        return ((PredictionsPlugin) getSelectedPlugin()).convertTextToSpeech(str, textToSpeechOptions, consumer, consumer2);
    }

    public IdentifyOperation identify(IdentifyAction identifyAction, Bitmap bitmap, IdentifyOptions identifyOptions, Consumer consumer, Consumer consumer2) {
        return ((PredictionsPlugin) getSelectedPlugin()).identify(identifyAction, bitmap, identifyOptions, consumer, consumer2);
    }

    public InterpretOperation interpret(String str, InterpretOptions interpretOptions, Consumer consumer, Consumer consumer2) {
        return ((PredictionsPlugin) getSelectedPlugin()).interpret(str, interpretOptions, consumer, consumer2);
    }

    public TranslateTextOperation translateText(String str, LanguageType languageType, LanguageType languageType2, Consumer consumer, Consumer consumer2) {
        return ((PredictionsPlugin) getSelectedPlugin()).translateText(str, languageType, languageType2, consumer, consumer2);
    }

    public TranslateTextOperation translateText(String str, LanguageType languageType, LanguageType languageType2, TranslateTextOptions translateTextOptions, Consumer consumer, Consumer consumer2) {
        return ((PredictionsPlugin) getSelectedPlugin()).translateText(str, languageType, languageType2, translateTextOptions, consumer, consumer2);
    }

    public TranslateTextOperation translateText(String str, TranslateTextOptions translateTextOptions, Consumer consumer, Consumer consumer2) {
        return ((PredictionsPlugin) getSelectedPlugin()).translateText(str, translateTextOptions, consumer, consumer2);
    }
}

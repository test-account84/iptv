package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class MediaPlayerProxy implements IMediaPlayer {
    protected final IMediaPlayer mBackEndMediaPlayer;

    public class 1 implements IMediaPlayer.OnPreparedListener {
        final /* synthetic */ IMediaPlayer.OnPreparedListener val$finalListener;

        public 1(IMediaPlayer.OnPreparedListener onPreparedListener) {
            this.val$finalListener = onPreparedListener;
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
            this.val$finalListener.onPrepared(MediaPlayerProxy.this);
        }
    }

    public class 2 implements IMediaPlayer.OnCompletionListener {
        final /* synthetic */ IMediaPlayer.OnCompletionListener val$finalListener;

        public 2(IMediaPlayer.OnCompletionListener onCompletionListener) {
            this.val$finalListener = onCompletionListener;
        }

        public void onCompletion(IMediaPlayer iMediaPlayer) {
            this.val$finalListener.onCompletion(MediaPlayerProxy.this);
        }
    }

    public class 3 implements IMediaPlayer.OnBufferingUpdateListener {
        final /* synthetic */ IMediaPlayer.OnBufferingUpdateListener val$finalListener;

        public 3(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
            this.val$finalListener = onBufferingUpdateListener;
        }

        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            this.val$finalListener.onBufferingUpdate(MediaPlayerProxy.this, i);
        }
    }

    public class 4 implements IMediaPlayer.OnSeekCompleteListener {
        final /* synthetic */ IMediaPlayer.OnSeekCompleteListener val$finalListener;

        public 4(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
            this.val$finalListener = onSeekCompleteListener;
        }

        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            this.val$finalListener.onSeekComplete(MediaPlayerProxy.this);
        }
    }

    public class 5 implements IMediaPlayer.OnVideoSizeChangedListener {
        final /* synthetic */ IMediaPlayer.OnVideoSizeChangedListener val$finalListener;

        public 5(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
            this.val$finalListener = onVideoSizeChangedListener;
        }

        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            this.val$finalListener.onVideoSizeChanged(MediaPlayerProxy.this, i, i2, i3, i4);
        }
    }

    public class 6 implements IMediaPlayer.OnErrorListener {
        final /* synthetic */ IMediaPlayer.OnErrorListener val$finalListener;

        public 6(IMediaPlayer.OnErrorListener onErrorListener) {
            this.val$finalListener = onErrorListener;
        }

        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            return this.val$finalListener.onError(MediaPlayerProxy.this, i, i2);
        }
    }

    public class 7 implements IMediaPlayer.OnInfoListener {
        final /* synthetic */ IMediaPlayer.OnInfoListener val$finalListener;

        public 7(IMediaPlayer.OnInfoListener onInfoListener) {
            this.val$finalListener = onInfoListener;
        }

        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            return this.val$finalListener.onInfo(MediaPlayerProxy.this, i, i2);
        }
    }

    public class 8 implements IMediaPlayer.OnTimedTextListener {
        final /* synthetic */ IMediaPlayer.OnTimedTextListener val$finalListener;

        public 8(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
            this.val$finalListener = onTimedTextListener;
        }

        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            this.val$finalListener.onTimedText(MediaPlayerProxy.this, ijkTimedText);
        }
    }

    public MediaPlayerProxy(IMediaPlayer iMediaPlayer) {
        this.mBackEndMediaPlayer = iMediaPlayer;
    }

    public int getAudioSessionId() {
        return this.mBackEndMediaPlayer.getAudioSessionId();
    }

    public long getCurrentPosition() {
        return this.mBackEndMediaPlayer.getCurrentPosition();
    }

    public String getDataSource() {
        return this.mBackEndMediaPlayer.getDataSource();
    }

    public long getDuration() {
        return this.mBackEndMediaPlayer.getDuration();
    }

    public IMediaPlayer getInternalMediaPlayer() {
        return this.mBackEndMediaPlayer;
    }

    public MediaInfo getMediaInfo() {
        return this.mBackEndMediaPlayer.getMediaInfo();
    }

    public ITrackInfo[] getTrackInfo() {
        return this.mBackEndMediaPlayer.getTrackInfo();
    }

    public int getVideoHeight() {
        return this.mBackEndMediaPlayer.getVideoHeight();
    }

    public int getVideoSarDen() {
        return this.mBackEndMediaPlayer.getVideoSarDen();
    }

    public int getVideoSarNum() {
        return this.mBackEndMediaPlayer.getVideoSarNum();
    }

    public int getVideoWidth() {
        return this.mBackEndMediaPlayer.getVideoWidth();
    }

    public boolean isLooping() {
        return this.mBackEndMediaPlayer.isLooping();
    }

    public boolean isPlayable() {
        return false;
    }

    public boolean isPlaying() {
        return this.mBackEndMediaPlayer.isPlaying();
    }

    public void pause() throws IllegalStateException {
        this.mBackEndMediaPlayer.pause();
    }

    public void prepareAsync() throws IllegalStateException {
        this.mBackEndMediaPlayer.prepareAsync();
    }

    public void release() {
        this.mBackEndMediaPlayer.release();
    }

    public void reset() {
        this.mBackEndMediaPlayer.reset();
    }

    public void seekTo(long j) throws IllegalStateException {
        this.mBackEndMediaPlayer.seekTo(j);
    }

    public void setAudioStreamType(int i) {
        this.mBackEndMediaPlayer.setAudioStreamType(i);
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(context, uri);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mBackEndMediaPlayer.setDisplay(surfaceHolder);
    }

    public void setKeepInBackground(boolean z) {
        this.mBackEndMediaPlayer.setKeepInBackground(z);
    }

    public void setLogEnabled(boolean z) {
    }

    public void setLooping(boolean z) {
        this.mBackEndMediaPlayer.setLooping(z);
    }

    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener != null) {
            this.mBackEndMediaPlayer.setOnBufferingUpdateListener(new 3(onBufferingUpdateListener));
        } else {
            this.mBackEndMediaPlayer.setOnBufferingUpdateListener(null);
        }
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            this.mBackEndMediaPlayer.setOnCompletionListener(new 2(onCompletionListener));
        } else {
            this.mBackEndMediaPlayer.setOnCompletionListener(null);
        }
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener != null) {
            this.mBackEndMediaPlayer.setOnErrorListener(new 6(onErrorListener));
        } else {
            this.mBackEndMediaPlayer.setOnErrorListener(null);
        }
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener != null) {
            this.mBackEndMediaPlayer.setOnInfoListener(new 7(onInfoListener));
        } else {
            this.mBackEndMediaPlayer.setOnInfoListener(null);
        }
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener != null) {
            this.mBackEndMediaPlayer.setOnPreparedListener(new 1(onPreparedListener));
        } else {
            this.mBackEndMediaPlayer.setOnPreparedListener(null);
        }
    }

    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener != null) {
            this.mBackEndMediaPlayer.setOnSeekCompleteListener(new 4(onSeekCompleteListener));
        } else {
            this.mBackEndMediaPlayer.setOnSeekCompleteListener(null);
        }
    }

    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener != null) {
            this.mBackEndMediaPlayer.setOnTimedTextListener(new 8(onTimedTextListener));
        } else {
            this.mBackEndMediaPlayer.setOnTimedTextListener(null);
        }
    }

    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener != null) {
            this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(new 5(onVideoSizeChangedListener));
        } else {
            this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(null);
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        this.mBackEndMediaPlayer.setScreenOnWhilePlaying(z);
    }

    @TargetApi(14)
    public void setSurface(Surface surface) {
        this.mBackEndMediaPlayer.setSurface(surface);
    }

    public void setVolume(float f, float f2) {
        this.mBackEndMediaPlayer.setVolume(f, f2);
    }

    public void setWakeMode(Context context, int i) {
        this.mBackEndMediaPlayer.setWakeMode(context, i);
    }

    public void start() throws IllegalStateException {
        this.mBackEndMediaPlayer.start();
    }

    public void stop() throws IllegalStateException {
        this.mBackEndMediaPlayer.stop();
    }

    @TargetApi(14)
    public void setDataSource(Context context, Uri uri, Map map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(context, uri, map);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(fileDescriptor);
    }

    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(str);
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        this.mBackEndMediaPlayer.setDataSource(iMediaDataSource);
    }
}

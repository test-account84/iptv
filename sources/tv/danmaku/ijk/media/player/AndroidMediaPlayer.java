package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import tv.danmaku.ijk.media.player.misc.AndroidTrackInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AndroidMediaPlayer extends AbstractMediaPlayer {
    private static MediaInfo sMediaInfo;
    private String mDataSource;
    private final Object mInitLock;
    private final AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
    private final MediaPlayer mInternalMediaPlayer;
    private boolean mIsReleased;
    private MediaDataSource mMediaDataSource;

    public class AndroidMediaPlayerListenerHolder implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnTimedTextListener {
        public final WeakReference mWeakMediaPlayer;

        public AndroidMediaPlayerListenerHolder(AndroidMediaPlayer androidMediaPlayer) {
            this.mWeakMediaPlayer = new WeakReference(androidMediaPlayer);
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) == null) {
                return;
            }
            AndroidMediaPlayer.this.notifyOnBufferingUpdate(i);
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) == null) {
                return;
            }
            AndroidMediaPlayer.this.notifyOnCompletion();
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return ((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) != null && AndroidMediaPlayer.this.notifyOnError(i, i2);
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            return ((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) != null && AndroidMediaPlayer.this.notifyOnInfo(i, i2);
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) == null) {
                return;
            }
            AndroidMediaPlayer.this.notifyOnPrepared();
        }

        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) == null) {
                return;
            }
            AndroidMediaPlayer.this.notifyOnSeekComplete();
        }

        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) == null) {
                return;
            }
            AndroidMediaPlayer.this.notifyOnTimedText(timedText != null ? new IjkTimedText(timedText.getBounds(), timedText.getText()) : null);
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (((AndroidMediaPlayer) this.mWeakMediaPlayer.get()) == null) {
                return;
            }
            AndroidMediaPlayer.this.notifyOnVideoSizeChanged(i, i2, 1, 1);
        }
    }

    @TargetApi(23)
    public static class MediaDataSourceProxy extends MediaDataSource {
        private final IMediaDataSource mMediaDataSource;

        public MediaDataSourceProxy(IMediaDataSource iMediaDataSource) {
            this.mMediaDataSource = iMediaDataSource;
        }

        public void close() throws IOException {
            this.mMediaDataSource.close();
        }

        public long getSize() throws IOException {
            return this.mMediaDataSource.getSize();
        }

        public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
            return this.mMediaDataSource.readAt(j, bArr, i, i2);
        }
    }

    public AndroidMediaPlayer() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.mInitLock = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.mInternalMediaPlayer = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = new AndroidMediaPlayerListenerHolder(this);
        attachInternalListeners();
    }

    private void attachInternalListeners() {
        this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnTimedTextListener(this.mInternalListenerAdapter);
    }

    private void releaseMediaDataSource() {
        MediaDataSource mediaDataSource = this.mMediaDataSource;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.mMediaDataSource = null;
        }
    }

    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    public long getCurrentPosition() {
        try {
            return this.mInternalMediaPlayer.getCurrentPosition();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return 0L;
        }
    }

    public String getDataSource() {
        return this.mDataSource;
    }

    public long getDuration() {
        try {
            return this.mInternalMediaPlayer.getDuration();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return 0L;
        }
    }

    public MediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    public MediaInfo getMediaInfo() {
        if (sMediaInfo == null) {
            MediaInfo mediaInfo = new MediaInfo();
            mediaInfo.mVideoDecoder = "android";
            mediaInfo.mVideoDecoderImpl = "HW";
            mediaInfo.mAudioDecoder = "android";
            mediaInfo.mAudioDecoderImpl = "HW";
            sMediaInfo = mediaInfo;
        }
        return sMediaInfo;
    }

    public ITrackInfo[] getTrackInfo() {
        return AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer);
    }

    public int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    public int getVideoSarDen() {
        return 1;
    }

    public int getVideoSarNum() {
        return 1;
    }

    public int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    public boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    public boolean isPlayable() {
        return true;
    }

    public boolean isPlaying() {
        try {
            return this.mInternalMediaPlayer.isPlaying();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return false;
        }
    }

    public void pause() throws IllegalStateException {
        this.mInternalMediaPlayer.pause();
    }

    public void prepareAsync() throws IllegalStateException {
        this.mInternalMediaPlayer.prepareAsync();
    }

    public void release() {
        this.mIsReleased = true;
        this.mInternalMediaPlayer.release();
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    public void reset() {
        try {
            this.mInternalMediaPlayer.reset();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
        }
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    public void seekTo(long j) throws IllegalStateException {
        this.mInternalMediaPlayer.seekTo((int) j);
    }

    public void setAudioStreamType(int i) {
        this.mInternalMediaPlayer.setAudioStreamType(i);
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.mInitLock) {
            try {
                if (!this.mIsReleased) {
                    this.mInternalMediaPlayer.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setKeepInBackground(boolean z) {
    }

    public void setLogEnabled(boolean z) {
    }

    public void setLooping(boolean z) {
        this.mInternalMediaPlayer.setLooping(z);
    }

    public void setScreenOnWhilePlaying(boolean z) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(z);
    }

    @TargetApi(14)
    public void setSurface(Surface surface) {
        this.mInternalMediaPlayer.setSurface(surface);
    }

    public void setVolume(float f, float f2) {
        this.mInternalMediaPlayer.setVolume(f, f2);
    }

    public void setWakeMode(Context context, int i) {
        this.mInternalMediaPlayer.setWakeMode(context, i);
    }

    public void start() throws IllegalStateException {
        this.mInternalMediaPlayer.start();
    }

    public void stop() throws IllegalStateException {
        this.mInternalMediaPlayer.stop();
    }

    @TargetApi(14)
    public void setDataSource(Context context, Uri uri, Map map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri, map);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mDataSource = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.mInternalMediaPlayer.setDataSource(str);
        } else {
            this.mInternalMediaPlayer.setDataSource(parse.getPath());
        }
    }

    @TargetApi(23)
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        releaseMediaDataSource();
        MediaDataSourceProxy mediaDataSourceProxy = new MediaDataSourceProxy(iMediaDataSource);
        this.mMediaDataSource = mediaDataSourceProxy;
        a.a(this.mInternalMediaPlayer, mediaDataSourceProxy);
    }
}

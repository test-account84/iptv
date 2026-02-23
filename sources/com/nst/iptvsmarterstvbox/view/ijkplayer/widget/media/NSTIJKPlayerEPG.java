package com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.app.a;
import com.nst.iptvsmarterstvbox.model.callback.VodInfoCallback;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerEPGActivity;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.misc.IjkMediaFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerEPG extends FrameLayout implements MediaController.MediaPlayerControl, z7.n {
    public static final int[] W1 = {0, 1, 2, 3, 4, 5};
    public boolean A;
    public SharedPreferences A0;
    public String A1;
    public boolean B;
    public SharedPreferences B0;
    public Handler B1;
    public int C;
    public SharedPreferences C0;
    public Context C1;
    public Handler D;
    public SharedPreferences D0;
    public LiveStreamDBHandler D1;
    public Handler E;
    public SharedPreferences.Editor E0;
    public String E1;
    public int F;
    public SharedPreferences.Editor F0;
    public final SeekBar.OnSeekBarChangeListener F1;
    public boolean G;
    public SharedPreferences.Editor G0;
    public final SeekBar.OnSeekBarChangeListener G1;
    public int H;
    public boolean H0;
    public IMediaPlayer.OnVideoSizeChangedListener H1;
    public int I;
    public boolean I0;
    public IMediaPlayer.OnPreparedListener I1;
    public boolean J;
    public SharedPreferences J0;
    public IMediaPlayer.OnCompletionListener J1;
    public SharedPreferences K;
    public n7.l K0;
    public IMediaPlayer.OnInfoListener K1;
    public SharedPreferences.Editor L;
    public boolean L0;
    public IMediaPlayer.OnErrorListener L1;
    public SharedPreferences M;
    public TextView M0;
    public IMediaPlayer.OnBufferingUpdateListener M1;
    public Context N;
    public TextView N0;
    public IMediaPlayer.OnSeekCompleteListener N1;
    public u7.a O;
    public TextView O0;
    public IMediaPlayer.OnTimedTextListener O1;
    public com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a P;
    public RadioGroup P0;
    public a.a P1;
    public int Q;
    public RadioGroup Q0;
    public int Q1;
    public int R;
    public RadioGroup R0;
    public int R1;
    public long S;
    public SharedPreferences.Editor S0;
    public List S1;
    public long T;
    public TextView T0;
    public int T1;
    public long U;
    public FrameLayout U0;
    public int U1;
    public long V;
    public androidx.appcompat.app.a V0;
    public boolean V1;
    public TextView W;
    public SeekBar W0;
    public SeekBar X0;
    public LinearLayout Y0;
    public Handler Z0;
    public String a;
    public Runnable a1;
    public Handler b1;
    public Uri c;
    public Runnable c1;
    public String d;
    public Animation d1;
    public Map e;
    public String e0;
    public Animation e1;
    public int f;
    public Activity f0;
    public ImageView f1;
    public int g;
    public NSTIJKPlayerEPG g0;
    public ImageView g1;
    public int h;
    public AudioManager h0;
    public LinearLayout h1;
    public a.b i;
    public int i0;
    public LinearLayout i1;
    public IMediaPlayer j;
    public float j0;
    public int j1;
    public int k;
    public GestureDetector k0;
    public TextView k1;
    public int l;
    public int l0;
    public TextView l1;
    public int m;
    public View m0;
    public LinearLayout m1;
    public int n;
    public z n0;
    public Animation n1;
    public int o;
    public Button o0;
    public Animation o1;
    public IMediaPlayer.OnCompletionListener p;
    public Boolean p0;
    public RelativeLayout p1;
    public IMediaPlayer.OnPreparedListener q;
    public Boolean q0;
    public Animation q1;
    public int r;
    public Boolean r0;
    public LinearLayout r1;
    public IMediaPlayer.OnErrorListener s;
    public Boolean s0;
    public Animation s1;
    public IMediaPlayer.OnInfoListener t;
    public Boolean t0;
    public Animation t1;
    public int u;
    public Boolean u0;
    public Animation u1;
    public boolean v;
    public boolean v0;
    public SharedPreferences v1;
    public boolean w;
    public StringBuilder w0;
    public RelativeLayout w1;
    public boolean x;
    public Formatter x0;
    public boolean x1;
    public int y;
    public boolean y0;
    public boolean y1;
    public long z;
    public boolean z0;
    public String z1;

    public class a implements IMediaPlayer.OnInfoListener {
        public a() {
        }

        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            String X;
            String str;
            if (NSTIJKPlayerEPG.W(NSTIJKPlayerEPG.this) != null) {
                NSTIJKPlayerEPG.W(NSTIJKPlayerEPG.this).onInfo(iMediaPlayer, i, i2);
            }
            if (i == 3) {
                NSTIJKPlayerEPG.Y(NSTIJKPlayerEPG.this, 2);
                X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                str = "MEDIA_INFO_VIDEO_RENDERING_START:";
            } else if (i == 10005) {
                NSTIJKPlayerEPG.Y(NSTIJKPlayerEPG.this, 1);
                X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                str = "MEDIA_INFO_OPEN_INPUT:";
            } else if (i == 901) {
                X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                str = "MEDIA_INFO_UNSUPPORTED_SUBTITLE:";
            } else {
                if (i != 902) {
                    if (i == 10001) {
                        NSTIJKPlayerEPG.Z(NSTIJKPlayerEPG.this, i2);
                        Log.d(NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this), "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar = NSTIJKPlayerEPG.this.P;
                        if (aVar != null) {
                            aVar.setVideoRotation(i2);
                        }
                    } else if (i != 10002) {
                        switch (i) {
                            case 700:
                                X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                                str = "MEDIA_INFO_VIDEO_TRACK_LAGGING:";
                                break;
                            case 701:
                                NSTIJKPlayerEPG.Y(NSTIJKPlayerEPG.this, 1);
                                X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                                str = "MEDIA_INFO_BUFFERING_START:";
                                break;
                            case 702:
                                NSTIJKPlayerEPG.Y(NSTIJKPlayerEPG.this, 6);
                                X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                                str = "MEDIA_INFO_BUFFERING_END:";
                                break;
                            case 703:
                                X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                                str = "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2;
                                break;
                            default:
                                switch (i) {
                                    case 800:
                                        X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                                        str = "MEDIA_INFO_BAD_INTERLEAVING:";
                                        break;
                                    case 801:
                                        X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                                        str = "MEDIA_INFO_NOT_SEEKABLE:";
                                        break;
                                    case 802:
                                        X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                                        str = "MEDIA_INFO_METADATA_UPDATE:";
                                        break;
                                }
                        }
                    } else {
                        X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                        str = "MEDIA_INFO_AUDIO_RENDERING_START:";
                    }
                    return true;
                }
                X = NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this);
                str = "MEDIA_INFO_SUBTITLE_TIMED_OUT:";
            }
            Log.d(X, str);
            return true;
        }
    }

    public class b implements IMediaPlayer.OnErrorListener {
        public b() {
        }

        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            Log.d(NSTIJKPlayerEPG.X(NSTIJKPlayerEPG.this), "Error: " + i + "," + i2);
            NSTIJKPlayerEPG.v(NSTIJKPlayerEPG.this, -1);
            NSTIJKPlayerEPG.S(NSTIJKPlayerEPG.this, -1);
            NSTIJKPlayerEPG.z(NSTIJKPlayerEPG.this);
            NSTIJKPlayerEPG.Y(NSTIJKPlayerEPG.this, -1);
            if (NSTIJKPlayerEPG.b0(NSTIJKPlayerEPG.this) != null) {
                NSTIJKPlayerEPG.b0(NSTIJKPlayerEPG.this).onError(NSTIJKPlayerEPG.x(NSTIJKPlayerEPG.this), i, i2);
            }
            return true;
        }
    }

    public class c implements IMediaPlayer.OnBufferingUpdateListener {
        public c() {
        }

        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            NSTIJKPlayerEPG.c0(NSTIJKPlayerEPG.this, i);
        }
    }

    public class d implements IMediaPlayer.OnSeekCompleteListener {
        public d() {
        }

        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerEPG.i0(NSTIJKPlayerEPG.this, System.currentTimeMillis());
        }
    }

    public class e implements IMediaPlayer.OnTimedTextListener {
        public e() {
        }

        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            TextView textView;
            if (ijkTimedText == null) {
                NSTIJKPlayerEPG.this.W.setVisibility(8);
                return;
            }
            String replace = ijkTimedText.getText().replace("{\\b1}", "").replace("{\\b0}", "").replace("{\\i1}", "").replace("{\\i0}", "").replace("{\\c}", "");
            StringBuilder sb = new StringBuilder();
            try {
                if (replace.contains("{")) {
                    for (String str : replace.split("\\{")) {
                        if (str.contains("}")) {
                            str = str.substring(str.lastIndexOf("}") + 1);
                        }
                        sb.append(str);
                    }
                }
            } catch (Exception unused) {
            }
            NSTIJKPlayerEPG nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
            NSTIJKPlayerEPG.l0(nSTIJKPlayerEPG, NSTIJKPlayerEPG.m0(nSTIJKPlayerEPG).getSharedPreferences("pref.using_sub_font_size", 0));
            try {
                NSTIJKPlayerEPG.this.W.setTextSize(2, Float.parseFloat(NSTIJKPlayerEPG.k0(NSTIJKPlayerEPG.this).getString("pref.using_sub_font_size", m7.a.x0)));
            } catch (Exception unused2) {
            }
            if (NSTIJKPlayerEPG.this.getShowOrHideSubtitles().equals("visible")) {
                NSTIJKPlayerEPG.this.W.setVisibility(0);
            } else {
                NSTIJKPlayerEPG.this.W.setVisibility(8);
            }
            if (sb.length() > 0) {
                textView = NSTIJKPlayerEPG.this.W;
                replace = sb.toString();
            } else {
                textView = NSTIJKPlayerEPG.this.W;
            }
            textView.setText(replace);
        }
    }

    public class f implements a.a {
        public f() {
        }

        public void a(a.b bVar, int i, int i2, int i3) {
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a a = bVar.a();
            NSTIJKPlayerEPG nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
            if (a != nSTIJKPlayerEPG.P) {
                Log.e(NSTIJKPlayerEPG.X(nSTIJKPlayerEPG), "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerEPG.D(nSTIJKPlayerEPG, i2);
            NSTIJKPlayerEPG.L(NSTIJKPlayerEPG.this, i3);
            boolean z = false;
            boolean z2 = NSTIJKPlayerEPG.P(NSTIJKPlayerEPG.this) == 3;
            if (!NSTIJKPlayerEPG.this.P.d() || (NSTIJKPlayerEPG.W0(NSTIJKPlayerEPG.this) == i2 && NSTIJKPlayerEPG.k(NSTIJKPlayerEPG.this) == i3)) {
                z = true;
            }
            if (NSTIJKPlayerEPG.x(NSTIJKPlayerEPG.this) != null && z2 && z) {
                if (NSTIJKPlayerEPG.A(NSTIJKPlayerEPG.this) != 0) {
                    NSTIJKPlayerEPG nSTIJKPlayerEPG2 = NSTIJKPlayerEPG.this;
                    nSTIJKPlayerEPG2.seekTo(NSTIJKPlayerEPG.A(nSTIJKPlayerEPG2));
                }
                NSTIJKPlayerEPG.this.start();
            }
        }

        public void b(a.b bVar, int i, int i2) {
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a a = bVar.a();
            NSTIJKPlayerEPG nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
            if (a != nSTIJKPlayerEPG.P) {
                Log.e(NSTIJKPlayerEPG.X(nSTIJKPlayerEPG), "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerEPG.n0(nSTIJKPlayerEPG, bVar);
            if (NSTIJKPlayerEPG.x(NSTIJKPlayerEPG.this) == null) {
                NSTIJKPlayerEPG.this.p1();
            } else {
                NSTIJKPlayerEPG nSTIJKPlayerEPG2 = NSTIJKPlayerEPG.this;
                NSTIJKPlayerEPG.p0(nSTIJKPlayerEPG2, NSTIJKPlayerEPG.x(nSTIJKPlayerEPG2), bVar);
            }
        }

        public void c(a.b bVar) {
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a a = bVar.a();
            NSTIJKPlayerEPG nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
            if (a != nSTIJKPlayerEPG.P) {
                Log.e(NSTIJKPlayerEPG.X(nSTIJKPlayerEPG), "onSurfaceDestroyed: unmatched render callback\n");
            } else {
                NSTIJKPlayerEPG.n0(nSTIJKPlayerEPG, null);
                NSTIJKPlayerEPG.this.r1();
            }
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ LinearLayout a;

        public g(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        public void run() {
            this.a.setVisibility(8);
            if (NSTIJKPlayerEPG.q0(NSTIJKPlayerEPG.this).getVisibility() != 0 || NSTIJKPlayerEPG.r0(NSTIJKPlayerEPG.this) == null) {
                return;
            }
            NSTIJKPlayerEPG.r0(NSTIJKPlayerEPG.this).setVisibility(0);
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            NSTIJKPlayerEPG.s0(NSTIJKPlayerEPG.this);
        }
    }

    public class i implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ int a;

        public i(int i) {
            this.a = i;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerEPG nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
            NSTIJKPlayerEPG.x0(nSTIJKPlayerEPG, NSTIJKPlayerEPG.z0(nSTIJKPlayerEPG).edit());
            if (i == 111 || i == 11111111) {
                NSTIJKPlayerEPG.t0(NSTIJKPlayerEPG.this).putInt("currentVideoTrack", -1);
                NSTIJKPlayerEPG.this.f1(this.a);
            } else {
                NSTIJKPlayerEPG.t0(NSTIJKPlayerEPG.this).putInt("currentVideoTrack", i);
                NSTIJKPlayerEPG.this.t1(i);
            }
            NSTIJKPlayerEPG.t0(NSTIJKPlayerEPG.this).apply();
        }
    }

    public class j implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ int a;

        public j(int i) {
            this.a = i;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerEPG nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
            NSTIJKPlayerEPG.B0(nSTIJKPlayerEPG, NSTIJKPlayerEPG.F0(nSTIJKPlayerEPG).edit());
            if (i == 1111 || i == 1111111) {
                NSTIJKPlayerEPG.A0(NSTIJKPlayerEPG.this).putInt("currentAudioTrack", -1);
                NSTIJKPlayerEPG.this.f1(this.a);
            } else {
                NSTIJKPlayerEPG.A0(NSTIJKPlayerEPG.this).putInt("currentAudioTrack", i);
                int currentPosition = (int) NSTIJKPlayerEPG.x(NSTIJKPlayerEPG.this).getCurrentPosition();
                NSTIJKPlayerEPG.this.t1(i);
                NSTIJKPlayerEPG.x(NSTIJKPlayerEPG.this).seekTo(Long.parseLong(String.valueOf(currentPosition)));
            }
            NSTIJKPlayerEPG.A0(NSTIJKPlayerEPG.this).apply();
        }
    }

    public class k implements SeekBar.OnSeekBarChangeListener {
        public k() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView h;
            Resources resources;
            int i2;
            NSTIJKPlayerEPG.g(NSTIJKPlayerEPG.this, i);
            int f = (int) ((NSTIJKPlayerEPG.f(NSTIJKPlayerEPG.this) / 255.0f) * 100.0f);
            if (f < 20) {
                h = NSTIJKPlayerEPG.h(NSTIJKPlayerEPG.this);
                resources = NSTIJKPlayerEPG.this.getResources();
                i2 = a7.e.i0;
            } else if (f < 30) {
                h = NSTIJKPlayerEPG.h(NSTIJKPlayerEPG.this);
                resources = NSTIJKPlayerEPG.this.getResources();
                i2 = a7.e.j0;
            } else if (f < 40) {
                h = NSTIJKPlayerEPG.h(NSTIJKPlayerEPG.this);
                resources = NSTIJKPlayerEPG.this.getResources();
                i2 = a7.e.k0;
            } else if (f < 50) {
                h = NSTIJKPlayerEPG.h(NSTIJKPlayerEPG.this);
                resources = NSTIJKPlayerEPG.this.getResources();
                i2 = a7.e.l0;
            } else if (f < 60) {
                h = NSTIJKPlayerEPG.h(NSTIJKPlayerEPG.this);
                resources = NSTIJKPlayerEPG.this.getResources();
                i2 = a7.e.m0;
            } else if (f < 70) {
                h = NSTIJKPlayerEPG.h(NSTIJKPlayerEPG.this);
                resources = NSTIJKPlayerEPG.this.getResources();
                i2 = a7.e.n0;
            } else {
                h = NSTIJKPlayerEPG.h(NSTIJKPlayerEPG.this);
                resources = NSTIJKPlayerEPG.this.getResources();
                i2 = a7.e.o0;
            }
            h.setBackground(resources.getDrawable(i2));
            WindowManager.LayoutParams attributes = NSTIJKPlayerEPG.E(NSTIJKPlayerEPG.this).getWindow().getAttributes();
            attributes.screenBrightness = NSTIJKPlayerEPG.f(NSTIJKPlayerEPG.this) / 255.0f;
            NSTIJKPlayerEPG.j0(NSTIJKPlayerEPG.this).R((int) NSTIJKPlayerEPG.f(NSTIJKPlayerEPG.this));
            NSTIJKPlayerEPG.E(NSTIJKPlayerEPG.this).getWindow().setAttributes(attributes);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerEPG.this.C1();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerEPG.this.C1();
            NSTIJKPlayerEPG.this.a1(3000);
        }
    }

    public class l implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ int a;

        public l(int i) {
            this.a = i;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerEPG nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
            NSTIJKPlayerEPG.K0(nSTIJKPlayerEPG, NSTIJKPlayerEPG.L0(nSTIJKPlayerEPG).edit());
            if (i == 11111 || i == 111111) {
                TextView textView = NSTIJKPlayerEPG.this.W;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                NSTIJKPlayerEPG.J0(NSTIJKPlayerEPG.this).putInt("currentSubtitleTrack", -1);
                NSTIJKPlayerEPG.this.f1(this.a);
            } else {
                TextView textView2 = NSTIJKPlayerEPG.this.W;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                NSTIJKPlayerEPG.J0(NSTIJKPlayerEPG.this).putInt("currentSubtitleTrack", i);
                NSTIJKPlayerEPG.this.t1(i);
            }
            NSTIJKPlayerEPG.J0(NSTIJKPlayerEPG.this).apply();
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            NSTIJKPlayerEPG nSTIJKPlayerEPG;
            String str;
            switch (i) {
                case 0:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "10";
                    break;
                case 1:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "12";
                    break;
                case 2:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "14";
                    break;
                case 3:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "16";
                    break;
                case 4:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "18";
                    break;
                case 5:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "20";
                    break;
                case 6:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "22";
                    break;
                case 7:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "24";
                    break;
                case 8:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "26";
                    break;
                case 9:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "28";
                    break;
                case 10:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "30";
                    break;
                case 11:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "32";
                    break;
                case 12:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "34";
                    break;
                case 13:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "36";
                    break;
                case 14:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "38";
                    break;
                case 15:
                    nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
                    str = "40";
                    break;
                default:
                    return;
            }
            NSTIJKPlayerEPG.M0(nSTIJKPlayerEPG, str);
            NSTIJKPlayerEPG.N0(NSTIJKPlayerEPG.this).setText(str);
            dialogInterface.cancel();
        }
    }

    public class n implements DialogInterface.OnDismissListener {
        public n() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class o implements SeekBar.OnSeekBarChangeListener {
        public o() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView R0;
            Resources resources;
            int i2;
            if (NSTIJKPlayerEPG.D0(NSTIJKPlayerEPG.this) != null) {
                try {
                    NSTIJKPlayerEPG.D0(NSTIJKPlayerEPG.this).setStreamVolume(3, i, 0);
                    int streamVolume = (int) ((NSTIJKPlayerEPG.D0(NSTIJKPlayerEPG.this).getStreamVolume(3) / NSTIJKPlayerEPG.Q0(NSTIJKPlayerEPG.this)) * 100.0f);
                    if (streamVolume == 0 || streamVolume < 0) {
                        R0 = NSTIJKPlayerEPG.R0(NSTIJKPlayerEPG.this);
                        resources = NSTIJKPlayerEPG.this.getResources();
                        i2 = a7.e.w0;
                    } else if (streamVolume < 40) {
                        R0 = NSTIJKPlayerEPG.R0(NSTIJKPlayerEPG.this);
                        resources = NSTIJKPlayerEPG.this.getResources();
                        i2 = a7.e.t0;
                    } else if (streamVolume < 80) {
                        R0 = NSTIJKPlayerEPG.R0(NSTIJKPlayerEPG.this);
                        resources = NSTIJKPlayerEPG.this.getResources();
                        i2 = a7.e.u0;
                    } else if (streamVolume < 100) {
                        R0 = NSTIJKPlayerEPG.R0(NSTIJKPlayerEPG.this);
                        resources = NSTIJKPlayerEPG.this.getResources();
                        i2 = a7.e.v0;
                    } else {
                        R0 = NSTIJKPlayerEPG.R0(NSTIJKPlayerEPG.this);
                        resources = NSTIJKPlayerEPG.this.getResources();
                        i2 = a7.e.v0;
                    }
                    R0.setBackground(resources.getDrawable(i2));
                } catch (Exception unused) {
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerEPG.this.C1();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerEPG.this.C1();
            NSTIJKPlayerEPG.this.a1(3000);
        }
    }

    public class p implements View.OnTouchListener {
        public p() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent != null && NSTIJKPlayerEPG.S0(NSTIJKPlayerEPG.this).onTouchEvent(motionEvent);
        }
    }

    public class q implements Runnable {
        public q() {
        }

        public void run() {
            NSTIJKPlayerEPG nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
            nSTIJKPlayerEPG.H++;
            m7.w.P0(NSTIJKPlayerEPG.E(nSTIJKPlayerEPG), NSTIJKPlayerEPG.E(NSTIJKPlayerEPG.this).getResources().getString(a7.j.g5) + " (" + NSTIJKPlayerEPG.this.H + "/" + NSTIJKPlayerEPG.T0(NSTIJKPlayerEPG.this) + ")");
            NSTIJKPlayerEPG.this.p1();
            NSTIJKPlayerEPG.this.start();
        }
    }

    public class r implements Runnable {
        public r() {
        }

        public void run() {
            NSTIJKPlayerEPG.this.j1();
        }
    }

    public class s implements Runnable {
        public s() {
        }

        public void run() {
            NSTIJKPlayerEPG.this.i1();
        }
    }

    public class t implements IMediaPlayer.OnVideoSizeChangedListener {
        public t() {
        }

        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            NSTIJKPlayerEPG.Y0(NSTIJKPlayerEPG.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerEPG.l(NSTIJKPlayerEPG.this, iMediaPlayer.getVideoHeight());
            NSTIJKPlayerEPG.o(NSTIJKPlayerEPG.this, iMediaPlayer.getVideoSarNum());
            NSTIJKPlayerEPG.r(NSTIJKPlayerEPG.this, iMediaPlayer.getVideoSarDen());
            if (NSTIJKPlayerEPG.W0(NSTIJKPlayerEPG.this) == 0 || NSTIJKPlayerEPG.k(NSTIJKPlayerEPG.this) == 0) {
                return;
            }
            NSTIJKPlayerEPG nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar = nSTIJKPlayerEPG.P;
            if (aVar != null) {
                aVar.c(NSTIJKPlayerEPG.W0(nSTIJKPlayerEPG), NSTIJKPlayerEPG.k(NSTIJKPlayerEPG.this));
                NSTIJKPlayerEPG nSTIJKPlayerEPG2 = NSTIJKPlayerEPG.this;
                nSTIJKPlayerEPG2.P.a(NSTIJKPlayerEPG.n(nSTIJKPlayerEPG2), NSTIJKPlayerEPG.p(NSTIJKPlayerEPG.this));
            }
            NSTIJKPlayerEPG.this.requestLayout();
        }
    }

    public class u implements IMediaPlayer.OnPreparedListener {
        public u() {
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerEPG.u(NSTIJKPlayerEPG.this, System.currentTimeMillis());
            NSTIJKPlayerEPG.v(NSTIJKPlayerEPG.this, 2);
            if (NSTIJKPlayerEPG.w(NSTIJKPlayerEPG.this) != null) {
                NSTIJKPlayerEPG.w(NSTIJKPlayerEPG.this).onPrepared(NSTIJKPlayerEPG.x(NSTIJKPlayerEPG.this));
            }
            NSTIJKPlayerEPG.z(NSTIJKPlayerEPG.this);
            NSTIJKPlayerEPG.Y0(NSTIJKPlayerEPG.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerEPG.l(NSTIJKPlayerEPG.this, iMediaPlayer.getVideoHeight());
            int A = NSTIJKPlayerEPG.A(NSTIJKPlayerEPG.this);
            if (A != 0) {
                NSTIJKPlayerEPG.this.seekTo(A);
            }
            if (NSTIJKPlayerEPG.W0(NSTIJKPlayerEPG.this) == 0 || NSTIJKPlayerEPG.k(NSTIJKPlayerEPG.this) == 0) {
                if (NSTIJKPlayerEPG.P(NSTIJKPlayerEPG.this) == 3) {
                    NSTIJKPlayerEPG.this.start();
                    return;
                }
                return;
            }
            NSTIJKPlayerEPG nSTIJKPlayerEPG = NSTIJKPlayerEPG.this;
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar = nSTIJKPlayerEPG.P;
            if (aVar != null) {
                aVar.c(NSTIJKPlayerEPG.W0(nSTIJKPlayerEPG), NSTIJKPlayerEPG.k(NSTIJKPlayerEPG.this));
                NSTIJKPlayerEPG nSTIJKPlayerEPG2 = NSTIJKPlayerEPG.this;
                nSTIJKPlayerEPG2.P.a(NSTIJKPlayerEPG.n(nSTIJKPlayerEPG2), NSTIJKPlayerEPG.p(NSTIJKPlayerEPG.this));
                if (!NSTIJKPlayerEPG.this.P.d() || (NSTIJKPlayerEPG.B(NSTIJKPlayerEPG.this) == NSTIJKPlayerEPG.W0(NSTIJKPlayerEPG.this) && NSTIJKPlayerEPG.J(NSTIJKPlayerEPG.this) == NSTIJKPlayerEPG.k(NSTIJKPlayerEPG.this))) {
                    if (NSTIJKPlayerEPG.P(NSTIJKPlayerEPG.this) == 3) {
                        NSTIJKPlayerEPG.this.start();
                    } else {
                        if (NSTIJKPlayerEPG.this.isPlaying()) {
                            return;
                        }
                        if (A == 0 && NSTIJKPlayerEPG.this.getCurrentPosition() <= 0) {
                            return;
                        }
                    }
                    NSTIJKPlayerEPG.z(NSTIJKPlayerEPG.this);
                }
            }
        }
    }

    public class v implements IMediaPlayer.OnCompletionListener {
        public v() {
        }

        public void onCompletion(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerEPG.v(NSTIJKPlayerEPG.this, 5);
            NSTIJKPlayerEPG.S(NSTIJKPlayerEPG.this, 5);
            NSTIJKPlayerEPG.z(NSTIJKPlayerEPG.this);
            NSTIJKPlayerEPG.this.C1();
            NSTIJKPlayerEPG.this.x1();
            NSTIJKPlayerEPG.this.a1(5000);
            if (NSTIJKPlayerEPG.T(NSTIJKPlayerEPG.this) != null) {
                NSTIJKPlayerEPG.T(NSTIJKPlayerEPG.this).onCompletion(NSTIJKPlayerEPG.x(NSTIJKPlayerEPG.this));
            }
        }
    }

    public static abstract class w {
    }

    public class x implements View.OnFocusChangeListener {
        public final View a;

        public x(View view) {
            this.a = view;
        }

        public final void a(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                if (z) {
                    return;
                }
                View view2 = this.a;
                if (view2 != null && view2.getTag() != null && this.a.getTag().equals("1") && NSTIJKPlayerEPG.O0(NSTIJKPlayerEPG.this) != null) {
                    NSTIJKPlayerEPG.O0(NSTIJKPlayerEPG.this).setBackgroundResource(a7.e.o);
                }
                a(1.0f);
                b(1.0f);
                return;
            }
            View view3 = this.a;
            if (view3 != null && view3.getTag() != null && this.a.getTag().equals("2")) {
                view.setBackground(NSTIJKPlayerEPG.this.getResources().getDrawable(a7.e.K1));
                return;
            }
            float f = z ? 1.12f : 1.0f;
            a(f);
            b(f);
            View view4 = this.a;
            if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1") || NSTIJKPlayerEPG.O0(NSTIJKPlayerEPG.this) == null) {
                return;
            }
            NSTIJKPlayerEPG.O0(NSTIJKPlayerEPG.this).setBackgroundResource(a7.e.h);
        }
    }

    public class y extends GestureDetector.SimpleOnGestureListener {
        public boolean a;

        public y() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.a = true;
            return super.onDown(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            NSTIJKPlayerEPG.this.I1();
            return true;
        }
    }

    public class z {
        public final Activity a;
        public View b;

        public z(Activity activity) {
            this.a = activity;
        }

        public z a() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(8);
            }
            return this;
        }

        public z b(int i) {
            this.b = this.a.findViewById(i);
            return this;
        }

        public z c() {
            View view = this.b;
            if (view != null) {
                view.requestFocus();
            }
            return this;
        }

        public z d(CharSequence charSequence) {
            TextView textView = this.b;
            if (textView != null && (textView instanceof TextView)) {
                textView.setText(charSequence);
            }
            return this;
        }

        public z e() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(0);
            }
            return this;
        }
    }

    public NSTIJKPlayerEPG(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "NSTIJKPlayerEPG";
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = -1;
        this.z = -1L;
        this.A = true;
        this.B = false;
        this.C = 7000;
        this.F = 0;
        this.H = 0;
        this.I = 5;
        this.J = false;
        this.S = 0L;
        this.T = 0L;
        this.U = 0L;
        this.V = 0L;
        this.e0 = "visible";
        this.j0 = -1.0f;
        Boolean bool = Boolean.FALSE;
        this.p0 = bool;
        this.q0 = bool;
        this.r0 = bool;
        this.s0 = bool;
        this.t0 = bool;
        this.u0 = bool;
        this.v0 = false;
        this.y0 = false;
        this.z0 = false;
        this.H0 = false;
        this.I0 = false;
        this.L0 = false;
        this.j1 = 0;
        this.y1 = false;
        this.E1 = "";
        this.F1 = new k();
        this.G1 = new o();
        this.H1 = new t();
        this.I1 = new u();
        this.J1 = new v();
        this.K1 = new a();
        this.L1 = new b();
        this.M1 = new c();
        this.N1 = new d();
        this.O1 = new e();
        this.P1 = new f();
        this.Q1 = 4;
        this.R1 = W1[0];
        this.S1 = new ArrayList();
        this.T1 = 0;
        this.U1 = 0;
        this.V1 = false;
        m1(context);
    }

    public static /* synthetic */ int A(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.u;
    }

    public static /* synthetic */ SharedPreferences.Editor A0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.F0;
    }

    public static /* synthetic */ int B(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.m;
    }

    public static /* synthetic */ SharedPreferences.Editor B0(NSTIJKPlayerEPG nSTIJKPlayerEPG, SharedPreferences.Editor editor) {
        nSTIJKPlayerEPG.F0 = editor;
        return editor;
    }

    public static /* synthetic */ int D(NSTIJKPlayerEPG nSTIJKPlayerEPG, int i2) {
        nSTIJKPlayerEPG.m = i2;
        return i2;
    }

    public static /* synthetic */ AudioManager D0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.h0;
    }

    public static /* synthetic */ Activity E(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.f0;
    }

    public static /* synthetic */ SharedPreferences F0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.C0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void F1() {
        int i2;
        CharSequence[] charSequenceArr = {"10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40"};
        a.a aVar = new a.a(this.C1);
        aVar.setTitle(getResources().getString(a7.j.R7));
        String string = this.J0.getString("pref.using_sub_font_size", m7.a.x0);
        string.hashCode();
        char c2 = 65535;
        switch (string.hashCode()) {
            case 1567:
                if (string.equals("10")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1569:
                if (string.equals("12")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1571:
                if (string.equals("14")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1573:
                if (string.equals("16")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1575:
                if (string.equals("18")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1598:
                if (string.equals("20")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1600:
                if (string.equals("22")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1602:
                if (string.equals("24")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1604:
                if (string.equals("26")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1606:
                if (string.equals("28")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1629:
                if (string.equals("30")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1631:
                if (string.equals("32")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1633:
                if (string.equals("34")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1635:
                if (string.equals("36")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 1637:
                if (string.equals("38")) {
                    c2 = 14;
                    break;
                }
                break;
            case 1660:
                if (string.equals("40")) {
                    c2 = 15;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            default:
                i2 = 0;
                break;
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                break;
            case 5:
                i2 = 5;
                break;
            case 6:
                i2 = 6;
                break;
            case 7:
                i2 = 7;
                break;
            case '\b':
                i2 = 8;
                break;
            case '\t':
                i2 = 9;
                break;
            case '\n':
                i2 = 10;
                break;
            case 11:
                i2 = 11;
                break;
            case '\f':
                i2 = 12;
                break;
            case '\r':
                i2 = 13;
                break;
            case 14:
                i2 = 14;
                break;
            case 15:
                i2 = 15;
                break;
        }
        aVar.l(charSequenceArr, i2, new m());
        try {
            androidx.appcompat.app.a create = aVar.create();
            this.V0 = create;
            create.setOnDismissListener(new n());
            this.V0.show();
        } catch (Exception unused) {
        }
    }

    private void G1(String str) {
        try {
            SharedPreferences sharedPreferences = this.f0.getSharedPreferences("pref.using_sub_font_size", 0);
            this.J0 = sharedPreferences;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            this.S0 = edit;
            if (edit != null) {
                edit.putString("pref.using_sub_font_size", str);
                this.S0.apply();
            }
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ int J(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.n;
    }

    public static /* synthetic */ SharedPreferences.Editor J0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.E0;
    }

    private void J1() {
        View findViewById = this.f0.findViewById(a7.f.p);
        this.m0 = findViewById;
        findViewById.setClickable(true);
        this.m0.setOnTouchListener(new p());
    }

    public static /* synthetic */ SharedPreferences.Editor K0(NSTIJKPlayerEPG nSTIJKPlayerEPG, SharedPreferences.Editor editor) {
        nSTIJKPlayerEPG.E0 = editor;
        return editor;
    }

    public static /* synthetic */ int L(NSTIJKPlayerEPG nSTIJKPlayerEPG, int i2) {
        nSTIJKPlayerEPG.n = i2;
        return i2;
    }

    public static /* synthetic */ SharedPreferences L0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.B0;
    }

    public static /* synthetic */ void M0(NSTIJKPlayerEPG nSTIJKPlayerEPG, String str) {
        nSTIJKPlayerEPG.G1(str);
    }

    public static /* synthetic */ TextView N0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.T0;
    }

    public static /* synthetic */ Button O0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.o0;
    }

    public static /* synthetic */ int P(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.h;
    }

    public static /* synthetic */ int Q0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.i0;
    }

    public static /* synthetic */ TextView R0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.l1;
    }

    public static /* synthetic */ int S(NSTIJKPlayerEPG nSTIJKPlayerEPG, int i2) {
        nSTIJKPlayerEPG.h = i2;
        return i2;
    }

    public static /* synthetic */ GestureDetector S0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.k0;
    }

    public static /* synthetic */ IMediaPlayer.OnCompletionListener T(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.p;
    }

    public static /* synthetic */ int T0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.I;
    }

    public static /* synthetic */ IMediaPlayer.OnInfoListener W(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.t;
    }

    public static /* synthetic */ int W0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.k;
    }

    public static /* synthetic */ String X(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.a;
    }

    public static /* synthetic */ void Y(NSTIJKPlayerEPG nSTIJKPlayerEPG, int i2) {
        nSTIJKPlayerEPG.A1(i2);
    }

    public static /* synthetic */ int Y0(NSTIJKPlayerEPG nSTIJKPlayerEPG, int i2) {
        nSTIJKPlayerEPG.k = i2;
        return i2;
    }

    public static /* synthetic */ int Z(NSTIJKPlayerEPG nSTIJKPlayerEPG, int i2) {
        nSTIJKPlayerEPG.o = i2;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnErrorListener b0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.s;
    }

    public static /* synthetic */ int c0(NSTIJKPlayerEPG nSTIJKPlayerEPG, int i2) {
        nSTIJKPlayerEPG.r = i2;
        return i2;
    }

    public static /* synthetic */ float f(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.j0;
    }

    public static /* synthetic */ float g(NSTIJKPlayerEPG nSTIJKPlayerEPG, float f2) {
        nSTIJKPlayerEPG.j0 = f2;
        return f2;
    }

    public static /* synthetic */ TextView h(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.k1;
    }

    public static /* synthetic */ long i0(NSTIJKPlayerEPG nSTIJKPlayerEPG, long j2) {
        nSTIJKPlayerEPG.V = j2;
        return j2;
    }

    public static /* synthetic */ u7.a j0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.O;
    }

    public static /* synthetic */ int k(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.l;
    }

    public static /* synthetic */ SharedPreferences k0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.J0;
    }

    public static /* synthetic */ int l(NSTIJKPlayerEPG nSTIJKPlayerEPG, int i2) {
        nSTIJKPlayerEPG.l = i2;
        return i2;
    }

    public static /* synthetic */ SharedPreferences l0(NSTIJKPlayerEPG nSTIJKPlayerEPG, SharedPreferences sharedPreferences) {
        nSTIJKPlayerEPG.J0 = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ Context m0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.N;
    }

    public static /* synthetic */ int n(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.Q;
    }

    public static /* synthetic */ a.b n0(NSTIJKPlayerEPG nSTIJKPlayerEPG, a.b bVar) {
        nSTIJKPlayerEPG.i = bVar;
        return bVar;
    }

    public static /* synthetic */ int o(NSTIJKPlayerEPG nSTIJKPlayerEPG, int i2) {
        nSTIJKPlayerEPG.Q = i2;
        return i2;
    }

    public static /* synthetic */ int p(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.R;
    }

    public static /* synthetic */ void p0(NSTIJKPlayerEPG nSTIJKPlayerEPG, IMediaPlayer iMediaPlayer, a.b bVar) {
        nSTIJKPlayerEPG.c1(iMediaPlayer, bVar);
    }

    public static /* synthetic */ LinearLayout q0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.Y0;
    }

    public static /* synthetic */ int r(NSTIJKPlayerEPG nSTIJKPlayerEPG, int i2) {
        nSTIJKPlayerEPG.R = i2;
        return i2;
    }

    public static /* synthetic */ LinearLayout r0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.m1;
    }

    public static /* synthetic */ void s0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        nSTIJKPlayerEPG.F1();
    }

    public static /* synthetic */ SharedPreferences.Editor t0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.G0;
    }

    public static /* synthetic */ long u(NSTIJKPlayerEPG nSTIJKPlayerEPG, long j2) {
        nSTIJKPlayerEPG.T = j2;
        return j2;
    }

    public static /* synthetic */ int v(NSTIJKPlayerEPG nSTIJKPlayerEPG, int i2) {
        nSTIJKPlayerEPG.g = i2;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnPreparedListener w(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.q;
    }

    public static /* synthetic */ IMediaPlayer x(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.j;
    }

    public static /* synthetic */ SharedPreferences.Editor x0(NSTIJKPlayerEPG nSTIJKPlayerEPG, SharedPreferences.Editor editor) {
        nSTIJKPlayerEPG.G0 = editor;
        return editor;
    }

    public static /* synthetic */ w7.b z(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        nSTIJKPlayerEPG.getClass();
        return null;
    }

    public static /* synthetic */ SharedPreferences z0(NSTIJKPlayerEPG nSTIJKPlayerEPG) {
        return nSTIJKPlayerEPG.D0;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0186 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1(int r15) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEPG.A1(int):void");
    }

    public void B1() {
        v7.a.d(null);
    }

    public void C1() {
        Handler handler;
        if (NSTIJKPlayerEPGActivity.B2 || (handler = this.Z0) == null) {
            return;
        }
        handler.removeCallbacksAndMessages((Object) null);
    }

    public void D1() {
        Handler handler = this.b1;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void E0(String str) {
    }

    public void E1() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.j.release();
            this.j = null;
            this.g = 0;
            this.h = 0;
            ((AudioManager) this.N.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int H1() {
        /*
            r6 = this;
            int r0 = r6.Q1
            r1 = 1
            int r0 = r0 + r1
            r6.Q1 = r0
            android.app.Activity r0 = r6.f0
            java.lang.String r2 = "loginPrefs"
            r3 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r3)
            r6.K = r0
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r6.L = r0
            int r0 = r6.Q1
            int[] r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEPG.W1
            int r4 = r2.length
            int r0 = r0 % r4
            r6.Q1 = r0
            r0 = r2[r0]
            r6.R1 = r0
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a r0 = r6.P
            if (r0 == 0) goto Lb1
            android.app.Activity r0 = r6.f0
            int r2 = a7.f.X6
            android.view.View r0 = r0.findViewById(r2)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            android.app.Activity r2 = r6.f0
            int r4 = a7.f.n
            android.view.View r2 = r2.findViewById(r4)
            android.widget.TextView r2 = (android.widget.TextView) r2
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a r4 = r6.P
            int r5 = r6.R1
            r4.setAspectRatio(r5)
            int r4 = r6.Q1
            if (r4 != 0) goto L54
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.j2
        L4c:
            java.lang.String r1 = r1.getString(r4)
        L50:
            r2.setText(r1)
            goto L7d
        L54:
            if (r4 != r1) goto L5d
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.i2
            goto L4c
        L5d:
            r1 = 2
            if (r4 != r1) goto L67
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.Q8
            goto L4c
        L67:
            r1 = 3
            if (r4 != r1) goto L71
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.j3
            goto L4c
        L71:
            r1 = 4
            if (r4 != r1) goto L77
            java.lang.String r1 = "16:9"
            goto L50
        L77:
            r1 = 5
            if (r4 != r1) goto L7d
            java.lang.String r1 = "4:3"
            goto L50
        L7d:
            android.content.SharedPreferences$Editor r1 = r6.L
            java.lang.String r2 = "aspect_ratio"
            int r4 = r6.Q1
            r1.putInt(r2, r4)
            android.content.SharedPreferences$Editor r1 = r6.L
            r1.apply()
            r0.setVisibility(r3)
            android.widget.LinearLayout r1 = r6.m1
            if (r1 == 0) goto L9f
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L9f
            android.widget.LinearLayout r1 = r6.m1
            r2 = 8
            r1.setVisibility(r2)
        L9f:
            android.os.Handler r1 = r6.E
            r2 = 0
            r1.removeCallbacksAndMessages(r2)
            android.os.Handler r1 = r6.E
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEPG$g r2 = new com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEPG$g
            r2.<init>(r0)
            r3 = 3000(0xbb8, double:1.482E-320)
            r1.postDelayed(r2, r3)
        Lb1:
            int r0 = r6.R1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEPG.H1():int");
    }

    public void I1() {
        RelativeLayout relativeLayout;
        if (NSTIJKPlayerEPGActivity.B2) {
            D1();
            if (this.r1.getVisibility() == 0) {
                j1();
                return;
            } else {
                y1();
                b1(3000);
                return;
            }
        }
        SeekBar seekBar = this.X0;
        if (seekBar != null) {
            seekBar.setProgress(this.h0.getStreamVolume(3));
        }
        C1();
        if (this.p1.getVisibility() == 0) {
            this.p1.startAnimation(this.q1);
            relativeLayout = this.p1;
        } else {
            if (this.w1.getVisibility() != 0) {
                if (this.Y0.getVisibility() == 0) {
                    i1();
                    return;
                } else {
                    x1();
                    a1(5000);
                    return;
                }
            }
            this.w1.startAnimation(this.u1);
            relativeLayout = this.w1;
        }
        relativeLayout.setVisibility(8);
    }

    public void K(VodInfoCallback vodInfoCallback) {
    }

    public final void K1() {
        z zVar;
        int i2;
        try {
            IMediaPlayer iMediaPlayer = this.j;
            if (iMediaPlayer == null || !iMediaPlayer.isPlaying()) {
                this.n0.b(a7.f.H5).a();
                zVar = this.n0;
                i2 = a7.f.I5;
            } else {
                this.n0.b(a7.f.I5).a();
                zVar = this.n0;
                i2 = a7.f.H5;
            }
            zVar.b(i2).e();
        } catch (Exception unused) {
        }
    }

    public final void Z0() {
    }

    public void a() {
    }

    public void a1(int i2) {
        if (NSTIJKPlayerEPGActivity.B2) {
            return;
        }
        s sVar = new s();
        this.a1 = sVar;
        this.Z0.postDelayed(sVar, i2);
    }

    public void b() {
    }

    public void b1(int i2) {
        r rVar = new r();
        this.c1 = rVar;
        this.b1.postDelayed(rVar, i2);
    }

    public final void c1(IMediaPlayer iMediaPlayer, a.b bVar) {
        if (iMediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            bVar.b(iMediaPlayer);
        }
    }

    public boolean canPause() {
        return this.v;
    }

    public boolean canSeekBackward() {
        return this.w;
    }

    public boolean canSeekForward() {
        return this.x;
    }

    public void d(String str) {
    }

    public final String d1(String str) {
        return TextUtils.isEmpty(str) ? "und" : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0052 A[PHI: r2
      0x0052: PHI (r2v1 java.lang.String) = (r2v0 java.lang.String), (r2v6 java.lang.String) binds: [B:9:0x002e, B:14:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tv.danmaku.ijk.media.player.IMediaPlayer e1(int r10) {
        /*
            r9 = this;
            r0 = 1
            if (r10 == r0) goto Lc9
            boolean r10 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerEPGActivity.J1()
            if (r10 != 0) goto L14
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEPG$z r10 = r9.n0
            int r1 = a7.f.A
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEPG$z r10 = r10.b(r1)
            r10.e()
        L14:
            android.net.Uri r10 = r9.c
            if (r10 == 0) goto Lc7
            tv.danmaku.ijk.media.player.IjkMediaPlayer r10 = new tv.danmaku.ijk.media.player.IjkMediaPlayer
            r10.<init>()
            r1 = 3
            tv.danmaku.ijk.media.player.IjkMediaPlayer.native_setLogLevel(r1)
            u7.a r1 = r9.O
            boolean r1 = r1.D()
            java.lang.String r2 = "mediacodec"
            r3 = 0
            r5 = 1
            r7 = 4
            if (r1 == 0) goto L52
            r10.setOption(r7, r2, r5)
            u7.a r1 = r9.O
            boolean r1 = r1.E()
            java.lang.String r2 = "mediacodec-auto-rotate"
            if (r1 == 0) goto L41
            r10.setOption(r7, r2, r5)
            goto L44
        L41:
            r10.setOption(r7, r2, r3)
        L44:
            u7.a r1 = r9.O
            boolean r1 = r1.v()
            java.lang.String r2 = "mediacodec-handle-resolution-change"
            if (r1 == 0) goto L52
            r10.setOption(r7, r2, r5)
            goto L55
        L52:
            r10.setOption(r7, r2, r3)
        L55:
            java.lang.String r1 = "subtitle"
            r10.setOption(r7, r1, r5)
            u7.a r1 = r9.O
            boolean r1 = r1.G()
            java.lang.String r2 = "opensles"
            if (r1 == 0) goto L68
            r10.setOption(r7, r2, r5)
            goto L6b
        L68:
            r10.setOption(r7, r2, r3)
        L6b:
            u7.a r1 = r9.O
            java.lang.String r1 = r1.w()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r2 = "overlay-format"
            if (r1 == 0) goto L80
            r3 = 842225234(0x32335652, double:4.16114554E-315)
            r10.setOption(r7, r2, r3)
            goto L85
        L80:
            java.lang.String r1 = "fcc-_es2"
            r10.setOption(r7, r2, r1)
        L85:
            java.lang.String r1 = "framedrop"
            r10.setOption(r7, r1, r5)
            java.lang.String r1 = "start-on-prepared"
            r10.setOption(r7, r1, r5)
            android.app.Activity r1 = r9.f0
            java.lang.String r2 = "user_agent"
            r3 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r9.M = r1
            java.lang.String r4 = "IPTVSmartersPlayer"
            java.lang.String r1 = r1.getString(r2, r4)
            java.lang.String r8 = ""
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto Lac
            r10.setOption(r0, r2, r1)
            goto Laf
        Lac:
            r10.setOption(r0, r2, r4)
        Laf:
            java.lang.String r0 = "mediacodec-hevc"
            r10.setOption(r7, r0, r5)
            java.lang.String r0 = "0"
            r1 = 48
            r4 = 2
            r10.setOption(r4, r0, r1)
            android.app.Activity r0 = r9.f0
            java.lang.String r1 = "pref.using_buffer_size"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r3)
            r9.v1 = r0
            goto Lce
        Lc7:
            r10 = 0
            goto Lce
        Lc9:
            tv.danmaku.ijk.media.player.AndroidMediaPlayer r10 = new tv.danmaku.ijk.media.player.AndroidMediaPlayer
            r10.<init>()
        Lce:
            u7.a r0 = r9.O
            boolean r0 = r0.q()
            if (r0 == 0) goto Ldc
            tv.danmaku.ijk.media.player.TextureMediaPlayer r0 = new tv.danmaku.ijk.media.player.TextureMediaPlayer
            r0.<init>(r10)
            r10 = r0
        Ldc:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEPG.e1(int):tv.danmaku.ijk.media.player.IMediaPlayer");
    }

    public void f1(int i2) {
        w7.e.b(this.j, i2);
    }

    public void g1() {
        v7.a.d(this.j);
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        if (this.j != null) {
            return this.r;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (o1()) {
            return (int) this.j.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentWindowIndex() {
        return this.F;
    }

    public int getDuration() {
        if (o1()) {
            return (int) this.j.getDuration();
        }
        return -1;
    }

    public Boolean getFullScreenValue() {
        return Boolean.valueOf(this.G);
    }

    public int getNewSeekPosition() {
        return (int) this.z;
    }

    public boolean getPlayerIsPrepared() {
        return this.L0;
    }

    public String getShowOrHideSubtitles() {
        return this.e0;
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }

    public void h1(Boolean bool) {
        this.G = bool.booleanValue();
    }

    public void i1() {
        if (NSTIJKPlayerEPGActivity.B2 || this.Y0.getVisibility() != 0) {
            return;
        }
        this.Y0.startAnimation(this.e1);
        if (this.h1.getVisibility() == 0) {
            this.h1.startAnimation(this.e1);
        }
        if (this.m1.getVisibility() == 0) {
            this.m1.startAnimation(this.e1);
        }
        if (this.i1.getVisibility() == 0) {
            this.i1.startAnimation(this.e1);
        }
        this.Y0.setVisibility(8);
        if (this.h1.getVisibility() == 0) {
            this.h1.setVisibility(8);
        }
        if (this.m1.getVisibility() == 0) {
            this.m1.setVisibility(8);
        }
        if (this.i1.getVisibility() == 0) {
            this.i1.setVisibility(8);
        }
    }

    public boolean isPlaying() {
        IMediaPlayer iMediaPlayer;
        return o1() && (iMediaPlayer = this.j) != null && iMediaPlayer.isPlaying();
    }

    public void j1() {
        if (this.r1.getVisibility() == 0) {
            this.r1.startAnimation(this.t1);
            this.r1.setVisibility(8);
        }
    }

    public final void k1() {
        boolean p2 = this.O.p();
        this.V1 = p2;
        if (p2) {
            v7.a.b(getContext());
            this.j = v7.a.a();
        }
    }

    public final void l1() {
        this.S1.clear();
        if (this.O.s()) {
            this.S1.add(1);
        }
        if (this.O.t()) {
            this.S1.add(2);
        }
        if (this.O.r()) {
            this.S1.add(0);
        }
        if (this.S1.isEmpty()) {
            this.S1.add(1);
        }
        int intValue = ((Integer) this.S1.get(this.T1)).intValue();
        this.U1 = intValue;
        setRender(intValue);
    }

    public final void m1(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.N = applicationContext;
        this.O = new u7.a(applicationContext);
        this.K0 = new n7.l(this, this.N);
        k1();
        l1();
        this.k = 0;
        this.l = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.g = 0;
        this.h = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref.using_sub_font_size", 0);
        this.J0 = sharedPreferences;
        String string = sharedPreferences.getString("pref.using_sub_font_size", m7.a.x0);
        TextView textView = new TextView(context);
        this.W = textView;
        try {
            textView.setTextSize(2, Float.parseFloat(string));
        } catch (Exception unused) {
        }
        this.W.setTextColor(context.getResources().getColor(a7.c.G));
        this.W.setGravity(17);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        layoutParams.setMargins(0, 0, 0, 40);
        addView(this.W, layoutParams);
    }

    public boolean n1() {
        return this.V1;
    }

    public final boolean o1() {
        int i2;
        return (this.j == null || (i2 = this.g) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 != 5) {
        }
        o1();
        return super.onKeyDown(i2, keyEvent);
    }

    public void p1() {
        IMediaPlayer.OnErrorListener onErrorListener;
        if (this.c == null || this.i == null) {
            return;
        }
        q1(false);
        try {
            ((AudioManager) this.N.getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 1);
        } catch (Exception unused) {
        }
        try {
            this.j = e1(this.O.x());
            getContext();
            this.j.setOnPreparedListener(this.I1);
            this.j.setOnVideoSizeChangedListener(this.H1);
            this.j.setOnCompletionListener(this.J1);
            this.j.setOnErrorListener(this.L1);
            this.j.setOnInfoListener(this.K1);
            this.j.setOnBufferingUpdateListener(this.M1);
            this.j.setOnSeekCompleteListener(this.N1);
            this.j.setOnTimedTextListener(this.O1);
            this.r = 0;
            String scheme = this.c.getScheme();
            if (Build.VERSION.SDK_INT >= 23 && this.O.F() && (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file"))) {
                this.j.setDataSource(new w7.a(new File(this.c.toString())));
            } else {
                this.j.setDataSource(this.N, this.c, this.e);
            }
            c1(this.j, this.i);
            this.j.setAudioStreamType(3);
            this.j.setScreenOnWhilePlaying(true);
            this.S = System.currentTimeMillis();
            this.j.prepareAsync();
            this.l0 = this.f0.getResources().getDisplayMetrics().widthPixels;
            AudioManager audioManager = (AudioManager) this.f0.getSystemService("audio");
            this.h0 = audioManager;
            this.i0 = audioManager.getStreamMaxVolume(3);
            int streamVolume = this.h0.getStreamVolume(3);
            this.X0.setMax(this.h0.getStreamMaxVolume(3));
            this.X0.setProgress(streamVolume);
            this.k0 = new GestureDetector(this.f0, new y());
            J1();
            this.w0 = new StringBuilder();
            this.x0 = new Formatter(this.w0, Locale.getDefault());
            this.g = 1;
        } catch (NullPointerException e2) {
            Log.w(this.a, "Unable to open content: " + this.c, e2);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.L1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (IllegalArgumentException e3) {
            Log.w(this.a, "Unable to open content: " + this.c, e3);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.L1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (IOException e4) {
            Log.w(this.a, "Unable to open content: " + this.c, e4);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.L1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (Exception e5) {
            Log.w(this.a, "Unable to open content: " + this.c, e5);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.L1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void pause() {
        IMediaPlayer iMediaPlayer;
        if (o1() && (iMediaPlayer = this.j) != null && iMediaPlayer.isPlaying()) {
            this.j.pause();
            this.g = 4;
        }
        this.h = 4;
    }

    public void q1(boolean z2) {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.j.release();
            this.j = null;
            this.g = 0;
            if (z2) {
                this.h = 0;
            }
            ((AudioManager) this.N.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public void r1() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    public void s1() {
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void seekTo(int i2) {
        if (o1()) {
            this.U = System.currentTimeMillis();
            this.j.seekTo(i2);
            i2 = 0;
        }
        this.u = i2;
    }

    public void setAdjustViewBounds(boolean z2) {
        if (this.x1 == z2) {
            return;
        }
        this.x1 = z2;
        if (z2) {
            setBackground((Drawable) null);
        } else {
            setBackgroundColor(-16777216);
        }
        requestLayout();
    }

    public void setContext(Context context) {
        this.C1 = context;
    }

    public void setCurrentChannelLogo(String str) {
        this.A1 = str;
    }

    public void setCurrentEpgChannelID(String str) {
        this.z1 = str;
    }

    public void setCurrentWindowIndex(int i2) {
        this.F = i2;
    }

    public void setEPGHandler(Handler handler) {
        this.B1 = handler;
    }

    public void setHudView(TableLayout tableLayout) {
    }

    public void setLiveStreamDBHandler(LiveStreamDBHandler liveStreamDBHandler) {
        this.D1 = liveStreamDBHandler;
    }

    public void setMediaController(w7.b bVar) {
        Z0();
    }

    public void setMovieListener(w wVar) {
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.p = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.s = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.t = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.q = onPreparedListener;
    }

    public void setRender(int i2) {
        SurfaceView surfaceView;
        if (i2 == 0) {
            surfaceView = null;
        } else if (i2 == 1) {
            surfaceView = new com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.b(getContext());
        } else {
            if (i2 != 2) {
                Log.e(this.a, String.format(Locale.getDefault(), "invalid render %d\n", new Object[]{Integer.valueOf(i2)}));
                return;
            }
            surfaceView = new com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.c(getContext());
            if (this.j != null) {
                surfaceView.getSurfaceHolder().b(this.j);
                surfaceView.c(this.j.getVideoWidth(), this.j.getVideoHeight());
                surfaceView.a(this.j.getVideoSarNum(), this.j.getVideoSarDen());
                surfaceView.setAspectRatio(this.R1);
            }
        }
        setRenderView(surfaceView);
    }

    public void setRenderView(com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar) {
        int i2;
        int i3;
        if (this.P != null) {
            IMediaPlayer iMediaPlayer = this.j;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.P.getView();
            this.P.b(this.P1);
            this.P = null;
            removeView(view);
        }
        if (aVar == null) {
            return;
        }
        this.P = aVar;
        SharedPreferences sharedPreferences = this.N.getSharedPreferences("loginPrefs", 0);
        this.K = sharedPreferences;
        int i4 = sharedPreferences.getInt("aspect_ratio", 4);
        this.Q1 = i4;
        aVar.setAspectRatio(i4);
        int i5 = this.k;
        if (i5 > 0 && (i3 = this.l) > 0) {
            aVar.c(i5, i3);
        }
        int i6 = this.Q;
        if (i6 > 0 && (i2 = this.R) > 0) {
            aVar.a(i6, i2);
        }
        View view2 = this.P.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(view2);
        this.P.e(this.P1);
        this.P.setVideoRotation(this.o);
    }

    public void setShowOrHideSubtitles(String str) {
        this.e0 = str;
    }

    public void setTitle(CharSequence charSequence) {
        this.n0.b(a7.f.lj).d(charSequence);
    }

    public void start() {
        if (o1()) {
            this.j.start();
            this.g = 3;
        }
        this.h = 3;
    }

    public void t1(int i2) {
        w7.e.e(this.j, i2);
    }

    public void u1(Activity activity, NSTIJKPlayerEPG nSTIJKPlayerEPG, RadioGroup radioGroup, RadioGroup radioGroup2, RadioGroup radioGroup3, TextView textView, TextView textView2, TextView textView3, TextView textView4, SeekBar seekBar, SeekBar seekBar2, LinearLayout linearLayout, Animation animation, Animation animation2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView5, LinearLayout linearLayout4, Animation animation3, Animation animation4, TextView textView6, RelativeLayout relativeLayout, Animation animation5, LinearLayout linearLayout5, Animation animation6, Animation animation7, RelativeLayout relativeLayout2, Animation animation8, String str, FrameLayout frameLayout) {
        this.f0 = activity;
        this.g0 = nSTIJKPlayerEPG;
        this.D = new Handler();
        this.E = new Handler();
        this.P0 = radioGroup;
        this.Q0 = radioGroup2;
        this.R0 = radioGroup3;
        this.O0 = textView;
        this.N0 = textView2;
        this.M0 = textView3;
        this.T0 = textView4;
        this.W0 = seekBar;
        this.X0 = seekBar2;
        this.Y0 = linearLayout;
        this.Z0 = new Handler();
        this.b1 = new Handler();
        this.d1 = animation;
        this.e1 = animation2;
        this.f1 = imageView;
        this.g1 = imageView2;
        this.h1 = linearLayout2;
        this.i1 = linearLayout3;
        this.W0.setOnSeekBarChangeListener(this.F1);
        this.X0.setOnSeekBarChangeListener(this.G1);
        this.k1 = textView5;
        seekBar.setKeyProgressIncrement(1);
        float f2 = this.f0.getWindow().getAttributes().screenBrightness;
        this.j0 = f2;
        if (f2 == -1.0f) {
            this.j0 = this.O != null ? r3.o() : m7.a.J0;
        }
        seekBar.setProgress((int) this.j0);
        this.m1 = linearLayout4;
        this.n1 = animation3;
        this.o1 = animation4;
        this.l1 = textView6;
        this.p1 = relativeLayout;
        this.q1 = animation5;
        this.r1 = linearLayout5;
        this.s1 = animation6;
        this.t1 = animation7;
        this.w1 = relativeLayout2;
        this.u1 = animation8;
        this.E1 = str;
        this.U0 = frameLayout;
        this.n0 = new z(activity);
    }

    public final void v1(Uri uri, Map map, boolean z2, String str) {
        this.c = uri;
        this.d = str;
        this.e = map;
        this.u = 0;
        this.G = z2;
        this.F = this.F;
        E1();
        p1();
        requestLayout();
        invalidate();
    }

    public void w1(Uri uri, boolean z2, String str) {
        v1(uri, null, z2, str);
    }

    public void x1() {
        if (NSTIJKPlayerEPGActivity.B2 || this.Y0.getVisibility() != 8) {
            return;
        }
        this.Y0.startAnimation(this.d1);
        this.Y0.setVisibility(0);
        if (this.h1.getVisibility() == 8) {
            this.h1.startAnimation(this.d1);
            this.h1.setVisibility(0);
        }
        if (this.m1.getVisibility() == 8 && !NSTIJKPlayerEPGActivity.J1()) {
            this.m1.startAnimation(this.d1);
            this.m1.setVisibility(0);
        }
        if (this.i1.getVisibility() == 8) {
            this.i1.startAnimation(this.d1);
            this.i1.setVisibility(0);
        }
    }

    public void y1() {
        if (this.Y0.getVisibility() == 8) {
            this.r1.startAnimation(this.s1);
            this.r1.setVisibility(0);
        }
    }

    public void z1(RadioGroup radioGroup, RadioGroup radioGroup2, RadioGroup radioGroup3, TextView textView, TextView textView2, TextView textView3, TextView textView4, FrameLayout frameLayout) {
        TextView textView5;
        int i2;
        ITrackInfo[] iTrackInfoArr;
        int i3;
        if (this.j == null) {
            return;
        }
        radioGroup.removeAllViews();
        radioGroup2.removeAllViews();
        radioGroup3.removeAllViews();
        try {
            SharedPreferences sharedPreferences = this.f0.getSharedPreferences("pref.using_sub_font_size", 0);
            this.J0 = sharedPreferences;
            textView4.setText(sharedPreferences.getString("pref.using_sub_font_size", m7.a.x0));
            frameLayout.setOnClickListener(new h());
        } catch (Exception unused) {
        }
        Boolean bool = Boolean.FALSE;
        this.u0 = bool;
        this.t0 = bool;
        this.s0 = bool;
        this.q0 = bool;
        this.p0 = bool;
        this.r0 = bool;
        int d2 = w7.e.d(this.j, 1);
        int d3 = w7.e.d(this.j, 2);
        int d4 = w7.e.d(this.j, 3);
        ITrackInfo[] trackInfo = this.j.getTrackInfo();
        if (trackInfo == null || trackInfo.length <= 0) {
            textView5 = textView3;
            i2 = 0;
            textView.setVisibility(0);
            textView2.setVisibility(0);
        } else {
            int i4 = 0;
            int i5 = -1;
            for (int length = trackInfo.length; i4 < length; length = i3) {
                ITrackInfo iTrackInfo = trackInfo[i4];
                int i6 = i5 + 1;
                int trackType = iTrackInfo.getTrackType();
                IMediaFormat format = iTrackInfo.getFormat();
                if (format != null && (format instanceof IjkMediaFormat)) {
                    iTrackInfoArr = trackInfo;
                    i3 = length;
                    if (trackType == 1) {
                        Boolean bool2 = Boolean.TRUE;
                        this.s0 = bool2;
                        if (!this.p0.booleanValue()) {
                            this.p0 = bool2;
                            RadioButton radioButton = new RadioButton(this.f0);
                            radioButton.setText("Disable");
                            radioButton.setTextColor(getResources().getColor(a7.c.G));
                            radioButton.setTextSize(13.0f);
                            radioButton.setId(11111111);
                            radioButton.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                            radioButton.setPadding(0, 0, 16, 0);
                            radioButton.setOnFocusChangeListener(new x(radioButton));
                            if (d2 == -1) {
                                radioButton.setChecked(true);
                                radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton.setTag("2");
                            radioGroup.addView(radioButton);
                        }
                        RadioButton radioButton2 = new RadioButton(this.f0);
                        iTrackInfo.getInfoInline();
                        radioButton2.setText(i6 + ", " + iTrackInfo.getInfoInline());
                        if (i6 == -1) {
                            radioButton2.setId(111);
                        } else {
                            radioButton2.setId(i6);
                        }
                        radioButton2.setTextColor(getResources().getColor(a7.c.G));
                        radioButton2.setTextSize(13.0f);
                        radioButton2.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                        radioButton2.setPadding(0, 0, 16, 0);
                        radioButton2.setOnFocusChangeListener(new x(radioButton2));
                        if (i6 == d2) {
                            radioButton2.setChecked(true);
                            radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton2.setTag("2");
                        radioGroup.addView(radioButton2);
                        radioGroup.setOnCheckedChangeListener(new i(d2));
                        i4++;
                        i5 = i6;
                        trackInfo = iTrackInfoArr;
                    } else if (trackType == 2) {
                        Boolean bool3 = Boolean.TRUE;
                        this.t0 = bool3;
                        if (!this.q0.booleanValue()) {
                            this.q0 = bool3;
                            RadioButton radioButton3 = new RadioButton(this.f0);
                            radioButton3.setText("Disable");
                            radioButton3.setTextColor(getResources().getColor(a7.c.G));
                            radioButton3.setTextSize(13.0f);
                            radioButton3.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                            radioButton3.setId(1111111);
                            radioButton3.setPadding(0, 0, 16, 0);
                            radioButton3.setOnFocusChangeListener(new x(radioButton3));
                            if (d3 == -1) {
                                radioButton3.setChecked(true);
                                radioGroup2.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton3.setTag("2");
                            radioGroup2.addView(radioButton3);
                        }
                        RadioButton radioButton4 = new RadioButton(this.f0);
                        radioButton4.setText(i6 + ", " + iTrackInfo.getInfoInline() + ", " + d1(iTrackInfo.getLanguage()));
                        radioButton4.setTextColor(getResources().getColor(a7.c.G));
                        radioButton4.setTextSize(13.0f);
                        radioButton4.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                        if (i6 == -1) {
                            radioButton4.setId(1111);
                        } else {
                            radioButton4.setId(i6);
                        }
                        radioButton4.setPadding(0, 0, 16, 0);
                        radioButton4.setOnFocusChangeListener(new x(radioButton4));
                        if (i6 == d3) {
                            radioButton4.setChecked(true);
                            radioGroup2.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton4.setTag("2");
                        radioGroup2.addView(radioButton4);
                        radioGroup2.setOnCheckedChangeListener(new j(d3));
                    } else if (trackType == 3) {
                        Boolean bool4 = Boolean.TRUE;
                        this.u0 = bool4;
                        if (!this.r0.booleanValue()) {
                            this.r0 = bool4;
                            RadioButton radioButton5 = new RadioButton(this.f0);
                            radioButton5.setText("Disable");
                            radioButton5.setTextColor(getResources().getColor(a7.c.G));
                            radioButton5.setTextSize(13.0f);
                            radioButton5.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                            radioButton5.setId(111111);
                            radioButton5.setPadding(0, 0, 16, 0);
                            radioButton5.setOnFocusChangeListener(new x(radioButton5));
                            if (d4 == -1) {
                                radioButton5.setChecked(true);
                                radioGroup3.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton5.setTag("2");
                            radioGroup3.addView(radioButton5);
                        }
                        RadioButton radioButton6 = new RadioButton(this.f0);
                        radioButton6.setText(i6 + ", " + iTrackInfo.getInfoInline());
                        radioButton6.setTextColor(getResources().getColor(a7.c.G));
                        radioButton6.setTextSize(13.0f);
                        radioButton6.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                        if (i6 == -1) {
                            radioButton6.setId(11111);
                        } else {
                            radioButton6.setId(i6);
                        }
                        radioButton6.setPadding(0, 0, 16, 0);
                        radioButton6.setOnFocusChangeListener(new x(radioButton6));
                        if (i6 == d4) {
                            radioButton6.setChecked(true);
                            radioGroup3.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton6.setTag("2");
                        radioGroup3.addView(radioButton6);
                        radioGroup3.setOnCheckedChangeListener(new l(d4));
                    }
                } else {
                    iTrackInfoArr = trackInfo;
                    i3 = length;
                }
                i4++;
                i5 = i6;
                trackInfo = iTrackInfoArr;
            }
            if (this.s0.booleanValue()) {
                i2 = 0;
                textView.setVisibility(8);
            } else {
                i2 = 0;
                textView.setVisibility(0);
            }
            if (this.t0.booleanValue()) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(i2);
            }
            if (this.u0.booleanValue()) {
                textView3.setVisibility(8);
                return;
            }
            textView5 = textView3;
        }
        textView5.setVisibility(i2);
    }
}

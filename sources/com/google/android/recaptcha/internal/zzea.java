package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.math.RoundingMode;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class zzea extends zzeb {
    final zzdw zzb;
    final Character zzc;

    public zzea(zzdw zzdwVar, Character ch) {
        this.zzb = zzdwVar;
        if (ch != null && zzdwVar.zzd('=')) {
            throw new IllegalArgumentException(zzdl.zza("Padding character %s was already in alphabet", ch));
        }
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzea) {
            zzea zzeaVar = (zzea) obj;
            if (this.zzb.equals(zzeaVar.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zzeaVar.zzc;
                if (ch == ch2) {
                    return true;
                }
                if (ch != null && ch.equals(ch2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzb.hashCode();
        Character ch = this.zzc;
        return hashCode ^ (ch == null ? 0 : ch.hashCode());
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                str = ".omitPadding()";
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                str = "')";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public int zza(byte[] bArr, CharSequence charSequence) throws zzdz {
        zzdw zzdwVar;
        bArr.getClass();
        CharSequence zze = zze(charSequence);
        if (!this.zzb.zzc(zze.length())) {
            throw new zzdz("Invalid input length " + zze.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < zze.length()) {
            long j = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                zzdwVar = this.zzb;
                if (i3 >= zzdwVar.zzc) {
                    break;
                }
                j <<= zzdwVar.zzb;
                if (i + i3 < zze.length()) {
                    j |= this.zzb.zzb(zze.charAt(i4 + i));
                    i4++;
                }
                i3++;
            }
            int i5 = zzdwVar.zzd;
            int i6 = i5 * 8;
            int i7 = i4 * zzdwVar.zzb;
            int i8 = (i5 - 1) * 8;
            while (i8 >= i6 - i7) {
                bArr[i2] = (byte) ((j >>> i8) & 255);
                i8 -= 8;
                i2++;
            }
            i += this.zzb.zzc;
        }
        return i2;
    }

    public void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzdi.zzd(0, i2, bArr.length);
        while (i3 < i2) {
            zzf(appendable, bArr, i3, Math.min(this.zzb.zzd, i2 - i3));
            i3 += this.zzb.zzd;
        }
    }

    public final int zzc(int i) {
        return (int) (((this.zzb.zzb * i) + 7) / 8);
    }

    public final int zzd(int i) {
        zzdw zzdwVar = this.zzb;
        return zzdwVar.zzc * zzed.zza(i, zzdwVar.zzd, RoundingMode.CEILING);
    }

    public final CharSequence zze(CharSequence charSequence) {
        charSequence.getClass();
        if (this.zzc == null) {
            return charSequence;
        }
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }

    public final void zzf(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzdi.zzd(i, i + i2, bArr.length);
        int i3 = 0;
        zzdi.zza(i2 <= this.zzb.zzd);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | (bArr[i + i4] & 255)) << 8;
        }
        int i5 = ((i2 + 1) * 8) - this.zzb.zzb;
        while (i3 < i2 * 8) {
            zzdw zzdwVar = this.zzb;
            appendable.append(zzdwVar.zza(zzdwVar.zza & ((int) (j >>> (i5 - i3)))));
            i3 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i3 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i3 += this.zzb.zzb;
            }
        }
    }

    public zzea(String str, String str2, Character ch) {
        this(new zzdw(str, str2.toCharArray()), ch);
    }
}

package com.netflix.hawkins.consumer.tokens;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import p000o.C30361nWh;
import p000o.nYA;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.netflix.hawkins.consumer.tokens.Appearance[], still in use, count: 1, list:
  (r0v1 com.netflix.hawkins.consumer.tokens.Appearance[]) from 0x001a: INVOKE (r0v1 com.netflix.hawkins.consumer.tokens.Appearance[]) STATIC call: kotlin.enums.EnumEntriesKt.b(java.lang.Enum[]):o.nYA A[MD:(java.lang.Enum[]):o.nYA (m), WRAPPED] (LINE:27)
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003"}, d2 = {"Lcom/netflix/hawkins/consumer/tokens/Appearance;", "", "Dark", "Light"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Appearance {
    Dark,
    Light;

    private static final /* synthetic */ nYA $ENTRIES;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[Appearance.values().length];
            try {
                iArr[Appearance.Light.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Appearance.Dark.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            c = iArr;
        }
    }

    public static nYA b() {
        return $ENTRIES;
    }

    public static Appearance[] values() {
        return (Appearance[]) $VALUES.clone();
    }

    public final Appearance c() {
        int i = a.c[ordinal()];
        if (i == 1) {
            return Dark;
        }
        if (i == 2) {
            return Light;
        }
        C30361nWh.a();
        return null;
    }

    public static Appearance valueOf(String str) {
        return (Appearance) Enum.valueOf(Appearance.class, str);
    }

    static {
        $ENTRIES = EnumEntriesKt.b(appearanceArr);
    }

    private Appearance() {
        super(str, i);
    }
}

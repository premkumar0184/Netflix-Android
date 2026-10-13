package com.netflix.hawkins.consumer.component.button;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import p000o.nYA;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.netflix.hawkins.consumer.component.button.HawkinsButtonType[], still in use, count: 1, list:
  (r0v1 com.netflix.hawkins.consumer.component.button.HawkinsButtonType[]) from 0x0042: INVOKE (r0v1 com.netflix.hawkins.consumer.component.button.HawkinsButtonType[]) STATIC call: kotlin.enums.EnumEntriesKt.b(java.lang.Enum[]):o.nYA A[MD:(java.lang.Enum[]):o.nYA (m), WRAPPED] (LINE:67)
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
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007"}, d2 = {"Lcom/netflix/hawkins/consumer/component/button/HawkinsButtonType;", "", "Primary", "Secondary", "Tertiary", "Supplemental", "Brand", "Destructive"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class HawkinsButtonType {
    Primary,
    Secondary,
    Tertiary,
    Supplemental,
    Brand,
    Destructive;

    private static final /* synthetic */ nYA $ENTRIES;

    public static nYA a() {
        return $ENTRIES;
    }

    public static HawkinsButtonType[] values() {
        return (HawkinsButtonType[]) $VALUES.clone();
    }

    public static HawkinsButtonType valueOf(String str) {
        return (HawkinsButtonType) Enum.valueOf(HawkinsButtonType.class, str);
    }

    static {
        $ENTRIES = EnumEntriesKt.b(hawkinsButtonTypeArr);
    }

    private HawkinsButtonType() {
        super(str, i);
    }
}

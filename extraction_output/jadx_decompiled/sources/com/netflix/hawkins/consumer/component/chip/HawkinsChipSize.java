package com.netflix.hawkins.consumer.component.chip;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import p000o.nYA;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.netflix.hawkins.consumer.component.chip.HawkinsChipSize[], still in use, count: 1, list:
  (r0v1 com.netflix.hawkins.consumer.component.chip.HawkinsChipSize[]) from 0x001a: INVOKE (r0v1 com.netflix.hawkins.consumer.component.chip.HawkinsChipSize[]) STATIC call: kotlin.enums.EnumEntriesKt.b(java.lang.Enum[]):o.nYA A[MD:(java.lang.Enum[]):o.nYA (m), WRAPPED] (LINE:27)
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003"}, d2 = {"Lcom/netflix/hawkins/consumer/component/chip/HawkinsChipSize;", "", "Small", "Standard"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class HawkinsChipSize {
    Small,
    Standard;

    private static final /* synthetic */ nYA $ENTRIES;

    public static nYA b() {
        return $ENTRIES;
    }

    public static HawkinsChipSize[] values() {
        return (HawkinsChipSize[]) $VALUES.clone();
    }

    public static HawkinsChipSize valueOf(String str) {
        return (HawkinsChipSize) Enum.valueOf(HawkinsChipSize.class, str);
    }

    static {
        $ENTRIES = EnumEntriesKt.b(hawkinsChipSizeArr);
    }

    private HawkinsChipSize() {
        super(str, i);
    }
}

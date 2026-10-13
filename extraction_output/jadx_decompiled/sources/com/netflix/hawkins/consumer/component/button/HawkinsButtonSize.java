package com.netflix.hawkins.consumer.component.button;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import p000o.nYA;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.netflix.hawkins.consumer.component.button.HawkinsButtonSize[], still in use, count: 1, list:
  (r0v1 com.netflix.hawkins.consumer.component.button.HawkinsButtonSize[]) from 0x002a: INVOKE (r0v1 com.netflix.hawkins.consumer.component.button.HawkinsButtonSize[]) STATIC call: kotlin.enums.EnumEntriesKt.b(java.lang.Enum[]):o.nYA A[MD:(java.lang.Enum[]):o.nYA (m), WRAPPED] (LINE:43)
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t"}, d2 = {"Lcom/netflix/hawkins/consumer/component/button/HawkinsButtonSize;", "", "Lo/bah;", "iconSize", "F", "getIconSize-D9Ej5fM$com_netflix_hawkins_kotlin_hawkins_components", "()F", "Small", "Standard", "Large"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class HawkinsButtonSize {
    Small(16.0f),
    Standard(24.0f),
    Large(36.0f);

    private static final /* synthetic */ nYA $ENTRIES;
    private final float iconSize;

    private HawkinsButtonSize(float f) {
        super(str, i);
        this.iconSize = f;
    }

    public static nYA d() {
        return $ENTRIES;
    }

    public static HawkinsButtonSize[] values() {
        return (HawkinsButtonSize[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM$com_netflix_hawkins_kotlin_hawkins_components, reason: not valid java name and from getter */
    public final float getIconSize() {
        return this.iconSize;
    }

    public static HawkinsButtonSize valueOf(String str) {
        return (HawkinsButtonSize) Enum.valueOf(HawkinsButtonSize.class, str);
    }

    static {
        $ENTRIES = EnumEntriesKt.b(hawkinsButtonSizeArr);
    }
}

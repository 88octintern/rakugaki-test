package com.example.rakugaki;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/example/rakugaki/RakugakiTapEvent;", "", "event", "Lcom/example/rakugaki/RakugakiTapEvent$RakugakiEvent;", "view", "Landroid/view/View;", "(Lcom/example/rakugaki/RakugakiTapEvent$RakugakiEvent;Landroid/view/View;)V", "getEvent", "()Lcom/example/rakugaki/RakugakiTapEvent$RakugakiEvent;", "getView", "()Landroid/view/View;", "RakugakiEvent", "rakugaki_release"})
public final class RakugakiTapEvent {
    @org.jetbrains.annotations.NotNull()
    private final com.example.rakugaki.RakugakiTapEvent.RakugakiEvent event = null;
    @org.jetbrains.annotations.NotNull()
    private final android.view.View view = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.rakugaki.RakugakiTapEvent.RakugakiEvent getEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getView() {
        return null;
    }
    
    public RakugakiTapEvent(@org.jetbrains.annotations.NotNull()
    com.example.rakugaki.RakugakiTapEvent.RakugakiEvent event, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/rakugaki/RakugakiTapEvent$RakugakiEvent;", "", "(Ljava/lang/String;I)V", "DRAGGING", "RELEASED", "rakugaki_release"})
    public static enum RakugakiEvent {
        /*public static final*/ DRAGGING /* = new DRAGGING() */,
        /*public static final*/ RELEASED /* = new RELEASED() */;
        
        RakugakiEvent() {
        }
    }
}
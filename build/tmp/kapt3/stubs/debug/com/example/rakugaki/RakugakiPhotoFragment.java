package com.example.rakugaki;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J(\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0017J\b\u0010\"\u001a\u00020\u0011H\u0016J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010$\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/example/rakugaki/RakugakiPhotoFragment;", "Lcom/example/rakugaki/BaseFragment;", "()V", "bgImgView", "Landroid/widget/ImageView;", "binding", "error/NonExistentClass", "getBinding", "()Lerror/NonExistentClass;", "setBinding", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "rakugaki", "Lcom/example/rakugaki/RakugakiCore;", "viewModel", "Lcom/example/rakugaki/PhotoEditViewModel;", "initView", "", "onClickCancel", "view", "Landroid/view/View;", "onClickDone", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "onRakugakiTapEvent", "event", "Lcom/example/rakugaki/RakugakiTapEvent;", "onResume", "saveImageAndDone", "setParams", "Companion", "rakugaki_debug"})
public final class RakugakiPhotoFragment extends com.example.rakugaki.BaseFragment {
    @org.jetbrains.annotations.NotNull()
    public error.NonExistentClass binding;
    private com.example.rakugaki.RakugakiCore rakugaki;
    private android.widget.ImageView bgImgView;
    private com.example.rakugaki.PhotoEditViewModel viewModel;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EXTRA_RAKUGAKI_PHOTO = "extra_rakugaki_photo";
    public static final com.example.rakugaki.RakugakiPhotoFragment.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final error.NonExistentClass getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    error.NonExistentClass p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.Nullable()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initView() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    private final void setParams() {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onRakugakiTapEvent(@org.jetbrains.annotations.NotNull()
    com.example.rakugaki.RakugakiTapEvent event) {
    }
    
    public final void onClickDone(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onClickCancel(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void saveImageAndDone(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public RakugakiPhotoFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/example/rakugaki/RakugakiPhotoFragment$Companion;", "", "()V", "EXTRA_RAKUGAKI_PHOTO", "", "getEXTRA_RAKUGAKI_PHOTO", "()Ljava/lang/String;", "newInstance", "Lcom/example/rakugaki/RakugakiPhotoFragment;", "url", "rakugaki_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEXTRA_RAKUGAKI_PHOTO() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.rakugaki.RakugakiPhotoFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String url) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
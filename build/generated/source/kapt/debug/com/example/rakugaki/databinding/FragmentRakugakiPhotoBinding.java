package com.example.rakugaki.databinding;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
public abstract class FragmentRakugakiPhotoBinding extends ViewDataBinding {
    public final android.widget.LinearLayout buttons;
    public final android.widget.ImageButton charactableBtn;
    public final android.widget.LinearLayout colorPalette;
    public final android.widget.FrameLayout container;
    public final android.widget.LinearLayout delete;
    public final android.widget.LinearLayout deleteArea;
    public final android.widget.ImageView deleteImage;
    public final android.widget.TextView deleteText;
    public final android.widget.ImageView imageView;
    public final android.widget.ImageButton pentable;
    public final android.widget.Button saveBtn;
    public final android.widget.ScrollView scrollview;
    // variables
    protected com.example.rakugaki.RakugakiPhotoFragment mFragment;
    protected com.example.rakugaki.PhotoEditViewModel mViewModel;
    protected FragmentRakugakiPhotoBinding(android.databinding.DataBindingComponent bindingComponent, android.view.View root_, int localFieldCount
        , android.widget.LinearLayout buttons
        , android.widget.ImageButton charactableBtn
        , android.widget.LinearLayout colorPalette
        , android.widget.FrameLayout container
        , android.widget.LinearLayout delete
        , android.widget.LinearLayout deleteArea
        , android.widget.ImageView deleteImage
        , android.widget.TextView deleteText
        , android.widget.ImageView imageView
        , android.widget.ImageButton pentable
        , android.widget.Button saveBtn
        , android.widget.ScrollView scrollview
    ) {
        super(bindingComponent, root_, localFieldCount);
        this.buttons = buttons;
        this.charactableBtn = charactableBtn;
        this.colorPalette = colorPalette;
        this.container = container;
        this.delete = delete;
        this.deleteArea = deleteArea;
        this.deleteImage = deleteImage;
        this.deleteText = deleteText;
        this.imageView = imageView;
        this.pentable = pentable;
        this.saveBtn = saveBtn;
        this.scrollview = scrollview;
    }
    //getters and abstract setters
    public abstract void setFragment(com.example.rakugaki.RakugakiPhotoFragment Fragment);
    public com.example.rakugaki.RakugakiPhotoFragment getFragment() {
        return mFragment;
    }
    public abstract void setViewModel(com.example.rakugaki.PhotoEditViewModel ViewModel);
    public com.example.rakugaki.PhotoEditViewModel getViewModel() {
        return mViewModel;
    }
    public static FragmentRakugakiPhotoBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentRakugakiPhotoBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentRakugakiPhotoBinding bind(android.view.View view) {
        return null;
    }
    public static FragmentRakugakiPhotoBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
    public static FragmentRakugakiPhotoBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
    public static FragmentRakugakiPhotoBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
}
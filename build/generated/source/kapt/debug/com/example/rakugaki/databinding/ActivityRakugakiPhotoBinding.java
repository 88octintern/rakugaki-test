package com.example.rakugaki.databinding;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
public abstract class ActivityRakugakiPhotoBinding extends ViewDataBinding {
    public final android.widget.FrameLayout contentView;
    public final android.widget.Button rakugakiPhotoCancel;
    public final android.widget.Button rakugakiPhotoDone;
    public final android.support.v7.widget.Toolbar toolbar;
    // variables
    protected com.example.rakugaki.RakugakiPhotoActivity mActivity;
    protected ActivityRakugakiPhotoBinding(android.databinding.DataBindingComponent bindingComponent, android.view.View root_, int localFieldCount
        , android.widget.FrameLayout contentView
        , android.widget.Button rakugakiPhotoCancel
        , android.widget.Button rakugakiPhotoDone
        , android.support.v7.widget.Toolbar toolbar
    ) {
        super(bindingComponent, root_, localFieldCount);
        this.contentView = contentView;
        this.rakugakiPhotoCancel = rakugakiPhotoCancel;
        this.rakugakiPhotoDone = rakugakiPhotoDone;
        this.toolbar = toolbar;
    }
    //getters and abstract setters
    public abstract void setActivity(com.example.rakugaki.RakugakiPhotoActivity Activity);
    public com.example.rakugaki.RakugakiPhotoActivity getActivity() {
        return mActivity;
    }
    public static ActivityRakugakiPhotoBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityRakugakiPhotoBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityRakugakiPhotoBinding bind(android.view.View view) {
        return null;
    }
    public static ActivityRakugakiPhotoBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
    public static ActivityRakugakiPhotoBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
    public static ActivityRakugakiPhotoBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
}
package com.example.rakugaki;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2 = {"Lcom/example/rakugaki/BaseActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "hideToolbar", "", "initBackToolbar", "toolbar", "Landroid/support/v7/widget/Toolbar;", "initTopToolbar", "replaceFragment", "fragment", "Landroid/support/v4/app/Fragment;", "layoutResId", "", "rakugaki_release"})
public abstract class BaseActivity extends android.support.v7.app.AppCompatActivity {
    
    public final void initBackToolbar(@org.jetbrains.annotations.Nullable()
    android.support.v7.widget.Toolbar toolbar) {
    }
    
    public final void replaceFragment(@org.jetbrains.annotations.Nullable()
    android.support.v4.app.Fragment fragment, @android.support.annotation.LayoutRes()
    @android.support.annotation.IdRes()
    int layoutResId) {
    }
    
    public final void hideToolbar() {
    }
    
    public final void initTopToolbar(@org.jetbrains.annotations.Nullable()
    android.support.v7.widget.Toolbar toolbar) {
    }
    
    public BaseActivity() {
        super();
    }
}
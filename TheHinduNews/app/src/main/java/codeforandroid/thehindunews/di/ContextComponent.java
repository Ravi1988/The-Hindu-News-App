package codeforandroid.thehindunews.di;

import codeforandroid.thehindunews.view.NewsDetaileFragment;
import codeforandroid.thehindunews.view.MainActivity;
import dagger.Subcomponent;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */
@Subcomponent(modules = ContextModule.class)
public interface ContextComponent {
	void inject(MainActivity mainActivity);
	void inject(NewsDetaileFragment mainActivity);
}

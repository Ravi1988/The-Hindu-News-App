package codeforandroid.thehindunews.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

	ContextComponent plus(ContextModule contextModule);
}

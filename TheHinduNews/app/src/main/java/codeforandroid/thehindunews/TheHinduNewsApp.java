package codeforandroid.thehindunews;

import android.app.Application;

import codeforandroid.thehindunews.di.AppComponent;
import codeforandroid.thehindunews.di.AppModule;
import codeforandroid.thehindunews.di.DaggerAppComponent;

/**
 * Created by ravi.sharma01 on 1/28/18.
 */

public class TheHinduNewsApp extends Application{


	private AppComponent appComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		initAppComponent();
	}

	private void initAppComponent() {
		appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
	}

	public AppComponent getAppComponent(){
		return appComponent;
	}
}

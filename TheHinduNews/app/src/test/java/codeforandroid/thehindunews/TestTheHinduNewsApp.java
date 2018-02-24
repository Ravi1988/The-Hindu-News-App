package codeforandroid.thehindunews;

import codeforandroid.thehindunews.di.AppComponent;
import codeforandroid.thehindunews.di.AppModule;
import codeforandroid.thehindunews.di.DaggerAppComponent;

/**
 * Created by ravi.sharma01 on 2/24/18.
 */

public class TestTheHinduNewsApp extends TheHinduNewsApp{

	AppComponent appComponent;
	@Override
	public AppComponent getAppComponent() {
		if(appComponent == null){
			appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
		}

		return super.getAppComponent();
	}
}

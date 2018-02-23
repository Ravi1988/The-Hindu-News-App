package codeforandroid.thehindunews.util;

import android.support.v4.app.FragmentActivity;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */

public class DefaultNavigator implements Navigator{

	private final FragmentActivity activity;

	public DefaultNavigator(FragmentActivity activity){
		this.activity = activity;
	}

	@Override
	public void openNewsDetailPage() {

	}
}

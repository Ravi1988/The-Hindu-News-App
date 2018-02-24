package codeforandroid.thehindunews;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ravi.sharma01 on 2/24/18.
 */

public class BaseTest {

	@BeforeClass
	public static void setupRx(){
		RxAndroidPlugins.setInitMainThreadSchedulerHandler(e -> Schedulers.trampoline());
	}

	@AfterClass
	public static void tearRx(){
		RxAndroidPlugins.reset();
	}
}

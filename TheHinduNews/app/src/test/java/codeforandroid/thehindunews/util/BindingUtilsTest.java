package codeforandroid.thehindunews.util;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ImageView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import codeforandroid.thehindunews.BaseTest;
import codeforandroid.thehindunews.BuildConfig;
import codeforandroid.thehindunews.model.News.Article;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by ravi.sharma01 on 2/24/18.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class BindingUtilsTest extends BaseTest{

	@Mock
	ImageView imageView;

	@Mock
	SwipeRefreshLayout swipeRefreshLayout;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldLoadImageInImageView(){
		Article article = MockData.getArticle();
		BindingUtils.setImageUrl(imageView,article.getUrlToImage());
		verify(imageView).setImageBitmap(any());
	}

	@Test
	public void shouldSetLoaderInView(){
		boolean isLoading = true;
		BindingUtils.swipeLoader(swipeRefreshLayout, isLoading);
		verify(swipeRefreshLayout).setRefreshing(isLoading);
	}



}

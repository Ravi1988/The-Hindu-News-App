package codeforandroid.thehindunews.viewmodel;

import android.accounts.NetworkErrorException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import codeforandroid.thehindunews.BaseTest;
import codeforandroid.thehindunews.model.News;
import codeforandroid.thehindunews.repo.NewsItemRepo;
import codeforandroid.thehindunews.util.MockData;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ravi.sharma01 on 2/24/18.
 */

public class TestNewsItemListViewModel extends BaseTest{

	@Mock
	private NewsItemRepo newsitemRepo;
	private NewsItemListViewModel newsItemViewModel;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		newsItemViewModel = new NewsItemListViewModel(newsitemRepo);
	}

	@Test
	public void shouldLoadNewsFromNetwork(){
		News news = MockData.getMockNews();

		when(newsitemRepo.getTopStories()).thenReturn(Observable.just(news));

		newsItemViewModel.loadNews();

		verify(newsitemRepo).getTopStories();
		assertEquals(news.getArticles().size(),newsItemViewModel.getArticles().size());
	}

	@Test
	public void shouldShowProgressWhenApiInAir(){

		News news = MockData.getMockNews();
		BehaviorSubject<News> subject = BehaviorSubject.create();
		when(newsitemRepo.getTopStories()).thenReturn(subject);
		newsItemViewModel.loadNews();

		assertTrue(newsItemViewModel.getShowProgressBar().get());

		subject.onNext(news);
		subject.onComplete();

		assertFalse(newsItemViewModel.getShowProgressBar().get());
	}

	@Test
	public void shouldShowErrorIfRequestFailed(){
		Observable<News> error = Observable.error(new NetworkErrorException());
		when(newsitemRepo.getTopStories()).thenReturn(error);

		newsItemViewModel.loadNews();

		assertTrue(newsItemViewModel.getIsShowError().get());
		assertFalse(newsItemViewModel.getShowProgressBar().get());

	}
}

package codeforandroid.thehindunews.repo;

import codeforandroid.thehindunews.model.News;
import codeforandroid.thehindunews.network.TheHinduNewsApiService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public class NewsItemRepoImpl implements NewsItemRepo{

	private final TheHinduNewsApiService apiService;

	public NewsItemRepoImpl(TheHinduNewsApiService apiService){
		this.apiService = apiService;
	}

	@Override
	public Observable<News> getTopStories() {
		return apiService.getTopStories("950a93ff3c884c77a7b84a79fa6dfaa3").
		subscribeOn(Schedulers.io())
		.observeOn(AndroidSchedulers.mainThread())
		.doOnNext(new Consumer<News>() {
			@Override
			public void accept(News news) throws Exception {
				//add caching
			}
		});
	}

}

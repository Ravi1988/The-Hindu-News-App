package codeforandroid.thehindunews.network;

import codeforandroid.thehindunews.model.News;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public interface TheHinduNewsApiService {
	@GET("v2/top-headlines?sources=the-hindu")
	Observable<News> getTopStories(@Query("apiKey") String apiKey);
}

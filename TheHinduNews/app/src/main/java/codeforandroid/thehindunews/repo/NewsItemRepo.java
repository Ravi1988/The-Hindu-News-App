package codeforandroid.thehindunews.repo;


import codeforandroid.thehindunews.model.News;
import io.reactivex.Observable;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public interface NewsItemRepo {

	Observable<News> getTopStories();
}

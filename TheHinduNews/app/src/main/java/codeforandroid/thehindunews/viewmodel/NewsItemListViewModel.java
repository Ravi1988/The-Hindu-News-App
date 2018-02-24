package codeforandroid.thehindunews.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import javax.inject.Inject;

import codeforandroid.thehindunews.model.News;
import codeforandroid.thehindunews.model.News.Article;
import codeforandroid.thehindunews.repo.NewsItemRepo;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ravi.sharma01 on 1/29/18.
 */

public class NewsItemListViewModel {

	private final NewsItemRepo newsItemRepo;
	private ObservableField<Boolean> showProgressBar;
	private ObservableField<Boolean> showError;

	private ObservableField<News> newsItem;
	private ObservableField<Article> article;
	private ObservableList<Article> articles;

	@Inject
	public NewsItemListViewModel(NewsItemRepo newsItemRepo) {
		showProgressBar = new ObservableField<>(false);
		showError = new ObservableField<>(false);
		newsItem = new ObservableField<>();
		article = new ObservableField<>();
		articles = new ObservableArrayList<>();

		this.newsItemRepo = newsItemRepo;
	}


	public void loadNews(){
		showProgress();
		newsItemRepo.getTopStories().subscribe(new Observer<News>() {
			@Override
			public void onSubscribe(Disposable d) {

			}

			@Override
			public void onNext(News news) {
				newsItem.set(news);
				articles.clear();
				articles.addAll(news.getArticles());
				showError.set(false);
				hideProgress();
			}

			@Override
			public void onError(Throwable e) {
				hideProgress();
				showError.set(true);
			}

			@Override
			public void onComplete() {
				hideProgress();
			}
		});
	}

	private void hideProgress() {
		showProgressBar.set(false);
	}

	private void showProgress() {
		showProgressBar.set(true);
	}

	public ObservableField<Boolean> getShowProgressBar() {
		return showProgressBar;
	}

	public ObservableField<Boolean> getIsShowError() {
		return showError;
	}

	public ObservableField<News> getNewsItem() {
		return newsItem;
	}

	public ObservableField<Article> getArticle() {
		return article;
	}

	public void setArticle(Article value){
		article.set(value);
	}
	public ObservableList<Article> getArticles() {
		return articles;
	}
}

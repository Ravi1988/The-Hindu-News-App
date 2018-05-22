package codeforandroid.thehindunews.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import javax.inject.Inject;

import codeforandroid.thehindunews.BR;
import codeforandroid.thehindunews.model.News.Article;
import codeforandroid.thehindunews.util.Navigator;

/**
 * Created by ravi.sharma01 on 2/24/18.
 */

public class ArticleViewModel extends BaseObservable {

	private final Navigator navigator;
	private int pos;
	private Article article;

	@Inject
	public ArticleViewModel(Navigator navigator) {
		this.navigator = navigator;
	}

	@Bindable
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
		notifyPropertyChanged(BR.article);
	}

	public void openNewsDetail() {
		if (article != null) {
			navigator.openNewsDetailPage(getPos());
		}
	}

	@Bindable
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
		notifyPropertyChanged(BR.pos);
	}
}

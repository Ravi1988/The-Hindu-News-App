package codeforandroid.thehindunews.viewmodel;

import android.databinding.ObservableField;

import javax.inject.Inject;

import codeforandroid.thehindunews.model.News.Article;
import codeforandroid.thehindunews.util.Navigator;

/**
 * Created by ravi.sharma01 on 2/24/18.
 */

public class ArticleViewModel{

	private final Navigator navigator;
	private int pos;
	private ObservableField<Article> article;

	@Inject
	public ArticleViewModel(Navigator navigator){
		this.article = new ObservableField<>();
		this.navigator = navigator;
	}

	public Article getArticle() {
		return article.get();
	}

	public void setArticle(Article article) {
		this.article.set(article);
	}

	public void openNewsDetail(){
		if(article.get() != null) {
			navigator.openNewsDetailPage(getPos());
		}
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
}

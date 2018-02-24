package codeforandroid.thehindunews.util;

import java.util.ArrayList;
import java.util.Arrays;

import codeforandroid.thehindunews.model.News;
import codeforandroid.thehindunews.model.News.Article;

/**
 * Created by ravi.sharma01 on 2/24/18.
 */

public class MockData {

	public static News getMockNews() {
		News news = new News();
		news.setArticles(getArticles());
		return news;
	}

	public static ArrayList<Article> getArticles() {
		return new ArrayList<>(Arrays.asList(getArticle(), getArticle(), getArticle()));
	}

	public static Article getArticle() {
		Article article = new Article();
		article.setTitle("Ravi is writing unit test :)");
		article.setAuthor("Ravi");
		article.setDescription("Ravi started learning mockito and junit with mvvm");
		article.setPublishedAt("20-20-18 18.20");
		article.setUrlToImage("http://www.thehindu.com/news/national/article22778825.ece/ALTERNATES/LANDSCAPE_615/MEHULCHOKSI");
		return article;
	}
}

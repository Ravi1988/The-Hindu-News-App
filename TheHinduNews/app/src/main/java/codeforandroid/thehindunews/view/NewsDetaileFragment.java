package codeforandroid.thehindunews.view;


import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import codeforandroid.thehindunews.BR;
import codeforandroid.thehindunews.R;
import codeforandroid.thehindunews.TheHinduNewsApp;
import codeforandroid.thehindunews.databinding.NewsDetailViewBinding;
import codeforandroid.thehindunews.di.AppComponent;
import codeforandroid.thehindunews.di.ContextModule;
import codeforandroid.thehindunews.model.News.Article;
import codeforandroid.thehindunews.viewmodel.ArticleViewModel;
import codeforandroid.thehindunews.viewmodel.NewsItemListViewModel;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */

public class NewsDetaileFragment extends DialogFragment {


	@Inject
	NewsItemListViewModel viewModel;

	@Inject
	ArticleViewModel articleViewModel;

	private int pos;
	private NewsDetailViewBinding bind;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		resolveDependency();
		pos = getArguments().getInt("position");
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		bind = DataBindingUtil.inflate(inflater,R.layout.news_detail_view,container,false);
		viewModel.getArticles().addOnListChangedCallback(itemChangedListener);
		viewModel.loadNews();
		return bind.getRoot();
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	private void resolveDependency() {
		AppComponent appComponent = ((TheHinduNewsApp)getActivity().getApplication()).getAppComponent();
		appComponent.plus(new ContextModule(getActivity()))
				.inject(this);
	}

	private final ObservableList.OnListChangedCallback<ObservableList<Article>> itemChangedListener = new ObservableList.OnListChangedCallback<ObservableList<Article>>() {
		@Override
		public void onChanged(ObservableList<Article> news) {

		}

		@Override
		public void onItemRangeChanged(ObservableList<Article> news, int start, int count) {

		}

		@Override
		public void onItemRangeInserted(ObservableList<Article> news, int start, int count) {
			articleViewModel.setArticle(news.get(pos));
			bind.setVariable(BR.vm,articleViewModel);
			bind.executePendingBindings();
		}

		@Override
		public void onItemRangeMoved(ObservableList<Article> news, int i, int i1, int i2) {
		}

		@Override
		public void onItemRangeRemoved(ObservableList<Article> news, int start, int count) {

		}
	};
}

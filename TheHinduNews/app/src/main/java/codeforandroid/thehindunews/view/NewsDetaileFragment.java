package codeforandroid.thehindunews.view;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
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
		Log.d("LifeCycleMethod","onCreate");
		resolveDependency();
		pos = getArguments().getInt("position");
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		Log.d("LifeCycleMethod","onCreateView");
		bind = DataBindingUtil.inflate(inflater,R.layout.news_detail_view,container,false);
		viewModel.getArticles().addOnListChangedCallback(itemChangedListener);
		viewModel.loadNews();
		return bind.getRoot();
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		Log.d("LifeCycleMethod","onViewCreated");
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
		Log.d("LifeCycleMethod","onViewStateRestored");
		super.onViewStateRestored(savedInstanceState);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		Log.d("LifeCycleMethod","onSaveInstanceState");
		super.onSaveInstanceState(outState);
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
			articleViewModel.openNewsDetail();
		}

		@Override
		public void onItemRangeMoved(ObservableList<Article> news, int i, int i1, int i2) {
		}

		@Override
		public void onItemRangeRemoved(ObservableList<Article> news, int start, int count) {

		}
	};

	@Override
	public void onStart() {
		Log.d("LifeCycleMethod","onStart");
		super.onStart();

	}

	@Override
	public void onResume() {
		Log.d("LifeCycleMethod","onResume");
		super.onResume();
	}

	@Override
	public void onDestroy() {
		Log.d("LifeCycleMethod","onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		Log.d("LifeCycleMethod","onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		Log.d("LifeCycleMethod","onDetach");
		super.onDetach();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.d("LifeCycleMethod","onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onAttach(Context context) {
		Log.d("LifeCycleMethod","onAttach");
		super.onAttach(context);
	}

	@Override
	public void onAttachFragment(Fragment childFragment) {
		Log.d("LifeCycleMethod","onAttachFragment");
		super.onAttachFragment(childFragment);
	}

	@Override
	public void onPause() {
		Log.d("LifeCycleMethod","onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		Log.d("LifeCycleMethod","onStop");
		super.onStop();
	}

}

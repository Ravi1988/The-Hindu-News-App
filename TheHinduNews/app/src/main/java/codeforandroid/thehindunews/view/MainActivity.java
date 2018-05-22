package codeforandroid.thehindunews.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import javax.inject.Inject;

import codeforandroid.thehindunews.R;
import codeforandroid.thehindunews.TheHinduNewsApp;
import codeforandroid.thehindunews.adapters.NewsAdapter;
import codeforandroid.thehindunews.databinding.NewsMainViewBinding;
import codeforandroid.thehindunews.di.AppComponent;
import codeforandroid.thehindunews.di.ContextModule;
import codeforandroid.thehindunews.viewmodel.NewsItemListViewModel;

public class MainActivity extends AppCompatActivity {

	@Inject
	NewsAdapter newsAdapter;

	@Inject
	NewsItemListViewModel viewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("ActivityLifeCycle","onCreate");
		super.onCreate(savedInstanceState);
		resolveDependency();
		NewsMainViewBinding binding = DataBindingUtil.setContentView(this, R.layout.news_main_view);
		binding.setVm(viewModel);
		newsAdapter.setData(viewModel.getArticles());
		viewModel.loadNews();
		RecyclerView rvList = (RecyclerView) findViewById(R.id.rvList);
		setupRv(rvList);
		SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
		setupSwipeLayout(refreshLayout);

	}

	private void resolveDependency() {
		AppComponent appComponent = ((TheHinduNewsApp)getApplication()).getAppComponent();
		appComponent.plus(new ContextModule(this))
		.inject(this);
	}

	private void setupSwipeLayout(SwipeRefreshLayout refreshLayout) {
		refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				viewModel.loadNews();
			}
		});
	}

	private void setupRv(RecyclerView rvList) {
		rvList.setAdapter(newsAdapter);
		rvList.setLayoutManager(new LinearLayoutManager(this));
		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
				DividerItemDecoration.VERTICAL);
		rvList.addItemDecoration(dividerItemDecoration);
	}

	@Override
	protected void onStart() {
		Log.d("ActivityLifeCycle","onStart");
		super.onStart();
	}

	@Override
	protected void onPause() {
		Log.d("ActivityLifeCycle","onPause");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.d("ActivityLifeCycle","onRestart");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.d("ActivityLifeCycle","onResume");
		super.onResume();
	}

	@Override
	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
		Log.d("ActivityLifeCycle","onSaveInstanceState");
		super.onSaveInstanceState(outState, outPersistentState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		Log.d("ActivityLifeCycle","onRestoreInstanceState");
		super.onRestoreInstanceState(savedInstanceState);
	}


	@Override
	public void onAttachFragment(android.support.v4.app.Fragment fragment) {
		Log.d("ActivityLifeCycle","onAttachFragment");
		super.onAttachFragment(fragment);
	}

	@Override
	protected void onDestroy() {
		Log.d("ActivityLifeCycle","onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onStop() {
		Log.d("ActivityLifeCycle","onStop");
		super.onStop();
	}
}

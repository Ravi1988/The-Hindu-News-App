package codeforandroid.thehindunews.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
}

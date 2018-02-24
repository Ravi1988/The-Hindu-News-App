package codeforandroid.thehindunews.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import javax.inject.Inject;

import codeforandroid.thehindunews.BR;
import codeforandroid.thehindunews.R;
import codeforandroid.thehindunews.model.News.Article;
import codeforandroid.thehindunews.util.Navigator;
import codeforandroid.thehindunews.viewmodel.ArticleViewModel;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

	private final Navigator navigator;
	private ObservableList<Article> data;

	@Inject
	public NewsAdapter(Navigator navigator){
		setHasStableIds(true);
		this.navigator = navigator;
	}

	@Override
	public long getItemId(int position) {
		return getData().get(position).getTitle().hashCode();
	}


	public void setData(ObservableList<Article> data){
		this.data = data;
		data.addOnListChangedCallback(itemChangedListener);
	}

	@Override
	public int getItemViewType(int position) {
		return R.layout.item_view;
	}

	@Override
	public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		ViewDataBinding binding = DataBindingUtil
				.inflate(LayoutInflater.from(parent.getContext()), viewType,
						parent, false);
		return new NewsViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(NewsViewHolder holder, int position) {
		holder.bindModel(getData().get(position));
	}
	@Override
	public int getItemCount() {
		return data == null ? 0 : data.size();
	}

	public ObservableList<Article> getData() {
		return data;
	}

	private final ObservableList.OnListChangedCallback<ObservableList<Article>> itemChangedListener = new ObservableList.OnListChangedCallback<ObservableList<Article>>() {
		@Override
		public void onChanged(ObservableList<Article> news) {

		}

		@Override
		public void onItemRangeChanged(ObservableList<Article> news, int start, int count) {
			notifyItemRangeChanged(start, count);
		}

		@Override
		public void onItemRangeInserted(ObservableList<Article> news, int start, int count) {
			notifyItemRangeInserted(start, count);
		}

		@Override
		public void onItemRangeMoved(ObservableList<Article> news, int i, int i1, int i2) {
		}

		@Override
		public void onItemRangeRemoved(ObservableList<Article> news, int start, int count) {
			notifyItemRangeRemoved(start, count);
		}
	};

	class NewsViewHolder extends RecyclerView.ViewHolder{

		private final ViewDataBinding binding;
		private ArticleViewModel viewModelArticle;

		NewsViewHolder(ViewDataBinding binding) {
			super(binding.getRoot());
			this.binding = binding;
			viewModelArticle = new ArticleViewModel(navigator);
			binding.setVariable(BR.vm, viewModelArticle);
		}

		void bindModel(Article article){
			viewModelArticle.setArticle(article);
			binding.executePendingBindings();
		}

	}
}

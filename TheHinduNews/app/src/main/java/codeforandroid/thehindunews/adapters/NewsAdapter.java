package codeforandroid.thehindunews.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

import codeforandroid.thehindunews.model.News.Article;
import codeforandroid.thehindunews.viewmodel.NewsItemListViewModel;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

	protected final NewsItemListViewModel newsItemListViewModel;
	private ArrayList<Article> data;

	@Inject
	public NewsAdapter(NewsItemListViewModel newsItemListViewModel){
		this.newsItemListViewModel = newsItemListViewModel;
	}

	public void setData(ArrayList<Article> data){
		this.data = data;
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
		bind(data.get(position));
	}

	private void bind(Article article){
		newsItemListViewModel.setArticle(article);
	}

	@Override
	public int getItemCount() {
		return data == null ? 0 : data.size();
	}

	public static class NewsViewHolder extends RecyclerView.ViewHolder{

		public NewsViewHolder(ViewDataBinding binding) {
			super(binding.getRoot());
		}

	}
}

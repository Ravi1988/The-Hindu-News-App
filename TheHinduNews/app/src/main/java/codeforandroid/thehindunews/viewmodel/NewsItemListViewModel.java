package codeforandroid.thehindunews.viewmodel;

import android.databinding.ObservableField;

import javax.inject.Inject;

/**
 * Created by ravi.sharma01 on 1/29/18.
 */

public class NewsItemListViewModel {

	private ObservableField<Boolean> showProgressBar;
	private ObservableField<Boolean> isShowError;

	@Inject
	public void NewsItemListViewModel() {
		showProgressBar = new ObservableField<>(false);
		isShowError = new ObservableField<>(false);
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
		return isShowError;
	}
}

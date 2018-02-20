package codeforandroid.thehindunews.util;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public class BindingUtils {
	@BindingAdapter("bind:isLoading")
	public static void swipeLoader(SwipeRefreshLayout layout, boolean isLoading) {
		layout.setRefreshing(isLoading);
	}
}

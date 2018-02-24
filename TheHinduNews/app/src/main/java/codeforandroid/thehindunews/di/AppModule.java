package codeforandroid.thehindunews.di;

import javax.inject.Singleton;

import codeforandroid.thehindunews.network.TheHinduNewsApiService;
import codeforandroid.thehindunews.repo.NewsItemRepo;
import codeforandroid.thehindunews.repo.NewsItemRepoImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */
@Module (includes = NetworkModule.class)
public class AppModule {

	@Provides
	@Singleton
	NewsItemRepo providesNewsItemRepoImpl(TheHinduNewsApiService apiService) {
		return new NewsItemRepoImpl(apiService);
	}
}

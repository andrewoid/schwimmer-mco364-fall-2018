package schwimmer.earthquake.net;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.text.JTextComponent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import schwimmer.earthquake.Earthquake;
import schwimmer.earthquake.EarthquakeFeedModel;
import schwimmer.earthquake.EarthquakeProperties;

@Singleton
public class EarthquakeController {
	private USGSEarthquakeService service;
	private Provider<EarthquakeView> viewProvider;

	@Inject
	public EarthquakeController(Provider<EarthquakeView> viewProvider, USGSEarthquakeService service) {
		this.viewProvider = viewProvider;
		this.service = service;
	}

	public void refreshData() {
		service.getAllHour().enqueue(new Callback<EarthquakeFeedModel>() {
			@Override
			public void onResponse(Call<EarthquakeFeedModel> call, Response<EarthquakeFeedModel> response) {
				EarthquakeFeedModel feed = response.body();

				List<Earthquake> earthquakes = feed.getFeatures()
						.stream()
						.filter(earthquake -> earthquake.getProperties().getMag() >= 1)
						.sorted(Comparator.comparing(Earthquake::getMagnitude).reversed())
						.limit(5)
						.collect(Collectors.toList());


				viewProvider.get().setEarthquakes(earthquakes);

			}

			@Override
			public void onFailure(Call<EarthquakeFeedModel> callMonth, Throwable t) {
				t.printStackTrace();
			}
		});
	}

}
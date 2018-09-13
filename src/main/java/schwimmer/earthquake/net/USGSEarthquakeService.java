package schwimmer.earthquake.net;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import schwimmer.earthquake.EarthquakeFeedModel;

public interface USGSEarthquakeService {
	
	@GET("/earthquakes/feed/v1.0/summary/all_month.geojson")
	Observable<EarthquakeFeedModel> getAllMonth();
	
	@GET("/earthquakes/feed/v1.0/summary/all_week.geojson")
	Observable<EarthquakeFeedModel> getAllWeek();

	@GET("/earthquakes/feed/v1.0/summary/all_hour.geojson")
	Observable<EarthquakeFeedModel> getAllHour();

	@GET("/earthquakes/feed/v1.0/summary/all_day.geojson")
	Observable<EarthquakeFeedModel> getAllDay();
	
}

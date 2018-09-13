package schwimmer.earthquake.net;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.text.JTextComponent;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
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
    private Disposable disposable;

    @Inject
    public EarthquakeController(Provider<EarthquakeView> viewProvider, USGSEarthquakeService service) {
        this.viewProvider = viewProvider;
        this.service = service;
    }

    public void refreshData() {
        disposable = Observable.interval(0,30, TimeUnit.SECONDS)
                .flatMap(aLong -> service.getAllDay())
                .map(feed -> feed.getFeatures())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(this::setEarthquakes,
                        throwable -> System.out.println("Error getting data"));
    }

    private void setEarthquakes(List<Earthquake> list) {
        List<Earthquake> earthquakes = list
                .stream()
                .filter(earthquake -> earthquake.getProperties().getMag() >= 3.0)
                .sorted((e1, e2) -> e1.getMagnitude() > e2.getMagnitude() ? -1 : 1)
                .limit(5)
                .collect(Collectors.toList());

        viewProvider.get().setEarthquakes(earthquakes);
    }

    public void stop() {
        disposable.dispose();
    }

}

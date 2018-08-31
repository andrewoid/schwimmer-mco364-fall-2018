package schwimmer.earthquake;

import java.util.List;

public class EarthquakeFeedModel {

	private String type;
	private List<Earthquake> features;

	public EarthquakeFeedModel(String type, List<Earthquake> features) {
		super();
		this.type = type;
		this.features = features;
	}

	public String getType() {
		return type;
	}

	public List<Earthquake> getFeatures() {
		return features;
	}
	
}

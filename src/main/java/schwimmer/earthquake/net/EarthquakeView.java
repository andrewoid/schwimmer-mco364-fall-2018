package schwimmer.earthquake.net;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.List;

import javax.inject.Inject;
/*import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Comparator;
import java.util.Optional;
*/
import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/*import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;*/
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import schwimmer.earthquake.Earthquake;
import schwimmer.earthquake.EarthquakeProperties;

@Singleton
public class EarthquakeView extends JFrame //implements WindowListener
{
	private static final long serialVersionUID = 6111006689421939040L;
	private JLabel fields[] = new JLabel[5];
	
	@Inject
	public EarthquakeView(EarthquakeController controller)
	{
		setTitle("Largest Earthquakes");
		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		for (int i=0; i<fields.length; i++) {
			fields[i] = new JLabel();
			panel.add(fields[i]);
		}
		
		add(panel);

		controller.refreshData();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent windowEvent) {
				controller.stop();
			}
		});
	}

	public void setEarthquakes(List<Earthquake> earthquakes) {
		for (int i=0; i<fields.length && i<earthquakes.size(); i++) {
			EarthquakeProperties properties = earthquakes.get(i).getProperties();
			fields[i].setText(properties.getMag() + " " + properties.getPlace());
		}
	}


	public static void main(String[] args)
	{
		Injector injector = Guice.createInjector(new EarthquakeModule());

		EarthquakeView view = injector.getInstance(EarthquakeView.class);

		view.setVisible(true);
	}

}

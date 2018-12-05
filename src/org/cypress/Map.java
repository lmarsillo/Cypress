package org.cypress;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Map extends JLabel {

	private static final long serialVersionUID = 1L;

	public Map() {

		String latitude = "43.6709928";
		String longitude = "-79.3836399";
		String mapFile = "./src/resources/toronto.jpg";
		byte[] b = new byte[2048];
		int length;

		String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
				+ latitude
				+ ","
				+ longitude
				+ "&zoom=13&size=700x700&scale=2&maptype=roadmap&style=feature:all|element:labels|visibility:off";

		try {
			URL url;
			url = new URL(imageUrl);

			InputStream input = url.openStream();
			OutputStream output = new FileOutputStream(mapFile);

			while ((length = input.read(b)) != -1) {
				output.write(b, 0, length);
			}
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ImageIcon imageIcon = new ImageIcon((new ImageIcon("./src/resources/toronto.jpg"))
				.getImage().getScaledInstance(600, 600,
						java.awt.Image.SCALE_SMOOTH));
		setIcon(imageIcon);
	}
	

}
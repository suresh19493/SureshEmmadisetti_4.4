package com.honeywell.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.honeywell.test.model.Cab;
import com.honeywell.test.model.Person;

@Service
public class CabService {

	private String phonenumber;
	private String lattitude;
	private String langitude;
	private Boolean isRunning;

	private static final double earth_radius = 6371.0;

	List<Cab> cabs = new ArrayList<Cab>();

	CabService() {
		Cab cab1 = new Cab("1", "suresh", "8125743669", 12.9611159, 77.6362214, false);
		Cab cab2 = new Cab("2", "ramesh", "8125743668", 17.9611159, 79.6362214, false);
		Cab cab3 = new Cab("3", "rajesh", "8125743667", 10.9611159, 76.6362214, false);
		Cab cab4 = new Cab("4", "vignesh", "8125743666", 12.9611159, 77.6362214, true);
		this.cabs.add(cab1);
		this.cabs.add(cab2);
		this.cabs.add(cab3);
		this.cabs.add(cab4);
	}

	public Cab getCabNearestMe(Person person) {
		Double min_dist = Double.MAX_VALUE;
		Cab min_cab = null;
		// Map<Double> distanceList=new ArrayList<>();
		for (Cab cab : cabs) {
			if (!cab.getIsRunning()) {
				Double dist = distanceEarth(cab.getLangitude(), cab.getLangitude(), person.getLattitude(),
						person.getLangitude());
				if (dist < min_dist) {
					min_dist = dist;
					min_cab = cab;
				}
			}
		}
		return min_cab;
	}

	private double degtorad(double deg) {
		return (deg * Math.PI / 180);
	}

	private double distanceEarth(double lat2d, double lon2d, double lat1d, double lon1d) {
		double lat1, lon1, lat2, lon2, delta_lon, central_ang;

		lat1 = degtorad(lat1d);
		lon1 = degtorad(lon1d);
		lat2 = degtorad(lat2d);
		lon2 = degtorad(lon2d);

		delta_lon = lon2 - lon1;

		// great circle distance formula.
		central_ang = Math
				.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(delta_lon));

		return (earth_radius * central_ang);
	}

}

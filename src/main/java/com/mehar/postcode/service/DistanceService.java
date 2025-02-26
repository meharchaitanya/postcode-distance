package com.mehar.postcode.service;
import com.mehar.postcode.dto.DistanceResponse;
import com.mehar.postcode.model.Postcode;
import com.mehar.postcode.repository.PostcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {
    @Autowired
    private PostcodeRepository postcodeRepository;

    public DistanceResponse calculateDistance(String postcode1, String postcode2) throws Exception{

        Postcode p1 = postcodeRepository.findByPostcode(postcode1).orElseThrow(() -> new Exception("Postcode not found: " + postcode1));
        Postcode p2 = postcodeRepository.findByPostcode(postcode2).orElseThrow(() -> new Exception("Postcode not found: " + postcode2));

        double distance = calculateHaversineDistance(p1.getLatitude(), p1.getLongitude(), p2.getLatitude(), p2.getLongitude());

        return new DistanceResponse(
                p1.getPostcode(), p1.getLatitude(), p1.getLongitude(),
                p2.getPostcode(), p2.getLatitude(), p2.getLongitude(),
                distance, "km"
        );
    }

    private double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
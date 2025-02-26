package com.mehar.postcode.controller;

import com.mehar.postcode.dto.DistanceResponse;
import com.mehar.postcode.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distance")
public class DistanceController {
    @Autowired
    private DistanceService distanceService;

    @GetMapping
    public DistanceResponse getDistance(@RequestParam String postcode1, @RequestParam String postcode2) throws Exception {
        return distanceService.calculateDistance(postcode1, postcode2);
    }
}
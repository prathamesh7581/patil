package com.erdiagram.mapping.controller;

import com.erdiagram.mapping.entity.Bus;
import com.erdiagram.mapping.entity.BusStop;
import com.erdiagram.mapping.entity.Stop;
import com.erdiagram.mapping.repository.BusRepository;
import com.erdiagram.mapping.repository.BusStopRepository;
import com.erdiagram.mapping.repository.StopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    private BusRepository busRepository;

    private StopRepository stopRepository;

    private BusStopRepository busstopRepository;


    public BusController(BusRepository busRepository, StopRepository stopRepository, BusStopRepository busstopRepository) {
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
        this.busstopRepository = busstopRepository;
    }

    @PostMapping
    public ResponseEntity<BusStop> allocateBusRoute(
            @RequestParam long busId,
            @RequestParam  long stopId,
            @RequestBody BusStop busStop
    ){
        Bus bus = busRepository.findById(busId).get();
        Stop stop = stopRepository.findById(stopId).get();
        
        busStop.setBus(bus);
        busStop.setStop(stop);
        BusStop savedEntity = busstopRepository.save(busStop);

        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

}

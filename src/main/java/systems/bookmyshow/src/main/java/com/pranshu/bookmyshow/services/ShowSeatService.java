package com.pranshu.bookmyshow.services;

import com.pranshu.bookmyshow.enums.SeatStatus;
import com.pranshu.bookmyshow.models.ShowSeat;
import com.pranshu.bookmyshow.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public List<ShowSeat> getSeats(List<Long> showSeatIds) {
        return null;
    }

    public void lockSeats(List<ShowSeat> showSeats) {
        for (ShowSeat seat : showSeats) {
            seat.setStatus(SeatStatus.LOCKED);
        }
        showSeatRepository.saveAll(showSeats);
    }
}

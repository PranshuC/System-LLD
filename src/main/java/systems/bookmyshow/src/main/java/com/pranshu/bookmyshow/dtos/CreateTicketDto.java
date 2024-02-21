package com.pranshu.bookmyshow.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateTicketDto {

    // User Id
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds = new ArrayList<>();
}

package ru.practicum.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDto {
    private float lat;

    private float lon;
}

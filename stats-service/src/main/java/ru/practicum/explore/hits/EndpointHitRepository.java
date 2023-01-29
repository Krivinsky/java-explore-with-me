package ru.practicum.explore.hits;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EndpointHitRepository  extends CrudRepository<EndpointHit, Long> {
//    List<EndpointHit> findEndpointHitByUriAndTimestampBetween(String uri, LocalDateTime start, LocalDateTime end);

    List<EndpointHit> findAllByTimestampBetween(LocalDateTime start, LocalDateTime end);
}

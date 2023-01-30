package ru.practicum.explore.hits;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EndpointHitServiceImpl implements EndpointHitService {

    EndpointHitRepository endpointHitRepository;

    public EndpointHitServiceImpl(EndpointHitRepository endpointHitRepository) {
        this.endpointHitRepository = endpointHitRepository;
    }

    @Override
    public EndpointHit creat(EndpointHitDto endpointHitDto) {
        EndpointHit endpointHit = EndpointHitMapper.toEndpointHit(endpointHitDto);
        endpointHit.setTimestamp(LocalDateTime.now());
        return endpointHitRepository.save(endpointHit);
    }

    @Override
    public List<EndpointHitDtoResp> getStat(String start, String end, List<String> uris, Boolean unique) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldtStart = LocalDateTime.parse(start,dtf);
        LocalDateTime ldtEnd = LocalDateTime.parse(end, dtf);

        List<EndpointHitDtoResp> result;

        if (unique) {
            result = endpointHitRepository.getStatUrisIsUnique(ldtStart, ldtEnd, uris);
        } else {
            result = endpointHitRepository.getStat(ldtStart, ldtEnd, uris);
        }
        return result;
    }
}

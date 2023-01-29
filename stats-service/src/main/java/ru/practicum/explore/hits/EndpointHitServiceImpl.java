package ru.practicum.explore.hits;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println(endpointHit);/////////////////////////////////////////////-----------------------------------------
        return endpointHitRepository.save(endpointHit);
    }

    @Override
    public List<EndpointHitDtoResp> getStat(String start, String end, List<String> uris) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");     //2020-05-05 00:00:00
        LocalDateTime ldtStart = LocalDateTime.parse(start,dtf);
        LocalDateTime ldtEnd = LocalDateTime.parse(end, dtf);



//        List<EndpointHitDtoResp> resps =  endpointHitRepository.findEndpointHitByUriAndTimestampBetween(uris.get(0), ldtStart, ldtEnd)
//                .stream()
//                .map(EndpointHitMapper::toEndpointHitDtoResp)
//                .collect(Collectors.toList());

        List<EndpointHitDtoResp> resps =  endpointHitRepository.findAllByTimestampBetween(ldtStart, ldtEnd)
                .stream()
                .map(EndpointHitMapper::toEndpointHitDtoResp)
                .collect(Collectors.toList());

        return resps;
    }
}

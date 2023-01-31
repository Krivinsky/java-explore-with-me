package ru.practicum.ewm.client.stats;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import ru.practicum.EndpointHitDto;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpClient;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StatsClient {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final String application;
    private final String statsServiceUri;
    private final ObjectMapper json;
    private final HttpClient httpClient;


    public StatsClient(@Value("${spring.application.name}") String application,
                       @Value("${services.stats-service.uri:http://localhost:9090}") String statsServiceUri,
                       ObjectMapper json) {
        this.application = application;
        this.statsServiceUri = statsServiceUri;
        this.json = json;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(2))
                .build();
    }

    public void hit(HttpServletRequest userReques) {
        EndpointHitDto hit = EndpointHitDto.builder()
                .app(application)
                .ip(userReques.getRemoteAddr())
                .uri(userReques.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();


    }
}

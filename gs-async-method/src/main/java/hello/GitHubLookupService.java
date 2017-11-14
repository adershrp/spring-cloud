package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GitHubLookupService {

    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<Greeting> findUser(String user) throws InterruptedException {
        logger.info("Looking up " + user);
        String url = String.format("http://localhost:8080/api/%s/morning", user);
        Greeting results = restTemplate.getForObject(url, Greeting.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(5000L);
        return CompletableFuture.completedFuture(results);
    }

}

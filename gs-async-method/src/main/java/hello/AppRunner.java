package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

	private final GitHubLookupService gitHubLookupService;

	public AppRunner(GitHubLookupService gitHubLookupService) {
		this.gitHubLookupService = gitHubLookupService;
	}

	@Override
	public void run(String... args) throws Exception {
		// Start the clock
		long start = System.currentTimeMillis();

		// Kick of multiple, asynchronous lookups
		CompletableFuture<Greeting> page1 = gitHubLookupService.findUser("PivotalSoftware");
		CompletableFuture<Greeting> page2 = gitHubLookupService.findUser("CloudFoundry");
		CompletableFuture<Greeting> page3 = gitHubLookupService.findUser("Spring-Projects");
		CompletableFuture<Greeting> page4 = gitHubLookupService.findUser("PivotalSoftware");
		CompletableFuture<Greeting> page5 = gitHubLookupService.findUser("CloudFoundry");
		CompletableFuture<Greeting> page6 = gitHubLookupService.findUser("Spring-Projects");
		CompletableFuture<Greeting> page7 = gitHubLookupService.findUser("PivotalSoftware");
		CompletableFuture<Greeting> page8 = gitHubLookupService.findUser("CloudFoundry");
		CompletableFuture<Greeting> page9 = gitHubLookupService.findUser("Spring-Projects");

		// Wait until they are all done
		CompletableFuture.allOf(page1, page2, page3, page4, page5, page6, page7, page8, page9).join();

		// Print results, including elapsed time
		logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
		logger.info("--> " + page1.get());
		logger.info("--> " + page2.get());
		logger.info("--> " + page3.get());

	}

}

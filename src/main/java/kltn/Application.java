 package kltn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import com.github.messenger4j.Messenger;


@EnableAsync
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Application  {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    @Bean
    public Messenger messenger(@Value("${messenger4j.pageAccessToken}") String pageAccessToken,
 @Value("${messenger4j.appSecret}") final String appSecret,
 @Value("${messenger4j.verifyToken}") final String verifyToken) {
        return Messenger.create(pageAccessToken, appSecret, verifyToken);
    }
}

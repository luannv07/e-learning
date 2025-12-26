package id.luannv.e_learning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@SpringBootApplication
@EnableJpaAuditing
public class ELearningApplication {

	public static void main(String[] args) {
		try {
            SpringApplication.run(ELearningApplication.class, args);
        } catch (Exception e) {
            log.info("-- Caught an error while trying to run application.");
            e.printStackTrace();
        }
	}

}

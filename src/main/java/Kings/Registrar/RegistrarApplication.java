package Kings.Registrar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistrarApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RegistrarApplication.class);
		app.setRegisterShutdownHook(false); // Disable the automatic shutdown hook
		app.run(args);
	}

}

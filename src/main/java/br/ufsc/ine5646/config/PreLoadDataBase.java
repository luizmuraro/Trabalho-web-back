package br.ufsc.ine5646.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.ufsc.ine5646.entity.Medico;
import br.ufsc.ine5646.repository.MedicoRepository;
import lombok.extern.slf4j.Slf4j;

/**@Configuration
@Slf4j
class PreLoadDataBase {
	
	private static final Logger log = LoggerFactory.getLogger(PreLoadDataBase.class);
	
	@Bean
	CommandLineRunner initDatabase(PlayerRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Player("Cassio Gigante", "GK")));
			log.info("preloading " + repository.save(new Player("Vagner Love", "FW")));
		};
	}
	
}
**/
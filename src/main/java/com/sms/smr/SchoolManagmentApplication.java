package com.sms.smr;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sms.smr.infra.outputadapter.db.AlumnoEntity;
import com.sms.smr.infra.outputadapter.jparepository.alumno.SpringDataAlumnoRepository;


@SpringBootApplication()
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SchoolManagmentApplication {

	@Autowired
	private  SpringDataAlumnoRepository sDAlumnoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagmentApplication.class, args);
	}
    @Bean
    public CommandLineRunner databaseInitializer() {
        return args -> {
            // Add code to initialize the database with data
            AlumnoEntity alumnoEntity = null;
			for(int i =1;i<21;i++) {
				alumnoEntity = new AlumnoEntity();
				alumnoEntity.setApellido("Apellido "+i);
				alumnoEntity.setNombre("Nombre "+i);
				sDAlumnoRepository.save(alumnoEntity);
			}

        };
    }

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
			}
		};
	}
}

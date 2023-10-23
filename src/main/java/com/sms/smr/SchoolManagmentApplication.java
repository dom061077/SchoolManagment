package com.sms.smr;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sms.smr.infra.outputadapter.db.AlumnoEntity;
import com.sms.smr.infra.outputadapter.jparepository.alumno.SpringDataAlumnoRepository;


@SpringBootApplication()

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
}

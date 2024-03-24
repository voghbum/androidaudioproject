package com.voghbum.androidaudiobookprojectbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class AndroidAudioBookProjectBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(AndroidAudioBookProjectBackendApplication.class, args);
	}
}

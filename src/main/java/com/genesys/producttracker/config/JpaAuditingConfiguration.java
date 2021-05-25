package com.genesys.producttracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {

        /*
          if we are using spring security, we can get the currently logged username with following code segment.
          SecurityContextHolder.getContext().getAuthentication().getName(). and maybe in the future implement createdby or Modifyedby
          property;
         */
        return () -> Optional.ofNullable("randomuser");
    }
}
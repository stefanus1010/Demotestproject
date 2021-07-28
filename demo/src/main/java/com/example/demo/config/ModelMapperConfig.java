package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	

    /**
     * Bean {@link ModelMapper} dan konfigurasinya
     * @return {@link ModelMapper} yang sudah dikonfigurasi
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        /* agar mapping "strict", nama property sumber dan tujuan harus sama persis kalau tidak, abaikan
            untuk mencegah terjadinya bug-bug yang tidak diharapkan
        */
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}

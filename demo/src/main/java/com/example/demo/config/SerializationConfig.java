package com.example.demo.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.math.BigDecimal;

@Configuration
public class SerializationConfig {
	
	@Bean(name = "jacksonBuilder")
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

        builder.serializerByType(BigDecimal.class, new ToStringSerializer());
        // serialize dan deserialize properti JSON dalam format snake_case
        builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        // Format tanggal seperti ZonedDateTime dan kawan2 dalam format ISO-8601
        // 2020-09-12T12:39:00+07:00
        // 2020-09-12T05:39:00Z
        builder.dateFormat(new StdDateFormat());
        return builder;
    }

}

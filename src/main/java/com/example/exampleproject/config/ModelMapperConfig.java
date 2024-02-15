package com.example.exampleproject.config;

import com.example.exampleproject.service.component.MappingHelper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    public interface ModelMapperFactory {
        ModelMapper getMapper();
    }

    private ModelMapperFactory modelMapperFactory() {
        return () -> {
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.STRICT);
            return mapper;
        };
    }

    @Bean
    public MappingHelper mappingHelper() {
        return new MappingHelper(modelMapperFactory());
    }
}
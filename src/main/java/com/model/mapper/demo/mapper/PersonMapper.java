package com.model.mapper.demo.mapper;

import com.model.mapper.demo.dto.PersonDto;
import com.model.mapper.demo.entity.Person;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(Person.class, PersonDto.class)
                .field("surname", "lastName")
                .byDefault()
                .register();
    }

}

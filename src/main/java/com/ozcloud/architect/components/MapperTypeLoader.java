package com.ozcloud.architect.components;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MapperTypeLoader implements ApplicationRunner {


    @Autowired
    ModelMapper modelMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
		/*Converter<BasketDTO, Basket> converter = context -> {
			Basket entity = context.getDestination();

			if (context.getSource().getCustomerId() > 0)
				entity.setCustomer(customerRepository.findById(context.getSource().getCustomerId()).get());
			else
				entity.setCustomer(null);

			if (context.getSource().getFabricId() > 0)
				entity.setFabric(fabricRepository.findById(context.getSource().getFabricId()).get());
			else
				entity.setFabric(null);

			return entity;
		};

		modelMapper.createTypeMap(BasketDTO.class, Basket.class).setPostConverter(converter);*/

    }

}

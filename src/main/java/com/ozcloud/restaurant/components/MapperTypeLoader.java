package com.ozcloud.restaurant.components;

import com.ozcloud.restaurant.dtos.ItemDTO;
import com.ozcloud.restaurant.dtos.ProductDTO;
import com.ozcloud.restaurant.model.Item;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.Destination;

@Component
public class MapperTypeLoader implements ApplicationRunner {


    @Autowired
    ModelMapper modelMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Converter<Item, ItemDTO> converter = context -> {
            ItemDTO itemDTO = context.getDestination();
            Item item = context.getSource();
          if(item.getParentItem() != null)
              itemDTO.setParentId(item.getParentItem().getItemId());

          return itemDTO;

        };
        modelMapper.createTypeMap(Item.class, ItemDTO.class).setPostConverter(converter);

        Converter<Item, ProductDTO> converterProduct = context -> {
            ProductDTO productDTO = context.getDestination();
            Item item = context.getSource();
            if(item.getParentItem() != null)
                productDTO.setParentId(item.getParentItem().getItemId());

            return productDTO;

        };
        modelMapper.createTypeMap(Item.class, ProductDTO.class).setPostConverter(converterProduct);
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

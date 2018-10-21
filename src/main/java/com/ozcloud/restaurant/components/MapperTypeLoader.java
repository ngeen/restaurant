package com.ozcloud.restaurant.components;

import com.ozcloud.restaurant.dtos.ItemDTO;
import com.ozcloud.restaurant.dtos.ProductDTO;
import com.ozcloud.restaurant.dtos.VenueDTO;
import com.ozcloud.restaurant.enums.ItemType;
import com.ozcloud.restaurant.enums.Status;
import com.ozcloud.restaurant.model.Item;
import com.ozcloud.restaurant.model.Product;
import com.ozcloud.restaurant.model.Venue;
import com.ozcloud.restaurant.repository.ItemRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.Destination;

@Component
public class MapperTypeLoader implements ApplicationRunner {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Converter<Item, ItemDTO> converterItem = context -> {
            ItemDTO itemDTO = context.getDestination();
            Item item = context.getSource();
          if(item.getParentItem() != null)
              itemDTO.setParentId(item.getParentItem().getItemId());

          return itemDTO;

        };

        modelMapper.createTypeMap(Item.class, ItemDTO.class).setPostConverter(converterItem);

        Converter<Item, ProductDTO> converterProduct = context -> {
            ProductDTO productDTO = context.getDestination();
            Item item = context.getSource();
            if(item.getParentItem() != null)
                productDTO.setParentId(item.getParentItem().getItemId());

            return productDTO;

        };
        modelMapper.createTypeMap(Item.class, ProductDTO.class).setPostConverter(converterProduct);

        modelMapper.addMappings(new PropertyMap<VenueDTO, Venue>() {
            @Override
            protected void configure() {
                map().setFoursquareId(source.getFoursquareId());
                skip(destination.getVenueId());
            }
        });

        Converter<ItemDTO, Item> converterItemDTO = context -> {
            ItemDTO itemDTO = context.getSource();
            Item item = context.getDestination();
            if(itemDTO.getParentId() > 0)
                item.setParentItem(itemRepository.findByItemId(itemDTO.getParentId()));

            return item;

        };

        modelMapper.addMappings(new PropertyMap<ItemDTO, Item>() {
            @Override
            protected void configure() {
                //map().setFoursquareId(source.getFoursquareId());
                skip(destination.getStatus());
                skip(destination.getItemType());
            }
        }).setPostConverter(converterItemDTO);

        Converter<ProductDTO, Product> converterProductDTO = context -> {
            ProductDTO itemDTO = context.getSource();
            Product item = context.getDestination();
            if(itemDTO.getParentId() > 0)
                item.setParentItem(itemRepository.findByItemId(itemDTO.getParentId()));

            return item;

        };

        modelMapper.addMappings(new PropertyMap<ProductDTO, Product>() {
            @Override
            protected void configure() {
                //map().setFoursquareId(source.getFoursquareId());
                skip(destination.getStatus());
                skip(destination.getItemType());
            }
        }).setPostConverter(converterProductDTO);

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

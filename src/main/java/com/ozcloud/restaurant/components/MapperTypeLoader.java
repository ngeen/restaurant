package com.ozcloud.restaurant.components;

import com.ozcloud.restaurant.dtos.*;
import com.ozcloud.restaurant.enums.ItemType;
import com.ozcloud.restaurant.enums.Status;
import com.ozcloud.restaurant.model.*;
import com.ozcloud.restaurant.repository.ItemRepository;
import com.ozcloud.restaurant.repository.UserRepository;
import com.ozcloud.restaurant.repository.VenueRepository;
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

    @Autowired
    UserRepository userRepository;

    @Autowired
    VenueRepository venueRepository;

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

        Converter<ProductExtension, ProductExtDTO> converterProductExt = context -> {
            ProductExtDTO productExtDTO = context.getDestination();
            ProductExtension productExtension = context.getSource();
            if(productExtension.getPExtItem() != null)
                productExtDTO.setPExtItemId(productExtension.getPExtItem().getItemId());
            return productExtDTO;

        };
        modelMapper.createTypeMap(ProductExtension.class, ProductExtDTO.class).setPostConverter(converterProductExt);

        /*Converter<Media, MediaDTO> converterMedia = context -> {
            MediaDTO mediaDTO = context.getDestination();
            Media media = context.getSource();

            if(media.getUser() != null)
                mediaDTO.setUserId(media.getUser().getUserId());

            if(media.getMenuItem() != null)
                mediaDTO.setMenuItemId(media.getMenuItem().getItemId());

            if(media.getUser() != null)
                mediaDTO.setVenueId(media.getVenue().getVenueId());

            return mediaDTO;

        };

        modelMapper.createTypeMap(Media.class, MediaDTO.class).setPostConverter(converterMedia);*/

        modelMapper.addMappings(new PropertyMap<VenueDTO, Venue>() {
            @Override
            protected void configure() {
                map().setFoursquareId(source.getFoursquareId());
                skip(destination.getVenueId());
            }
        });

        Converter<ProductExtDTO, ProductExtension> converterProductExtDTO = context -> {
            ProductExtDTO productExtDTO = context.getSource();
            ProductExtension productExtension = context.getDestination();
            if(productExtDTO.getPExtItemId() > 0)
                productExtension.setPExtItem(itemRepository.findByItemId(productExtDTO.getPExtItemId()));

            return productExtension;

        };

        modelMapper.addMappings(new PropertyMap<ProductExtDTO, ProductExtension>() {
            @Override
            protected void configure() {
                //map().setFoursquareId(source.getFoursquareId());
                skip(destination.getPExtId());
            }
        }).setPostConverter(converterProductExtDTO);


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
                skip(destination.getProductStatus());
                skip(destination.getItemType());
            }
        }).setPostConverter(converterProductDTO);

        Converter<MediaDTO, Media> converterMediaDTO = context -> {
            MediaDTO mediaDTO = context.getSource();
            Media media = context.getDestination();
            if(mediaDTO.getMenuItemId() > 0)
                media.setMenuItem(itemRepository.findByItemId(mediaDTO.getMenuItemId()));

            if(mediaDTO.getUserId() > 0)
                media.setUser(userRepository.findById(mediaDTO.getUserId()).orElse(null));

            if(mediaDTO.getVenueId() > 0)
                media.setVenue(venueRepository.findById(mediaDTO.getVenueId()).orElse(null));

            return media;

        };

        modelMapper.addMappings(new PropertyMap<MediaDTO, Media>() {
            @Override
            protected void configure() {
                //map().setFoursquareId(source.getFoursquareId());
                skip(destination.getMediaId());
                skip(destination.getStatus());
                skip(destination.getMediaType());
            }
        }).setPostConverter(converterMediaDTO);

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

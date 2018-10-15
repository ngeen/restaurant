package com.ozcloud.restaurant.controller;

import com.google.common.collect.Lists;
import com.ozcloud.restaurant.dtos.ItemDTO;
import com.ozcloud.restaurant.dtos.ProductDTO;
import com.ozcloud.restaurant.dtos.UserDTO;
import com.ozcloud.restaurant.enums.ItemType;
import com.ozcloud.restaurant.model.Item;
import com.ozcloud.restaurant.model.Product;
import com.ozcloud.restaurant.model.Venue;
import com.ozcloud.restaurant.repository.ItemRepository;
import com.ozcloud.restaurant.repository.ProductRepository;
import com.ozcloud.restaurant.service.UserServiceImpl;
import com.ozcloud.restaurant.utils.BaseResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController implements Serializable {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/getItems")
    public ResponseEntity<BaseResponse> getAllItems() throws Exception {
        try {
            List<Item> items = Lists.newArrayList(itemRepository.findAllByOrderByItemTypeAsc());

            Type listType = new TypeToken<List<ProductDTO>>() {}.getType();
            List<ProductDTO> itemList = modelMapper.map(items,listType);

            return ResponseEntity.ok(BaseResponse.getOkResponse(itemList));
        } catch (Exception e) {
            throw  new Exception(e);
        }

    }

    @PostMapping("/createMenu")
    public ResponseEntity<BaseResponse> createMenu(@RequestBody ItemDTO itemDTO) throws Exception {
        try {
            Item menu = new Item();
            menu.setItemType(ItemType.MENU);
            menu.setName(itemDTO.getName());
            menu.setDescription(itemDTO.getDescription());
            menu.setUser(userServiceImpl.getAuthUser());
            menu = itemRepository.save(menu);

            return ResponseEntity.ok(BaseResponse.getOkResponse(Long.valueOf(menu.getItemId())));
        } catch (Exception e) {
            throw  new Exception(e);
        }
    }

    @PostMapping("/createCategory")
    public ResponseEntity<BaseResponse> createCategory(@RequestBody ItemDTO itemDTO) throws Exception {
        try {
            if(itemDTO.getParentId() == 0)
                throw new Exception("MissingMenu");

            Item item = modelMapper.map(itemDTO, Item.class);
            item.setItemType(ItemType.MENU);
            item.setUser(userServiceImpl.getAuthUser());
            item = itemRepository.save(item);

            return ResponseEntity.ok(BaseResponse.getOkResponse(Long.valueOf(item.getItemId())));
        } catch (Exception e) {
            throw  new Exception(e);
        }
    }

    @PostMapping("/createProduct")
    public ResponseEntity<BaseResponse> createProduct(@RequestBody ProductDTO productDTO) throws Exception {
        try {
            if(productDTO.getParentId() == 0)
                throw new Exception("MissingCategory");

            Product product = modelMapper.map(productDTO, Product.class);
            product.setItemType(ItemType.PRODUCT);
            product.setUser(userServiceImpl.getAuthUser());
            product = itemRepository.save(product);

            return ResponseEntity.ok(BaseResponse.getOkResponse(Long.valueOf(product.getItemId())));
        } catch (Exception e) {
            throw  new Exception(e);
        }
    }

    @PostMapping("/updateItem")
    public ResponseEntity<BaseResponse> updateItem(@RequestBody ItemDTO itemDTO) throws Exception {
        try {
            Item item = itemRepository.findById(itemDTO.getId()).orElse(null);
            if(item == null)
                throw new Exception("MissingItem");

            if(item.getUser().getUserId() != userServiceImpl.getAuthUser().getUserId())
                throw new Exception("WrongUser");

            item = modelMapper.map(itemDTO, Item.class);
            item = itemRepository.save(item);

            return ResponseEntity.ok(BaseResponse.getOkResponse(Long.valueOf(item.getItemId())));
        } catch (Exception e) {
            throw  new Exception(e);
        }
    }

    @PostMapping("/deleteItem")
    public ResponseEntity<BaseResponse> deleteItem(@RequestBody ItemDTO itemDTO) throws Exception {
        try {
            Item item = itemRepository.findById(itemDTO.getId()).orElse(null);
            if(item == null)
                throw new Exception("MissingItem");

            if(item.getUser().getUserId() != userServiceImpl.getAuthUser().getUserId())
                throw new Exception("WrongUser");

            itemRepository.delete(item);

            return ResponseEntity.ok(BaseResponse.getOkResponse("Success"));
        } catch (Exception e) {
            throw  new Exception(e);
        }
    }
}

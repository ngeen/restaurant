package com.ozcloud.restaurant.controller;

import com.google.common.collect.Lists;
import com.ozcloud.restaurant.enums.ItemType;
import com.ozcloud.restaurant.model.Item;
import com.ozcloud.restaurant.repository.ItemRepository;
import com.ozcloud.restaurant.repository.ProductRepository;
import com.ozcloud.restaurant.utils.BaseResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController implements Serializable {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getItems")
    public ResponseEntity<BaseResponse> getAllItems() throws Exception {
        try {
            List<Item> items = Lists.newArrayList(itemRepository.findAll());
            List<Object> alltypes = new ArrayList<Object>();
            for (Item item: items) {
                Object oItem = null;

                if(item.getItemType() == ItemType.PRODUCT)
                    oItem = productRepository.findById(item.getItemId()).orElse(null);
                else
                    oItem = item;

                alltypes.add(oItem);
            }
            //Type listType = new TypeToken<List<ProductDTO>>() {}.getType();
            //List<ProductDTO> itemList = modelMapper.map(items,listType);

            return ResponseEntity.ok(BaseResponse.getOkResponse(alltypes));
        } catch (Exception e) {
            throw  new Exception(e);
        }

    }
}

package com.ozcloud.restaurant.controller;

import com.ozcloud.restaurant.dtos.ProductExtDTO;
import com.ozcloud.restaurant.enums.ItemType;
import com.ozcloud.restaurant.model.ProductExtension;
import com.ozcloud.restaurant.repository.ProductExtRepository;
import com.ozcloud.restaurant.service.UserServiceImpl;
import com.ozcloud.restaurant.utils.BaseResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.UUID;

@RestController
public class ProductExtController implements Serializable {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductExtRepository productExtRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/insertProductExt")
    public ResponseEntity<BaseResponse> insertProductExt(@RequestBody ProductExtDTO productExtDTO) throws Exception {
        try {
            if (productExtDTO.getPExtItemId() == 0)
                throw new Exception("MissingProduct");

            ProductExtension productExtension = modelMapper.map(productExtDTO, ProductExtension.class);
            if (productExtension.getPExtItem().getItemType() != ItemType.PRODUCT)
                throw new Exception("InvalidItemType");
            UUID uuid = UUID.randomUUID();
            productExtension.setPExtGuid(uuid.toString());
            productExtension = productExtRepository.save(productExtension);

            ProductExtDTO returnProductExt = modelMapper.map(productExtension, ProductExtDTO.class);
            return ResponseEntity.ok(BaseResponse.getOkResponse(returnProductExt));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @PostMapping("/updateProductExt")
    @Transactional
    public ResponseEntity<BaseResponse> updateProductExt(@RequestBody ProductExtDTO productExtDTO) throws Exception {
        try {
            ProductExtension productExtension = productExtRepository.findByPExtGuid(productExtDTO.getPExtGuid());
            if (productExtension == null)
                throw new Exception("MissingProductExtension");

            if (productExtension.getPExtItem().getUser().getUserId() != userServiceImpl.getAuthUser().getUserId())
                throw new Exception("WrongUser");

            productExtension.setPExtName(productExtDTO.getPExtName());
            productExtension.setPExtDescription(productExtDTO.getPExtDescription());
            productExtension.setPExtPrice(productExtDTO.getPExtPrice());

            productExtension = productExtRepository.save(productExtension);

            ProductExtDTO returnProductExt = modelMapper.map(productExtension, ProductExtDTO.class);
            return ResponseEntity.ok(BaseResponse.getOkResponse(returnProductExt));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @PostMapping("/deleteProductExt")
    @Transactional
    public ResponseEntity<BaseResponse> deleteProductExt(@RequestBody ProductExtDTO productExtDTO) throws Exception {
        try {
            ProductExtension productExtension = productExtRepository.findByPExtGuid(productExtDTO.getPExtGuid());
            if (productExtension == null)
                throw new Exception("MissingItem");

            if (productExtension.getPExtItem().getUser().getUserId() != userServiceImpl.getAuthUser().getUserId())
                throw new Exception("WrongUser");

            productExtRepository.delete(productExtension);

            return ResponseEntity.ok(BaseResponse.getOkResponse("Success"));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}

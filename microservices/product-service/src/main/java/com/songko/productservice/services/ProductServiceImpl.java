package com.songko.productservice.services;

import com.songko.api.core.product.Product;
import com.songko.api.core.product.ProductService;
import com.songko.util.exceptions.InvalidInputException;
import com.songko.util.exceptions.NotFoundException;
import com.songko.util.http.ServiceUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ServiceUtil serviceUtil;

    @Override
    public Product getProduct(int productId) {
        log.debug("/product return the found product for productId={}", productId);

        if (productId < 1) throw new InvalidInputException("Invalid productId: " + productId);

        if (productId == 13) throw new NotFoundException("No product found for productId: " + productId);

        final String name = "name-" + productId;
        final int weight = 123;

        // 아직 데이터베이스가 없으므로 ServiceUtil 클래스에서 받은 서비스 주소와 인자로 입력된 productId를 이용해서 하드 코딩한 응답을 반환
        final String serviceAddress = serviceUtil.getServiceAddress();
        return new Product(productId, name, weight, serviceAddress);
    }
}

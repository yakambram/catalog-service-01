package com.client.catalog.service.controller;

import com.client.catalog.service.exception.ApplicationException;
import com.client.catalog.service.exception.ErrorCodesAndMessages;
import com.client.catalog.service.model.Product;
import com.client.catalog.service.service.ProductService;
import com.client.catalog.service.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable("id") String productId) throws ApplicationException {
        try {
            Optional<Product> product = productService.getProductById(productId);
            ApiResponse<Product> apiResponse = new ApiResponse();
            if (product.isPresent()) {
                apiResponse.setResponse(product.get());
                apiResponse.setMessage("success");
                apiResponse.setSuccess(true);
                return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);
            } else {
                apiResponse.setResponse(null);
                apiResponse.setMessage("Product is not available for given Id");
                apiResponse.setSuccess(true);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorCodesAndMessages.PRODUCT_NOT_FOUND_ERROR);
        }
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProducts() throws ApplicationException {
        try {
            List<Product> products = productService.getAllProducts();
            if (products != null) {
                return ResponseEntity.status(HttpStatus.FOUND).body(products);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(products);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorCodesAndMessages.PRODUCT_NOT_FOUND_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Product>> save(@RequestBody Product product) throws ApplicationException {
        try {
            Product products = productService.save(product);
            ApiResponse<Product> apiResponse = new ApiResponse();
            if (product != null) {
                apiResponse.setResponse(product);
                apiResponse.setMessage("success");
                apiResponse.setSuccess(true);
                return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
            } else {
                apiResponse.setResponse(product);
                apiResponse.setMessage("Not acceptable product");
                apiResponse.setSuccess(true);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(apiResponse);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorCodesAndMessages.PRODUCT_NOT_FOUND_ERROR);
        }

    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(productService.searchProducts(query));
    }


}
package com.example.redispoc;

import com.example.redispoc.entity.Product;
import com.example.redispoc.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class Controller {
    @Autowired
    private ProductDao productDao;

    @GetMapping
    public List<Object> getAll() {
        return productDao.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        productDao.save(product);
        return product;
    }
}

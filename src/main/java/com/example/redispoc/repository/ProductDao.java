package com.example.redispoc.repository;

import com.example.redispoc.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    private static final String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate<String, Product> template;

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Object> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProdById(int id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }


}

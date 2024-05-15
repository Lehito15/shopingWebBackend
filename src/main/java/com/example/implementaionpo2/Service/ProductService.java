package com.example.implementaionpo2.Service;

import com.example.implementaionpo2.Entity.Product;
import com.example.implementaionpo2.Entity.Unit;
import com.example.implementaionpo2.Repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UnitService unitService;

    public Product getProductById(Long unitId) {
        return productRepository.findById(unitId).orElse(null);
    }

    public void addSampleProduct(){
        Product p1 = new Product();
        p1.setName("Pomidor");
        p1.setPrice(5.50F);
        p1.setNumber(1);
        p1.setUnit(unitService.getUnitById(1L));
        p1.setCategory(categoryService.getCategoryById(1L));

        Product p2 = new Product();
        p2.setName("Jabłko");
        p2.setPrice(3.50F);
        p2.setNumber(1);
        p2.setUnit(unitService.getUnitById(1L));
        p2.setCategory(categoryService.getCategoryById(2L));

        Product p3 = new Product();
        p3.setName("Piers z kurczaka");
        p3.setPrice(15.49F);
        p3.setNumber(500);
        p3.setUnit(unitService.getUnitById(3L));
        p3.setCategory(categoryService.getCategoryById(3L));

        Product p4 = new Product();
        p4.setName("Mleko");
        p4.setPrice(2.50F);
        p4.setNumber(1);
        p4.setUnit(unitService.getUnitById(2L));
        p4.setCategory(categoryService.getCategoryById(4L));

        Product p5 = new Product();
        p5.setName("Ziemniak");
        p5.setPrice(1.50F);
        p5.setNumber(1);
        p5.setUnit(unitService.getUnitById(1L));
        p5.setCategory(categoryService.getCategoryById(1L));

        Product p6 = new Product();
        p6.setName("Stek wolowy");
        p6.setPrice(24.30F);
        p6.setNumber(100);
        p6.setUnit(unitService.getUnitById(3L));
        p6.setCategory(categoryService.getCategoryById(3L));

        Product p7 = new Product();
        p7.setName("Sok pomaranczowy");
        p7.setPrice(7.50F);
        p7.setNumber(1);
        p7.setUnit(unitService.getUnitById(4L));
        p7.setCategory(categoryService.getCategoryById(5L));

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);
        productRepository.save(p5);
        productRepository.save(p6);
        productRepository.save(p7);


    }

}

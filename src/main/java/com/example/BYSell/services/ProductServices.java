package com.example.BYSell.services;

import com.example.BYSell.models.Image;
import com.example.BYSell.models.Product;
import com.example.BYSell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServices {
//    private List<Product> products = new ArrayList<>();
//    private Long ID = 0L;
//    {
//        products.add(new Product(++ID,"PlayStation","Simplediscription",65000,"Vitebsk","Thomas"));
//        products.add(new Product(++ID,"PlayStation","Simplediscription",5000,"Vitebsk","Valers"));
//    }
    private final ProductRepository productRepository;
    public List<Product> list(String title)
    {
        if (title!=null && !title.isEmpty())
          return    productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0){
            image1 = toImageEntity(file1);
            System.out.println("Methid setPreviewImage");
            image1.setPreviewImage(true);
            System.out.println(" 1- Method seveProduct ="+product.getTitle());
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0){
            image2 = toImageEntity(file2);
            System.out.println("Methid setPreviewImage");
            System.out.println("2 - Method seveProduct ="+product.getTitle());
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0){
            image3 = toImageEntity(file3);
            System.out.println("Methid setPreviewImage");
            System.out.println("3-Method seveProduct ="+product.getTitle());
            product.addImageToProduct(image3);
        }
        log.info("Saving product: Title:{}; Author:{} " + product.getTitle(), product.getAuthor());
        System.out.println("     "+product);
        Product productFromDB = productRepository.save(product);
        productFromDB.setPreviewImageId(productFromDB.getImages().get(0).getId());
        System.out.println("product="+product);
        productRepository.save(product);

    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        System.out.println("image = "+image.getName());
        return image;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        System.out.println("getProductById ="+id+" ");
        Product product = productRepository.findById(id).orElse(null);
        System.out.println("getProductByid product="+product);
        return product;
        //return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }
}

package com.example.BYSell.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Анотация соответсвия данной модели в БД
@Entity
@Table (name="products")
public class Product  {
//Указываем id как ключ primary key
    @Id
    //Генерация инкримент ID
    @GeneratedValue (strategy = GenerationType.AUTO)
//    Указываем явно что данное поле относиться к колонке бд(можно и не указывать)
    @Column (name = "id")
    private Long id;
    @Column (name = "titel")
    private String title;
//    columnDefinition - меняем тип поля
    @Column (name = "description", columnDefinition = "text")
    private String description;
    @Column (name = "price")
    private int price;
    @Column (name = "city")
    private String city;
    @Column (name = "autor")
    private String author;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "product")
    //mappedBy указывает на сзяку с Image.product
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;

    private LocalDateTime dataOfCreater;
    @PrePersist
    private void init (){
        dataOfCreater = LocalDateTime.now();
    }
    public void addImageToProduct (Image image){
        image.setProduct(this);
        System.out.println("Method addImageToProduct ="+image.getName());
        System.out.println("images = "+ images);
        images.add(image);
        System.out.println("images =" + images);
        System.out.println("Image added to product = " +images);
    }
}

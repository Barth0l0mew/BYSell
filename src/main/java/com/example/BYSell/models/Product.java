package com.example.BYSell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//Анотация соответсвия данной модели с сущности(объекта) в БД
@Table(name = "products")
//Название таблицы данных сущностей
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    //id- Ид калонки
    @GeneratedValue(strategy = GenerationType.AUTO)
    //GeneratedValue - указывает что данное свойство будет создоваться согласно данной стратегии
    @Column(name = "id")
    //column - указывает на име колонки данной сущности
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    //    columnDefinition - меняем тип поля
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "city")
    private String city;
    @Column(name = "author")
    private String author;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
    mappedBy = "product")
    //CascadeType.ALL — означает, что операция, например, записи должна распространяться и на дочерние таблицы.
    //mappedBy указывает на сзяку с Image.product
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateOfCreated;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }


    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);
    }
}
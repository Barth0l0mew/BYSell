package com.example.BYSell.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;
    @Column (name = "name")
    private String name;
    @Column (name = "origrnalFileName")
    private String originalFileName;
    @Column (name = "size")
    private Long size;
    @Column (name = "contentType")
    private String contentType;
    @Column (name = "isPreviewImage")
    private boolean isPreviewImage;
    @Lob
    //анатация указывает что параметр будет храниться в бд в формате LONGBLOB
    //или посторинке @ Column (ColumnDefinition ="LONGBLOB")
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    //eager - все сразу загружается
    //layz - ленивая загрузка помлндовательная загрузка
    private Product product;
}
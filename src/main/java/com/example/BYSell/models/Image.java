package com.example.BYSell.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;


@Entity
@Table(name = "images")
@Data
//@ToString, @EqualsAndHashCode, @Getter @Setter и @RequiredArgsConstructor
@AllArgsConstructor
// будет сгенерирован конструктор с одним параметром для каждого поля вашего класса.
@NoArgsConstructor
//генерацию непараметризованного конструктора
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "originalFileName")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "contentType")
    private String contentType;
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage;
    @Lob
    //анатация указывает что параметр будет храниться в бд в формате LONGBLOB
    //или посторинке @ Column (ColumnDefinition ="LONGBLOB")
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    //связь много к одному, т.е много картинок к одному продукту
    //eager - все сразу загружается
    //layz - ленивая загрузка помлндовательная загрузка
    private Product product;
}
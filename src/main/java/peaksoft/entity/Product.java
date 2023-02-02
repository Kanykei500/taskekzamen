package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString(exclude = {"company","categories"})
@NoArgsConstructor
@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "products_id_generator")
    @SequenceGenerator(name = "product_id_generator",sequenceName = "product_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    private int price;
    @Column(name = "year_of_issue")
    private LocalDate yearOfIssue;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private Company company;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private Category category;

    public Product(String productName, int price, LocalDate yearOfIssue) {
        this.productName = productName;
        this.price = price;
        this.yearOfIssue = yearOfIssue;
    }

}

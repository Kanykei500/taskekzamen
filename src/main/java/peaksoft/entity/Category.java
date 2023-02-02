package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@ToString(exclude = "product")
@NoArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "categories_id_generator")
    @SequenceGenerator(name = "categories_id_generator",sequenceName = "categories_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "category_name")

   private String categoryName;
    @OneToMany(mappedBy = "category",cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    private List<Product> product;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}

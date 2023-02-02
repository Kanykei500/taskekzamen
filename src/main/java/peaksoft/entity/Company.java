package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "products")
@Entity
@Table(name= "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "companies_id_generator")
    @SequenceGenerator(name = "companies_id_generator",sequenceName = "companies_seq",
    allocationSize = 1)
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    private String country;
    @OneToMany(mappedBy = "company",cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Product>products;

    public Company(String companyName, String country) {
        this.companyName = companyName;
        this.country = country;
    }
}

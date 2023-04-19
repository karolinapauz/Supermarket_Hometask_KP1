package enitity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer totalAvailable;

    private BigDecimal price;

    private BigDecimal weight;

    private BigDecimal cost;

    @OneToMany(mappedBy = "product")
    private Set<Sale> sales;


    public Product(String productName, int totalAvailable, BigDecimal price, BigDecimal weight, BigDecimal cost) {

    }
}

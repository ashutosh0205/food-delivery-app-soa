package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "my_item")
@Getter
@Setter
@ApiModel(value = "Item")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Items {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer itemId;
    private String name;
    private int price;
    private int quantity;

    //@ManyToOne
    //@JoinColumn(name="orderId", nullable=false)

   /* @ManyToOne
    @JoinColumn(name = "orderId", insertable = false, updatable = false)
    private Order order;*/
}

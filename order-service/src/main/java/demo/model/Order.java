package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "my_order")
@Getter
@Setter
@ApiModel(value = "Order")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {

  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer orderId;

    private String restaurantId;

  //  @OneToMany(mappedBy="order", cascade= CascadeType.ALL)
   @OneToMany(cascade= CascadeType.ALL)
   @JoinColumn(name = "orderId")
    private Set<Items> items;
    private int totalPrice;
    private long orderTime;
    private String specialNote;
    private long deliveryTime;
    private String paymentId;
    private String note;
    private String userId;
}

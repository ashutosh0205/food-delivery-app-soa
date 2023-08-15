package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

// @JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "menuitem")
@Getter
@Setter
@ApiModel(value = "MenuItem")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MenuItem {
    @Id
    String id;
    private String restaurantId;
    private String name;
    private String description;
    private int price;
}

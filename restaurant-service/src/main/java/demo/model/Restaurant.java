package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


// @JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "restaurant")
@Getter
@Setter
// @JsonInclude(JsonInclude.Include.NON_NULL)
// @Data
// @RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor))
@ApiModel(value = "Restaurant")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String address;

  /*  @JsonCreator
    public Restaurant(@JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("address") String address) {
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }*/
}

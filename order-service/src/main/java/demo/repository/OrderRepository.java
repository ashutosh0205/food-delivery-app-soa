package demo.repository;

import demo.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
    //@RestResource(rel = "find-by-id", description = @Description("Find by id"))
    public Order findFirstByOrderId(@Param("orderId") Integer orderId);

   // @RestResource(rel = "delete-by-id", description = @Description("Delete by id"))
   // public void delete(@Param("id") String id);

//     @RestResource(rel = "create", description = @Description("Create"))
    public Order save(@Param("order") Order order);
}

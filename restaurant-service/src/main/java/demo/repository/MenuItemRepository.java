package demo.repository;

import demo.model.MenuItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends PagingAndSortingRepository<MenuItem, String> {
    // @RestResource(rel = "by-rid", description = @Description("Get all menuitems by restaurant id"))
    public List<MenuItem> findAllByRestaurantId(String rid);

    // @RestResource(rel = "by-name", description = @Description("Get menuitem by item name"))
    public MenuItem findByName(@Param("name") String name);
}

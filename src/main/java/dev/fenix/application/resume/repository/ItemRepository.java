package dev.fenix.application.resume.repository;


import dev.fenix.application.resume.model.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item,Long> {
    Item getItemById(Long id);
  //  Item getItemByName(String title);
    Item save(Item item);
    void delete(Item item);
}

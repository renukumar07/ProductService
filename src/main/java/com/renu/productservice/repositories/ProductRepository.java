package com.renu.productservice.repositories;

import com.renu.productservice.models.Category;
import com.renu.productservice.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    Optional<Product> findByTitleAndDescription(String title, String description);

    List<Product> findByTitleContaining(String word);
    //Using like operator.

    List<Product> findTopThreeByTitle(String title);

    Optional<Product> findByCategory(Category category);

    void deleteById(Long id);

    void deleteByTitle(String title);

    Product save(Product product);

//    @Query("Custom Query") // HQL -> Hibernate Query Language
//    Optional<Product> someRandomQuery();


}

/*

C -> Create
R -> Read
U -> Update
D -> Delete
ProductRepository -> Product
Product findById(id) => Select * from products where id = <id>
List<Product> findAll() => select * from products;
findByTitle(String title) => select * product where title = ""

delete by id and (category = or Des = )
 */
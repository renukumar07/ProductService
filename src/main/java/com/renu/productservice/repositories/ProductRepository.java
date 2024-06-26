package com.renu.productservice.repositories;

import com.renu.productservice.models.Category;
import com.renu.productservice.models.Product;
import com.renu.productservice.repositories.projections.ProductWithIdAndTitle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("select p from Product p where p.id = 10") // HQL -> Hibernate Query Language
    List<Product> someRandomQuery();

    @Query("select p from Product p where p.price > 100000 and lower(p.title) like '%pro%'") // HQL -> Hibernate Query Language
    List<Product> someRandomQuery2();

    //This method will return a Product with Only Id and Title
    @Query("select p.id, p.title from Product p where p.price > 100000 and lower(p.title) like '%pro%'") // HQL -> Hibernate Query Language
    List<ProductWithIdAndTitle> someRandomQuery3();




    //This method will return a Product with Only Id and Title
    @Query("select p.id as id, p.title as title from Product p where p.price > 120000 and lower(p.title) like '%pro%'") // HQL -> Hibernate Query Language
    List<ProductWithIdAndTitle> someRandomQuery4();

    @Query("select p.id as id, p.title as title from Product p where p.id = :id")
     ProductWithIdAndTitle doSomething(@Param("id") Long id);

    //How many DB calls -> 2
    // First select the Product object & then fetching the Category object.
    @Query(value = "select * from Product p where p.id = 1", nativeQuery = true)
    Product doSomethingSQL();



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
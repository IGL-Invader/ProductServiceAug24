package com.example.ProductServiceAug24.repository;

import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.projections.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface productRepository extends JpaRepository<Product, Long> {

    //select * from products where name == {name}
    Product findFirstByNameAndCategory(String name, String category);

    //find all products
    //select * from products
    List<Product> findAll();

    Optional<Product> findById(Long id);

    //below is the HQL query
    @Query("select p from products p where p.id = :id" )
    Product selectById(Long id);

    //below is the SQL query
    @Query(value = "select * from products p where p.id = :id", nativeQuery = true)
    Product selectById2(Long id);

    @Query(nativeQuery = true, value = "select p.id, p.name, p.description from products p where p.id =:id")
    ProductInfo getProductInfo(long id);


    Page<Product> findAll(Pageable pageable);
}

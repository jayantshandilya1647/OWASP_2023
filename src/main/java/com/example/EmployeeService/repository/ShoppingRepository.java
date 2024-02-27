package com.example.EmployeeService.repository;

import com.example.EmployeeService.model.Shopping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingRepository extends CrudRepository<Shopping,Long> {
    @Query(nativeQuery = true, value = "SELECT * from SHOPPING WHERE PRODUCT_ID=? AND USER_ID = ?")
    Optional<Shopping> fetchWithUser(Long itemId, Long UserId);

    @Query(nativeQuery = true, value = "SELECT * from SHOPPING WHERE USER_ID = ?")
    List<Shopping> fetchUser(Long UserId);

}


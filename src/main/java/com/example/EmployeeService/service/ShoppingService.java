package com.example.EmployeeService.service;

import com.example.EmployeeService.model.Shopping;
import com.example.EmployeeService.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingService {
    @Autowired
    private final ShoppingRepository repository;

    public ShoppingService(ShoppingRepository repo){this.repository=repo;}

    public Optional<Shopping> getCart(Long id)
    {
        return repository.findById(id);

    }

    public List<Shopping> getUserCart(Long id)
    {
        return repository.fetchUser(id);

    }

    public Optional<Shopping> getCartForUser(Long id, Long userId)
    {
        return repository.fetchWithUser(id, userId);

    }
}

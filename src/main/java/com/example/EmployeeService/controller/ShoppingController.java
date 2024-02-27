package com.example.EmployeeService.controller;

import org.springframework.ui.Model;
import com.example.EmployeeService.model.Shopping;
import com.example.EmployeeService.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ShoppingController {

    @Autowired
    private ShoppingService service;

    @GetMapping("/cart/{id}")
    public Optional<Shopping> getCartDetails(@PathVariable("id") Long id)
    {
        return service.getCart(id);
    }

    @GetMapping("/user/cart/{user}")
    public List<Shopping> getAllCartDetails(@PathVariable("user") Long userId, Model model)

    {
        model.addAttribute("name","Shilpa");
        return service.getUserCart(userId);
    }

    @GetMapping("/user/cart")
    public String getAllUserCartDetails( Model model)

    {
        model.addAttribute("name","Shilpa");
        return "shoppingCart";
    }

    @GetMapping("/cart/details/{id}")
    public Optional<Shopping> getCartSpecificDetails(@PathVariable("id") Long id,
                                                     @RequestHeader("Authorization")String token,
                                                     @RequestHeader("Userid")Long userId)
    {
        if(token !=null && token.equalsIgnoreCase("humanresource"))
            return service.getCartForUser(id, userId);
        else
            throw new RuntimeException("User is NOT authorized !");
    }
}

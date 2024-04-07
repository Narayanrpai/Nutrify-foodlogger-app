package com.narayan.foodlogger.bootstrap;

import com.narayan.foodlogger.repositories.CategoryRepository;
import com.narayan.foodlogger.repositories.ProductRepository;
import com.narayan.foodlogger.repositories.UserRepository;
import com.narayan.foodlogger.model.Category;
import com.narayan.foodlogger.model.Product;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Builder
public class Bootstrap implements CommandLineRunner {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    public Bootstrap(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll().block();
        categoryRepository.deleteAll().block();
        //userRepository.deleteAll().block();

        productRepository.save(Product.builder().name("products").calories(250.0).description("A Great Product").build()).block();

        categoryRepository.save(Category.builder().name("Category1").description("Spicy").build()).block();

        //userRepository.save(User.builder().firstName("Stevie").lastName("Murphy").username("smurphy94").email("smurphy54321@gmail.com").password("password").roles("USER, TEST").active(true).build()).block();
        //userRepository.save(User.builder().firstName("Andrea").lastName("Lee-Murphy").username("anlee").email("anlee@tcd.ie").password("password").roles("USER, TEST").active(true).build()).block();
    }
}

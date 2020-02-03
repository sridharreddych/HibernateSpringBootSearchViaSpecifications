package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nCall fetchAuthors():");
            bookstoreService.fetchAuthors();

            System.out.println("\nCall fetchBooksPage():");
            bookstoreService.fetchBooksPage(0, 2);
        };
    }
}


/*
 * 
 * 
 * 
 * 
 * 
 * How To Implement Advanced Search Via Specification

Description: This application is an example of implementing an advanced search via Specification API. Mainly, you can give the search filters to a generic Specification and fetch the result set. Pagination is supported as well. You can chain expressions via logical AND and OR to create compound filters. Nevertheless, there is room for extensions to add brackets support (e.g., (x AND y) OR (x AND z)), more operations, conditions parser and so on and forth.

Key points:

write a generic Specification

 */

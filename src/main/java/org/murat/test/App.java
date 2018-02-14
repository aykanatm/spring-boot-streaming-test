package org.murat.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.content.commons.repository.Store;
import org.springframework.content.rest.StoreRestResource;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @StoreRestResource(path="test-videos")
    public interface VideoStore extends Store<String> {}
}

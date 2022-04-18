package ru.gb.less2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean(ProductService.class);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextLine()) {
                switch (scanner.nextLine()) {
                    case "all":
                        System.out.println("Все продукты:");
                        System.out.println(productService.getAllProduct());
                        break;
                    case "put":
                        System.out.println("Введите id товара для добавления в корзину:");
                        productService.putInCart(scanner.nextLong());
                        break;
                    case "remove":
                        System.out.println("Введите id товара для удаления из корзины:");
                        productService.removeFromCart(scanner.nextLong());
                        break;
                    case "cart":
                        System.out.println("Продукты в корзине:");
                        System.out.println(productService.showCart());
                        break;
                    case "end":
                        return;
                }
            }
        }
    }
}

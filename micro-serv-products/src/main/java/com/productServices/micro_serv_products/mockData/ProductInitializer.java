package com.productServices.micro_serv_products.mockData;
import com.productServices.micro_serv_products.model.Product;
import com.productServices.micro_serv_products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository; // Asegúrate de tener este repositorio

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = Arrays.asList(
                Product.builder()
                        .name("Laptop")
                        .description("Laptop de alto rendimiento")
                        .price(999.99)
                        .stock(15L)
                        .build(),
                Product.builder()
                        .name("Mouse")
                        .description("Mouse óptico")
                        .price(19.99)
                        .stock(50L)
                        .build(),
                Product.builder()
                        .name("Keyboard")
                        .description("Teclado mecánico")
                        .price(49.99)
                        .stock(30L)
                        .build(),
                Product.builder()
                        .name("Smartphone")
                        .description("Smartphone con cámara de 48MP")
                        .price(599.99)
                        .stock(20L)
                        .build(),
                Product.builder()
                        .name("Tablet")
                        .description("Tablet con pantalla de 10 pulgadas")
                        .price(399.99)
                        .stock(25L)
                        .build(),
                Product.builder()
                        .name("Monitor")
                        .description("Monitor LED de 24 pulgadas")
                        .price(99.99)
                        .stock(10L)
                        .build(),
                Product.builder()
                        .name("Printer")
                        .description("Impresora a color")
                        .price(149.99)
                        .stock(8L)
                        .build(),
                Product.builder()
                        .name("External Hard Drive")
                        .description("Disco duro externo de 1TB")
                        .price(79.99)
                        .stock(12L)
                        .build(),
                Product.builder()
                        .name("Router")
                        .description("Router Wi-Fi de alta velocidad")
                        .price(199.99)
                        .stock(18L)
                        .build(),
                Product.builder()
                        .name("Graphics Card")
                        .description("Tarjeta gráfica para gamers")
                        .price(299.99)
                        .stock(5L)
                        .build(),
                Product.builder()
                        .name("Headphones")
                        .description("Auriculares inalámbricos")
                        .price(24.99)
                        .stock(40L)
                        .build(),
                Product.builder()
                        .name("Smartwatch")
                        .description("Reloj inteligente con monitor de salud")
                        .price(229.99)
                        .stock(22L)
                        .build()
        );


        productRepository.saveAll(products);
    }
}

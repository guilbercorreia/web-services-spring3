package com.projetowebservices.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetowebservices.demo.entities.Category;
import com.projetowebservices.demo.entities.Order;
import com.projetowebservices.demo.entities.OrderItem;
import com.projetowebservices.demo.entities.Product;
import com.projetowebservices.demo.entities.User;
import com.projetowebservices.demo.entities.enums.OrderStatus;
import com.projetowebservices.demo.repositories.CategoryRepository;
import com.projetowebservices.demo.repositories.OrderItemRepository;
import com.projetowebservices.demo.repositories.OrderRepository;
import com.projetowebservices.demo.repositories.ProductRepository;
import com.projetowebservices.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Estevão Ferreia", "estevao.f@gmail.com", "88888888", "12345678");
		User u2 = new User(null, "Alex Marques", "alex.m@gmail.com", "77777777", "12345678");

		Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
		Order o2 = new Order(null, Instant.parse("2023-06-21T03:42:10Z"), u2, OrderStatus.CANCELED);
		Order o3 = new Order(null, Instant.parse("2023-06-22T15:21:22Z"), u1, OrderStatus.DELIVERED);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		Product p1 = new Product(null, "O Senhor dos Aneis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Arquitetura limpa", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Category cat1 = new Category(null, "Electronicos");
		Category cat2 = new Category(null, "Livros");
		Category cat3 = new Category(null, "PC");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

	}
}

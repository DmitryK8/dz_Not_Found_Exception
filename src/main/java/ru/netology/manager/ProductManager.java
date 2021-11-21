package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository = new ProductRepository();
    private Product[] products = new Product[0];


    public ProductManager(ProductRepository repository) { this.repository = repository;
    }
    public ProductManager() {

    }

    public void add(Product  product) {
        repository.save(product);
    }

    public Product[] getAll() {
        Product[] products = repository.findAll();
        Product[] result = new Product[products.length];
        for (int i =0; i < result.length; i++) {
            int index = products.length - i - 1;
            result[i] = products[index];
        }
        return result;

    }

    public Product[] searchById(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(products, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;

    }
    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }

            return false;
        }

        if (product instanceof TShirt) {
            TShirt smartphone = (TShirt) product;
            if (smartphone.getProduction().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }

        return false;
    }
}
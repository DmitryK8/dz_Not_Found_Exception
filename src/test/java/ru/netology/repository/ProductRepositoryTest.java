package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book goodBook = new Book(1, "GoodBook", 1000, "Толстой");
    private Book goodBook8 = new Book(11, "Good Book8", 1107, "Дмитрий Кравченко");
    private Book goodBook17 = new Book(117, "Good Book17 ", 2060, "Вася Пупкин");

    @BeforeEach
    public void shouldSetUp() {
        repository.save(goodBook);
        repository.save(goodBook8);
        repository.save(goodBook17);

    }

    @Test
    public void shouldRemoveById() {
        Product expected = goodBook8;
        Product actual = repository.findById(11);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdNot() {
        Product expected = null;
        assertThrows(NotFoundException.class, () -> repository.removeById(1000));
    }


}
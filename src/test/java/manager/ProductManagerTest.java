package manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductManagerTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);


    Book book1 = new Book(1, "book1", 500, "Author1");
    Book book2 = new Book(2, "book2", 1500, "Author1");
    Book book3 = new Book(3, "book3", 400, "Author2");
    Book book4 = new Book(4, "Glossary1", 2500, "Author3");
    Book book5 = new Book(5, "book5", 200, "Author4");
    Book book6 = new Book(6, "book6", 500, "Author1");
    Book book7 = new Book(7, "book7", 800, "Author5");
    Book book8 = new Book(8, "Glossary2", 3500, "Author6");
    Book book9 = new Book(9, "book4", 7500, "Author7");
    Book book10 = new Book(10, "book8", 1300, "Author8");
    Book book11 = new Book(11, "BookOnBook", 1200, "Author3");

    Smartphone smartphone1 = new Smartphone(1001, "Smartphone1", 15000, "Manufacturer1");
    Smartphone smartphone2 = new Smartphone(1002, "Smartphone2", 25000, "Manufacturer1");
    Smartphone smartphone3 = new Smartphone(1003, "Smartphone3", 5000, "Manufacturer2");
    Smartphone smartphone4 = new Smartphone(1004, "Smartphone4", 75000, "Manufacturer4");
    Smartphone smartphone5 = new Smartphone(1005, "Slider1", 1500, "Manufacturer3");
    Smartphone smartphone6 = new Smartphone(1006, "Smartphone6", 7500, "Manufacturer2");
    Smartphone smartphone7 = new Smartphone(1007, "Slider2", 25000, "Manufacturer5");
    Smartphone smartphone8 = new Smartphone(1008, "EliteSmartphone1", 1005000, "Manufacturer6");
    Smartphone smartphone9 = new Smartphone(1009, "Smartphone5", 13000, "Manufacturer1");
    Smartphone smartphone10 = new Smartphone(1010, "Smartphone", 8000, "Manufacturer4");
    Smartphone smartphone11 = new Smartphone(1011, "Smartphone8", 5000, "Manufacturer7");
    Smartphone smartphone12 = new Smartphone(1012, "Smartphone9", 15500, "Manufacturer8");
    Smartphone smartphone13 = new Smartphone(1013, "EliteSmartphone2", 1500000, "Manufacturer6");


    @Test
    public void findBook() { //поиск по слову которое существует в массиве
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(book5);
        manager.addProduct(book6);
        manager.addProduct(book7);
        manager.addProduct(book8);
        manager.addProduct(book9);
        manager.addProduct(book10);
        manager.addProduct(book11);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
        manager.addProduct(smartphone4);
        manager.addProduct(smartphone5);
        manager.addProduct(smartphone6);
        manager.addProduct(smartphone7);
        manager.addProduct(smartphone8);
        manager.addProduct(smartphone9);
        manager.addProduct(smartphone10);
        manager.addProduct(smartphone11);
        manager.addProduct(smartphone12);
        manager.addProduct(smartphone13);

        Product[] expected = {book1, book2, book3, book5, book6, book7, book9, book10};
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findNontBook() {// поиск по слову которого нет в массиве
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(book5);
        manager.addProduct(book6);
        manager.addProduct(book7);
        manager.addProduct(book8);
        manager.addProduct(book9);
        manager.addProduct(book10);
        manager.addProduct(book11);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
        manager.addProduct(smartphone4);
        manager.addProduct(smartphone5);
        manager.addProduct(smartphone6);
        manager.addProduct(smartphone7);
        manager.addProduct(smartphone8);
        manager.addProduct(smartphone9);
        manager.addProduct(smartphone10);
        manager.addProduct(smartphone11);
        manager.addProduct(smartphone12);
        manager.addProduct(smartphone13);

        Product[] expected = {};
        Product[] actual = manager.searchBy("bok");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findSmartphone() { //поиск по слову из другой группы товаров
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(book5);
        manager.addProduct(book6);
        manager.addProduct(book7);
        manager.addProduct(book8);
        manager.addProduct(book9);
        manager.addProduct(book10);
        manager.addProduct(book11);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
        manager.addProduct(smartphone4);
        manager.addProduct(smartphone5);
        manager.addProduct(smartphone6);
        manager.addProduct(smartphone7);
        manager.addProduct(smartphone8);
        manager.addProduct(smartphone9);
        manager.addProduct(smartphone10);
        manager.addProduct(smartphone11);
        manager.addProduct(smartphone12);
        manager.addProduct(smartphone13);

        Product[] expected = {smartphone8, smartphone13};
        Product[] actual = manager.searchBy("EliteSmartphone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removed() {// удаление с существуещем id
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone5);
        manager.addProduct(smartphone6);
        manager.addProduct(smartphone7);
        manager.addProduct(smartphone8);
        manager.addProduct(smartphone9);
        manager.addProduct(smartphone10);

        repo.removeProductId(1008);

        Product[] expected = {book1, book2, book3, book4, smartphone5, smartphone6, smartphone7, smartphone9, smartphone10};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removedIdNot() {// удаление id которого нет
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone5);
        manager.addProduct(smartphone6);
        manager.addProduct(smartphone7);
        //manager.addProduct(smartphone8);
        manager.addProduct(smartphone9);
        manager.addProduct(smartphone10);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeProductId(1008));
    }

    @Test
    public void getAuthors() {//  сетера/геттера автора
        Book author = new Book(3, "book3", 400, "Author2");

        author.setAuthor("Автор1");

        String expected = ("Автор1");
        String actual = author.getAuthor();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void getManufacturer() {// сетер/гетер производитель
        Smartphone manufacturer = new Smartphone(1001, "Smartphone1", 15000, "Manufacturer1");

        manufacturer.setManufacturer("Производитель1");

        String expected = ("Производитель1");
        String actual = manufacturer.getManufacturer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getProduct() {//сеттер/гетер id и цена
        Product product = new Product(0, "name", 0);

        product.setId(66);
        product.setName("ProductName");
        product.setPrice(2000);

        int[] expected = {66, 2000};
        int[] actual = {product.getId(), product.getPrice()};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getProductName() {//сетер/гетер наименование
        Product product = new Product(0, "name", 0);

        product.setId(66);
        product.setName("ProductName");
        product.setPrice(2000);

        String expected = ("ProductName");
        String actual = product.getName();

        Assertions.assertEquals(expected, actual);
    }
}
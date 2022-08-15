package manager;

public class Repository {

    Product[] products = new Product[0];

    public void addProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;

    }

    public void removeProductId(int id) {
        if (findById(id) == null){
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int index = 0;
        Product[] tmp = new Product[products.length - 1];// удаление id
        for (
                Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
            products = tmp;
        }
    }

    public Product findById(int id){
        Product result= null;
        for (Product product: products) {
            if (product.getId() == id){
                result=product;
            }
        }
        return result;
    }

    public Product[] findAll() {
        return products;
    }
}

package Zad2;

public class ProductInBasket extends Product {
    public int quantityOfProduct = 0;

    public ProductInBasket(String name, double price, int quantityOfProduct) {
        super(name, price);
        this.quantityOfProduct = quantityOfProduct;
    }

    public void setQuantityOfProduct(int quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }
}

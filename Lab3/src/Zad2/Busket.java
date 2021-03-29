package Zad2;

import java.util.LinkedList;

public class Busket {
    public LinkedList<ProductInBasket> productsInBusket = new LinkedList<>();

    public void putProductInBusket (ProductInBasket productName){
        this.productsInBusket.addFirst(productName);
    }

    public void pullProductOutOfBusket(){
        this.productsInBusket.removeFirst();
    }

    public LinkedList<ProductInBasket> getProductsInBusket() {
        return productsInBusket;
    }

    @Override
    public String toString() {
        return "" +
                productsInBusket;

    }

}

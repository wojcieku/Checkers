package Zad2;

import java.util.LinkedList;

public class Busket {
    public LinkedList<ProductInBasket> productsInBusket = new LinkedList<>();

    @Override
    public String toString() {
        return "Busket{" +
                "productsInBusket=" + productsInBusket +
                '}';
    }

    public void putProductInBusket (ProductInBasket productName){
        this.productsInBusket.addFirst(productName);
    }
}

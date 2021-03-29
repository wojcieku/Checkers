package Zad2;

import java.util.*;

public class Checkout {
    public static void service(LinkedList<Client> list) {
        for(var client : list){
            double sum = 0;
            Busket busket = client.busket;
            for(var temp:busket.productsInBusket){
                sum += (temp.price* temp.quantityOfProduct);
            }
            System.out.println(client.surname+"busket content: "+busket);
            System.out.println(client.surname+" should pay: "+sum);

        }
    }

    public static void main(String[] args) {
        Product banana = new Product("banana", 1);
        Product bread = new Product("bread", 2);
        Product milk = new Product("milk", 3);
        Product beer = new Product("beer", 5);
        Product butter = new Product("butter", 4);
        Product pasta = new Product("pasta", 5);
        Product ham = new Product("ham", 6);
        Product cheese = new Product("cheese", 3);
        Product oil = new Product("oil", 4);
        Product passata = new Product("passata", 3.5);
        Product candy = new Product("candy", 2.2);

        List<Product> listOfProducts = Arrays.asList(
                banana, bread, milk, beer, butter, pasta, ham, cheese, oil, passata, candy
        );

        ProductInBasket p1 = new ProductInBasket(banana.name, banana.price, 3);
        ProductInBasket p2 = new ProductInBasket(banana.name, banana.price, 5);
        ProductInBasket p3 = new ProductInBasket(bread.name, bread.price, 2);
        ProductInBasket p4 = new ProductInBasket(beer.name, beer.price, 5);

        Busket BondBusket = new Busket();
        Busket Xbusket = new Busket();
        Busket Ybusket = new Busket();

        BondBusket.putProductInBusket(p1);
        BondBusket.putProductInBusket(p3);
        BondBusket.putProductInBusket(p4);

        Xbusket.putProductInBusket(p1);
        Xbusket.putProductInBusket(p3);

        Ybusket.putProductInBusket(p2);
        Ybusket.putProductInBusket(p4);

        LinkedList<Client> clientList = new LinkedList<>();
        LinkedList<Client> queue = new LinkedList<>();


        Client c1 = new Client("Bond", BondBusket);
        Client c2 = new Client("X", Xbusket);
        Client c3 = new Client("Y", Ybusket);

        clientList.add(c1);
        clientList.add(c2);
        clientList.add(c3);

        queue.addLast(c2);
        queue.addLast(c3);
        queue.addLast(c1);

        service(queue);
    }
}

package Zad2;

public class Client {
    public String surname;
    public Busket busket;

    public Client(String surname, Busket busket) {
        this.surname = surname;
        this.busket = busket;
    }

    public void setBusket(Busket busket) {
        this.busket = busket;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Busket getBusket() {
        return busket;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "surname='" + surname + '\'' +
                ", busket=" + busket +
                '}';
    }
}

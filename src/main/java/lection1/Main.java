package lection1;

import lection1.models.Laptop;
import lection1.models.NetworkPrinter;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Hp", 24, 16);
        NetworkPrinter printer = new NetworkPrinter("HP", 12);

        laptop.displaySpecifications();
        laptop.turnOn();
        laptop.connect("Office_Network");
        laptop.enablePowerSaving();
        System.out.println("Скорость соединения: " + laptop.getConnectionSpeed() + " Мбит/с");

        System.out.println("\n");

        printer.displaySpecifications();
        printer.turnOn();
        printer.connect("Office_Network");
        printer.print(50);
        printer.replaceToner();

        System.out.println("\nВсего устройств: " + lection1.abstracts.ComputerEquipment.getTotalDevices());
    }
}
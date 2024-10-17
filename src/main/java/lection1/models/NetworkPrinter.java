package lection1.models;

import lection1.abstracts.ComputerEquipment;
import lection1.interfaces.NetworkConnection;
import lection1.interfaces.PowerManagement;

public class NetworkPrinter extends ComputerEquipment implements PowerManagement, NetworkConnection {
    private int tonerLevel;
    private boolean isPowered;
    private String currentNetwork;
    private int printedPages;

    public NetworkPrinter(String manufacturer, int warrantyMonths) {
        super(manufacturer, warrantyMonths);
        this.tonerLevel = 100;
        this.isPowered = false;
        this.printedPages = 0;
        this.currentNetwork = null;
    }

    public boolean print(int pages) {
        if (isPowered && tonerLevel > 0 && !isDefective) {
            if (tonerLevel >= pages) {
                tonerLevel -= pages;
                printedPages += pages;
                System.out.println("Напечатано страниц: " + pages);
                return true;
            } else {
                System.out.println("Недостаточно тонера");
            }
        }
        return false;
    }

    public void replaceToner() {
        if (!isPowered) {
            tonerLevel = 100;
            System.out.println("Тонер заменен");
        } else {
            System.out.println("Выключите принтер перед заменой тонера");
        }
    }

    @Override
    public void turnOn() {
        isPowered = true;
        System.out.println("Принтер включен");
    }

    @Override
    public void turnOff() {
        isPowered = false;
        disconnect();
        System.out.println("Принтер выключен");
    }

    @Override
    public boolean isPowered() {
        return isPowered;
    }

    @Override
    public void enablePowerSaving() {
        if (isPowered) {
            System.out.println("Режим энергосбережения принтера включен");
        }
    }

    @Override
    public boolean connect(String network) {
        if (isPowered && !isDefective) {
            this.currentNetwork = network;
            return true;
        }
        return false;
    }

    @Override
    public void disconnect() {
        this.currentNetwork = null;
    }

    @Override
    public int getConnectionSpeed() {
        return currentNetwork != null ? 100 : 0;
    }

    @Override
    public String getCurrentNetwork() {
        return currentNetwork;
    }

    @Override
    public void displaySpecifications() {
        System.out.println("Сетевой принтер " + manufacturer);
        System.out.println("Уровень тонера: " + tonerLevel + "%");
        System.out.println("Отпечатано страниц: " + printedPages);
        System.out.println("Гарантия: " + (isUnderWarranty() ? "Активна" : "Истекла"));
    }
}
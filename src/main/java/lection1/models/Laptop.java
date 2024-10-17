package lection1.models;

import lection1.abstracts.ComputerEquipment;
import lection1.interfaces.NetworkConnection;
import lection1.interfaces.PowerManagement;

public class Laptop extends ComputerEquipment implements PowerManagement, NetworkConnection {
    private int batteryLevel;
    private boolean isPowered;
    private String currentNetwork;
    private int ramGB;
    private boolean powerSavingMode;

    public Laptop(String manufacturer, int warrantyMonths, int ramGB) {
        super(manufacturer, warrantyMonths);
        this.batteryLevel = 100;
        this.isPowered = false;
        this.ramGB = ramGB;
        this.powerSavingMode = false;
        this.currentNetwork = null;
    }

    @Override
    public void turnOn() {
        if (!isDefective && batteryLevel > 0) {
            isPowered = true;
            System.out.println("Ноутбук включен. Уровень батареи: " + batteryLevel + "%");
        } else {
            System.out.println("Невозможно включить ноутбук");
        }
    }

    @Override
    public void turnOff() {
        isPowered = false;
        disconnect();
        System.out.println("Ноутбук выключен");
    }

    @Override
    public boolean isPowered() {
        return isPowered;
    }

    @Override
    public void enablePowerSaving() {
        if (isPowered) {
            powerSavingMode = true;
            System.out.println("Режим энергосбережения включен");
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
        if (currentNetwork != null) {
            return powerSavingMode ? 50 : 100;
        }
        return 0;
    }

    @Override
    public String getCurrentNetwork() {
        return currentNetwork;
    }

    public void chargeBattery(int minutes) {
        int chargeIncrease = minutes / 2;
        batteryLevel = Math.min(100, batteryLevel + chargeIncrease);
        System.out.println("Батарея заряжена до " + batteryLevel + "%");
    }

    @Override
    public void displaySpecifications() {
        System.out.println("Ноутбук " + manufacturer);
        System.out.println("RAM: " + ramGB + "GB");
        System.out.println("Батарея: " + batteryLevel + "%");
        System.out.println("Гарантия: " + (isUnderWarranty() ? "Активна" : "Истекла"));
    }
}

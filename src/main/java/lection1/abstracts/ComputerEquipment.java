package lection1.abstracts;

public abstract class ComputerEquipment {
    protected String manufacturer;
    protected int warrantyMonths;
    protected static int totalDevices = 0;
    protected boolean isDefective;

    public ComputerEquipment(String manufacturer, int warrantyMonths) {
        this.manufacturer = manufacturer;
        this.warrantyMonths = warrantyMonths;
        this.isDefective = false;
        totalDevices++;
    }

    public abstract void displaySpecifications();

    public static int getTotalDevices() {
        return totalDevices;
    }

    protected boolean isUnderWarranty() {
        return warrantyMonths > 0;
    }

    public void reportDefect() {
        this.isDefective = true;
        System.out.println("Дефект зарегистрирован");
    }
}
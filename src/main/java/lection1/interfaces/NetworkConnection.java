package lection1.interfaces;

public interface NetworkConnection {
    boolean connect(String network);
    void disconnect();
    int getConnectionSpeed();
    String getCurrentNetwork();
}
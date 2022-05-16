package ro.info.uaic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client());
        clientList.add(new Client());
        clientList.add(new Client());
        clientList.add(new Client());

        for (Client client : clientList) {
            client.run();
        }

    }
}
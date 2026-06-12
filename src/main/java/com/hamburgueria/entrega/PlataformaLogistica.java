package com.hamburgueria.entrega;

import java.util.List;

public class PlataformaLogistica {

    public String dispatchOrder(int orderId, String address, List<String> itemNames) {
        return String.format("EXT-%04d | %s | %s", orderId, address, itemNames);
    }
}

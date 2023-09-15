class Inventory {
     int quantity;
     int lowOrderLevelQuantity;

   Inventory(int quantity, int lowOrderLevelQuantity) {
        this.quantity = quantity;
        this.lowOrderLevelQuantity = lowOrderLevelQuantity;
    }
}

class Accessories extends Inventory {
     String description;
     int uniqueId;

     Accessories(int quantity, String description, int uniqueId) {
        super(quantity, 5); // Accessories have a low order level quantity of 5
        this.description = description;
        this.uniqueId = uniqueId;
    }
}

class Laptop extends Inventory {
     String model;
     int uniqueId;

   Laptop(int quantity, String model, int uniqueId) {
        super(quantity, 3); // Laptops have a low order level quantity of 3
        this.model = model;
        this.uniqueId = uniqueId;
    }
}

class Order {
     Inventory item;
     int orderedQuantity;

    Order(Inventory item, int orderedQuantity) {
        this.item = item;
        this.orderedQuantity = orderedQuantity;
    }

     String processOrder() {
        if (orderedQuantity <= item.quantity) {
            item.quantity -= orderedQuantity;
            return "Invoice generated.";
        } else if (orderedQuantity <= item.lowOrderLevelQuantity) {
            return "Request for Material (RFM) generated.";
        } else {
            return "Insufficient stock to fulfill the order.";
        }
    }
}

class wholesale {
    public static void main(String[] args) {
        // Create 5 laptops and 10 Accessories objects
        Laptop[] laptops = new Laptop[5];
        Accessories[] accessories = new Accessories[10];

        for (int i = 0; i < 5; i++) {
            laptops[i] = new Laptop(5, "Model " + (i + 1), i + 1);
        }

        for (int i = 0; i < 10; i++) {
            accessories[i] = new Accessories(10, "Accessory " + (i + 1), i + 1);
        }

        // Customer places orders
        Order[] orders = {
            new Order(laptops[0], 2),
            new Order(accessories[2], 7),
            new Order(laptops[3], 5),
            new Order(accessories[7], 3),
            new Order(laptops[2], 4),
            new Order(accessories[0], 2),
            new Order(laptops[4], 6),
            new Order(accessories[9], 9),
            new Order(laptops[1], 4),
            new Order(accessories[3], 3)
        };

        // Process the orders and print the results
        for (int i = 0; i < orders.length; i++) {
            String result = orders[i].processOrder();
            System.out.println("Order " + (i + 1) + ": " + result);
        }
    }
}

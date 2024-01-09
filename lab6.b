import java.util.*;

class EnhancedOrderFulfillmentSystem {
    private List<Order> orders = new ArrayList<>();
    private Inventory inventory = new Inventory();

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public Order getOrderToProcess() {
        if (!orders.isEmpty()) {
            return orders.remove(0);
        }
        return null;
    }

    public void startProcessing() {
        Thread producerThread = new Thread(new Producer(this));
        Thread consumerThread = new Thread(new Consumer(this));

        producerThread.start();
        consumerThread.start();

        // Wait for the threads to finish processing
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        inventory.viewInventory();
    }

    public void waitForCompletion() {
        // Simulate waiting for orders to be processed
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All orders processed successfully.");
    }

    public boolean updateInventory(Order order) {
        return inventory.processOrder(order);
    }

    public boolean checkInventoryAvailability(Item item) {
        return inventory.checkAvailability(item);
    }

    public void trackOrderStatus(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                System.out.println("Order " + orderId + " status: " + order.getStatus());
                return;
            }
        }
        System.out.println("Order " + orderId + " not found.");
    }

    private static class Inventory {
        private Map<String, Integer> stock;

        public Inventory() {
            this.stock = new HashMap<>();
            initializeInventory();
        }

        private void initializeInventory() {
            // Initialize inventory with some items
            stock.put("ProductA", 20);
            stock.put("ProductB", 15);
            stock.put("ProductC", 25);
            stock.put("ProductD", 30);
        }

        public synchronized boolean processOrder(Order order) {
            for (Item item : order.getItems()) {
                if (checkAvailability(item)) {
                    int currentQuantity = stock.getOrDefault(item.getProductName(), 0);
                    int orderedQuantity = item.getQuantity();

                    if (orderedQuantity > 0) {
                        stock.put(item.getProductName(), currentQuantity - orderedQuantity);
                        System.out.println("Removed " + orderedQuantity + " units of " + item.getProductName() + " from the inventory.");
                    }
                } else {
                    return false; // Insufficient inventory
                }
            }
            order.setStatus(OrderStatus.COMPLETED);
            return true;
        }

        public synchronized boolean checkAvailability(Item item) {
            return stock.getOrDefault(item.getProductName(), 0) >= item.getQuantity();
        }

        public synchronized void viewInventory() {
            System.out.println("Remaining Inventory:");
            for (Map.Entry<String, Integer> entry : stock.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " units");
            }
        }
    }

    private static class Producer implements Runnable {
        private EnhancedOrderFulfillmentSystem system;

        public Producer(EnhancedOrderFulfillmentSystem system) {
            this.system = system;
        }

        @Override
        public void run() {
            Random random = new Random();

            for (int i = 0; i < 5; i++) {
                List<Item> items = new ArrayList<>();
                items.add(new Item("ProductA", random.nextInt(5) + 1));  // Random quantity between 1 and 5
                items.add(new Item("ProductB", random.nextInt(5) + 1));
                items.add(new Item("ProductC", random.nextInt(5) + 1));
                items.add(new Item("ProductD", random.nextInt(5) + 1));

                Order order = new Order(i + 1, items);
                system.placeOrder(order);

                try {
                    Thread.sleep(random.nextInt(2000) + 1000);  // Sleep between 1 and 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        private EnhancedOrderFulfillmentSystem system;

        public Consumer(EnhancedOrderFulfillmentSystem system) {
            this.system = system;
        }

        @Override
        public void run() {
            while (true) {
                Order order = system.getOrderToProcess();
                if (order != null) {
                    boolean success = system.updateInventory(order);
                    if (success) {
                        System.out.println("Order " + order.getOrderId() + " processed successfully.");
                    } else {
                        System.out.println("Insufficient inventory for Order " + order.getOrderId());
                    }
                }

                try {
                    Thread.sleep(1000);  // Sleep for 1 second before processing the next order
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        EnhancedOrderFulfillmentSystem system = new EnhancedOrderFulfillmentSystem();

        system.startProcessing();
        system.waitForCompletion();
    }
}

class Order {
    private static int orderIdCounter = 1;
    private int orderId;
    private List<Item> items;
    private OrderStatus status;

    public Order(int orderId, List<Item> items) {
        this.orderId = orderIdCounter++;
        this.items = items;
        this.status = OrderStatus.PENDING;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

class Item {
    private String productName;
    private int quantity;

    public Item(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}

enum OrderStatus {
    PENDING, COMPLETED
}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class OrderProcessingError extends Exception {
    public OrderProcessingError(String message) {
        super(message);
    }
}

class InventoryShortageError extends OrderProcessingError {
    public InventoryShortageError(String message) {
        super(message);
    }
}

class OrderCancellationError extends OrderProcessingError {
    public OrderCancellationError(String message) {
        super(message);
    }
}

enum OrderProcessingStatus {
    PROCESSING, COMPLETED, CANCELLED
}

class Product {
    public String name;
    public int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}

class SalesOrder {
    public int orderId;
    public List<Product> products;
    public OrderProcessingStatus status;

    public SalesOrder(int orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.status = OrderProcessingStatus.COMPLETED;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderProcessingStatus getStatus() {
        return status;
    }

    public void setStatus(OrderProcessingStatus status) {
        this.status = status;
    }
}

public class AdvancedOrderProcessingSystem {

    private List<SalesOrder> salesOrders;
    private Map<String, Integer> stock;
    private final Object lock = new Object();

    public AdvancedOrderProcessingSystem() {
        salesOrders = new ArrayList<>();
        stock = new HashMap<>();
    }

    public synchronized void initiateSalesOrder(SalesOrder salesOrder) {
        salesOrders.add(salesOrder);
        System.out.println("Sales Order " + salesOrder.getOrderId() + " initiated");
    }

    public synchronized void updateStock(SalesOrder salesOrder) throws InventoryShortageError {
        for (Product product : salesOrder.getProducts()) {
            String productName = product.getName();
            int productQuantity = product.getQuantity();

            if (stock.containsKey(productName)) {
                int currentQuantity = stock.get(productName);
                if (currentQuantity >= productQuantity) {
                    stock.put(productName, currentQuantity - productQuantity);
                } else {
                    throw new InventoryShortageError("Insufficient stock for product: " + productName);
                }
            } else {
                throw new InventoryShortageError("Product " + productName + " not found in the stock");
            }
        }
    }

    public synchronized boolean checkStockAvailability(Product product) {
        int availableQuantity = stock.getOrDefault(product.getName(), 0);
        return availableQuantity >= product.getQuantity();
    }

    public void commenceProcessing() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (SalesOrder salesOrder : salesOrders) {
            executor.execute(() -> {
                try {
                    synchronized (lock) {
                        updateStock(salesOrder);
                    }
                    salesOrder.setStatus(OrderProcessingStatus.COMPLETED);
                    System.out.println("Sales Order " + salesOrder.getOrderId() + " processed");
                } catch (InventoryShortageError e) {
                    salesOrder.setStatus(OrderProcessingStatus.CANCELLED);
                    System.out.println("Sales Order " + salesOrder.getOrderId() + " cancelled " + e.getMessage());
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
    }

    public void awaitCompletion() {
        commenceProcessing();
    }

    public synchronized OrderProcessingStatus trackOrderStatus(int orderId) {
        for (SalesOrder salesOrder : salesOrders) {
            if (salesOrder.getOrderId() == orderId) {
                return salesOrder.getStatus();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        AdvancedOrderProcessingSystem aops = new AdvancedOrderProcessingSystem();

        aops.stock.put("Product1", 10);
        aops.stock.put("Product2", 5);
        aops.stock.put("Product3", 8);

        List<Product> products1 = List.of(new Product("Product1", 2), new Product("Product2", 1));
        List<Product> products2 = List.of(new Product("Product3", 12));

        SalesOrder salesOrder1 = new SalesOrder(1, products1);
        SalesOrder salesOrder2 = new SalesOrder(2, products2);

        System.out.println("");
        System.out.println("Advanced Order Processing System");
        System.out.println("---------------------------------");
        System.out.println("");

        aops.initiateSalesOrder(salesOrder1);
        aops.initiateSalesOrder(salesOrder2);

        aops.awaitCompletion();

        System.out.println(aops.trackOrderStatus(1));
        System.out.println(aops.trackOrderStatus(2));
        System.out.println(" ");
    }
}

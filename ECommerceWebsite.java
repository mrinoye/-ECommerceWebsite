package ECom;

import java.util.Scanner;

class OrderException extends Exception {
    public OrderException(String errorMessage) {
        super(errorMessage);}
}

class PaymentException extends OrderException {
    public PaymentException(String errorMessage) {
        super(errorMessage);}
}

class ProductException extends OrderException {
    public ProductException(String errorMessage) {
        super(errorMessage);}
}

class StockException extends ProductException {
    public StockException(String errorMessage) {
        super(errorMessage);}
}

class DeliveryException extends OrderException {
    public DeliveryException(String errorMessage) {
        super(errorMessage);}
}

class Product {
    private int id;
    private String name;
    private int price;
    private int stock;

    public Product(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;}
    
    public int getId() {
        return id;}

    public String getName() {
        return name;}

    public int getPrice() {
        return price;}

    public int getStock() {
        return stock;}

    public void setStock(int stock) {
        this.stock = stock;}
}

class Order {
    private int id;
    private Product product;
    private int quantity;
    private String address;

    public Order(int id, Product product, int quantity, String address) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.address = address;}

    public int getId() {
        return id;}

    public Product getProduct() {
        return product;}

    public int getQuantity() {
        return quantity;}

    public String getAddress() {
        return address;}
}

class Payment {
    private String method;
    private int amount;

    public Payment(String method, int amount) {
        this.method = method;
        this.amount = amount;}

    public String getMethod() {
        return method;}

    public int getAmount() {
        return amount;}
}

class Delivery {
    private String courier;
    private String trackingNumber;

    public Delivery(String courier, String trackingNumber) {
        this.courier = courier;
        this.trackingNumber = trackingNumber;}

    public String getCourier() {
        return courier;}

    public String getTrackingNumber() {
        return trackingNumber;}
}

class ECommerceWebsite {
    private static int orderId = 0;
    private static Product[] products = new Product[3];
    private static Scanner scanner = new Scanner(System.in);

    static {
        products[0] = new Product(1, "Product 1", 100, 10);
        products[1] = new Product(2, "Product 2", 200, 5);
        products[2] = new Product(3, "Product 3", 300, 3);}

    private static Product findProductById(int id) throws ProductException {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;}
        }
        throw new ProductException("Product with id " + id + " not found.");
    }

    private static void placeOrder() throws OrderException {
        System.out.print("Enter product id: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        Product product = findProductById(productId);

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (quantity > product.getStock()) {
            throw new StockException("Insufficient stock for product " + product.getName() + ".");
        }

        System.out.print("Enter delivery address: ");
        String address = scanner.nextLine();

        Order order = new Order(++orderId, product, quantity, address);

        System.out.println("Order placed successfully: " + order.getId());
        try {
            Payment payment = makePayment(order.getProduct().getPrice() * order.getQuantity());
            System.out.println("Payment successful: " + payment.getAmount() + " paid via " + payment.getMethod());

            Delivery delivery = deliverOrder(order.getId());
            System.out.println("Delivery successful: " + delivery.getCourier() + " tracking number " + delivery.getTrackingNumber());
        } catch (PaymentException | DeliveryException e) {
            cancelOrder(order.getId());
            throw e;}
    }

    private static Payment makePayment(int amount) throws PaymentException {
        System.out.print("Enter payment method: ");
        String method = scanner.nextLine();

        if (!method.matches("Credit card")) {
            throw new PaymentException("Invalid payment method.");}

        System.out.print("Enter amount: ");
        int paidAmount = scanner.nextInt();
        scanner.nextLine();

        if (paidAmount < amount) {
            throw new PaymentException("Insufficient payment amount.");}

        return new Payment(method, paidAmount);}

    private static Delivery deliverOrder(int orderId) throws DeliveryException {
    	    System.out.print("Enter courier: ");
    	    String courier = scanner.nextLine();

    	    System.out.print("Enter tracking number: ");
    	    String trackingNumber = scanner.nextLine();

    	    if (!trackingNumber.matches("trck@048")) {
    	        throw new DeliveryException("Invalid tracking number.");}

    	    return new Delivery(courier, trackingNumber);}

    	private static void cancelOrder(int orderId) {
    	    System.out.println("Order " + orderId + " cancelled.");}

    	public static void main(String[] args) {
    	    try {
    	        placeOrder();
    	    } catch (OrderException e) {
    	        System.out.println("Order failed: " + e.getMessage());
    	    } finally {
    	        scanner.close();}
    	}
    }

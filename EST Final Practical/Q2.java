class OrderFacade {
    WarehouseService warehouse = new WarehouseService();
    PaymentService payment = new PaymentService();
    EmailService email = new EmailService();

    public void placeOrder(String productId, double amount, String userEmail) {
        if (warehouse.checkStock(productId) &&
            payment.makePayment(amount)) {
            
            email.sendReceipt(userEmail);
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Order failed!");
        }
    }
}
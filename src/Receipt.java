public class Receipt implements Printable {
        private String storeName;
        private String item;
        private double price;

    @Override
    public String print() {
        double total = price*price;
        System.out.println("hellllo");
        return String.format("---Receipt----%s\nItem--%s\nstoreName,%.2f\n---price----%.2f\n----total",item,storeName,price,total);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.storeName = "SuperMart";
        receipt.item = "Milk";
        receipt.price = 2.99;
        String string= """
                Hello, How are you doing?
                been a long time. 
                no see we met. 
                hope you are doing well.
                """;

        System.out.println(receipt.print());
        System.out.println(string);
    }
}

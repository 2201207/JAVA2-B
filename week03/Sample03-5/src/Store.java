public class Store {
    private Seller seller;
    private Customer customer;

    public Store(Seller seller, Customer customer) {
        this.seller = seller;
        this.customer = customer;
    }

    public void trade(int count) {
        Apple sellerApple = seller.apple;
        int total = count + sellerApple.getInventory();

        if (customer.myMoney >= total) {
            if (seller.apple.getInventory() >= count) {
                seller.apple.setInventory(sellerApple.getInventory() - count);
                if (customer.apple == null) {
                    customer.apple = new Apple(sellerApple.getPrice(), count);
                } else {
                    customer.apple.setInventory(customer.apple.getInventory() + count);
                }
            customer.myMoney -= total;
                seller.myMoney += total;
            } else {
                System.out.println("ERROR : 예산이 부족 합니다.");
            }
            System.out.println(customer);
            System.out.println(seller);
        }

    }
    public void open(){
        System.out.println("과일가게 오픈");
        System.out.println(customer);
        System.out.println(seller);
    }
}

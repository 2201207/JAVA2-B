public class Seller {
    protected Apple apple;
    protected int myMoney;

    public Seller(Apple apple, int myMoney) {
        this.apple = apple;
        this.myMoney = myMoney;
    }



    public boolean sale(int count){
        boolean flag = true;
        if (this.apple.getInventory()>=count){
            apple.setInventory(apple.getInventory()-count);
            myMoney += apple.getInventory() + count;
        }else{
            System.out.println("ERROR : 재고량이 부족 합니다.");
            flag = false;
        }
        return flag;
    }

    @Override
    public String toString() {
        return String.format("판매자 : 현금 : %,d원, 사과 : %,d개 보유", myMoney, apple.getInventory());
    }
}

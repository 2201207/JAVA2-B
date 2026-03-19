public class TV {
    String manufacturer;
    int year;
    int size;
    String panelType;


    public TV(String manufacturer, int year, int size, String panelType) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.size = size;
        this.panelType = panelType;
    }


    public void showInfo() {
        System.out.println("우리집 TV는 " + manufacturer + "에서 만든 " + year + "년형 " + size + " 인치 " + panelType + " TV 입니다");
    }
}

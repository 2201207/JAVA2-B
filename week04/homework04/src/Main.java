public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("이름   사번   부서명  원호 급-호     본봉  업무수당 직급수당 공제금액  세금    수령액");
        System.out.println("---------------------------------------------------------------------------------");


        Employee[] emps = {
                new Employee(11111, "홍길동", 1, false, 1, 1, 200000),
                new Employee(12231, "한국민", 3, false, 2, 3, 300000),
                new Employee(13156, "이대한", 4, true, 2, 4, 200000),
                new Employee(13211, "한아름", 5, false, 3, 3, 100000),
                new Employee(16171, "새로움", 4, false, 3, 5, 200000),
                new Employee(17778, "이기쁨", 3, false, 2, 3, 200000),
                new Employee(18567, "정동진", 1, true, 2, 2, 200000),
                new Employee(19129, "김진우", 4, false, 1, 1, 200000),
                new Employee(19891, "이나래", 3, false, 3, 4, 200000),
                new Employee(21190, "박명길", 2, false, 2, 5, 300000)
        };


        for (Employee e : emps) {
            e.printRow();

            if (e.name.equals("새로움")) {
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}
package chap_04.io.bankExam;

import chap_04.io.bankExam.service.*;

import java.util.Scanner;

public class App {
    private CreateService createService = new CreateService();
    private BankService bankService = new BankService();
    private LoadService loadService = new LoadService();
    private SaveService saveService = new SaveService();
    private ModifyService modifyService = new ModifyService();
    private DeleteService deleteService = new DeleteService();
    private PrintService printService = new PrintService();


    public void start() {
        loadService.load();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println();
                System.out.println("=========은행 서비스============");
                System.out.println("1. 계좌 개설");
                System.out.println("2. 입금");
                System.out.println("3. 출금");
                System.out.println("4. 계좌정보 출력");
                System.out.println("5  저장");
                System.out.println("6. 삭제");
                System.out.println("7. 나가기");
                System.out.println("=============================");
                System.out.println("원하시는 서비스의 숫자를 입력해주세요");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        createService.create();
                        break;
                    case 2:
                        bankService.deposit();
                        break;
                    case 3:
                        bankService.withdraw();
                        break;
                    case 4:
                        printService.print();
                        break;
                    case 5:
                        saveService.save();
                        break;
                    case 6:
                        deleteService.delete();
                        break;
                    case 7:
                        System.out.println("프로그램을 종료합니다...");
                        System.exit(0);
                    default:
                        System.out.println("잘못된 선택입니다!");
                }
            } catch (RuntimeException e) {
                System.out.println();
                System.out.println("[" + e.getMessage() +"]");
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("알수없는 오류입니다.");
                throw new RuntimeException(e);
            }
        }



    }
}
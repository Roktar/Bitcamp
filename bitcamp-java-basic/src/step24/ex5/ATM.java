package step24.ex5;

public class ATM extends Thread {
    Account account;
    String name;
    
    public ATM(String name, Account account) {
        super(name); // 쓰레드 이름 세팅
        this.account = account;
    }
    
    @Override
    public void run() {
        long money = 0;
        long sum = 0;
        
        long startTime = System.currentTimeMillis();
        
        while ( true ) {
            try {
                money = account.withdraw(100);
            } catch(Exception e) { }
            System.out.printf("%s의 중간 출금 : %d, 잔액 : %d\n", this.getName(), money, account.balance );
            if(money <= 0)
                break;
            sum += money;
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.printf("%s가 찾은 돈 : %d원, 소요시간 : %d\n", this.getName(), sum, (endTime-startTime));
    }
}

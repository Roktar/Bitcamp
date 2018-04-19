package step24.ex5;

public class Account {
    String accountId;
    long balance;
    
    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
        System.out.printf("%s 계좌의 현재금액 : %d\n", accountId, balance);
    }
    
    public long withdraw(long money) throws Exception {
        long b = this.balance;
        
        // 딜레이를 발생시켜 다른 쓰레드가 CPU를 가져갈 수 있도록 하기위함
        //for(int i=0; i<1000; i++) Math.asin(45.765);
        
        sleep();
        
        b -= money;
        
        // 딜레이를 발생시켜 다른 쓰레드가 CPU를 가져갈 수 있도록 하기위함
        //for(int i=0; i<1000; i++) Math.asin(45.765);
        
        sleep();
        
        if(b < 0)
            return 0;
        // 딜레이를 발생시켜 다른 쓰레드가 CPU를 가져갈 수 있도록 하기위함
        //for(int i=0; i<1000; i++) Math.asin(45.765);
        
        sleep();
        
        this.balance = b;
        
        sleep();
        
        // 딜레이를 발생시켜 다른 쓰레드가 CPU를 가져갈 수 있도록 하기위함
        //for(int i=0; i<1000; i++) Math.asin(45.765); 
        
        return money;
    }
    
    public void sleep() throws Exception{
        Thread.sleep(10);
    }
}

package step24.ex5_2;

public class Account {
    String accountId;
    long balance;
    
    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
        System.out.printf("%s 계좌의 현재금액 : %d\n", accountId, balance);
    }
    
    synchronized public long withdraw(long money){
        long b = this.balance;
        
        // 딜레이를 발생시켜 다른 쓰레드가 CPU를 가져갈 수 있도록 하기위함
        for(int i=0; i<1000; i++) Math.asin(45.765);
        
        b -= money;
        
        // 딜레이를 발생시켜 다른 쓰레드가 CPU를 가져갈 수 있도록 하기위함
        //for(int i=0; i<1000; i++) Math.asin(45.765);
        
        if(b < 0)
            return 0;
        // 딜레이를 발생시켜 다른 쓰레드가 CPU를 가져갈 수 있도록 하기위함
        for(int i=0; i<1000; i++) Math.asin(45.765);
        
        this.balance = b;
        
        // 딜레이를 발생시켜 다른 쓰레드가 CPU를 가져갈 수 있도록 하기위함
        for(int i=0; i<1000; i++) Math.asin(45.765); 
        
        return money;
    }
}

import java.util.Arrays;

public class Bank{
    static final double EURO =4.6;
    static final double USD =3.95;
    static final double PLN =1.0;
    Account [] accounts = new Account[2];
    static int INSTANCES =0;
    char numberBank;

    public Bank(){
        INSTANCES++;
        numberBank=(char)(INSTANCES+'0');
    }

    public void addAccount(Account account){
        for(int i=0;i<accounts.length;i++){
            if (accounts[i] ==null){
                accounts[i]=account;
                int min=100;
                int max=999;
                account.setNumber("" + numberBank + (min+ (int) (Math.random() * ((max- min) + 1))));
                return;
            }
        }
    }

    public void printAccounts(){
        System.out.println(Arrays.toString(accounts));
    }

    public Account findAccount(String number){
        for (Account account : accounts) {
            if (account.getNumber().equals(number)) return account;
        }
        if(number.charAt(0) != numberBank){
            System.out.println("Will not work, wrong bank");
        }else {
            System.out.println("Could not find given account");
        }
        return null;
    }

    public double changeCurrency(double balance, String currency, String anotherCurrency){
        if(currency.equals("EURO")){
            balance*=EURO;
            if(anotherCurrency.equals("PLN")) return balance;
            if(anotherCurrency.equals("USD")) return balance/USD;
        }
        if(currency.equals("USD")){
            balance*=USD;
            if(anotherCurrency.equals("PLN")) return balance;
            if(anotherCurrency.equals("EURO")) return balance/EURO;
        }
        if(currency.equals("PLN")){
            if(anotherCurrency.equals("EURO")) return balance/EURO;
            if(anotherCurrency.equals("USD")) return balance/USD;
        }
        return balance;
    }

    public void transferToDifferentCurrency(String number, String anotherCurrency){
        for (Account account : accounts) {
            if (account.getNumber().equals(number)) {
                account.setBalance(changeCurrency(account.getBalance(), account.getCurrency(), anotherCurrency));
                account.setCurrency(anotherCurrency);
                return;
            }
        }
        System.out.println("Could not find given account");
    }

    public void transfer(String number, String anotherNumber, int amount, zad2.Bank bank2){
        Account ac1 = findAccount(number);
        Account ac2 = bank2.findAccount(anotherNumber);

        if (ac1 != null && ac2 != null) {
            ac1.setBalance(ac1.getBalance() - amount);
            ac2.setBalance(ac2.getBalance() + changeCurrency(amount, ac1.getCurrency(), ac2.getCurrency()));
        }
    }

    public void transfer(String number, String anotherNumber, int amount){
        transfer(number, anotherNumber, amount, this);
    }

}
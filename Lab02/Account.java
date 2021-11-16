public class Account{
    private String name;
    private String surname;
    private String num;
    private double balance;
    private String currency;
    static int NUMBER_OF_CREATED_ACCOUNTS=0;

    public Account(String name, String surname, String currency){
        this.name=name;
        this.surname=surname;
        this.num="Not assigned to any bank";
        this.balance=0.;
        this.currency = currency;
        NUMBER_OF_CREATED_ACCOUNTS++;
    }

    public Account(String name, String surname, double balance, String currency){
        this.name=name;
        this.surname=surname;
        this.num="Not assigned to any bank";
        this.balance=balance;
        this.currency = currency;
        NUMBER_OF_CREATED_ACCOUNTS++;
    }

    public String getOwner(){
        return name + " " + surname;
    }

    public String getAccountBalance(){
        return balance + " " + currency;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance=balance;
    }

    public String getNumber(){
        return num;
    }

    public void setNumber(String num){
        this.num=num;
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }

    public String getCurrency(){
        return currency;
    }

    @Override
    public String toString(){
        return "Account{firstName='" + this.name + "', lastName='" + this.surname + "', number='" + this.num +"', balance=" + this.balance + "}";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o==null || o.getClass() != getClass()) return false;
        zad2.Account anotherAcount = (zad2.Account) o;
        return name.equals(anotherAcount.name) && surname.equals(anotherAcount.surname) && num.equals(anotherAcount.num) && balance == anotherAcount.balance && currency.equals(anotherAcount.currency);
    }

}
/**
 * Класс счетов, содержащиц переменные, конструктор с параметрами, геттеры, сеттеры, и методы toString, equals, и hashcode.
 */

package com.tms.banking.system.banks.clients.account;
import java.time.LocalDate;
import java.util.Objects;

public class Account {
    protected String accountNumber;
    protected double balance;
    protected LocalDate accountExpirationDate;

    public Account(String accountNumber, double balance, LocalDate accountExpirationDate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountExpirationDate = accountExpirationDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getAccountExpirationDate() {
        return accountExpirationDate;
    }

    public void setAccountExpirationDate(LocalDate accountExpirationDate) {
        this.accountExpirationDate = accountExpirationDate;
    }

    public void automaticallyClosedAccount(Account account){
        if(account.getBalance()==0){
            System.out.println("Счет был автоматически закрыт, так как сумма была изменена на 0");
        } else {
            System.out.println("Счет будет автоматически закрыт после даты окончания счета: " + account.getAccountExpirationDate());
        }
    }


    @Override
    public String toString() {
        return "Номер счета ='" + accountNumber + '\'' +
                ", Сумма на счету =" + balance +
                ", Дата окончания счета = " + accountExpirationDate +
                '}';
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 &&
                accountNumber.equals(account.accountNumber) &&
                accountExpirationDate.equals(account.accountExpirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance, accountExpirationDate);
    }
}

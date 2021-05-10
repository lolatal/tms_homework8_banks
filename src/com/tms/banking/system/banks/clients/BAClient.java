/**
 * Класс-наследник, сожержит переопределенные методы, массив счетов Bank of America и методы для получения информации о счетах.
 */

package com.tms.banking.system.banks.clients;
import com.tms.banking.system.Bank;
import com.tms.banking.system.banks.clients.account.Account;
import com.tms.banking.system.banks.clients.account.DatesCalendar;

import java.time.LocalDate;
import java.util.Scanner;


public class BAClient extends Client{
    protected int stateNumber;
    protected String stateName;


    public BAClient(String lastname, String firstname, LocalDate birthday, String passportNumber, String gender, Account clientAccount, int stateNumber, String stateName) {
        super(lastname, firstname, birthday, passportNumber, gender, clientAccount);
        this.stateNumber = stateNumber;
        this.stateName = stateName;
    }

    @Override
    public void openAccount(Bank bank, Account account) {
        double depositAmount = account.getBalance();
        if (bank.getMinAmountToOpenAnAccount() > depositAmount) {
            System.out.println("Вносимая сумма счета меньше пороговой, вы не можете открыть счет");
        } else {
            System.out.println("Открытие счета в Bank of America");
        }
    }

    @Override
    public void closeAccount(Account account, DatesCalendar datesCalendar) {
        if(datesCalendar.getFutureDate().isAfter(account.getAccountExpirationDate())){
            System.out.println("Ваш счет был закрыт " + account.getAccountExpirationDate() + " так как прошла дата окончания счета");
        }
    }

    @Override
    public void changeAccount(Account account, Client client) {
        System.out.println("Добро пожаловать, " + client.getFirstname() + " " + client.getLastname() + ", Баланс вашего счета  в Bank Of America на данный момент = " + account.getBalance() + ". Введите 1, если хотите снять деньги, и 2, если хотите пополнить счет");
        Scanner scanner = new Scanner(System.in);
        int operationType = scanner.nextInt();
        if (operationType == 1) {
            System.out.println("Введите снимаемую сумму");
            double withdrawalAmount = scanner.nextDouble();
            if(withdrawalAmount<0){
                System.out.println("Вы ввели отрицательное число. Невозможно осуществить транзакцию");
                account.setBalance(account.getBalance());
            }
            if (withdrawalAmount <= account.getBalance() && withdrawalAmount>0) {
                account.setBalance(account.getBalance() - withdrawalAmount);
                System.out.println("Новая сумма счета: " + account.getBalance());
            } else if (withdrawalAmount > account.getBalance()) {
                System.out.println("Недостаточно средств");
            }
        } else if (operationType == 2) {
            System.out.println("Введите вносимую сумму");
            double depositAmount = scanner.nextDouble();
            if(depositAmount<0){
                System.out.println("Вы ввели отрицательное число. Невозможно осуществить транзакцию");
                account.setBalance(account.getBalance());
            } else if(depositAmount>0){
                account.setBalance(account.getBalance() + depositAmount);
                System.out.println("Новая сумма счета: " + account.getBalance());
            }
        } else {
                System.out.println("Вы ввели несуществующий тип операции");
            }
            account.automaticallyClosedAccount(account);
    }

    @Override
    public String toString() {
        return "BAClient{" +
                "Номер штата =" + stateNumber +
                ", Название штата ='" + stateName + '\'' +
                ", Фамилия='" + lastname + '\'' +
                ", Имя ='" + firstname + '\'' +
                ", Дата рождения =" + birthday +
                ", Номер паспорта ='" + passportNumber + '\'' +
                ", Пол ='" + gender + '\'' +
                ", Данные счета = " + clientAccount +
                '}';
    }

    private static Account[] baAccountsArray = {
            new Account("18-XX-19-YZ", 2000.0, LocalDate.of(2024, 10, 11)),
            new Account("22-RT-90-XX", 10000.0, LocalDate.of(2026, 12, 31)),
            new Account("32-FR-45-KN", 800.0, LocalDate.of(2022, 9, 18)),
    };

    public static Account[] getBaAccountsArray(){
        return baAccountsArray;
    }

    public static Account getBaAccounts() {
        for (Account account : baAccountsArray) {
            return account;
        }
        return getBaAccounts();
    }

}

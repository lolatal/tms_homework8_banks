/**
 * Класс-наследник, сожержит переопределенные методы, массив счетов Deutsche Bank и методы для получения информации о счетах.
 */

package com.tms.banking.system.banks.clients;
import com.tms.banking.system.Bank;
import com.tms.banking.system.banks.clients.account.Account;
import com.tms.banking.system.banks.clients.account.DatesCalendar;

import java.time.LocalDate;
import java.util.Scanner;


public class DBClient extends Client {
    protected String federalLandCode;

    public DBClient(String lastname, String firstname, LocalDate birthday, String passportNumber, String gender, Account clientAccount, String federalLandCode) {
        super(lastname, firstname, birthday, passportNumber, gender, clientAccount);
        this.federalLandCode = federalLandCode;
    }

    @Override
    public void openAccount(Bank bank, Account account) {
        double depositAmount = account.getBalance();
        if (bank.getMinAmountToOpenAnAccount() > depositAmount) {
            System.out.println("Вносимая сумма счета меньше пороговой, вы не можете открыть счет");
        } else {
            System.out.println("Открытие счета в Deutsche Bank");
        }
    }

    @Override
    public void closeAccount(Account account, DatesCalendar datesCalendar) {
        if (datesCalendar.getFutureDate().isAfter(account.getAccountExpirationDate())) {
            System.out.println("Ваш счет был закрыт " + account.getAccountExpirationDate() + " так как прошла дата окончания счета");
        }
    }

    @Override
    public void changeAccount(Account account, Client client) {
        System.out.println("Добро пожаловать, " + client.getFirstname() + " " + client.getLastname() + ", Баланс вашего счета  в Deutsche Bank на данный момент = " + account.getBalance() + ". Введите 1, если хотите снять деньги, и 2, если хотите пополнить счет");
        Scanner scanner = new Scanner(System.in);
        int operationType = scanner.nextInt();
        if (operationType == 1) {
            System.out.println("Введите снимаемую сумму");
            double withdrawalAmount = scanner.nextDouble();
            if (withdrawalAmount < 0) {
                System.out.println("Вы ввели отрицательное число. Невозможно осуществить транзакцию");
                account.setBalance(account.getBalance());
            }
            if (withdrawalAmount <= account.getBalance() && withdrawalAmount > 0) {
                account.setBalance(account.getBalance() - withdrawalAmount);
                System.out.println("Новая сумма счета: " + account.getBalance());
            } else if (withdrawalAmount > account.getBalance()) {
                System.out.println("Недостаточно средств");
            }
        } else if (operationType == 2) {
            System.out.println("Введите вносимую сумму");
            double depositAmount = scanner.nextDouble();
            if (depositAmount < 0) {
                System.out.println("Вы ввели отрицательное число. Невозможно осуществить транзакцию");
                account.setBalance(account.getBalance());
            } else if (depositAmount > 0) {
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
        return "Код федеративное земли ='" + federalLandCode + '\'' +
                ", Фамилия='" + lastname + '\'' +
                ", Имя ='" + firstname + '\'' +
                ", Дата рождения=" + birthday +
                ", Номер пасспорта ='" + passportNumber + '\'' +
                ", Пол ='" + gender + '\'' +
                ", Данные счета = " + clientAccount +
                '}';
    }

    private static Account[] dbAccountsArray = {
            new Account("45-12-34-56-89", 8450.0, LocalDate.of(2025, 9, 18)),
            new Account("31-00-83-90-76", 10000.0, LocalDate.of(2024, 10, 3)),
            new Account("09-18-45-13-11", 3670.0, LocalDate.of(2022, 11, 1))
    };

    public static Account[] getDbAccountsArray() {
        return dbAccountsArray;
    }

    public static Account getDbAccounts() {
        for (Account account : dbAccountsArray) {
            return account;
        }
        return getDbAccounts();
    }

}


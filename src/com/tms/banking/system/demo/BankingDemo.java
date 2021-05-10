/**
 * Класс, отражающий заданные реализации.
 */

package com.tms.banking.system.demo;
import com.tms.banking.system.Bank;
import com.tms.banking.system.banks.BankOfAmerica;
import com.tms.banking.system.banks.ChinaBank;
import com.tms.banking.system.banks.DeutscheBank;
import com.tms.banking.system.banks.clients.BAClient;
import com.tms.banking.system.banks.clients.CBClient;
import com.tms.banking.system.banks.clients.Client;
import com.tms.banking.system.banks.clients.DBClient;
import com.tms.banking.system.banks.clients.account.Account;
import com.tms.banking.system.banks.clients.account.DatesCalendar;

import java.time.LocalDate;

public class BankingDemo {
    public static void main(String[] args) {

        /**
         * Пример вывода информации о банке и клиентах на консоль
         */

        Bank bank;
        bank = new BankOfAmerica("Charlotte", 1111, "USD", LocalDate.of(2025, 12, 31), 1000.000);
        System.out.println("Bank of America:" + "\n" + bank.toString());
        bank = new ChinaBank("Beijing", 2222, "RMB", LocalDate.of(2026, 12, 31), 5000.000);
        System.out.println("Bank of China" + "\n" + bank.toString());
        System.out.println("-----------------------------------");

        Client client = new BAClient("Staryn", "Irina", LocalDate.of(1989, 8, 10), "CA2020212", "female", BAClient.getBaAccountsArray()[1], 11, "Illinois");
        System.out.println("Данные клиента Bank of America:" + "\n" + client.toString());
        Client client1 = new DBClient("Muller", "Hannah", LocalDate.of(1983, 4, 10), "456FRT9", "female", DBClient.getDbAccountsArray()[1], "DE-SL");
        System.out.println("Данные клиента Deutsche Bank:" + "\n" + client1.toString());
        Client client2 = new CBClient("Wang", "Liu", LocalDate.of(1984, 11, 9), "FRT5670T", "female", CBClient.getCbAccountsArray()[1], "Hainan");
        System.out.println("Данные клиента Bank of China:" + "\n" + client2.toString());
        System.out.println("-----------------------------------");

        /**
         * Пример сравнения имеющихся счетов и пользователей (добавление новых)
         */

        Account account = new Account("18-XX-19-YZ", 2000.0, LocalDate.of(2024, 10, 11));
        if(account.equals(BAClient.getBaAccounts())){
            System.out.println("Данный счет не может быть добавлен, так как такой уже существует");
        }else{
            System.out.println("Данный счет будет добавлен в базу Bank of America");
        }

        Client client3 = new BAClient("Tailor", "Jack", LocalDate.of(1986, 11, 23), "SW2345678", "male", BAClient.getBaAccountsArray()[2], 38, "Pennsylvania");
        if(client3.equals(BankOfAmerica.getBaClients())) {
            System.out.println("Данный пользователь не может быть добавлен, так как такой уже существует");
        }else{
            System.out.println("Данный пользователь будет добавлен");
        }
        Client client4 = new DBClient("Muller", "Hannah", LocalDate.of(1983, 4, 10), "456FRT9", "female", DBClient.getDbAccountsArray()[1], "DE-SL");
        if(client4.equals(DeutscheBank.getDbClients())) {
            System.out.println("Данный пользователь не может быть добавлен, так как такой уже существует");
        }else{
            System.out.println("Данный пользователь будет добавлен");
        }
        System.out.println("-----------------------------------");


        /**
         * Пример открытия счета (основываясь на пороговой сумме)
         */

        Account account1 = new Account("XXX09-82", 320, LocalDate.of(2025, 2, 23));
        Client client5 = new DBClient("Smith", "Sarah", LocalDate.of(1992, 4, 12), "XX3452D", "female", account1, "D34");
        Bank bank1 = new DeutscheBank("Berlin", 333, "Euro", LocalDate.of(2030, 12, 31), 1500);
        client5.openAccount(bank1, account1);
        System.out.println("-----------------------------------");


        /**
         * Пример изменения суммы счета (deposit or withdrawal), и, соответственно,
         * реализации метода автоматического закрытия счета, если сумма была изменена на 0.
         */

        Client client6 = BankOfAmerica.getBaClientsArray()[0];
        Account account2 = BankOfAmerica.getBaClientsArray()[0].getClientAccount();
        client6.changeAccount(account2, client6);
        Client client7 = ChinaBank.getCbClientsArray()[1];
        Account account3 = ChinaBank.getCbClientsArray()[1].getClientAccount();
        client7.changeAccount(account3, client7);
        System.out.println("-----------------------------------");

        /**
         * Пример закрытия счета
         */

        Client client8 = DeutscheBank.getDbClientsArray()[1];
        Account account4 = DeutscheBank.getDbClientsArray()[1].getClientAccount();
        DatesCalendar datesCalendar = new DatesCalendar(LocalDate.of(2031, 11, 2));
        client8.closeAccount(account4, datesCalendar);

        System.out.println("-----------------------------------");

        /**
         * Проверка на заполненность массива счетов и клиентов
         */


        int maxDbAccountsArrayLength = 5;
        if(DBClient.getDbAccountsArray().length < maxDbAccountsArrayLength) {
            Account account5 = new Account("345-18", 3400, LocalDate.of(2023, 3, 15));
            Client client9 = new DBClient("Bjorn", "Peter", LocalDate.of(1976, 3, 24), "ST56TG", "male", account5, "F54");
            System.out.println("Счет для " + client9.getFirstname() + " " + client9.getLastname() + " будет открыт");
        } else{
            System.out.println("Счет не может быть добавлен. Массив счетов заполнен");
        }

        int maxBaClientsArrayLength = 3;
        if(BankOfAmerica.getBaClientsArray().length < maxBaClientsArrayLength){
            Account account6 = new Account("KLg-56-GN", 12380, LocalDate.of(2025, 12, 30));
            Client client10 = new BAClient("Brown", "Amelia", LocalDate.of(1988, 7, 18), "76GHT65T", "female", account6, 28, "Texas");
            System.out.println("Клиент " + client10.getFirstname() + " " + client10.getLastname() + " будет добавлен в массив клиентов");
        }else {
            System.out.println("Клиент не может быть добавлен. Массив клиентов заполнен");
        }

    }
}

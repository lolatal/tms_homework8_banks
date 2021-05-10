/**
 * Класс-наследник. Содержит массив клиентов Bank of America и методы для получения информации о клиенте из массива.
 */

package com.tms.banking.system.banks;
import com.tms.banking.system.Bank;
import com.tms.banking.system.banks.clients.BAClient;
import com.tms.banking.system.banks.clients.Client;
import java.time.LocalDate;



public class BankOfAmerica extends Bank {

    public BankOfAmerica(String headQuartersLocation, int worldCode, String nationalCurrency, LocalDate licenseExpirationDate, double minAmountToOpenAnAccount) {
        super(headQuartersLocation, worldCode, nationalCurrency, licenseExpirationDate, minAmountToOpenAnAccount);
    }

    private static Client[] baClientsArray = {
            new BAClient("Kemezh", "Olga", LocalDate.of(1992, 2, 16), "AB2020202", "female", BAClient.getBaAccountsArray()[0], 48, "Wisconsin"),
            new BAClient("Staryn", "Irina", LocalDate.of(1989, 8, 10), "CA2020212", "female", BAClient.getBaAccountsArray()[1], 11, "Illinois"),
            new BAClient("Tailor", "Jack", LocalDate.of(1986, 11, 23), "SW2345678", "male", BAClient.getBaAccountsArray()[2], 37, "Pennsylvania")
    };

    public static Client[] getBaClientsArray() {
        return baClientsArray;
    }

    public static Client getBaClients(){
        for(Client client: baClientsArray){
            return client;
        }
        return getBaClients();
    }

}




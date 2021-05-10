/**
 * Класс-наследник. Содержит массив клиентов Deutsche Bank и методы для получения информации о клиенте из массива.
 */

package com.tms.banking.system.banks;
import com.tms.banking.system.Bank;
import com.tms.banking.system.banks.clients.Client;
import com.tms.banking.system.banks.clients.DBClient;
import java.time.LocalDate;


public class DeutscheBank extends Bank {

    public DeutscheBank(String headQuartersLocation, int worldCode, String nationalCurrency, LocalDate licenseExpirationDate, double minAmountToOpenAnAccount) {
        super(headQuartersLocation, worldCode, nationalCurrency, licenseExpirationDate, minAmountToOpenAnAccount);
    }

    private static Client[] dbClientsArray = {
            new DBClient("Shroder", "Alex", LocalDate.of(1990, 5, 18), "678FGT0", "male", DBClient.getDbAccountsArray()[0], "DE-NI"),
            new DBClient("Muller", "Hannah", LocalDate.of(1983, 4, 10), "456FRT9", "female", DBClient.getDbAccountsArray()[1], "DE-SL"),
            new DBClient("Fischer", "Ben", LocalDate.of(1975, 11, 29), "123DRH3", "male", DBClient.getDbAccountsArray()[2], "DE-BE")
    };

    public static Client[] getDbClientsArray() {
        return dbClientsArray;
    }

    public static Client getDbClients(){
        for(Client client: dbClientsArray){
            return client;
        }
        return getDbClients();
    }


}

/**
 * Класс-наследник. Содержит массив клиентов China Bank и методы для получения информации о клиенте из массива.
 */

package com.tms.banking.system.banks;
import com.tms.banking.system.Bank;
import com.tms.banking.system.banks.clients.CBClient;
import com.tms.banking.system.banks.clients.Client;
import java.time.LocalDate;


public class ChinaBank extends Bank {

    public ChinaBank(String headQuartersLocation, int worldCode, String nationalCurrency, LocalDate licenseExpirationDate, double minAmountToOpenAnAccount) {
        super(headQuartersLocation, worldCode, nationalCurrency, licenseExpirationDate, minAmountToOpenAnAccount);
    }

    private static Client[] cbClientsArray = {
            new CBClient("Shu", "Tian", LocalDate.of(1993, 4, 16), "TUP23TP", "male", CBClient.getCbAccountsArray()[0], "Sichuan"),
            new CBClient("Wang", "Liu", LocalDate.of(1984, 11, 9), "FRT5670T", "female", CBClient.getCbAccountsArray()[1], "Hainan"),
            new CBClient("Hu", "Zhao", LocalDate.of(1970, 8, 22), "SW2345678", "male", CBClient.getCbAccountsArray()[2], "Guangdong")
    };
    public static Client[] getCbClientsArray(){
        return cbClientsArray;
    }

    public static Client getCbClients(){
        for(Client client: cbClientsArray){
            return client;
        }
        return getCbClients();
    }

}

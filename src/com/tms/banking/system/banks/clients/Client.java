/**
 * Класс-родитель для общей информации о клиентах различных банков.
 * Содержит переменные, методы, контсруктор с параметрами и геттеры, сеттеры.
 */

package com.tms.banking.system.banks.clients;
import com.tms.banking.system.Bank;
import com.tms.banking.system.banks.clients.account.Account;
import com.tms.banking.system.banks.clients.account.DatesCalendar;
import java.time.LocalDate;
import java.util.Objects;


public abstract class Client {
    protected String lastname;
    protected String firstname;
    protected LocalDate birthday;
    protected String passportNumber;
    protected String gender;
    Account clientAccount;

    public abstract void openAccount(Bank bank, Account account);
    public abstract void closeAccount(Account account, DatesCalendar datesCalendar);
    public abstract void changeAccount(Account account, Client client);


    public Client(String lastname, String firstname, LocalDate birthday, String passportNumber, String gender, Account clientAccount) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.passportNumber = passportNumber;
        this.gender = gender;
        this.clientAccount = clientAccount;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Account getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(Account clientAccount) {
        this.clientAccount = clientAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return lastname.equals(client.lastname) &&
                firstname.equals(client.firstname) &&
                passportNumber.equals(client.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, passportNumber);
    }
}



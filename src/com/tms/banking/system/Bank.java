/**
 * Класс-родитель для банков, содержащий переменные, конструктор с параметрами, геттеры, сеттеры, и метод toString
 */

package com.tms.banking.system;
import java.time.LocalDate;


public abstract class Bank {
    protected String headQuartersLocation;
    protected int worldCode;
    protected String nationalCurrency;
    protected LocalDate licenseExpirationDate;
    protected double minAmountToOpenAnAccount;


    public Bank(String headQuartersLocation, int worldCode, String nationalCurrency, LocalDate licenseExpirationDate, double minAmountToOpenAnAccount) {
        this.headQuartersLocation = headQuartersLocation;
        this.worldCode = worldCode;
        this.nationalCurrency = nationalCurrency;
        this.licenseExpirationDate = licenseExpirationDate;
        this.minAmountToOpenAnAccount = minAmountToOpenAnAccount;

    }

    public String getHeadQuartersLocation() {
        return headQuartersLocation;
    }

    public void setHeadQuartersLocation(String headQuartersLocation) {
        this.headQuartersLocation = headQuartersLocation;
    }

    public int getWorldCode() {
        return worldCode;
    }

    public void setWorldCode(int worldCode) {
        this.worldCode = worldCode;
    }

    public String getNationalCurrency() {
        return nationalCurrency;
    }

    public void setNationalCurrency(String nationalCurrency) {
        this.nationalCurrency = nationalCurrency;
    }

    public LocalDate getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    public void setLicenseExpirationDate(LocalDate licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public double getMinAmountToOpenAnAccount() {
        return minAmountToOpenAnAccount;
    }

    public void setMinAmountToOpenAnAccount(double minAmountToOpenAnAccount) {
        this.minAmountToOpenAnAccount = minAmountToOpenAnAccount;
    }

    @Override
    public String toString() {
        return //"Bank{" +
                "Центральное отделение банка ='" + headQuartersLocation + '\'' +
                ", Мировой код банка =" + worldCode +
                ", Национальная валюта ='" + nationalCurrency + '\'' +
                ", Дата окончания лицензии =" + licenseExpirationDate.toString() +
                ", Минимальная сумма для открытия счета = " + minAmountToOpenAnAccount +
                '}';
    }
}

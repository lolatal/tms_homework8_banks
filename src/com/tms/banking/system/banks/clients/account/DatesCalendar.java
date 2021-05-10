/**
 * Вспомогательный класс для установки потенциальной даты (с целью проверки метода закрытия счета).
 */

package com.tms.banking.system.banks.clients.account;

import java.time.LocalDate;

public class DatesCalendar {
    protected LocalDate futureDate;

    public DatesCalendar(LocalDate futureDate) {
        this.futureDate = futureDate;
    }

    public LocalDate getFutureDate() {
        return futureDate;
    }

    public void setFutureDate(LocalDate futureDate) {
        this.futureDate = futureDate;
    }
}

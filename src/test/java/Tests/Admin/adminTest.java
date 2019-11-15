package Tests.Admin;

import Tests.BaseTest;
import Tools.PageContainer;
import com.google.common.collect.ImmutableList;
import junitparams.JUnitParamsRunner;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class adminTest extends BaseTest {




    @Override
    protected void precondition() {
            pages.getTestPageAdm().openPage("https://wysh.console-staging.wysh.ai");
            pages.getTestPageAdm().adminLogin("concierge@wysh.ai", "Password2017");
            pages.getTestPageClnt().openPage("https://wysh.console-staging.wysh.ai/widget/login");
            pages.getTestPageClnt().loginClnt("trentreznor@net3mail.com", "Password2017");
            pages.getTestPageClnt().requestMenu();
            pages.getTestPageAdm().selectCompany();
    }

    public static LocalDate newDate() {
        LocalDate from = LocalDate.of(2020, 1, 1);
        LocalDate to = LocalDate.of(2020, 1, 10);
        long days = from.until(to, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        LocalDate randomDate = from.plusDays(randomDays);
        return randomDate;
    }

    public static String getDayOfMonthSuffix(LocalDate date) {
        int n = date.getDayOfMonth();

        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
}






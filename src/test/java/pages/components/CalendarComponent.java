package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDay (String day, String month, String year){

            // Устанавливаем месяц и год
            $(".react-datepicker__month-select").selectOption(month);
            $(".react-datepicker__year-select").selectOption(year);

            // Ждем обновления
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Ищем все дни текущего месяца и кликаем по нужному
            $(".react-datepicker__month:not(.react-datepicker__month--outside-month)")
                    .$(byText(day))
                    .click();
        }
    }






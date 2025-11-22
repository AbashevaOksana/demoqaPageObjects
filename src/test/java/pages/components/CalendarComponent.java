package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement
            monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select"),
            dayInput = $(".react-datepicker__month:not(.react-datepicker__month--outside-month)");

    public void setDay (String day, String month, String year){

            // Устанавливаем месяц и год
        monthInput.selectOption(month);
        yearInput.selectOption(year);//

            // Ищем все дни текущего месяца и кликаем по нужному
        dayInput.$(byText(day)).click();
        }
    }






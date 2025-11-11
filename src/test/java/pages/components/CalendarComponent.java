package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDay (String value, String mounth, String year){

        $(".react-datepicker__month-select").selectOption("February");//
        $(".react-datepicker__year-select").$(byText("1983")).click();//
        $(".react-datepicker__week").$(byText("4")).click();//


    }

}

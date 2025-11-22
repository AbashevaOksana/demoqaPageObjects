package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsUtils {
    public static void removeBanners() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
    }
}

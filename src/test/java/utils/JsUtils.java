package utils;

import static com.codeborne.selenide.Selenide.*;

public class JsUtils {

    public static void removeBanners() {
        // Просто выполняем JavaScript напрямую
        executeJavaScript("document.querySelector('footer')?.remove()");
        executeJavaScript("document.getElementById('fixedban')?.remove()");
    }
}

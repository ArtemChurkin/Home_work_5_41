package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsSnippets {
    public static void removeAds(){
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
    }



}

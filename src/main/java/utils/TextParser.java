package utils;

import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    public static String getParsedValue(WebElement element) {
        String cartProductText = element.getText();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(cartProductText);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
    }

}

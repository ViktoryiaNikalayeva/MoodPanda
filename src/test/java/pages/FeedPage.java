package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pages.LoginPage.URL;

public class FeedPage extends BasePage {
    public static final String UPDATE_MOOD_CSS = "#LinkUpdate";

    public BasePage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public FeedPage isPageOpened() {
        $(UPDATE_MOOD_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }

    public RateYourHappinessModalPage clickUpdate() {
        $(UPDATE_MOOD_CSS).click();
        return new RateYourHappinessModalPage();

    }

}

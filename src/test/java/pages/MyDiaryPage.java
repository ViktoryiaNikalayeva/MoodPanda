package pages;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class MyDiaryPage extends BasePage {

    public static final String URL = "https://moodpanda.com/Feed/?Me=1";
    public static final String DATE = ".text-muteda:first-child";
    public static final String MOOD_RATING = ".badge.pull-right";
    public static final String DESCRIPTION = "(//*[contains(@class, 'media-content')])[1]";
    public static final String BUTTON = "#ContentPlaceHolderContent_ButtonNext";

    public BasePage openPage() {
        open(URL);
        return this;
    }

    public MyDiaryPage isPageOpened() {
        $(BUTTON).waitUntil(Condition.visible, 10000);
        return this;
    }

    public MyDiaryPage validateMood(int moodRating, String description, String year, String month, String day) {
        assertEquals($(DATE).getText(), dateConstructor(year, month, day), "Date should be " + dateConstructor(year, month, day));
        assertEquals($(MOOD_RATING).getText(), String.valueOf(moodRating), "Mood rating should be" + moodRating);
        $(By.xpath(DESCRIPTION)).waitUntil(Condition.visible, 10000);
        assertEquals($(By.xpath(DESCRIPTION)).getText(), description, "Description should be" + description);
        return this;

    }

    public MyDiaryPage validateMood(int moodRating, String description) {
        assertEquals($(MOOD_RATING).getText(), String.valueOf(moodRating), "Mood rating should be" + moodRating);
        assertEquals($(By.xpath(DESCRIPTION)).getText(), description, "Description should be" + description);
        return this;

    }

    public MyDiaryPage validateMood(int moodRating, String description, String y23days) {
        assertEquals($(DATE).getText(), y23Constructor(y23days));
        assertEquals($(MOOD_RATING).getText(), String.valueOf(moodRating), "Mood rating should be" + moodRating);
        assertEquals($(By.xpath(DESCRIPTION)).getText(), description, "Description should be" + description);
        return this;

    }

    public String dateConstructor  (String year, String month, String day) {
        return day + " " + month + " " + year + " ·";
    }
    public String y23Constructor  (String y23Days) {
        return y23Days;
    }

}

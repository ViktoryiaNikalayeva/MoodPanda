package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModalPage {
    public static final String SLIDER_CSS = ".ui-slider-handle";
    public static final String TEXTAREA = "#TextBoxUpdateMoodTag";
    public static final String DATE = "//*[contains(text(), '%s')]";
    public static final String HOURS_ = "#ddlHistoricHour";
    public static final String MINUTES_ = "#ddlHistoricMinute";
    public static final String YEARS_ = ".ui-datepicker-year";
    public static final String MONTH_ = ".ui-datepicker-month";
    public static final String DAY_ = "//a[text() = '%s']";
    public static final String UPDATE_BUTTON = ".btn.ButtonUpdate";


    public MoodUpdateModalPage updateMood(int moodRating, String description, String date) {
        setMoodRating(moodRating);
        $(TEXTAREA).sendKeys(description);
        $(By.xpath(String.format(DATE, date))).click();
        $(UPDATE_BUTTON).click();
        return new MoodUpdateModalPage();
    }

    public MoodUpdateModalPage updateMood(int moodRating, String description,
                                          String date, String hours, String minutes) {
        setMoodRating(moodRating);
        $(TEXTAREA).sendKeys(description);
        $(By.xpath(String.format(DATE, date))).click();
        setTime(hours, minutes);
        $(UPDATE_BUTTON).click();
        return new MoodUpdateModalPage();
    }


    public MoodUpdateModalPage updateMood(
            int moodRating, String description, String date,
            String year, String month, String day,
            String hours, String minutes) {
        setMoodRating(moodRating);
        $(TEXTAREA).sendKeys(description);
        $(By.xpath(String.format(DATE, date))).click();
        setDate(year, month, day, hours, minutes);
        $(UPDATE_BUTTON).click();
        return new MoodUpdateModalPage();
    }


    public void setTime(String hours, String minutes) {
        new Select($(HOURS_)).selectByVisibleText(hours);
        new Select($(MINUTES_)).selectByVisibleText(minutes);

    }

    public void setDate(String year, String month, String day, String hours, String minutes) {
        new Select($(YEARS_)).selectByVisibleText(year);
        new Select($(MONTH_)).selectByVisibleText(month);
        $(By.xpath(String.format(DAY_, day))).click();
        setTime(hours, minutes);

    }

    public void setMoodRating(int moodRating) {
        int defaultMood = 5;
        $(SLIDER_CSS).click();
        Keys direction;
        if (moodRating > defaultMood) {
            direction = Keys.ARROW_RIGHT;
        } else {
            direction = Keys.ARROW_LEFT;
        }
        for (int i = 0; i < Math.abs(moodRating - defaultMood); i++) {
            $(SLIDER_CSS).sendKeys(direction);
        }
    }
}

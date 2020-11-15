package pages;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdateModalPage {
    public static final String GO_TO_DIARY_BUTTON = ".ButtonMyDiary";

    public MyDiaryPage goToMyDiary() {
        $(GO_TO_DIARY_BUTTON).click();
        return new MyDiaryPage();

    }

}

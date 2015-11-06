package Webapp.model;

/**
 * Created by lstday
 * 22.10.15.
 */
public enum ContactType {
    MOBILE("Телефон"),
    SKYPE("Скайп"),
    EMAIL("Почта");

    private String title;

    ContactType(String title) {
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

}

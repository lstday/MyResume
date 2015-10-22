package Resume.model;

/**
 * Created by lstday
 * 22.10.15.
 */

public enum SectionType {
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификаиця"),
    EXPERIENCE("Опыт"),
    EDUCATION("Образование");

    private String title;

    SectionType(String title) {
        this.title=title;
    }

    public String getTitle() {
        return title;
    }
}

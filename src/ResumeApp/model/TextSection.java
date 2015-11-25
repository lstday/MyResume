package ResumeApp.model;

import java.util.Objects;

/**
 * Created by lstday
 * 22.10.15.
 */
public class TextSection extends Section {
    static final long serialVersionUID = 1L;

    private String value;

    public TextSection() {
    }

    public TextSection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextSection)) return false;
        TextSection that = (TextSection) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return getValue();
    }
}

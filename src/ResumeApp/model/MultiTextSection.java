package ResumeApp.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by lstday
 * 22.10.15.
 */

public class MultiTextSection extends Section {
    static final long serialVersionUID = 1L;

    private List<String> values = new LinkedList<>();

    public MultiTextSection(String[] values) {
        this.values = new LinkedList<>(Arrays.asList(values));
    }

    public MultiTextSection(List<String> values) {
        this.values = values;
    }

    public MultiTextSection() {
    }

    public List<String> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultiTextSection)) return false;
        if (!super.equals(o)) return false;
        MultiTextSection that = (MultiTextSection) o;
        return Objects.equals(getValues(), that.getValues());
    }

    @Override
    public int hashCode() {
        return values != null ? values.hashCode() : 0;
    }

}

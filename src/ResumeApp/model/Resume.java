package ResumeApp.model;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by lstday
 * 22.10.15.
 */
public class Resume implements Serializable {
    static final long serialVersionUID = 1L;

    private String uuid;
    private String fullName;
    private String location;
    private String homePage;

    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume() {
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public Resume(String fullName, String location) {
        this(UUID.randomUUID().toString(), fullName, location);
    }

    public Resume(String uuid, String fullName, String location) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.location = location;
    }

    public Resume(String uuid, String fullName, String location, String homePage) {
        Objects.requireNonNull(uuid, "uuid must not be null!");
        Objects.requireNonNull(fullName, "fullName must not be null!");
        Objects.requireNonNull(location, "location must not be null!");
        Objects.requireNonNull(homePage, "homePage must not be null!");
        this.uuid = uuid;
        this.fullName = fullName;
        this.location = location;
        this.homePage = homePage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName) &&
                Objects.equals(location, resume.location) &&
                Objects.equals(homePage, resume.homePage) &&
                Objects.equals(contacts, resume.contacts) &&
                Objects.equals(sections, resume.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, location, homePage, contacts, sections);
    }

    public void addSection(SectionType sectionType, Section section) {
        sections.put(sectionType, section);
    }

    public void addContact(ContactType contact, String value) {
        contacts.put(contact, value);
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }

    public Section getSection(SectionType type) {
        return sections.get(type);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLocation() {
        return location;
    }

    public String getHomePage() {
        return homePage;
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public Map<SectionType, Section> getSections() {
        return sections;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public void addObjective(String value) {
        addSection(SectionType.OBJECTIVE, new TextSection(value));
    }

    public void addMultiTextSection(SectionType sectionType, String... values) {
        addSection(sectionType, new MultiTextSection(values));
    }

    public void addOrganizationSection(SectionType sectionType, Organization... values) {
        addSection(sectionType, new OrganizationSection(values));
    }

    public int compareTo(Resume resume) {
        return fullName.compareTo(resume.fullName);
        //TODO мало, надо ещё
    }

    public void removeContact(ContactType type) {
        contacts.remove(type);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                ", location='" + location + '\'' +
                ", homePage='" + homePage + '\'' +
                ", contacts=" + contacts +
                ", sections=" + sections +
                '}';
    }
}

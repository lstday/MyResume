package ResumeApp.Storage;

import ResumeApp.ResumeAppException;
import ResumeApp.model.Resume;

import java.util.Collection;

/**
 * Created by lstday
 * 29.10.15.
 */
public interface IStorage {
    void clear();

    void save(Resume resume) throws ResumeAppException;

    void update(Resume resume);

    Resume load(String uuid);

    void delete(String uuid);

    Collection<Resume> getAllSorted();

    boolean isSectionSupported();

    int size();
}

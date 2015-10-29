package Resume.Storage;

import Resume.model.Resume;

import java.util.Collection;

/**
 * Created by lstday
 * 29.10.15.
 */
public interface IStorage {
    void clear();

    void save(Resume resume);

    void update(Resume resume);

    Resume load(String uuid);

    void delete(String uuid);

    Collection<Resume> getAllSorted();

    int size();
}

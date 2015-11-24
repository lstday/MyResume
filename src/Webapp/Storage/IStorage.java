package Webapp.Storage;

import Webapp.AppException;
import Webapp.model.Resume;

import java.util.Collection;

/**
 * Created by lstday
 * 29.10.15.
 */
public interface IStorage {
    void clear();

    void save(Resume resume) throws AppException;

    void update(Resume resume);

    Resume load(String uuid);

    void delete(String uuid);

    Collection<Resume> getAllSorted();

    boolean isSectionSupported();

    int size();
}

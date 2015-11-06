package Webapp.Storage;

import Webapp.WebappException;
import Webapp.model.Resume;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by lstday
 * 29.10.15.
 */
public class ArrayStorage extends AbstractStorage<Integer> {
    public static final int LIMIT = 10000;
    private Resume[] array = new Resume[LIMIT];
    private int size;

    @Override
    protected Integer getContext(String uuid) {
        return null;
    }

    @Override
    protected boolean exist(Integer ctx) {
        return false;
    }

    @Override
    protected void doSave(Integer ctx, Resume resume) {

    }

    @Override
    protected void doUpdate(Integer ctx, Resume resume) {

    }

    @Override
    protected Resume doLoad(Integer ctx) {
        return null;
    }

    @Override
    protected void doDelete(Integer ctx) {

    }

    @Override
    protected List<Resume> doGetAll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

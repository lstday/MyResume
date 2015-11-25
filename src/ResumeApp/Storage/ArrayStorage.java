package ResumeApp.Storage;

import ResumeApp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lstday
 * 29.10.15.
 */
public class ArrayStorage extends AbstractStorage<Integer> {
    public static final int LIMIT = 10000;
    private Resume[] array = new Resume[LIMIT];
    private int size;

    @Override
    protected void doClear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    protected Integer getContext(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (array[i] != null) {
                if (array[i].getUuid().equals(uuid)) return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean exist(Integer idx) {
        return idx != -1;
    }

    @Override
    protected void doSave(Integer idx, Resume resume) {
        array[size++] = resume;
    }

    @Override
    protected void doUpdate(Integer idx, Resume resume) {
        array[idx] = resume;
    }

    @Override
    protected Resume doLoad(Integer idx) {
        return array[idx];
    }

    @Override
    protected void doDelete(Integer idx) {
        int numbers = size - idx - 1;
        if (numbers > 0) {
            System.arraycopy(array, idx + 1, array, idx, numbers);
        }
        array[--size] = null;
    }

    @Override
    protected List<Resume> doGetAll() {
        return Arrays.asList(Arrays.copyOf(array, size));
    }

    @Override
    public int size() {
        return size;
    }
}

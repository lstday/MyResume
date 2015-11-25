package ResumeApp.storage;

import ResumeApp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lstday
 * 13.11.15.
 */
public class MapStorage extends AbstractStorage<String> {

    private Map<String, Resume> MAP = new HashMap<>();

    @Override
    protected void doClear() {
        MAP.clear();
    }

    @Override
    protected String getContext(String uuid) {
        return uuid;
    }

    @Override
    protected boolean exist(String uuid) {
        return MAP.containsKey(uuid);
    }

    @Override
    protected void doSave(String uuid, Resume resume) {
        MAP.put(uuid, resume);
    }

    @Override
    protected void doUpdate(String uuid, Resume resume) {
        MAP.put(uuid, resume);
    }

    @Override
    protected Resume doLoad(String uuid) {
        return MAP.get(uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        MAP.remove(uuid);
    }

    @Override
    protected List<Resume> doGetAll() {
        return new ArrayList<>(MAP.values());
    }

    @Override
    public int size() {
        return MAP.size();
    }
}

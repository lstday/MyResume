package ResumeApp.storage;

import ResumeApp.ResumeAppException;
import ResumeApp.model.Resume;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by lstday
 * 05.11.15.
 */
abstract public class AbstractStorage<C> implements IStorage {
    protected final Logger logger = Logger.getLogger(getClass().getName());


    @Override
    public void clear() {
        logger.info("Delete all resumes.");
        doClear();
    }

    protected abstract void doClear();

    protected abstract C getContext(String uuid);

    private C getContext(Resume r) {
        return getContext(r.getUuid());
    }

    protected abstract boolean exist(C ctx);

    @Override
    public void save(Resume resume) {
        logger.info("Save resume with uuid " + resume.getUuid());
        C ctx = getContext(resume);
        if (exist(ctx)) {
            throw new ResumeAppException("Resume " + resume.getUuid() + " is already exist");
        }
        doSave(ctx, resume);
    }

    protected abstract void doSave(C ctx, Resume resume);

    @Override
    public void update(Resume resume) {
        logger.info("Update resume with uuid" + resume.getUuid());
        C ctx = getContext(resume);
        if (!exist(ctx)) {
            throw new ResumeAppException("Resume " + resume.getUuid() + " is not exist!");
        }
        doUpdate(ctx, resume);
    }

    protected abstract void doUpdate(C ctx, Resume resume);

    @Override
    public Resume load(String uuid) {
        logger.info("Load resume with uuid" + uuid);
        C ctx = getContext(uuid);
        if (!exist(ctx)) {
            throw new ResumeAppException("Resume " + uuid + " is not exist!");
        }
        return doLoad(ctx); //TODO ?
    }

    protected abstract Resume doLoad(C ctx);

    @Override
    public void delete(String uuid) {
        logger.info("Delete resume with uuid" + uuid);
        C ctx = getContext(uuid);
        if (!exist(ctx)) {
            throw new ResumeAppException("Resume " + uuid + " is not exist!");
        }
        doDelete(ctx); //TODO ?
    }

    protected abstract void doDelete(C ctx);

    @Override
    public Collection<Resume> getAllSorted() {
        logger.info(("getAllSorted"));
        List<Resume> list = doGetAll();
        Collections.sort(list, new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                int cmp = o1.getFullName().compareTo(o2.getFullName());
                if (cmp != 0) return cmp;
                return o1.getUuid().compareTo(o2.getUuid());
            }
        });
        return list;
    }

    @Override
    public boolean isSectionSupported() {
        return true;
    }

    protected abstract List<Resume> doGetAll();

    @Override
    public abstract int size();


}

package ResumeApp.storage;

import ResumeApp.ResumeAppException;
import ResumeApp.model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lstday
 * 20.11.15.
 */
public abstract class FileStorage extends AbstractStorage<File> {
    private File dir;

    public FileStorage(String path) {
        this.dir = new File(path);
        if (!dir.isDirectory() || !dir.canWrite())
            throw new IllegalArgumentException("'" + path + "' is not directory or directory is read only.");
    }

    @Override
    protected void doClear() {
        File[] files = dir.listFiles();
        if (files == null)
            return;
        for (File file : files) {
            doDelete(file);
        }
    }

    @Override
    protected File getContext(String fileName) {
        return new File(dir, fileName);
    }

    @Override
    protected boolean exist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(File file, Resume resume) {
        try {
            if (!file.createNewFile()) {
                throw new ResumeAppException("Could not create file" + file.getAbsolutePath(), resume);
            }
        } catch (IOException e) {
            throw new ResumeAppException("Could not create file" + file.getAbsolutePath(), resume, e);
        }
        write(file, resume);
    }

    @Override
    protected void doUpdate(File file, Resume resume) {
        write(file, resume);
    }

    protected void write(File file, Resume resume) {
        try {
            write(new FileOutputStream(file), resume);
        } catch (IOException e) {
            throw new ResumeAppException("Could not write file " + file.getAbsolutePath(), resume, e);
        }
    }

    @Override
    protected Resume doLoad(File file) {
        return read(file);
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new ResumeAppException("File " + file.getAbsolutePath() + " can not be deleted");
        }
    }

    @Override
    protected List<Resume> doGetAll() {
        File[] files = dir.listFiles();
        if (files == null) return Collections.emptyList();
        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(read(file));
        }
        return list;
    }

    protected Resume read(File file) {
        try {
            return read(new FileInputStream(file));
        } catch (IOException e) {
            throw new ResumeAppException("Could not write the file " + file.getAbsolutePath(), e);
        }
    }

    abstract protected void write(OutputStream os, Resume r) throws IOException;

    abstract protected Resume read(InputStream is) throws IOException;

    @Override
    public int size() {
        String[] list = dir.list();
        if (list == null) {
            throw new ResumeAppException("Couldn not read dir " + dir.getAbsolutePath());
        }
        return list.length;
    }
}

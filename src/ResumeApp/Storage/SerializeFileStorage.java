package ResumeApp.Storage;

import ResumeApp.ResumeAppException;
import ResumeApp.model.Resume;

import java.io.*;

/**
 * Created by lstday
 * 24.11.15.
 */
public class SerializeFileStorage extends FileStorage {

    public SerializeFileStorage(String path) {
        super(path);
    }

    @Override
    protected void write(OutputStream os, Resume resume) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(resume);
        }
    }

    @Override
    protected Resume read(InputStream is) throws IOException {
        try(ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new ResumeAppException("Cannot read resume.", e);
        }
    }

}

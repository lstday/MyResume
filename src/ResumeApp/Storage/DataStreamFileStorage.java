package ResumeApp.Storage;

import ResumeApp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by lstday
 * 24.11.15.
 */
public class DataStreamFileStorage extends FileStorage {

    public DataStreamFileStorage(String path) {
        super(path);
    }

    @Override
    protected void write(OutputStream os, Resume r) throws IOException {

    }

    @Override
    protected Resume read(InputStream is) throws IOException {
        return null;
    }
}

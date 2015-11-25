package ResumeApp;

import ResumeApp.model.Resume;

/**
 * Created by lstday
 * 30.10.15.
 */
public class ResumeAppException extends RuntimeException {
    private Resume resume = null;
    private String uuid = null;

    public ResumeAppException(String message) {
        super(message);
    }

    public ResumeAppException(String message, Resume resume) {
        super(message);
        this.resume = resume;
    }

    public ResumeAppException(String message, Throwable e) {
        super(message, e);
    }

    public ResumeAppException(String message, Resume resume, Throwable e) {
        super(message, e);
        this.resume = resume;
    }

    public ResumeAppException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public Resume getResume() {
        return resume;
    }

    public String getUuid() {
        return uuid;
    }
}

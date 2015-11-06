package Webapp;

import Webapp.model.Resume;

/**
 * Created by lstday
 * 30.10.15.
 */
public class WebappException extends RuntimeException {
    private Resume resume = null;
    private String uuid = null;

    public WebappException(String message) {
        super(message);
    }

    public WebappException(String message, Resume resume) {
        super(message);
        this.resume = resume;
    }

    public WebappException(String message, Throwable e) {
        super(message, e);
    }

    public WebappException(String message, Resume resume, Throwable e) {
        super(message, e);
        this.resume = resume;
    }

    public WebappException(String message, String uuid) {
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

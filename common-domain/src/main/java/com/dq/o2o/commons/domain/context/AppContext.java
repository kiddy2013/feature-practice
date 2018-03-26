package com.dq.o2o.commons.domain.context;

public class AppContext extends ClientContext {
    private String source;
    private String accessToken;

    public AppContext() {
    }

    public AppContext(String source) {
        this.source = source;
    }

    public AppContext(String source, String accessToken) {
        this.source = source;
        this.accessToken = accessToken;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}

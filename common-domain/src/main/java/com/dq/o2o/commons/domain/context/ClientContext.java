
package com.dq.o2o.commons.domain.context;

import java.io.Serializable;

public class ClientContext implements Serializable {
    private String ip;

    public ClientContext() {
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class RequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static String serverIp = "";
    private String appKey;
    private String appIp;
    private String appValidate;

    public RequestDTO() {
        this.appIp = serverIp;
    }

    private static String getIp() {
        String localip = null;
        String netip = null;

        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            boolean finded = false;

            while(true) {
                while(netInterfaces.hasMoreElements() && !finded) {
                    NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
                    Enumeration address = ni.getInetAddresses();

                    while(address.hasMoreElements()) {
                        ip = (InetAddress)address.nextElement();
                        if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                            netip = ip.getHostAddress();
                            finded = true;
                            break;
                        }

                        if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                            localip = ip.getHostAddress();
                        }
                    }
                }

                return netip != null && !"".equals(netip) ? netip : localip;
            }
        } catch (Throwable var7) {
            var7.printStackTrace();
            return netip != null && !"".equals(netip) ? netip : localip;
        }
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppIp() {
        return this.appIp;
    }

    public void setAppIp(String appIp) {
        this.appIp = appIp;
    }

    public String getAppValidate() {
        return this.appValidate;
    }

    public void setAppValidate(String appValidate) {
        this.appValidate = appValidate;
    }

    static {
        try {
            serverIp = getIp();
        } catch (Exception var1) {
            serverIp = "0.0.0.0";
        }

    }
}

package practice.feature.java.core.serviceimpl.impl;

import practice.feature.java.core.serviceimpl.JackService;

public class MetalService implements JackService {
    @Override
    public void showMe() {
        System.out.println(this.getClass().getName());
    }
}
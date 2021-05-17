package com.andersen.shkraba.core;

import com.andersen.shkraba.utils.InitDriver;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    private InitDriver initDriver;

    @BeforeClass
    public void initPages() {
        initDriver = new InitDriver();
        initDriver.initDriverSettings();
    }

    protected abstract void createPage();

}

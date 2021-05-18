package com.andersen.shkraba.core;

import org.testng.annotations.BeforeClass;
import com.andersen.shkraba.utils.InitDriver;

public abstract class BaseTest {

    private InitDriver initDriver;

    @BeforeClass
    public void initPages() {
        initDriver = new InitDriver();
        initDriver.initDriverSettings();
    }

    protected abstract void createPage();

}

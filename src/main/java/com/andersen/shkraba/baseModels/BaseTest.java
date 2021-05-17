package com.andersen.shkraba.baseModels;

import com.andersen.shkraba.utils.InitDriver;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    InitDriver initDriver;

    @BeforeClass
    public void initPages() {
        initDriver = new InitDriver();
        initDriver.initDriverSettings();
    }

    protected abstract void createPages();

}

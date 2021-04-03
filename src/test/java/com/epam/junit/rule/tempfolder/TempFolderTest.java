package com.epam.junit.rule.tempfolder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class TempFolderTest {

    private static File tempFolder;

    /*TemporaryFolder Rule allows creation of files and folders that should
      be deleted when the test method finishes (whether it passes or
      fails)*/
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    //newFolder() - returns a new fresh folder with the given name under ~\AppData\Local\Temp\<generated temporary folder>\
    @Test
    public void renameMe() throws IOException {
        tempFolder = temporaryFolder.newFolder("tempFolder");
        assertTrue(tempFolder.exists());
    }

    @After
    public void after() {
        System.out.printf("after test %b%n", tempFolder.exists());
        System.out.println(tempFolder.getAbsolutePath());
    }

    @AfterClass
    public static void afterClass() {
        System.out.printf("after class %b%n", tempFolder.exists());
    }
}

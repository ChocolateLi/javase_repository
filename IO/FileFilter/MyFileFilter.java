package com.IO.FileFilter;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory()||pathname.getName().endsWith(".txt");
    }
}

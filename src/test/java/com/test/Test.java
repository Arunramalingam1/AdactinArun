package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;

public class Test extends BaseClass {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String projectPath = getProjectPath();
		System.out.println(projectPath);
		String propertyfilevalue = getPropertyfilevalue("jvmpath");
		System.out.println(propertyfilevalue);
	}

}

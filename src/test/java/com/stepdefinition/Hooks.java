package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class Hooks extends BaseClass {
	/**
	 * @see Used to Launch the application  
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	@Before
	public void beforeScenerio() throws FileNotFoundException, IOException {
		getBrowser(getPropertyfilevalue("browser"));
    	enterapplicationUrl(getPropertyfilevalue("url"));
		maximizeWindow();
		implicitWait(1000);

	}
	/**
	 * @see Used to capture ScreenShot and Quit Window
	 * @param Scenerio
	 */

	@After
	public void afterScenerio(Scenario Scenerio) {
		Scenerio.attach(screenShot(), "IMG/png", "Screenshot after each Scenerio ");
		quite();

	}

}

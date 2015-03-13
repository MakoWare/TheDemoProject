package com.makoware.demoproject.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.makoware.demoproject.TheDemoProject;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        // 1080p
        config.width = 1280;
        config.height = 720;

		new LwjglApplication(new TheDemoProject(), config);
	}
}

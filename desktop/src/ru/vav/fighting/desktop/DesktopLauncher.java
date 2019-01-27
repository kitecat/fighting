package ru.vav.fighting.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.vav.fighting.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Fighting";
		config.height = 720;
		config.width = 1280;
		new LwjglApplication(new Game(), config);
	}
}

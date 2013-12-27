package ru.ucoz.megadiablo.android.apm.ui.plaf;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author MegaDiablo
 */
public final class UserInterfaceUtils {

	private UserInterfaceUtils() {
	}

	public static void setLookAndFeel(final Theme pTheme) {
		if (pTheme == null) {
			setSystemTheme();
		} else {
//			plaf.setThemeDefault();
			JFrame.setDefaultLookAndFeelDecorated(true);
			try {
				UIManager.setLookAndFeel(pTheme.getParent().getLookAndFeel());
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();

				setSystemTheme();
			}
		}
	}
	
	private static void setSystemTheme() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		try {
			UIManager.setLookAndFeel(UIManager
				.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}

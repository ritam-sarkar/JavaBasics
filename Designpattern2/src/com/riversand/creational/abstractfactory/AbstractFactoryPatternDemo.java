package com.riversand.creational.abstractfactory;

import javax.xml.parsers.DocumentBuilder;

/**
 * 
 * @author ritsarka
 * Example {@link DocumentBuilder}
 * This is used as factory of factory design pattern
 * an abstract layer over factory pattern , means it is factory of factory
 *
 *
 */
public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		GUIFactory factory;

		String os = "Windows"; // Could be determined dynamically

		if (os.equalsIgnoreCase("Windows")) {
			factory = new WindowsFactory();
		} else {
			factory = new MacFactory();
		}

		Button button = factory.createButton();
		Checkbox checkbox = factory.createCheckbox();

		button.paint();       // Output: Windows Button
		checkbox.check();     // Output: Windows Checkbox

	}

}
// Product interfaces
interface Button {
	void paint();
}
interface Checkbox {
	void check();
}

// Concrete products (Windows)
class WindowsButton implements Button {
	public void paint() { System.out.println("Windows Button"); }
}
class WindowsCheckbox implements Checkbox {
	public void check() { System.out.println("Windows Checkbox"); }
}

// Concrete products (Mac)
class MacButton implements Button {
	public void paint() { System.out.println("Mac Button"); }
}
class MacCheckbox implements Checkbox {
	public void check() { System.out.println("Mac Checkbox"); }
}

// Abstract Factory
interface GUIFactory {
	Button createButton();
	Checkbox createCheckbox();
}

// Concrete factories
class WindowsFactory implements GUIFactory {
	public Button createButton() { return new WindowsButton(); }
	public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}

class MacFactory implements GUIFactory {
	public Button createButton() { return new MacButton(); }
	public Checkbox createCheckbox() { return new MacCheckbox(); }
}


/**
 * 
 */
package com.riversand.creational.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ritsarka
 *
 * This pattern avoids costly creation
 * avoids subclassing because like builder pattern it follows immutablity
 * Usually implemented with registry
 * Example {@link Object#clone()} 
 * Unlike builder pattern it is difficult implement in legacy code.
 * Prototype design pattern is used when the Object creation is a costly affair and requires a lot of time
 * and resources and you have a similar object already existing
 * We can achieve this by using clone() method but it will create just another instance of the same object.
 */
public class PrototypePatternDemo {
	public static void main(String[] args) {
		List<String> sections = List.of("Introduction", "Body");
		Map<String, String> metadata = Map.of("version", "1.0", "status", "draft");

		DocumentTemplate original = new DocumentTemplate("Design Doc", "Alice", sections, metadata);
		DocumentTemplate clone = original.clone();

		// Modify clone
		clone.addSection("Conclusion");
		clone.updateMetadata("status", "final");

		System.out.println("=== Original ===");
		original.print();

		System.out.println("\n=== Clone ===");
		clone.print();
	}


}
class DocumentTemplate implements Cloneable {
	private final String title; // Immutable
	private final String author; // Immutable
	private List<String> sections; // Mutable
	private Map<String, String> metadata; // Mutable

	public DocumentTemplate(String title, String author, List<String> sections, Map<String, String> metadata) {
		this.title = title;
		this.author = author;
		this.sections = new ArrayList<>(sections); // Defensive copy
		this.metadata = new HashMap<>(metadata);   // Defensive copy
	}

	// Deep clone
	@Override
	public DocumentTemplate clone() {
		try {
			DocumentTemplate copy = (DocumentTemplate) super.clone();
			// Deep copy mutable fields
			copy.sections = new ArrayList<>(this.sections);
			copy.metadata = new HashMap<>(this.metadata);
			return copy;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Cloning not supported", e);
		}
	}

	// Utility methods for demonstration
	public void addSection(String section) {
		this.sections.add(section);
	}

	public void updateMetadata(String key, String value) {
		this.metadata.put(key, value);
	}

	public void print() {
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Sections: " + sections);
		System.out.println("Metadata: " + metadata);
	}
}

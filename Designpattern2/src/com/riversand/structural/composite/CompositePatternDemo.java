package com.riversand.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Componenets representpart of whole structure
 * Compose objects into tree structure
 * Individual object treated as Composite
 * Examples : java.awt.Componenet
 *            jsf widgets
 *            File system and path
 */
public class CompositePatternDemo {

	/**
	 * Each menu has menu items
	 *  Menu is also following hierarchy , Main
	 *  MenuItem and Menu are MenuComponent
	 * @param args
	 */
	public static void main(String[] args) {

		Folder root = new Folder("root");

		File file1 = new File("file1.txt");
		File file2 = new File("file2.txt");

		Folder subFolder = new Folder("subfolder");
		subFolder.add(new File("subfile1.txt"));

		root.add(file1);
		root.add(subFolder);
		root.add(file2);

		root.display("");
		
	}
}
// Component
interface FileSystemItem {
	void display(String indent);
}

// Leaf
class File implements FileSystemItem {
	private String name;

	public File(String name) {
		this.name = name;
	}

	public void display(String indent) {
		System.out.println(indent + "File: " + name);
	}
}

// Composite
class Folder implements FileSystemItem {
	private String name;
	private List<FileSystemItem> children = new ArrayList<>();

	public Folder(String name) {
		this.name = name;
	}

	public void add(FileSystemItem item) {
		children.add(item);
	}

	public void display(String indent) {
		System.out.println(indent + "Folder: " + name);
		for (FileSystemItem item : children) {
			item.display(indent + "  ");
		}
	}
}



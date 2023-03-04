package com.riversand.structural.decorator;
/**
 * We are decorating Inputsream over file, datainputstream over inputstream
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DecoratorPatterExample {

	public static void main(String[] args) throws IOException {

		File file = new File("test.txt");
		file.createNewFile();
		OutputStream ostream = new FileOutputStream(file);
		DataOutputStream dataOutputStream = new DataOutputStream(ostream);
		dataOutputStream.writeChars("text");
		InputStream iStream = new FileInputStream(file);
		DataInputStream dataInputStream = new DataInputStream(iStream);
		System.out.println(dataInputStream.readLine());		
	}

}

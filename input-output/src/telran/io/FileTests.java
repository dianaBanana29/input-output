package telran.io;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileTests {
File file;
@BeforeEach
void setUp() {
	file = new File("dir1");
	file.delete();
	new File("file1.txt").delete();
}
	@Test
	void newDirectoryTest() {

		assertFalse(file.exists());
		file.mkdir();
		assertTrue(file.exists());
	}
@Test
void printDirectoryContent() {
	printDirectory("..", 2);
}
private void printDirectory(String pathName, int level) {
	// TODO Auto-generated method stub
	
}
@Test
void printStreamTest() throws Exception{
	PrintStream printStream = new PrintStream("file1.txt");
	printStream.println("Hello");
	BufferedReader reader = new BufferedReader(new FileReader("file1.txt"));
	assertEquals("Hello", reader.readLine());
	printStream.close();
	reader.close();
}
@Test
void printWriterTest() throws Exception{
	PrintWriter printWriter = new PrintWriter("file1.txt");
	printWriter.println("Hello");
	BufferedReader reader = new BufferedReader(new FileReader("file1.txt"));
	assertEquals("Hello", reader.readLine());
	printWriter.close();
	reader.close();
}
}

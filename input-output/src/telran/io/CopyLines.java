package telran.io;
import java.io.*;
public class CopyLines {
private static final String CONSOLE = "Console";
public static void main(String[] args) {
	if(args.length < 2) {
		System.out.println("too few arguments: usage - first argument defines source; second -");
		
	} else {
		try {
			BufferedReader	reader = getReader(args[0]);
		PrintStream stream = getStream(args[1]);
		copy(reader, stream);
		} catch{
			
		}
}
}
private static void copy(BufferedReader reader, PrintStream stream) throws Exception {
while(true) {
	String line;
	try {
		line = reader.readLine();
		if(line == null) {
			break;
		}
		stream.println(line);
	}
	catch (IOException e) {
		throw new Exception("Error in reading" + e.getMessage());
	}
}
}
private static PrintStream getStream(String destination) throws Exception {
	
	return destination.equals(CONSOLE) ? System.out : getStreamFile(destination);
}
private static PrintStream getStreamFile(String destination) throws Exception {
	
	try {
		return new PrintStream(destination);
	} catch (FileNotFoundException e) {
	
throw new Exception(String.format("Destination path %s contains non-excisted directory", destination));
	}
}
private static BufferedReader getReader(String source) throws Exception {
	BufferedReader readerRes = source.equals(CONSOLE) ? getConsoleReader() : getFileReader(source);
			return readerRes;
}
private static BufferedReader getFileReader(String source) throws Exception {
	
	try {
		return new BufferedReader(new FileReader(source));
	} catch (FileNotFoundException e) {
		throw new Exception(String.format("sourse %s doesn`t exist", source));
	}
}
private static BufferedReader getConsoleReader() {
	
	return new BufferedReader(new InputStreamReader(System.in));
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DanijelSokac
 */
public abstract class FilesUtils {
    public static File getUserWorkingDir() {
        return new File(".");
    }
    
    public static String getFileContent(File file, Charset charset) {
        StringBuilder sb = new StringBuilder();   
        FileInputStream inputStream = null;
	Scanner sc = null;
	try {
	    inputStream = new FileInputStream(file);
	    sc = new Scanner(inputStream, charset.name());
	    while (sc.hasNextLine()) {
	        String line = sc.nextLine();
                sb.append(line);
                sb.append(System.lineSeparator());
	    }
	    // note that Scanner suppresses exceptions
	    if (sc.ioException() != null) {
	        throw sc.ioException();
	    }
	} catch (IOException ex) {
            Logger.getLogger(FilesUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
	    if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(FilesUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
	    }
	    if (sc != null) {
	        sc.close();
	    }
	}
        return sb.toString();
    }
    
    public static File writeToFile(File location, String fileName, String content, Charset charset) throws IOException {
        File newFile = new File(location, fileName);
        if(!newFile.exists()) {
            newFile.createNewFile();
        }
        Files.write(newFile.toPath(), content.getBytes(charset));
        return newFile;
    }
    
    public static File writeToFile(File location, String fileName, List<String> lines, Charset charset) throws FileNotFoundException, IOException {
        File file = new File(location, fileName);
	FileOutputStream fos = new FileOutputStream(file);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, charset));
 
	for (String line : lines) {
		bw.write(line);
		bw.newLine();
	}
 
	bw.close();
        return file;
    }
    
    public static File storeFile(File location, File file, Charset charset) throws Exception {
        if(!location.isDirectory()) {
            throw new Exception("The location MUST be a directory!!!");
        }
        if(!location.exists()) {
            location.mkdirs();
        }
        String content = getFileContent(file, charset);
        return writeToFile(location, file.getName(), content, charset);
    }
    
    public static File storeFile(File location, String filename, String content, Charset charset) throws Exception {
        return writeToFile(location, filename, content, charset);
    }
}

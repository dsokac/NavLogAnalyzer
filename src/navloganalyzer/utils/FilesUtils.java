/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navloganalyzer.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import navloganalyzer.models.StudentAttendanceItem;

public class FilesUtils {
    private static FilesUtils INSTANCE = null;
    
    private FilesUtils() {}
    
    public static FilesUtils getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new FilesUtils();
        }
        return INSTANCE;
    }
    
    public File getUserWorkingDir() {
        return new File(".");
    }
    
    public File getDirectory(String path) throws Exception {
        return getDirectory(null, path);
    }
    
    public File getDirectory(File directory, String name) throws Exception {
        return getFileOrDirectory(directory, name, false);
    }
    
    public File getFile(String path) throws Exception {
        return getFile(null, path, false);
    }
    
    public File getFile(String path, boolean append) throws Exception {
        return getFile(null, path, append);
    }
    
    public File getFile(File directory, String name) throws Exception {
        return getFile(directory, name, false);
    }
    
    public File getFile(File directory, String name, boolean append) throws Exception {
        return getFileOrDirectory(directory, name, append);
    }
    
    public File getFileOrDirectory(File directory, String name, boolean append) throws Exception {
        File output = null;
        if(directory != null) {            
            output = new File(directory, name);
        } else {
            output = new File(name);
        }
        
        if(output.exists() && append) {
            output.delete();
        }
        if(!output.exists()) {
            File parent = output.getParentFile();
            if(parent != null) {
                if(!parent.exists()) {
                    parent.mkdirs();
                }
            }
            String fileName = output.getName();
            if(!fileName.isEmpty()) {
                if(fileName.contains(".")) {
                    output.createNewFile();
                } else {
                    output.mkdirs();
                }
            }
        } 
        return output;
    }
    
    public String getFileContent(File file, Charset charset) {
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
    
    public File writeToFile(File location, String fileName, String content, Charset charset) throws IOException, Exception {
        File newFile = getFile(location, fileName, false);
        Files.write(newFile.toPath(), content.getBytes(charset));
        return newFile;
    }
    
    public File writeToFile(File location, String fileName, List<String> lines, Charset charset) throws FileNotFoundException, IOException, Exception {
        File file = getFile(location, fileName);
	FileOutputStream fos = new FileOutputStream(file);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, charset));
 
	for (String line : lines) {
		bw.write(line);
		bw.newLine();
	}
 
	bw.close();
        return file;
    }
    
    public File storeFile(File location, File file, Charset charset) throws Exception {
        String content = getFileContent(file, charset);
        return writeToFile(location, file.getName(), content, charset);
    }
    
    public File storeFile(File location, String filename, String content, Charset charset) throws Exception {
        return writeToFile(location, filename, content, charset);
    }
    
    public void writeJsontoFile(Object data, String folderName, String fileName) throws Exception {
        File dataFolder = getDirectory(getUserWorkingDir(), folderName);
        
        String content = new Gson().toJson(data);
        try {
            storeFile(dataFolder, fileName, content, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(FilesUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FilesUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<StudentAttendanceItem> readJsonArrayFromFile(String folderName, String fileName) throws Exception {
        File folder = getDirectory(getUserWorkingDir(), folderName);
        File file = getFile(folder, fileName);
        String content = getFileContent(file, StandardCharsets.UTF_8);
        List<StudentAttendanceItem> items;    
        java.lang.reflect.Type listType = new TypeToken<List<StudentAttendanceItem>>() {}.getType();
        items = new Gson().fromJson(content, listType);
        return items;
    }
}

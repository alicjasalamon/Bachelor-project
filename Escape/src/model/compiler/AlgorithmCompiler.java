package model.compiler;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

public class AlgorithmCompiler {
    
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static Object getInstanceOfCompiledAlgorithm(File javaFile) {
        
		try {
	        
	        String fullName = "model.backbone.algorithm." + javaFile.getName().substring(0, javaFile.getName().length()-5);
	        StringBuilder src = new StringBuilder();
	        
	        Path path = javaFile.toPath();
	        try (Scanner scanner =  new Scanner(path, ENCODING.name())){
	          while (scanner.hasNextLine()){
	            src.append(scanner.nextLine() + "\n");
	          }      
	        }
	
	        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	        JavaFileManager fileManager = new
	            ClassFileManager(compiler
	                .getStandardFileManager(null, null, null));
	
	        List<JavaFileObject> jfiles = new ArrayList<JavaFileObject>();
	        jfiles.add(new CharSequenceJavaFileObject(fullName, src));
	
	        compiler.getTask(null, fileManager, null, null,
	            null, jfiles).call();
	
	        Object instance = fileManager.getClassLoader(null)
	            .loadClass(fullName).newInstance();
	        return instance;
	    
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
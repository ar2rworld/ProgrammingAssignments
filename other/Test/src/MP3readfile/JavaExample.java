package MP3readfile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
	public class JavaExample {

	    public static void main(String[] args) {

	        final File folder = new File("C:\\Users\\Artur\\Music");

	        List<String> result = new ArrayList<>();

	        search(".*\\.mp3", folder, result);

	        for (String s : result) {
	            System.out.println(s);
	        }

	    }

	    public static void search(final String pattern, final File folder, List<String> result) {
	        for (final File f : folder.listFiles()) {

	            if (f.isDirectory()) {
	                search(pattern, f, result);
	            }

	            if (f.isFile()) {
	                if (f.getName().matches(pattern)) {
	                    result.add(f.getAbsolutePath());
	                }
	            }

	        }
	    }
	    public static void search1(final String pattern, final File folder, List<File> result) {
	        for (final File f : folder.listRoots()) {
	            for(File file : f.listFiles()) {
	                if (file.getName().matches(pattern)) {
	                    result.add(file);
	                }
	            }
	            
	        }
	        search1(pattern,folder, result);
	    }
	    
	}

package analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import model.Log;

public class Analyzer {
	
	public static void main(String[] args) {
		init();
		List<File> flist = getFileList();
		for  (File file : flist) {
			doAnalyze(file);
			
		}
	}

	private static void init() {
		File target = new File("data");
		if  (!target.exists()) target.mkdirs();		
	}

	private static void doAnalyze(File file) {
		BufferedReader bin;
		try {
			bin = new BufferedReader(new FileReader(file));
			String str =  bin.readLine();
			while (str != null){
				Log log = LogParser.getLog(str.trim());
				if  (log != null) {
					Outputer.output(log);
				};
				str =  bin.readLine();
				
			}
			bin.close();
		} catch (FileNotFoundException e) {
			System.out.println(file.getName() + " is not exist");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("analyze " + file.getName() + " wrong");
			e.printStackTrace();
		}
	}

	private static List<File> getFileList() {
		return null;
	}

}

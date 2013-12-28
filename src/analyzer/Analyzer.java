package analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import model.Log;

public class Analyzer {
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println("begin to parse files...");
		List<File> flist = getFileList();
		for  (File file : flist) {
			System.out.println("begin to analyze : " +  file.getName());
			doAnalyze(file);
		}
		System.out.println("finish!");
		destroy();
	}

	private static void destroy() throws IOException {
		LogParser.destroy();
	}

	private static void init() throws IOException {
		System.out.println("initial...");
		LogParser.init();
		Outputer.init();
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
		List<File> rst =  new LinkedList<File>();
		File file = new File("file.config");
		
		try {
			BufferedReader bin = new BufferedReader(new FileReader(file));
			String str = bin.readLine();
			while (str !=  null){
				if (str.trim().length() != 0){
					File infile =  new File(str);
					if  (infile.exists()) rst.add(infile);
				}
				str = bin.readLine();
			}
			bin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
	}

}

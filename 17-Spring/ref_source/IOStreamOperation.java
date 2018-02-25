/***
实现将文本"hello world"写入到D盘test.txt文件中，并读取该文件文本内容打印出来的功能。
***/

import java.io.*;

class IOStreamOperation{
	public static void main(String args[]) throws IOException{
//		fileWriter();  //字符流写读操作
//		fileReader();  //字符流读操作
		fileOutput();  //字节流写操作
		fileInput();   //字节流读操作
	}
	
	public static void fileOutput() throws IOException{
		String str = "hello world!";
		File file = new File("d:\\test2.txt");   //创建文件
		if(!file.exists()){
			file.createNewFile();     //如果文件不存在，则进行创建
		}
		FileOutputStream fOutput = new FileOutputStream(file);
		BufferedOutputStream bOutput = new BufferedOutputStream(fOutput);
		byte[] buffer = str.getBytes(); //将字符串文本转换成字节数组
		bOutput.write(buffer);
		bOutput.close();
		fOutput.close();
	}
	
	public static void fileInput() throws IOException{
		File file = new File("d:\\test2.txt");    //创建文件
		FileInputStream fIutput = new FileInputStream(file);
		BufferedInputStream bIutput = new BufferedInputStream(fIutput);
		int temp = 0;
		while((temp = bIutput.read())!= -1){    //当temp为-1时，数据读取完毕
			System.out.print((char)temp);
		}
		bIutput.close();
		fIutput.close();
	}
	
	public static void fileWriter() throws IOException{
		String str = "hello world!";
		File file = new File("d:\\test.txt");
		if(!file.exists()){
			file.createNewFile();     //如果文件不存在，则进行创建
		}
		FileWriter fwWriter = new FileWriter(file);
		BufferedWriter bWriter = new BufferedWriter(fwWriter);
		bWriter.write(str);
		bWriter.close();
		fwWriter.close();
	}
	
	public static void fileReader() throws IOException{
		File file = new File("d:\\test.txt");
		FileReader fReader = new FileReader(file);
		BufferedReader buReader = new BufferedReader(fReader);
		String temp = null;
		while((temp = buReader.readLine()) != null){  //当temp为null时，数据读取完毕
			System.out.println(temp);
		}
		buReader.close();
		fReader.close();
	}
}

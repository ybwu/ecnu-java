/**
实现将文本"hello world"写入到D盘test.txt文件中，并读取该文件文本内容打印出来的功能
**/

import java.io.*;

class IOStreamOperation{
	public static void main(String args[]) throws IOException{
//		fileWriter();  //字符流写读操作
//		fileReader();  //字符流读操作
		fileOutput();  //字节流写操作
		fileInput();   //字节流读操作
	}
	/* fileOutput()函数 
	功能：Java中的字节流文件写入操作
	用途:在d盘的test2.txt文件中写入hello world！
	主要步骤：1.判断test2.txt文件存在，若不存在则新建该文件。
			  2.利用File对象file创建字节流输出类型FileOutputStream对象fOutput
			  3.利用字节流输出类型FileOutputStream对象fOutput创建缓存字节流输出类型BufferedOutputStream对象bOutput
			  4.用bOutput的write方法将转换为字节数组的数据写入到文件中。
			  5.利用close方法关闭上述的两个流对象。
	*/
	public static void fileOutput() throws IOException{
		String str = "hello world!";
		File file = new File("d:\\test2.txt");   //创建文件对象
		if(!file.exists()){
			file.createNewFile();     //如果文件不存在，则进行创建  步骤1
		}
		FileOutputStream fOutput = new FileOutputStream(file);//步骤2
		BufferedOutputStream bOutput = new BufferedOutputStream(fOutput);//步骤3
		byte[] buffer = str.getBytes(); //将字符串文本转换成字节数组
		bOutput.write(buffer);//步骤4
		bOutput.close();
		fOutput.close();//步骤5
	}
	/* fileInput()函数 
	功能：Java中的字节流文件读取操作
	用途:读入d盘的test2.txt文件中的数据
	主要步骤：
			  1.利用File对象file创建字节流输入类型FileInputStream对象fIutput
			  2.利用字节流输入类型FileInputStream对象fIutput创建缓存字节流输入类型BufferedInputStream对象bIutput
			  3.用bIutput的read方法读取文件数据
			  4.利用close方法关闭上述的两个流对象。
	*/
	public static void fileInput() throws IOException{
		File file = new File("d:\\test2.txt");    //创建文件对象
		FileInputStream fIutput = new FileInputStream(file);//步骤1
		BufferedInputStream bIutput = new BufferedInputStream(fIutput);//步骤2
		int temp = 0;
		//read方法每次读取一个字节。当temp为-1时，表示已到达文件结尾。数据读取完毕
		while((temp = bIutput.read())!= -1){    
			System.out.print((char)temp);//步骤3 注意强制类型转换
		}
		bIutput.close();
		fIutput.close();//步骤4
	}
	/* fileWriter()函数 
	功能：Java中的字符流文件写入操作
	用途:在d盘的test2.txt文件中写入hello world！
	主要步骤：1.判断test2.txt文件存在，若不存在则新建该文件。
			  2.利用File对象file创建字符流输出类型FileWriter对象fwWriter
			  3.利用字符流输出类型FileWriter对象fwWriter创建缓存字符流输出类型BufferedWriter对象bWriter
			  4.用bWriter的write方法将数据写入到文件中。
			  5.利用close方法关闭上述的两个流对象。
	*/
	public static void fileWriter() throws IOException{
		String str = "hello world!";
		File file = new File("d:\\test.txt");
		if(!file.exists()){
			file.createNewFile();     //如果文件不存在，则进行创建 步骤1
		}
		FileWriter fwWriter = new FileWriter(file);//步骤2
		BufferedWriter bWriter = new BufferedWriter(fwWriter);//步骤3
		bWriter.write(str);//步骤4
		bWriter.close();
		fwWriter.close();//步骤5
	}
	/* fileWriter()函数 
	功能：Java中的字符流文件读取操作
	用途:读取d盘的test2.txt文件中的数据
	主要步骤：
			  1.利用File对象file创建字符流输入类型FileReader对象fReader
			  2.利用字符流输入类型FileReader对象fReader创建缓存字符流输入类型BufferedReader对象buReader
			  3.用buReader的readLine方法读取文件中的数据
			  4.利用close方法关闭上述的两个流对象。
	*/
	public static void fileReader() throws IOException{
		File file = new File("d:\\test.txt");
		FileReader fReader = new FileReader(file);//步骤1
		BufferedReader buReader = new BufferedReader(fReader);//步骤2
		String temp = null;
		//readline方法每次读取文件的一行 当temp为null时，到达文件结尾 数据读取完毕 步骤3
		while((temp = buReader.readLine()) != null){  
			System.out.println(temp);
		}
		buReader.close();
		fReader.close();//步骤4
	}
}

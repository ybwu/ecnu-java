/*
 *
 * 使用IOStreamOperation.java中文件读写方法的步骤:
 * 1. 根据需求选择fileReader, fileWriter, fileInput, fileOutput
 * 2. 将该方法整体拷贝到定义的类中(即, 这里的MyType类). 
 * 3. 在文件头添加 import java.io.*;
 * 4. 在main函数后增加 throws IOException
 * 5. 在主函数中使用该方法
 *
 * */

import java.io.*;

public class MyType {
    int i;
    double d;
    char c;
    void set(double data){
        d = data;
    }
    double get(){
        return d;
    }

	public static void fileReader() throws IOException{
		File file = new File("d:\\test.txt");
		FileReader fReader = new FileReader(file);
		BufferedReader buReader = new BufferedReader(fReader);
		String temp = null;
		while((temp = buReader.readLine()) != null){  
			System.out.println(temp);
		}
		buReader.close();
		fReader.close();
	}

    public static void main(String[] argv) throws IOException{
        MyType m = new MyType();
        m.set(1.5);
        System.out.println(m.get());

        m.fileReader();
    }


}

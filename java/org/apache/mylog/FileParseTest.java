package org.apache.mylog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;

public class FileParseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String absUrl="D:\\log\\code";
		File srcFileDir=new File(absUrl);
		if(srcFileDir.exists())
		{
			FilenameFilter filter=new JavaNameFilter();;
			String[] fileNames=srcFileDir.list(filter);
			if(fileNames.length>0)
			{
				File tf=new File(absUrl+File.separator+fileNames[0]);
				BufferedReader bfd=null;
				try{
					 	bfd=new BufferedReader(new FileReader(tf));
					 	boolean flag=true;
					 	while(flag)
					 	{
					 		String s=bfd.readLine();
					 		if(s==null)
					 			flag=false;
					 		else if(s.contains("{"))
					 			System.out.println(s);
					 	}
					 	
					
				} catch (Exception e) {
						e.printStackTrace();
				}
				finally
				{
					try
					{
						if(bfd!=null)
							bfd.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
			
			}
		}
		else
			System.out.println("目录不存在!");
	}
	
	
	private boolean checkBegin(String str)
	{
		if(str.contains("{"))
			return true;
		else
			return false;
	}
	
	private boolean checkMethodBegin(String str)
	{
		return false;
	}
	
	
	private int checkString(String str)
	{
		
		return 0;
	}
	
	
	private final static int begin_flag=1; //含有 {
	
	private final static  int end_flag=2;   //含有 }
	
	private final static int class_word=3;   //含有关键字  class
	
	private final static int method_begin=4;   //含有 (
	
	private final static int method_end=5;     //含有  )
	
	
			
	


}

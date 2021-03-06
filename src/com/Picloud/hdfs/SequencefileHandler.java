package com.Picloud.hdfs;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.springframework.stereotype.Service;

@Service
public class SequencefileHandler {
	public static String hdfsUrl = "hdfs://localhost:9000";
	
	/**
	 * 打包成sequencefile到HDFS
	 * @author Jet-Muffin
	 * @param items
	 * @throws IOException
	 */
	public  void packageToHdfs(File[] items,String filePath) throws IOException{
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(hdfsUrl), conf);
		FSDataInputStream in = null;
		BytesWritable value = new BytesWritable();
		Text key = new Text();
		Path path = new Path(fs.getHomeDirectory(),filePath);

		SequenceFile.Writer writer = null;
		writer = SequenceFile.createWriter(fs, conf, path, key.getClass(),value.getClass());
		
		for (File item : items) {
			try {
				String filename = item.getName();
				byte buffer[] = getBytes(item);
				writer.append(new Text(filename), new BytesWritable(
						buffer));		
			} catch (Exception e) {
				System.out.println("Exception MESSAGES = " + e.getMessage());
				e.printStackTrace();
			}
			item.delete();
		}
		writer.close();
	}
	
	/**
	 * 获取同步点集合
	 * @param filePath
	 * @return ArrayList 同步点集合
	 * @throws IOException
	 */
	public  ArrayList getSyncPosition(String filePath) throws IOException {
			Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(URI.create(hdfsUrl), conf);
	
			Path seqPath = new Path(fs.getHomeDirectory(), filePath);
			SequenceFile.Reader reader = new SequenceFile.Reader(fs, seqPath, conf);// 创建实例	
			
			BytesWritable value = new BytesWritable();
			Text key = new Text();
		
			ArrayList List = new ArrayList(); 
			long position = reader.getPosition();
			while(reader.next(key,value)){
				System.out.println(key + "======" + position);// 打印已读取键值对
				position = reader.getPosition();
				List.add(position); 
				//TODO 将position信息保存到hbase里
			}
			return List;
		}		
	
	/**
	 * 获取同步点集合，保存到hbase里
	 * @param filePath
	 * @throws IOException
	 */
	public  byte[]  getSyncPosition(String filePath,String fileName) throws IOException {
			Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(URI.create(hdfsUrl), conf);
	
			Path seqPath = new Path(fs.getHomeDirectory(), filePath);
			SequenceFile.Reader reader = new SequenceFile.Reader(fs, seqPath, conf);// 创建实例	
			
			BytesWritable value = new BytesWritable();
			Text key = new Text();
			long position = reader.getPosition();
			byte[] content = null;
			while(reader.next(key,value)){
				position = reader.getPosition();
				reader.sync(position);
				reader.next(key,value);
				String keyStr = key.toString();
				if(keyStr.equals(fileName)){
					content = value.getBytes();
					break;
				}
			}
			return content;
		}		
	
	/**
	 * 按同步点从seq文件中读取图片
	 * @param filePath
	 * @throws IOException
	 */
	public  byte[] readByPosition(String filePath) throws IOException {
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(hdfsUrl), conf);

		Path seqPath = new Path(fs.getHomeDirectory(), filePath);
		SequenceFile.Reader reader = new SequenceFile.Reader(fs, seqPath, conf);// 创建实例	
		
		BytesWritable value = new BytesWritable();
		Text key = new Text();
		
		//TODO 根据fileName查询position
		long position = 1550688;
		
		reader.sync(position);
		reader.next(key,value);
		System.out.println(key + "======" + position);// 打印已读取键值对		
		
		byte[] data = value.get();
		return data;
	}
	
	/**
	 * 将file对象转化为byte数组
	 * @param file
	 * @return
	 */
	private  byte[] getBytes(File file){  
        byte[] buffer = null;  
        try {  
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
            byte[] b = new byte[fis.available()];  
            int n;  
            while ((n = fis.read(b)) != -1) {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return buffer;  
    }
	
	public static void main(String[] args) throws IOException {
		SequencefileHandler s = new SequencefileHandler();
		s.getSyncPosition("/upload/test/sequencefile/20150331204248","20.gif");
	}
}

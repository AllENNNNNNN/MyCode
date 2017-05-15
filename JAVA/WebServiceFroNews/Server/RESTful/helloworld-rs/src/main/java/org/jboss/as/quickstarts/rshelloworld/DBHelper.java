package org.jboss.as.quickstarts.rshelloworld;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;  
  
public class DBHelper {  
    public static final String url = "jdbc:mysql://127.0.0.1/mw2017";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "a280298";  
  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    public DBHelper() {  
        try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
    
    public String Create(String title,String content,String publishTime)
    {
    	String sql="insert into news values(null,'"+title+"','"+content+"','"+publishTime+"')";
    	try {
    		pst=conn.prepareStatement(sql);
			pst.execute();
			return title+"发布成功!\n";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "发布失败!\n";
    
    }
    
    public String delete(String title)
    {
    	
    	String sql="delete from news where title='"+title+"'";
    	try {
			pst=conn.prepareStatement(sql);
			pst.execute();
			return title+"删除成功\n";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "删除失败\n";
    }
    
    public String update(String title,String content)
    {
    	String sql="update news set content='"+content+"' where title='"+title+"'";
    	try {
			pst=conn.prepareStatement(sql);
			pst.execute();
			return title+"更新成功\n";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "更新成功\n";
    }
    
    public String select(String title,String content)
    {
    	String sql="select * from news where title like '%"+title+"%' or content like '%"+content+"%'";
    	
    	String result="";
    	try {
			pst=conn.prepareStatement(sql);
			ResultSet resultSet=pst.executeQuery(sql);
			while(resultSet.next())
			{
				result=result+resultSet.getString("title")+"   "+resultSet.getString("content")+"    "+resultSet.getString("publishTime")+"\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return result;
    }
    
    public String getAll()
    {
    	String sql="select * from news";
    	String result="";
    	try {
			pst=conn.prepareStatement(sql);
			ResultSet resultSet=pst.executeQuery(sql);
			while(resultSet.next())
			{
				result=result+resultSet.getString("title")+"   "+resultSet.getString("content")+"    "+resultSet.getString("publishTime")+"\t\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return result;
    	
    
    }
    
   
}  
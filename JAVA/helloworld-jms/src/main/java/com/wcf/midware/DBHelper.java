package com.wcf.midware;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;  
  
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
    
    public ArrayList<String> getTopic(String client)
    {
    	ArrayList<String> topicList=new ArrayList<String>();
    	String sql="select * from topicTable where client='"+client+"'";
    	try {
			pst=conn.prepareStatement(sql);
			ResultSet result=pst.executeQuery();
			while(result.next())
			{
				topicList.add(result.getString("topic"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return topicList;
    }
    
    public void subscribe(String client,String topic)
    {
    	String sql="select * from topicTable where client='"+client+"' and topic='"+topic+"'";
    	try {
			pst=conn.prepareStatement(sql);
			ResultSet result=pst.executeQuery();
			int i=0;
			while(result.next()) i++;
			if(i==0)
			{
				sql="insert into topicTable values('"+client+"'"+",'"+topic+"')";
				System.out.println(sql);
				pst=conn.prepareStatement(sql);
				pst.execute();
				System.out.println("订阅成功！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void exceSql(String sql)
    {
    	try {
			pst=conn.prepareStatement(sql);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    public boolean hasClient(String s)
    {
    	String sql="select * from topicTable";
    	 try {
			pst = conn.prepareStatement(sql);
			ResultSet result=pst.executeQuery();
			while(result.next())
			{
				//System.out.println(result.getString("client"));
				if(s.equals(result.getString(1)))
				{
					return true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
    	
    }
}  
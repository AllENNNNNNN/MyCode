/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.rshelloworld;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Path("/")
public class HelloWorld {


	DBHelper dh=new DBHelper();
	public HelloWorld() 
	{	

	}


	@GET
	@Produces("text/plain")
	@Path("/select/{key}")
	public String getStudent(@PathParam("key") String key) {
		return this.dh.select(key, key);
	}




	@GET
	@Produces("text/plain")
	@Path("/getAll")
	public String getAllStudent(){

		System.out.println(this.dh.getAll());
		return this.dh.getAll();
	}

	@DELETE
	@Produces("text/plain")
	@Path("/delete/{title}")
	public String delete(@PathParam("title") String title) {
		return this.dh.delete(title);
	}

	@PUT
	@Produces("text/plain")
	@Path("/update")
	public String update(@FormParam("title") String title, 
			@FormParam("content") String content) {
		return this.dh.update(title, content);
	}

	@POST
	@Produces("text/plain")
	@Path("/create")
	public String createStudent(@FormParam("title") String title,
			@FormParam("content") String content) {	

		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String publishTime=time.format(new Date());
		return this.dh.Create(title, content, publishTime);

	}



	public void test()
	{
		String title="newTitle";
		String content="newContent";
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String publishTime=time.format(new Date());
		System.out.println(this.dh.getAll());
		System.out.println(this.dh.Create(title, content, publishTime));
		System.out.println(this.dh.select(title, content));
		System.out.println(this.dh.update(title, content));
		System.out.println(this.dh.delete(title));

	}
}






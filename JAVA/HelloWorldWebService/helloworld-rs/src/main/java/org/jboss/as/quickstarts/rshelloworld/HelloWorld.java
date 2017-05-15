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

import java.util.ArrayList;

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
	
	private static ArrayList<StudentRecord> students = createInitialSutdent();

	public HelloWorld() {	}
	
	private static ArrayList<StudentRecord> createInitialSutdent() {
		ArrayList<StudentRecord> s = new ArrayList<StudentRecord>();
		s.add(new StudentRecord("007", "Lai"));
		s.add(new StudentRecord("001", "John"));
		return s;
	}
	
	@GET
	@Produces("text/plain")
	@Path("/get/{id:\\d+}")
	public String getStudent(@PathParam("id") String id) {
		StudentRecord s = find(id);
		if (s == null)
			return "No record found!";
		return s.toString();
	}
	
	@GET
	@Produces("text/plain")
	@Path("/getAll")
	public String getAllStudent(){
		String result = "";
		for (StudentRecord s : students){
			result += s.toString();
			result += ";";
		}
		result+="汤凯好！";
		return result;	
	}
	
	@DELETE
	@Produces("text/plain")
	@Path("/delete/{id:\\d+}")
	public String delete(@PathParam("id") String id) {
		if (id == null)
			return "No ID is given: nothing to edit.\n";
		StudentRecord s = find(id);
		if (s == null) {
			return "There is no Student with ID " + id + "\n";
		}
		students.remove(s);//remove
		return "Student " + id + " has been removed.\n";
	}
	
	@PUT
	@Produces("text/plain")
	@Path("/update")
	public String update(@QueryParam("id") String id, 
                         @QueryParam("name") String name) {
		if (id == null && name == null)
			return "Neither who nor what is given: nothing to edit.\n";
		StudentRecord s = find(id);
		if (s == null) {
			return "There is no Student with ID " + id + "\n";
		}
		// Update.
		s.setId(id);
		s.setName(name);
		return "Student " + id + " has been updated.\n";
	}
	
	@POST
	@Path("/create")
	@Produces("text/plain")
	public String createStudent(@FormParam("id") String id,
                               @FormParam("name") String name) {	
		StudentRecord s = find(id);
		if (s != null) {
			return "Duplicate Id:" + id + "\n";
		} else {
			StudentRecord sr = new StudentRecord(id, name);
			students.add(sr);
			return "Student is added to Server: " + sr + "\n";
		}
	}
	
	private StudentRecord find(String id) {		
		for (StudentRecord s : students) {
			if (s.getId().equals(id))
				return s;
		}
		return null;
	}

}






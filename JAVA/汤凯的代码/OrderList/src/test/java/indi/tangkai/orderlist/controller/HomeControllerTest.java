package indi.tangkai.orderlist.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import indi.tangkai.orderlist.controller.OrderListController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class HomeControllerTest 
{
	@Test
	public void testHomePage() throws Exception
	{
		OrderListController controller=new OrderListController();
		MockMvc mockMvc=standaloneSetup(controller).build();
		
		mockMvc.perform(get("/"))
		.andExpect(view().name("home"));
	}
}

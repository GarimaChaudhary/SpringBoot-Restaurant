package com.example.demo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class RestaurantControllerTests {

	 private MockMvc mockMvc;

	    @Before
	    public void setup() {
	        this.mockMvc = MockMvcBuilders.standaloneSetup(new RestaurantController()).build();
	    }

	    @Test
	    public void testSayHelloWorld() throws Exception {
	        this.mockMvc.perform(post("/api/v1/restaurant").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType("application/json"));

	    }
	
	
	
	
	
//	@InjectMocks
//	private RestaurantController restaurantController;
//	@Mock
//	RestaurantServiceImpl restaurantService;
//	private  MockMvc mockMvc;
//	
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
////		restaurantController = new RestaurantController();
////		restaurantController.setRestaurantService(restaurantService);
//		mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
//	}
//	
//	@Test
//	public void testSearchById() throws Exception {
//
//		int id = 1;
////		Restaurant first = new Restaurant();
////		first.setRestaurantId(1);
////		first.setRestaurantName("Truffles");
////		first.setRestaurantLoc("Koramangala");
////		first.setCostOfTwo(new BigDecimal(2000));
//
////		when(restaurantService.searchById(id)).thenReturn(first);
//		mockMvc.perform(
//				get("/api/v1/restaurant"+id))
//		.andExpect(MockMvcResultMatchers.status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("data.restaurantName", is("Truffles")))
//		.andExpect(jsonPath("data.restaurantLoc", is("Koramangala")))
//		.andExpect(jsonPath("data.restaurantId", is(id)))
//		.andExpect(jsonPath("data.costOfTwo", is(2000)));
////		.andExpect(jsonPath("success", is(true)));
//		
////		verify(restaurantService, times(1)).searchById(id);
//	}

	
//	@Test
//	public void findAll_ShouldReturnListofRestaurants() throws Exception {
//		Restaurant first = new Restaurant();
//		first.setRestaurantId(1);
//		first.setRestaurantName("Truffles");
//		first.setRestaurantLoc("Koramangala");
//		first.setCostOfTwo(new BigDecimal(2000));
//
//		Restaurant second = new Restaurant();
//		second.setRestaurantId(1);
//		second.setRestaurantName("Truffles");
//		second.setRestaurantLoc("Koramangala");
//		second.setCostOfTwo(new BigDecimal(2000));
//
//
//		when(restaurantService.findAll()).thenReturn(Arrays.asList(first, second));
//
//		mockMvc.perform(get("/api/v1/restaurant"))
//		.andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$", hasSize(2)))
//		.andExpect(jsonPath("$[0].id", is(1)))
//		.andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
//		.andExpect(jsonPath("$[0].title", is("Foo")))
//		.andExpect(jsonPath("$[1].id", is(2)))
//		.andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
//		.andExpect(jsonPath("$[1].title", is("Bar")));
//
//		verify(todoServiceMock, times(1)).findAll();
//		verifyNoMoreInteractions(todoServiceMock);
//
//	}

	
}


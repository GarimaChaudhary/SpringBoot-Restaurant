package com.example.demo.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.demo.domain.Restaurant;
import com.example.demo.repository.RestaurantRepository;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceImplTests {

	private RestaurantServiceImpl restaurantServiceImpl;
	@Mock
	RestaurantRepository restaurantRepository;
	@Mock
	Restaurant restaurant;
	@Mock
	List<Restaurant> restaurants;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		restaurantServiceImpl = new RestaurantServiceImpl();
		restaurantServiceImpl.setRestaurantRepository(restaurantRepository);
	}
	
	@Test
    public void shouldReturnRestaurant_whenaddRestaurantIsCalled() throws Exception {
        // Arrange
        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
        // Act
        Restaurant savedRestaurant = restaurantServiceImpl.addRestaurant(restaurant);
        // Assert
        assertThat(savedRestaurant, is(equalTo(restaurant)));
    }
	
	@Test
    public void shouldReturnRestaurant_whensearchByIdIsCalled() throws Exception {
        // Arrange
        when(restaurantRepository.findOne(1)).thenReturn(restaurant);
        // Act
        Restaurant retrievedRestaurant = restaurantServiceImpl.searchById(1);
        // Assert
        assertThat(retrievedRestaurant, is(equalTo(restaurant)));
 
    }
	
	@Test
    public void shouldReturnRestaurant_whensearchByNameIsCalled() throws Exception {
        // Arrange
        when(restaurantRepository.findByRestaurantName("Social")).thenReturn(restaurant);
        // Act
        Restaurant retrievedRestaurant = restaurantServiceImpl.searchByName("Social");
        // Assert
        assertThat(retrievedRestaurant, is(equalTo(restaurant)));
 
    }
	
	@Test
    public void shouldReturnListOfRestaurants_whenfindAllIsCalled() throws Exception {
        // Arrange
        when(restaurantRepository.findAll()).thenReturn(restaurants);
        // Act
        List<Restaurant> retrievedRestaurants = restaurantServiceImpl.findAll();
        // Assert
        assertThat(retrievedRestaurants, is(equalTo(restaurants)));
 
    }
	
    @Test
    public void shouldCallDeleteMethodOfRestaurantRepository_whenDeleteRestaurantIsCalled() throws Exception {
        // Arrange
        doNothing().when(restaurantRepository).delete(1);
        // Act
        restaurantServiceImpl.deleteRestaurant(1);
        // Assert
        verify(restaurantRepository, times(1)).delete(1);
    }
	
}

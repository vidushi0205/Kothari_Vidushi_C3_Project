import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE
    
    @BeforeEach
    public void setUp() {
    	LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }
    
    @Test
    public void get_total_order_value_in_case_particular_items_checked() {
    	List<Item> restMenuList = restaurant.getMenu();
    	assertEquals(388,restaurant.getTotalOrderValue(restMenuList));
    }

    @Test
    public void total_order_value_should_reduce_when_particular_item_removed() {
    	List<Item> restMenuList = restaurant.getMenu();
    	int totalOrder = restaurant.getTotalOrderValue(restMenuList);
    	int totalOrderValueAfterItemRemoval = restMenuList.get(1).getPrice();
    	restMenuList.remove(1);
    	assertEquals(totalOrder - totalOrderValueAfterItemRemoval,restaurant.getTotalOrderValue(restMenuList));
    }
    

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
    	restaurant.setClosingTime(LocalTime.now().plusMinutes(10));
        restaurant.setOpeningTime(LocalTime.now().minusMinutes(10));
        assertTrue(restaurant.isRestaurantOpen());
        //WRITE UNIT TEST CASE HERE
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
    	restaurant.setClosingTime(LocalTime.now().minusMinutes(10));
        assertFalse(restaurant.isRestaurantOpen());
        //WRITE UNIT TEST CASE HERE

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}
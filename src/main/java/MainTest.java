import java.time.LocalTime;

public class MainTest {
	
	// This is a Main Tester Class 
	
		public static void main(String[] args) throws restaurantNotFoundException {
			
			LocalTime openingTime = LocalTime.parse("10:30:00");
	        LocalTime closingTime = LocalTime.parse("22:00:00");
	        Restaurant restValue = new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
	        restValue.addToMenu("Sweet corn soup",119);
	        restValue.addToMenu("Vegetable lasagne", 269);
	        RestaurantService restaurantServiceObj = new RestaurantService();
	        Restaurant restaurantAdded = restaurantServiceObj.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
	        restaurantAdded.addToMenu("Sweet corn soup",119);
	        restaurantAdded.addToMenu("Vegetable lasagne", 269);
	        System.out.println(restValue.getMenu());
	        System.out.println(restValue.isRestaurantOpen());
	        System.out.println(restaurantServiceObj.findRestaurantByName("Amelie's cafe"));
	        System.out.println(restaurantServiceObj.findRestaurantByName("Amelie cafe"));

			
		}

}

package code.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Programs {
	String[][] groupingDishes(String[][] dishes) {
	    if(dishes == null){
	        return null;
	    }
		Map<String, List<String>> ingredientsMap = new TreeMap();
	    for(String[] dishArray: dishes){
	        if(dishArray.length == 0){
	            continue;
	        }
	        //reading ingredient
	        for(int i = 1;i < dishArray.length;i++){
	            if(!ingredientsMap.containsKey(dishArray[i])){
	                ingredientsMap.put(dishArray[i], new ArrayList());
	            }
	            ingredientsMap.get(dishArray[i]).add(dishArray[0]);
	        }
	    }
	    TreeSet<String> ingredientsReducedSet = new TreeSet();
//	    Set<String>ingredientsSet = ingredientsMap.keySet();
	    for(String ingredient : ingredientsMap.keySet()){
	        if(ingredientsMap.get(ingredient).size() >= 2){
	            ingredientsReducedSet.add(ingredient);
	        }
	       
		}

	    String[][] ret = new String[ingredientsReducedSet.size()][];
	    int i = 0;
	    for(String ingredient : ingredientsReducedSet){
	       
	        ret[i] = new String[ingredientsMap.get(ingredient).size()+1];
	        //ingredient name
	        ret[i][0] = ingredient;
	        int j = 1;
	        for(String dish: ingredientsMap.get(ingredient)){
	            ret[i][j++] = dish;
	        }
	        i++;
		}
	    
	    return ret;
	    
	}
	boolean areFollowingPatterns(String[] strings, String[] patterns) {
		
	    List<String> stringList = new ArrayList();
	    List<String> patternList = new ArrayList();
	    for(int i = 0;i< strings.length;i++){
	        // lastindex of both must be equal
	        int prevSIndex = stringList.lastIndexOf(strings[i]);
	        int prevPIndex = patternList.lastIndexOf(patterns[i]);
	        if(prevSIndex == -1 &&  prevPIndex != -1){
	            return false;
	        }else if(prevSIndex != -1 && patterns[prevSIndex] != patterns[i]){
	            return false;
	        }
	        stringList.add(strings[i]);
	        patternList.add(patterns[i]);
	        
	    }
	    return true;
	}



	public static void main(String[] args) {
		Programs p = new Programs();
//		String[][] dishes = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
//		                     {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
//		                     {"Quesadilla", "Chicken", "Cheese", "Sauce"},
//		                     {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};
//		System.out.println(dishes);
//		String[][] ingredients = p.groupingDishes(dishes);
//		System.out.println(Arrays.asList(ingredients));
//		String[] strings= {"cat", 
//		          "dog", 
//		          "dog"};
//		String[] patterns = {"a", 
//		          "b", 
//		          "b"};
		String[] strings = {"re", 
		          "jjinh", 
		          "rnz", 
		          "frok", 
		          "frok", 
		          "hxytef", 
		          "hxytef", 
		          "frok"};
		String[]  patterns = {"kzfzmjwe", 
		          "fgbugiomo", 
		          "ocuijka", 
		          "gafdrts", 
		          "gafdrts", 
		          "ebdva", 
		          "ebdva", 
		          "gafdrts"};
		
		System.out.println(p.areFollowingPatterns(strings, patterns));
	}
	

}

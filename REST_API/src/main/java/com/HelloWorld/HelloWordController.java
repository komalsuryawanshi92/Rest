package com.HelloWorld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWordController {
@PostMapping(value="/getUserDetails")	
public Map<String,Object>  hello(@RequestBody Map<String,Object>reqMap) {
	Map<String,Object> returnMap = new HashMap<String, Object>();
	try {
		List<Object> inputArray =  (List<Object>) reqMap.get("input");
		returnMap.put("status", true);
		returnMap.put("user_id", "Komal_suryawanshi_28091992");
		returnMap.put("email", "komalsuryawanshi111@gmail.com");
		returnMap.put("roll_no", "210947820052");
		List<Integer> numbers = getNumbersFromarray(inputArray);
		List<String> alphabates = getStringFromArray(inputArray);
		returnMap.put("numbers",numbers);
		returnMap.put("alphabates",alphabates);
	}
	catch (Exception e) {
		returnMap.put("status", false);
		returnMap.put("user_id", "Komal_suryawanshi_28091992");
		returnMap.put("email", "komalsuryawanshi111@gmail.com");
		returnMap.put("roll_no", "210947820052");
		returnMap.put("numbers","");
		returnMap.put("alphabates","");
	}
	return returnMap;

}

private List<String> getStringFromArray(List<Object> inputArray) {
	List<String> alphabates = new ArrayList<String>();
	for(Object element : inputArray) {
		if(element instanceof String)
			alphabates.add((String) element);
	}
	return alphabates;
}

private List<Integer> getNumbersFromarray(List<Object> inputArray) {
	List<Integer> numbers = new ArrayList<Integer>();
	for(Object element : inputArray) {
		if(element instanceof Integer)
			numbers.add((Integer) element);
	}
	return numbers;
}

}

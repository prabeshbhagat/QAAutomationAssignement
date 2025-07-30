package practice.qa.selenium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class employee {
	
	
	private int id;
	private String name;
	private String email;
	private int phone;
	
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	@Builder
	public static class address {
		private String street;
		private String city;
		private int zipcode;
	}

}

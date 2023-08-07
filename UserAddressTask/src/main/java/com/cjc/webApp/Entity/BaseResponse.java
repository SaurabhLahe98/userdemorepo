package com.cjc.webApp.Entity;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
	
	private int responseStatus;
	private String responsemsg;
	private Date responsedate;
	private T responseData;


}

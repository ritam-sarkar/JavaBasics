package com.riversand.structural.bridge;

import java.util.List;

public class PrintFormatter implements Formatter {

	@Override
	public String format(String header, List<Detail> details) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(header);
		strBuilder.append("\n");
		if(details != null && !details.isEmpty()) {
			for(Detail detail : details) {
				strBuilder.append(detail.getLabel()+" : "+detail.getValue());
			}
		}
		
		return strBuilder.toString();
	}

}

package org.bysj.pleural.dto.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class BestSvmParamsDTO {
	private double acc;
	private int index;
	private double c;
	private double g;
}

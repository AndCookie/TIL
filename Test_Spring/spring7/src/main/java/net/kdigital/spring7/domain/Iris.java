package net.kdigital.spring7.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Iris {
	private double petalLength;
	private double petalWidth;
	private double sepalLength;
	private double sepalWidth;
}
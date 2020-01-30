package com.accolite.testor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.inOrder;

import com.accolite.calculator.CalculatorImplementation;
import com.accolite.calculator.CalculatorInterface;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class Testor {
	
	@InjectMocks
	CalculatorImplementation testor=new CalculatorImplementation();

	@Mock
	CalculatorInterface impl;
	
	@Test
	public void testCalculator() {
		Mockito.when(impl.add(2.0, 3.0)).thenReturn(5.0);
		Mockito.when(impl.multiply(2.0, 3.0)).thenReturn(6.0);
		Mockito.when(impl.subtract(2.0, 3.0)).thenReturn(-1.0);
		Mockito.when(impl.divide(4.0,2.0)).thenReturn(2.0);
		
		Assert.assertEquals(testor.add(2.0,3.0), 5.0,0);
		Assert.assertEquals(testor.multiply(2.0,3.0), 6.0,0);
		Assert.assertEquals(testor.subtract(2.0,3.0), -1.0,0);
		Assert.assertEquals(testor.divide(4.0,2.0), 2.0,0);
		
		
	}

	
}

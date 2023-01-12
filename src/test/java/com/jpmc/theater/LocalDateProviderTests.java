package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;

public class LocalDateProviderTests {
    @Test
    void testCurrentDate() {
        System.out.println("Current Date is - " + LocalDateProvider.singleton().currentDate());
    }
    
    @Test
    void testSingleton() {
    	LocalDateProvider instance1 = LocalDateProvider.singleton();
    	LocalDateProvider instance2 = LocalDateProvider.singleton();
    	
    	assertSame(instance1,instance2);//Only 1 instance created
    }
    
    @Test
    void testReflection() {
    	LocalDateProvider instance1 = LocalDateProvider.singleton();
    	LocalDateProvider instance2 = null;
        try {
            Constructor[] constructors  = LocalDateProvider.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instance2  = (LocalDateProvider)constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        assertNull(instance2);//Cannot create via reflection
    }
    
    @Test
    void testClone() {
    	LocalDateProvider instance1 = LocalDateProvider.singleton();
    	LocalDateProvider instance2 = null;
    	try {
    		instance2 = (LocalDateProvider) instance1.clone();
    	} catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        assertNull(instance2);//Cannot clone    	
    }
}

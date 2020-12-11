package org.apache.openjpa.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.openjpa.util.entity.ProxiesEntity;
import org.apache.openjpa.util.support.NonValid;
import org.apache.openjpa.util.support.Valid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ProxiesTest {
	
	private ProxiesEntity entity;
	private Object expectedResult;
	private Proxies proxies;


	public ProxiesTest(ProxiesEntity entity, Object expectedResult) {
		this.entity = entity;
    	this.expectedResult = expectedResult;
	}
	
	
	@Parameterized.Parameters
    public static Collection<?> getParameters(){
		
		/*CATEGORY PARTITION:
		 * Proxy --> {Valid, NonValid, Null}
		 * detachable --> {True, False}
		 * 
		 * 
		 * writeReplace(new DelayedArrayListProxy(int>0), true) --> DelayedArrayListProxy
		 * writeReplace(new NonProxy(), false) -->?
		 * writeReplace(null, false) --> null
		 * */
		
		
		ProxiesEntity validProxy = new ProxiesEntity(true);
		//ProxiesEntity NonValidProxy = new ProxiesEntity();
		ProxiesEntity nullProxy = new ProxiesEntity(false);
		//ProxiesEntity proxiesEntity = new ProxiesEntity(,false)
		ProxiesEntity setOwnerEntity = new ProxiesEntity(true);
		
		 return Arrays.asList(new Object[][] {
			 
			 
			//Suite minimale
			 {validProxy.initializeValidProxy(1), validProxy.getObject()},
			 //{NonValidProxy.initializeNonValidProxy(), },
			 {nullProxy.initializeNullProxy(), null},
			 {new ProxiesEntity(new DelayedArrayListProxy(), false), new ArrayList<>()},
			 {setOwnerEntity.initializeSetOwnerEntity(1), null},
			 
			 //code coverage
			 
	        	
	    	});
		
	}
	
	@Before
    public void setUp(){
        this.proxies = new Proxies();
    }
	
	@Test
    public void writeReplaceTest() {
    	
    	Object result = null;
    	result = Proxies.writeReplace((Proxy) entity.getObject(), entity.isDetachable());
    	//System.out.println(result.getClass());
    	Assert.assertEquals(this.expectedResult, result);
        
    	
        

    }
	
	public static void main(String[] args) {
		Proxies proxies;
		Object obj;
		DelayedArrayListProxy delayedArrayListProxy = new DelayedArrayListProxy();
		obj = Proxies.writeReplace(new DelayedArrayListProxy(), false);
		System.out.println(obj.getClass());
	}
	
	
}

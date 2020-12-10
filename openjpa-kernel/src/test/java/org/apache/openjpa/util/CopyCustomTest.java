package org.apache.openjpa.util;

import org.apache.openjpa.util.entity.ProxyManagerImplEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;


@RunWith(Parameterized.class)
public class CopyCustomTest {

    private ProxyManagerImpl proxyManager;
    private ProxyManagerImplEntity entity;
    private Object expectedResult;

    public CopyCustomTest(ProxyManagerImplEntity entity, Object expectedResult) {
        this.entity = entity;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<?> getParameters(){
    	
    	
    	
        Random r = new Random();
        //List<TestInput> testInputs = new ArrayList<>();
        /*ProxyManagerImplEntity entityNull = new ProxyManagerImplEntity(obj);
        ProxyManagerImplEntity entityNonBean = new ProxyManagerImplEntity(r.nextInt(), r.nextInt());
        ProxyManagerImplEntity entityBean = new ProxyManagerImplEntity(r.nextInt());
        ProxyManagerImplEntity entityMap = new ProxyManagerImplEntity(r.nextInt(), r.nextInt(), r.nextInt(), r.nextInt());
        ProxyManagerImplEntity entityDate = new ProxyManagerImplEntity(new Date());
        ProxyManagerImplEntity entityGregorian = new ProxyManagerImplEntity(new GregorianCalendar());
        ProxyManagerImplEntity entityProxyDate = new ProxyManagerImplEntity(new ProxyManagerImpl().newDateProxy(Date.class));
        ProxyManagerImplEntity entityList = new ProxyManagerImplEntity(r.nextInt(), r.nextInt(), r.nextInt());*/
        
        
        ProxyManagerImplEntity entityNull = new ProxyManagerImplEntity();
        ProxyManagerImplEntity entityNonValid = new ProxyManagerImplEntity();
        ProxyManagerImplEntity entityDate = new ProxyManagerImplEntity();
        
        
        ProxyManagerImplEntity entityValid = new ProxyManagerImplEntity();
        ProxyManagerImplEntity entityMap = new ProxyManagerImplEntity();
        ProxyManagerImplEntity entityGregorian = new ProxyManagerImplEntity();
        ProxyManagerImplEntity entityProxyDate = new ProxyManagerImplEntity();
        ProxyManagerImplEntity entityList = new ProxyManagerImplEntity();
        ProxyManagerImplEntity entityManageable = new ProxyManagerImplEntity();
        
        
        //BeanClass beanClass = new BeanClass();
        //beanClass.setValue(r.nextInt());
        //testInputs.add(new TestInput(beanClass, false), beanClass);

        //Map<Integer, Integer> map = new HashMap<>();
        //map.put(r.nextInt(), r.nextInt());
        //map.put(r.nextInt(), r.nextInt());
        //map.put(r.nextInt(), r.nextInt());

        

        

        //Proxy proxy = new ProxyManagerImpl().newDateProxy(Date.class);
        

        //List<Integer> list = new ArrayList<>();

        //list.add(r.nextInt());
        //list.add(r.nextInt());
        //list.add(r.nextInt());




        return Arrays.asList(new Object[][] {
    		
        	//Suite minimale
        	{entityNull.initializeEntityNull(null), null},
            {entityNonValid.initializeEntityNonValid(r.nextInt(), r.nextInt()), null}, 
            {entityDate.initializeEntityDate(new Date()), entityDate.getObject()},

            //line, branch and mutation coverage
            {entityManageable.initializeEntityManageable(), null},
            {entityValid.initializeEntityValid(r.nextInt(), true), entityValid.getObject()}, 
            {entityMap.initializeEntityMap(r.nextInt(), r.nextInt(), false), entityMap.getObject()},
            {entityGregorian.initializeEntityGregorian(new GregorianCalendar()), entityGregorian.getObject()},
            {entityProxyDate.initializeEntityProxyDate(new ProxyManagerImpl().newDateProxy(Date.class)), entityProxyDate.getObject()},
            {entityList.initializeEntityList(r.nextInt()), entityList.getObject()}
    	});

    }

    

    @Before
    public void setUp(){
        this.proxyManager = new ProxyManagerImpl();
    }

    @Test
    public void copyCustomTest() {
        Object result = this.proxyManager.copyCustom(this.entity.getObject());

       
        Assert.assertEquals(this.expectedResult, result);
      

    }
    
    public static void main(String[] args) {
        /*ProxyManagerImplEntity proxyEntity = new ProxyManagerImplEntity();
        ProxyManagerImplEntity proxyEntity1= new ProxyManagerImplEntity();
        System.out.println(proxyEntity.createInt(5));
        System.out.println(proxyEntity.createString("ciao"));
        System.out.println(proxyEntity1.createInt(5));
        System.out.println(proxyEntity1.createString("ciao"));*/

	}

}

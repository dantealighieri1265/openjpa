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

        Object obj = new Object();
        obj=null;
        ProxyManagerImplEntity entityNull = new ProxyManagerImplEntity(obj);
        ProxyManagerImplEntity entityNonBean = new ProxyManagerImplEntity(r.nextInt(), r.nextInt());
        ProxyManagerImplEntity entityBean = new ProxyManagerImplEntity(r.nextInt());
        ProxyManagerImplEntity entityMap = new ProxyManagerImplEntity(r.nextInt(), r.nextInt(), r.nextInt(), r.nextInt());
        ProxyManagerImplEntity entityDate = new ProxyManagerImplEntity(new Date());
        ProxyManagerImplEntity entityGregorian = new ProxyManagerImplEntity(new GregorianCalendar());
        ProxyManagerImplEntity entityProxyDate = new ProxyManagerImplEntity(new ProxyManagerImpl().newDateProxy(Date.class));
        ProxyManagerImplEntity entityList = new ProxyManagerImplEntity(r.nextInt(), r.nextInt(), r.nextInt());
        
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
    		
        	{entityNull , null},
            {entityNonBean, null}, // non bean per ul branch coverage ultimo statement
            {entityBean, entityBean.getObject()}, //bean per il branch coverage per l'ultimo statement
            {entityMap, entityMap.getObject()},
            {entityDate, entityDate.getObject()},
            {entityGregorian, entityGregorian.getObject()},
            {entityProxyDate, entityProxyDate.getObject()},
            {entityList, entityList.getObject()}//Collection
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

}

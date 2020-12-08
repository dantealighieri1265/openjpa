package org.apache.openjpa.util;

import org.apache.openjpa.util.entity.ProxyManagerImplEntity;
import org.apache.openjpa.util.support.Valid;
import org.apache.openjpa.util.support.FinalClass;
import org.apache.openjpa.util.support.NonValid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Timestamp;
import java.util.*;

@RunWith(Parameterized.class)
public class NewCustomProxyTest {

    //private ProxyManagerImpl proxyManager;
    private Object object;
    /*private boolean autoOff;
    private String unproxyable;
    private boolean resultNull;*/
    private ProxyManagerImpl proxyManager;
    private ProxyManagerImplEntity entity;
    private Object expectedResult;

    /*public NewCustomProxyTest(TestInput testInput) {
        this.object = testInput.getObject();
        this.autoOff = testInput.isAutoOff();
        this.unproxyable = testInput.getUnproxyable();
        this.resultNull = testInput.isResultNull();
    }*/
    
    public NewCustomProxyTest(ProxyManagerImplEntity entity, Object expectedResult) {
        this.entity = entity;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<?> getParameters(){
        Random r = new Random();
        //List<TestInput> testInputs = new ArrayList<>();
        
        
        ProxyManagerImplEntity entityNull = new ProxyManagerImplEntity(true);
        ProxyManagerImplEntity entityNonValid = new ProxyManagerImplEntity(false);
        ProxyManagerImplEntity entityFinal = new ProxyManagerImplEntity(true);
        ProxyManagerImplEntity entityValid = new ProxyManagerImplEntity(true);
        ProxyManagerImplEntity entityMap = new ProxyManagerImplEntity(true);
        ProxyManagerImplEntity entitySortedMap = new ProxyManagerImplEntity(true);
        ProxyManagerImplEntity entitySortedSet = new ProxyManagerImplEntity(false);
        ProxyManagerImplEntity entityDate = new ProxyManagerImplEntity(false);
        ProxyManagerImplEntity entityGregorian = new ProxyManagerImplEntity(false);
        ProxyManagerImplEntity entityProxyDate = new ProxyManagerImplEntity(true);
        ProxyManagerImplEntity entityList = new ProxyManagerImplEntity(true);//TODO: vedi se è una lista o array
        ProxyManagerImplEntity entityTimestamp = new ProxyManagerImplEntity(false);
        
        /*TODO: RICORDATI DI SETTARE LA VARIABILE STRINGA UNPROXYBLE*/
        ProxyManagerImplEntity entityUnproxyable = new ProxyManagerImplEntity(false);
        
        boolean sortedMap = true;
        boolean notSortedMap = false;
        boolean proxyable = true;
        boolean unproxyable = false;
        
        /*testInputs.add(new TestInput(null, true, true));
        testInputs.add(new TestInput(new NonBeanClass(r.nextInt(), r.nextInt()), false, true));
        testInputs.add(new TestInput(new FinalClass(), true, true));

        BeanClass beanClass = new BeanClass();
        beanClass.setValue(r.nextInt());
        testInputs.add(new TestInput(beanClass, true,false));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(r.nextInt(), r.nextInt());
        map.put(r.nextInt(), r.nextInt());
        map.put(r.nextInt(), r.nextInt());

        testInputs.add(new TestInput(map, true, false));

        Map<Integer, Integer> sortedMap = new TreeMap<>();
        sortedMap.put(r.nextInt(), r.nextInt());
        sortedMap.put(r.nextInt(), r.nextInt());
        sortedMap.put(r.nextInt(), r.nextInt());

        testInputs.add(new TestInput(sortedMap, true, false));

        Set<Integer> sortedSet = new TreeSet<>(); //1 tra set e list forse ridondante
        sortedSet.add(r.nextInt());
        sortedSet.add(r.nextInt());
        sortedSet.add(r.nextInt());

        testInputs.add(new TestInput(sortedSet, false, false));

        testInputs.add(new TestInput(new Date(), false, false));

        testInputs.add(new TestInput(new GregorianCalendar(), false, false));

        Proxy proxy = new ProxyManagerImpl().newDateProxy(Date.class);
        testInputs.add(new TestInput(proxy, true, false));

        List<Integer> list = new ArrayList<>();

        list.add(r.nextInt());
        list.add(r.nextInt());
        list.add(r.nextInt());

        testInputs.add(new TestInput(list, true, false));
        testInputs.add(new TestInput(new Timestamp(System.currentTimeMillis()), false, false));

        
        BeanClass unproxyableClass = new BeanClass();
        unproxyableClass.setValue(r.nextInt());
        testInputs.add(new TestInput(unproxyableClass, false, BeanClass.class.getName(),true));*/


        return Arrays.asList(new Object[][] {
    		
        	{entityNull.initializeEntityNull(null), null},
            {entityNonValid.initializeEntityNonValid(r.nextInt(), r.nextInt()), null},// non bean per ul branch coverage ultimo statement
            {entityFinal.initializeEntityFinal(), null},
            {entityValid.initializeEntityValid(r.nextInt(), proxyable), entityValid.getObject()}, //bean per il branch coverage per l'ultimo statement
            {entityMap.initializeEntityMap(r.nextInt(), r.nextInt(), notSortedMap), entityMap.getObject()},
            {entitySortedMap.initializeEntityMap(r.nextInt(), r.nextInt(), sortedMap), entitySortedMap.getObject()},
            {entitySortedSet.initializeSortedSet(r.nextInt()), entitySortedSet.getObject()},
            {entityDate.initializeEntityDate(new Date()), entityDate.getObject()},
            {entityGregorian.initializeEntityGregorian(new GregorianCalendar()), entityGregorian.getObject()},
            {entityProxyDate.initializeEntityProxyDate(new ProxyManagerImpl().newDateProxy(Date.class)), entityProxyDate.getObject()},
            {entityList.initializeEntityList(r.nextInt()), entityList.getObject()},
            {entityTimestamp.initializeEntityTimestamp(new Timestamp(System.currentTimeMillis())), entityTimestamp.getObject()},
            /*In realtà questo non so a cosa serva. Non mi aumenta ne la coverage nè la branch. Forse
            * è utile per la mutation*/
            {entityUnproxyable.initializeEntityValid(r.nextInt(), unproxyable), null},
    	});

    }

    /*private static class TestInput {
        private Object object;
        private boolean autoOff;
        private String unproxyable;
        private boolean resultNull;

        public TestInput(Object object, boolean autoOff, boolean resultNull) {
            this.object = object;
            this.autoOff = autoOff;
            this.unproxyable = "";
            this.resultNull = resultNull;

        }

        public TestInput(Object object, boolean autoOff, String unproxyable,boolean resultNull) {
            this(object, autoOff, resultNull);
            this.unproxyable = unproxyable;
        }

        public Object getObject() {
            return object;
        }

        public boolean isAutoOff() {
            return autoOff;
        }

        public String getUnproxyable() {
            return unproxyable;
        }

        public boolean isResultNull() {
            return resultNull;
        }
    }*/

    @Before
    public void setUp(){
        this.proxyManager = new ProxyManagerImpl();
        this.proxyManager.setUnproxyable(this.entity.getUnproxyable());
    }

    @Test
    public void newCustomProxyTest() {
        Object result = this.proxyManager.newCustomProxy(this.entity.getObject(), this.entity.isAutoOff());

        /*if (this.resultNull) {
            Assert.assertNull(result);
        } else {
            Assert.assertEquals(this.object, result);
        }*/
        
        Assert.assertEquals(this.expectedResult, result);

    }
    
    public static void main(String[] args) {
    	Valid unproxyableClass = new Valid();
		System.out.println(Valid.class.getName());
	}

}

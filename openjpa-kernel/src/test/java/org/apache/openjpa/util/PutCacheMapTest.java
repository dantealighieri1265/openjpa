package org.apache.openjpa.util;

import org.apache.openjpa.util.entity.CacheMapEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.security.auth.kerberos.KerberosKey;

import static org.mockito.Mockito.*;
/*
CacheMap maintains
a fixed number of cache entries, and an
optional soft reference map for entries
that are moved out of the LRU space. So,
for applications that have a monotonically
increasing number of distinct queries, this
option can be used to ensure that a fixed
amount of memory is used by the cache.
*/

@RunWith(Parameterized.class)
public class PutCacheMapTest {
	
//    private Object value;
      //private Object previousValue;
	  private CacheMap cacheMap;
	  private Object expectedResult;
//    private boolean hasPreviousValue;
//    private boolean pinned;
//    private Integer cachedMaxMapSize;
//    private Integer numObjectToInsert;
      private CacheMapEntity entity;

    //@Rule
    //public MockitoRule mockitoRule = MockitoJUnit.rule();


    public PutCacheMapTest(CacheMapEntity entity, Object expectedResult) { //, Object expectedResult
    	this.entity = entity;
    	this.expectedResult = expectedResult;

//        this.key = testInput.getKey();
//        this.value = testInput.getValue();
//        this.hasPreviousValue = testInput.isAlreadyExist();
//        this.pinned = testInput.isPinned();
//        this.cachedMaxMapSize = testInput.getCacheMaxMapSize();
//        this.numObjectToInsert = testInput.getNumObjectToInsert();
        /*if (entity.isAlreadyExist()) {
            this.previousValue = new Object();
        } else {
            this.previousValue = null;
        }*/
    }


    @Parameterized.Parameters
    public static Collection<?> getParameters(){
    	 return Arrays.asList(new Object[][] {
    		 //suite minimale
    		 {new CacheMapEntity(null, null, false, false, 0, 1), null},
    		 {new CacheMapEntity(new Object(), null, true, true, 1, 2), new Object()},//new object()
    		 {new CacheMapEntity(null, new Object(), true, false, 1, 1), new Object()},//new object()
    		 {new CacheMapEntity(new Object(), new Object(), false, true, 1, 1), null},
    		 
    		 //coverage
    		 {new CacheMapEntity(new Object(), new Object(), true, false, 2,0), new Object()}
             //{new WriteTestEntity(0, -1), null},
             //{new WriteTestEntity(-1, 0), null}
         });
        //List<CacheMapEntity> testInputs = new ArrayList<>();
//      Object[][] matrix = new Object[5][2];
//      matrix[0][0] = new CacheMapEntity(null, null, false, false, 0, 1);
//      matrix[0][1] = null;
//      return Arrays.asList(matrix);
        
        //suite minimale
        //implementa l'expected results
/*        testInputs.add(new CacheMapEntity(null, null, false, false, 0, 1)); //null
        testInputs.add(new CacheMapEntity(new Object(), null, true, true, 1, 2)); //null
        testInputs.add(new CacheMapEntity(null, new Object(), true, false, 1, 1)); //null
        testInputs.add(new CacheMapEntity(new Object(), new Object(), false, true, 1, 1)); //null
        
        //coverage
        testInputs.add(new CacheMapEntity(new Object(), new Object(), true, false, 2,0)); //Object*/
        
//        testInputs.add(new CacheMapEntity(new Object(), new Object(), true, false, 2, 1));
//        testInputs.add(new CacheMapEntity(new Object(), new Object(), true, true, 1, 1));
        

    }

    @Before
    public void setUp(){
        this.cacheMap = new CacheMap(true, entity.getCacheMaxMapSize(), entity.getCacheMaxMapSize() + 1, 1L, 1);
        //if (haspreviousvalue)
        if (entity.isAlreadyExist()) {
            this.cacheMap.put(entity.getKey(), this.expectedResult);
        }
        for (int i = 0; i < entity.getNumObjectToInsert(); i++) {
            this.cacheMap.put(new Object(), new Object());
        }

        if (entity.isPinned()) {
            this.cacheMap.pin(entity.getKey());
        }

        //this.cacheMap = spy(this.cacheMap);

    }

    @Test
    public void putTest() {
        Object result = this.cacheMap.put(entity.getKey(), entity.getValue());
        System.out.println(result+"\n");
        //verify(this.cacheMap).writeLock();
        //verify(this.cacheMap).writeUnlock();
        
        Assert.assertEquals(this.expectedResult, result);
        
//        if (entity.isAlreadyExist() && entity.getCacheMaxMapSize() != 0) {
//            Assert.assertEquals(this.expectedResult, result);
//        } else {
//            Assert.assertNull(result);
//        }

        //testa la get a sto punto
        
//        Object getValue = this.cacheMap.get(entity.getKey());
//
//        Assert.assertEquals(entity.getValue(), getValue);


    }

}

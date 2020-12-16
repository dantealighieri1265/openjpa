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

import java.util.Arrays;
import java.util.Collection;


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
	
	  private CacheMap cacheMap;
	  private Object expectedResult;
      private CacheMapEntity entity;
	  private Object expectedSize;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    public PutCacheMapTest(CacheMapEntity entity, Object expectedResult, int expectedSize) { 
    	this.entity = entity;
    	this.expectedResult = expectedResult;
    	this.expectedSize = expectedSize;
    }


    @Parameterized.Parameters
    public static Collection<?> getParameters(){
    	
    	/*CATEGORY PARTITION:
    	 * 
    	 * Key --> {valid, NonValid, null}
    	 * Object --> {valid, nonValid, null}
    	 * 
    	 * L'oggetto nonValid non può essere considerato per via del fatto che 
    	 * entrambi i paramentri sono classi di tipo Object.
    	 * 
    	 * put(valid, valid)
    	 * put(null, null)
    	 * put(null, valid)
    	 * put(valid, null)
    	 * 
    	 * */
    	
    	/*MUTATION TESTING:
    	 * 
    	 * -Line 393: mutation equivalent (NO Weak mutation, Strong mutation)  --> Forse è anche weak 
    	 * perché oltre al fattop che il metodo salta ad un altro metodo vuoyo lo stato non cambia
    	 * -Line 395: mutation equivalent (NO Weak mutation, Strong mutation)-->(Entry removed not implemented??)
    	 * -Line 396: mutation equivalent (NO Weak mutation, Strong mutation)-->(Entry added and entry removed nont implemented??)
    	 * 
    	 * -Line 410: mutation equivalent (NO Weak mutation, Strong mutation)
    	 * -Line 411: mutation equivalent (NO Weak mutation, Strong mutation)-->(Entry added not implemented??)
		 * -Line 413: mutation equivalent (NO Weak mutation, Strong mutation)-->(Entry removed not implemented??)
    	 * -Line 414: mutation equivalent (NO Weak mutation, Strong mutation)-->(Entry added not implemented??)
    	 * -Line 417: mutation equivalent (NO Weak mutation, Strong mutation)-->(Entry removed not implemented??)
    	 * -Line 418: mutation equivalent (NO Weak mutation, Strong mutation)-->(Entry added not implemented??)
    	 * 
    	 * -Line 422: mutation survived & No coverage --> No tests that exercised the line of code 422: Mi sembra strano però essendo 
    	 * la riga 422 dento un finally
    	 * */
    	
    	Object objValue = new Object();

    	
    	
    	 return Arrays.asList(new Object[][] {
    		 //suite minimale
    		 {new CacheMapEntity(null, null, false, false, 0, 1), null, 0},
    		 {new CacheMapEntity(new Object(), null, true, true, 1, 0), null, 1},
    		 {new CacheMapEntity(null, objValue, true, false, 1, 1), objValue, 2},
    		 {new CacheMapEntity(new Object(), objValue, true, true, 1, 1), objValue, 2},
    		 
    		 //coverage
    		 {new CacheMapEntity(new Object(), objValue, true, false, 2,0),objValue,1},
    		 {new CacheMapEntity(new Object(), objValue, false, false, 1,0), null,1},
         });
        

    }

    @Before
    public void setUp(){
        this.cacheMap = new CacheMap(true, entity.getCacheMaxMapSize(), entity.getCacheMaxMapSize() + 1, 1L, 1);
        if (entity.isAlreadyExist()) {
            this.cacheMap.put(entity.getKey(), this.entity.getValue());
        }
        for (int i = 0; i < entity.getNumObjectToInsert(); i++) {
            this.cacheMap.put(new Object(), new Object());
        }

        if (entity.isPinned()) {
            this.cacheMap.pin(entity.getKey());
        }

        this.cacheMap = spy(this.cacheMap);

    }

    @Test
    public void putTest() {
        Object result = this.cacheMap.put(entity.getKey(), entity.getValue());
        

        Assert.assertEquals(this.expectedResult, result);
        
        //for mutation
        Assert.assertEquals(this.expectedSize, this.cacheMap.size());
        
        if (this.entity.getCacheMaxMapSize() != 0)
        	verify(this.cacheMap).entryAdded(entity.getKey(), entity.getValue()); 
       
        //TODO gestire entryadded ed entry removed
        if (this.entity.isAlreadyExist() && this.entity.getValue()!= null)
        	verify(this.cacheMap).entryRemoved(entity.getKey(), entity.getValue(), false);

        verify(this.cacheMap).writeLock();
        verify(this.cacheMap).writeUnlock();


    }

}

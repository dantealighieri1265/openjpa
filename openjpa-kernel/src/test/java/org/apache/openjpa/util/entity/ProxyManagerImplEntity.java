package org.apache.openjpa.util.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.openjpa.util.support.Valid;
import org.apache.openjpa.util.support.FinalClass;
import org.apache.openjpa.util.support.NonValid;


public class ProxyManagerImplEntity {
	
	private Object object;
	private boolean autoOff;
    private String unproxyable;
	
	public ProxyManagerImplEntity() {
		// Nothing to do
	}
	
	public ProxyManagerImplEntity(boolean b) {
		this.autoOff = b;
	}
	

	public ProxyManagerImplEntity initializeEntityNull(Object object2) {
		setObject(object2);
		return this;
	}
	
	
	public ProxyManagerImplEntity initializeEntityNonValid(int nextInt, int nextInt2) {
		
        NonValid nonValid = new NonValid(nextInt, nextInt2);
        setObject(nonValid);
        return this;
    }

	public ProxyManagerImplEntity initializeEntityValid(int nextInt, boolean proxyable) {
		Valid valid = new Valid();
		valid.setValue(nextInt);
		if (!proxyable) {
			setUnproxyable(Valid.class.getName());
		}
		setObject(valid);
		return this;
	}
	public ProxyManagerImplEntity initializeEntityMap(int nextInt, int nextInt2, boolean sortedMap) {
		Map<Integer, Integer> map;
		if (sortedMap){
			map = new TreeMap<>();
		}else {
			map = new HashMap<>();
		}
		map.put(nextInt, nextInt2);
        setObject(map);
        return this;
	}
	public ProxyManagerImplEntity initializeEntityDate(Object object2) {
        this.object = object2;
        return this;
    }
	public ProxyManagerImplEntity initializeEntityGregorian(Object object2) {
        this.object = object2;
        return this;
    }
	public ProxyManagerImplEntity initializeEntityProxyDate(Object object2) {
        this.object = object2;
        return this;
    }
	public ProxyManagerImplEntity initializeEntityList(int nextInt) {
		List<Integer> list = new ArrayList<>();

        list.add(nextInt);
        setObject(list);
        return this;
	}
	
	public ProxyManagerImplEntity initializeEntityArray(float nextInt) {
		Float[] list = new Float[]{nextInt}; //immutable
        setObject(list);
        return this;
	}

	public ProxyManagerImplEntity initializeEntityFinal() {
		FinalClass finalClass = new FinalClass();
		setObject(finalClass);
		return this;
	}

	public Object initializeSortedSet(int nextInt) {
		Set<Integer> sortedSet = new TreeSet<>(); //1 tra set e list forse ridondante
        sortedSet.add(nextInt);
        setObject(sortedSet);
		return this;
	}

	public ProxyManagerImplEntity initializeEntityTimestamp(Timestamp timestamp) {
		setObject(timestamp);
		return this;
	}
	
	
	public Object getObject() {
        return object;
    }

	public void setObject(Object object) {
		this.object = object;
	}

	public String getUnproxyable() {
		return unproxyable;
	}

	public void setUnproxyable(String unproxyable) {
		this.unproxyable = unproxyable;
	}

	public boolean isAutoOff() {
		return autoOff;
	}

	public void setAutoOff(boolean autoOff) {
		this.autoOff = autoOff;
	}



}

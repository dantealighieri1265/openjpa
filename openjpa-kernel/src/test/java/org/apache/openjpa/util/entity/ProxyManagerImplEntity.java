package org.apache.openjpa.util.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.openjpa.util.support.BeanClass;
import org.apache.openjpa.util.support.NonBeanClass;

public class ProxyManagerImplEntity {
	
	private Object object;
	private boolean autoOff;
    private String unproxyable;
	
	public ProxyManagerImplEntity() {
		// TODO Nothing to do
	}

    /*public ProxyManagerImplEntity(Object object) {
        this.object = object;
    }
    
    

    public ProxyManagerImplEntity(int n1) {
		BeanClass beanClass = new BeanClass();
		beanClass.setValue(n1);
		setObject(beanClass);
	}

	public ProxyManagerImplEntity(int n1, int n2, int n3, int n4) {
		Map<Integer, Integer> map = new HashMap<>();
        map.put(n1, n2);
        map.put(n3, n4);
        setObject(map);
	}

	

	public ProxyManagerImplEntity(int n1, int n2, int n3 ) {
		List<Integer> list = new ArrayList<>();

        list.add(n1);
        list.add(n2);
        list.add(n3);
        setObject(list);
	}
	
	public ProxyManagerImplEntity(float n1) {
		Float[] list = new Float[]{n1}; //immutable
        
        setObject(list);
	}*/
	

	public ProxyManagerImplEntity initializeEntityNull(Object object2) {
		setObject(object2);
		return this;
	}
	public ProxyManagerImplEntity initializeEntityNonBean(int n1, int n2) {
        NonBeanClass nonBeanClass = new NonBeanClass(n1, n2);
        setObject(nonBeanClass);
        return this;
    }
	public ProxyManagerImplEntity initializeEntityBean(int n1) {
		BeanClass beanClass = new BeanClass();
		beanClass.setValue(n1);
		setObject(beanClass);
		return this;
	}
	public ProxyManagerImplEntity initializeEntityMap(int n1, int n2, int n3, int n4) {
		Map<Integer, Integer> map = new HashMap<>();
        map.put(n1, n2);
        map.put(n3, n4);
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
	public ProxyManagerImplEntity initializeEntityList(int n1, int n2, int n3 ) {
		List<Integer> list = new ArrayList<>();

        list.add(n1);
        list.add(n2);
        list.add(n3);
        setObject(list);
        return this;
	}
	public ProxyManagerImplEntity initializeEntityArray(float n1) {
		Float[] list = new Float[]{n1}; //immutable
        setObject(list);
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

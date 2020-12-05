package org.apache.openjpa.util.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.openjpa.util.support.BeanClass;
import org.apache.openjpa.util.support.NonBeanClass;

public class ProxyManagerImplEntity {
	
	private Object object;

    public ProxyManagerImplEntity(Object object) {
        this.object = object;
    }
    
    public ProxyManagerImplEntity(int n1, int n2) {
        NonBeanClass nonBeanClass = new NonBeanClass(n1, n2);
        setObject(nonBeanClass);
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

	public ProxyManagerImplEntity() {
		// TODO Auto-generated constructor stub
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
	}

	public Object getObject() {
        return object;
    }

	public void setObject(Object object) {
		this.object = object;
	}

}

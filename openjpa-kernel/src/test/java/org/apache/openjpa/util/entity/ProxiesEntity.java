package org.apache.openjpa.util.entity;

import java.io.IOException;
import java.io.ObjectOutput;
import java.util.BitSet;

import org.apache.openjpa.enhance.PersistenceCapable;
import org.apache.openjpa.enhance.StateManager;
import org.apache.openjpa.kernel.BrokerImpl;
import org.apache.openjpa.kernel.DetachedStateManager;
import org.apache.openjpa.kernel.DetachedValueStateManager;
import org.apache.openjpa.kernel.FetchConfiguration;
import org.apache.openjpa.kernel.OpenJPAStateManager;
import org.apache.openjpa.kernel.PCState;
import org.apache.openjpa.kernel.StateManagerImpl;
import org.apache.openjpa.kernel.StoreContext;
import org.apache.openjpa.meta.ClassMetaData;
import org.apache.openjpa.util.DelayedArrayListProxy;

public class ProxiesEntity {
	
	private Object object;
	private boolean detachable;
	
	public ProxiesEntity() {
		// TODO Auto-generated constructor stub
	}

	public ProxiesEntity(boolean b) {
		this.setDetachable(b);
	}

	public ProxiesEntity(DelayedArrayListProxy delayedArrayListProxy, boolean b) {
		this.object = delayedArrayListProxy;
		this.detachable = b;
	}

	public ProxiesEntity initializeValidProxy(int i) {
		DelayedArrayListProxy delayedArrayListProxy = new DelayedArrayListProxy(i);
		setObject(delayedArrayListProxy);
		return this;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public boolean isDetachable() {
		return detachable;
	}

	public void setDetachable(boolean detachable) {
		this.detachable = detachable;
	}

	public ProxiesEntity initializeNullProxy() {
		setObject(null);
		return this;
	}

	public ProxiesEntity initializeSetOwnerEntity(int i) {
		DelayedArrayListProxy delayedArrayListProxy = new DelayedArrayListProxy(i);
		delayedArrayListProxy.setOwner( new DetachedValueStateManager(new Object(), new BrokerImpl()), i);
		setObject(delayedArrayListProxy);
		return this;
	}

}

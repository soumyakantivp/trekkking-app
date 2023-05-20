package com.trek.easy.service;

import java.util.List;

public interface ServiceCRUD<K,V> {
	public void add(K obj);
	public void update(K obj);
	public V delete(V id);
	public K get(V id);
	public List<K> getAll();
}

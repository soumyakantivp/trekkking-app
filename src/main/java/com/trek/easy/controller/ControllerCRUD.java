package com.trek.easy.controller;

import java.util.List;

public interface ControllerCRUD<K, V> {
	public int add(K obj);
	public int update(K obj);
	public int delete(V id);
	public K getById(V id);
	public List<K> getAll();
}

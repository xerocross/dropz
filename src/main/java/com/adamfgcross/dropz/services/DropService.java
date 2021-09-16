package com.adamfgcross.dropz.services;

import com.adamfgcross.dropz.entities.Drop;

import java.util.List;

public interface DropService {
    public void saveDrop(Drop drop);

    public void saveDrop(String dropText, String username);

    public List<Drop> getDrops(String dropText, String username);

    public List<Drop> queryDrops(String query, String username);
}

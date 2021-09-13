package com.adamfgcross.dropz.services;

import com.adamfgcross.dropz.entities.Drop;

public interface DropService {
    public void saveDrop(Drop drop);

    public void saveDrop(String dropText, String username);
}

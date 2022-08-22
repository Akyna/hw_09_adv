package com.amboiko;

import java.util.concurrent.CopyOnWriteArrayList;

public class Provider {
    // public volatile List<Record> list = new ArrayList<>();

    // public volatile List<Record> list = Collections.synchronizedList(new ArrayList<>());

    public volatile CopyOnWriteArrayList<Record> list = new CopyOnWriteArrayList<>();

    // public volatile Queue<Record> list = new ConcurrentLinkedQueue<>();


}

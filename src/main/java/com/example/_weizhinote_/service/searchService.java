package com.example._weizhinote_.service;

import java.util.List;

public interface searchService {
    List<Integer> searchByTag(String tagname,String userId);
}

package com.blue.service.impl;


import com.blue.mapper.TypeMapper;
import com.blue.po.Type;
import com.blue.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kuls
 * @Desc kuls
 * @date 2020/5/5 7:20 下午
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public int save(Type type) {
        return typeMapper.save(type);
    }

    @Override
    public Type getType(Long id) {
        return typeMapper.getType(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public List<Type> listType() {
        List<Type> list = typeMapper.listType();
        return list;
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public int deleteType(Long id) {
        return typeMapper.deleteType(id);
    }

    @Override
    public List<Type> getAllTypeAndBlog() {
        return typeMapper.getAllTypeAndBlog();
    }
}

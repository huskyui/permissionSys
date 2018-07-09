package com.husky.persys.modalur.sys.service;

import java.util.Map;

public interface ShiroService {
    //从数据库中获取资源权限生产map对象
    public Map<String,String> loadFilterChainDefinitionMap();
    //更新系统权限
    void updatePermissions();
}

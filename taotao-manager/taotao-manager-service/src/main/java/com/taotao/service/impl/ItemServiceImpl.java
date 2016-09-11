package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 商品管理service
 * Created by wanghongxiang on 16/9/9.
 */

@Service

public class ItemServiceImpl implements ItemService {


    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long itemId) {

        //直接通过主键查询

//        TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);

        TbItemExample tbItemExample = new TbItemExample();

        //添加查询条件
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdEqualTo(itemId);

        List<TbItem> tbItemList = itemMapper.selectByExample(tbItemExample);

        if(tbItemList != null && tbItemList.size() > 0){
            TbItem tbItem = tbItemList.get(0);
            return tbItem;
        }
        return null;
    }
}

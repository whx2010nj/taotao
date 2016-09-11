package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by wanghongxiang on 16/9/11.
 */
public class PageHelperTest {


    @Test
    public void test(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);

        TbItemExample tbItemExample = new TbItemExample();

        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(1,10);
        List<TbItem> tbItems = mapper.selectByExample(tbItemExample);

        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
        long total = pageInfo.getTotal();

        System.out.println("total:" + total);
        System.out.print("rows:" + tbItems);
        for(TbItem tbItem:tbItems){
            System.out.println(tbItem);
        }



    }
}

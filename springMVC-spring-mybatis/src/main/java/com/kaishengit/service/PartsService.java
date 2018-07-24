package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Parts;
import com.kaishengit.entity.Type;

import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/7/23
 */
public interface PartsService {
    /**
     * 根据id查询对应的配件对象
     * @param id
     * @return
     */
    Parts findById(Integer id);

    /**
     * 根据页码获得对应的数据集合
     * @param pageNo 页码 1，2，3
     * @return pageInfo对象
     */
    PageInfo<Parts> findPage(Integer pageNo);

    /**
     *  查询所有的配件类型列表
     * @return
     */
    List<Type> findTypeList();

    /**
     * 根据页码和筛选条件map集合查询对应的配件列表
     * @param pageNo 页码
     * @param queryMap 筛选条件map
     * @return
     */
    PageInfo<Parts> findPageByPageNoAndQueryMap(Integer pageNo, Map<String,Object> queryMap);

    /**
     * 配件入库
     * @param parts
     */
    void saveParts(Parts parts);

    /**
     * 删除配件
     * @param id
     */
    void delPartsById(Integer id);

    void partsEdit(Parts parts);
}

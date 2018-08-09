package com.kaishengit.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.erp.entity.Parts;
import com.kaishengit.erp.entity.PartsExample;
import com.kaishengit.erp.entity.Type;
import com.kaishengit.erp.entity.TypeExample;
import com.kaishengit.erp.service.PartsService;
import com.kaishengit.erp.mapper.PartsMapper;
import com.kaishengit.erp.mapper.TypeMapper;
import com.kaishengit.erp.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/7/23
 */
@Service
public class PartsServiceImpl implements PartsService {

    Logger logger = LoggerFactory.getLogger(PartsServiceImpl.class);

    @Autowired
    private PartsMapper partsMapper;

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 根据id查询对应的配件对象
     *
     * @param id
     * @return
     */
    @Override
    public Parts findById(Integer id) {
        return partsMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据页码获得对应的数据集合
     *
     * @param pageNo 页码 1，2，3
     * @return pageInfo对象
     */
    @Override
    public PageInfo<Parts> findPage(Integer pageNo) {
        // 分页
        PageHelper.startPage(pageNo,Constant.DEFAULT_PAGE_SIZE);

       /* PartsExample partsExample = new PartsExample();
        // 排序
        partsExample.setOrderByClause("id asc");*/
        List<Parts> partsList = partsMapper.findPageWithType();

        // 封装分页对象
        PageInfo<Parts> pageInfo = new PageInfo<>(partsList);
        return pageInfo;
    }

    /**
     * 查询所有的配件类型列表
     *
     * @return
     */
    @Override
    public List<Type> findTypeList() {
        TypeExample typeExample = new TypeExample();
        return typeMapper.selectByExample(typeExample);
    }

    /**
     * 根据页码和筛选条件map集合查询对应的配件列表
     *
     * @param pageNo   页码
     * @param queryMap 筛选条件map
     * @return
     */
    @Override
    public PageInfo<Parts> findPageByPageNoAndQueryMap(Integer pageNo, Map<String, Object> queryMap) {
        PageHelper.startPage(pageNo,Constant.DEFAULT_PAGE_SIZE);

        List<Parts> partsList = partsMapper.findPageWithTypeByQueryMap(queryMap);

        PageInfo<Parts> pageInfo = new PageInfo<>(partsList);
        return pageInfo;
    }

    /**
     * 配件入库
     *
     * @param parts
     */
    @Override
    public void saveParts(Parts parts) {
        partsMapper.insertSelective(parts);
        // TODO 增加配件入库流水业务 如果该配件存在则修改库存数量
        logger.debug("新增的配件：{}", parts);
    }

    /**
     * 删除配件
     *
     * @param id
     */
    @Override
    public void delPartsById(Integer id) {
        Parts parts = partsMapper.selectByPrimaryKey(id);
        if(parts != null) {
            partsMapper.deleteByPrimaryKey(id);
        }
        logger.debug("删除配件：{}", parts);
    }

    @Override
    public void partsEdit(Parts parts) {
        partsMapper.updateByPrimaryKeySelective(parts);
        logger.debug("更新配件：{}", parts);
    }

    /**
     * 根据id查找配件列表
     *
     * @param id
     * @return
     */
    @Override
    public List<Parts> findPartsByType(Integer id) {
        PartsExample partsExample = new PartsExample();
        // 查找库存量大于0
        partsExample.createCriteria().andTypeIdEqualTo(id)
            .andInventoryGreaterThan(0);
        return partsMapper.selectByExample(partsExample);
    }

    /**
     * 根据订单号查询对应的配件列表
     *
     * @param orderId
     * @return
     */
    @Override
    public List<Parts> findPartsByOrderId(Integer orderId) {
        List<Parts> partsList = partsMapper.findByOrderId(orderId);
        return partsList;
    }


}

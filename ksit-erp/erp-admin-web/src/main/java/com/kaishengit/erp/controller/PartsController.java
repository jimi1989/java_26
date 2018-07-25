package com.kaishengit.erp.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.erp.entity.Parts;
import com.kaishengit.erp.entity.Type;
import com.kaishengit.erp.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/7/23
 */
@Controller
@RequestMapping("/parts")
public class PartsController {

    @Autowired
    private PartsService partsService;

    @GetMapping("/{id:\\d+}/edit")
    public String partsEdit(@PathVariable Integer id, Model model) {
        Parts parts = partsService.findById(id);
        // 封装typeList
        List<Type> typeList = partsService.findTypeList();
        model.addAttribute("typeList", typeList);
        model.addAttribute("parts", parts);
        return "parts/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String partsEdit(Parts parts, RedirectAttributes redirectAttributes) {
        partsService.partsEdit(parts);
        redirectAttributes.addFlashAttribute("message", "更新成功");
        return "redirect:/parts";
    }


    @GetMapping("/{id:\\d+}/del")
    public String partsDel(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        partsService.delPartsById(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/parts";
    }


    @GetMapping("/new")
    public String partsNew(Model model) {
        // 封装typeList
        List<Type> typeList = partsService.findTypeList();
        model.addAttribute("typeList", typeList);
        return "parts/new";
    }

    @PostMapping("/new")
    public String partsNew(Parts parts, RedirectAttributes redirectAttributes) {
        partsService.saveParts(parts);
        redirectAttributes.addFlashAttribute("message", "入库成功");
        return "redirect:/parts";
    }

    @GetMapping
    public String list(@RequestParam(name = "p",defaultValue = "1",required = false) Integer pageNo,
                       @RequestParam(required = false) String partsName,
                       @RequestParam(required = false) Integer partsType,
                       Model model){
        // 封装筛选的queryMap集合
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("partsName", partsName);
        queryMap.put("partsType", partsType);

        PageInfo<Parts> page = partsService.findPageByPageNoAndQueryMap(pageNo, queryMap);
        // 封装typeList
        List<Type> typeList = partsService.findTypeList();

        model.addAttribute("page", page);
        model.addAttribute("typeList", typeList);
        return "parts/list";
    }

    @GetMapping("/{id:\\d+}")
    public String findById(@PathVariable Integer id, Model model) throws IOException {

        Parts parts = partsService.findById(id);

        if(parts == null) {
            // 抛出异常
            throw new IOException();
        } else {
            model.addAttribute("parts", parts);
            return "parts/detail";
        }
    }



}

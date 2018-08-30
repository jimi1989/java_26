package com.kaishengit.tms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.kaishengit.tms.controller.exception.NotFoundException;
import com.kaishengit.tms.entity.StoreAccount;
import com.kaishengit.tms.entity.TicketStore;
import com.kaishengit.tms.fileStore.QiniuStore;
import com.kaishengit.tms.service.TicketStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/ticketstore")
public class TicketStoreController {

    @Reference(version = "1.0")
    private TicketStoreService ticketStoreService;
    @Autowired
    private QiniuStore qiniuStore;

    @GetMapping
    public String home(Model model,
                       @RequestParam(name = "p",required = false,defaultValue = "1") Integer pageNo,
                       @RequestParam(required = false,defaultValue = "") String storeName,
                       @RequestParam(required = false,defaultValue = "") String storeManager,
                       @RequestParam(required = false,defaultValue = "") String storeTel) {
        Map<String,Object> queryParam = Maps.newHashMap();
        queryParam.put("storeName",storeName);
        queryParam.put("storeManager",storeManager);
        queryParam.put("storeTel",storeTel);

        PageInfo<TicketStore> pageInfo = ticketStoreService.findAllTicketStoreByPage(pageNo,queryParam);
        model.addAttribute("pageInfo",pageInfo);
        return "store/home";
    }

    /**
     * 新增售票点
     * @return
     */
    @GetMapping("/new")
    public String newStore(Model model) {
        //获取七牛文件上传token
        String upToken = qiniuStore.getUploadToken();
        model.addAttribute("upToken",upToken);
        return "store/new";
    }

    @PostMapping("/new")
    public String newStore(TicketStore ticketStore, RedirectAttributes redirectAttributes) {
        ticketStoreService.saveNewTicktStore(ticketStore);
        redirectAttributes.addFlashAttribute("message","新增成功");
        return "redirect:/ticketstore";
    }

    /**
     * 查看售票点详情
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}")
    public String viewTicketStore(@PathVariable Integer id,Model model) {
        TicketStore ticketStore = ticketStoreService.findTicketStoreById(id);

        if(ticketStore == null) {
            throw new NotFoundException();
        }
        //查找关联的售票点账号
        StoreAccount storeAccount = ticketStoreService.findStoreAccountById(ticketStore.getId());

        model.addAttribute("storeAccount",storeAccount);
        model.addAttribute("ticketStore",ticketStore);
        return "store/info";
    }

    /**
     * 编辑售票点
     * @return
     *
     */
    @GetMapping("/{id:\\d+}/edit")
    public String editTicketStore(@PathVariable Integer id,Model model) {
        TicketStore ticketStore = ticketStoreService.findTicketStoreById(id);
        if(ticketStore == null) {
            throw new NotFoundException();
        }

        //获取七牛上传的Token
        String uploadToken = qiniuStore.getUploadToken();

        model.addAttribute("uploadToken",uploadToken);
        model.addAttribute("ticketStore",ticketStore);
        return "store/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String updateTicketStore(TicketStore ticketStore,RedirectAttributes redirectAttributes) {
        ticketStoreService.updateTicketStore(ticketStore);
        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/ticketstore";
    }
}

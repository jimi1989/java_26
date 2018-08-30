package com.kaishengit.tms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.dto.ResponseBean;
import com.kaishengit.tms.entity.TicketInRecord;
import com.kaishengit.tms.entity.TicketOutRecord;
import com.kaishengit.tms.entity.TicketStore;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.TicketService;
import com.kaishengit.tms.service.TicketStoreService;
import com.kaishengit.tms.shiro.ShiroUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Reference(version = "1.0")
    private TicketService ticketService;
    @Reference(version = "1.0")
    private TicketStoreService ticketStoreService;


    /**
     * 年票入库首页
     * @return
     */
    @GetMapping("/storage")
    public String ticketIn(Model model,
                           @RequestParam(required = false,defaultValue = "1",name = "p") Integer pageNo ) {
        PageInfo<TicketInRecord> pageInfo = ticketService.findTicketRecordByPageNo(pageNo);

        model.addAttribute("pageInfo",pageInfo);
        return "ticket/storage/home";
    }

    /**
     * 新增入库
     * @return
     */
    @GetMapping("/storage/new")
    public String newTicketStorage(Model model) {
        String today = DateTime.now().toString("YYYY-MM-dd");

        model.addAttribute("today",today);
        return "ticket/storage/new";
    }
    @PostMapping("/storage/new")
    public String newTicketStorage(TicketInRecord ticketInRecord,
                                   RedirectAttributes redirectAttributes,
                                   Model model) {
        try {
            ticketService.saveTicketInRecord(ticketInRecord, new ShiroUtil().getCurrentAccount());

            redirectAttributes.addFlashAttribute("message", "新增成功");
        } catch (ServiceException ex) {
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
            ex.printStackTrace();
        }
        return "redirect:/ticket/storage";
    }

    /**
     * 删除年票入库记录
     */
    @GetMapping("/storage/{id:\\d+}/del")
    public String delInRecord(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        try {
            ticketService.delInRecordById(id);
            redirectAttributes.addFlashAttribute("message","删除成功");
        } catch (ServiceException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
        }
        return "redirect:/ticket/storage";
    }

    /**
     * 年票统计首页
     * @return
     */
    @GetMapping("/chart")
    public String chartHome(Model model) {
        Map<String,Long> resultMap = ticketService.countTicketByState();
        model.addAttribute("resultMap",resultMap);
        return "ticket/chart/home";
    }

    /**
     * 年票下发首页
     * @return
     */
    @GetMapping("/out")
    public String ticketOutHome(Model model,
                               @RequestParam(name = "p",required = false,defaultValue = "1") Integer pageNo) {
        PageInfo<TicketOutRecord> pageInfo = ticketService.findTicketOutRecordByPageNo(pageNo);

        model.addAttribute("page",pageInfo);
        return "ticket/out/home";
    }

    /**
     * 新增年票下发
     * @return
     */
    @GetMapping("/out/new")
    public String newTicketOut(Model model) {
        String today = DateTime.now().toString("YYYY-MM-dd");
        //查找所有的售票点
        List<TicketStore> ticketStoreList = ticketStoreService.findAllTicketStore();

        model.addAttribute("today",today);
        model.addAttribute("ticketStoreList",ticketStoreList);
        return "ticket/out/new";
    }

    @PostMapping("/out/new")
    public String newTicketOut(TicketOutRecord ticketOutRecord, RedirectAttributes redirectAttributes) {
        try {
            ticketService.saveTicketOutRecord(ticketOutRecord, new ShiroUtil().getCurrentAccount());
        } catch (ServiceException ex) {
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
        }
        return "redirect:/ticket/out";
    }

    /**
     * 删除下发单
     * @param id
     * @return
     */
    @GetMapping("/out/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean delTicketOut(@PathVariable Integer id) {
        ticketService.delOutRecordById(id);
        return ResponseBean.success();
    }
}

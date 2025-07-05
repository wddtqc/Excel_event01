package com.example.controller;

import com.example.entity.WageRecord;
import com.example.entity.WageRecordDTO;
import com.example.service.WageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/wage")
public class WageRecordController {
    @Autowired
    private WageRecordService wageRecordService;
//111
    @PostMapping("/add")
    public boolean add(@RequestBody @Valid WageRecordDTO dto) {
        try {
            WageRecord record = new WageRecord();
            record.setProjectStreet(dto.getProjectStreet());
            record.setProjectName(dto.getProjectName());
            record.setProjectStartTime(dto.getProjectStartTime());
            record.setProjectEndTime(dto.getProjectEndTime());
            record.setName(dto.getName());
            record.setIdCard(dto.getIdCard());
            record.setPhone(dto.getPhone());
            record.setCompany(dto.getCompany());
            record.setJobType(dto.getJobType());
            record.setWorkArea(dto.getWorkArea());
            record.setEntryDate(dto.getEntryDate() != null && !dto.getEntryDate().isEmpty() ? java.sql.Date.valueOf(dto.getEntryDate()) : null);
            record.setBaseSalary(dto.getBaseSalary() != null && !dto.getBaseSalary().isEmpty() ? new java.math.BigDecimal(dto.getBaseSalary()) : null);
            record.setPayStatus(dto.getPayStatus());
            record.setSocialSecurity(dto.getSocialSecurity());
            record.setRemark(dto.getRemark());
            record.setMonth(dto.getMonth());
            System.out.println("record = " + record);
            return wageRecordService.save(record);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/update")
    public boolean update(@RequestBody @Valid WageRecordDTO dto) {
        try {
            WageRecord record = new WageRecord();
            record.setId(dto.getId());
            record.setProjectStreet(dto.getProjectStreet());
            record.setProjectName(dto.getProjectName());
            record.setProjectStartTime(dto.getProjectStartTime());
            record.setProjectEndTime(dto.getProjectEndTime());
            record.setName(dto.getName());
            record.setIdCard(dto.getIdCard());
            record.setPhone(dto.getPhone());
            record.setCompany(dto.getCompany());
            record.setJobType(dto.getJobType());
            record.setWorkArea(dto.getWorkArea());
            record.setEntryDate(dto.getEntryDate() != null && !dto.getEntryDate().isEmpty() ? java.sql.Date.valueOf(dto.getEntryDate()) : null);
            record.setBaseSalary(dto.getBaseSalary() != null && !dto.getBaseSalary().isEmpty() ? new java.math.BigDecimal(dto.getBaseSalary()) : null);
            record.setPayStatus(dto.getPayStatus());
            record.setSocialSecurity(dto.getSocialSecurity());
            record.setRemark(dto.getRemark());
            record.setMonth(dto.getMonth());
            System.out.println("record = " + record);
            return wageRecordService.updateById(record);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return wageRecordService.removeById(id);
    }

    @GetMapping("/list")
    public com.baomidou.mybatisplus.core.metadata.IPage<WageRecord> list(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String idCard,
        @RequestParam(required = false) String month,
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<WageRecord> query = new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<>();
        if (name != null && !name.isEmpty()) query.like("name", name);
        if (idCard != null && !idCard.isEmpty()) query.eq("id_card", idCard);
        if (month != null && !month.isEmpty()) query.eq("month", month);
        return wageRecordService.page(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(page, size), query);
    }

    @GetMapping("/{id}")
    public WageRecord get(@PathVariable Long id) {
        return wageRecordService.getById(id);
    }

    @GetMapping("/workersByMonth")
    public Map<String, Object> getWorkersByMonth(
            @RequestParam String month,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        List<WageRecord> allRecords = wageRecordService.list();
        List<Map<String, Object>> workerRows = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for (WageRecord record : allRecords) {
            if (record.getMonth() != null && new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(record.getMonth()).equals(month)) {
                Map<String, Object> row = new HashMap<>();
                row.put("name", record.getName());
                row.put("idCard", record.getIdCard());
                row.put("month", record.getMonth());
                row.put("entryDate", record.getEntryDate());
                row.put("jobType", record.getJobType());
                row.put("workArea", record.getWorkArea());
                row.put("baseSalary", record.getBaseSalary());
                row.put("socialSecurity", record.getSocialSecurity());
                row.put("company", record.getCompany());
                row.put("remark", record.getRemark());
                row.put("projectName", record.getProjectName());
                row.put("createTime", record.getCreateTime());
                workerRows.add(row);
            }
        }

        int total = workerRows.size();
        int fromIndex = (page - 1) * size;
        int toIndex = Math.min(fromIndex + size, total);
        List<Map<String, Object>> pageList = fromIndex < total ? workerRows.subList(fromIndex, toIndex) : new ArrayList<>();

        Map<String, Object> result = new HashMap<>();
        result.put("records", pageList);
        result.put("total", total);
        return result;
    }
}

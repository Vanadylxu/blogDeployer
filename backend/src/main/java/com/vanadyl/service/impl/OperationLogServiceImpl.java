package com.vanadyl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vanadyl.entity.OperationLog;
import com.vanadyl.exception.PersistenceException;
import com.vanadyl.mapper.OperationLogMapper;
import com.vanadyl.service.OperationLogService;
import com.vanadyl.util.IPUtils;
import com.vanadyl.util.UserAgentUtils;

import java.util.List;
import java.util.Map;

/**
 * @Description: 操作日志业务层实现
 * @Author: Naccl
 * @Date: 2020-11-30
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    OperationLogMapper operationLogMapper;
    @Autowired
    UserAgentUtils userAgentUtils;

    @Override
    public List<OperationLog> getOperationLogListByDate(String startDate, String endDate) {
        return operationLogMapper.getOperationLogListByDate(startDate, endDate);
    }

    @Transactional
    @Override
    public void saveOperationLog(OperationLog log) {
        String ipSource = IPUtils.getCityInfo(log.getIp());
        Map<String, String> userAgentMap = userAgentUtils.parseOsAndBrowser(log.getUserAgent());
        String os = userAgentMap.get("os");
        String browser = userAgentMap.get("browser");
        log.setIpSource(ipSource);
        log.setOs(os);
        log.setBrowser(browser);
        if (operationLogMapper.saveOperationLog(log) != 1) {
            throw new PersistenceException("日志添加失败");
        }
    }

    @Transactional
    @Override
    public void deleteOperationLogById(Long id) {
        if (operationLogMapper.deleteOperationLogById(id) != 1) {
            throw new PersistenceException("删除日志失败");
        }
    }
}

package cn.skyln.web.service.impl;

import cn.skyln.web.model.DO.TrafficDO;
import cn.skyln.web.mapper.TrafficMapper;
import cn.skyln.web.service.TrafficService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author skylamella
 * @since 2022-11-26
 */
@Service
@Slf4j
public class TrafficServiceImpl extends ServiceImpl<TrafficMapper, TrafficDO> implements TrafficService {
}

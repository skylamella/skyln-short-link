package cn.skyln.web.service.impl;

import cn.skyln.web.model.DO.AccountDO;
import cn.skyln.web.mapper.AccountMapper;
import cn.skyln.web.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author skylamella
 * @since 2022-11-26
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountDO> implements AccountService {

}

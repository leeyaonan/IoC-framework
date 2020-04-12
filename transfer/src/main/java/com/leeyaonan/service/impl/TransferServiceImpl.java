package com.leeyaonan.service.impl;

import com.leeyaonan.dao.AccountDao;
import com.leeyaonan.dao.impl.JdbcAccountDaoImpl;
import com.leeyaonan.pojo.Account;
import com.leeyaonan.service.TransferService;

/**
 * @Author Leeyaonan
 * @Date 2020/4/12 12:09
 */
public class TransferServiceImpl implements TransferService {

    private AccountDao accountDao = new JdbcAccountDaoImpl();

    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {
        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney() - money);
        to.setMoney(to.getMoney() + money);

        accountDao.updateAccountByCardNo(from);
        accountDao.updateAccountByCardNo(to);
    }
}

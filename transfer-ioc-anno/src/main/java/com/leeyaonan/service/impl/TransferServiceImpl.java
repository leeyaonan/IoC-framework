package com.leeyaonan.service.impl;

import com.leeyaonan.dao.AccountDao;
import com.leeyaonan.dao.impl.JdbcAccountDaoImpl;
import com.leeyaonan.pojo.Account;
import com.leeyaonan.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Leeyaonan
 * @Date 2020/4/12 12:09
 */
@Service("transferService")
public class TransferServiceImpl implements TransferService {

    // 最佳状态
    @Autowired
    private AccountDao accountDao;

    // 构造函数传值/set方法传值

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }



    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

        /*try{
            // 开启事务(关闭事务的自动提交)
            TransactionManager.getInstance().beginTransaction();*/

        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney()-money);
        to.setMoney(to.getMoney()+money);

        accountDao.updateAccountByCardNo(to);
//        int c = 1/0;
        accountDao.updateAccountByCardNo(from);

        /*    // 提交事务

            TransactionManager.getInstance().commit();
        }catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            TransactionManager.getInstance().rollback();

            // 抛出异常便于上层servlet捕获
            throw e;

        }*/




    }
}

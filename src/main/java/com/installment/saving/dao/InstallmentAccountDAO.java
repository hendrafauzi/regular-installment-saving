package com.installment.saving.dao;

import com.installment.saving.mapper.InstallmentAccountMapper;
import com.installment.saving.model.InstallmentAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class InstallmentAccountDAO extends JdbcDaoSupport {

    @Autowired
    public InstallmentAccountDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public int save(int tenor, double firstDeposit, double monthlyDeposit, String purpose)
    {
        String sql = "INSERT INTO saving_account (tenor, first_deposit, monthly_deposit, purpose) values (?,?,?,?)";

        try {
            return this.getJdbcTemplate().update(sql,tenor,firstDeposit,monthlyDeposit,purpose);
        }
        catch (Exception ex)
        {
            throw null;
        }
    }

    public List<InstallmentAccount> getInstallmentAccounts() {
        return this.getJdbcTemplate()
                .query(InstallmentAccountMapper.BASE_QUERY,
                        new Object[]{},
                        new InstallmentAccountMapper());

    }

    public InstallmentAccount findById(int id) {
        String query = InstallmentAccountMapper.BASE_QUERY.concat(" where sa.id = ? ");
        return this.getJdbcTemplate()
                .queryForObject(query,
                        new Object[]{id},
                        new InstallmentAccountMapper());
    }
}

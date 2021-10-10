package com.installment.saving.mapper;

import com.installment.saving.model.InstallmentAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InstallmentAccountMapper implements RowMapper<InstallmentAccount> {
    public static final String BASE_QUERY = "Select sa.id, sa.tenor, sa.first_deposit, sa.monthly_deposit, sa.purpose from saving_account sa ";

    @Override
    public InstallmentAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        int tenor = rs.getInt("tenor");
        double firstDeposit = rs.getDouble("first_deposit");
        double monthlyDeposit = rs.getDouble("monthly_deposit");
        String purpose = rs.getString("purpose");

        return new InstallmentAccount(id, tenor, firstDeposit, monthlyDeposit, purpose);
    }
}

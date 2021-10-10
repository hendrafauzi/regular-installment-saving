package com.installment.saving.controller;

import com.installment.saving.dao.InstallmentAccountDAO;
import com.installment.saving.model.InstallmentAccount;
import com.installment.saving.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/installment")
public class InstallmentSavingController {

    @Autowired
    private InstallmentAccountDAO installmentAccountDAO;

    //Get all data from Saving Account
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAllData() {
        Response resp = new Response();
        List<InstallmentAccount> installmentAccountList = installmentAccountDAO.getInstallmentAccounts();

        resp.setData(installmentAccountList);
        resp.setStatus(HttpStatus.OK.toString());
        resp.setMessage("Success");

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    //Calculate a Saving Account
    @PostMapping(value = "/inquiry", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> calculateSavingAcc(@RequestBody InstallmentAccount installmentAccount) {
        Response resp = new Response();
        System.out.println("tenor: " + installmentAccount.getTenor());
        System.out.println("obj: " + installmentAccount.toString());
        //final balance = (((saving tenor/12) * 6%) * grand total deposit amount) + grand total deposit amount
        double grandTotalDeposit = installmentAccount.getFirst_deposit() + ((double) (installmentAccount.getTenor()-1) * installmentAccount.getMonthly_deposit());
        double finalBalance = ((((double) installmentAccount.getTenor()/12) * (6/100)) * (grandTotalDeposit)) + grandTotalDeposit;

        resp.setData(finalBalance);
        resp.setStatus(HttpStatus.OK.toString());
        resp.setMessage("Success");

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    //Save data into saving account table
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createInstallment(@RequestBody InstallmentAccount insAcc) {
        Response resp = new Response();
        int saveData = installmentAccountDAO.save(insAcc.getTenor(), insAcc.getFirst_deposit(),
                insAcc.getMonthly_deposit(), insAcc.getPurpose());

        System.out.println(saveData);

        resp.setData(new Object());
        resp.setStatus(HttpStatus.OK.toString());
        resp.setMessage("Success");

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getDataById(@PathVariable int id) {
        Response resp = new Response();
        InstallmentAccount installmentAccount = installmentAccountDAO.findById(id);

        resp.setData(installmentAccount);
        resp.setStatus(HttpStatus.OK.toString());
        resp.setMessage("Success");

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
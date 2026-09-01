package com.example;

import com.accountingapisdk.AccountingApiSdk;
import com.accountingapisdk.exceptions.ApiError;

public class Main {

  public static void main(String[] args) {
    AccountingApiSdk accountingApiSdk = new AccountingApiSdk();

    try {
      Object response = accountingApiSdk.accountingApiSdk.getHealth();

      System.out.println(response);
    } catch (ApiError e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}

# AccountingApiSdkService

A list of all methods in the `AccountingApiSdkService` service. Click on the method name to view detailed information about that method.

| Methods                                       | Description                          |
| :-------------------------------------------- | :----------------------------------- |
| [getHealth](#gethealth)                       | Basic service health check.          |
| [createCustomer](#createcustomer)             | Create a customer.                   |
| [listCustomers](#listcustomers)               | List customers.                      |
| [recordInvoicePayment](#recordinvoicepayment) | Record a payment against an invoice. |
| [getInvoiceById](#getinvoicebyid)             | Get a single invoice by ID.          |
| [createInvoice](#createinvoice)               | Create an invoice.                   |
| [listInvoices](#listinvoices)                 | List invoices.                       |
| [listPayments](#listpayments)                 | List recorded payments.              |

## getHealth

Basic service health check.

- HTTP Method: `GET`
- Endpoint: `/health`

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.accountingapisdk.AccountingApiSdk;

public class Main {

  public static void main(String[] args) {
    AccountingApiSdk accountingApiSdk = new AccountingApiSdk();

    Object response = accountingApiSdk.accountingApiSdk.getHealth();

    System.out.println(response);
  }
}

```

## createCustomer

Create a customer.

- HTTP Method: `POST`
- Endpoint: `/customers`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| createCustomerRequest | [CreateCustomerRequest](../models/CreateCustomerRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.accountingapisdk.AccountingApiSdk;
import com.accountingapisdk.models.CreateCustomerRequest;

public class Main {

  public static void main(String[] args) {
    AccountingApiSdk accountingApiSdk = new AccountingApiSdk();

    CreateCustomerRequest createCustomerRequest = CreateCustomerRequest.builder()
      .name("Acme Bakery")
      .email("owner@acmebakery.test")
      .build();

    Object response = accountingApiSdk.accountingApiSdk.createCustomer(createCustomerRequest);

    System.out.println(response);
  }
}

```

## listCustomers

List customers.

- HTTP Method: `GET`
- Endpoint: `/customers`

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.accountingapisdk.AccountingApiSdk;

public class Main {

  public static void main(String[] args) {
    AccountingApiSdk accountingApiSdk = new AccountingApiSdk();

    Object response = accountingApiSdk.accountingApiSdk.listCustomers();

    System.out.println(response);
  }
}

```

## recordInvoicePayment

Record a payment against an invoice.

- HTTP Method: `POST`
- Endpoint: `/invoices/{invoiceId}/payments`

**Parameters**

| Name                        | Type                                                                    | Required | Description  |
| :-------------------------- | :---------------------------------------------------------------------- | :------- | :----------- |
| invoiceId                   | String                                                                  | ✅       |              |
| recordInvoicePaymentRequest | [RecordInvoicePaymentRequest](../models/RecordInvoicePaymentRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.accountingapisdk.AccountingApiSdk;
import com.accountingapisdk.models.RecordInvoicePaymentRequest;

public class Main {

  public static void main(String[] args) {
    AccountingApiSdk accountingApiSdk = new AccountingApiSdk();

    RecordInvoicePaymentRequest recordInvoicePaymentRequest = RecordInvoicePaymentRequest.builder()
      .amount(500L)
      .paymentDate("2026-01-20")
      .method("bank_transfer")
      .reference("BT-7781")
      .build();

    Object response = accountingApiSdk.accountingApiSdk.recordInvoicePayment(
      "invoiceId",
      recordInvoicePaymentRequest
    );

    System.out.println(response);
  }
}

```

## getInvoiceById

Get a single invoice by ID.

- HTTP Method: `GET`
- Endpoint: `/invoices/{invoiceId}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| invoiceId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.accountingapisdk.AccountingApiSdk;

public class Main {

  public static void main(String[] args) {
    AccountingApiSdk accountingApiSdk = new AccountingApiSdk();

    Object response = accountingApiSdk.accountingApiSdk.getInvoiceById("invoiceId");

    System.out.println(response);
  }
}

```

## createInvoice

Create an invoice.

- HTTP Method: `POST`
- Endpoint: `/invoices`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| createInvoiceRequest | [CreateInvoiceRequest](../models/CreateInvoiceRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.accountingapisdk.AccountingApiSdk;
import com.accountingapisdk.models.CreateInvoiceRequest;
import com.accountingapisdk.models.LineItems;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AccountingApiSdk accountingApiSdk = new AccountingApiSdk();

    LineItems lineItems = LineItems.builder()
      .description("Monthly bookkeeping")
      .quantity(1L)
      .unitPrice(1250L)
      .build();

    List<LineItems> lineItemsList = Arrays.asList(lineItems);

    CreateInvoiceRequest createInvoiceRequest = CreateInvoiceRequest.builder()
      .customerId("cust_001")
      .invoiceDate("2026-01-15")
      .dueDate("2026-01-30")
      .currency("USD")
      .lineItems(lineItemsList)
      .build();

    Object response = accountingApiSdk.accountingApiSdk.createInvoice(createInvoiceRequest);

    System.out.println(response);
  }
}

```

## listInvoices

List invoices.

- HTTP Method: `GET`
- Endpoint: `/invoices`

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.accountingapisdk.AccountingApiSdk;

public class Main {

  public static void main(String[] args) {
    AccountingApiSdk accountingApiSdk = new AccountingApiSdk();

    Object response = accountingApiSdk.accountingApiSdk.listInvoices();

    System.out.println(response);
  }
}

```

## listPayments

List recorded payments.

- HTTP Method: `GET`
- Endpoint: `/payments`

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.accountingapisdk.AccountingApiSdk;

public class Main {

  public static void main(String[] args) {
    AccountingApiSdk accountingApiSdk = new AccountingApiSdk();

    Object response = accountingApiSdk.accountingApiSdk.listPayments();

    System.out.println(response);
  }
}

```

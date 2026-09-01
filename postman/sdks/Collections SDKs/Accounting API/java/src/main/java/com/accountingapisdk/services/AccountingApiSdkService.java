package com.accountingapisdk.services;

import com.accountingapisdk.config.AccountingApiSdkConfig;
import com.accountingapisdk.config.RequestConfig;
import com.accountingapisdk.exceptions.ApiError;
import com.accountingapisdk.http.AccountingApiSdkResponse;
import com.accountingapisdk.http.Environment;
import com.accountingapisdk.http.HttpMethod;
import com.accountingapisdk.http.ModelConverter;
import com.accountingapisdk.http.util.RequestBuilder;
import com.accountingapisdk.models.CreateCustomerRequest;
import com.accountingapisdk.models.CreateInvoiceRequest;
import com.accountingapisdk.models.RecordInvoicePaymentRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * AccountingApiSdkService Service
 */
public class AccountingApiSdkService extends BaseService {

  private RequestConfig getHealthConfig;
  private RequestConfig createCustomerConfig;
  private RequestConfig listCustomersConfig;
  private RequestConfig recordInvoicePaymentConfig;
  private RequestConfig getInvoiceByIdConfig;
  private RequestConfig createInvoiceConfig;
  private RequestConfig listInvoicesConfig;
  private RequestConfig listPaymentsConfig;

  /**
   * Constructs a new instance of AccountingApiSdkService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public AccountingApiSdkService(@NonNull OkHttpClient httpClient, AccountingApiSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getHealth}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public AccountingApiSdkService setGetHealthConfig(RequestConfig config) {
    this.getHealthConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createCustomer}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public AccountingApiSdkService setCreateCustomerConfig(RequestConfig config) {
    this.createCustomerConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listCustomers}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public AccountingApiSdkService setListCustomersConfig(RequestConfig config) {
    this.listCustomersConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code recordInvoicePayment}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public AccountingApiSdkService setRecordInvoicePaymentConfig(RequestConfig config) {
    this.recordInvoicePaymentConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getInvoiceById}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public AccountingApiSdkService setGetInvoiceByIdConfig(RequestConfig config) {
    this.getInvoiceByIdConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createInvoice}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public AccountingApiSdkService setCreateInvoiceConfig(RequestConfig config) {
    this.createInvoiceConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listInvoices}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public AccountingApiSdkService setListInvoicesConfig(RequestConfig config) {
    this.listInvoicesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listPayments}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public AccountingApiSdkService setListPaymentsConfig(RequestConfig config) {
    this.listPaymentsConfig = config;
    return this;
  }

  /**
   * Basic service health check.
   *
   * @return response of {@code Object}
   */
  public Object getHealth() throws ApiError {
    return this.getHealth(null);
  }

  /**
   * Basic service health check.
   *
   * @return response of {@code Object}
   */
  public Object getHealth(RequestConfig requestConfig) throws ApiError {
    return withRawResponse().getHealth(requestConfig).getData();
  }

  /**
   * Basic service health check.
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getHealthAsync() throws ApiError {
    return this.getHealthAsync(null);
  }

  /**
   * Basic service health check.
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getHealthAsync(RequestConfig requestConfig) throws ApiError {
    return withRawResponse()
      .getHealthAsync(requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetHealthRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "health"
    ).build();
  }

  /**
   * Create a customer.
   *
   * @param createCustomerRequest {@link CreateCustomerRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createCustomer(@NonNull CreateCustomerRequest createCustomerRequest)
    throws ApiError {
    return this.createCustomer(createCustomerRequest, null);
  }

  /**
   * Create a customer.
   *
   * @param createCustomerRequest {@link CreateCustomerRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createCustomer(
    @NonNull CreateCustomerRequest createCustomerRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createCustomer(createCustomerRequest, requestConfig).getData();
  }

  /**
   * Create a customer.
   *
   * @param createCustomerRequest {@link CreateCustomerRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createCustomerAsync(
    @NonNull CreateCustomerRequest createCustomerRequest
  ) throws ApiError {
    return this.createCustomerAsync(createCustomerRequest, null);
  }

  /**
   * Create a customer.
   *
   * @param createCustomerRequest {@link CreateCustomerRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createCustomerAsync(
    @NonNull CreateCustomerRequest createCustomerRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createCustomerAsync(createCustomerRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateCustomerRequest(
    @NonNull CreateCustomerRequest createCustomerRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "customers"
    )
      .setJsonContent(createCustomerRequest)
      .build();
  }

  /**
   * List customers.
   *
   * @return response of {@code Object}
   */
  public Object listCustomers() throws ApiError {
    return this.listCustomers(null);
  }

  /**
   * List customers.
   *
   * @return response of {@code Object}
   */
  public Object listCustomers(RequestConfig requestConfig) throws ApiError {
    return withRawResponse().listCustomers(requestConfig).getData();
  }

  /**
   * List customers.
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listCustomersAsync() throws ApiError {
    return this.listCustomersAsync(null);
  }

  /**
   * List customers.
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listCustomersAsync(RequestConfig requestConfig) throws ApiError {
    return withRawResponse()
      .listCustomersAsync(requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListCustomersRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "customers"
    ).build();
  }

  /**
   * Record a payment against an invoice.
   *
   * @param invoiceId String
   * @param recordInvoicePaymentRequest {@link RecordInvoicePaymentRequest} Request Body
   * @return response of {@code Object}
   */
  public Object recordInvoicePayment(
    @NonNull String invoiceId,
    @NonNull RecordInvoicePaymentRequest recordInvoicePaymentRequest
  ) throws ApiError {
    return this.recordInvoicePayment(invoiceId, recordInvoicePaymentRequest, null);
  }

  /**
   * Record a payment against an invoice.
   *
   * @param invoiceId String
   * @param recordInvoicePaymentRequest {@link RecordInvoicePaymentRequest} Request Body
   * @return response of {@code Object}
   */
  public Object recordInvoicePayment(
    @NonNull String invoiceId,
    @NonNull RecordInvoicePaymentRequest recordInvoicePaymentRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .recordInvoicePayment(invoiceId, recordInvoicePaymentRequest, requestConfig)
      .getData();
  }

  /**
   * Record a payment against an invoice.
   *
   * @param invoiceId String
   * @param recordInvoicePaymentRequest {@link RecordInvoicePaymentRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> recordInvoicePaymentAsync(
    @NonNull String invoiceId,
    @NonNull RecordInvoicePaymentRequest recordInvoicePaymentRequest
  ) throws ApiError {
    return this.recordInvoicePaymentAsync(invoiceId, recordInvoicePaymentRequest, null);
  }

  /**
   * Record a payment against an invoice.
   *
   * @param invoiceId String
   * @param recordInvoicePaymentRequest {@link RecordInvoicePaymentRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> recordInvoicePaymentAsync(
    @NonNull String invoiceId,
    @NonNull RecordInvoicePaymentRequest recordInvoicePaymentRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .recordInvoicePaymentAsync(invoiceId, recordInvoicePaymentRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildRecordInvoicePaymentRequest(
    @NonNull String invoiceId,
    @NonNull RecordInvoicePaymentRequest recordInvoicePaymentRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "invoices/{invoiceId}/payments"
    )
      .setPathParameter("invoiceId", invoiceId)
      .setJsonContent(recordInvoicePaymentRequest)
      .build();
  }

  /**
   * Get a single invoice by ID.
   *
   * @param invoiceId String
   * @return response of {@code Object}
   */
  public Object getInvoiceById(@NonNull String invoiceId) throws ApiError {
    return this.getInvoiceById(invoiceId, null);
  }

  /**
   * Get a single invoice by ID.
   *
   * @param invoiceId String
   * @return response of {@code Object}
   */
  public Object getInvoiceById(@NonNull String invoiceId, RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse().getInvoiceById(invoiceId, requestConfig).getData();
  }

  /**
   * Get a single invoice by ID.
   *
   * @param invoiceId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getInvoiceByIdAsync(@NonNull String invoiceId) throws ApiError {
    return this.getInvoiceByIdAsync(invoiceId, null);
  }

  /**
   * Get a single invoice by ID.
   *
   * @param invoiceId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getInvoiceByIdAsync(
    @NonNull String invoiceId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getInvoiceByIdAsync(invoiceId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetInvoiceByIdRequest(
    @NonNull String invoiceId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "invoices/{invoiceId}"
    )
      .setPathParameter("invoiceId", invoiceId)
      .build();
  }

  /**
   * Create an invoice.
   *
   * @param createInvoiceRequest {@link CreateInvoiceRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createInvoice(@NonNull CreateInvoiceRequest createInvoiceRequest) throws ApiError {
    return this.createInvoice(createInvoiceRequest, null);
  }

  /**
   * Create an invoice.
   *
   * @param createInvoiceRequest {@link CreateInvoiceRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createInvoice(
    @NonNull CreateInvoiceRequest createInvoiceRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createInvoice(createInvoiceRequest, requestConfig).getData();
  }

  /**
   * Create an invoice.
   *
   * @param createInvoiceRequest {@link CreateInvoiceRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createInvoiceAsync(
    @NonNull CreateInvoiceRequest createInvoiceRequest
  ) throws ApiError {
    return this.createInvoiceAsync(createInvoiceRequest, null);
  }

  /**
   * Create an invoice.
   *
   * @param createInvoiceRequest {@link CreateInvoiceRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createInvoiceAsync(
    @NonNull CreateInvoiceRequest createInvoiceRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createInvoiceAsync(createInvoiceRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateInvoiceRequest(
    @NonNull CreateInvoiceRequest createInvoiceRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "invoices"
    )
      .setJsonContent(createInvoiceRequest)
      .build();
  }

  /**
   * List invoices.
   *
   * @return response of {@code Object}
   */
  public Object listInvoices() throws ApiError {
    return this.listInvoices(null);
  }

  /**
   * List invoices.
   *
   * @return response of {@code Object}
   */
  public Object listInvoices(RequestConfig requestConfig) throws ApiError {
    return withRawResponse().listInvoices(requestConfig).getData();
  }

  /**
   * List invoices.
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listInvoicesAsync() throws ApiError {
    return this.listInvoicesAsync(null);
  }

  /**
   * List invoices.
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listInvoicesAsync(RequestConfig requestConfig) throws ApiError {
    return withRawResponse()
      .listInvoicesAsync(requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListInvoicesRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "invoices"
    ).build();
  }

  /**
   * List recorded payments.
   *
   * @return response of {@code Object}
   */
  public Object listPayments() throws ApiError {
    return this.listPayments(null);
  }

  /**
   * List recorded payments.
   *
   * @return response of {@code Object}
   */
  public Object listPayments(RequestConfig requestConfig) throws ApiError {
    return withRawResponse().listPayments(requestConfig).getData();
  }

  /**
   * List recorded payments.
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listPaymentsAsync() throws ApiError {
    return this.listPaymentsAsync(null);
  }

  /**
   * List recorded payments.
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listPaymentsAsync(RequestConfig requestConfig) throws ApiError {
    return withRawResponse()
      .listPaymentsAsync(requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListPaymentsRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "payments"
    ).build();
  }

  /**
   * Returns an accessor whose methods mirror this service but return the full HTTP response
   * (status code, headers, and raw body) wrapped alongside the parsed data.
   *
   * @return An accessor exposing raw-response variants of this service's methods
   */
  public WithRawResponse withRawResponse() {
    return new WithRawResponse();
  }

  /**
   * Per-call accessor exposing raw-response variants of {@link AccountingApiSdkService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * Basic service health check.
     *
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> getHealth() throws ApiError {
      return this.getHealth(null);
    }

    /**
     * Basic service health check.
     *
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> getHealth(RequestConfig requestConfig) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getHealthConfig, requestConfig);
      Request request = buildGetHealthRequest(resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new AccountingApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Basic service health check.
     *
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> getHealthAsync() throws ApiError {
      return this.getHealthAsync(null);
    }

    /**
     * Basic service health check.
     *
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> getHealthAsync(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getHealthConfig, requestConfig);
      Request request = buildGetHealthRequest(resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new AccountingApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Create a customer.
     *
     * @param createCustomerRequest {@link CreateCustomerRequest} Request Body
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> createCustomer(
      @NonNull CreateCustomerRequest createCustomerRequest
    ) throws ApiError {
      return this.createCustomer(createCustomerRequest, null);
    }

    /**
     * Create a customer.
     *
     * @param createCustomerRequest {@link CreateCustomerRequest} Request Body
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> createCustomer(
      @NonNull CreateCustomerRequest createCustomerRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createCustomerConfig, requestConfig);
      Request request = buildCreateCustomerRequest(createCustomerRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new AccountingApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Create a customer.
     *
     * @param createCustomerRequest {@link CreateCustomerRequest} Request Body
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> createCustomerAsync(
      @NonNull CreateCustomerRequest createCustomerRequest
    ) throws ApiError {
      return this.createCustomerAsync(createCustomerRequest, null);
    }

    /**
     * Create a customer.
     *
     * @param createCustomerRequest {@link CreateCustomerRequest} Request Body
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> createCustomerAsync(
      @NonNull CreateCustomerRequest createCustomerRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createCustomerConfig, requestConfig);
      Request request = buildCreateCustomerRequest(createCustomerRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new AccountingApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * List customers.
     *
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> listCustomers() throws ApiError {
      return this.listCustomers(null);
    }

    /**
     * List customers.
     *
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> listCustomers(RequestConfig requestConfig)
      throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listCustomersConfig, requestConfig);
      Request request = buildListCustomersRequest(resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new AccountingApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * List customers.
     *
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> listCustomersAsync()
      throws ApiError {
      return this.listCustomersAsync(null);
    }

    /**
     * List customers.
     *
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> listCustomersAsync(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listCustomersConfig, requestConfig);
      Request request = buildListCustomersRequest(resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new AccountingApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Record a payment against an invoice.
     *
     * @param invoiceId String
     * @param recordInvoicePaymentRequest {@link RecordInvoicePaymentRequest} Request Body
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> recordInvoicePayment(
      @NonNull String invoiceId,
      @NonNull RecordInvoicePaymentRequest recordInvoicePaymentRequest
    ) throws ApiError {
      return this.recordInvoicePayment(invoiceId, recordInvoicePaymentRequest, null);
    }

    /**
     * Record a payment against an invoice.
     *
     * @param invoiceId String
     * @param recordInvoicePaymentRequest {@link RecordInvoicePaymentRequest} Request Body
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> recordInvoicePayment(
      @NonNull String invoiceId,
      @NonNull RecordInvoicePaymentRequest recordInvoicePaymentRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(recordInvoicePaymentConfig, requestConfig);
      Request request = buildRecordInvoicePaymentRequest(
        invoiceId,
        recordInvoicePaymentRequest,
        resolvedConfig
      );
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new AccountingApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Record a payment against an invoice.
     *
     * @param invoiceId String
     * @param recordInvoicePaymentRequest {@link RecordInvoicePaymentRequest} Request Body
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> recordInvoicePaymentAsync(
      @NonNull String invoiceId,
      @NonNull RecordInvoicePaymentRequest recordInvoicePaymentRequest
    ) throws ApiError {
      return this.recordInvoicePaymentAsync(invoiceId, recordInvoicePaymentRequest, null);
    }

    /**
     * Record a payment against an invoice.
     *
     * @param invoiceId String
     * @param recordInvoicePaymentRequest {@link RecordInvoicePaymentRequest} Request Body
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> recordInvoicePaymentAsync(
      @NonNull String invoiceId,
      @NonNull RecordInvoicePaymentRequest recordInvoicePaymentRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(recordInvoicePaymentConfig, requestConfig);
      Request request = buildRecordInvoicePaymentRequest(
        invoiceId,
        recordInvoicePaymentRequest,
        resolvedConfig
      );
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new AccountingApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Get a single invoice by ID.
     *
     * @param invoiceId String
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> getInvoiceById(@NonNull String invoiceId)
      throws ApiError {
      return this.getInvoiceById(invoiceId, null);
    }

    /**
     * Get a single invoice by ID.
     *
     * @param invoiceId String
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> getInvoiceById(
      @NonNull String invoiceId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getInvoiceByIdConfig, requestConfig);
      Request request = buildGetInvoiceByIdRequest(invoiceId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new AccountingApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Get a single invoice by ID.
     *
     * @param invoiceId String
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> getInvoiceByIdAsync(
      @NonNull String invoiceId
    ) throws ApiError {
      return this.getInvoiceByIdAsync(invoiceId, null);
    }

    /**
     * Get a single invoice by ID.
     *
     * @param invoiceId String
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> getInvoiceByIdAsync(
      @NonNull String invoiceId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getInvoiceByIdConfig, requestConfig);
      Request request = buildGetInvoiceByIdRequest(invoiceId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new AccountingApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Create an invoice.
     *
     * @param createInvoiceRequest {@link CreateInvoiceRequest} Request Body
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> createInvoice(
      @NonNull CreateInvoiceRequest createInvoiceRequest
    ) throws ApiError {
      return this.createInvoice(createInvoiceRequest, null);
    }

    /**
     * Create an invoice.
     *
     * @param createInvoiceRequest {@link CreateInvoiceRequest} Request Body
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> createInvoice(
      @NonNull CreateInvoiceRequest createInvoiceRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createInvoiceConfig, requestConfig);
      Request request = buildCreateInvoiceRequest(createInvoiceRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new AccountingApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Create an invoice.
     *
     * @param createInvoiceRequest {@link CreateInvoiceRequest} Request Body
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> createInvoiceAsync(
      @NonNull CreateInvoiceRequest createInvoiceRequest
    ) throws ApiError {
      return this.createInvoiceAsync(createInvoiceRequest, null);
    }

    /**
     * Create an invoice.
     *
     * @param createInvoiceRequest {@link CreateInvoiceRequest} Request Body
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> createInvoiceAsync(
      @NonNull CreateInvoiceRequest createInvoiceRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createInvoiceConfig, requestConfig);
      Request request = buildCreateInvoiceRequest(createInvoiceRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new AccountingApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * List invoices.
     *
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> listInvoices() throws ApiError {
      return this.listInvoices(null);
    }

    /**
     * List invoices.
     *
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> listInvoices(RequestConfig requestConfig)
      throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listInvoicesConfig, requestConfig);
      Request request = buildListInvoicesRequest(resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new AccountingApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * List invoices.
     *
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> listInvoicesAsync() throws ApiError {
      return this.listInvoicesAsync(null);
    }

    /**
     * List invoices.
     *
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> listInvoicesAsync(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listInvoicesConfig, requestConfig);
      Request request = buildListInvoicesRequest(resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new AccountingApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * List recorded payments.
     *
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> listPayments() throws ApiError {
      return this.listPayments(null);
    }

    /**
     * List recorded payments.
     *
     * @return response of {@code AccountingApiSdkResponse<Object>}
     */
    public AccountingApiSdkResponse<Object> listPayments(RequestConfig requestConfig)
      throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listPaymentsConfig, requestConfig);
      Request request = buildListPaymentsRequest(resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new AccountingApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * List recorded payments.
     *
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> listPaymentsAsync() throws ApiError {
      return this.listPaymentsAsync(null);
    }

    /**
     * List recorded payments.
     *
     * @return response of {@code CompletableFuture<AccountingApiSdkResponse<Object>>}
     */
    public CompletableFuture<AccountingApiSdkResponse<Object>> listPaymentsAsync(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listPaymentsConfig, requestConfig);
      Request request = buildListPaymentsRequest(resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new AccountingApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }
  }
}

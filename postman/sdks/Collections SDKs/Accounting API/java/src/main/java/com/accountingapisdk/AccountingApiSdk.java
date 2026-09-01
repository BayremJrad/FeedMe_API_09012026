package com.accountingapisdk;

import com.accountingapisdk.config.AccountingApiSdkConfig;
import com.accountingapisdk.http.Environment;
import com.accountingapisdk.http.interceptors.DefaultHeadersInterceptor;
import com.accountingapisdk.http.interceptors.LoggingInterceptor;
import com.accountingapisdk.http.interceptors.RetryInterceptor;
import com.accountingapisdk.logging.Logger;
import com.accountingapisdk.services.AccountingApiSdkService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/**
 * Minimal HTTP API surface for a basic accounting application. Intentionally small and practical.
 */
public class AccountingApiSdk {

  public final AccountingApiSdkService accountingApiSdk;

  private final AccountingApiSdkConfig config;

  /**
   * Constructs a new instance of AccountingApiSdk with default configuration.
   */
  public AccountingApiSdk() {
    // Default configs
    this(AccountingApiSdkConfig.builder().build());
  }

  /**
   * Constructs a new instance of AccountingApiSdk with custom configuration.
   * Initializes all services, HTTP client, and optional OAuth token manager.
   *
   * @param config The SDK configuration including base URL, authentication, timeout, and retry settings
   */
  public AccountingApiSdk(AccountingApiSdkConfig config) {
    this.config = config;

    // A user-supplied client is augmented (not replaced): the SDK derives its client from
    // the injected instance so its transport settings and interceptors are preserved, then
    // layers the SDK's own interceptors on top.
    final OkHttpClient customHttpClient = config.getHttpClient();
    final OkHttpClient.Builder httpClientBuilder =
      (customHttpClient != null
          ? customHttpClient.newBuilder()
          : new OkHttpClient.Builder()).addInterceptor(new DefaultHeadersInterceptor(config))
        .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
        // Logging is added last so it observes the fully-decorated request (auth headers
        // included, then redacted). Silent by default — see LogConfig.
        .addInterceptor(new LoggingInterceptor(Logger.from(config.getLogConfig())));

    // Only apply the SDK's default read timeout when building the client ourselves; a
    // user-supplied client owns its own transport (timeout) settings.
    if (customHttpClient == null) {
      httpClientBuilder.readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS);
    }

    final OkHttpClient httpClient = httpClientBuilder.build();

    this.accountingApiSdk = new AccountingApiSdkService(httpClient, config);
  }

  /**
   * Sets the environment for all API requests.
   *
   * @param environment The environment to use (e.g., DEFAULT, PRODUCTION, STAGING)
   */
  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  /**
   * Sets the base URL for all API requests.
   *
   * @param baseUrl The base URL to use for API requests
   */
  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c

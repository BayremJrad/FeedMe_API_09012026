package com.accountingapisdk.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateInvoiceRequest {

  @JsonProperty("customerId")
  private JsonNullable<String> customerId;

  @JsonProperty("invoiceDate")
  private JsonNullable<String> invoiceDate;

  @JsonProperty("dueDate")
  private JsonNullable<String> dueDate;

  @JsonProperty("currency")
  private JsonNullable<String> currency;

  @JsonProperty("lineItems")
  private JsonNullable<List<LineItems>> lineItems;

  // FSM-59: capture unknown JSON fields so they round-trip on re-serialize.
  // @Builder.Default keeps the empty-map default in the Lombok-generated builder; without it the
  // builder would leave the map null and the any-setter would NPE on the first unknown field.
  // Deserialization is wired via the builder's @JsonAnySetter (see the Builder below), NOT here:
  // Lombok @Jacksonized deserializes through the builder and does not copy a field-level
  // @JsonAnySetter across, so unknown fields would be silently dropped if it lived on this field.
  @Builder.Default
  private Map<String, Object> additionalProperties = new HashMap<>();

  // @JsonAnyGetter must sit on the getter (not the field) so Jackson inlines the unknown entries on
  // serialize. On the field it double-registers with the Lombok getter and leaks a literal
  // "additionalProperties" property into every request body and object parameter.
  // Declaring the getter here also stops Lombok @Data from generating its own.
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @JsonIgnore
  public String getCustomerId() {
    return customerId.orElse(null);
  }

  @JsonIgnore
  public String getInvoiceDate() {
    return invoiceDate.orElse(null);
  }

  @JsonIgnore
  public String getDueDate() {
    return dueDate.orElse(null);
  }

  @JsonIgnore
  public String getCurrency() {
    return currency.orElse(null);
  }

  @JsonIgnore
  public List<LineItems> getLineItems() {
    return lineItems.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreateInvoiceRequestBuilder {

    private JsonNullable<String> customerId = JsonNullable.undefined();

    @JsonProperty("customerId")
    public CreateInvoiceRequestBuilder customerId(String value) {
      this.customerId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> invoiceDate = JsonNullable.undefined();

    @JsonProperty("invoiceDate")
    public CreateInvoiceRequestBuilder invoiceDate(String value) {
      this.invoiceDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> dueDate = JsonNullable.undefined();

    @JsonProperty("dueDate")
    public CreateInvoiceRequestBuilder dueDate(String value) {
      this.dueDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> currency = JsonNullable.undefined();

    @JsonProperty("currency")
    public CreateInvoiceRequestBuilder currency(String value) {
      this.currency = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<LineItems>> lineItems = JsonNullable.undefined();

    @JsonProperty("lineItems")
    public CreateInvoiceRequestBuilder lineItems(List<LineItems> value) {
      this.lineItems = JsonNullable.of(value);
      return this;
    }

    @JsonAnySetter
    public CreateInvoiceRequestBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }
  }
}

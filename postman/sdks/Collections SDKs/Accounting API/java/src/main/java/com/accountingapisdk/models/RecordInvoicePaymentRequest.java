package com.accountingapisdk.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
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
public class RecordInvoicePaymentRequest {

  @JsonProperty("amount")
  private JsonNullable<Long> amount;

  @JsonProperty("paymentDate")
  private JsonNullable<String> paymentDate;

  @JsonProperty("method")
  private JsonNullable<String> method;

  @JsonProperty("reference")
  private JsonNullable<String> reference;

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
  public Long getAmount() {
    return amount.orElse(null);
  }

  @JsonIgnore
  public String getPaymentDate() {
    return paymentDate.orElse(null);
  }

  @JsonIgnore
  public String getMethod() {
    return method.orElse(null);
  }

  @JsonIgnore
  public String getReference() {
    return reference.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class RecordInvoicePaymentRequestBuilder {

    private JsonNullable<Long> amount = JsonNullable.undefined();

    @JsonProperty("amount")
    public RecordInvoicePaymentRequestBuilder amount(Long value) {
      this.amount = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> paymentDate = JsonNullable.undefined();

    @JsonProperty("paymentDate")
    public RecordInvoicePaymentRequestBuilder paymentDate(String value) {
      this.paymentDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> method = JsonNullable.undefined();

    @JsonProperty("method")
    public RecordInvoicePaymentRequestBuilder method(String value) {
      this.method = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> reference = JsonNullable.undefined();

    @JsonProperty("reference")
    public RecordInvoicePaymentRequestBuilder reference(String value) {
      this.reference = JsonNullable.of(value);
      return this;
    }

    @JsonAnySetter
    public RecordInvoicePaymentRequestBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }
  }
}

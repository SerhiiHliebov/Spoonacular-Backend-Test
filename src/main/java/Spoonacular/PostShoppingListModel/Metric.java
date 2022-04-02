package Spoonacular.PostShoppingListModel;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "amount",
        "unit"
})
public class Metric {

    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("unit")
    private String unit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Metric withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Metric withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Metric withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}

package Spoonacular.PostShoppingListModel;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "aisles",
        "id",
        "name",
        "measures",
        "usages",
        "usageRecipeIds",
        "pantryItem",
        "aisle",
        "cost",
        "ingredientId",
        "startDate",
        "endDate"
})
@ToString
public class Item {

    @JsonProperty("aisles")
    private List<Aisle> aisles = null;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("measures")
    private Measures measures;
    @JsonProperty("usages")
    private List<Object> usages = null;
    @JsonProperty("usageRecipeIds")
    private List<Object> usageRecipeIds = null;
    @JsonProperty("pantryItem")
    private Boolean pantryItem;
    @JsonProperty("aisle")
    private String aisle;
    @JsonProperty("cost")
    private Double cost;
    @JsonProperty("ingredientId")
    private Integer ingredientId;
    @JsonProperty("startDate")
    private Integer startDate;
    @JsonProperty("endDate")
    private Integer endDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("aisles")
    public List<Aisle> getAisles() {
        return aisles;
    }

    @JsonProperty("aisles")
    public void setAisles(List<Aisle> aisles) {
        this.aisles = aisles;
    }

    public Item withAisles(List<Aisle> aisles) {
        this.aisles = aisles;
        return this;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    public Item withId(Long id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Item withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("measures")
    public Measures getMeasures() {
        return measures;
    }

    @JsonProperty("measures")
    public void setMeasures(Measures measures) {
        this.measures = measures;
    }

    public Item withMeasures(Measures measures) {
        this.measures = measures;
        return this;
    }

    @JsonProperty("usages")
    public List<Object> getUsages() {
        return usages;
    }

    @JsonProperty("usages")
    public void setUsages(List<Object> usages) {
        this.usages = usages;
    }

    public Item withUsages(List<Object> usages) {
        this.usages = usages;
        return this;
    }

    @JsonProperty("usageRecipeIds")
    public List<Object> getUsageRecipeIds() {
        return usageRecipeIds;
    }

    @JsonProperty("usageRecipeIds")
    public void setUsageRecipeIds(List<Object> usageRecipeIds) {
        this.usageRecipeIds = usageRecipeIds;
    }

    public Item withUsageRecipeIds(List<Object> usageRecipeIds) {
        this.usageRecipeIds = usageRecipeIds;
        return this;
    }

    @JsonProperty("pantryItem")
    public Boolean getPantryItem() {
        return pantryItem;
    }

    @JsonProperty("pantryItem")
    public void setPantryItem(Boolean pantryItem) {
        this.pantryItem = pantryItem;
    }

    public Item withPantryItem(Boolean pantryItem) {
        this.pantryItem = pantryItem;
        return this;
    }

    @JsonProperty("aisle")
    public String getAisle() {
        return aisle;
    }

    @JsonProperty("aisle")
    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public Item withAisle(String aisle) {
        this.aisle = aisle;
        return this;
    }

    @JsonProperty("cost")
    public Double getCost() {
        return cost;
    }

    @JsonProperty("cost")
    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Item withCost(Double cost) {
        this.cost = cost;
        return this;
    }

    @JsonProperty("ingredientId")
    public Integer getIngredientId() {
        return ingredientId;
    }

    @JsonProperty("ingredientId")
    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Item withIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
        return this;
    }

    @JsonProperty("startDate")
    public Integer getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Item withStartDate(Integer startDate) {
        this.startDate = startDate;
        return this;
    }

    @JsonProperty("endDate")
    public Integer getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public Item withEndDate(Integer endDate) {
        this.endDate = endDate;
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

    public Item withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}

package abramov.instagram.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramData {
    @JsonProperty("string_list_data")
    private List stringListData;

    InstagramData() {
    }

    public InstagramData(List<ValueData> stringListData) {
        this.stringListData = stringListData;
    }

    public List<ValueData> getStringListData() {
        return stringListData;
    }

    public void setStringListData(List<ValueData> stringListData) {
        this.stringListData = stringListData;
    }
}
package abramov.instagram.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueData {
    private String value;
    private String href;

    public ValueData() {
    }

    public ValueData(String value) {
        this.value = value;
        this.href = "https://www.instagram.com/" + value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        this.href = "https://www.instagram.com/" + value;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}

